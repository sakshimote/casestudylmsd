package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CourseDto;

public interface CourseService {
	
	
	CourseDto saveCourse(CourseDto courseDto);
	
	 CourseDto getCourseById(Long courseId);

      List<CourseDto> getAllCourses();
      
      List<CourseDto> getCoursesByTrainerId(Long trainerId);

}
