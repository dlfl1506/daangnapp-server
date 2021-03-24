package com.cos.blog.web;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.service.AuthService;
import com.cos.blog.service.LocationService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.dto.auth.AuthSaveReqDto;
import com.cos.blog.web.dto.auth.AuthUpdateReqDto;

import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@RequiredArgsConstructor
@RestController
public class AuthController {
	
	private final AuthService authService;
	
	@GetMapping("/auth")
	public CMRespDto<?> 인증코드확인(String phoneNumber){
		return new CMRespDto<>(1,authService.인증코드확인(phoneNumber));
	}
	
	@PostMapping("/auth")
	public CMRespDto<?> 인증코드전송(@RequestBody AuthSaveReqDto authSaveReqDto){
		return new CMRespDto<>(1,authService.문자전송후save(authSaveReqDto));
	}
	
	@DeleteMapping("/auth")
	public CMRespDto<?> 인증코드삭제(int id){
		authService.인증코드삭제(id);
		return new CMRespDto<>(1, null); 
	}
	
	@PutMapping("/auth")
	public CMRespDto<?> 인증코드수정(int id,AuthUpdateReqDto authUpdateReqDto){
		return new CMRespDto<>(1,authService.인증코드수정(id,authUpdateReqDto));
	}
}
