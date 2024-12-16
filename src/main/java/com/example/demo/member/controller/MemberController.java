package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    // 회원 등록
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberDTO dto) {
        boolean isSuccess = memberService.register(dto);
        if (isSuccess) {
            return new ResponseEntity<>("회원 등록이 완료되었습니다.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("중복된 아이디로 인해 회원 등록에 실패하였습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    // 회원 목록 조회
    @GetMapping("/member/list")
    public ResponseEntity<List<MemberDTO>> getList() {
        List<MemberDTO> list = memberService.getList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 회원 단건 조회
    @GetMapping("/member/read")
    public ResponseEntity<MemberDTO> read(@RequestParam(name = "memberId") String memberId) {
        MemberDTO dto = memberService.read(memberId);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // 회원 수정
    @PutMapping("/member/modify")
    public ResponseEntity<String> modify(@RequestBody MemberDTO dto) {
        memberService.modify(dto);
        return new ResponseEntity<>("회원 정보가 수정되었습니다.", HttpStatus.OK);
    }

    // 회원 삭제
    @DeleteMapping("/member/remove")
    public ResponseEntity<String> remove(@RequestParam(name = "memberId") String memberId) {
        memberService.remove(memberId);
        return new ResponseEntity<>("회원이 삭제되었습니다.", HttpStatus.OK);
    }

}
