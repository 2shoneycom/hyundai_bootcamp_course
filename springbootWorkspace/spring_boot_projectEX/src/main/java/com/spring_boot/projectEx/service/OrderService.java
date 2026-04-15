package com.spring_boot.projectEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.model.IOrderDAO;

@Service
@Primary
public class OrderService implements IOrderService {
	@Autowired
	IOrderDAO dao;

	@Override
	public MemberDTO getMemberInfo(String memId) {
		return dao.getMemberInfo(memId);
	}
	
}
