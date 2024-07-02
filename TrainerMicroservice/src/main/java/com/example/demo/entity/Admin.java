package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

	
		
		private Long adminId;
		
	
		private String username;
		
		
		
		private String password;
	
		private String plainTextPassword;
		
		
		private String role;
		
}
