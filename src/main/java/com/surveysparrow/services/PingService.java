package com.surveysparrow.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public boolean pingUrl(Integer urlId) throws Exception{
		boolean result=false;
		
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
                result = true;
            }
        } catch (Exception e) {
            //log it
        	LogEntity log=new LogEntity();
        	//log.setMessage(e.getMessage());
        	log.setMessage("Your URL has taken more than "+url.getResponseTime()+"ms to respond");
        	log.setTime(new Date());
        	log.setUrl(url);
        	logsDAO.save(log);
        }
		
		return result;
	}

	public UrlDTO fetchUrl(Integer urlId) {
		
		return mapper.map(urlsDAO.findById(urlId).get(),
				UrlDTO.class);
	}
	
	
	
}
