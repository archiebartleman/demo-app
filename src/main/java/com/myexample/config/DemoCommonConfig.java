package com.myexample.config;

import com.myexample.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.myexample.domain")
@EnableJpaRepositories("com.myexample.dao")
@EnableTransactionManagement
public class DemoCommonConfig {
    @Autowired
    protected DepartmentDao departmentDao;

    @Autowired
    protected DeptEmpDao deptEmpDao;

    @Autowired
    protected DeptManagerDao deptManagerDao;

    @Autowired
    protected EmployeeDao employeeDao;

    @Autowired
    protected SalaryDao salaryDao;

    @Autowired
    protected TitleDao titleDao;
}
