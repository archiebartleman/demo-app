package com.myexample.dao;

import com.myexample.domain.DeptEmp;
import com.myexample.domain.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptEmpDao extends JpaRepository<DeptEmp, DeptEmpId> {
}
