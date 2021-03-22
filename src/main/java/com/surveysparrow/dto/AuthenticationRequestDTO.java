package com.surveysparrow.dto;

public class AuthenticationRequestDTO {
	private String email;
    private String password;

    

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequestDTO()
    {

    }

    public AuthenticationRequestDTO(String username, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

}
