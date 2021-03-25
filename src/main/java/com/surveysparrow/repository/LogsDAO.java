package com.surveysparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveysparrow.entity.LogEntity;
import com.surveysparrow.entity.UrlEntity;

@Repository
public interface LogsDAO extends JpaRepository<LogEntity, Integer>{
	@Modifying
	@Query("delete from LogEntity log where log.url = ?1")
	void deleteByUrl(UrlEntity url);
}
