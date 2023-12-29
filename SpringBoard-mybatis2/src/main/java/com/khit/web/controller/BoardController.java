package com.khit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.BoardDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j              
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@GetMapping("/write")
	public String writeform() {
		return "/board/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		bs.insert(boardDTO);
		return "redirect:/";
	}
}
