package servlet;

import java.io.IOException;
import java.util.List;

import dao.BasicSettingDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ShiftType;


@WebServlet("/ShiftTypeServlet")
public class ShiftTypeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // データベースからシフトの種類を取得
        List<ShiftType> shiftTypes = BasicSettingDAO.getShiftTypes();

        // shiftTypesがnullまたは空ではないか確認
        if (shiftTypes != null && !shiftTypes.isEmpty()) {
            request.setAttribute("shiftTypes", shiftTypes);
        } else {
            System.out.println("No shift types available.");
            // shiftTypesが空の場合でもリクエスト属性をセット
            request.setAttribute("shiftTypes", shiftTypes);
        }

        // シフトの種類リストをJSPに渡す
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/shiftTypeForm.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shiftName = request.getParameter("shiftName");

        // シフトの種類をデータベースに登録
        BasicSettingDAO.addShiftType(shiftName);

        // 登録後、基本設定ページにリダイレクト
        response.sendRedirect("BasicSettingServlet");
    }
}
