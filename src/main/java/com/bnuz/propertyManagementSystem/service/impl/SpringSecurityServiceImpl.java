package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.service.SpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: Harry
 * @Date: 2019-09-20 18:41
 * @Version 1.0
 */

@Service("SpringSecurityServiceImpl")
public class SpringSecurityServiceImpl implements SpringSecurityService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean matchesPassword(String rawPassword, String encodePassword) {
        return bCryptPasswordEncoder.matches(rawPassword,encodePassword);
    }
}