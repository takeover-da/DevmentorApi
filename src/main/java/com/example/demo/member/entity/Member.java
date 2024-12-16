package com.example.demo.member.entity;

import org.hibernate.annotations.Comment;

import com.example.demo.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Comment("회원")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member extends BaseEntity {

	@Id
	@Column(length = 30)
	@Comment("회원아이디")
	String memberId;

	@Column(length = 30, nullable = false)
	@Comment("회원이름")
	String name;

	@Column(length = 50)
	@Comment("이메일")
	String email;

	@Column(length = 100, nullable = false)
	@Comment("비밀번호")
	String password;

	@Column(length = 30, nullable = false)
	@Comment("등급")
	String role;

}
