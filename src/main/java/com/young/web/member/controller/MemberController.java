package com.young.web.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.young.web.member.model.MemberVO;
import com.young.web.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	MemberService memberService;
	
	@RequestMapping(value="/signup" ,method=RequestMethod.GET)
	public String signupPage() {
		return "/member/signup";
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public String signup(MemberVO memberVO,RedirectAttributes redirect) {
		
		String regExp_id="^[0-9a-z]{1,13}$";
		if(memberVO.getUserid().matches(regExp_id) && memberVO.getPassword().length()>=8&&memberVO.getPassword().length()<=15) {
			memberService.insertMember(memberVO);
			return "redirect:/login";
		 }else {
			 redirect.addFlashAttribute("msgs", "회원가입에 실패하였습니다.");
			 return "redirect:/";
		 }
		
		
		
		
		
	}
	
}
