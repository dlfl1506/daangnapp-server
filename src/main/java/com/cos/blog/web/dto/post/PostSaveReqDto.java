package com.cos.blog.web.dto.post;

import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;

import lombok.Data;

@Data
public class PostSaveReqDto {
	private String title; // 제목
	private String content; // 내용
	private String price; // 가격 // 가격

	private String gu;
	private String dong;
	private String category;

	public Post toEntity() {
		return Post.builder().title(title).content(content).price(price).gu(gu).dong(dong).category(category).build();
	}

}
