package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public boolean register(MemberDTO dto) {
        // 회원 ID 중복 체크
        boolean exists = memberRepository.existsById(dto.getMemberId());
        if (exists) {
            return false; // 중복된 회원 ID
        }
        // DTO를 엔티티로 변환 후 저장
        Member entity = dtoToEntity(dto);
        memberRepository.save(entity);
        return true; // 등록 성공
    }

    @Override
    public List<MemberDTO> getList() {
        // 회원 목록 조회
        List<Member> members = memberRepository.findAll();
        // 엔티티를 DTO로 변환
        List<MemberDTO> memberDTOs = members.stream()
                .map(entity->entityToDto(entity))
                .collect(Collectors.toList());
        return memberDTOs;
    }

    @Override
    public MemberDTO read(String memberId) {
        // 회원 ID로 데이터 조회
        Optional<Member> result = memberRepository.findById(memberId);
        return result.map(this::entityToDto).orElse(null);
    }

    @Override
    public void modify(MemberDTO dto) {
        // 회원 ID로 기존 회원 조회
        Optional<Member> result = memberRepository.findById(dto.getMemberId());
        if (result.isPresent()) {
            // 기존 엔티티 가져오기
            Member entity = result.get();
            // 수정할 내용 업데이트
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setPassword(dto.getPassword());
            entity.setRole(dto.getRole());
            // 엔티티 저장
            memberRepository.save(entity);
        }
    }

    @Override
    public void remove(String memberId) {
        // 회원 ID 존재 여부 확인 후 삭제
        if (memberRepository.existsById(memberId)) {
            memberRepository.deleteById(memberId);
        }
    }

}
