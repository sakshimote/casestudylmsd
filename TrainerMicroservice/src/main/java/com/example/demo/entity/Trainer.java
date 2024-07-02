package com.example.demo.entity;

import java.time.Duration;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainers")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainerId;
	
	private String firstName;
	private String lastName;
	



	   @OneToMany(cascade = CascadeType.ALL)
	private List<TrainingCourses> courseList;
	   
	   @OneToMany(cascade = CascadeType.ALL)
	private List<Batches> batches;
	   
	   private int engagedHours;
	   
		private String designation;
		private String expertise;
		
	

}
