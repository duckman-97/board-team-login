package com.study.domain.post;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.SearchDto;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	@GetMapping("/post/write.do")
	public String openPostWrite(@RequestParam(value = "id" , required = false) final Long id,
			Model model) {
		
		if(id != null) {
			PostResponse post = postService.findPostById(id);
			model.addAttribute("post",post);
			
		}
		
		return "post/write";
		
		
		
		
		
	}
	
	
	
	
	   @PostMapping("/post/save.do")
	    public String savePost(final PostRequest params) {
	        postService.savePost(params);
	        return "redirect:/post/list.do";
	    }
	   
	   
	   
	   
	   
	   
	   
	   @GetMapping("/post/list.do")
	   public String openPostList(@ModelAttribute("params") final SearchDto params,Model model ) {
		   
	        PagingResponse<PostResponse> response = postService.findAllPost(params);
	        model.addAttribute("response", response);
		  
		   
		   return "post/list";
		}
	   
	   
	   
	   
	   @GetMapping("/post/view.do")
	   public String openPostView(@RequestParam final Long id,Model model) {
		   
		   PostResponse post = postService.findPostById(id);
		   model.addAttribute("post",post);
		   return "post/view";
		   
		   
		   
		   
	   }
	   
	   @PostMapping("/post/update.do")
	   public String updatePost(final PostRequest params) {
		   postService.updatePost(params);
		   return "redirect:/post/list.do";
		   
	   }
	   
	   
	   
	   
	   
	   
	   @PostMapping("/post/delete.do")
	   public String deletePost(@RequestParam final Long id,
			   @RequestParam final Map<String, Object> queryParams
			   ) {
		   
		   String path = postService.pathMaker(queryParams);
		   
		   
		
		   
		   
		   
		   
		   	postService.deletePost(id);
		   	return "redirect:/post/list.do?" + path;
	   }
	   
	   
	 
	   
	   
	   
	   
	
	   
	   
	   
}
