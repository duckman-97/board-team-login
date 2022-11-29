package com.study.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	private CommentMapper mapper;
	

	public void CommentRegist(CommentVO vo) {
		mapper.CommentRegist(vo);

	}

	
	public List<CommentVO> getList(int bno) {
		return mapper.getList(bno);
	}

	public int getTotal(int bno) {
		// TODO Auto-generated method stub
		return mapper.getTotal(bno);
	}

	
	public List<CommentVO> myRecord(String writer) {
		return mapper.myRecord(writer);
	}


	public void commentDelete(int cno) {
		mapper.commentDelete(cno);
		
	}
	
	
	public List<CommentVO> getComList(String com_wrtier) {
		return mapper.getComList(com_wrtier);
	}

}