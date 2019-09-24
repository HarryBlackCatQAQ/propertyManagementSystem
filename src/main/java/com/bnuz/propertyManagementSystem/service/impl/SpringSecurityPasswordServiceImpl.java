package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.service.SpringSecurityPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * SpringSecurityPassword加密服务
 *
 * @Author: Harry
 * @Date: 2019-09-20 18:41
 * @Version 1.0
 */

@Service("SpringSecurityPasswordServiceImpl")
public class SpringSecurityPasswordServiceImpl implements SpringSecurityPasswordService {

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