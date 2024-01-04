package com.khit.web.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.UserDTO;
import com.khit.web.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired //검색해보기
	private UserService userService;

	//회원 가입 페이지 요청
	@GetMapping("/join")
	public String joinForm() {
		return "/user/join";
	}
	
	//회원 가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO ) {
		log.info("userDTO:" + userDTO);
		userService.insert(userDTO);
		return "redirect:/user/login"; //http://localhost:8080/
	}
	
	//회원 목록
	@GetMapping("/")
	public String userlist(Model model) {
		List<UserDTO> userDTOList = userService.findAll();
		model.addAttribute("userList", userDTOList);
		return "/user/userlist";
	}
	
	//회원 상세보기 - getUser() /user?id
	@GetMapping
	public String getUser(@RequestParam("id") Long id,
			Model model) {
		UserDTO userDTO = userService.findById(id);
		model.addAttribute("user", userDTO);
		return "/user/userdetail";
	}
	
	//로그인 페이지
	@GetMapping("/login")
	public String loginForm() {
		return "/user/login";
	}
	
	//로그인 처리
	//세션 발급
	@PostMapping("/login")
	public String login(@ModelAttribute UserDTO userDTO,
			HttpSession session) {
		//로그인 성공, 실패 
		UserDTO loginUser = userService.login(userDTO);
		if(loginUser != null) {
			session.setAttribute("sessionId", userDTO.getUserId());
			return "redirect:/";
		}else {
			return "/user/login";
		}
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 삭제
		return "redirect:/";
	}
	@GetMapping("/update")
	public String userupdate(HttpSession session ,Model model) {
		String userId = (String) session.getAttribute("sessionId");
		UserDTO userDTO = userService.findByUserId(userId);
		model.addAttribute("user", userDTO);
		return"/user/userupdate";	
	}
	@PostMapping("/update")
	public String update(@ModelAttribute UserDTO userDTO) {
		userService.updateuser(userDTO);
		return "redirect:/user/update?id=" + userDTO.getId(); //나중에 경로 이거 물어볼것
		
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id ) {
		
		userService.delete(id);		
		return"redirect:/user/"; //리다이렉트: 강제로 페이지이동 새로고침처럼 작용한다.
		
	}
	//아이디 중복검사
	@PostMapping("/checkuserid")
	public @ResponseBody String CheckuserId(@RequestParam("userId") String userId) {
		
		String checkResult = userService.checkuserId(userId);
		log.info(userId);
		return checkResult; //usable or notusable 리턴
	}
}






