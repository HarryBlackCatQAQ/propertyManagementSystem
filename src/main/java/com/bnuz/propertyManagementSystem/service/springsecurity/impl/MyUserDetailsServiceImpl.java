package com.bnuz.propertyManagementSystem.service.springsecurity.impl;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.springsecurity.JwtUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义SpringSecurity UserDetailsService 获取用户数据、权限
 *
 * @Author: Harry
 * @Date: 2019-09-23 00:38
 * @Version 1.0
 */
@Slf4j
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    /**
     * 从数据库获取数据和权限 并转化为JwtUser
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.selectByUserName(s);

        logF(user,s);


        if(user == null){
            return new JwtUser();
        }
        return new JwtUser(user);
    }

    private void logF(User user,String s){
        if(user == null){
            log.warn("登录用户:" + s + " 该用户不存在!");
        }
        else{
            log.info("登录用户:" + user.toString());
        }
    }


}
