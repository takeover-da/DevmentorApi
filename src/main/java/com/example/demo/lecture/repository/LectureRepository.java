package com.example.demo.lecture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.lecture.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
	
    // 로드맵별 강의 번호 리스트 조회
    @Query(value = "select * from lecture where lecture_no in (:lectureNo)", nativeQuery = true)
    List<Lecture> getLectureList(@Param("lectureNo") List<Integer> lectureNo);
	
}
