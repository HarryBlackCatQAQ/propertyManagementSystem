package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.PropertyDao;
import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.PropertyService;
import java.util.List;
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
  public Result delete(Property property) {
    synchronized (PropertyServiceImpl.class) {
      propertyDao.delete(property);
      return new Result(true, ResultStatusCode.OK, "删除成功");
    }
  }

  @Override
  @Transactional(readOnly = true)
  public Result findAll(Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum,pageSize);
    Page page = propertyDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getAllProperty() {
    List<Property> properties = propertyDao.findAllByOrderByName();
    return new Result(true, ResultStatusCode.OK, "查询成功", properties);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getFirst() {
    Property property = propertyDao.getFirstBy();
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getById(Integer id) {
    Property property = propertyDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getByUid(Long uid) {
    Property property = propertyDao.getByUid(uid);
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getByName(String propertyName) {
    Property property = propertyDao.getByName(propertyName);
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

  @Override
  @Transactional(readOnly = true)
  public Result checkPropertyName(String propertyName) {
    Property property = propertyDao.getByName(propertyName);
    if(property != null) {
      return new Result(false, ResultStatusCode.OK, "楼盘名字已存在");
    }
    return new Result(true, ResultStatusCode.OK, "楼盘名字可用");
  }

}
