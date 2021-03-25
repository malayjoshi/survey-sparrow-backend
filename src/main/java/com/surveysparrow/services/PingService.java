package com.surveysparrow.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysparrow.dto.PingResponseDTO;
import com.surveysparrow.dto.UrlDTO;
import com.surveysparrow.entity.LogEntity;
import com.surveysparrow.entity.UrlEntity;
import com.surveysparrow.repository.LogsDAO;
import com.surveysparrow.repository.UrlsDAO;

@Service
public class PingService {
	
	@Autowired
	private LogsDAO logsDAO;
	
	@Autowired
	private UrlsDAO urlsDAO;
	
	@Autowired
	private ModelMapper mapper;

	public PingResponseDTO pingUrl(Integer urlId) throws Exception{
		
		PingResponseDTO dto=new PingResponseDTO();
		dto.setWithinResponseTime(false);
		
		UrlEntity url=urlsDAO.findById(urlId).get();
		
		try {
            URL urlObj = new URL(url.getUrl());
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
                        // Set connection timeout
            con.setConnectTimeout(url.getResponseTime());
            con.connect();
 
            int code = con.getResponseCode();
            if (code == 200) {
            	
                dto.setWithinResponseTime(true);
                dto.setTime(new Date());
            
            }
        } catch (Exception e) {
            //log it
        	LogEntity log=new LogEntity();
        	//log.setMessage(e.getMessage());
        	log.setMessage("Your URL has taken more than "+url.getResponseTime()+"ms to respond");
        	
        	Date time=new Date();
        	
        	log.setTime(time);
        	dto.setTime(time);
        	
        	log.setUrl(url);
        	logsDAO.save(log);
        }
		
		return dto;
	}

	public UrlDTO fetchUrl(Integer urlId) {
		
		return mapper.map(urlsDAO.findById(urlId).get(),
				UrlDTO.class);
	}
	
	
	
}
