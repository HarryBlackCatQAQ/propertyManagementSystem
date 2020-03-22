package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.HouseFeeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Harry
 * @Date: 2019-10-25 13:58
 * @Version 1.0
 */
@RequestMapping("/houseFeeRecord")
@RestController
@Api(tags = "物业管理费相关接口")
public class HouseFeeRecordController {

    @Autowired
    private HouseFeeRecordService houseFeeRecordService;

    @GetMapping("/getOwnerUnPayFeesList")
    @ApiOperation("获取未支付物业费列表")
    public Result getOwnerUnPayFeesList(int userId,int pageNum, int pageSize){
        return houseFeeRecordService.getOwnerUnPayFeesList(userId, pageNum, pageSize);
    }

    @GetMapping("/getPayFeesListByPayState")
    @ApiOperation("根据支付状态获取物业费列表")
    public Result getPayFeesListByPayState(int userId,int pageNum,int pageSize,int payState){
        return  houseFeeRecordService.getPayFeesListByPayState(userId, pageNum, pageSize, payState);
    }

    @GetMapping("/getAllPayFeesList")
    @ApiOperation("获取所有物业费列表")
    public Result getAllPayFeesList(int userId,int pageNum,int pageSize){
        return houseFeeRecordService.getAllPayFeesList(userId, pageNum, pageSize);
    }
}