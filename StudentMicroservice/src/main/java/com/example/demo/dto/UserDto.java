package com.example.demo.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotEmpty;
import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long userId;
	
	@NotEmpty(message = "username should not be empty")
	private String userName;
	
	private String email;
	private Long phoneNumber;
	
	private Long trainerId;
	
	private Long courseId;

	
	private Long batchId;

}
