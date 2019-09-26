package com.bnuz.propertyManagementSystem.filter.springsecurity;

import com.bnuz.propertyManagementSystem.service.redis.JWTRedisService;
import com.bnuz.propertyManagementSystem.util.JwtTokenUtils;
import com.bnuz.propertyManagementSystem.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: Harry
 * @Date: 2019-09-23 00:41
 * @Version 1.0 授权过滤器
 */
@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * 根据token给用户进行授权
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        //获取token
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);

        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // 如果请求头中有token，则进行解析，并且设置认证信息
        boolean isExpiration = JwtTokenUtils.isExpiration(tokenHeader);
        log.info("token是否过期:" + isExpiration);
        if(isExpiration){
            return;
        }

        //设置用户权限
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }



    // 这里从token中获取用户信息并新建一个UsernamePasswordAuthenticationToken
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {

        //获取信息token中的信息都存在了map中
        Map<String,Object> map = JwtTokenUtils.parsingToken(tokenHeader);

        String token = (String) map.get("token");
        String username = (String) map.get("username");

        //检查token
        if(!checkToken(username,token)){
            return null;
        }


        String roles[] = (String[]) map.get("roles");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //添加用户的权限
        for(String s:roles){
            authorities.add(new SimpleGrantedAuthority(s));
        }


        return new UsernamePasswordAuthenticationToken(username, null,
                authorities);
    }

    /**
     * 检查token
     * @param username
     * @param token
     * @return
     */
    private boolean checkToken(String username,String token){
        if(username == null){
            return false;
        }

        JWTRedisService jwtRedisService = SpringUtil.getBean(JWTRedisService.class);
        if(!jwtRedisService.hasToken(username)){
            log.warn("redis中无该token:" + token);
            return false;
        }
        else{

            String redisToken = (String)jwtRedisService.getToken(username);
            if(!token.equals(redisToken)){
                log.warn("redis中" + username + "的token和前端出来的token不一样");
                log.warn("redisToken:" + redisToken);
                log.warn("前端Toekn:" + token);
                return false;
            }
        }

        return true;
    }
}
