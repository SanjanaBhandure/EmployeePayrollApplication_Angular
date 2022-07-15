package com.bridgelabz.employeepayrollapplication.repository;

import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
    EmployeePayrollData getOne(int empId);
    EmployeePayrollData getById(int empId);

    EmployeePayrollData findByEmployeeId(int empId);
}
