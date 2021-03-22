package com.surveysparrow.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.surveysparrow.entity.UserEntity;
import com.surveysparrow.repository.UserDAO;


@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	UserDAO userDao;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity=userDao.findByEmail(email);
		
		User user=new User(userEntity.getEmail(),userEntity.getPassword(),new ArrayList<>());
		
		return user;
    }

}
