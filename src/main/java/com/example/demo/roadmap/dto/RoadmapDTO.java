package com.example.demo.roadmap.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadmapDTO {

    // 로드맵의 고유 번호
    int roadmapNo;

    // 로드맵 제목
    String title;

    // 로드맵 설명
    String description;

    // 로드맵의 난이도
    int difficulty;
    
    // 강의 리스트
    List<Integer> lectures;

    // 등록일
    LocalDateTime regDate;

    // 수정일
    LocalDateTime modDate;

}
