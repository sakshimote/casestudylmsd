package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TrainerDto;

public interface TrainerService {
	
	TrainerDto saveTrainer(TrainerDto trainerDto);
	
	TrainerDto getTrainerById(Long trainerId);
	
	List<TrainerDto> getAllTrainers();
	
	TrainerDto getTrainingCoursesBatchesEngagedHoursByTrainerId(Long trainerId);
	
	

}
