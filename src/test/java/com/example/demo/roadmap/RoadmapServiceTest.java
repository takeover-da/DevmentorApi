package com.example.demo.roadmap;

import com.example.demo.roadmap.dto.RoadmapDTO;
import com.example.demo.roadmap.service.RoadmapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoadmapServiceTest {

    @Autowired
    RoadmapService service;

    @Test
    public void 로드맵등록() {
        // 로드맵 DTO 생성
        RoadmapDTO dto = RoadmapDTO.builder()
                .title("Spring Boot 로드맵")
                .description("스프링 부트 학습을 위한 단계별 로드맵")
                .difficulty(3)
                .build();

        // 로드맵 등록
        boolean isRegistered = service.register(dto);

        if (isRegistered) {
            System.out.println("로드맵이 등록되었습니다.");
        } else {
            System.out.println("로드맵 등록에 실패했습니다.");
        }
    }

    @Test
    public void 로드맵목록조회() {
        List<RoadmapDTO> list = service.getList();

        if (list.isEmpty()) {
            System.out.println("로드맵 목록이 비어 있습니다.");
        } else {
            for (RoadmapDTO dto : list) {
                System.out.println(dto);
            }
        }
    }

    @Test
    public void 로드맵단건조회() {
        // 테스트용 로드맵 번호
        int roadmapNo = 1;

        RoadmapDTO dto = service.read(roadmapNo);

        if (dto != null) {
            System.out.println("조회된 로드맵: " + dto);
        } else {
            System.out.println("로드맵이 존재하지 않습니다.");
        }
    }

    @Test
    public void 로드맵수정() {
        // 수정할 기존 로드맵 조회
        int roadmapNo = 1;
        RoadmapDTO dto = service.read(roadmapNo);

        if (dto != null) {
            // 로드맵 수정 내용
            dto.setTitle("Spring Boot 로드맵 - 수정");
            dto.setDescription("수정된 스프링 부트 학습 로드맵");
            dto.setDifficulty(4);

            // 수정 실행
            service.modify(dto);

            // 수정된 로드맵 확인
            RoadmapDTO updatedDto = service.read(roadmapNo);
            System.out.println("수정된 로드맵: " + updatedDto);
        } else {
            System.out.println("수정할 로드맵이 존재하지 않습니다.");
        }
    }

    @Test
    public void 로드맵삭제() {
        // 삭제할 로드맵 번호
        int roadmapNo = 1;

        // 로드맵 삭제 실행
        service.remove(roadmapNo);

        // 삭제 확인
        RoadmapDTO dto = service.read(roadmapNo);
        if (dto == null) {
            System.out.println("로드맵이 삭제되었습니다.");
        } else {
            System.out.println("로드맵 삭제 실패: " + dto);
        }
    }
}

