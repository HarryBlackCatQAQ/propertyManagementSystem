package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.HouseDao;
import com.bnuz.propertyManagementSystem.model.House;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Hovees
 * @Date: 2019-10-14 16:41
 * @Version 1.0
 */

@Transactional
@Service
public class HouseServiceImpl implements HouseService {

  @Autowired
  private HouseDao houseDao;

  @Override
  public Result insert(House house) {
    synchronized (HouseServiceImpl.class) {
      houseDao.saveAndFlush(house);
      return new Result(true, ResultStatusCode.OK, "插入成功");
    }
  }

  @Override
  public Result update(House house) {
    synchronized (HouseServiceImpl.class) {
      houseDao.saveAndFlush(house);
      return new Result(true, ResultStatusCode.OK, "更新成功");
    }
  }

  @Override
  public Result delete(House house) {
    synchronized (HouseServiceImpl.class) {
      houseDao.delete(house);
      return new Result(true, ResultStatusCode.OK, "删除成功");
    }
  }

  @Override
  @Transactional(readOnly = true)
  public Result findAll(Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page page = houseDao.findAll(pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  @Transactional(readOnly = true)
  public Result findAllByBuildingId(Integer pageNum, Integer pageSize, Integer buildingId) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page page = houseDao.findAllByBuildingIdOrderByNumber(buildingId, pageable);
    return new Result(true, ResultStatusCode.OK, "查询成功", page);
  }

  @Override
  @Transactional(readOnly = true)
  public Result getById(Integer id) {
    House house = houseDao.getById(id);
    return new Result(true, ResultStatusCode.OK, "查询成功", house);
  }

  @Override
  @Transactional(readOnly = true)
  public Result checkBuildingHouseNumber(Integer buildingId, Integer number) {
    House house = houseDao.getByBuildingIdAndNumber(buildingId, number);
    if(house != null) {
      return new Result(false, ResultStatusCode.OK, "房屋门牌号已存在");
    }
    return new Result(true, ResultStatusCode.OK, "房屋门牌号可用");
  }

}
