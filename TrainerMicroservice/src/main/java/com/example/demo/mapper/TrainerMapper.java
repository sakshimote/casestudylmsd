package com.example.demo.mapper;

import com.example.demo.dto.TrainerDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Trainer;

public class TrainerMapper {
	
public static final TrainerDto mapToTrainerDto(Trainer trainer) {
		
	
		
		TrainerDto trainerDto=new TrainerDto(
				trainer.getTrainerId(),
				trainer.getFirstName(),
				trainer.getLastName(),
                trainer.getCourseList(),
				trainer.getBatches(),
				trainer.getEngagedHours(),
				trainer.getDesignation(),
				trainer.getExpertise()
				);
		
		return trainerDto;
	}
	
	
	public static final Trainer mapToTrainer(TrainerDto trainerDto) {
		Trainer trainer=new Trainer(
				trainerDto.getTrainerId(),
				trainerDto.getFirstName(),
				trainerDto.getLastName(),
				trainerDto.getCourseList(),
				trainerDto.getBatches(),
				trainerDto.getEngagedHours(),
				trainerDto.getDesignation(),
				trainerDto.getExpertise()
		);
		
		return trainer;
	}
	

}
