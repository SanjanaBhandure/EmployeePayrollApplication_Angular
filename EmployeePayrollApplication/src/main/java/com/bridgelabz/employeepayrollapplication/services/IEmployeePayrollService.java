package com.bridgelabz.employeepayrollapplication.services;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayRollData();
    EmployeePayrollData getEmployeePayRollDataById(int empId) throws EmployeePayrollException;
    EmployeePayrollData addEmployeePayRollData(EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayRollDataById(int empId) throws EmployeePayrollException;
    EmployeePayrollData updateEmployeePayRollData(int empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeePayrollException;
}
