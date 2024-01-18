package com.khit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.board.dto.BoardDTO;
import com.khit.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
	private final BoardService boardservice;
	
	@GetMapping("/write")
	public String writeform() {
		
		
		return"/board/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		System.out.println(boardDTO);
		boardservice.insert(boardDTO);
		return"redirect:/board/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDTO> boardDTO = boardservice.findAll();
		model.addAttribute("boardlist", boardDTO);
		return"/board/list";
	}
	@GetMapping
	public String getOne(@RequestParam("id") Integer id, Model model) {
		BoardDTO board = boardservice.findById(id);
		model.addAttribute("board", board);
		return"/board/detail";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id) {
		boardservice.delete(id);
		return"redirect:/board/list";
	}
	@GetMapping("/update")
	public String updateform(@RequestParam("id") Integer id, Model model) {
		BoardDTO board = boardservice.findById(id);
		model.addAttribute("board", board);
		return "/board/update";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardservice.update(boardDTO);
		
		return "redirect:/board/list";
	}

	
	
	
	
	
}


















