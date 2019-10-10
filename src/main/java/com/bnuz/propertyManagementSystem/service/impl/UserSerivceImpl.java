package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-10-05 00:32
 * @Version 1.0
 */
@Transactional
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

        return new Result(true, ResultStatusCode.OK,"查询成功",page);
    }

    @Override
    public Result delUser(int id) {

        synchronized (UserSerivceImpl.class){
            int res = userDao.deleteByPrimaryKey(id);

            if(res == 1) {
                return new Result(true, ResultStatusCode.OK, "删除成功");
            }
            else{
                return new Result(false, ResultStatusCode.ERROR, "删除失败");
            }
        }

    }

    @Override
    public Result updateUser(User user) {
        synchronized (UserSerivceImpl.class){

              User resUser = userDao.selectByPrimaryKey(user.getId());

              resUser.setNickname(user.getNickname());
              resUser.setRole(user.getRole());
              resUser.setUsername(user.getUsername());

            userDao.updateByPrimaryKey(resUser);

            return new Result(true,ResultStatusCode.OK,"更新成功");
        }
    }

    @Override
    public Result selectByType(String ttype, String content,int pageNum,int size) {

        if(ttype.equals("1")){
            ttype = "userName";
        }
        else if(ttype.equals("2")){
            ttype = "nickName";
        }

        PageHelper.startPage(pageNum,size);
        List<User> list;
        if(ttype.equals("3")){
            list = userDao.selectByRole(changeRole(content));
        }
        else{
            list = userDao.selectByType(ttype,content);
        }


        PageInfo<User> page = new PageInfo<User>(list);

        return new Result(true, ResultStatusCode.OK,"查询成功",page);
    }

    private int changeRole(String content){
        if(content.equals("业主")){
            return 0;
        }
        else if(content.equals("物业管理员")){
            return 1;
        }
        else{
            return 2;
        }
    }

}