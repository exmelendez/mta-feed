package com.example.android.mta;

public class LineStatus {

    private String lineStatus;
    private String[] lineTimes = new String[8];
    private boolean lineOnTime;

    public LineStatus(String lineStatus, String[] lineTimes) {
        this.lineStatus = lineStatus;
        this.lineTimes = lineTimes;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public String[] getLineTimes() {
        return lineTimes;
    }

    public void setLineTimes(String[] lineTimes) {
        this.lineTimes = lineTimes;
    }

    public boolean isLineOnTime() {
        return lineOnTime;
    }

    public void setLineOnTime(boolean lineOnTime) {
        this.lineOnTime = lineOnTime;
    }
}
