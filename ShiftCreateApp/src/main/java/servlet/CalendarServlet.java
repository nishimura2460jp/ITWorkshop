package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	 private Map<String, Boolean> vacations = new HashMap<>();

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String yearParam = request.getParameter("year");
	        String monthParam = request.getParameter("month");
	        String dateParam = request.getParameter("date");
	        String vacationParam = request.getParameter("vacation");

	        // 年、月、日を処理する
	        int year = (yearParam != null) ? Integer.parseInt(yearParam) : Calendar.getInstance().get(Calendar.YEAR);
	        int month = (monthParam != null) ? Integer.parseInt(monthParam) : Calendar.getInstance().get(Calendar.MONTH);

	        // 日付を指定された場合、その日付もリクエストにセット
	        if (dateParam != null) {
	            request.setAttribute("year", year);
	            request.setAttribute("month", month);
	            request.setAttribute("day", Integer.parseInt(dateParam));
	        }
	        
	        // 月の最初の日の曜日を計算
	        Calendar cal = Calendar.getInstance();
	        cal.set(year, month, 1);
	        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	        // 休暇の処理
	        if ("true".equals(vacationParam) && dateParam != null) {
	            String vacationKey = year + "-" + (month + 1) + "-" + dateParam;
	            vacations.put(vacationKey, true);
	        }

	        // JSPに渡すデータを設定
	        request.setAttribute("year", year);
	        request.setAttribute("month", month);
	        request.setAttribute("vacations", vacations);
	        request.setAttribute("firstDayOfWeek", firstDayOfWeek);
	        request.setAttribute("daysInMonth", daysInMonth);

	        // JSPに転送
	        request.getRequestDispatcher((dateParam == null) ? "/WEB-INF/jsp/loginResult.jsp" : "/WEB-INF/jsp/holidaySet.jsp").forward(request, response);
	    }
	}
