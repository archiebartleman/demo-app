package com.myexample.dao;

import com.myexample.domain.Salary;
import com.myexample.domain.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDao extends JpaRepository<Salary, SalaryId> {
}
