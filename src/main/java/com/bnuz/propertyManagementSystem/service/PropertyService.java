package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 13:41
 * @Version 1.0
 */

public interface PropertyService {

  /**
   * 新增楼盘
   * @param property
   * @return
   */
  Result insert(Property property);

  /**
   * 更新楼盘信息
   * @param property
   * @return
   */
  Result update(Property property);

  /**
   * 获取所有楼盘并分页
   * @param pageNum
   * @param pageSize
   * @return
   */
  Result findAll(Integer pageNum, Integer pageSize);

  /**
   * 根据id获取楼盘
   * @param id
   * @return
   */
  Result getById(Integer id);

  /**
   * 根据uid获取楼盘
   * @param uid
   * @return
   */
  Result getByUid(Integer uid);

}
