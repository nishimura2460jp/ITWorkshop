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
	        
	    		    // 業務の種類を取得
	    		    public static List<JobType> getJobTypes() {
	    		        List<JobType> jobTypes = new ArrayList<>();
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_types");
	    		             ResultSet rs = ps.executeQuery()) {
	    		            while (rs.next()) {
	    		                JobType jobType = new JobType();
	    		                jobType.setId(rs.getInt("id"));
	    		                jobType.setJobName(rs.getString("job_name"));
	    		                jobTypes.add(jobType);
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		        return jobTypes;
	    		    }

	    		    // シフトの種類を取得
	    		    public static List<ShiftType> getShiftTypes() {
	    		        List<ShiftType> shiftTypes = new ArrayList<>();
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement("SELECT * FROM shift_types");
	    		             ResultSet rs = ps.executeQuery()) {
	    		            while (rs.next()) {
	    		                ShiftType shiftType = new ShiftType();
	    		                shiftType.setId(rs.getInt("id"));
	    		                shiftType.setShiftName(rs.getString("shift_name"));
	    		                shiftTypes.add(shiftType);
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		        return shiftTypes;
	    		    }

	    		    // スタッフをDBに登録
	    		    public static void addStaff(Staff staff) {
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement(
	    		                 "INSERT INTO staff (staff_name, weekly_work_days, shift_type_id) VALUES (?, ?, ?)",
	    		                 Statement.RETURN_GENERATED_KEYS)) {
	    		            ps.setString(1, staff.getStaffName());
	    		            ps.setInt(2, staff.getWeeklyWorkDays());
	    		            ps.setInt(3, staff.getShiftTypeId());
	    		            ps.executeUpdate();

	    		            // 生成されたスタッフIDを取得
	    		            ResultSet rs = ps.getGeneratedKeys();
	    		            if (rs.next()) {
	    		                int staffId = rs.getInt(1);

	    		                // 業務の種類をスタッフに紐づけ
	    		                if (staff.getJobTypes() != null) {
	    		                    for (Integer jobTypeId : staff.getJobTypes()) {
	    		                        try (PreparedStatement psJobSkill = conn.prepareStatement(
	    		                                "INSERT INTO staff_job_skills (staff_id, job_type_id) VALUES (?, ?)")) {
	    		                            psJobSkill.setInt(1, staffId);
	    		                            psJobSkill.setInt(2, jobTypeId);
	    		                            psJobSkill.executeUpdate();
	    		                        }
	    		                    }
	    		                }
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }

	    		}
