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

    @GetMapping("/searchOwnerTimeRangeFeesList")
    @ApiOperation("搜索时间范围内数据列表")
    public Result searchOwnerTimeRangeFeesList(int userId, int pageNum, int pageSize,
        int fromYear, int fromMonth, int toYear, int toMonth) {
        return houseFeeRecordService.searchOwnerTimeRangeFeesList(userId, pageNum, pageSize,
            fromYear, fromMonth, toYear, toMonth);
    }

    @GetMapping("/searchUserBuildingFeesList")
    @ApiOperation("搜索业主楼栋物业费列表")
    public Result searchUserBuildingFeesList(int pageNum, int pageSize, int userId, int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth) {
        return houseFeeRecordService.searchUserBuildingFeesList(pageNum, pageSize, userId, buildingId,
            fromYear, fromMonth, toYear, toMonth);
    }

    @GetMapping("/searchBuildingFeesList")
    @ApiOperation("搜索楼栋时间范围内物业费列表")
    public Result searchBuildingFeesList(int pageNum, int pageSize, int buildingId,
        int fromYear, int fromMonth, int toYear, int toMonth) {
        return houseFeeRecordService.searchBuildingFeesList(pageNum, pageSize, buildingId,
            fromYear, fromMonth, toYear, toMonth);
    }

    @GetMapping("/searchUserFeesList")
    @ApiOperation("搜索用户时间范围内物业费列表")
    public Result searchUserFeesList(int userId, int pageNum, int pageSize,
        int fromYear, int fromMonth, int toYear, int toMonth) {
        return houseFeeRecordService.searchUserFeesList(userId, pageNum, pageSize, fromYear, fromMonth, toYear, toMonth);
    }

    @GetMapping("/searchHouseFeesList")
    @ApiOperation("搜索房屋时间范围内物业费列表")
    public Result searchHouseFeesList(int pageNum, int pageSize, int houseId, int fromYear,
        int fromMonth, int toYear, int toMonth){
        return houseFeeRecordService.searchHouseFeesList(pageNum, pageSize, houseId, fromYear, fromMonth, toYear, toMonth);
    }

    @GetMapping("/checkHouseFeeClear")
    @ApiOperation("检查房屋物业费是否缴清")
    public Result checkHouseFeeClear(int houseId) {
        return houseFeeRecordService.checkHouseFeeClear(houseId);
    }

}