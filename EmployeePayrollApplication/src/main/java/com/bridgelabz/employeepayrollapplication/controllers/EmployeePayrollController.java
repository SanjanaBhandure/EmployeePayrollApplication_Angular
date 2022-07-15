/*
Spring Employee Payroll App Development.
* Coonecting to frontend Angular Application
*
* @author: Sanjana Bhandure.
* @version: 1.17
* @date: 13-07-2022
*/

package com.bridgelabz.employeepayrollapplication.controllers;

import com.bridgelabz.employeepayrollapplication.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapplication.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapplication.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapplication.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapplication.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employeePayrollService")
public class EmployeePayrollController {

    /*
     *Introducing DTO and Model and Service Layer to Employee Payroll App and created a Rest Controller to demonstrate the various HTTP Methods
     */

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"}, method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.getEmployeePayRollData();
        ResponseDTO responseDTO = new ResponseDTO(employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /* Getting data from server */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empId") int empId) throws EmployeePayrollException {
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayRollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO(employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /* Posting data to server */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody @Valid EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = employeePayrollService.addEmployeePayRollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    @PostMapping("/create/param")
//    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestParam(value = "name") @Valid String name, @RequestParam(value = "salary") @Valid long salary) {
//        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO(name, salary);
//        EmployeePayrollData employeePayrollData = employeePayrollService.addEmployeePayRollData(employeePayrollDTO);
//        ResponseDTO responseDTO = new ResponseDTO("Created employee payroll data successfully using request params", employeePayrollData);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }

    /* Deleting data from server */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollDataById(@PathVariable("empId") int empId) throws EmployeePayrollException {
        employeePayrollService.deleteEmployeePayRollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO( "Deleted by id: " + empId);
        return new ResponseEntity<>(responseDTO , HttpStatus.OK);
    }

    /* Updating data to server */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody @Valid EmployeePayrollDTO employeePayrollDTO) throws EmployeePayrollException {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayRollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
