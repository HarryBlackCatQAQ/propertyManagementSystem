package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-10-05 00:32
 * @Version 1.0
 */
@Service("UserSerivceImpl")
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result getAllUser(int pageNum,int size) {

        //只有紧跟在 PageHelper.startPage 方法后的第一个 MyBatis 的查询(select)方法会被分页
        PageHelper.startPage(pageNum,size);
        List<User> list = userDao.selectAllUser();


        //用PageInfo对结果进行包装 可以获取到User的总共条数，根据pageNum和size分的总页数等等基本信息，具体可以自行打印出来看
        PageInfo<User> page = new PageInfo<User>(list);

        return new Result(true,4,"",page);
    }

}