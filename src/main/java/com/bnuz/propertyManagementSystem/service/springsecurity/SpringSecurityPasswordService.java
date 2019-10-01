package com.bnuz.propertyManagementSystem.service.springsecurity;

public interface SpringSecurityPasswordService {

    /**
     * 加密密码
     * @param password 需加密密码
     * @return
     */
    public String encodePassword(String password);

    /**
     * 匹配密码
     * @param rawPassword 需匹配密码
     * @param encodePassword  已加密密码
     * @return
     */
    public boolean matchesPassword(String rawPassword,String encodePassword);
}
