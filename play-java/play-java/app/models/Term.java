package models;

/**
 * Created by Justin on 4/16/2017.
 */
public class Term {
    private String semester;
    private int year;

    public Term(String semester, int year) {
        this.semester = semester;
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
