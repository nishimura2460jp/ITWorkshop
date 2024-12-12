package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SetHolidayServlet")
public class SetHolidayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        // 希望休の情報をセット（ここではコンソールに出力）
        System.out.println("希望休: " + year + "年 " + month + "月 " + day + "日");

        // 希望休の情報をセッションに保存することも可能
        HttpSession session = request.getSession();
        session.setAttribute("holiday", year + "年 " + month + "月 " + day + "日");

        // 画面に戻す
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CalendarServlet");  // CalendarServlet へフォワード
        dispatcher.forward(request, response);
    }
}