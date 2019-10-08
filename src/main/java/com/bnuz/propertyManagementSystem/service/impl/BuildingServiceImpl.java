package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.BuildingDao;
import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    synchronized (BuildingServiceImpl.class) {
      buildingDao.saveAndFlush(building);
      return new Result(true, ResultStatusCode.OK, "插入成功");
    }
  }

  @Override
  public Result update(Building building) {
    synchronized (BuildingServiceImpl.class) {
      buildingDao.saveAndFlush(building);
      return new Result(true, ResultStatusCode.OK, "更新成功");
    }
  }

  @Override
  public Result findAll(Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page page = buildingDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  public Result getById(Integer id) {
    Building building = buildingDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", building);
  }

  @Override
  public Result getByUid(Integer uid) {
    Building building = buildingDao.getByUid(uid);
    return new Result(true, ResultStatusCode.OK, "查询成功", building);
  }

}
