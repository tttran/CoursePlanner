package models;

/**
 * Created by Justin on 4/16/2017.
 */
public class TimeBlock {
    public enum Day
    {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }

    private Day day;

    private int startTime;
    private int endTime;

    public TimeBlock(int startTime, int endTime, Day day) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
