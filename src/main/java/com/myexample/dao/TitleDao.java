package com.myexample.dao;

import com.myexample.domain.Title;
import com.myexample.domain.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleDao extends JpaRepository<Title, TitleId> {
}
