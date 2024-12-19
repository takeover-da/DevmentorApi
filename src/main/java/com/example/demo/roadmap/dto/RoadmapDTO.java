package com.example.demo.roadmap.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.lecture.entity.Lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadmapDTO {

    // 로드맵의 고유 번호
    int roadmapNo;

    // 로드맵 제목
    String title;

    // 로드맵 설명
    String description;

    // 로드맵의 난이도
    int difficulty;
    
    // 강의 번호 리스트
    List<Integer> lectures;
    
    // 실제 강의 리스트
    List<Lecture> lectureList;
    
    // 대표이미지 파일
	MultipartFile thumnailFile; 
	
	// 대표이미지
	String thumnail; 

	// 상세이미지 파일
	MultipartFile detailImgFile; 

	// 상세이미지
	String detailImg; 

    // 등록일
    LocalDateTime regDate;

    // 수정일
    LocalDateTime modDate;

}
