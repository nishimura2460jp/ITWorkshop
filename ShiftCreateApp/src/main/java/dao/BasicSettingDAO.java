package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.JobType;
import model.ShiftType;
import model.Staff;

public class BasicSettingDAO {
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
	    
	    //job_types テーブルに新しい業務の種類（job_name）を挿入
	    public static void addJobType(String jobName) {
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(
	                 "INSERT INTO job_types (job_name) VALUES (?)",
	                 Statement.RETURN_GENERATED_KEYS)) {
	            
	            // パラメータをセット
	            ps.setString(1, jobName);
	            ps.executeUpdate();

	            // 生成されたキー（ID）を取得（必要に応じて）
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int jobTypeId = rs.getInt(1);
	                // jobTypeIdを使って処理を続ける場合
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    		    // 業務の種類を取得
	    		    public static List<JobType> getJobTypes() {
	    		        List<JobType> jobTypes = new ArrayList<>();
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_types");
	    		             ResultSet rs = ps.executeQuery()) {
	    		            while (rs.next()) {
	    		                JobType jobType = new JobType();
	    		                jobType.setJobId(rs.getInt("job_id"));
	    		                jobType.setJobName(rs.getString("job_name"));
	    		                jobTypes.add(jobType);
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		        return jobTypes;
	    		    }

	    		    // shift_types テーブルに新しいシフトの種類（shift_name）を挿入
	    		    public static void addShiftType(String shiftName) {
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement(
	    		                 "INSERT INTO shift_types (shift_name) VALUES (?)",
	    		                 Statement.RETURN_GENERATED_KEYS)) {
	    		            
	    		            // パラメータをセット
	    		            ps.setString(1, shiftName);
	    		            ps.executeUpdate();

	    		            // 生成されたキー（ID）を取得（必要に応じて）
	    		            ResultSet rs = ps.getGeneratedKeys();
	    		            if (rs.next()) {
	    		                int shiftTypeId = rs.getInt(1);
	    		                // shiftTypeIdを使って処理を続ける場合
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }
	    		    
	    		    // シフトの種類を取得
	    		    public static List<ShiftType> getShiftTypes() {
	    		        List<ShiftType> shiftTypes = new ArrayList<>();
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement("SELECT * FROM shift_types");
	    		             ResultSet rs = ps.executeQuery()) {
	    		            while (rs.next()) {
	    		                ShiftType shiftType = new ShiftType();
	    		                shiftType.setShiftId(rs.getInt("shift_id"));
	    		                shiftType.setShiftName(rs.getString("shift_name"));
	    		                shiftTypes.add(shiftType);
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		        return shiftTypes;
	    		    }
	    		    
	    		    // 休暇情報をDBに挿入
	    		    public static void addHoliday(int staffId, int year, int month, int day, String holidayType) {
	    		        String sql = "INSERT INTO holidays (staff_id, year, month, day, holiday_type) VALUES (?, ?, ?, ?, ?)";
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement(sql)) {
	    		            
	    		            ps.setInt(1, staffId);
	    		            ps.setInt(2, year);
	    		            ps.setInt(3, month);
	    		            ps.setInt(4, day);
	    		            ps.setString(5, holidayType);
	    		            
	    		            ps.executeUpdate();  // データを挿入
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }

	    		 // スタッフをDBに登録
	    		    public static void addStaff(Staff staff) {
	    		        // Connectionを取得
	    		        try (Connection conn = getConnection()) {
	    		            // 1. スタッフ情報を登録する
	    		            String staffSql = "INSERT INTO staff (staff_name, weekly_work_days, shift_type_id) VALUES (?, ?, ?)";
	    		            try (PreparedStatement ps = conn.prepareStatement(staffSql, Statement.RETURN_GENERATED_KEYS)) {
	    		                ps.setString(1, staff.getStaffName());
	    		                ps.setInt(2, staff.getWeeklyWorkDays());
	    		                ps.setInt(3, staff.getShiftTypeId());
	    		                ps.executeUpdate();

	    		                // 2. 生成されたスタッフIDを取得
	    		                ResultSet rs = ps.getGeneratedKeys();
	    		                int staffId = -1;
	    		                if (rs.next()) {
	    		                    staffId = rs.getInt(1);
	    		                }

	    		                // 3. 業務の種類（JobTypes）をスタッフに紐づけ
	    		                if (staff.getJobTypes() != null && staffId != -1) {
	    		                    String jobSkillSql = "INSERT INTO staff_job_skills (staff_id, job_type_id) VALUES (?, ?)";
	    		                    try (PreparedStatement psJobSkill = conn.prepareStatement(jobSkillSql)) {
	    		                        for (Integer jobTypeId : staff.getJobTypes()) {
	    		                            psJobSkill.setInt(1, staffId);  // 登録したスタッフIDをセット
	    		                            psJobSkill.setInt(2, jobTypeId);  // 各業務IDをセット
	    		                            psJobSkill.addBatch();  // バッチ処理でまとめて実行
	    		                        }
	    		                        psJobSkill.executeBatch();  // バッチ実行
	    		                    }
	    		                }
	    		            } catch (SQLException e) {
	    		                e.printStackTrace();
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }
}
