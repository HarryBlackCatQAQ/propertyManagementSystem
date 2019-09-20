package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;

public interface ComplaintAndSuggestionSheetService {
    public Result createComplaintAndSuggestionSheet();

    public Result queryComplaintAndSuggestionSheet();

    public Result updateComplaintAndSuggestionSheet();

    public Result queryComplaintAndSuggestionSheetByRoot();
}
