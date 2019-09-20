package com.bnuz.propertyManagementSystem.util;

import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: Harry
 * @Date: 2019-09-20 01:36
 * @Version 1.0
 */
@Component
public class SHA1Util {

    /**
     * 使用SHA1算法加密密码
     * @param psw
     * @return
     */
    public String encodePassword(String psw) {
        if(StringUtils.isEmpty(psw)){
            return null;
        }else{
            System.out.println("dasdsadsadda");
            System.out.println("dsds");
            return DigestUtils.sha1DigestAsHex(psw);
        }
    }
}