package com.bnuz.propertyManagementSystem.filter.springsecurity;

import com.alibaba.fastjson.JSON;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.redis.JWTRedisService;
import com.bnuz.propertyManagementSystem.util.JwtTokenUtils;
import com.bnuz.propertyManagementSystem.springsecurity.JwtUser;
import com.bnuz.propertyManagementSystem.util.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: Harry
 * @Date: 2019-09-23 00:40
 * @Version 1.0 登录认证过滤器
 */
@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        //设置登录url
        super.setFilterProcessesUrl("/auth/login");
    }

    /**
     * 获取用户权限
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // 从输入流中获取到登录的信息
        try {
            User loginUser = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证成功生成token 并返回token
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // 查看源代码会发现调用getPrincipal()方法会返回一个实现了`UserDetails`接口的对象
        // 所以就是JwtUser啦
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();

        //生成根据JwtUser生成token
        String token = creatTokenByJwtUser(jwtUser);

        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的格式应该是 `Bearer token`
        response.setHeader("token", token);
        response.setHeader("Access-Control-Expose-Headers", "token");

        Result result = new Result(true, ResultStatusCode.OK,"login success");
        String json = JSON.toJSONString(result);
        response.getWriter().write(json);
    }

    /**
     * 生成token
     * @param jwtUser
     * @return
     */
    private String creatTokenByJwtUser(JwtUser jwtUser){
        String role = "";

        // 获取jwtUser中的权限
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();

        //拼接权限表
        int counter = 0;
        for (GrantedAuthority authority : authorities){
            if(counter++ != 0){
                role += " ";
            }
            role += authority.getAuthority();
        }

        log.info("用户" + jwtUser.getUsername() + "权限:" + role);

        //生成token
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role,false);

        //将token存进redis
        saveTokenInRedis(jwtUser,token);

        return JwtTokenUtils.TOKEN_PREFIX + token;
    }

    /**
     * token存进redis
     * @param jwtUser
     * @param token
     */
    private void saveTokenInRedis(JwtUser jwtUser,String token){
        //由于该过滤器无法注入Spring [未知原因] 所以手动获取需要的相关bean
        JWTRedisService jwtRedisService = SpringUtil.getBean(JWTRedisService.class);
        jwtRedisService.saveToken(jwtUser.getUsername(),token);
    }

    /**
     * 这是验证失败 设置response返回给前端
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Result result = new Result(false, ResultStatusCode.LOGINERROR,"username or password is wrong!");

        String json = JSON.toJSONString(result);
        response.getWriter().write(json);
    }
}
