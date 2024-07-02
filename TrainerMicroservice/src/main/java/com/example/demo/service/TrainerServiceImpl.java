package com.example.demo.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.example.demo.dto.TrainerDto;
import com.example.demo.entity.Batches;
import com.example.demo.entity.Trainer;
import com.example.demo.entity.TrainingCourses;
import com.example.demo.mapper.TrainerMapper;
import com.example.demo.repository.BatchesRepository;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.repository.TrainingCoursesRepository;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	@Autowired
	private TrainingCoursesRepository coursesRepository;
	@Autowired
	private BatchesRepository batchesRepository;
	


	@Override
	public TrainerDto saveTrainer(TrainerDto trainerDto) {
		Trainer trainer=TrainerMapper.mapToTrainer(trainerDto);
		
		Trainer savedTrainer=trainerRepository.save(trainer);
	
		return TrainerMapper.mapToTrainerDto(savedTrainer);
	}
	
	

	@Override
	public TrainerDto getTrainerById(Long trainerId) {
		// TODO Auto-generated method stub
		
		Trainer trainer=trainerRepository.findById(trainerId).get();
		return TrainerMapper.mapToTrainerDto(trainer);
	}

	@Override
	public List<TrainerDto> getAllTrainers() {
		// TODO Auto-generated method stub
		List<Trainer> trainers=trainerRepository.findAll();
		return trainers.stream().map(TrainerMapper::mapToTrainerDto).collect(Collectors.toList());
	}
	

	
	
	
	@Override
	public TrainerDto getTrainingCoursesBatchesEngagedHoursByTrainerId(Long trainerId){
		
	Trainer trainer=trainerRepository.findById(trainerId).get();
List<TrainingCourses> list=webClient.get()
				.uri("http://localhost:8001/courses/get/list/"+trainerId)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<TrainingCourses>>() {}).block();
List<TrainingCourses> list2= coursesRepository.saveAll(list);

int courseTotalHours=0;
for(int i=0;i<list.size();i++) {
	courseTotalHours+=list.get(i).getCourseHours();
}



List<Batches> bList=webClient.get()
.uri("http://localhost:8004/batches/get/trainer/"+trainerId)
.retrieve().bodyToMono(new ParameterizedTypeReference<List<Batches>>() {}).block();



List<TrainingCourses> list3= coursesRepository.saveAll(list);
List<Batches> blist2=batchesRepository.saveAll(bList);




	//	http://localhost:8001/courses/get/list/1
trainer.setCourseList(list3);
trainer.setBatches(blist2);
trainer.setEngagedHours(courseTotalHours);

Trainer savedTrainer=trainerRepository.save(trainer);
TrainerDto trainerDto=TrainerMapper.mapToTrainerDto(savedTrainer);

//Period difference = Period.between(blist2, blist2.forEach(b->date=b.getBatchEndDate()));
	
return trainerDto;
		
	}


	
	

}
