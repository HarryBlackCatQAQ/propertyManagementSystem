package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimeline;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimelineExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ComplaintAndSuggestionSheetTimelineDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetTimelineDao extends MyBatisBaseDao<ComplaintAndSuggestionSheetTimeline, Integer, ComplaintAndSuggestionSheetTimelineExample> {

    @Select("SELECT * FROM complaint_and_suggestion_sheet_timeline WHERE sheetId = #{sheetId}")
    public List<ComplaintAndSuggestionSheetTimeline> selectComplaintAndSuggestionSheetTimelineBySheetId(int sheetId);
}