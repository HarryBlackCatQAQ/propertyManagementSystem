package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;

public interface RegisteredService {

    /**
     * 检查是否有该用户名
     * @param username
     * @return
     */
    public Result checkUserName(String username);

    /**
     * 注册该用户
     * @param user
     * @return
     */
    public Result registeredUser(User user);
}
