package com.surveysparrow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysparrow.repository.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;
	
	public String getEmployeeNameByEmail(String email) {
		return userDao.findByEmail(email).getName();
	}
		
	
}
