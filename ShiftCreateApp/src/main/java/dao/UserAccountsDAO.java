package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.User;

public class UserAccountsDAO {
	private final String JDBC_URL = "jdbc:h2:~/desktop/SQL/shiftCreate";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public User findByLogin(Login login) {
		User user = null;
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}
		 // データベースへ接続
	    try (Connection conn = DriverManager.getConnection("jdbc:h2:~/desktop/SQL/shiftCreate","sa","")) {

	     // SELECT文を準備
	      String sql = "SELECT ID, NAME, PASS FROM USERACCOUNTS WHERE NAME =? AND PASS =?";  
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1, login.getName());
	      pStmt.setString(2, login.getPass());
	      
	      // SELECT文を実行し。結果表を取得
	      ResultSet rs = pStmt.executeQuery();
	      
	      if(rs.next()) {
	    	  // ユーザーが存在したらデータを取得
	    	  // ユーザーを表すUserインスタンスを生成
	    	  int id =rs.getInt("ID");
	    	  String name =rs.getString("NAME");
	    	  String pass =rs.getString("PASS");
	    	  user = new User(id, name, pass);
	      }
	      }catch (SQLException e) {
    	e.printStackTrace();
    	System.out.println("SQL State: " + e.getSQLState());
        System.out.println("Error Code: " + e.getErrorCode());
        System.out.println("Message: " + e.getMessage());
	      return null;
	    }
        return user;
  }
}
