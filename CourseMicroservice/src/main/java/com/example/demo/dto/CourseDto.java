package com.example.demo.dto;

import com.example.demo.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
	
private Long courseId;
	
	private String courseName;
	
	private int courseHours;
	
	private String courseDescription;
	
	private Long trainerId;
	
	private String trainingBy;
	

}
