package ru.bodrov.enterprise.TryForStaff.model;

public class Department extends AbstractEntity {

    private String departmentName;

    public Department(String departmentName){ this.departmentName = departmentName;}

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
