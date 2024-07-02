package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BatchDto;
import com.example.demo.entity.Batch;
import com.example.demo.mapper.BatchMapper;
import com.example.demo.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	private BatchRepository batchRepository;

	@Override
	public BatchDto saveBatch(BatchDto batchDto) {
		// TODO Auto-generated method stub
		
		Batch batch=BatchMapper.mapToBatch(batchDto);
		List<Batch> batches=batchRepository.findAll();
		for(int i=0;i<batches.size();i++) {
			
			System.out.println("hi");
		System.out.println(batchDto.getBatchStartDate());
		System.out.println(batches.get(0).getBatchStartDate());	
			
//			if(batchDto.getBatchStartDate().isAfter(batches.get(i).getBatchStartDate())
//					&& batchDto.getBatchEndDate().isBefore(batches.get(i).getBatchEndDate())) {
//			
				
				
				
				
//				throw new RuntimeException("Mentor occupied for given start date :"
//					+batchDto.getBatchStartDate()+" to end date"+batchDto.getBatchEndDate()+
//					" please enter start date which is available for mentor");	
//			}else {
//				Batch savedBatch=batchRepository.save(batch);
//				BatchDto batchDto2=BatchMapper.mapToBatchDto(savedBatch);
//				
//					return batchDto2;
//			}
		}
//if(batchDto.getBatchStartDate().isAfter())
//		
//		 if (currentDate.isAfter(batchStartDate) && currentDate.isBefore(batchEndDate)) {
//	            return true;
//	        } else {
//	            return false;
//	        }
//	
		return null;

	}

	@Override
	public List<BatchDto> getAllBatches() {
		// TODO Auto-generated method stub
		
		List<Batch> batches=batchRepository.findAll();
		
		return batches.stream().map(BatchMapper::mapToBatchDto).collect(Collectors.toList());
		
	}

	@Override
	public BatchDto getBatchById(Long batchId) {
		// TODO Auto-generated method stub
		
		Batch batch=batchRepository.findById(batchId).get();
		return BatchMapper.mapToBatchDto(batch);
	}

	@Override
	public List<BatchDto> getBatchesByTrainerId(Long trainerId) {
		// TODO Auto-generated method stub
		
		List<Batch> list=batchRepository.findByTrainerId(trainerId);
		return list.stream().map(BatchMapper::mapToBatchDto).collect(Collectors.toList());
	}
	
	
	

}
