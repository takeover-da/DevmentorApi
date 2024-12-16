package com.example.demo.member;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService service;

    @Test
    public void 회원등록() {
        // 회원 DTO 생성
        MemberDTO dto = MemberDTO.builder()
                .memberId("admin")
                .name("홍길동")
                .email("hong@test.com")
                .password("1234")
                .role("ROLE_ADMIN")
                .build();

        // 회원 등록
        boolean isSuccess = service.register(dto);

        if (isSuccess) {
            System.out.println("회원이 등록되었습니다.");
        } else {
            System.out.println("회원 등록에 실패하였습니다. (중복된 아이디)");
        }
    }

    @Test
    public void 회원목록조회() {
        // 모든 회원 조회
        List<MemberDTO> list = service.getList();

        for (MemberDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void 회원단건조회() {
        // 특정 회원 조회
        MemberDTO dto = service.read("admin");

        if (dto != null) {
            System.out.println("조회된 회원: " + dto);
        } else {
            System.out.println("회원이 존재하지 않습니다.");
        }
    }

    @Test
    public void 회원수정() {
        // 수정할 기존 회원 조회
        MemberDTO dto = service.read("admin");

        if (dto != null) {
            dto.setName("이몽룡");
            dto.setEmail("lee@test.com");
            dto.setPassword("5678");

            // 회원 수정
            service.modify(dto);

            // 수정된 회원 확인
            MemberDTO updatedDto = service.read("admin");
            System.out.println("수정된 회원: " + updatedDto);
        } else {
            System.out.println("수정할 회원이 존재하지 않습니다.");
        }
    }

    @Test
    public void 회원삭제() {
        // 특정 회원 삭제
        service.remove("admin");

        // 삭제 확인
        MemberDTO dto = service.read("admin");
        if (dto == null) {
            System.out.println("회원이 삭제되었습니다.");
        } else {
            System.out.println("회원 삭제 실패: " + dto);
        }
    }


}
