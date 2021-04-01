package com.cos.blog.web.dto.image;

import com.cos.blog.domain.image.Image;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;

import lombok.Data;

@Data
public class ImageSaveReqdto {

	private String uri;
	private Integer postId;

	public Image toEntity() {
		return Image.builder().uri(uri).post(Post.builder().id(postId).build()).build();
	}
}
