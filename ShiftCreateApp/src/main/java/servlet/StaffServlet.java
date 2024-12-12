package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.BasicSettingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JobType;
import model.ShiftType;
import model.Staff;
public class StaffServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DBから業務の種類とシフトの種類を取得
        List<JobType> jobTypes = BasicSettingDAO.getJobTypes();  // DBHelperで業務の種類を取得
        List<ShiftType> shiftTypes = BasicSettingDAO.getShiftTypes();  // DBHelperでシフトの種類を取得
        
        // 取得したデータをリクエスト属性として設定
        request.setAttribute("jobTypes", jobTypes);
        request.setAttribute("shiftTypes", shiftTypes);
        
        // スタッフ登録フォームを表示
        request.getRequestDispatcher("/staffForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffName = request.getParameter("staffName");
        int weeklyWorkDays = Integer.parseInt(request.getParameter("weeklyWorkDays"));
        int shiftTypeId = Integer.parseInt(request.getParameter("shiftType"));
        String[] jobTypeIds = request.getParameterValues("jobTypes");

        // JavaBeanを使用してスタッフ情報を格納
        Staff staff = new Staff();
        staff.setStaffName(staffName);
        staff.setWeeklyWorkDays(weeklyWorkDays);
        staff.setShiftTypeId(shiftTypeId);

        // 複数選択された業務の種類をリストに追加
        if (jobTypeIds != null) {
            List<Integer> jobTypes = new ArrayList<>();
            for (String jobTypeIdStr : jobTypeIds) {
                jobTypes.add(Integer.parseInt(jobTypeIdStr));
            }
            staff.setJobTypes(jobTypes);
        }

        // スタッフ情報をDBに登録
        BasicSettingDAO.addStaff(staff);

        // 登録後、基本設定画面にリダイレクト
        response.sendRedirect("basicSetting.jsp");
    }
}
