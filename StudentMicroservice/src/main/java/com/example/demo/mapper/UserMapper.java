package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

public class UserMapper {
	
	
	public static final UserDto mapToUserDto(User user) {
		UserDto userDto=new UserDto(
				user.getUserId(),
				user.getUserName(),
				user.getEmail(),user.getPhoneNumber(),
				user.getTrainerId(),
				user.getCourseId(),
				user.getBatchId());
		
		return userDto;
	}
	
	
	public static final User mapToUser(UserDto userDto) {
		User user=new User(
				userDto.getUserId(),
				userDto.getUserName(),
				userDto.getEmail(),userDto.getPhoneNumber(),
				userDto.getTrainerId(),
				userDto.getCourseId(),
				userDto.getBatchId());
		
		return user;
	}

}
