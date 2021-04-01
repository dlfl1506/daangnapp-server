package com.cos.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.service.UserService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.dto.user.UserSaveReqDto;
import com.cos.blog.web.dto.user.UserUpdateReqdto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@GetMapping("/user/phoneNumber")
	public CMRespDto<?> 유저확인(String phoneNumber) {
		return new CMRespDto<>(1, userService.유저확인(phoneNumber));
	}

	@GetMapping("/user/nickName")
	public CMRespDto<?> 닉네임중복체크(String nickName) {
		return new CMRespDto<>(1, userService.닉네임중복체크(nickName));
	}

	@GetMapping("/user/{id}")
	public CMRespDto<?> 유저ID로확인(@PathVariable int id) {
		return new CMRespDto<>(1, userService.유저ID로확인(id));
	}

	@PostMapping("/user")
	public CMRespDto<?> 회원가입(@RequestBody UserSaveReqDto userSaveReqDto) {
		return new CMRespDto<>(1, userService.회원가입(userSaveReqDto));
	}

	@PutMapping("/user/{id}")
	public CMRespDto<?> 닉네임AND포토이미지변경(@PathVariable int id,@RequestBody UserUpdateReqdto userUpdateReqdto) {
		return new CMRespDto<>(1, userService.닉네임AND프로필변경(id, userUpdateReqdto));
	}
}
