package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import model.Shift;


@WebServlet("/ShiftCreateDAO")
public class ShiftCreateDAO {
	private final String JDBC_URL = "jdbc:h2:~/desktop/SQL/shiftCreate";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	// DB接続を取得するメソッド
    public static Connection getConnection() throws SQLException {
        try {
            // ドライバーの読み込み（H2の場合）
            Class.forName("org.h2.Driver");  // H2のJDBCドライバを指定
            return DriverManager.getConnection("jdbc:h2:~/desktop/SQL/shiftCreate", "sa", "");
            
        } catch (ClassNotFoundException | SQLException e) {
            // エラー処理
            e.printStackTrace();
            throw new SQLException("DB connection error", e);
        }
    }

    private static final String INSERT_SHIFT_SQL = "INSERT INTO shift (staff_id, shift_type_id, shift_date) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SHIFTS = "SELECT * FROM shift";
    private static final String DELETE_SHIFT_SQL = "DELETE FROM shift WHERE shift_id = ?";


    public void insertShift(Shift shift) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SHIFT_SQL)) {
            statement.setInt(1, shift.getStaffId());
            statement.setInt(2, shift.getShiftTypeId());
            statement.setString(3, shift.getShiftDate());
            statement.executeUpdate();
        }
    }

    public List<Shift> getAllShifts() {
        List<Shift> shifts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SHIFTS);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int shiftId = rs.getInt("shift_id");
                int staffId = rs.getInt("staff_id");
                int shiftTypeId = rs.getInt("shift_type_id");
                String shiftDate = rs.getString("shift_date");
                shifts.add(new Shift(shiftId, staffId, shiftTypeId, shiftDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shifts;
    }

    public boolean deleteShift(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SHIFT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
