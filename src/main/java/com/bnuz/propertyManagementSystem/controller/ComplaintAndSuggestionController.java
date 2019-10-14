package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.ComplaintAndSuggestionSheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Harry
 * @Date: 2019-09-20 15:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/ComplaintAndSuggestion")
@Api(tags = "投诉建议单相关接口")
public class ComplaintAndSuggestionController {

    @Autowired
    private ComplaintAndSuggestionSheetService complaintAndSuggestionSheetService;


    @PostMapping(value = "/create")
    @ApiOperation("获取投诉建议单")
    public Result createComplaintAndSuggestionSheet(@RequestBody ComplaintAndSuggestionSheet complaintAndSuggestionSheet){
        return complaintAndSuggestionSheetService.createComplaintAndSuggestionSheet(complaintAndSuggestionSheet);
    }

    @PostMapping(value = "/query")
    public Result queryComplaintAndSuggestionSheet(){
        return new Result();
    }

    @PostMapping(value = "/update")
    public Result updateComplaintAndSuggestionSheet(){
        return new Result();
    }

    @PostMapping(value = "/queryRt")
    public Result queryComplaintAndSuggestionSheetByRoot(){
        return new Result();
    }

    @PostMapping(value ="/updateFeedBack")
    public Result updateFeedBack(){
        return new Result();
    }
}