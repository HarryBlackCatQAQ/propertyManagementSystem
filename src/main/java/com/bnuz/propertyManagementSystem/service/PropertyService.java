package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Property;
import com.bnuz.propertyManagementSystem.model.Result;

/**
 * @Author: Hovees
 * @Date: 2019-10-07 13:41
 * @Version 1.0
 */

public interface PropertyService {

  public Result insert(Property property);

  public Result getById(Integer id);

}
