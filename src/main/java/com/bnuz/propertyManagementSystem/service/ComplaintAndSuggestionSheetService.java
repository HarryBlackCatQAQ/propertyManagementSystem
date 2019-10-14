package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.Result;

public interface ComplaintAndSuggestionSheetService {
    public Result createComplaintAndSuggestionSheet(ComplaintAndSuggestionSheet complaintAndSuggestionSheet);

    public Result queryComplaintAndSuggestionSheet();

    public Result updateComplaintAndSuggestionSheet();

    public Result queryComplaintAndSuggestionSheetByRoot();

    public final static String PENDING = "待处理";

    public final static String DEALING = "正在处理";

    public final static String COMPLETE = "已完成";
}
