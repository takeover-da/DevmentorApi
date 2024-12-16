package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface MemberService {

    // 회원 등록 메소드
    boolean register(MemberDTO dto);

    // 회원 목록 조회 메소드
    List<MemberDTO> getList();

    // 회원 상세 조회 메소드
    MemberDTO read(String memberId);

    // 회원 수정 메소드
    void modify(MemberDTO dto);

    // 회원 삭제 메소드
    void remove(String memberId);

    // DTO를 엔티티로 변환하는 메소드
    default Member dtoToEntity(MemberDTO dto) {
        return Member.builder()
                .memberId(dto.getMemberId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }

    // 엔티티를 DTO로 변환하는 메소드
    default MemberDTO entityToDto(Member entity) {
        return MemberDTO.builder()
                .memberId(entity.getMemberId())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(entity.getRole())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

}
