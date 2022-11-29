package com.study.comment;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class CommentVO {
	
	private int cno;
	private int bno;
	private String writer;
	private String content;
	
	
	

	
}
