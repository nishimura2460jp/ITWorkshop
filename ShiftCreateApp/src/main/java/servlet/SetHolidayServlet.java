package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dao.BasicSettingDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SetHolidayServlet")
public class SetHolidayServlet extends HttpServlet {
	  // 休暇履歴を保存するためのMap（データベースを使う場合は、この部分を変更）
    private static Map<String, String> holidayHistory = new HashMap<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String holidayType = request.getParameter("holidayType");  // 休暇の種類（午前休、午後休、全休）

        // セッションからスタッフIDを取得（スタッフIDはログイン時に保存されていると仮定）
        HttpSession session = request.getSession();
        Integer staffId = (Integer) session.getAttribute("staffId");

        if (staffId != null) {
            // 希望休の情報をデータベースに保存
            BasicSettingDAO.addHoliday(staffId, Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), holidayType);

            // 休暇の情報を確認用にコンソールに出力
            System.out.println("希望休: " + year + "年 " + month + "月 " + day + "日 " + holidayType);

            // 画面に戻す
            RequestDispatcher dispatcher = request.getRequestDispatcher("/CalendarServlet");
            dispatcher.forward(request, response);
        } else {
            // スタッフIDがセッションにない場合はエラーメッセージを表示
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "スタッフIDが取得できませんでした");
        }
    }
}