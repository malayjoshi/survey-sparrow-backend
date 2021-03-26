package com.surveysparrow.repository;

import java.util.Date;
import java.util.List;

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
	
	@Modifying
	@Query("from LogEntity log where log.time >= ?1 and log.time < ?2 and log.url = ?3")
	List<LogEntity> findByDateAndUrl(Date date1,Date date2,UrlEntity url);
	
}
