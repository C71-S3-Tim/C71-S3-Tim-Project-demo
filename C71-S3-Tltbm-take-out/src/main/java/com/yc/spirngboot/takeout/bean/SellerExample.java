package com.yc.spirngboot.takeout.bean;

import java.util.ArrayList;
import java.util.List;

public class SellerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellerExample() {
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

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSendpriceIsNull() {
            addCriterion("sendprice is null");
            return (Criteria) this;
        }

        public Criteria andSendpriceIsNotNull() {
            addCriterion("sendprice is not null");
            return (Criteria) this;
        }

        public Criteria andSendpriceEqualTo(Double value) {
            addCriterion("sendprice =", value, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceNotEqualTo(Double value) {
            addCriterion("sendprice <>", value, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceGreaterThan(Double value) {
            addCriterion("sendprice >", value, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("sendprice >=", value, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceLessThan(Double value) {
            addCriterion("sendprice <", value, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceLessThanOrEqualTo(Double value) {
            addCriterion("sendprice <=", value, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceIn(List<Double> values) {
            addCriterion("sendprice in", values, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceNotIn(List<Double> values) {
            addCriterion("sendprice not in", values, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceBetween(Double value1, Double value2) {
            addCriterion("sendprice between", value1, value2, "sendprice");
            return (Criteria) this;
        }

        public Criteria andSendpriceNotBetween(Double value1, Double value2) {
            addCriterion("sendprice not between", value1, value2, "sendprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceIsNull() {
            addCriterion("packprice is null");
            return (Criteria) this;
        }

        public Criteria andPackpriceIsNotNull() {
            addCriterion("packprice is not null");
            return (Criteria) this;
        }

        public Criteria andPackpriceEqualTo(Double value) {
            addCriterion("packprice =", value, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceNotEqualTo(Double value) {
            addCriterion("packprice <>", value, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceGreaterThan(Double value) {
            addCriterion("packprice >", value, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("packprice >=", value, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceLessThan(Double value) {
            addCriterion("packprice <", value, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceLessThanOrEqualTo(Double value) {
            addCriterion("packprice <=", value, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceIn(List<Double> values) {
            addCriterion("packprice in", values, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceNotIn(List<Double> values) {
            addCriterion("packprice not in", values, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceBetween(Double value1, Double value2) {
            addCriterion("packprice between", value1, value2, "packprice");
            return (Criteria) this;
        }

        public Criteria andPackpriceNotBetween(Double value1, Double value2) {
            addCriterion("packprice not between", value1, value2, "packprice");
            return (Criteria) this;
        }

        public Criteria andLogimgeIsNull() {
            addCriterion("logImge is null");
            return (Criteria) this;
        }

        public Criteria andLogimgeIsNotNull() {
            addCriterion("logImge is not null");
            return (Criteria) this;
        }

        public Criteria andLogimgeEqualTo(String value) {
            addCriterion("logImge =", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeNotEqualTo(String value) {
            addCriterion("logImge <>", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeGreaterThan(String value) {
            addCriterion("logImge >", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeGreaterThanOrEqualTo(String value) {
            addCriterion("logImge >=", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeLessThan(String value) {
            addCriterion("logImge <", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeLessThanOrEqualTo(String value) {
            addCriterion("logImge <=", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeLike(String value) {
            addCriterion("logImge like", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeNotLike(String value) {
            addCriterion("logImge not like", value, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeIn(List<String> values) {
            addCriterion("logImge in", values, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeNotIn(List<String> values) {
            addCriterion("logImge not in", values, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeBetween(String value1, String value2) {
            addCriterion("logImge between", value1, value2, "logimge");
            return (Criteria) this;
        }

        public Criteria andLogimgeNotBetween(String value1, String value2) {
            addCriterion("logImge not between", value1, value2, "logimge");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Integer value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Integer value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Integer value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Integer value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Integer value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Integer> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Integer> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Integer value1, Integer value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Integer value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Integer value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Integer value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Integer value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Integer value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Integer> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Integer> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Integer value1, Integer value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andSphoneIsNull() {
            addCriterion("sphone is null");
            return (Criteria) this;
        }

        public Criteria andSphoneIsNotNull() {
            addCriterion("sphone is not null");
            return (Criteria) this;
        }

        public Criteria andSphoneEqualTo(String value) {
            addCriterion("sphone =", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotEqualTo(String value) {
            addCriterion("sphone <>", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneGreaterThan(String value) {
            addCriterion("sphone >", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneGreaterThanOrEqualTo(String value) {
            addCriterion("sphone >=", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLessThan(String value) {
            addCriterion("sphone <", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLessThanOrEqualTo(String value) {
            addCriterion("sphone <=", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneLike(String value) {
            addCriterion("sphone like", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotLike(String value) {
            addCriterion("sphone not like", value, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneIn(List<String> values) {
            addCriterion("sphone in", values, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotIn(List<String> values) {
            addCriterion("sphone not in", values, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneBetween(String value1, String value2) {
            addCriterion("sphone between", value1, value2, "sphone");
            return (Criteria) this;
        }

        public Criteria andSphoneNotBetween(String value1, String value2) {
            addCriterion("sphone not between", value1, value2, "sphone");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("images is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("images is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String value) {
            addCriterion("images =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String value) {
            addCriterion("images <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String value) {
            addCriterion("images >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            addCriterion("images >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String value) {
            addCriterion("images <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            addCriterion("images <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLike(String value) {
            addCriterion("images like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String value) {
            addCriterion("images not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String> values) {
            addCriterion("images in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String> values) {
            addCriterion("images not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String value1, String value2) {
            addCriterion("images between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            addCriterion("images not between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andDistictIdIsNull() {
            addCriterion("distict_id is null");
            return (Criteria) this;
        }

        public Criteria andDistictIdIsNotNull() {
            addCriterion("distict_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistictIdEqualTo(Integer value) {
            addCriterion("distict_id =", value, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdNotEqualTo(Integer value) {
            addCriterion("distict_id <>", value, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdGreaterThan(Integer value) {
            addCriterion("distict_id >", value, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("distict_id >=", value, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdLessThan(Integer value) {
            addCriterion("distict_id <", value, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdLessThanOrEqualTo(Integer value) {
            addCriterion("distict_id <=", value, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdIn(List<Integer> values) {
            addCriterion("distict_id in", values, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdNotIn(List<Integer> values) {
            addCriterion("distict_id not in", values, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdBetween(Integer value1, Integer value2) {
            addCriterion("distict_id between", value1, value2, "distictId");
            return (Criteria) this;
        }

        public Criteria andDistictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("distict_id not between", value1, value2, "distictId");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Integer value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Integer value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Integer value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Integer value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Integer> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Integer> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andQualifiedIsNull() {
            addCriterion("qualified is null");
            return (Criteria) this;
        }

        public Criteria andQualifiedIsNotNull() {
            addCriterion("qualified is not null");
            return (Criteria) this;
        }

        public Criteria andQualifiedEqualTo(Integer value) {
            addCriterion("qualified =", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotEqualTo(Integer value) {
            addCriterion("qualified <>", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedGreaterThan(Integer value) {
            addCriterion("qualified >", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("qualified >=", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLessThan(Integer value) {
            addCriterion("qualified <", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLessThanOrEqualTo(Integer value) {
            addCriterion("qualified <=", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedIn(List<Integer> values) {
            addCriterion("qualified in", values, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotIn(List<Integer> values) {
            addCriterion("qualified not in", values, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedBetween(Integer value1, Integer value2) {
            addCriterion("qualified between", value1, value2, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("qualified not between", value1, value2, "qualified");
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