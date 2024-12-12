package servlet;

import java.io.IOException;

import dao.BasicSettingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ShiftTypeServlet")
public class ShiftTypeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shiftName = request.getParameter("shiftName");
        
        // データベースにシフトの種類を登録
         BasicSettingDAO.addShiftType(shiftName);
        
        response.sendRedirect("basicSetting.jsp");
    }
}
