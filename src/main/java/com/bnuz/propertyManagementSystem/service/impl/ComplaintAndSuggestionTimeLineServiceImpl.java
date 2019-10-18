package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetTimelineDao;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimeline;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.ComplaintAndSuggestionTimeLineService;
import com.bnuz.propertyManagementSystem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Harry
 * @Date: 2019-10-16 16:39
 * @Version 1.0
 */
@Service("ComplaintAndSuggestionTimeLineServiceImpl")
public class ComplaintAndSuggestionTimeLineServiceImpl implements ComplaintAndSuggestionTimeLineService {

    @Autowired
    private ComplaintAndSuggestionSheetTimelineDao complaintAndSuggestionSheetTimelineDao;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public Result createComplaintAndSuggestionSheetTimeLine(ComplaintAndSuggestionSheetTimeline complaintAndSuggestionSheetTimeline) {
        complaintAndSuggestionSheetTimeline.setProcessingTime(dateUtil.getNow());
        complaintAndSuggestionSheetTimelineDao.insert(complaintAndSuggestionSheetTimeline);
        return new Result(true, ResultStatusCode.OK,"时间线更新成功!");
    }
}