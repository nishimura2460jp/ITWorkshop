package model;

public class Shift {
    private int shiftId;
    private int staffId;
    private int shiftTypeId;
    private String shiftDate;

    public Shift(int shiftId, int staffId, int shiftTypeId, String shiftDate) {
        this.shiftId = shiftId;
        this.staffId = staffId;
        this.shiftTypeId = shiftTypeId;
        this.shiftDate = shiftDate;
    }

    // Getters and Setters
    public int getShiftId() { return shiftId; }
    public int getStaffId() { return staffId; }
    public int getShiftTypeId() { return shiftTypeId; }
    public String getShiftDate() { return shiftDate; }
}
