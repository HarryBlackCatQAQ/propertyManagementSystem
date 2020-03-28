package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimeline;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.ComplaintAndSuggestionTimeLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Harry
 * @Date: 2019-10-16 16:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/ComplaintAndSuggestionTimeLine")
@Api(tags = "投诉建议单时间线相关接口")
public class ComplaintAndSuggestionTimeLineController {

    @Autowired
    private ComplaintAndSuggestionTimeLineService complaintAndSuggestionTimeLineService;

    @PostMapping(value = "/create")
    @ApiOperation("申请投诉时间线插入")
    public Result createComplaintAndSuggestionSheetTimeLine(@RequestBody ComplaintAndSuggestionSheetTimeline complaintAndSuggestionSheetTimeline){
        return complaintAndSuggestionTimeLineService.createComplaintAndSuggestionSheetTimeLine(complaintAndSuggestionSheetTimeline);
    }

    @PostMapping(value ="/update")
    @ApiOperation("投诉建议申请单回馈")
    public Result updateComplaintAndSuggestionSheetTimeLine(@RequestBody ComplaintAndSuggestionSheetTimeline complaintAndSuggestionSheetTimeline){

        return complaintAndSuggestionTimeLineService.updateComplaintAndSuggestionSheetTimeLine(complaintAndSuggestionSheetTimeline);
    }

}