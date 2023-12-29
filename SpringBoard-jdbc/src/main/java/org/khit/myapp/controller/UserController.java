package org.khit.myapp.controller;

import javax.servlet.http.HttpSession;

import org.khit.myapp.dto.UserDTO;
import org.khit.myapp.sevice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
@Controller
public class UserController {
	
	private UserService uservice;
	
	@GetMapping("/join")
	public String join() {
		return "/user/join";
	}
	
	@PostMapping("/join")
	public String join(UserDTO userDTO) {
		log.info("userdto=" +userDTO);
	     uservice.save(userDTO);
		return "redirect:/";		
	}
	
	@GetMapping("/login")
	public String login() {		
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(UserDTO userDTO, HttpSession session) {
		boolean loginresult = uservice.login(userDTO);
		if(loginresult) {
			session.setAttribute("sessionid", userDTO.getUserid());
			return "redirect:/board/list";
		}else {
			return "/user/login";
		}	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	
		return "redirect:/";
	}

}
