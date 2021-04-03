package com.cos.blog.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.domain.image.Image;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.ImageService;
import com.cos.blog.service.PostService;
import com.cos.blog.service.UserService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.dto.image.ImageSaveReqdto;
import com.cos.blog.web.dto.post.PostSaveReqDto;
import com.cos.blog.web.dto.post.PostUpdateReqDto;
import com.cos.blog.web.dto.user.UserUpdateReqdto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostController {

	private final PostService postService;
	private final UserService userService;
	private final ImageService imageService;

	@PostMapping("/post/image")
	public CMRespDto<?> 이미지저장(@RequestBody ImageSaveReqdto imageSaveReqdto) {
		Image imageEntity = imageService.사진등록(imageSaveReqdto.toEntity());
		if (imageEntity == null) {
			return new CMRespDto<>(-1, null);
		} else {
			return new CMRespDto<>(1, imageEntity);
		}
	}

	
	@PostMapping("/post")
	public CMRespDto<?> 중고거래글쓰기(@RequestBody PostSaveReqDto postSaveReqDto, int userId) {
		User userEntity = userService.유저ID로확인(userId);
		Post post = postSaveReqDto.toEntity();
		post.setUser(userEntity);
		Post postEntity = postService.중고거래글쓰기(post);
		return new CMRespDto<>(1, postEntity);
	}

	@GetMapping("/post/gu")
	public CMRespDto<?> 구별게시물검색(String gu) {
		return new CMRespDto<>(1, postService.구별게시물검색(gu));
	}

	@GetMapping("/post/image")
	public CMRespDto<?> 게시물사진찾기(int postId) {
		return new CMRespDto<>(1, imageService.게시물사진찾기(postId));
	}

	@GetMapping("/post/{id}")
	public CMRespDto<?> 게시물상세보기(@PathVariable int id) {
		return new CMRespDto<>(1, postService.게시물상세보기(id));
	}

	@DeleteMapping("/post/{id}")
	public CMRespDto<?> deleteById(@PathVariable int id) {
		postService.게시물삭제(id);
		return new CMRespDto<>(1, null);
	}

	@PutMapping("/post/{id}")
	public CMRespDto<?> 게시물수정(@PathVariable int id, @RequestBody PostUpdateReqDto postUpdateReqDto) {
		return new CMRespDto<>(1, postService.게시물수정(id, postUpdateReqDto));
	}

}
