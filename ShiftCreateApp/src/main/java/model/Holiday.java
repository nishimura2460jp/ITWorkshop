package model;

public class Holiday {
    private int year;
    private int month;
    private int day;
    private String holidayType;

    // コンストラクタ
    public Holiday(int year, int month, int day, String holidayType) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.holidayType = holidayType;
    }

    // ゲッター・セッター
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }
}
