package com.example.demo.service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.APIResponseDto;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.TrainerDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	private WebClient webClient;
	
	

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user=UserMapper.mapToUser(userDto);
		User savedUser=userRepository.save(user);
		return UserMapper.mapToUserDto(savedUser);
	}



	@Override
	public APIResponseDto getByUserId(Long userId) {
		// TODO Auto-generated method stub
		
		logger.info("get by user id method accessed");
		
		User user=userRepository.findById(userId).orElseThrow(
				()->new ResourceNotFoundException("user", "id",userId));;
		

		CourseDto courseDto=	webClient.get()
		.uri("http://localhost:8001/courses/get/"+user.getCourseId())
		.retrieve().bodyToMono(CourseDto.class).block();
		
		
		TrainerDto trainerDto=webClient.get()
				
.uri("http://localhost:8002/trainers/getById/"+user.getTrainerId())
.retrieve().bodyToMono(TrainerDto.class).block();
		
		
		
	UserDto userDto= UserMapper.mapToUserDto(user);
	
	APIResponseDto apiResponseDto=new  APIResponseDto();
	apiResponseDto.setUserDto(userDto);
	apiResponseDto.setCourseDto(courseDto);
	apiResponseDto.setTrainerDto(trainerDto);
	
	return apiResponseDto;
	

		
	}



	@Override
	public List<UserDto> getByCourseId(Long courseId) {
		// TODO Auto-generated method stub
		
		List<User> users=userRepository.findByCourseId(courseId);
		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		
	}

	
	


	@Override
	public List<UserDto> getUsers() {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findAll();
		
		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		
	}


	//put method impl remaining..
	@Override
	public UserDto saveCourseCompletionDate(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<UserDto> getByTrainerId(Long trainerId) {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findByTrainerId(trainerId);
		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
	}



	@Override
	public List<UserDto> getByBatchId(Long batchId) {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findByBatchId(batchId);
		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
	}
	
	
	

}
