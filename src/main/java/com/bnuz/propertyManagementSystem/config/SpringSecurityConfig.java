package com.bnuz.propertyManagementSystem.config;

import com.bnuz.propertyManagementSystem.filter.springsecurity.JWTAuthenticationFilter;
import com.bnuz.propertyManagementSystem.filter.springsecurity.JWTAuthorizationFilter;
import com.bnuz.propertyManagementSystem.filter.springsecurity.JWTLogoutFilter;
import com.bnuz.propertyManagementSystem.filter.springsecurity.TokenClearLogoutHandler;
import com.bnuz.propertyManagementSystem.service.springsecurity.impl.MyUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * SpringSecurityConfig配置
 *
 * @Author: Harry
 * @Date: 2019-09-23 00:42
 * @Version 1.0
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义UserDetailsService 获取数据库中用户基本信息，和权限
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsServiceImpl();
    }

    /**
     * 密码加密 采用SHA-256 + 随机盐 + 密钥对密码进行加密
     * 密码进行hash处理，得到密码的hash值，然后将其与从数据库中查询到的密码hash值进行比较
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 告诉AuthenticationManager要调用的userDetailsService和bCryptPasswordEncoder密码加密
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
    }

    /**
     * SpringSecurity主要配置 配置api接口的权限和自定义的认证、授权等过滤器的添加
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()

                // 测试用资源，需要验证了的用户才能访问
                .antMatchers("/tasks/**").authenticated()
                // 需要角色为xxx才能删除访问的资源
                .antMatchers("/test/t1").hasAnyRole("0","1","2")
                .antMatchers("/test/t2").hasAnyRole("1","2")
                .antMatchers("/test/t3").hasAnyRole("2")
                // 其他都放行了
                .anyRequest().permitAll()
                .and()

                //添加过滤器
                //登录认证过滤器
                .addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
                //用户api授权过滤器
                .addFilter(new JWTAuthorizationFilter(authenticationManagerBean()))
                //登出过滤器
                .addFilter(new JWTLogoutFilter("/logout",tokenClearLogoutHandler()))
                // 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }

    @Bean
    public TokenClearLogoutHandler tokenClearLogoutHandler(){
        return new TokenClearLogoutHandler();
    }

    /**
     * 跨域设置
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
