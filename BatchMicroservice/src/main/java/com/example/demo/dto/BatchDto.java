package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {
private Long batchId;
private String BatchName;
	private Long courseId;
	
	private Long trainerId;

	private LocalDate batchStartDate;
	
	private LocalDate batchEndDate;
	
	private String TrainingOn;
	private String TrainingBy;
}
