package com.cos.blog.service;

import org.springframework.stereotype.Service;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.web.dto.post.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	
	public Post 중고거래글쓰기(Post post) {
		return postRepository.save(post);
	}

}
