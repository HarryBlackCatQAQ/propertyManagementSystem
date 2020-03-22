package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao继承基类
 */
@Repository
public interface UserDao extends MyBatisBaseDao<User, Integer, UserExample> {

    @Select("SELECT * FROM user where userName = #{username} and password = #{password}")
    public User selectByUser(User user);

    @Select("SELECT * FROM user where userName = #{username}")
    public User selectByUserName(String username);

    @Select("SELECT id,userName,nickName,role FROM user")
    public List<User> selectAllUser();

    @Select("SELECT * FROM user where ${ttype} like '%${content}%'")
    public List<User> selectByType(String ttype,String content);

    @Select("SELECT * FROM user where role = #{role}")
    public List<User> selectByRole(Integer role);

    @Select("SELECT * FROM user where phone like '%${phone}%'")
    public List<User> selectByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM user where id = #{id}")
    public User getById(Integer id);
}