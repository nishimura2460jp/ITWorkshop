package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ShiftCreateDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shift;

@WebServlet("/ShiftServlet")
public class ShiftServlet extends HttpServlet {
    private ShiftCreateDAO shiftCreateDAO;

    public void init() {
        shiftCreateDAO = new ShiftCreateDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Shift> listShift = shiftCreateDAO.getAllShifts();
        request.setAttribute("listShift", listShift);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/shiftResult.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staff_id"));
        int shiftTypeId = Integer.parseInt(request.getParameter("shift_type_id"));
        String shiftDate = request.getParameter("shift_date");

        Shift newShift = new Shift(0, staffId, shiftTypeId, shiftDate);
        try {
            shiftCreateDAO.insertShift(newShift);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ShiftCreateDAO");
    }
}


