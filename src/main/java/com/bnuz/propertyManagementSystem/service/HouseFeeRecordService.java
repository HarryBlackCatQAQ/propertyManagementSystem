package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;

public interface HouseFeeRecordService {

    public Result getOwnerUnPayFeesList(int userId,int pageNum, int pageSize);

    public Result searchOwnerTimeRangeFeesList(int userId, int pageNum, int pageSize,
        int fromYear, int fromMonth, int toYear, int toMonth);

    public Result searchUserBuildingFeesList(int pageNum, int pageSize, int userId, int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth);

    public Result searchBuildingFeesList(int pageNum, int pageSize, int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth);

    public Result searchUserFeesList(int pageNum, int pageSize, int userId,
        int fromYear, int fromMonth, int toYear, int toMonth);

    public Result searchHouseFeesList(int pageNum, int pageSize, int houseId, int fromYear,
        int fromMonth, int toYear, int toMonth);

    public Result checkHouseFeeClear(int houseId);

}
