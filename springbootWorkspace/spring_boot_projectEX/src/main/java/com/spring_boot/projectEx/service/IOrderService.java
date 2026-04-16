package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;

public interface IOrderService {
	public MemberDTO getMemberInfo(String memId);
	public void insertOrderInfo(OrderInfoDTO dto); // 주문 정보 저장
	public ArrayList<OrderInfoDTO> orderList(String memId);
	public OrderInfoDTO getOrderInfo(String ordNo);
}
