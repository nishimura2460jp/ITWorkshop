package model;

public class ShiftType {
    private int shiftId;
    private String shiftName;
    private String startTime;
    private String endTime;

    public ShiftType(int shiftId, String shiftName, String startTime, String endTime) {
        this.shiftId = shiftId;
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // コンストラクタ
    public ShiftType() {}

    // ゲッター・セッター
    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
}
