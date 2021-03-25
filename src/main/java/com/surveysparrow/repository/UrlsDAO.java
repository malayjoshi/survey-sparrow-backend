package com.surveysparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveysparrow.entity.UrlEntity;

@Repository
public interface UrlsDAO extends JpaRepository<UrlEntity, Integer> {
	@Modifying
	@Query("delete from UrlEntity url where url.id = ?1")
	void delete(int id);
}
