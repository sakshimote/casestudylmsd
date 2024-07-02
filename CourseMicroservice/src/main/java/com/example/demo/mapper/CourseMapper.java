package com.example.demo.mapper;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;

public class CourseMapper {
	
	public static final CourseDto mapToCourseDto(Course course) {
		CourseDto courseDto=new CourseDto(
				course.getCourseId(),
				course.getCourseName(),
				course.getCourseHours(),
				course.getCourseDescription(),
				course.getTrainerId(),
				course.getTrainingBy());
		
		return courseDto;
	}

	
	public static final Course mapToCourse(CourseDto courseDto) {
		Course course=new Course(
				courseDto.getCourseId(),
				courseDto.getCourseName(),
				courseDto.getCourseHours(),
				courseDto.getCourseDescription(),
				courseDto.getTrainerId(),
				courseDto.getTrainingBy());
		return course;
	}
}
