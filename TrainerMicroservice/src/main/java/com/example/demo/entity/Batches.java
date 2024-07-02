package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Table(name = "batches")
public class Batches {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;

private Long batchId;
	
	private Long courseId;
	
	private Long trainerId;
	private String BatchName;
	
	private LocalDate batchStartDate;
	private LocalDate batchEndDate;
}
