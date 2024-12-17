package com.example.demo.roadmap;

import com.example.demo.roadmap.entity.Roadmap;
import com.example.demo.roadmap.repository.RoadmapRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RoadmapRepositoryTest {

    @Autowired
    RoadmapRepository repository;

    @Test
    public void 로드맵등록() {
        // 로드맵 데이터 생성
        Roadmap roadmap = Roadmap.builder()
                .title("Spring Boot 학습 로드맵")
                .description("Spring Boot 기초부터 실전까지 학습합니다.")
                .difficulty(3)
                .build();

        // 로드맵 저장
        repository.save(roadmap);
        System.out.println("로드맵 등록 완료: " + roadmap);
    }

    @Test
    public void 로드맵목록조회() {
        List<Roadmap> list = repository.findAll();
        for (Roadmap roadmap : list) {
            System.out.println(roadmap);
        }
    }

    @Test
    public void 로드맵단건조회() {
        Optional<Roadmap> result = repository.findById(1);
        if (result.isPresent()) {
            Roadmap roadmap = result.get();
            System.out.println("조회된 로드맵: " + roadmap);
        } else {
            System.out.println("로드맵이 존재하지 않습니다.");
        }
    }

    @Test
    public void 로드맵수정() {
        // 기존 로드맵 조회
        Optional<Roadmap> result = repository.findById(1);
        if (result.isPresent()) {
            Roadmap roadmap = result.get();
            // 일부 내용 수정
            roadmap.setTitle("수정된 Spring Boot 학습 로드맵");
            roadmap.setDescription("내용이 수정되었습니다.");
            roadmap.setDifficulty(5);
            // 저장 (업데이트)
            repository.save(roadmap);
            System.out.println("로드맵 수정 완료: " + roadmap);
        } else {
            System.out.println("수정할 로드맵이 없습니다.");
        }
    }

    @Test
    public void 로드맵삭제() {
        repository.deleteById(1);
        System.out.println("로드맵 삭제 완료.");
    }
}
