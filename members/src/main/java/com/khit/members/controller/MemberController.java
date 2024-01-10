package com.khit.members.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.members.DTO.MemberDTO;
import com.khit.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  //생성자 주입
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/join")
	public String joinform() {
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		memberService.insert(memberDTO);
		log.info(""+memberDTO);
		return "/member/login";
		
	}
	@GetMapping("/login")
	public String loginform() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO,
			HttpSession session) {
		
		MemberDTO loginmember = memberService.login(memberDTO);
		if(loginmember != null) {
			session.setAttribute("sessionemail", memberDTO.getEmail());
			return "main";
		}else {
		
		return "/member/login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}

}
