package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;

public interface HouseFeeRecordService {

    public Result getOwnerUnPayFeesList(int userId,int pageNum, int pageSize);

    public Result getPayFeesListByPayState(int userId,int pageNum,int pageSize,int payState);

    public Result getAllPayFeesList(int userId,int pageNum,int pageSize);
}
