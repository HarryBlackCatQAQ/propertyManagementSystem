package com.bnuz.propertyManagementSystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintAndSuggestionSheetTimelineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ComplaintAndSuggestionSheetTimelineExample() {
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
            addCriterion("complaint_and_suggestion_sheet_timeline.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSheetIdIsNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId is null");
            return (Criteria) this;
        }

        public Criteria andSheetIdIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId is not null");
            return (Criteria) this;
        }

        public Criteria andSheetIdEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId =", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId <>", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId >", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId >=", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId <", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId <=", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId in", values, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId not in", values, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId between", value1, value2, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.sheetId not between", value1, value2, "sheetId");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeIsNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime is null");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime =", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeNotEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime <>", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeGreaterThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime >", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime >=", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeLessThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime <", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeLessThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime <=", value, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime in", values, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeNotIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime not in", values, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime between", value1, value2, "processingTime");
            return (Criteria) this;
        }

        public Criteria andProcessingTimeNotBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingTime not between", value1, value2, "processingTime");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameIsNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName is null");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName =", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName <>", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName >", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName >=", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName <", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName <=", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameLike(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName like", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName not like", value, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName in", values, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName not in", values, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName between", value1, value2, "processingUserNickName");
            return (Criteria) this;
        }

        public Criteria andProcessingUserNickNameNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet_timeline.processingUserNickName not between", value1, value2, "processingUserNickName");
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