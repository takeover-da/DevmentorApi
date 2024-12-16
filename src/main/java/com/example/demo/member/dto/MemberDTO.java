package com.example.demo.member.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    // 회원아이디
    String memberId;

    // 회원이름
    String name;

    // 이메일
    String email;

    // 비밀번호
    String password;

    // 등급
    String role;

    // 등록일
    LocalDateTime regDate;

    // 수정일
    LocalDateTime modDate;

}
