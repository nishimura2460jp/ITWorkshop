package model;

import java.util.List;

public class Staff {
    private int staffId;
    private String staffName;
    private int weeklyWorkDays;
    private int shiftTypeId;
    private List<Integer> jobTypes;   // 複数選択された業務の種類（JobType ID）

 // コンストラクタを追加
    public Staff(int staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
    }
    
    // ゲッター・セッター
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getWeeklyWorkDays() {
        return weeklyWorkDays;
    }

    public void setWeeklyWorkDays(int weeklyWorkDays) {
        this.weeklyWorkDays = weeklyWorkDays;
    }

    public int getShiftTypeId() {
        return shiftTypeId;
    }

    public void setShiftTypeId(int shiftTypeId) {
        this.shiftTypeId = shiftTypeId;
    }

    public List<Integer> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<Integer> jobTypes) {
        this.jobTypes = jobTypes;
    }
}


