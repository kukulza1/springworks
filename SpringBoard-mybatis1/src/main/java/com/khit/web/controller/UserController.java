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

import com.khit.web.dto.UserDTO;
import com.khit.web.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//ȸ������ ������ ��û
	@GetMapping("/join")
	public String joinForm() {
		return "/user/join";
	}
	//ȸ������ ó��
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO) {
		log.info("userDTO : " + userDTO);
		userService.insert(userDTO);
		return "redirect:/"; // http://localhost:8080/
	}
	//ȸ�� ���
	@GetMapping("/")
	public String userList(Model model) {
		List<UserDTO> userDTOList = userService.findAll();
		model.addAttribute("userlist", userDTOList);
		return "/user/userlist";
	}
	//ȸ�� �󼼺���
	@GetMapping
	public String getUser(@RequestParam("id") long id, Model model) {
		UserDTO userDTO = userService.findById(id);
		model.addAttribute("user", userDTO);
		return "user/userdetail";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}
}
