package model;

public class ShiftType {
    private int shiftId;
    private String shiftName;

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
}
