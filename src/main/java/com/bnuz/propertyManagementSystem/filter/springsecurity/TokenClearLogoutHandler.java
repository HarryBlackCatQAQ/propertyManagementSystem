package com.bnuz.propertyManagementSystem.filter.springsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Harry
 * @Date: 2019-09-23 15:07
 * @Version 1.0
 */
public class TokenClearLogoutHandler implements LogoutHandler {

//    private JwtUserService jwtUserService;
//
//    public TokenClearLogoutHandler(JwtUserService jwtUserService) {
//        this.jwtUserService = jwtUserService;
//    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//        authentication = SecurityContextHolder.getContext();
        System.out.println(request);
        System.out.println(response);
        System.err.println("logout：" + SecurityContextHolder.getContext());
        clearToken(authentication);
    }

    protected void clearToken(Authentication authentication) {
        System.err.println(authentication);
        if(authentication == null)
            return;
//        UserDetails user = (UserDetails)authentication.getPrincipal();
//        if(user!=null && user.getUsername()!=null)
//            jwtUserService.deleteUserLoginInfo(user.getUsername());
    }

}