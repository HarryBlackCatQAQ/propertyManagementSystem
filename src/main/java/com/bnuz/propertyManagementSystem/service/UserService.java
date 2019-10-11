package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;

public interface UserService {

    /**
     * 获取全部用户 可分页
     * @param pageNum
     * @param size
     * @return
     */
    public Result getAllUser(int pageNum,int size);

    /**
     * 根据id 删除User
     * @param id
     * @return
     */
    public Result delUser(int id);

    /**
     * 跟新User
     * @param user
     * @return
     */
    public Result updateUser(User user);

    /**
     * 根据类型查询User
     * @param ttype
     * @param content
     * @return
     */
    public Result selectByType(String ttype,String content,int pageNum,int size);
}
