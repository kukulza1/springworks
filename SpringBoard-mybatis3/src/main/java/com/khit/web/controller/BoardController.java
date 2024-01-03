package com.khit.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.BoardDTO;
import com.khit.web.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  //������ ����
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	 //��������
	private BoardService boardService;
	
	//�۾��� ������
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//�۾���
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO=" + boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/board/"; //boardlist.jsp�� �̵�
	}
	
	//�۸��
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.findall();
		model.addAttribute("boardlist",boardDTOList);
		return "board/boardlist";
	}
	
	@GetMapping
	public String getBoard(@RequestParam("id") Long id,
			 Model model) {
		
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return"/board/detail";
	}
	
}











