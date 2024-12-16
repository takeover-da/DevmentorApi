package com.example.demo.lecture.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureDTO {

    // 강의번호
    int lectureNo;

    // 강의제목
    String title;

    // 강의설명
    String description;

    // 강사명
    String instructorName;

    // 등록일
    LocalDateTime regDate;

    // 수정일
    LocalDateTime modDate;
    
}
