package com.example.harsh.to_dolist.login;

import org.springframework.stereotype.Component;

@Component
public class authenticationservice {
	
	public boolean authenticate(String id,String pass) {
		
		boolean valid_id=id.equalsIgnoreCase("Harsh");
		boolean valid_pass=pass.equalsIgnoreCase("Pass");
		return valid_id && valid_pass;
	}
}
