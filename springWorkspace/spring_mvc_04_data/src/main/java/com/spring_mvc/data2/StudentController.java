package com.spring_mvc.data2;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_mvc.DTO.Student;

@Controller
public class StudentController {

	//index 페이지 요청
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//Form  페이지 요청
	@RequestMapping("/student/studentSearchForm")
	public String studentSearchFormView() {
		return "student/studentSearchForm";
	}
	//index에서 studentForm 페이지 요청
	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm";
	}
	//index에서 studentForm2 페이지 요청
	@RequestMapping("/student/studentForm2")
	public String studentFormView2() {
		return "student/studentForm2";
	}
	//index에서 studentForm2 페이지 요청
	@RequestMapping("/student/studentForm2-1")
	public String studentFormView2_1() {
		return "student/studentForm2_1";
	}	
	
	//index에서 studentForm3 페이지 요청
	@RequestMapping("/student/studentForm3")
	public String studentFormView3() {
		return "student/studentForm3";
	}
	//index에서 studentForm4 페이지 요청
	@RequestMapping("/student/studentForm4")
	public String studentFormView4() {
		return "student/studentForm4";
	}
	
	//클라이언트 전송 parameter 처리
	//1. request 객체의 getParameter()
	@RequestMapping("/student/newStudent")
	public String insertStudent(HttpServletRequest request, Model model) {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		model.addAttribute("no",no);
		model.addAttribute("name",name);
		model.addAttribute("year",year);
		
		return "student/studentResult";
	}
	
	//2. @RequestParam 어노테이션 이용 - Request 객체의 파라미터 값을 DI
	//@RequestParam("no") String no == String no = request.getParameter("no")
	@RequestMapping("/student/newStudent2")
	public String insertStudent2(@RequestParam("no") String no,
								 @RequestParam("name") String name,
								 @RequestParam("year") String year,
									Model model) {

		model.addAttribute("no",no);
		model.addAttribute("name",name);
		model.addAttribute("year",year);
		return "student/studentResult";
	}
	
	//2-1. @RequestParam 어노테이션 이용 - Request 객체의 파라미터 값을 DI
	//@RequestParam("no") String no == String no = request.getParameter("no")
	//@RequestParam 어노테이션 생략 가능
	//request 파라미터명과 메소드의 파라미터명이 동일하면,
	//input 태그의 name속성과 메소드의 파라미텨명 동일하면 생략가능
	//스프링은 파라미터명과 동일한 메소드의 파라미터 변수를 찾아서 파라미터 value 전달
	@RequestMapping("/student/newStudent2-1")
	public String insertStudent2_1(String no,
								   String name,
								   String year,
									Model model) {

		model.addAttribute("no",no);
		model.addAttribute("name",name);
		model.addAttribute("year",year);
		return "student/studentResult";
	}	
	
	//3.command 객체 사용 : 메소드에 주입된 Student 객체를 command 객체라고 함
	//요청시 클라이언트로부터 전달된 파라미터명과 command 객체의 필드명이 동일하면
	//command 객체가 주입되면서 setter에 의해 파라미터값으로 초기화 됨
	
	// 파라미터 타입은 String, 객체 필드는가 Date 타입일 경우 요청에러 400이 발생함
	// Date 타입이 command 객체의 필드일 경우 - 클라이언트의 형식을 필드에 추가
	// view에서는 형식 관련한 태그를 사용해야함
	@RequestMapping("/student/newStudent3")
	public String insertStudent3(Student student) {
		
		return "student/studentResult2";
	}
	// command 객체에 필드가 파라미터와 1:1 매핑되지 않는 경우
	/*
	@RequestMapping("/student/newStudent3")
	public String insertStudent3(Student student, 
								 @RequestParam("birth") String birth, 
								 Model model) {
		System.out.println(student.getNo());
		System.out.println(student.getName());
		System.out.println(student.getYear());
		System.out.println(birth);
		
		// command 객체는 뷰까지 전달됨
		// 동일 데이터라면 model은 사용할 필요 없음
		model.addAttribute("no", student.getNo());
		model.addAttribute("name", student.getName());
		model.addAttribute("year", student.getYear());
		
		// command 객체에 필드가 없는 파라미터는 model을 꼭 통해서 전달해야함
		model.addAttribute("birth", birth);
		return "student/studentResult2";
	}*/
	
	// @ModelAttribute 어노테이션 사용해서 command 객체의 이름을 변경
	// student 참조변수가 view로 전달 시 studentInfo로 전달됨
	@RequestMapping("/student/newStudent4")
	public String insertStudent4(@ModelAttribute("studentInfo") Student student) {
		return "student/studentResult3";
	}
	
	// Url을 통해서 전달된 데이터를 추출
	// @PathVariable을 사용
	// @RequestMapping annotation의 uri안에 {}는 결정되지 않은 값 (동적인 url) 
	// {} 내의 key와 파라미터 변수명은 동일해야함
	@RequestMapping("/student/studentDetailView/{stdNo}")
	public String studentDetaiView(@PathVariable String stdNo) {
		System.out.println(stdNo);
		
		return "index";
	}
	
	@RequestMapping("/student/studentDetailView1/{stdNo}/{stdName}/{stdYear}")
	public String studentDetailView1(@PathVariable String stdNo,
									 @PathVariable String stdName,
									 @PathVariable String stdYear) {
		System.out.println(stdNo);
		System.out.println(stdName);
		System.out.println(stdYear);
		
		return "index";
	}
	
	// 검색을 위한 검색 데이터
	// 전달되는 파라미터를 한 번에 모두 주입
	// HashMap<key, value>
	// key: 파라미터명, value: 파라미터값
	@RequestMapping("/student/studentSearch")
	public String studentSearch(@RequestParam HashMap<String, Object> param, Model model) {
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		
		// db와 연결해서 검색 종류와 검색어를 통해서 검색 진행 (결과를 받아왔다고 가정)
		// name 홍길동으로 검색한 결과 2명 존재
		Student vo1 = new Student();
		Student vo2 = new Student();
		
		vo1.setNo("2021001");
		vo1.setName("홍길동");
		vo1.setYear(2);
		
		vo2.setNo("2022002");
		vo2.setName("홍길동");
		vo2.setYear(1);
		
		ArrayList<Student> stdList = new ArrayList<Student>();
		stdList.add(vo1);
		stdList.add(vo2);
		
		model.addAttribute("stdList", stdList);
		
		return "student/stduentSearchResult";
	}
	
	// 요청 처리 후 redirect 진행 메소드: redirect: 접두어 사용
	// 현재 context(data2)가 아닌 다른 context(third)로 redirect
	@RequestMapping("/redirect")
	public String redirect() {
		System.out.println("redirect");
		
		// 뷰 리졸버 api는 redirect:확인하면 프론트컨트롤러에게 redirect:신호 전달
		// 프론트컨트롤러 클라이언트에게 redirect 신호를 보냄 (= 응답) -> 클라이언트 /showInfo를 재요청
		
		// return "redirect:/third/showInfo"; // 현재 context 기준으로 uri를 구성 http://localhost:8080/data2/third/showInfo
		return "redirect:../third/showInfo";
	}
	
	//////////////////////////////////////////////
	// redirect 시 param(data) 전달
	
	// url에 첨부해서 파라미터 전달 : 쿼리스트링 방식
	@RequestMapping("/redirectParam1")
	public String redirectParam() throws Exception {
		String nation = "대한민국1";
		nation = URLEncoder.encode(nation, "UTF-8");
		
		return "redirect:/showRedirectParam/?nation=" + nation;
	}
	
	// model 객체 이용
	@RequestMapping("/redirectParam2")
	public String redirectParam(Model model) {
		model.addAttribute("nation", "대한민국2");
		
		return "redirect:/showRedirectParam";
	}
	
	// RedirectAttributes 객체 이용
	@RequestMapping("/redirectParam3")
	public String redirectParam(RedirectAttributes reAttr) {
		reAttr.addAttribute("nation", "대한민국3");
		
		return "redirect:/showRedirectParam";
	}
	
	// redirect 되는 곳
	@RequestMapping("/showRedirectParam")
	public String showParam(@RequestParam("nation") String nation, Model model) {
		System.out.println(nation);
		model.addAttribute("nation", nation);
		
		return "showRedirectParam";
	}
	
}//클래스 끝

























