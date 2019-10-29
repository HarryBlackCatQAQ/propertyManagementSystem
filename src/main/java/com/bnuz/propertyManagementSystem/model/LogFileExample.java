package com.bnuz.propertyManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class LogFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public LogFileExample() {
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
            addCriterion("log_file.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("log_file.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("log_file.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("log_file.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("log_file.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_file.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("log_file.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_file.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("log_file.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("log_file.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("log_file.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_file.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("log_file.`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("log_file.`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("log_file.`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("log_file.`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("log_file.`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_file.`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("log_file.`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("log_file.`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("log_file.`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("log_file.`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("log_file.`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("log_file.`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("log_file.fileName is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("log_file.fileName is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("log_file.fileName =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("log_file.fileName <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("log_file.fileName >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_file.fileName >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("log_file.fileName <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("log_file.fileName <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("log_file.fileName like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("log_file.fileName not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("log_file.fileName in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("log_file.fileName not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("log_file.fileName between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("log_file.fileName not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("log_file.`path` is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("log_file.`path` is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("log_file.`path` =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("log_file.`path` <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("log_file.`path` >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("log_file.`path` >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("log_file.`path` <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("log_file.`path` <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("log_file.`path` like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("log_file.`path` not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("log_file.`path` in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("log_file.`path` not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("log_file.`path` between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("log_file.`path` not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNull() {
            addCriterion("log_file.isDir is null");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNotNull() {
            addCriterion("log_file.isDir is not null");
            return (Criteria) this;
        }

        public Criteria andIsDirEqualTo(Integer value) {
            addCriterion("log_file.isDir =", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotEqualTo(Integer value) {
            addCriterion("log_file.isDir <>", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThan(Integer value) {
            addCriterion("log_file.isDir >", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_file.isDir >=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThan(Integer value) {
            addCriterion("log_file.isDir <", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThanOrEqualTo(Integer value) {
            addCriterion("log_file.isDir <=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirIn(List<Integer> values) {
            addCriterion("log_file.isDir in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotIn(List<Integer> values) {
            addCriterion("log_file.isDir not in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirBetween(Integer value1, Integer value2) {
            addCriterion("log_file.isDir between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotBetween(Integer value1, Integer value2) {
            addCriterion("log_file.isDir not between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameIsNull() {
            addCriterion("log_file.preLevelName is null");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameIsNotNull() {
            addCriterion("log_file.preLevelName is not null");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameEqualTo(String value) {
            addCriterion("log_file.preLevelName =", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameNotEqualTo(String value) {
            addCriterion("log_file.preLevelName <>", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameGreaterThan(String value) {
            addCriterion("log_file.preLevelName >", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_file.preLevelName >=", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameLessThan(String value) {
            addCriterion("log_file.preLevelName <", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameLessThanOrEqualTo(String value) {
            addCriterion("log_file.preLevelName <=", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameLike(String value) {
            addCriterion("log_file.preLevelName like", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameNotLike(String value) {
            addCriterion("log_file.preLevelName not like", value, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameIn(List<String> values) {
            addCriterion("log_file.preLevelName in", values, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameNotIn(List<String> values) {
            addCriterion("log_file.preLevelName not in", values, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameBetween(String value1, String value2) {
            addCriterion("log_file.preLevelName between", value1, value2, "preLevelName");
            return (Criteria) this;
        }

        public Criteria andPreLevelNameNotBetween(String value1, String value2) {
            addCriterion("log_file.preLevelName not between", value1, value2, "preLevelName");
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