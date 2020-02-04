package com.young.web.member.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.young.web.member.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	private String namespace ="com.young.web.member";

	@Inject
	SqlSessionTemplate sqlsession;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		return sqlsession.insert(namespace + ".insertMember", memberVO);
	}

	@Override
	public MemberVO getMember(String userid) {
		return sqlsession.selectOne(namespace + ".getMember", userid);
	} 
}
