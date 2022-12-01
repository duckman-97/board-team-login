package com.study.user;


import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.message.Message;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */
    @GetMapping
    public String root() {
        return "redirect:/login";
    }

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request,Model model){
    	
        String uri = request.getHeader("Referer");
        if (uri != null && !uri.contains("/login")) {
            request.getSession().setAttribute("prevPage", uri);
        }
        
        
       System.out.println(uri);
    	
        return "user/login";
    }

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/signUp")
    public String signUpForm() {
        return "user/signUp";
    }

    /**
     * 로그인 실패 폼
     * @return
     */
    @GetMapping("/access_denied")
    public String accessDenied() {
        return "user/access_denied";
    }

    /**
     * 회원가입 진행
     * @param userVo
     * @return
     */
    @PostMapping("/signUp")
    public String signUp(UserVo userVo ) {
    	
    	
    	
    	if(userService.checkId(userVo.getUserId()) == null ) {
    		 userService.joinUser(userVo);
 	        return "redirect:login";
    		
    		
    	}
 
    	
    	return "message/alert";
    	
    	
    		
    		
    		
    		
   


    	
       
    }

    

   
}