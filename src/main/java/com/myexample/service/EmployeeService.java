package com.myexample.service;

import com.myexample.dao.EmployeeDao;
import com.myexample.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAll() {
        log.info("finding all employees");
        return employeeDao.findAll();
    }

    public Employee byNumber(Integer id) {
        Employee employee = employeeDao.getOne(id);
        return employee;
    }
}
