package com.young.web.member.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.web.member.service.MemberService;

@RestController
public class RestMemberController {

	@Inject
	MemberService memberService;
	
	@RequestMapping("/idcheck")
	public boolean idCheck(@RequestParam String userid) {
		System.out.println(userid);
		
		
		return memberService.idcheck(userid);
	}
}
