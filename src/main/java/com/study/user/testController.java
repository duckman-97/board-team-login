package com.study.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
	
	
	@GetMapping("/member")
	public String onlyMember() {
		
		return "member.html";
		
	}
	
	
	
	
	@GetMapping("/all")
	public String fromAll(Model model) {
		model.addAttribute("msg","hello");
		
		
		return "user/all.html";
		
		
	}
	
	
	
	
}
