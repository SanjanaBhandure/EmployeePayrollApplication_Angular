package com.bridgelabz.employeepayrollapplication.model;

import lombok.Data;

import javax.persistence.*;
@Entity
public @Data class EmployeePayrollData {
    @Id
    private int employeeId;
    private String employeeName;
    private String image;
    private String gender;
    private String department;
    private int salary;
    private String date;
    private String note;

    public EmployeePayrollData(int employeeId, String employeeName, String image, String gender, String department, int salary, String date, String note) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.image = image;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.note = note;
    }

    public EmployeePayrollData() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
