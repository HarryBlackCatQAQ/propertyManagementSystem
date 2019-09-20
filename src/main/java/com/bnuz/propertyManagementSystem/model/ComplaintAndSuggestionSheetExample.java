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

        public Criteria andProprietoridIsNull() {
            addCriterion("complaint_and_suggestion_sheet.proprietorId is null");
            return (Criteria) this;
        }

        public Criteria andProprietoridIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.proprietorId is not null");
            return (Criteria) this;
        }

        public Criteria andProprietoridEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId =", value, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId <>", value, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId >", value, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId >=", value, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId <", value, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId <=", value, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId in", values, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId not in", values, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId between", value1, value2, "proprietorid");
            return (Criteria) this;
        }

        public Criteria andProprietoridNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet.proprietorId not between", value1, value2, "proprietorid");
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

        public Criteria andSubmittimeIsNull() {
            addCriterion("complaint_and_suggestion_sheet.submitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.submitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime =", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime <>", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime >", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime >=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime <", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.submitTime <=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.submitTime in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.submitTime not in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.submitTime between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.submitTime not between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeIsNull() {
            addCriterion("complaint_and_suggestion_sheet.processingTime is null");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet.processingTime is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime =", value, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeNotEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime <>", value, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeGreaterThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime >", value, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime >=", value, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeLessThan(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime <", value, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeLessThanOrEqualTo(Date value) {
            addCriterion("complaint_and_suggestion_sheet.processingTime <=", value, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.processingTime in", values, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeNotIn(List<Date> values) {
            addCriterion("complaint_and_suggestion_sheet.processingTime not in", values, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.processingTime between", value1, value2, "processingtime");
            return (Criteria) this;
        }

        public Criteria andProcessingtimeNotBetween(Date value1, Date value2) {
            addCriterion("complaint_and_suggestion_sheet.processingTime not between", value1, value2, "processingtime");
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