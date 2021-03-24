package com.cos.blog.service;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blog.domain.auth.Auth;
import com.cos.blog.domain.auth.AuthRepository;
import com.cos.blog.domain.location.LocationRepository;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.dto.auth.AuthSaveReqDto;
import com.cos.blog.web.dto.auth.AuthUpdateReqDto;

import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final AuthRepository authRepository;

	@Transactional(readOnly = true)
	public Auth 인증코드확인(String phoneNumber) {
		return authRepository.인증코드확인(phoneNumber);
	}

	@Transactional
	public void 인증코드삭제(int id) { // 삭제는 리턴이 필요없다. 삭제하다가 오류나서 GlobalException으로 처리하면 됨.
		authRepository.deleteById(id);
	}

	@Transactional
	public Auth 인증코드수정(int id, AuthUpdateReqDto authUpdateReqDto) {
		
		// 영속화
		Auth authEntity = authRepository.findById(id).orElseThrow(() -> {
					return new IllegalArgumentException("id를 찾을 수 없습니다.");
				});
		authEntity.setAuthCode(authUpdateReqDto.getAuthCode());
		
		String api_key = "NCSC5OTLTRBTVJGQ";
		String api_secret = "9PM4JVY0UYUPGEM0CAPKZNZXUACM38PK";
		Message coolsms = new Message(api_key, api_secret);
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", authEntity.getPhoneNumber());
		params.put("from", "01024091611");
		params.put("type", "SMS");
		params.put("text", "[당근마켓] 인증번호 [" +  authEntity.getAuthCode() + "]" + "*타인에게 절대 노출하지마세요.");
		params.put("app_version", "test app 1.2"); // application name and version

		/*
		 * try { JSONObject obj = (JSONObject) coolsms.send(params);
		 * System.out.println("메시지가 전송되었습니다."); System.out.println(obj); } catch
		 * (CoolsmsException e) { System.out.println(e.getMessage());
		 * System.out.println(e.getCode()); }
		 */

		return authEntity;
	}

	@Transactional
	public Auth 문자전송후save(AuthSaveReqDto authSaveReqDto) {
		String api_key = "NCSC5OTLTRBTVJGQ";
		String api_secret = "9PM4JVY0UYUPGEM0CAPKZNZXUACM38PK";
		Message coolsms = new Message(api_key, api_secret);
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", authSaveReqDto.getPhoneNumber());
		params.put("from", "01024091611");
		params.put("type", "SMS");
		params.put("text", "[당근마켓] 인증번호 [" + authSaveReqDto.getAuthCode() + "]" + "*타인에게 절대 노출하지마세요.");
		params.put("app_version", "test app 1.2"); // application name and version

		/*
		 * try { JSONObject obj = (JSONObject) coolsms.send(params);
		 * System.out.println("메시지가 전송되었습니다."); System.out.println(obj); } catch
		 * (CoolsmsException e) { System.out.println(e.getMessage());
		 * System.out.println(e.getCode()); }
		 */

		Auth authEntity = authRepository.save(authSaveReqDto.toEntity());
		return authEntity;
	}
}
