package com.spring_boot.projectEx.model;

import com.spring_boot.projectEx.dto.MemberDTO;

public interface IOrderDAO {
	public MemberDTO getMemberInfo(String memId);
}
