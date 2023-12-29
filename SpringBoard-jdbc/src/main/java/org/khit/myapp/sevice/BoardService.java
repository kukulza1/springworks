package org.khit.myapp.sevice;

import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.khit.myapp.repository.BoardRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor //생성자주입(DI)
@Service
public class BoardService {
     
	private BoardRepository br; 
	
	public void save(BoardDTO board) {
		br.save(board);
		
		
	}

	public List<BoardDTO> getlistall() {
	
		return br.getlistall();
	}

	public BoardDTO findbyId(Long id) {
			
		return  br.findbyId(id);
	}

}
