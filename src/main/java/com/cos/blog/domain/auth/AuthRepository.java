package com.cos.blog.domain.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.location.Location;

public interface AuthRepository extends JpaRepository<Auth,Integer> {

	@Query(value = "SELECT * FROM auth where phoneNumber=?1",nativeQuery = true)
	Auth 인증코드확인(String phoneNumber);
}
