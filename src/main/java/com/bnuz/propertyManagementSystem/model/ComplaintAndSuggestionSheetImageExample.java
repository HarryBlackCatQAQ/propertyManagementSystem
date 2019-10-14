package com.bnuz.propertyManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class ComplaintAndSuggestionSheetImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ComplaintAndSuggestionSheetImageExample() {
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
            addCriterion("complaint_and_suggestion_sheet_Image.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_Image.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_Image.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_Image.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_Image.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_Image.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSheetIdIsNull() {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId is null");
            return (Criteria) this;
        }

        public Criteria andSheetIdIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId is not null");
            return (Criteria) this;
        }

        public Criteria andSheetIdEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId =", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId <>", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdGreaterThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId >", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId >=", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdLessThan(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId <", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId <=", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId in", values, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotIn(List<Integer> values) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId not in", values, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId between", value1, value2, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_and_suggestion_sheet_Image.sheetId not between", value1, value2, "sheetId");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("complaint_and_suggestion_sheet_Image.`path` not between", value1, value2, "path");
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