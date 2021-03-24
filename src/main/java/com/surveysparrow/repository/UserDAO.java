package com.surveysparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surveysparrow.entity.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,Integer>{
	UserEntity findByEmail(String email);
}
