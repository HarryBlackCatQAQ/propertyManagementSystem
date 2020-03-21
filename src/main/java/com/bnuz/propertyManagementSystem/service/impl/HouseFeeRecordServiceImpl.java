package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.HouseFeeRecordDao;
import com.bnuz.propertyManagementSystem.model.HouseFeeRecord;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.HouseFeeRecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author: Harry
 * @Date: 2019-10-25 14:09
 * @Version 1.0
 */
@Service("HouseFeeRecordServiceImpl")
@Transactional
public class HouseFeeRecordServiceImpl implements HouseFeeRecordService {

    @Autowired
    private HouseFeeRecordDao houseFeeRecordDao;

    @Override
    public Result getOwnerUnPayFeesList(int userId,int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page page = houseFeeRecordDao.findAllUnPayFeesListByUserId(userId,pageable);

        return new Result(true, ResultStatusCode.OK, "查询成功", page);
    }

    @Override
    public Result searchOwnerTimeRangeFeesList(int userId, int pageNum, int pageSize, int fromYear,
        int fromMonth, int toYear, int toMonth) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page page = houseFeeRecordDao.searchOwnerTimeRangeFeesList(userId,fromYear,fromMonth,toYear,toMonth,pageable);

        return new Result(true, ResultStatusCode.OK, "查询成功", page);
    }

    @Override
    public Result searchUserBuildingFeesList(int pageNum, int pageSize, int userId, int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page page = houseFeeRecordDao.searchUserBuildingFeesList(userId,buildingId,fromYear,fromMonth,toYear,toMonth,pageable);

        return new Result(true, ResultStatusCode.OK, "查询成功", page);
    }

    @Override
    public Result searchBuildingFeesList(int pageNum, int pageSize, int buildingId, int fromYear,
        int fromMonth, int toYear, int toMonth) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page page = houseFeeRecordDao.searchBuildingFeesList(buildingId,fromYear,fromMonth,toYear,toMonth,pageable);

        return new Result(true, ResultStatusCode.OK, "查询成功", page);
    }

    @Override
    public Result searchUserFeesList(int pageNum, int pageSize, int userId, int fromYear,
        int fromMonth, int toYear, int toMonth) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page page = houseFeeRecordDao.searchUserFeesList(userId,fromYear,fromMonth,toYear,toMonth,pageable);

        return new Result(true, ResultStatusCode.OK, "查询成功", page);
    }

    @Override
    public Result searchHouseFeesList(int pageNum, int pageSize, int houseId, int fromYear,
        int fromMonth, int toYear, int toMonth) {
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            Page page = houseFeeRecordDao.searchHouseFeesList(houseId,fromYear,fromMonth,toYear,toMonth,pageable);

            return new Result(true, ResultStatusCode.OK, "查询成功", page);
    }

    @Override
    public Result checkHouseFeeClear(int houseId) {
        List<HouseFeeRecord> houseFeeRecords = houseFeeRecordDao.checkHouseFeeClear(houseId);

        int size = houseFeeRecords.size();
        Boolean result = (size == 0) ? true : false;

        return new Result(true, ResultStatusCode.OK, "物业费未缴清", result);
    }
}