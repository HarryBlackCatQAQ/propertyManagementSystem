package com.bnuz.propertyManagementSystem.filter.springsecurity;

import com.alibaba.fastjson.JSON;
import com.bnuz.propertyManagementSystem.dto.UserLoginDto;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.ValidateCodeService;
import com.bnuz.propertyManagementSystem.service.redis.UserLoginDtoService;
import com.bnuz.propertyManagementSystem.springsecurity.JwtUser;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import com.bnuz.propertyManagementSystem.util.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Harry
 * @Date: 2019-10-22 18:17
 * @Version 1.0
 */
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if((StringUtils.equals("/auth/login", httpServletRequest.getRequestURI()) ||
                StringUtils.equals("/PropertyManagementSystem/auth/login", httpServletRequest.getRequestURI()))
                && StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(), "post")) {
            HttpSession session = httpServletRequest.getSession();

            UserLoginDto loginUser = new ObjectMapper().readValue(httpServletRequest.getInputStream(), UserLoginDto.class);
            UserLoginDtoService userLoginDtoService = SpringUtil.getBean(UserLoginDtoService.class);
            userLoginDtoService.save(loginUser,session.getId());

//            System.err.println("@@@@:" + loginUser);

//            String ip = httpServletRequest.getRemoteAddr();

            String ip = session.getId();
            if(isCheckValidateCode(ip)){
                if(!checkValidateCode(ip,loginUser)){
                    Result result = new Result(false, ResultStatusCode.VALIDATE_CODE_ERROR,"ValidateCode error!");
                    String json = JSON.toJSONString(result);
                    httpServletResponse.getWriter().write(json);
                    return;
                }
            }

        }
        // 3. 校验通过，就放行
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }



    private boolean checkValidateCode(String ip,UserLoginDto loginUser){
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);

//        System.err.println(ValidateCodeService.VALIDATE_CODE_PER + ip);
//        System.err.println("validateCodeInRedis:" + redisUtil.get(ValidateCodeService.VALIDATE_CODE_PER + ip));
//        System.err.println(loginUser.getValidateCode());
        String validateCodeInRedis = (String)redisUtil.get(ValidateCodeService.VALIDATE_CODE_PER + ip);
        if(validateCodeInRedis == null){
            return false;
        }


        return validateCodeInRedis.equals(loginUser.getValidateCode());
    }

    private boolean isCheckValidateCode(String ip){
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);

        Object o = redisUtil.get(ip);
        if(o == null){
            return false;
        }

        int times = (int)o;
        if(times < 5){
            return false;
        }

        return true;

    }
}