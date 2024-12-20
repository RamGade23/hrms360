package com.cordis.hrms360.service;

import com.cordis.hrms360.entity.Address;
import com.cordis.hrms360.entity.Employee;
import com.cordis.hrms360.model.CreateEmployeeReq;
import com.cordis.hrms360.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String employeeName = "Akash";

    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee create(CreateEmployeeReq createEmployeeReq) {
        log.info("Inside create method of EmployeeService class");
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeReq.getFirstName());
        employee.setLastName(createEmployeeReq.getLastName());
        employee.setDepartment(createEmployeeReq.getDepartment());
        employee.setEmail(createEmployeeReq.getEmail());
        buildAddress(employee, createEmployeeReq);

        return employeeRepository.save(employee);
    }

    //this method is for mapping input address to address in employee request
    private void buildAddress(Employee employee, CreateEmployeeReq createEmployeeReq) {
        //List<Address> addressList = new ArrayList<>();

        //we are iterating address from input payload createEmployeeReq
        createEmployeeReq.getAddressReqList().forEach(addressReq -> {
            Address address = new Address();
            address.setCity(addressReq.getCity());
            address.setStreet(addressReq.getStreet());
            address.setState(addressReq.getState());
            address.setZipCode(addressReq.getZipCode());
            employee.addAddress(address);
            //addressList.add(address);
        });
        //employee.setAddresses(addressList);
    }
}
