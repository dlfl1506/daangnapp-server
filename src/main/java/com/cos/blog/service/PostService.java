package com.cos.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.web.dto.post.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	@Transactional
	public Post 중고거래글쓰기(Post post) {
		return postRepository.save(post);
	}
	@Transactional(readOnly = true)
	public List<Post> 구별게시물검색(String gu){
		return postRepository.m구별게시물검색(gu);
	}

}
