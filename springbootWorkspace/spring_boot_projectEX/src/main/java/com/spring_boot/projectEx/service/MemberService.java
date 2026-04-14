package com.spring_boot.projectEx.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.model.IMemberDAO;

@Service
// @Primary // Bean 결정이 모호한 경우 우선 선택됨
@Qualifier("MemberService")
public class MemberService implements IMemberService {

	@Autowired
	IMemberDAO dao;
	@Autowired
	PasswordEncoder pwdEncoder;
	
	// dao에게 id만 전달해서 해당 id의 레코드가 있는지 확인 후 pwd 전달받음
	// 암호화된 pwd와 평문 pwd를 대조해서 같으면 로그 처리 메시지를 컨트롤러에게 전달
	@Override
	public String loginCheck(HashMap<String, Object> map) {
		String encodedPwd = dao.loginCheck((String)map.get("id"));
		String result = "fail";
		String memPwd = (String)map.get("pwd");
		if(encodedPwd != null && pwdEncoder.matches(memPwd, encodedPwd)) {
			result="success";
		}
		return result;
	}
	
	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// 비밀번호 값만 추출해서 암호화
		String encodedPwd = pwdEncoder.encode(dto.getMemPwd());
		dto.setMemPwd(encodedPwd);
		
		dao.insertMember(dto); // 암호화된 비밀번호가 저장됨
	}

}
