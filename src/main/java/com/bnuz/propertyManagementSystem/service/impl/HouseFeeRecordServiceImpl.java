package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.HouseFeeRecordDao;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.HouseFeeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
}