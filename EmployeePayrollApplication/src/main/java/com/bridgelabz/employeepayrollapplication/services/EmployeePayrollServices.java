package com.bridgelabz.employeepayrollapplication.services;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;

import com.bridgelabz.employeepayrollapplication.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollServices implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayRollData() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayRollDataById(int empId) throws EmployeePayrollException {
        EmployeePayrollData employeePayrollData =  employeeRepository.findByEmployeeId(empId);
        if(employeePayrollData != null) {
            return employeePayrollData;
        } else {
            throw new EmployeePayrollException("Employee not found with id: " + empId);
        }
    }

    @Override
    public EmployeePayrollData addEmployeePayRollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeeRepository.findAll().size()+1,
                employeePayrollDTO.employeeName, employeePayrollDTO.image, employeePayrollDTO.gender, employeePayrollDTO.department,
                employeePayrollDTO.salary, employeePayrollDTO.date, employeePayrollDTO.note);
        employeeRepository.save(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayRollDataById(int empId) throws EmployeePayrollException {
        EmployeePayrollData employeePayrollData = employeeRepository.findByEmployeeId(empId);
        if(employeePayrollData != null) {
            employeeRepository.deleteById(empId);
        } else {
            throw new EmployeePayrollException("Employee not found with id: " + empId);
        }
    }

    @Override
    public EmployeePayrollData updateEmployeePayRollData(int empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeePayrollException {
        EmployeePayrollData employeePayrollData = this.getEmployeePayRollDataById(empId);
        employeePayrollData.setEmployeeName(employeePayrollDTO.employeeName);
        employeePayrollData.setImage(employeePayrollDTO.image);
        employeePayrollData.setGender(employeePayrollDTO.gender);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollData.setDepartment(employeePayrollDTO.department);
        employeePayrollData.setDate(employeePayrollDTO.date);
        employeePayrollData.setNote(employeePayrollDTO.note);
        employeeRepository.save(employeePayrollData);
        return employeePayrollData;
    }
}
