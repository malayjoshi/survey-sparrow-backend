package com.surveysparrow.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysparrow.dto.LogDTO;
import com.surveysparrow.entity.LogEntity;
import com.surveysparrow.repository.LogsDAO;
import com.surveysparrow.repository.UrlsDAO;

@Service
public class LogsPageService {
	@Autowired
	private LogsDAO logsDAO;

	@Autowired
	private UrlsDAO urlsDAO;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<LogDTO> getLogsByDateAndUrl(Date date, Integer urlId) {
		
		long ltime=date.getTime()+1*24*60*60*1000;
		Date endDate=new Date(ltime);
		
		List<LogEntity> logs=logsDAO.findByDateAndUrl(date, endDate, urlsDAO.findById(urlId).get());
		
		return logs.stream().map(log -> mapper.map(log, LogDTO.class))
				.collect(Collectors.toList());
	}
	
	
	
}
