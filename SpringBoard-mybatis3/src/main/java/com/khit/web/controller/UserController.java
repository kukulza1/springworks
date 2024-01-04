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
	
	@Autowired //�˻��غ���
	private UserService userService;

	//ȸ�� ���� ������ ��û
	@GetMapping("/join")
	public String joinForm() {
		return "/user/join";
	}
	
	//ȸ�� ���� ó��
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO ) {
		log.info("userDTO:" + userDTO);
		userService.insert(userDTO);
		return "redirect:/user/login"; //http://localhost:8080/
	}
	
	//ȸ�� ���
	@GetMapping("/")
	public String userlist(Model model) {
		List<UserDTO> userDTOList = userService.findAll();
		model.addAttribute("userList", userDTOList);
		return "/user/userlist";
	}
	
	//ȸ�� �󼼺��� - getUser() /user?id
	@GetMapping
	public String getUser(@RequestParam("id") Long id,
			Model model) {
		UserDTO userDTO = userService.findById(id);
		model.addAttribute("user", userDTO);
		return "/user/userdetail";
	}
	
	//�α��� ������
	@GetMapping("/login")
	public String loginForm() {
		return "/user/login";
	}
	
	//�α��� ó��
	//���� �߱�
	@PostMapping("/login")
	public String login(@ModelAttribute UserDTO userDTO,
			HttpSession session) {
		//�α��� ����, ���� 
		UserDTO loginUser = userService.login(userDTO);
		if(loginUser != null) {
			session.setAttribute("sessionId", userDTO.getUserId());
			return "redirect:/";
		}else {
			return "/user/login";
		}
	}
	
	//�α׾ƿ� ó��
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //���� ����
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
		return "redirect:/user/update?id=" + userDTO.getId(); //���߿� ��� �̰� �����
		
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id ) {
		
		userService.delete(id);		
		return"redirect:/user/"; //�����̷�Ʈ: ������ �������̵� ���ΰ�ħó�� �ۿ��Ѵ�.
		
	}
	//���̵� �ߺ��˻�
	@PostMapping("/checkuserid")
	public @ResponseBody String CheckuserId(@RequestParam("userId") String userId) {
		
		String checkResult = userService.checkuserId(userId);
		log.info(userId);
		return checkResult; //usable or notusable ����
	}
}






