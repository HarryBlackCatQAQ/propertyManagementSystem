package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.ComplaintAndSuggestionSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Harry
 * @Date: 2019-09-20 15:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/ComplaintAndSuggestion")
public class ComplaintAndSuggestionController {


    @PostMapping(value = "/create")
    public Result createComplaintAndSuggestionSheet(@RequestBody ComplaintAndSuggestionSheet complaintAndSuggestionSheet){
        return new Result();
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