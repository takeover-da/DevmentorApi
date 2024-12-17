package com.example.demo.roadmap.repository;

import com.example.demo.roadmap.entity.RoadmapDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface RoadmapDetailRepository extends JpaRepository<RoadmapDetail, Integer> {

    // 로드맵별 강의 리스트 조회
    @Query(value = "select lecture_lecture_no from roadmap_detail where roadmap_roadmap_no = :roadmapNo", nativeQuery = true)
    List<Integer> getLectureListByRoadmapNo(@Param("roadmapNo") int roadmapNo);
    
    // 로드맵별 강의 리스트 삭제
    @Modifying
    @Query(value = "delete from roadmap_detail where roadmap_roadmap_no = :roadmapNo", nativeQuery = true)
    void removeLectureListByRoadmapNo(@Param("roadmapNo") int roadmapNo);

}
