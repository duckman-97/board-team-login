package com.study.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.study.user.UserVo;

import lombok.Getter;

@Component
@Getter
public class CustomUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;

    private int userNo;
    private String userId;
    private String userPw;
    private String userAuth;
    private String appendDate;
    private String updateDate;
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	
    	
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        
        auth.add(new SimpleGrantedAuthority(this.userAuth));
        
        return Collections.singletonList(new SimpleGrantedAuthority(this.userAuth));
        
    }
    
    

        
    
    
    

	@Override
	public String getPassword() {
		return this.userPw;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}