package com.bnuz.propertyManagementSystem.dao;

import com.bnuz.propertyManagementSystem.model.FeedbackMessage;
import com.bnuz.propertyManagementSystem.model.FeedbackMessageExample;
import org.springframework.stereotype.Repository;

/**
 * FeedbackMessageDao继承基类
 */
@Repository
public interface FeedbackMessageDao extends MyBatisBaseDao<FeedbackMessage, Integer, FeedbackMessageExample> {
}