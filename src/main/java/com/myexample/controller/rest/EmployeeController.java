package com.myexample.controller.rest;

import com.myexample.domain.Employee;
import com.myexample.exception.EmployeeNotFoundException;
import com.myexample.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Employee> findAll() {
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @RequestMapping(value = "/employees/details/{employeeNumber}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> byNumber(@PathVariable("employeeNumber") Integer employeeNumber) {

        Employee employee = employeeService.byNumber(employeeNumber);

        if (employee == null) {
            throw new EmployeeNotFoundException(employeeNumber);
        } else {
            return ResponseEntity.ok(employee);
        }
    }
}
