package com.example.demo.security;

import com.example.demo.member.dto.MemberDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

// 사용자 정보를 담고 있는 인증 객체

public class CustomUser extends User {

  public CustomUser(MemberDTO dto) {
	super(dto.getMemberId(), dto.getPassword(), Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));
  }
  
}