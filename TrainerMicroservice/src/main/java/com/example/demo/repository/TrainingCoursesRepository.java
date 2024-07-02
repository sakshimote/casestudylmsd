package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TrainingCourses;

public interface TrainingCoursesRepository extends JpaRepository<TrainingCourses, Long> {

}
