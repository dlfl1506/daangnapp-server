package com.cos.blog.web.dto.auth;

import lombok.Data;

@Data
public class AuthUpdateReqDto {
	private String phoneNumber;
	private String authCode;
}
