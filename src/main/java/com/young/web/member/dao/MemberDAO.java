package com.young.web.member.dao;

import com.young.web.member.model.MemberVO;

public interface MemberDAO {
	
	public int insertMember(MemberVO memberVO);
	public MemberVO getMember(String userid);
}
