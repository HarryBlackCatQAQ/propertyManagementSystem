package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.PropertyDao;
import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
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
      return new Result(true, ResultStatusCode.OK,"插入成功!");
    }
  }

  @Override
  public Result getById(Integer id) {
    Property property = propertyDao.getById(id);
    System.out.println(property);
    System.out.println(property.getBuildings());
    return new Result(true, ResultStatusCode.OK, "查询成功", property);
  }

}
