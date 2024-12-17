package com.example.demo.roadmap.service;

import com.example.demo.roadmap.dto.RoadmapDTO;
import com.example.demo.roadmap.entity.Roadmap;

import java.util.List;

public interface RoadmapService {

    // 로드맵 등록 메소드
    boolean register(RoadmapDTO dto);

    // 로드맵 목록 조회 메소드
    List<RoadmapDTO> getList();

    // 로드맵 상세 조회 메소드
    RoadmapDTO read(int roadmapNo);

    // 로드맵 수정 메소드
    void modify(RoadmapDTO dto);

    // 로드맵 삭제 메소드
    void remove(int roadmapNo);

    // DTO를 엔티티로 변환하는 메소드
    default Roadmap dtoToEntity(RoadmapDTO dto) {
        return Roadmap.builder()
                .roadmapNo(dto.getRoadmapNo())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .difficulty(dto.getDifficulty())
                .build();
    }

    // 엔티티를 DTO로 변환하는 메소드
    default RoadmapDTO entityToDto(Roadmap entity) {
        return RoadmapDTO.builder()
                .roadmapNo(entity.getRoadmapNo())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .difficulty(entity.getDifficulty())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

}
