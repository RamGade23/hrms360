package com.cordis.hrms360.controller;

import com.cordis.hrms360.entity.Employee;
import com.cordis.hrms360.model.CreateEmployeeReq;
import com.cordis.hrms360.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/hrms/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping //localhost:8080/employee
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> empList = employeeService.fetchAllEmployees();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @PostMapping("/addEmployee") //localhost:8080/employee/addEmployee
    public ResponseEntity<Employee> postEmployee(@RequestBody CreateEmployeeReq createEmployeeReq) {
        log.info("Employee Request : {}",createEmployeeReq.toString());
        Employee employee = employeeService.create(createEmployeeReq);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployee") //localhost:8080/employee/deleteEmployee
    public String deleteEmployee() {
        return "Akash";
    }
}
