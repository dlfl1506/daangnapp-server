package com.cos.blog.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository extends JpaRepository<Likes, Integer>{
	@Modifying
	@Query(value = "INSERT INTO likes(postId, userId) VALUES(:postId, :userId)", nativeQuery = true)
	int mLike(int postId, int userId);
	
	@Modifying
	@Query(value = "DELETE FROM likes WHERE postId = :postId AND userId = :userId", nativeQuery = true)
	int mUnLike(int postId, int userId);
}