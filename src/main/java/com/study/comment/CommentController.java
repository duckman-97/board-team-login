package com.study.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/Comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	
	//댓글 입력
	@PostMapping("/InsertComment")
	public String InsertComment(@RequestBody CommentVO vo,HttpSession session) {
	
			
			
			service.CommentRegist(vo);
	
			return "InsertSuccess";
		
	}
	
	
	


	//댓글 목록
	@GetMapping("/CommentList/{bno}")
	public Map<String, Object> getList(@PathVariable int bno, Model model) {
		
		
		List<CommentVO> list = service.getList(bno);
		int total = service.getTotal(bno);
		
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", total);
		
		return map;
	}
	
	
	//댓글 삭제
	@GetMapping("/commentDelete/{cno}")
	public void deleteComment(@PathVariable int cno) {
	
		
		service.commentDelete(cno);
		
		
		
		
		
		
	}
	
	
	
	
	//댓글 갯수
	@GetMapping("/commentCount/{bno}")
	public int getCount(@PathVariable int bno) {
		int commentCount = service.getTotal(bno);
		
		
		
		
		
		
		
		
		
		return commentCount;
		
		
		
	}
	

	
	
	
	
}