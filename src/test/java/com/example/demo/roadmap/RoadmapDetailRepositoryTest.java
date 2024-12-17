package com.example.demo.roadmap;

import com.example.demo.lecture.entity.Lecture;
import com.example.demo.lecture.repository.LectureRepository;
import com.example.demo.roadmap.entity.Roadmap;
import com.example.demo.roadmap.entity.RoadmapDetail;
import com.example.demo.roadmap.repository.RoadmapDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RoadmapDetailRepositoryTest {

    @Autowired
    RoadmapDetailRepository roadmapDetailRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Test
    public void 로드맵상세등록() {
        // 로드맵 데이터 생성
        Roadmap roadmap = Roadmap.builder().roadmapNo(3).build();

        // 강의 데이터 생성
        Lecture lecture =  Lecture.builder().lectureNo(102).build();

        // 로드맵 상세 데이터 생성
        RoadmapDetail detail = RoadmapDetail.builder()
                .roadmap(roadmap)
                .lecture(lecture)
                .build();

        // 로드맵 상세 저장
        roadmapDetailRepository.save(detail);
        System.out.println("로드맵 상세 등록 완료: " + detail);
    }

    @Test
    public void 로드맵상세목록조회() {
        List<RoadmapDetail> list = roadmapDetailRepository.findAll();
        for (RoadmapDetail detail : list) {
            System.out.println(detail);
        }
    }

    @Test
    public void 로드맵상세단건조회() {
        Optional<RoadmapDetail> result = roadmapDetailRepository.findById(1);
        if (result.isPresent()) {
            RoadmapDetail detail = result.get();
            System.out.println("조회된 로드맵 상세: " + detail);
        } else {
            System.out.println("로드맵 상세가 존재하지 않습니다.");
        }
    }

    @Test
    public void 로드맵상세수정() {
        // 기존 강의 상세 조회
        Optional<Lecture> optionalLecture = lectureRepository.findById(102);

        // 기존 로드맵 상세 조회
        Optional<RoadmapDetail> optionalRoadmapDetail = roadmapDetailRepository.findById(1);
        if (optionalRoadmapDetail.isPresent()) {
            RoadmapDetail detail = optionalRoadmapDetail.get();
            // 일부 내용 수정
            detail.setLecture(optionalLecture.get());
            // 저장 (업데이트)
            roadmapDetailRepository.save(detail);
            System.out.println("로드맵 상세 수정 완료: " + detail);
        } else {
            System.out.println("수정할 로드맵 상세가 없습니다.");
        }
    }

    @Test
    public void 로드맵상세삭제() {
        roadmapDetailRepository.deleteById(1);
        System.out.println("로드맵 상세 삭제 완료.");
    }

    @Test
    public void 로드맵별강의조회() {
        int roadmapNo = 3; // 로드맵 번호 가정
        List<Integer> list = roadmapDetailRepository.getLectureListByRoadmapNo(roadmapNo);
        System.out.println("로드맵의 강의: " + list);
    }

    @Test
    public void 로드맵별강의삭제() {
        int roadmapNo = 3; // 로드맵 번호 가정
        roadmapDetailRepository.removeLectureListByRoadmapNo(roadmapNo);
    }

}
