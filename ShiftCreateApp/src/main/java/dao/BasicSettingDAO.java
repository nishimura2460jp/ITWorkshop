package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Holiday;
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
	    
	 // 休暇履歴を取得
	    public static List<Holiday> getHolidayHistory(int staffId) {
	        List<Holiday> holidayHistory = new ArrayList<>();
	        
	        String sql = "SELECT year, month, day, holiday_type FROM holidays WHERE staff_id = ? ORDER BY year DESC, month DESC, day DESC";

	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, staffId);  // staff_idをセット
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                int year = rs.getInt("year");
	                int month = rs.getInt("month");
	                int day = rs.getInt("day");
	                String holidayType = rs.getString("holiday_type");

	                // 休暇情報をHolidayオブジェクトに格納
	                Holiday holiday = new Holiday(year, month, day, holidayType);
	                holidayHistory.add(holiday);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return holidayHistory;
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
	    		    
	    		 // useraccountsのNAMEを元にstaff_idを取得
	    		    public static int getStaffIdByUserName(String userName) {
	    		        String sql = "SELECT staff_id FROM staff WHERE staff_name = ?";
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement(sql)) {
	    		            
	    		            ps.setString(1, userName);  // useraccountsのNAMEをセット
	    		            ResultSet rs = ps.executeQuery();
	    		            
	    		            if (rs.next()) {
	    		                return rs.getInt("staff_id");  // 該当するstaff_idを返す
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		        return -1;  // 該当するstaff_idがない場合は-1を返す
	    		    }
	    		    
	    		 // 休暇情報をDBに挿入
	    		    public static void addHoliday(int staffId, int year, int month, int day, String holidayType) {
	    		        String sql = "INSERT INTO holidays (staff_id, year, month, day, holiday_type) VALUES (?, ?, ?, ?, ?)";
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement(sql)) {
	    		            
	    		            ps.setInt(1, staffId);   // 有効なstaff_idをセット
	    		            ps.setInt(2, year);      // yearをセット
	    		            ps.setInt(3, month);     // monthをセット
	    		            ps.setInt(4, day);       // dayをセット
	    		            ps.setString(5, holidayType); // holidayTypeをセット
	    		            
	    		            ps.executeUpdate();  // データを挿入
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }

	    		    // スタッフIDが有効かどうかをチェックするメソッド
	    		    private static boolean isValidStaffId(int staffId) {
	    		        String sql = "SELECT COUNT(*) FROM staff WHERE staff_id = ?";
	    		        try (Connection conn = getConnection();
	    		             PreparedStatement ps = conn.prepareStatement(sql)) {
	    		            
	    		            ps.setInt(1, staffId);
	    		            ResultSet rs = ps.executeQuery();
	    		            
	    		            if (rs.next()) {
	    		                return rs.getInt(1) > 0;  // 存在する場合はtrueを返す
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		        return false;  // 存在しない場合はfalseを返す
	    		    }

	    		 // useraccountsとstaffのnameを比較して、両者をstaff_user_mappingテーブルに関連付け
	    		    public static void linkUseraccountsToStaff() {
	    		        try (Connection conn = getConnection()) {
	    		            // 1. ユーザーアカウントとスタッフを名前で紐づける
	    		            String selectUseraccountsSql = "SELECT id, name FROM useraccounts";
	    		            String selectStaffSql = "SELECT staff_id, staff_name FROM staff";

	    		            // ユーザーアカウントを取得
	    		            Map<String, Integer> userAccounts = new HashMap<>();
	    		            try (PreparedStatement ps = conn.prepareStatement(selectUseraccountsSql);
	    		                 ResultSet rs = ps.executeQuery()) {
	    		                while (rs.next()) {
	    		                    String userName = rs.getString("name");
	    		                    int userId = rs.getInt("id");
	    		                    // 名前を標準化して格納
	    		                    userAccounts.put(normalizeName(userName), userId);
	    		                }
	    		            }

	    		            // スタッフを取得
	    		            List<Staff> staffList = new ArrayList<>();
	    		            try (PreparedStatement ps = conn.prepareStatement(selectStaffSql);
	    		                 ResultSet rs = ps.executeQuery()) {
	    		                while (rs.next()) {
	    		                    int staffId = rs.getInt("staff_id");
	    		                    String staffName = rs.getString("staff_name");
	    		                    // スタッフ情報をリストに追加
	    		                    staffList.add(new Staff(staffId, normalizeName(staffName)));
	    		                }
	    		            }

	    		            // 2. バッチ処理で useraccounts と staff を紐づける
	    		            String insertMappingSql = "INSERT INTO staff_user_mapping (useraccount_id, staff_id, name) VALUES (?, ?, ?)";
	    		            try (PreparedStatement psMapping = conn.prepareStatement(insertMappingSql)) {
	    		                for (Staff staff : staffList) {
	    		                    // 標準化したスタッフ名に一致するユーザーアカウントがある場合
	    		                    Integer userId = userAccounts.get(staff.getStaffName());
	    		                    if (userId != null) {
	    		                        // useraccounts と staff を紐づけ
	    		                        psMapping.setInt(1, userId);       // useraccount_id
	    		                        psMapping.setInt(2, staff.getStaffId()); // staff_id
	    		                        psMapping.setString(3, staff.getStaffName());  // name
	    		                        psMapping.addBatch();  // バッチに追加
	    		                    }
	    		                }
	    		                psMapping.executeBatch();  // バッチ実行
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }

	    		    // 名前を標準化するメソッド（全角・半角スペース削除）
	    		    public static String normalizeName(String name) {
	    		        // スペースを削除し、全角から半角に変換
	    		        name = name.replaceAll("　", " ").replaceAll("\\s", "").trim();
	    		        
	    		        // 半角に変換（全角→半角）
	    		        name = java.text.Normalizer.normalize(name, java.text.Normalizer.Form.NFKC);
	    		        
	    		        return name;
	    		    }

	    		    

	    		    // スタッフをDBに登録する際に名前を標準化
	    		    public static void addStaff(Staff staff) {
	    		        try (Connection conn = getConnection()) {
	    		            // スタッフ名を標準化
	    		            String normalizedStaffName = normalizeName(staff.getStaffName());
	    		            
	    		            // 1. スタッフ情報を登録する
	    		            String staffSql = "INSERT INTO staff (staff_name, weekly_work_days, shift_type_id) VALUES (?, ?, ?)";
	    		            try (PreparedStatement ps = conn.prepareStatement(staffSql, Statement.RETURN_GENERATED_KEYS)) {
	    		                ps.setString(1, normalizedStaffName);
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
	    		            }
	    		        } catch (SQLException e) {
	    		            e.printStackTrace();
	    		        }
	    		    }
	    		    }
	    		    

