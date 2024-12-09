package servlet;

import java.io.IOException;

import dao.RegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterConfirmServlet")
public class RegisterConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("confirm".equals(action)) {
            String name = (String) request.getSession().getAttribute("name");
            String pass = (String) request.getSession().getAttribute("pass");
            
         // セッションスコープのデータをログに出力
            System.out.println("Session name: " + name);
            System.out.println("Session pass: " + pass);

            // DAO を使ってユーザーを登録
            RegisterDAO registerDAO = new RegisterDAO();
            boolean registrationSuccess = registerDAO.registerUser(name, pass);

            if (registrationSuccess) {
            	// 登録成功時の処理
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
                dispatcher.forward(request, response);
            } else {
            	// 登録失敗時の処理
                request.setAttribute("error", "ユーザー登録に失敗しました。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
                dispatcher.forward(request, response);
            }
        } else if ("edit".equals(action)) {
            response.sendRedirect("WEB-INF/jsp/register.jsp");
        }
    }
}
