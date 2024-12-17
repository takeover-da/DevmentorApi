package com.example.demo.lecture.service;

import java.util.List;

import com.example.demo.lecture.dto.LectureDTO;
import com.example.demo.lecture.entity.Lecture;

public interface LectureService {
	
	// 강의 등록 메소드
    int register(LectureDTO dto);

    // 강의 목록 조회 메소드
    List<LectureDTO> getList();

    // 강의 상세 조회 메소드
    LectureDTO read(int lectureNo);

    // 강의 수정 메소드
    void modify(LectureDTO dto);

    // 강의 삭제 메소드
    void remove(int lectureNo);

    // DTO를 엔티티로 변환하는 메소드
    default Lecture dtoToEntity(LectureDTO dto) {
        return Lecture.builder()
                .lectureNo(dto.getLectureNo())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .instructorName(dto.getInstructorName())
                .build();
    }

    // 엔티티를 DTO로 변환하는 메소드
    default LectureDTO entityToDto(Lecture entity) {
        return LectureDTO.builder()
                .lectureNo(entity.getLectureNo())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .instructorName(entity.getInstructorName())
                .fileurl(entity.getFileurl())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

}
