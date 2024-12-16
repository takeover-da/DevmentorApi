package com.example.demo.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.lecture.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
	
}
