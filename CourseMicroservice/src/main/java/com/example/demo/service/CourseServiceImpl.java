package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseDto saveCourse(CourseDto courseDto) {
		// TODO Auto-generated method stub
		Course course=CourseMapper.mapToCourse(courseDto);
		Course savedCourse=courseRepository.save(course);
		return CourseMapper.mapToCourseDto(savedCourse);
	
	}
	
	

	@Override
	public CourseDto getCourseById(Long courseId) {
		
		Course course=courseRepository.findById(courseId).get();
		
		return CourseMapper.mapToCourseDto(course);
	}

	@Override
	public List<CourseDto> getAllCourses() {
		
		
		List<Course> courses=courseRepository.findAll();
		// TODO Auto-generated method stub
		return courses.stream().map(CourseMapper::mapToCourseDto).collect(Collectors.toList());
		
	}


	@Override
	public List<CourseDto> getCoursesByTrainerId(Long trainerId) {
		List<Course> coursesByTrainerId=courseRepository.findByTrainerId(trainerId);
		return coursesByTrainerId.stream().map(CourseMapper::mapToCourseDto).collect(Collectors.toList());
		
	}
	
	
	
	

	
	
}
