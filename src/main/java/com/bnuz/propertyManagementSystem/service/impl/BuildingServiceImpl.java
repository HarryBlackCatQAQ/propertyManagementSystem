package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.BuildingDao;
import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 16:11
 * @Version 1.0
 */

@Transactional
@Service
public class BuildingServiceImpl implements BuildingService {

  @Autowired
  private BuildingDao buildingDao;

  @Override
  public Result insert(Building building) {
    buildingDao.saveAndFlush(building);
    return new Result(true, ResultStatusCode.OK, "插入成功");
  }

  @Override
  public Result getById(Integer id) {
    Building building = buildingDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", building);
  }
}
