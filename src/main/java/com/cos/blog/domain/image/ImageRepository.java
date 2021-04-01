package com.cos.blog.domain.image;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer>{
	
	@Query(value = "SELECT * FROM image where postId=?1",nativeQuery = true)
	List<Image> 게시물사진찾기(int postId);
	
}
