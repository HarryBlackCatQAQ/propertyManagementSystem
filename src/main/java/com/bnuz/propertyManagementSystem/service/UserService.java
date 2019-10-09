package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;

public interface UserService {

    /**
     * 获取全部用户 可分页
     * @param pageNum
     * @param size
     * @return
     */
    public Result getAllUser(int pageNum,int size);
}
