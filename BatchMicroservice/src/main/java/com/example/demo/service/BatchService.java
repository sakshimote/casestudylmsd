package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BatchDto;

public interface BatchService {
	
	BatchDto saveBatch(BatchDto batchDto);
	
	List<BatchDto> getAllBatches();
	
	
	BatchDto getBatchById(Long batchId);
	
	List<BatchDto> getBatchesByTrainerId(Long trainerId);
	
	
	

}
