package com.cos.blog.domain.post;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id; // id
   
   @Column(nullable = false, length = 100)
   private String title; // 제목
   
   @Column(nullable = false)
   @Lob
   private String content; // 내용
   
   @ColumnDefault("0") 
   private String price; // 가격
   
   private String img; // 이미지 사진
   
 
   @ColumnDefault("0") // default값 0이 들어간다.
   private int favorite; // 관심수
   
   @ColumnDefault("0")
   private int count; //조회수 
   
   @ManyToOne //post가 many
   @JoinColumn(name = "userId") //컬럼명 적기
   private User user;

   private String category;
   
   @Column(nullable = false)
   private String gu;
   
   @Column(nullable = false)
   private String dong;
   
   @CreationTimestamp 
   private Timestamp createDate; //만든시간
}