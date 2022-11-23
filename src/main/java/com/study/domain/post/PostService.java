package com.study.domain.post;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.study.dto.SearchDto;
import com.study.paging.Pagination;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	String path;
	private final PostMapper postMapper;
	
	
    @Transactional
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }
    
    public PostResponse findPostById(final Long id) {
        return postMapper.findById(id);
    }
    
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }
    
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }
    
    
   
    
    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {

        int count = postMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
    
    
    
    
    
    
    public String pathMaker(Map<String, Object> queryParams){

    path = "";
    
    	
    	
    	
 	   queryParams.forEach((key, value)->{
       	
		   
		   
		   if(!key.equals("id")) {
			   
			   
			   if(key.equals("page")) {
				   
				   path+=key + "=" + value ;
				   
			   }else {
			   
			   
			  path+= "&"+key + "=" + value ;
			   
			   }
			   
			   
		   }
		   
		   
	      });
    	
    	
    	
    	
    	return path;
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    


}
