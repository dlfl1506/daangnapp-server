package com.cos.blog.domain.user;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class User {
	private Integer id;
	private String phoneNumber;
	private String nickname;
	private String photo;

}
