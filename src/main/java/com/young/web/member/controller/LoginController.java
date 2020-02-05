package com.young.web.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.young.web.member.model.MemberVO;
import com.young.web.member.service.MemberService;

@Controller
public class LoginController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		return "/member/login";
	}
	
	@RequestMapping(value="/logincheck" ,method=RequestMethod.POST)
	public String loginCheck(MemberVO memberVO, HttpSession session,RedirectAttributes redirect) {
		if(session!=null) {
			session.removeAttribute("member");
		}
		
		MemberVO checkedMemberVO = memberService.loginCheck(memberVO);
		if(checkedMemberVO!=null) {
			session.setAttribute("member", checkedMemberVO);
			return "redirect:/";
		}else {
			redirect.addFlashAttribute("msgs", "로그인에 실패하였습니다.");
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
