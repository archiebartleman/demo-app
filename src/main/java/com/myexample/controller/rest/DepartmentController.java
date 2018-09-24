package com.myexample.controller.rest;

import com.myexample.domain.Department;
import com.myexample.exception.DepartmentNotFoundException;
import com.myexample.exception.EmployeeNotFoundException;
import com.myexample.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departments/details/all")
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentService.findAll();
        if (departments == null || departments.size() ==0) {
            throw new DepartmentNotFoundException();
        } else {
            return ResponseEntity.ok(departments);
        }
    }
}
