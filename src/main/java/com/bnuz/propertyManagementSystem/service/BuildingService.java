package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Building;
import com.bnuz.propertyManagementSystem.model.Result;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 16:11
 * @Version 1.0
 */

public interface BuildingService {

  public Result insert(Building building);

  public Result getById(Integer id);

}
