package servlet;

import java.io.IOException;

import dao.BasicSettingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SetHolidayServlet")
public class SetHolidayServlet extends HttpServlet {

    // 休暇情報をDBに挿入する処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションからログイン中のユーザーNAMEを取得
        String userName = (String) request.getSession().getAttribute("userName");  // ログイン中のユーザーNAMEをセッションから取得
        
        if (userName == null) {
            // userNameが取得できない場合はエラーメッセージを表示
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ログイン情報がありません。");
            return;
        }
        
        // useraccountsのNAMEからstaff_idを取得
        int staffId = BasicSettingDAO.getStaffIdByUserName(userName); 
        
        if (staffId == -1) {
            // staff_idが取得できなかった場合、エラーメッセージを表示
            request.setAttribute("errorMessage", "無効なスタッフIDです。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        // フォームから送られてきた休暇情報を取得
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String holidayType = request.getParameter("holidayType");  // 休暇の種類（午前休、午後休、全休）

        try {
            // 数値かどうかをチェック
            int yearInt = Integer.parseInt(year);  // 年
            int monthInt = Integer.parseInt(month);  // 月
            int dayInt = Integer.parseInt(day);  // 日

            // 休暇情報をデータベースに保存
            BasicSettingDAO.addHoliday(staffId, yearInt, monthInt, dayInt, holidayType);

            // 保存した履歴をリクエストに渡して表示ページに転送
            request.setAttribute("holidayHistory", BasicSettingDAO.getHolidayHistory(staffId)); // DBから履歴を取得する場合
            request.getRequestDispatcher("/WEB-INF/jsp/holidaySet.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // 数値に変換できない場合、エラーメッセージを返す
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "無効な日付形式が送信されました");
            return;  // 処理を中止し、エラーレスポンスを返す
        }
    }
}