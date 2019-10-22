package com.bnuz.propertyManagementSystem.filter.springsecurity;

import com.alibaba.fastjson.JSON;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.redis.JWTRedisService;
import com.bnuz.propertyManagementSystem.service.redis.LoginFailureTimesService;
import com.bnuz.propertyManagementSystem.util.JwtTokenUtils;
import com.bnuz.propertyManagementSystem.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出过滤器
 *
 * @Author: Harry
 * @Date: 2019-09-23 14:13
 * @Version 1.0
 */
@Slf4j
public class JWTLogoutFilter extends LogoutFilter {

    public JWTLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler... handlers) {
        super(logoutSuccessHandler, handlers);
    }

    public JWTLogoutFilter(String logoutSuccessUrl, LogoutHandler... handlers) {
        super(logoutSuccessUrl, handlers);
    }


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;


        if (requiresLogout(request, response)) {
            // 检测到用户请求了退出当前登录,现在执行退出登录逻辑
            String token = request.getHeader("authorization").replace(JwtTokenUtils.TOKEN_PREFIX,"");

            String username = "";
            log.info("token:" + token);
            try{
                username = (String)JwtTokenUtils.parsingToken(token).get("username");
            }catch (Exception e){
                log.error(e.toString());
            }

            JWTRedisService jwtRedisService = SpringUtil.getBean(JWTRedisService.class);
            boolean flag = jwtRedisService.delToken(username);

            log.info("" + flag);

            LoginFailureTimesService loginFailureTimesService = SpringUtil.getBean(LoginFailureTimesService.class);
            loginFailureTimesService.delLoginFailTimes(request.getRemoteAddr());

            Result result = new Result(true, ResultStatusCode.OK,"logout success");
            String json = JSON.toJSONString(result);
            response.getWriter().write(json);
            return;
        }

        // 不是用户请求退出登录的情况，继续执行 filter chain 。
        chain.doFilter(request, response);
    }
}