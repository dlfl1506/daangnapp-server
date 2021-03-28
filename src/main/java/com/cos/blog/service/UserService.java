package com.cos.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.location.Location;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;
import com.cos.blog.web.dto.user.UserSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User 유저확인(String phoneNumber) {
		return userRepository.m유저확인(phoneNumber);
	}
	
	@Transactional(readOnly = true)
	public User 유저ID로확인(int userId) {
		return userRepository.findById(userId).orElseThrow(()->{
	         return new IllegalArgumentException();
	      });
	}
	@Transactional(readOnly = true)
	public User 닉네임중복체크(String nickName) {
		return userRepository.m닉네임중복체크(nickName);
	}
	
	@Transactional
	public User 회원가입(UserSaveReqDto userSaveReqDto) {
		return userRepository.save(userSaveReqDto.toEntity());
	}

}
