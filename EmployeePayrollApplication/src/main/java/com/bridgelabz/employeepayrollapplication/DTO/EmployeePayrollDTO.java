package com.bridgelabz.employeepayrollapplication.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @NotNull(message = "name should not be null")
    public String employeeName;

    @NotNull(message = "image should not be null")
    public String image;

    @NotNull
    public String gender;

    @NotNull
    public String department;

    @NotNull
    public int salary;

    @NotNull
    public String date;

    @NotNull
    public String note;

    public EmployeePayrollDTO(String employeeName, String image, String gender, String department, int salary, String date, String note) {
        this.employeeName = employeeName;
        this.image = image;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.note = note;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}