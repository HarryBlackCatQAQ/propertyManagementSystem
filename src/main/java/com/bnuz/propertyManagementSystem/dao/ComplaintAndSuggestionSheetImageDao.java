package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetImage;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetImageExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ComplaintAndSuggestionSheetImageDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetImageDao extends MyBatisBaseDao<ComplaintAndSuggestionSheetImage, Integer, ComplaintAndSuggestionSheetImageExample> {

    @Select("SELECT * FROM complaint_and_suggestion_sheet_Image WHERE sheetId = #{sheetId}")
    public List<ComplaintAndSuggestionSheetImage> selectComplaintAndSuggestionSheetImageBySheetId(int sheetId);
}