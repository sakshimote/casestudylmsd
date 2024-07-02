package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long>{

	List<Batch> findByTrainerId(Long trainerId);

}
