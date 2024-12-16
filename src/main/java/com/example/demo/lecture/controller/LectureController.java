package com.example.demo.lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.lecture.dto.LectureDTO;
import com.example.demo.lecture.service.LectureService;

@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	private LectureService service;

	// 강의 목록 조회
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<LectureDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 강의 등록 (폼 데이터 처리)
	@PostMapping("/register")
	public ResponseEntity<?> register(LectureDTO dto) {
		
		int lectureNo = service.register(dto);

		if (lectureNo > 0) {
			return new ResponseEntity<>(lectureNo, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("강의 등록에 실패했습니다", HttpStatus.BAD_REQUEST);
		}
	}

	// 강의 상세 조회
	@GetMapping("/read")
	public ResponseEntity<?> read(@RequestParam(name = "lectureNo") int lectureNo) {
		LectureDTO dto = service.read(lectureNo);
		if (dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("해당 강의가 없습니다", HttpStatus.BAD_REQUEST);
		}
	}

	// 강의 수정
	@PutMapping("/modify")
	public ResponseEntity<?> modify(LectureDTO dto) {
		service.modify(dto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// 강의 삭제
	@DeleteMapping("/remove")
	public ResponseEntity<?> remove(@RequestParam(name = "lectureNo") int lectureNo) {
		service.remove(lectureNo);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
