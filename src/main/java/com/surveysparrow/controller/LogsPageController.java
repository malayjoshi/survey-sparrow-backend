package com.surveysparrow.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.surveysparrow.dto.LogDTO;

@CrossOrigin
@Controller
public class LogsPageController {
	@Autowired
	LogsPageService logsPageService;
	
	// for not recognizing date
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@GetMapping(value="/api/logs-of-url/{urlId}")
	public ResponseEntity<?> getLogsByDateAndUrl(
			@PathVariable Integer urlId,
			@RequestParam(name="date") Date date ) throws Exception{
		List<LogDTO> result=logsPageService.getLogsByDateAndUrl(date,urlId);
		
		return new ResponseEntity<List<LogDTO>>(
				result,new HttpHeaders(),HttpStatus.OK
				);
		
	}
	
}
