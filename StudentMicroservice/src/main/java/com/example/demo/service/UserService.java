package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.APIResponseDto;
import com.example.demo.dto.UserDto;

public interface UserService {
	
	
	UserDto saveUser(UserDto userDto);
	
	 APIResponseDto getByUserId(Long userId);
	
	List<UserDto> getByCourseId(Long courseId);
	
	List<UserDto> getByTrainerId(Long trainerId);
	
	List<UserDto> getByBatchId(Long batchId);
	
	List<UserDto> getUsers();
	
	UserDto saveCourseCompletionDate(UserDto userDto);
	
	

}
