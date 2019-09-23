package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.model.UserExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * UserDao继承基类
 */
@Repository
public interface UserDao extends MyBatisBaseDao<User, Integer, UserExample> {

    @Select("SELECT * FROM user where userName = #{username} and password = #{password}")
    public User selectByUser(User user);

}