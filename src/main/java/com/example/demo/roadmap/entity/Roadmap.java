package com.example.demo.roadmap.entity;

import com.example.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "roadmap")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Roadmap extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("로드맵의 고유 번호")
    int roadmapNo;

    @Column(length = 50, nullable = false)
    @Comment("로드맵 제목")
    String title;

    @Column(length = 255)
    @Comment("로드맵 설명")
    String description;

    @Comment("로드맵의 난이도")
    int difficulty;

}
