package com.example.demo.lecture;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.lecture.dto.LectureDTO;
import com.example.demo.lecture.service.LectureService;

@SpringBootTest
public class LectureServiceTest {
	
	@Autowired
    LectureService service;

    @Test
    public void 강의등록() {
        // 강의 DTO 생성
        LectureDTO dto = LectureDTO.builder()
                .title("Spring Boot 강의")
                .description("스프링 부트를 배워봅시다.")
                .instructorName("홍길동")
                .build();

        // 강의 등록
        int lectureNo = service.register(dto);

        if (lectureNo > 0) {
            System.out.println("강의가 등록되었습니다. 강의번호: " + lectureNo);
        } else {
            System.out.println("강의 등록에 실패했습니다.");
        }
    }

    @Test
    public void 강의목록조회() {
    	
    	List<LectureDTO> list = service.getList(); 
    	
        for (LectureDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void 강의단건조회() {

        LectureDTO dto = service.read(1);

        if (dto != null) {
            System.out.println("조회된 강의: " + dto);
        } else {
            System.out.println("강의가 존재하지 않습니다.");
        }
    }

    @Test
    public void 강의수정() {
    	
    	// 수정할 기존 강의 조회
    	LectureDTO dto = service.read(1);
    	
    	dto.setTitle("Spring Boot 강의 - 수정");
    	dto.setDescription("스프링 부트 강의를 업데이트했습니다.");
    	dto.setInstructorName("이몽룡");

        // 강의 수정
    	service.modify(dto);

        // 수정된 강의 확인
        LectureDTO updatedDto = service.read(1);
        System.out.println("수정된 강의: " + updatedDto);
    }

    @Test
    public void 강의삭제() {
        // 특정 강의 번호 삭제
    	service.remove(1); // 강의번호 1번 가정

        // 삭제 확인
        LectureDTO dto = service.read(1);
        if (dto == null) {
            System.out.println("강의가 삭제되었습니다.");
        } else {
            System.out.println("강의 삭제 실패: " + dto);
        }
    }

}
