package model;

import java.util.List;

public class Staff {
    private int id;
    private String staffName;
    private int weeklyWorkDays;
    private int shiftTypeId;
    private List<Integer> jobTypes;  // 複数選択された業務の種類

    // コンストラクタ
    public Staff() {}

    // ゲッター・セッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


