package com.example.demo.lecture.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import com.example.demo.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "lecture")
@Comment("강의")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lecture extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "lecture_seq_generator")
	@TableGenerator(
			name = "lecture_seq_generator",
			initialValue = 100, // 시작 값 설정
			allocationSize = 1  // 증가 단위
	)
	@Comment("강의번호")
	int lectureNo;

	@Column(length = 200, nullable = false)
	@Comment("강의제목")
	String title;

	@Column(length = 255)
	@Comment("강의설명")
	String description;
	
	@Column(length = 30)
	@Comment("강사명")
	String instructorName;

}
