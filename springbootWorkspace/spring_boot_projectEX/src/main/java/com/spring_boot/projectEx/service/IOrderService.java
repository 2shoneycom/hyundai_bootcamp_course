package com.spring_boot.projectEx.service;

import com.spring_boot.projectEx.dto.MemberDTO;

public interface IOrderService {
	public MemberDTO getMemberInfo(String memId);
}
