package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetDao;
import com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetTimelineDao;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimeline;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.service.ComplaintAndSuggestionSheetService;
import com.bnuz.propertyManagementSystem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author: Harry
 * @Date: 2019-10-13 17:21
 * @Version 1.0
 */
@Transactional
@Service("ComplaintAndSuggestionSheetServiceImpl")
public class ComplaintAndSuggestionSheetServiceImpl implements ComplaintAndSuggestionSheetService {

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private ComplaintAndSuggestionSheetDao complaintAndSuggestionSheetDao;

    @Autowired
    private ComplaintAndSuggestionSheetTimelineDao complaintAndSuggestionSheetTimelineDao;


    @Override
    public Result createComplaintAndSuggestionSheet(ComplaintAndSuggestionSheet complaintAndSuggestionSheet) {
        Date now = dateUtil.getNow();

        complaintAndSuggestionSheet.setSubmitTime(now);
        complaintAndSuggestionSheet.setProcessingTime(now);
        complaintAndSuggestionSheet.setState(ComplaintAndSuggestionSheetService.PENDING);

        complaintAndSuggestionSheetDao.insert(complaintAndSuggestionSheet);

        ComplaintAndSuggestionSheetTimeline timeline = new ComplaintAndSuggestionSheetTimeline();

        timeline.setMessage(complaintAndSuggestionSheet.getMessage());
        timeline.setProcessingTime(now);
        timeline.setProcessingUserNickName(complaintAndSuggestionSheet.getUserNickName());
        timeline.setSheetId(complaintAndSuggestionSheet.getId());

        complaintAndSuggestionSheetTimelineDao.insert(timeline);

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("sheetId",complaintAndSuggestionSheet.getId());
        return new Result(true, ResultStatusCode.OK,"申请成功!",hashMap);
    }

    @Override
    public Result queryComplaintAndSuggestionSheet() {
        return null;
    }

    @Override
    public Result updateComplaintAndSuggestionSheet() {
        return null;
    }

    @Override
    public Result queryComplaintAndSuggestionSheetByRoot() {
        return null;
    }


}