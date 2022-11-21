package com.study.user;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 로그인
   public  UserVo getUserAccount(String userId);

    // 회원가입
    void saveUser(UserVo userVo);
    
    
   
    
}