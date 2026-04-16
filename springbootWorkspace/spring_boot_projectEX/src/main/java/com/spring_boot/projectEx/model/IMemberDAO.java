package com.spring_boot.projectEx.model;

import java.util.HashMap;

import com.spring_boot.projectEx.dto.MemberDTO;

public interface IMemberDAO {
	// public String loginCheck(HashMap<String, Object> map);
	public String loginCheck(String id);
	public String idCheck(String id);
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String id);
}
