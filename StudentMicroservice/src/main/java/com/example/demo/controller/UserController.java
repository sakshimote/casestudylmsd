package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.APIResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController { 
	
	@Autowired
	
	private UserService userService;
	
	
	@PostMapping("/post")
	public ResponseEntity<UserDto> postUser(@RequestBody UserDto userDto){
		UserDto savedUser=userService.saveUser(userDto);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getById/{userId}")
	public ResponseEntity< APIResponseDto> getUserById(@PathVariable Long userId){
		 APIResponseDto userDto=userService.getByUserId(userId);
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<UserDto>> getUsers(){
		List<UserDto> users=userService.getUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/get/{courseId}")
	public ResponseEntity<List<UserDto>> getUsersByCourseId(@PathVariable Long courseId){
		List<UserDto> users=userService.getByCourseId(courseId);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/list/{trainerId}")
	public ResponseEntity<List<UserDto>> getUsersByTrainerId(@PathVariable Long trainerId){
		List<UserDto> users=userService.getByTrainerId(trainerId);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	@GetMapping("/get/batch/{batchId}")
	public ResponseEntity<List<UserDto>> getUsersByBatchId(@PathVariable Long batchId){
		List<UserDto> users=userService.getByBatchId(batchId);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
        //put method for saving end date remaining...
}
