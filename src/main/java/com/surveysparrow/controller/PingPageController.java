package com.surveysparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.surveysparrow.dto.PingResponseDTO;
import com.surveysparrow.dto.UrlDTO;
import com.surveysparrow.services.PingService;

@CrossOrigin
@Controller
public class PingPageController {

	@Autowired
	private PingService pingService;
	
	
	@PostMapping(value="/api/ping/{urlId}")
	public ResponseEntity<?> pingUrl(@PathVariable Integer urlId) throws Exception{
		
		PingResponseDTO dto=pingService.pingUrl(urlId);
		return new ResponseEntity<PingResponseDTO>(
				dto,new HttpHeaders(),HttpStatus.OK
				);
	
	}
	
	@GetMapping(value="/api/url/{urlId}")
	public ResponseEntity<?> fetchUrl(@PathVariable Integer urlId) throws Exception{
		return new ResponseEntity<UrlDTO>(
				pingService.fetchUrl(urlId),new HttpHeaders(),HttpStatus.OK
				);
	}
	
}
