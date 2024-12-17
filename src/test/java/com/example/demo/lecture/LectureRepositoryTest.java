package com.example.demo.lecture;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.lecture.entity.Lecture;
import com.example.demo.lecture.repository.LectureRepository;

@SpringBootTest
public class LectureRepositoryTest {

	@Autowired
	LectureRepository repository;

	@Test
	public void 강의등록() {
		// 강의 데이터 생성
		Lecture lecture = Lecture.builder()
									.title("스프링 강의")
									.description("스프링 부트와 JPA 학습")
									.instructorName("홍길동")
									.build();

		// 강의 저장
		repository.save(lecture);
		System.out.println("강의 등록 완료: " + lecture);
	}

	@Test
	public void 강의목록조회() {
		// 모든 강의 조회
		List<Lecture> list = repository.findAll();
		for (Lecture lecture : list) {
			System.out.println(lecture);
		}
	}

	@Test
	public void 강의단건조회() {
		// 강의 번호로 조회
		Optional<Lecture> result = repository.findById(1); // 강의번호 1번 가정
		if (result.isPresent()) {
			Lecture lecture = result.get();
			System.out.println("조회된 강의: " + lecture);
		} else {
			System.out.println("강의가 없습니다.");
		}
	}

	@Test
	public void 강의수정() {
		// 기존 강의 조회
		Optional<Lecture> result = repository.findById(1); // 강의번호 1번 가정
		if (result.isPresent()) {
			Lecture lecture = result.get();
			// 일부 내용 수정
			lecture.setTitle("수정된 스프링 강의");
			lecture.setDescription("수정된 설명입니다.");
			// 강의 저장 (업데이트)
			repository.save(lecture);
			System.out.println("강의 수정 완료: " + lecture);
		} else {
			System.out.println("수정할 강의가 없습니다.");
		}
	}

	@Test
	public void 강의삭제() {
		// 강의 삭제
		repository.deleteById(1); // 강의번호 1번 가정
		System.out.println("강의 삭제 완료.");
	}

}
