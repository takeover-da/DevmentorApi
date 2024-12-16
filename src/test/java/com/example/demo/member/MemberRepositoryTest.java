package com.example.demo.member;

import com.example.demo.lecture.entity.Lecture;
import com.example.demo.lecture.repository.LectureRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;

	@Test
	public void 회원등록() {
		// 회원 데이터 생성
		Member member = Member.builder()
				.memberId("user")
				.name("홍길동")
				.email("hong@test.com")
				.password("1234")
				.role("ROLE_USER")
				.build();

		// 회원 저장
		repository.save(member);
		System.out.println("회원 등록 완료: " + member);
	}

	@Test
	public void 회원목록조회() {
		List<Member> list = repository.findAll();
		for (Member member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void 회원단건조회() {
		Optional<Member> result = repository.findById("user");
		if (result.isPresent()) {
			Member member = result.get();
			System.out.println("조회된 회원: " + member);
		} else {
			System.out.println("회원이 없습니다.");
		}
	}

	@Test
	public void 회원수정() {
		// 기존 회원 조회
		Optional<Member> result = repository.findById("user");
		if (result.isPresent()) {
			Member member = result.get();
			// 일부 내용 수정
			member.setName("이몽룡");
			member.setEmail("lee@test.com");
			// 회원 저장 (업데이트)
			repository.save(member);
			System.out.println("회원 수정 완료: " + member);
		} else {
			System.out.println("수정할 회원이 없습니다.");
		}
	}

	@Test
	public void 회원삭제() {
		repository.deleteById("user");
		System.out.println("회원 삭제 완료.");
	}

}
