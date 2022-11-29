package com.study.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	
	
	void CommentRegist(CommentVO vo);
	
	
	List<CommentVO> getList(int bno);
	
	
	int getTotal(int bno);
	
	
	List<CommentVO> myRecord(String writer);
	
	void commentDelete(int cno);
	

	
	
	
	
	
	 List<CommentVO> getComList(String wrtier);
}
