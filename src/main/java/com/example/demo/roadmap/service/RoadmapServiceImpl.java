package com.example.demo.roadmap.service;

import com.example.demo.lecture.entity.Lecture;
import com.example.demo.roadmap.dto.RoadmapDTO;
import com.example.demo.roadmap.entity.Roadmap;
import com.example.demo.roadmap.entity.RoadmapDetail;
import com.example.demo.roadmap.repository.RoadmapDetailRepository;
import com.example.demo.roadmap.repository.RoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoadmapServiceImpl implements RoadmapService {

    @Autowired
    RoadmapRepository roadmapRepository;

    @Autowired
    RoadmapDetailRepository detailRepository;

    @Override
    public boolean register(RoadmapDTO dto) {
        // DTO를 엔티티로 변환 후 저장
        Roadmap entity = dtoToEntity(dto);
        roadmapRepository.save(entity);

        // 강의 리스트 추가
        List<Integer> rectures = dto.getLectures();
        if(rectures!=null && rectures.size()>0) {
            // 새로운 강의리스트 추가
            for (int rectureNo : rectures) {
                // 강의 데이터 생성
                Lecture lecture = Lecture.builder().lectureNo(rectureNo).build();
                // 로드맵 상세 데이터 생성
                RoadmapDetail detail = RoadmapDetail.builder()
                        .roadmap(entity)
                        .lecture(lecture)
                        .build();
                detailRepository.save(detail);
            }
        }

        return true;
    }

    @Override
    public List<RoadmapDTO> getList() {
        // 로드맵 전체 목록 조회
        List<Roadmap> roadmaps = roadmapRepository.findAll();
        // 엔티티를 DTO로 변환
        return roadmaps.stream()
                .map(entity->{
                    List<Integer> lectures = detailRepository.getLectureListByRoadmapNo(entity.getRoadmapNo());
                    RoadmapDTO dto = entityToDto(entity);
                    dto.setLectures(lectures);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RoadmapDTO read(int roadmapNo) {
        // 로드맵 번호로 단건 조회
        Optional<Roadmap> result = roadmapRepository.findById(roadmapNo);
        if(result.isPresent()){
            Roadmap entity = result.get();
            RoadmapDTO dto = entityToDto(entity);
            List<Integer> lectures = detailRepository.getLectureListByRoadmapNo(dto.getRoadmapNo());
            dto.setLectures(lectures);
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public void modify(RoadmapDTO dto) {
        // 로드맵 번호로 기존 데이터 조회
        Optional<Roadmap> result = roadmapRepository.findById(dto.getRoadmapNo());
        if (result.isPresent()) {
            // 기존 엔티티 가져오기
            Roadmap entity = result.get();
            // 수정할 내용 업데이트
            entity.setTitle(dto.getTitle());
            entity.setDescription(dto.getDescription());
            entity.setDifficulty(dto.getDifficulty());
            
            // 강의 리스트 수정
            List<Integer> rectures = dto.getLectures();
            if(rectures!=null && rectures.size()>0){
                // 기존 강의리스트 삭제
                detailRepository.removeLectureListByRoadmapNo(entity.getRoadmapNo());
                // 새로운 강의리스트 추가
                for(int rectureNo : rectures){
                    // 강의 데이터 생성
                    Lecture lecture =  Lecture.builder().lectureNo(rectureNo).build();
                    // 로드맵 상세 데이터 생성
                    RoadmapDetail detail = RoadmapDetail.builder()
                                                            .roadmap(entity)
                                                            .lecture(lecture)
                                                            .build();
                    detailRepository.save(detail);
                }
            }
            
            // 엔티티 저장
            roadmapRepository.save(entity);
        }
    }

    @Override
    public void remove(int roadmapNo) {
        // 로드맵 존재 여부 확인 후 삭제
        if (roadmapRepository.existsById(roadmapNo)) {
            // 로드맵 상세 먼저 삭제
            detailRepository.removeLectureListByRoadmapNo(roadmapNo);
            roadmapRepository.deleteById(roadmapNo);
        }
    }
}
