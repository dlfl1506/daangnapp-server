package com.cos.blog.domain.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Location {
	private String sggcode;
	private String entrancecode;
	private String bjdcode;
	private String sdm;
	private String sggm;
	private String omdm;
	
	
	
	@Id  // PK
	private String drmcode;

	private String drm ;
	private String jhyb;
	private String buildbb;
	private String buildboob;
	private String builidname;
	private String pax;
	private String builidboonryu;
	private String buildyb;
	
	@Column(unique=true)  //  nullable : null 허용 x , length : 글자길이 , unique : 중복허용 x 
	private String ghhjd;
	private double entX;
	private double entY;

}
