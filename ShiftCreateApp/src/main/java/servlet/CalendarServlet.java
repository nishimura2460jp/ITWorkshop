package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("CalendarServlet - doGet() is called");
    	// 現在の日付を基に年と月を決定
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int currentMonth = now.get(Calendar.MONTH) + 1; // 月は0ベースなので+1

        // リクエストパラメータから年と月を取得（デフォルトは現在の年と月）
        int year = currentYear;
        int month = currentMonth;

        if (request.getParameter("year") != null) {
            year = Integer.parseInt(request.getParameter("year"));
        }
        if (request.getParameter("month") != null) {
            month = Integer.parseInt(request.getParameter("month"));
        }

        // 前月と翌月を計算
        Calendar cal = new GregorianCalendar(year, month - 1, 1);
        cal.add(Calendar.MONTH, -1); // 前月
        int prevMonth = cal.get(Calendar.MONTH) + 1;
        int prevYear = cal.get(Calendar.YEAR);

        cal.add(Calendar.MONTH, 2); // 翌月
        int nextMonth = cal.get(Calendar.MONTH) + 1;
        int nextYear = cal.get(Calendar.YEAR);

        // 月のカレンダーを作成
        cal.set(year, month - 1, 1);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 週の開始曜日を取得（0:日曜日、1:月曜日）
        int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // カレンダーを2次元リストとして作成
        List<List<String>> calendar = new ArrayList<>();
        List<String> week = new ArrayList<>(Collections.nCopies(7, ""));
        
        // 最初の週の空白部分を埋める
        for (int i = 1; i < startDayOfWeek; i++) {
            week.set(i - 1, "");
        }

        // 日付をカレンダーに追加
        for (int i = 1; i <= daysInMonth; i++) {
            int dayOfWeek = (startDayOfWeek - 1 + i - 1) % 7;
            week.set(dayOfWeek, String.valueOf(i));
            if (dayOfWeek == 6 || i == daysInMonth) {
                calendar.add(new ArrayList<>(week));
                week = new ArrayList<>(Collections.nCopies(7, ""));
            }
        }

        // デバッグ用ログ
        System.out.println("calendar: " + calendar); // ここでcalendarの内容を確認
        System.out.println("calendar size: " + calendar.size()); // ここでcalendarのサイズを確認

        // カレンダー情報をJSPに渡す
        request.setAttribute("calendar", calendar);
        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("prevYear", prevYear);
        request.setAttribute("prevMonth", prevMonth);
        request.setAttribute("nextYear", nextYear);
        request.setAttribute("nextMonth", nextMonth);

        // JSPへフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
        dispatcher.forward(request, response);
    }
}
