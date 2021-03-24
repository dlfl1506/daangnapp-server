package com.cos.blog.domain.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.auth.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	@CreationTimestamp
	private Timestamp createDate;

}
