package com.cos.blog.web;

import java.awt.geom.Point2D;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.domain.location.Location;
import com.cos.blog.service.LocationService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.dto.location.LocationReqDto;
import com.jhlabs.map.proj.Projection;
import com.jhlabs.map.proj.ProjectionFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LocationController {

	private final LocationService locationService;

	@PostMapping("/location")
	public CMRespDto<?> 근처주소검색(@RequestBody LocationReqDto locationReqDto) {
		return new CMRespDto<>(1, locationService.근처주소검색(locationReqDto.getLongitude(), locationReqDto.getLatitude()));
	}

	@GetMapping("/location")
	public CMRespDto<?> 주소검색(String address) {
		return new CMRespDto<>(1, locationService.주소검색(address));
	}
	
	/*
	 * @GetMapping("/location") public CMRespDto<?> 근처주소검색(double longitude, double
	 * latitude) { return new CMRespDto(1, locationService.근처주소검색(longitude,
	 * latitude)); }
	 */

}
