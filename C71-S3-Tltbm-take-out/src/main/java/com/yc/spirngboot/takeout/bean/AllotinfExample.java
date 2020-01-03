package com.yc.spirngboot.takeout.bean;

import java.util.ArrayList;
import java.util.List;

public class AllotinfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllotinfExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdIsNull() {
            addCriterion("discrict_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdIsNotNull() {
            addCriterion("discrict_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdEqualTo(Integer value) {
            addCriterion("discrict_id =", value, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdNotEqualTo(Integer value) {
            addCriterion("discrict_id <>", value, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdGreaterThan(Integer value) {
            addCriterion("discrict_id >", value, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("discrict_id >=", value, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdLessThan(Integer value) {
            addCriterion("discrict_id <", value, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdLessThanOrEqualTo(Integer value) {
            addCriterion("discrict_id <=", value, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdIn(List<Integer> values) {
            addCriterion("discrict_id in", values, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdNotIn(List<Integer> values) {
            addCriterion("discrict_id not in", values, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdBetween(Integer value1, Integer value2) {
            addCriterion("discrict_id between", value1, value2, "discrictId");
            return (Criteria) this;
        }

        public Criteria andDiscrictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("discrict_id not between", value1, value2, "discrictId");
            return (Criteria) this;
        }

        public Criteria andRenameIsNull() {
            addCriterion("rename is null");
            return (Criteria) this;
        }

        public Criteria andRenameIsNotNull() {
            addCriterion("rename is not null");
            return (Criteria) this;
        }

        public Criteria andRenameEqualTo(String value) {
            addCriterion("rename =", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotEqualTo(String value) {
            addCriterion("rename <>", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameGreaterThan(String value) {
            addCriterion("rename >", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameGreaterThanOrEqualTo(String value) {
            addCriterion("rename >=", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameLessThan(String value) {
            addCriterion("rename <", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameLessThanOrEqualTo(String value) {
            addCriterion("rename <=", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameLike(String value) {
            addCriterion("rename like", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotLike(String value) {
            addCriterion("rename not like", value, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameIn(List<String> values) {
            addCriterion("rename in", values, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotIn(List<String> values) {
            addCriterion("rename not in", values, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameBetween(String value1, String value2) {
            addCriterion("rename between", value1, value2, "rename");
            return (Criteria) this;
        }

        public Criteria andRenameNotBetween(String value1, String value2) {
            addCriterion("rename not between", value1, value2, "rename");
            return (Criteria) this;
        }

        public Criteria andRephoneIsNull() {
            addCriterion("rephone is null");
            return (Criteria) this;
        }

        public Criteria andRephoneIsNotNull() {
            addCriterion("rephone is not null");
            return (Criteria) this;
        }

        public Criteria andRephoneEqualTo(String value) {
            addCriterion("rephone =", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneNotEqualTo(String value) {
            addCriterion("rephone <>", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneGreaterThan(String value) {
            addCriterion("rephone >", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneGreaterThanOrEqualTo(String value) {
            addCriterion("rephone >=", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneLessThan(String value) {
            addCriterion("rephone <", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneLessThanOrEqualTo(String value) {
            addCriterion("rephone <=", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneLike(String value) {
            addCriterion("rephone like", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneNotLike(String value) {
            addCriterion("rephone not like", value, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneIn(List<String> values) {
            addCriterion("rephone in", values, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneNotIn(List<String> values) {
            addCriterion("rephone not in", values, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneBetween(String value1, String value2) {
            addCriterion("rephone between", value1, value2, "rephone");
            return (Criteria) this;
        }

        public Criteria andRephoneNotBetween(String value1, String value2) {
            addCriterion("rephone not between", value1, value2, "rephone");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }
    }

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