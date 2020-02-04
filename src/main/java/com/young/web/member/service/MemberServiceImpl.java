package com.young.web.member.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.young.web.member.dao.MemberDAO;
import com.young.web.member.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDAO;

	@Inject
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public boolean idcheck(String userid) {
		MemberVO memberVO= memberDAO.getMember(userid);
		if(memberVO==null) {
			return true;	
		}else {
			return false;
		}
		
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		String encodedpassword = bcryptPasswordEncoder.encode(memberVO.getPassword());
		memberVO.setPassword(encodedpassword);
		return memberDAO.insertMember(memberVO);
	}

	@Override
	public MemberVO loginCheck(MemberVO memberVO) {
		MemberVO dbMemberVO = memberDAO.getMember(memberVO.getUserid());
		
		if(bcryptPasswordEncoder.matches(memberVO.getPassword(), dbMemberVO.getPassword())) {
			return dbMemberVO;
		}else {
			return null;
		}
		
	}
	
}
