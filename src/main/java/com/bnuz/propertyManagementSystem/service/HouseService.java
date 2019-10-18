package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.House;
import com.bnuz.propertyManagementSystem.model.Result;

/**
 * @Author: Hovees
 * @Date: 2019-10-14 16:41
 * @Version 1.0
 */

public interface HouseService {

  /**
   * 新增房屋
   * @param house
   * @return
   */
  Result insert(House house);

  /**
   * 更新房屋信息
   * @param house
   * @return
   */
  Result update(House house);

  /**
   * 删除房屋
   * @param house
   * @return
   */
  Result delete(House house);

  /**
   * 获取所有房屋信息并分页
   * @param pageNum
   * @param pageSize
   * @return
   */
  Result findAll(Integer pageNum, Integer pageSize);

  /**
   * 根据楼栋Id获取所有房屋信息并分页
   * @param pageNum
   * @param pageSize
   * @param buildingId
   * @return
   */
  Result findAllByBuildingId(Integer pageNum, Integer pageSize, Integer buildingId);

  /**
   * 根据主键ID获取房屋信息
   * @param id
   * @return
   */
  Result getById(Integer id);

  /**
   * 根据楼栋Uid和门牌号查找房屋
   * @param buildingId
   * @param number
   * @return
   */
  Result getByBuildingIdAndNumber(Integer buildingId, Integer number);

}