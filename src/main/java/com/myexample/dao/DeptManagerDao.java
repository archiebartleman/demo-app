package com.myexample.dao;

import com.myexample.domain.DeptManager;
import com.myexample.domain.DeptManagerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptManagerDao extends JpaRepository<DeptManager, DeptManagerId> {
}
