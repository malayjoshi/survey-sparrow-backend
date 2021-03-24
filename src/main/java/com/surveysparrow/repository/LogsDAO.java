package com.surveysparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surveysparrow.entity.LogEntity;

@Repository
public interface LogsDAO extends JpaRepository<LogEntity, Integer>{
	
}
