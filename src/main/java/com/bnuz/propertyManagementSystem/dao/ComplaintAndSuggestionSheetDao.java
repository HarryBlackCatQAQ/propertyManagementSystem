package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetExample;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ComplaintAndSuggestionSheetDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetDao extends MyBatisBaseDao<ComplaintAndSuggestionSheet, Integer, ComplaintAndSuggestionSheetExample> {

    @Select("SELECT * FROM complaint_and_suggestion_sheet where proprietorId = #{proprietorId}")
    @Results({
            @Result(column = "id",property = "imageList",
                    many = @Many(select = "com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetImageDao.selectComplaintAndSuggestionSheetImageBySheetId")),
            @Result(column = "id",property = "timelineList",
                    many = @Many(select = "com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetTimelineDao.selectComplaintAndSuggestionSheetTimelineBySheetId"))
    })
    public List<ComplaintAndSuggestionSheet> selectUserComplaintAndSuggestionSheetListByUserId(int proprietorId);
}