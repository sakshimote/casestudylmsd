package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto {
	
	
	
private Long trainerId;
	
	private String firstName;
	private String lastName;
	
	private Long courseId;

}
