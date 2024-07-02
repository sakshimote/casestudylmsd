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

import com.example.demo.dto.BatchDto;
import com.example.demo.service.BatchService;

@RestController
@RequestMapping("/batches")
@CrossOrigin("*")
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	
	@PostMapping("/post")
	public ResponseEntity<BatchDto> postBatch(@RequestBody BatchDto batchDto){
		BatchDto batchDto2=batchService.saveBatch(batchDto);
		return new ResponseEntity<>(batchDto2,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{batchId}")
	public ResponseEntity<BatchDto> getBatchByid(@PathVariable Long batchId){
		BatchDto batchDto=batchService.getBatchById(batchId);
		return new ResponseEntity<>(batchDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/list")
	public ResponseEntity<List<BatchDto>> getBatches(){
		List<BatchDto> batches=batchService.getAllBatches();
		return new ResponseEntity<>(batches,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/trainer/{trainerId}")
	public ResponseEntity<List<BatchDto>> getBatchesByTrainerId(@PathVariable Long trainerId){
		List<BatchDto> batches=batchService.getBatchesByTrainerId(trainerId);
		return new ResponseEntity<>(batches,HttpStatus.OK);
	}
	
	

}
