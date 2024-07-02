package com.example.demo.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long batchId;
	private String BatchName;
	
	private Long courseId;
	
	private Long trainerId;
	
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate batchStartDate;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate batchEndDate;
	

	private String TrainingOn;
	private String TrainingBy;
	
	

}
