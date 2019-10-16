package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 16:11
 * @Version 1.0
 */

public interface BuildingService {

  /**
   * 新增楼栋
   * @param building
   * @return
   */
  Result insert(Building building);

  /**
   * 更新楼栋信息
   * @param building
   * @return
   */
  Result update(Building building);

  /**
   * 获取所有楼栋并分页
   * @param pageNum
   * @param pageSize
   * @return
   */
  Result findAll(Integer pageNum, Integer pageSize);

  /**
   * 根据楼盘Uid获取所有楼栋并分页
   * @param pageNum
   * @param pageSize
   * @param propertyId
   * @return
   */
  Result findAllByPropertyId(Integer pageNum, Integer pageSize, Integer propertyId);

  /**
   * 根据id获取楼栋
   * @param id
   * @return
   */
  Result getById(Integer id);

}
