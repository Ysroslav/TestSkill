package ru.bodrov.enterprise.TryForStaff.model;


import java.sql.Date;

public class Staff extends AbstractEntity {

    private String firstName;

    private String lastName;

    private Date dateAddStaff;

    private Department department;

    public Staff(String firstName,
                 String lastName,
                 Date dateAddStaff,
                 Department department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateAddStaff = dateAddStaff;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateAddStaff() {
        return dateAddStaff;
    }

    public void setDateAddStaff(Date dateAddStaff) {
        this.dateAddStaff = dateAddStaff;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
