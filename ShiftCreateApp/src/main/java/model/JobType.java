package model;

public class JobType {
    private int jobId;
    private String jobName;
    private int staffRequired;

    // コンストラクタ
    public JobType() {}

    // ゲッター・セッター
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    public int getStaffRequired() {
        return staffRequired;
    }

    public void setStaffRequired(int staffRequired) {
        this.staffRequired = staffRequired;
    }
}

