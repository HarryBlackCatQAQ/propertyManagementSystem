package com.bnuz.propertyManagementSystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintAndSuggestionSheetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ComplaintAndSuggestionSheetExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("complaint_and_suggestion_sheet.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProprietorIdIsNull() {
            addCriterion("complaint_and_suggestion_sheet.proprietorId is null");
            return (Criteria) this;
        }

        public Criteria andProprietorIdIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.proprietorId is not null");
            return (Criteria) this;
        }

        public Criteria andProprietorIdEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId =", value, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId <>", value, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId >", value, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId >=", value, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId <", value, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId <=", value, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId in", values, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId not in", values, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId between", value1, value2, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andProprietorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId not between", value1, value2, "proprietorId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("complaint_and_suggestion_sheet.`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("complaint_and_suggestion_sheet.submitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.submitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.submitTime in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.submitTime not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.submitTime between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.submitTime not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeIsNull() {
            addCriterion("complaint_and_suggestion_sheet.processingTime is null");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.processingTime is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime =", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeNotEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime <>", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeGreaterThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime >", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime >=", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeLessThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime <", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeLessThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime <=", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.processingTime in", values, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeNotIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.processingTime not in", values, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.processingTime between", value1, value2, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeNotBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.processingTime not between", value1, value2, "processingTime");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNull() {
            addCriterion("complaint_and_suggestion_sheet.userNickName is null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.userNickName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName =", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName <>", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName >", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName >=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName <", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName <=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.userNickName not like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.userNickName in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.userNickName not in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.userNickName between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.userNickName not between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andSheetTypeIsNull() {
            addCriterion("complaint_and_suggestion_sheet.sheetType is null");
            return (Criteria) this;
        }

        public Criteria andSheetTypeIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.sheetType is not null");
            return (Criteria) this;
        }

        public Criteria andSheetTypeEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType =", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType <>", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType >", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType >=", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType <", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType <=", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType like", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.sheetType not like", value, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.sheetType in", values, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.sheetType not in", values, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.sheetType between", value1, value2, "sheetType");
            return (Criteria) this;
        }

        public Criteria andSheetTypeNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.sheetType not between", value1, value2, "sheetType");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("complaint_and_suggestion_sheet.message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("complaint_and_suggestion_sheet.title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet.title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet.title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet.title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet.title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet.title not between", value1, value2, "title");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}