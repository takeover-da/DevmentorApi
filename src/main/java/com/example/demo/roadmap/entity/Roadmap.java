package com.example.demo.roadmap.entity;

import org.hibernate.annotations.Comment;

import com.example.demo.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    
	@Column(length = 300)
	String thumnail; //대표이미지

	@Column(length = 300)
	String detailImg; //상세이미지

}
