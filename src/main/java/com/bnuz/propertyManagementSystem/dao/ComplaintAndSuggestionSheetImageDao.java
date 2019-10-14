package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetImage;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetImageExample;
import org.springframework.stereotype.Repository;

/**
 * ComplaintAndSuggestionSheetImageDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetImageDao extends MyBatisBaseDao<ComplaintAndSuggestionSheetImage, Integer, ComplaintAndSuggestionSheetImageExample> {
}