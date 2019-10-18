package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.BuildingDao;
import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
  public Result delete(Building building) {
    synchronized (BuildingServiceImpl.class) {
      buildingDao.delete(building);
      return new Result(true, ResultStatusCode.OK, "删除成功");
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
  @Transactional(readOnly = true)
  public Result findAll(Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page page = buildingDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  @Transactional(readOnly = true)
  public Result findAllByPropertyId(Integer pageNum, Integer pageSize, Integer propertyId) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page page = buildingDao.findAllByPropertyId(pageable, propertyId);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  @Transactional(readOnly = true)
  public Result findAllByPropertyIdOrderByName(Integer pageNum, Integer pageSize,
      Integer propertyId) {
    Sort sort = new Sort(Direction.ASC, "name");
    Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
    Page page = buildingDao.findAllByPropertyId(pageable, propertyId);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getById(Integer id) {
    Building building = buildingDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", building);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getByName(String buildingName) {
    Building building = buildingDao.getByName(buildingName);
    return new Result(true, ResultStatusCode.OK, "查询成功", building);
  }

  @Override
  @Transactional(readOnly = true)
  public Result checkPropertyBuildingName(Integer propertyId, String buildingName) {
    Building building = buildingDao.getByNameAndPropertyId(buildingName, propertyId);
    if(building != null) {
      return new Result(false, ResultStatusCode.OK, "楼栋名字已存在");
    }
    return new Result(true, ResultStatusCode.OK, "楼栋名字可用");
  }

}
