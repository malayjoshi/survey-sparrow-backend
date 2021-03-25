package com.surveysparrow.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysparrow.dto.AddUrlRequest;
import com.surveysparrow.dto.UrlDTO;
import com.surveysparrow.entity.LogEntity;
import com.surveysparrow.entity.UrlEntity;
import com.surveysparrow.repository.LogsDAO;
import com.surveysparrow.repository.UrlsDAO;
import com.surveysparrow.repository.UserDAO;

@Service
public class HomePageService {

	@Autowired
	private UrlsDAO urlsDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private LogsDAO logsDAO;
	
	@Autowired
	private ModelMapper mapper;
	
	private static final Logger LOGGER=Logger.getLogger(HomePageService.class.getName());
	
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

	@Transactional
	public void deleteUrlAndLogs(Integer id) throws Exception{
		
		UrlEntity url=urlsDAO.findById(id).get();
		logsDAO.deleteByUrl(url);
		urlsDAO.delete(url.getId());
		
		 
		
	}
	
	
	
}
