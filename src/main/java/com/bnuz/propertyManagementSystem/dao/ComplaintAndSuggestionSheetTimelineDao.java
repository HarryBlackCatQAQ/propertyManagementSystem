package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimeline;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetTimelineExample;
import org.springframework.stereotype.Repository;

/**
 * ComplaintAndSuggestionSheetTimelineDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetTimelineDao extends MyBatisBaseDao<ComplaintAndSuggestionSheetTimeline, Integer, ComplaintAndSuggestionSheetTimelineExample> {
}