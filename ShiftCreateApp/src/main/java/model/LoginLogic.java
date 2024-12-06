package model;

import dao.UserAccountsDAO;

public class LoginLogic {
public boolean execute(Login login) {
	UserAccountsDAO dao = new UserAccountsDAO();
	User user = dao.findByLogin(login);
	return user != null ;
}
}

