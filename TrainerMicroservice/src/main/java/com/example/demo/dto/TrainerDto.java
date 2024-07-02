package com.example.demo.dto;

import java.time.Duration;
import java.util.List;

import com.example.demo.entity.Batches;
import com.example.demo.entity.Trainer;
import com.example.demo.entity.TrainingCourses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto {
	
        private Long trainerId;
	
	private String firstName;
	private String lastName;
	
	private List<TrainingCourses> courseList;
	private List<Batches> batches;
	
	private int engagedHours;
	
	private String designation;
	private String expertise;

}
