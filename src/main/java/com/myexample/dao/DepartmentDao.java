package com.myexample.dao;

import com.myexample.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, String> {
}
