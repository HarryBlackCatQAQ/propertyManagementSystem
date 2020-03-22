package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.HouseFeePublishRecord;
import com.bnuz.propertyManagementSystem.model.Result;

public interface HouseFeePublishRecordService {

  public Result findAll(Integer pageNum, Integer pageSize);

  public Result publish(HouseFeePublishRecord houseFeePublishRecord);

}
