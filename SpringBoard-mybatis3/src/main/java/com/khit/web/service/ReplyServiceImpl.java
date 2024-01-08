package com.khit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.ReplyDTO;
import com.khit.web.mapper.ReplyMapper;

@Service //서비스를 등록하고 빈을 등록함
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyMapper replymapper;

	@Override
	public void insert(ReplyDTO replyDTO) {
		replymapper.insert(replyDTO);
	}

	@Override
	public List<ReplyDTO> getReplyList(Long BoardId) {
		return replymapper.getReplyList(BoardId);
	}

	@Override
	public void delete(Long id) {
		replymapper.delete(id);
	}

	@Override
	public ReplyDTO findById(Long id) {
		return replymapper.findById(id);
		
	}

	@Override
	public void update(ReplyDTO replyDTO) {
		replymapper.update(replyDTO);
	}

}
