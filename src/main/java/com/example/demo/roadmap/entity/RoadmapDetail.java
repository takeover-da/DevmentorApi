package com.example.demo.roadmap.entity;

import com.example.demo.lecture.entity.Lecture;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "roadmap_detail")
@Comment("로드맵상세")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoadmapDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("로드맵 상세의 고유 번호")
    int detailNo;

    @ManyToOne
    @Comment("연결된 로드맵")
    Roadmap roadmap;

    @ManyToOne
    @Comment("연결된 강의")
    Lecture lecture;
}
