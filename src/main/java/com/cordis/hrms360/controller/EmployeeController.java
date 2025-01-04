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
import java.util.Optional;

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
        log.info("Create Employee Request : {}", createEmployeeReq.toString());
        Employee employee = employeeService.create(createEmployeeReq);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }


        /*return employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok().body(employee))
                .orElse(ResponseEntity.notFound().build());*/
    }

/*    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        log.info("Update Employee Request : {}", updatedEmployee.toString());
        Employee employee = employeeService.update(id, updatedEmployee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }*/

    @DeleteMapping("/deleteEmployee") //localhost:8080/employee/deleteEmployee
    public String deleteEmployee() {
        return "Akash";
    }
}
