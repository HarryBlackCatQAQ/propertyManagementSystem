package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimeline;
import com.bnuz.propertyManagementSystem.model.Result;

public interface ComplaintAndSuggestionTimeLineService {

    public Result createComplaintAndSuggestionSheetTimeLine(ComplaintAndSuggestionSheetTimeline complaintAndSuggestionSheetTimeline);

    public Result updateComplaintAndSuggestionSheetTimeLine(ComplaintAndSuggestionSheetTimeline complaintAndSuggestionSheetTimeline);
}
