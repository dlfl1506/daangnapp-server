package com.cos.blog.web.dto.post;

import com.cos.blog.domain.post.Post;

import lombok.Data;


@Data
public class PostUpdateReqDto {
	private String title; // 제목
	private String content; // 내용
	private String price; // 가격 // 가격
	private String category;
}
