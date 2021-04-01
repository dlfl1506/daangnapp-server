package com.cos.blog.domain.user;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.auth.Auth;
import com.cos.blog.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String phoneNumber;
	
	@Column(nullable =false ,length = 50,unique=true)  //  nullable : null 허용 x , length : 글자길이 , unique : 중복허용 x 
	private String nickName;
	
	private String photo;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // cacade : post 삭제시 이미지 다날라감.
	@JsonIgnoreProperties({"user"})
	@ToString.Exclude
	private List<Post> posts;
	
	@CreationTimestamp
	private Timestamp createDate;

}
