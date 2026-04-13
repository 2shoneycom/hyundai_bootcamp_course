package com.spring_boot.projectEx.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memService;
	
	// 로그인 폼
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 로그인 처리
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) { // 현재 요청 클라이언의 session이 전달
		System.out.println("컨트롤러가 받은 값: " + param.toString());
		String memId = memService.loginCheck(param);
		String result = "fail";
		System.out.println("MemberController -> memId: " + memId);
		// 로그인 세션 처리
		if (memId!=null) {
			session.setAttribute("sid", memId);
			result = "success";
		}
		return result;
	}
	
	// 로그아웃 처리
	@GetMapping("/member/logout")
	public String userLogout(HttpSession session) {
		session.invalidate(); // 요청 클라이언트의 세션을 지움(로그인 유지 안됨)
		return "redirect:/";
	}
	
	// 회원가입 폼 
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	// id 중복 체크 요청 처리
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam String id) {
		String id_res = memService.idCheck(id);
		
		int result = 0;
		if (id_res != null) { // 기존 id가 있음
			result = 1;
		}
		
		return result;
	}
}
