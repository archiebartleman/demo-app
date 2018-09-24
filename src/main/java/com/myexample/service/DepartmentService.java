package com.myexample.service;

import com.myexample.dao.DepartmentDao;
import com.myexample.domain.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> findAll() {
        log.info("finding all departments");
        return departmentDao.findAll();
    }
}
