package com.surveysparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysparrow.entity.UrlEntity;

public interface UrlsDAO extends JpaRepository<UrlEntity, Integer> {

}
