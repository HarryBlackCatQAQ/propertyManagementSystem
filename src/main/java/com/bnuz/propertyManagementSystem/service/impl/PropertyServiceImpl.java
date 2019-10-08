package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.PropertyDao;
import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 13:41
 * @Version 1.0
 */

@Transactional
@Service
public class PropertyServiceImpl implements PropertyService {

  @Autowired
  private PropertyDao propertyDao;

  @Override
  public Result insert(Property property) {
    synchronized (PropertyServiceImpl.class){
      propertyDao.saveAndFlush(property);
      return new Result(true, ResultStatusCode.OK,"插入成功");
    }
  }

  @Override
  public Result update(Property property) {
    synchronized (PropertyServiceImpl.class) {
      propertyDao.saveAndFlush(property);
      return new Result(true, ResultStatusCode.OK,"更新成功");
    }
  }

  @Override
  public Result findAll(Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum,pageSize);
    Page page = propertyDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  public Result getById(Integer id) {
    Property property = propertyDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

  @Override
  public Result getByUid(Integer uid) {
    Property property = propertyDao.getByUid(uid);
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

}
