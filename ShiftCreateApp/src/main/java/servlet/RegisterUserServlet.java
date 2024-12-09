package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name").trim();
        String pass = request.getParameter("pass").trim();

        // 入力チェック
        if (name.isEmpty() || pass.isEmpty()) {
            request.setAttribute("error", "名前またはパスワードが入力されていません。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // 入力内容をセッションスコープに保存
        request.getSession().setAttribute("name", name);
        request.getSession().setAttribute("pass", pass);

        // 確認ページに遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
        dispatcher.forward(request, response);
    }
}

