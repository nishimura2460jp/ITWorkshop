package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得（追記）
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name").trim(); // 前後の空白を削除
		String pass = request.getParameter("pass").trim(); // 前後の空白を削除
		
		// ログイン処理の実行
		Login login = new Login(name, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		// ログイン処理の成否によって処理を分岐
		if(result) {  //ログイン成功時
			// セッションスコープにユーザー名を保存
			HttpSession session = request.getSession();
			session.setAttribute("name", name);  // Userオブジェクトをセッションに保存
		
			// 現在の年と月を取得
	        java.util.Calendar cal = java.util.Calendar.getInstance();
	        int year = cal.get(java.util.Calendar.YEAR);
	        int month = cal.get(java.util.Calendar.MONTH); // 0-based (0 = January, 11 = December)

	        // year と month をリクエスト属性として設定
	        request.setAttribute("year", year);
	        request.setAttribute("month", month);
			
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
		
		  // System.out.println("Input name: " + login.getName());
	      // System.out.println("Input pass: " + login.getPass());
	      // System.out.println("Login result: " + result);
		
	}else {   // ログイン失敗時
	// リダイレクト
		request.setAttribute("errorMessage", "ユーザー名またはパスワードが間違っています。");
		response.sendRedirect("LoginServlet");
	}
}
}