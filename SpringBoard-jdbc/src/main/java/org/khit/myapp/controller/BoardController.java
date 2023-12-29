package org.khit.myapp.controller;



import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.khit.myapp.sevice.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@Controller //bean 객체로 등록
public class BoardController {
	
	//생성자 주입 new
	
	//private BoardRepository boardRepository;
	private BoardService bservice;

	@GetMapping("/write")
	public String writeForm() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO=" + boardDTO);
		bservice.save(boardDTO);
		return "redirect:/board/list";
	}
	@GetMapping("/list")
	 public String getListAll(Model model) {
        List<BoardDTO> boardDTOList = bservice.getlistall();
        model.addAttribute("boardList",boardDTOList);
        return "/board/list";
    }
	@GetMapping
	public String getone(@RequestParam("id") Long id, Model model) {
		BoardDTO boardDTO = bservice.findbyId(id);
		model.addAttribute("board",boardDTO);
		return "/board/detail";
	}
	
	}
















