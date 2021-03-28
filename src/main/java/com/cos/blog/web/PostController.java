package com.cos.blog.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.PostService;
import com.cos.blog.service.UserService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.dto.post.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostController {

	private final PostService postService;
	private final UserService userService;
	
	@PostMapping("/post")
	public CMRespDto<?> 중고거래글쓰기(@RequestBody PostSaveReqDto postSaveReqDto,int userId){
		User userEntity = userService.유저ID로확인(userId);
		Post post = postSaveReqDto.toEntity();
		post.setUser(userEntity);
		Post postEntity = postService.중고거래글쓰기(post);
		return new CMRespDto<>(1, postEntity);
	}
	
}
