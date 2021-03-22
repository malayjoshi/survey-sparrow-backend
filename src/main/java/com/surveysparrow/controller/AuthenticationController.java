package com.surveysparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surveysparrow.dto.AuthenticationRequestDTO;
import com.surveysparrow.dto.AuthenticationResponseDTO;
import com.surveysparrow.security.JwtUtil;
import com.surveysparrow.services.UserDetailService;
import com.surveysparrow.services.UserService;

@CrossOrigin
@Controller	
public class AuthenticationController {
	
	
	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserDetailService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
			); 
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
	}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmail());
		
		String name=userService.getEmployeeNameByEmail(userDetails.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponseDTO(jwt,name));
	}

	
}
