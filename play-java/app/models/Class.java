package models;

/**
 * Created by Justin on 4/16/2017.
 */
public class Class {
    private String name;
    private int code;
    private Department department;

    public Class(String name, int code, Department department) {
        this.name = name;
        this.code = code;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
