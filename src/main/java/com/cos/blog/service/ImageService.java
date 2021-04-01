package com.cos.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.image.Image;
import com.cos.blog.domain.image.ImageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {

	private final ImageRepository imageRepository;
	
	@Transactional(readOnly = true)
	public List<Image> 게시물사진찾기(int postId){
		return imageRepository.게시물사진찾기(postId);
	}
	
	@Transactional
	public Image 사진등록(Image image) {
		return imageRepository.save(image);
}
}
