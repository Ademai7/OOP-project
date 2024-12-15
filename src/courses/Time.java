package courses;

import java.io.Serializable;

public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    private String startTime;
    private String endTime;

    public Time(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return startTime + "-" + endTime;
    }
}
