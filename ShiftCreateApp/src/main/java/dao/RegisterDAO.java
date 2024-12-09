package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    // JDBCのURL、ユーザー名、パスワードを適宜修正してください。
	private final String JDBC_URL = "jdbc:h2:~/desktop/SQL/shiftCreate";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

    public boolean registerUser(String name, String pass) {
    	// JDBCドライバを読み込む
    			try {
    				Class.forName("org.h2.Driver");
    			}catch(ClassNotFoundException e) {
    				throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
    			}
        // データベース接続処理
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/desktop/SQL/shiftCreate","sa","")) {
            String sql = "INSERT INTO USERACCOUNTS (NAME, PASS) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            	conn.setAutoCommit(true); // トランザクションが自動的にコミットされるように設定
            	stmt.setString(1, name);
                stmt.setString(2, pass);

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0; // 登録が成功した場合は true を返す
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQLエラーコード: " + e.getErrorCode());
            System.err.println("SQL状態: " + e.getSQLState());
            System.err.println("エラーメッセージ: " + e.getMessage());
            return false; // エラー発生時は false を返す
        }
    }
}
