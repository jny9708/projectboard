package com.young.web.member.service;

import com.young.web.member.model.MemberVO;

public interface MemberService {
	public boolean idcheck(String userid);
	public int insertMember(MemberVO memberVO );
	public MemberVO loginCheck(MemberVO memberVO);
	
}
