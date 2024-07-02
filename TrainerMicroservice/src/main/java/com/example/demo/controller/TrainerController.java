package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TrainerDto;
import com.example.demo.service.TrainerService;

@RestController
@RequestMapping("/trainers")
//@CrossOrigin(origins = {"http://localhost:4200/"})
public class TrainerController {
	
	
	@Autowired
	private TrainerService trainerService;
	
	@PostMapping("/post")
	public ResponseEntity<TrainerDto> postTrainer(@RequestBody TrainerDto trainerDto){
		TrainerDto savedTrainer=trainerService.saveTrainer(trainerDto);
		return new ResponseEntity<>(savedTrainer,HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{trainerId}")
	public ResponseEntity<TrainerDto> getTrainerById(@PathVariable Long trainerId){
		TrainerDto trainerDto=trainerService.getTrainerById(trainerId);
		return new ResponseEntity<>(trainerDto,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TrainerDto>> getAllTrainers(){
		List<TrainerDto> trainers=trainerService.getAllTrainers();
		return new ResponseEntity<>(trainers,HttpStatus.OK);
	}
	
	@PostMapping("/add/courses/{trainerId}")
	public ResponseEntity<TrainerDto> getTrainingCoursesByTrainerId(@PathVariable Long trainerId) {
		TrainerDto trainerDto=trainerService.getTrainingCoursesBatchesEngagedHoursByTrainerId(trainerId);
		return new ResponseEntity<>(trainerDto,HttpStatus.OK);
	}

	
	
	

}
