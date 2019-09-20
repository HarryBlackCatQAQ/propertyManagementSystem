package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheetExample;
import org.springframework.stereotype.Repository;

/**
 * ComplaintAndSuggestionSheetDao继承基类
 */
@Repository
public interface ComplaintAndSuggestionSheetDao extends MyBatisBaseDao<ComplaintAndSuggestionSheet, Integer, ComplaintAndSuggestionSheetExample> {
}