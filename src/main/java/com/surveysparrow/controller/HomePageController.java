package com.surveysparrow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.surveysparrow.dto.AddUrlRequest;
import com.surveysparrow.dto.UrlDTO;
import com.surveysparrow.dto.UserEmailDTO;
import com.surveysparrow.entity.UrlEntity;
import com.surveysparrow.services.HomePageService;

@Controller
public class HomePageController {
	
	@Autowired
	HomePageService homePageService;
	
	@Autowired
	private UserEmailDTO userEmailDTO;
	
	@PostMapping(value="/api/url")
	public ResponseEntity<?> addUrl(@RequestBody AddUrlRequest request)
			throws Exception{
		
		int id=homePageService.addUrl(request,userEmailDTO.getEmail());
		
		return new ResponseEntity<String>("{ \"id\":"+id+"}",
				new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/api/url")
	public ResponseEntity<?> getAllUrlsOfUser() throws Exception{
		return new ResponseEntity<List<UrlDTO>>(
				homePageService.getAllUrlsOfUser(userEmailDTO.getEmail()),
				new HttpHeaders(), HttpStatus.OK );
	}
	
	
}
