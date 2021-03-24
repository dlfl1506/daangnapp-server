package com.cos.blog.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.domain.location.Location;

public interface UserRepository extends JpaRepository<User,Integer> {

	@Query(value = "SELECT * FROM user where phoneNumber=?1",nativeQuery = true)
	User m유저확인(String phoneNumber);
	
	@Query(value = "SELECT * FROM user where nickName=?1",nativeQuery = true)
	User m닉네임중복체크(String nickName);
}
