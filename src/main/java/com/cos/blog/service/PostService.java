package com.cos.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.domain.user.User;
import com.cos.blog.web.dto.post.PostSaveReqDto;
import com.cos.blog.web.dto.post.PostUpdateReqDto;
import com.cos.blog.web.dto.user.UserUpdateReqdto;

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
	public List<Post> 구별게시물검색(String gu) {
		return postRepository.m구별게시물검색(gu);
	}

	@Transactional(readOnly = true)
	public Post 게시물상세보기(int id) {
		
		return postRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException();
		});
	}
	
	@Transactional
	public void 게시물삭제(int id) {
		postRepository.deleteById(id);
	}
	
	
	@Transactional
	public Post 게시물수정(int id, PostUpdateReqDto postUpdateReqDto) {
		// 영속화
		Post postEntity = postRepository.findById(id).get();
		postEntity.setTitle(postUpdateReqDto.getTitle());
		postEntity.setCategory(postUpdateReqDto.getCategory());
		postEntity.setPrice(postUpdateReqDto.getPrice());
		postEntity.setContent(postUpdateReqDto.getContent());
		return postEntity;
	}
}
