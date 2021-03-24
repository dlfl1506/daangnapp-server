package com.cos.blog.web.dto.user;

import com.cos.blog.domain.user.User;
import com.cos.blog.web.dto.location.LocationReqDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSaveReqDto {
	private String phoneNumber;
	private String nickName;
	
	public User toEntity() {
		return User.builder().phoneNumber(phoneNumber).nickName(nickName).build();
	}
}
