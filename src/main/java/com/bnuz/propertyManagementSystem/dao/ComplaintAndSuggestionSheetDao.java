package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetExample;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ComplaintAndSuggestionSheetDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetDao extends MyBatisBaseDao<ComplaintAndSuggestionSheet, Integer, ComplaintAndSuggestionSheetExample> {

    @Select("SELECT * FROM complaint_and_suggestion_sheet where proprietorId = #{proprietorId}")
    @Results(id="sheetMap" ,value = {
            @Result(column = "id",property = "imageList",
                    many = @Many(select = "com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetImageDao.selectComplaintAndSuggestionSheetImageBySheetId")),
            @Result(column = "id",property = "timelineList",
                    many = @Many(select = "com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetTimelineDao.selectComplaintAndSuggestionSheetTimelineBySheetId"))
    })
    public List<ComplaintAndSuggestionSheet> selectUserComplaintAndSuggestionSheetListByUserId(int proprietorId);

    @Select("SELECT * FROM complaint_and_suggestion_sheet where state = #{state}")
    @ResultMap(value = "sheetMap")
    public List<ComplaintAndSuggestionSheet> selectUserComplaintAndSuggestionSheetListByState(String state);

    @Select("SELECT * FROM complaint_and_suggestion_sheet")
    @ResultMap(value = "sheetMap")
    public List<ComplaintAndSuggestionSheet> selectUserComplaintAndSuggestionSheetList();

}