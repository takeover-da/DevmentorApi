package com.example.demo.lecture.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.dto.LectureDTO;
import com.example.demo.lecture.entity.Lecture;
import com.example.demo.lecture.repository.LectureRepository;

@Service
public class LectureServiceImpl implements LectureService {

	@Autowired
	LectureRepository lectureRepository;

	@Override
	public int register(LectureDTO dto) {
		Lecture entity = dtoToEntity(dto);
		lectureRepository.save(entity);
		int newNo = entity.getLectureNo();
		return newNo;
	}

	@Override
	public List<LectureDTO> getList() {
        // 강의 목록 조회
        List<Lecture> lectures = lectureRepository.findAll();
        // 엔티를 DTO로 변환
        List<LectureDTO> lectureDTOs = lectures.stream()
									        		.map(entity->entityToDto(entity))
									        		.collect(Collectors.toList());
        return lectureDTOs;
	}

	@Override
	public LectureDTO read(int lectureNo) {
		Optional<Lecture> result = lectureRepository.findById(lectureNo);
		if (result.isPresent()) {
			Lecture board = result.get();
			LectureDTO boardDTO = entityToDto(board);
			return boardDTO;
		} else {
			return null;
		}
	}

	@Override
	public void modify(LectureDTO dto) {
		// 강의 번호로 기존 강의 조회
		Optional<Lecture> result = lectureRepository.findById(dto.getLectureNo());
		if (result.isPresent()) {
			// 기존 엔티티 가져오기
			Lecture entity = result.get();
			// 변경할 내용 업데이트
			entity.setTitle(dto.getTitle());
			entity.setDescription(dto.getDescription());
			entity.setInstructorName(dto.getInstructorName());
			// 엔티티 저장
			lectureRepository.save(entity);
		}
	}

	@Override
	public void remove(int lectureNo) {
		boolean isExist = lectureRepository.existsById(lectureNo);
		 // 강의 번호로 삭제
        if (isExist) {
            lectureRepository.deleteById(lectureNo);
        }
	}

}