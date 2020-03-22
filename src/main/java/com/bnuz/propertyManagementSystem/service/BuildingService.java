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
   * 删除楼栋
   * @param building
   * @return
   */
  Result delete(Building building);

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
   * 获取所有楼栋
   * @return
   */
  Result findAll();

  /**
   * 根据楼盘id获取所有楼栋并分页
   * @param pageNum
   * @param pageSize
   * @param propertyId
   * @return
   */
  Result findAllByPropertyId(Integer pageNum, Integer pageSize, Integer propertyId);

  /**
   * 根据楼盘id获取所有楼栋按名字排序
   * @param propertyId
   * @return
   */
  Result findAllByPropertyIdOrderByName(Integer propertyId);

  /**
   * 根据楼盘id获取所有楼栋按名字排序并分页
   * @param pageNum
   * @param pageSize
   * @param propertyId
   * @return
   */
  Result findAllByPropertyIdOrderByName(Integer pageNum, Integer pageSize, Integer propertyId);

  /**
   * 根据id获取楼栋
   * @param id
   * @return
   */
  Result getById(Integer id);

  /**
   * 根据楼盘id获取第一个楼栋
   * @param propertyId
   * @return
   */
  Result getFirstByPropertyId(Integer propertyId);

  /**
   * 根据名字获取楼栋
   * @param buildingName
   * @return
   */
  Result getByName(String buildingName);

  /**
   * 检查当前楼盘楼栋名字是否可用
   * @param propertyId
   * @param buildingName
   * @return
   */
  Result checkPropertyBuildingName(Integer propertyId, String buildingName);

}
