package com.example.demo.lecture.entity;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("강의번호")
	int lectureNo;

	@Column(length = 50, nullable = false)
	@Comment("회원아이디")
	String memberId;

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
