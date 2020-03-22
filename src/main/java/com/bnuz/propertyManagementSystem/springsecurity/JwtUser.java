package com.bnuz.propertyManagementSystem.springsecurity;

import com.bnuz.propertyManagementSystem.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: Harry
 * @Date: 2019-09-23 00:38
 * @Version 1.0
 */
public class JwtUser extends User implements UserDetails {


    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser() {
    }

    /**
     *  写一个能直接使用user创建jwtUser的构造器 并赋予权限
     * @param user
     */
    public JwtUser(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setNickname(user.getNickname());
        this.setId(user.getId());
        this.setPhone(user.getPhone());
        this.setEmailAddress(user.getEmailAddress());


        Collection<GrantedAuthority> authorities2 = new ArrayList<>();

        for(int i = user.getRole() ;i >= 0;i--){
            authorities2.add(new SimpleGrantedAuthority("ROLE_"+ i));
        }
        authorities = authorities2;
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    // 获取权限信息，目前博主只会拿来存角色。。
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 账号是否未过期，默认是false，记得要改一下
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否未锁定，默认是false，记得也要改一下
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 账号凭证是否未过期，默认是false，记得还要改一下
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 这个有点抽象不会翻译，默认也是false，记得改一下
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 我自己重写打印下信息看的


    @Override
    public String toString() {
        return super.toString() + "JwtUser{" +
                "authorities=" + authorities +
                '}';
    }
}

