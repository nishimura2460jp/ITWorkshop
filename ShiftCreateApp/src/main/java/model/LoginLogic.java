package model;

import dao.UserAccountsDAO;

public class LoginLogic {
public boolean execute(Login login) {
	UserAccountsDAO dao = new UserAccountsDAO();
	
	 // リクエストパラメータのパスワードをトリムして比較する
    String trimmedPass = login.getPass().trim();
    Login trimmedLogin = new Login(login.getName(), trimmedPass);
    
	User user = dao.findByLogin(login);
	return user != null ;
}
}

