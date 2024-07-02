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

import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseServiceImpl;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/courses")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/post")
	public ResponseEntity<CourseDto> postCourse(@RequestBody CourseDto courseDto){
		CourseDto savedCoureDto=courseService.saveCourse(courseDto);
		return new ResponseEntity<>(savedCoureDto,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/get/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId){
		CourseDto courseDto=courseService.getCourseById(courseId);
		return new ResponseEntity<>(courseDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<CourseDto>> getCourses(){
		List<CourseDto> courses=courseService.getAllCourses();
		return new ResponseEntity<>(courses,HttpStatus.OK);
		
	}
	@GetMapping("/get/list/{trainerId}")
	public ResponseEntity<List<CourseDto>> getCourseListByTrainerId(@PathVariable Long trainerId){
		List<CourseDto> courses=courseService.getCoursesByTrainerId(trainerId);
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	
}
