package com.surveysparrow.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysparrow.dto.AddUrlRequest;
import com.surveysparrow.dto.UrlDTO;
import com.surveysparrow.entity.UrlEntity;
import com.surveysparrow.repository.UrlsDAO;
import com.surveysparrow.repository.UserDAO;

@Service
public class HomePageService {

	@Autowired
	private UrlsDAO urlsDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ModelMapper mapper;
	
	public int addUrl(AddUrlRequest request, String email) {
		
		UrlEntity url=new UrlEntity();
		url.setUrl(request.getUrl());
		url.setResponseTime(request.getResponseTime());
		url.setUser( userDAO.findByEmail(email) );
		
		return urlsDAO.save(url).getId();
		
	}

	public List<UrlDTO> getAllUrlsOfUser(String email) {
		
		return userDAO.findByEmail(email).
				getUrls().stream().
				map(url -> mapper.map(url, UrlDTO.class)).collect(Collectors.toList());
	}
	
	
	
}
