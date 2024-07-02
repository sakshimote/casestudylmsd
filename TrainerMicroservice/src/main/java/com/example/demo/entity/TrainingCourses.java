package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainer_Coursess")
public class TrainingCourses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private Long courseId;
	
	private String courseName;
	
	private int courseHours;
	
	
	
	
	private Long trainerId;
	

}
