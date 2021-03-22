package com.surveysparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysparrow.entity.UserEntity;

public interface UserDAO extends JpaRepository<UserEntity,Integer>{
	UserEntity findByEmail(String email);
}
