package com.cos.blog.web.dto.auth;

import com.cos.blog.domain.auth.Auth;

import lombok.Data;

@Data
public class AuthSaveReqDto {
	private String phoneNumber;
	private String authCode;

	public Auth toEntity() {
		return Auth.builder()
				.phoneNumber(phoneNumber)
				.authCode(authCode)
				.build();
	}
}
