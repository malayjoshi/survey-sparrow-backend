package com.surveysparrow.dto;

public class AuthenticationResponseDTO {
 	private final String jwt;
    private final String name;
    
    public AuthenticationResponseDTO(String jwt,String name) {
        this.jwt = jwt;
        this.name=name;
    }

    public String getJwt() {
        return jwt;
    }
    
    public String getName() {
    	return name; 
    }
}
