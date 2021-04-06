package com.cos.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.like.LikesRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikesService {
	private final LikesRepository likeRepository;
	
	@Transactional
	public void 관심추가(int postId, int userId) {
		likeRepository.mLike(postId,userId);
	
	}
	
	@Transactional
	public void 관심삭제(int postId, int userId) {
		likeRepository.mUnLike(postId, userId);
	}
}