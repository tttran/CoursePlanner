package models;

/**
 * Created by Justin on 4/16/2017.
 */
public class Classroom {
    private int number;
    private Building building;

    public Classroom(int number, Building building) {
        this.number = number;
        this.building = building;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
