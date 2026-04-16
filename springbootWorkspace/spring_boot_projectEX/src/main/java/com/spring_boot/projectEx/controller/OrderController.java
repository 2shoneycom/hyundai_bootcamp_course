package com.spring_boot.projectEx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;
import com.spring_boot.projectEx.service.ICartService;
import com.spring_boot.projectEx.service.IOrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	@Autowired
	ICartService cartService;
	@Autowired
	IOrderService ordService;
	
	// 주문서 작성 폼 요청
	@PostMapping("/product/orderForm")
	public String orderForm(@RequestParam int[] cartNo,
							@RequestParam int[] cartQty,
							Model model,
							HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		
		// 주문하기 버튼 클릭시 변경된 주문수량을 적용하기 위해 cart의 주문수량을 변경하는 메소드 호출
		cartService.updateCart(cartNo, cartQty);
		
		// 주문서에 출력할 주문자 기본 정보 가져오기
		MemberDTO dto = ordService.getMemberInfo(memId);
		
		// hp 정보
		String[] hp = (dto.getMemHp()).split("-");
		
		model.addAttribute("memDto", dto);
		model.addAttribute("hp1", hp[0]);
		model.addAttribute("hp2", hp[1]);
		model.addAttribute("hp3", hp[2]);
		
		// 연습문제 1 : 장바구니 목록 가져오기
		ArrayList<CartDTO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		return "product/orderForm";
	}
	
	// 주문정보를 파라미로 받아 저장, 주문상품정보는 cart테이블의 상품을 order-product테이블로 이동 (서비스 처리)
	@PostMapping("/product/orderComplete")
	public String orderInsert(OrderInfoDTO orderDto,
							  @RequestParam String hp1,
							  @RequestParam String hp2,
							  @RequestParam String hp3,
							  Model model,
							  HttpSession session) {
		// 전화번호 설정
		String hp = hp1 + "-" + hp2 + "-" + hp3;
		orderDto.setOrdRcvPhone(hp);
		
		// memId 설정
		orderDto.setMemId((String)session.getAttribute("sid"));
		
		// 주문번호 생성 및 설정
		// 주문번호 : 주문날짜시분초_랜덤숫자4개
		long timeNum = System.currentTimeMillis();
		// 날짜 시간 포맷 : MM(월) mm(분) HH(시:24시간제) 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String srtTime = dayTime.format(new Date(timeNum));
		// 랜덤숫자 4개 생성
		String rNum = "";
		for (int i = 1; i <= 4; i++) {
			rNum += (int)(Math.random() * 10);
		}
		String ordNo = srtTime + "_" + rNum;
		orderDto.setOrdNo(ordNo);
		
		ordService.insertOrderInfo(orderDto);
		model.addAttribute("ordNo", ordNo);
		
		return "product/orderCompleteView";
	}
	
	// 현재 로그인한 회원의 주문 목록
	@GetMapping("/order/orderListView")
	public String orderList(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid");
		ArrayList<OrderInfoDTO> ordList = ordService.orderList(memId); 
		model.addAttribute("ordList", ordList);
				
		return "product/orderListView";
	}
	
	// 주문 내역 상세 보기
	@GetMapping("/order/detailViewOrder/{ordNo}")
	public String orderDetail(@PathVariable String ordNo, Model model) {
		OrderInfoDTO orderDto = ordService.getOrderInfo(ordNo);
		model.addAttribute("orderDto", orderDto);
		
		return "product/orderDetailView";
	}
}
