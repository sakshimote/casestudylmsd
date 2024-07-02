package com.example.demo.mapper;

import com.example.demo.dto.BatchDto;
import com.example.demo.entity.Batch;

public class BatchMapper {
	
	
	public static final BatchDto mapToBatchDto(Batch batch) {
		BatchDto batchDto=new BatchDto(
				batch.getBatchId(),
				batch.getBatchName(),
				batch.getCourseId(),
				batch.getTrainerId(),
				batch.getBatchStartDate(),
				batch.getBatchEndDate(),batch.getTrainingOn(),batch.getTrainingBy());
		return batchDto;
	}
	
		
	
	public static final Batch mapToBatch(BatchDto batchDto) {
		Batch batch=new Batch(
				batchDto.getBatchId(),
				batchDto.getBatchName(),
				batchDto.getCourseId(),
				batchDto.getTrainerId(),
				batchDto.getBatchStartDate(),
				batchDto.getBatchEndDate(),batchDto.getTrainingOn(),batchDto.getTrainingBy());
		return batch;
	}
	

}
