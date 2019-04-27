package com.achan.entity.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsBaseExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdIsNull() {
            addCriterion("major_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdIsNotNull() {
            addCriterion("major_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdEqualTo(String value) {
            addCriterion("major_unit_id =", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdNotEqualTo(String value) {
            addCriterion("major_unit_id <>", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdGreaterThan(String value) {
            addCriterion("major_unit_id >", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("major_unit_id >=", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdLessThan(String value) {
            addCriterion("major_unit_id <", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdLessThanOrEqualTo(String value) {
            addCriterion("major_unit_id <=", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdLike(String value) {
            addCriterion("major_unit_id like", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdNotLike(String value) {
            addCriterion("major_unit_id not like", value, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdIn(List<String> values) {
            addCriterion("major_unit_id in", values, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdNotIn(List<String> values) {
            addCriterion("major_unit_id not in", values, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdBetween(String value1, String value2) {
            addCriterion("major_unit_id between", value1, value2, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andMajorUnitIdNotBetween(String value1, String value2) {
            addCriterion("major_unit_id not between", value1, value2, "majorUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdIsNull() {
            addCriterion("auxiliary_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdIsNotNull() {
            addCriterion("auxiliary_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdEqualTo(String value) {
            addCriterion("auxiliary_unit_id =", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdNotEqualTo(String value) {
            addCriterion("auxiliary_unit_id <>", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdGreaterThan(String value) {
            addCriterion("auxiliary_unit_id >", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("auxiliary_unit_id >=", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdLessThan(String value) {
            addCriterion("auxiliary_unit_id <", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdLessThanOrEqualTo(String value) {
            addCriterion("auxiliary_unit_id <=", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdLike(String value) {
            addCriterion("auxiliary_unit_id like", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdNotLike(String value) {
            addCriterion("auxiliary_unit_id not like", value, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdIn(List<String> values) {
            addCriterion("auxiliary_unit_id in", values, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdNotIn(List<String> values) {
            addCriterion("auxiliary_unit_id not in", values, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdBetween(String value1, String value2) {
            addCriterion("auxiliary_unit_id between", value1, value2, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryUnitIdNotBetween(String value1, String value2) {
            addCriterion("auxiliary_unit_id not between", value1, value2, "auxiliaryUnitId");
            return (Criteria) this;
        }

        public Criteria andUnitRateIsNull() {
            addCriterion("unit_rate is null");
            return (Criteria) this;
        }

        public Criteria andUnitRateIsNotNull() {
            addCriterion("unit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUnitRateEqualTo(BigDecimal value) {
            addCriterion("unit_rate =", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateNotEqualTo(BigDecimal value) {
            addCriterion("unit_rate <>", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateGreaterThan(BigDecimal value) {
            addCriterion("unit_rate >", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_rate >=", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateLessThan(BigDecimal value) {
            addCriterion("unit_rate <", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_rate <=", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateIn(List<BigDecimal> values) {
            addCriterion("unit_rate in", values, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateNotIn(List<BigDecimal> values) {
            addCriterion("unit_rate not in", values, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_rate between", value1, value2, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_rate not between", value1, value2, "unitRate");
            return (Criteria) this;
        }

        public Criteria andInPriceIsNull() {
            addCriterion("in_price is null");
            return (Criteria) this;
        }

        public Criteria andInPriceIsNotNull() {
            addCriterion("in_price is not null");
            return (Criteria) this;
        }

        public Criteria andInPriceEqualTo(BigDecimal value) {
            addCriterion("in_price =", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceNotEqualTo(BigDecimal value) {
            addCriterion("in_price <>", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceGreaterThan(BigDecimal value) {
            addCriterion("in_price >", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("in_price >=", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceLessThan(BigDecimal value) {
            addCriterion("in_price <", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("in_price <=", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceIn(List<BigDecimal> values) {
            addCriterion("in_price in", values, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceNotIn(List<BigDecimal> values) {
            addCriterion("in_price not in", values, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_price between", value1, value2, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_price not between", value1, value2, "inPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceIsNull() {
            addCriterion("out_price is null");
            return (Criteria) this;
        }

        public Criteria andOutPriceIsNotNull() {
            addCriterion("out_price is not null");
            return (Criteria) this;
        }

        public Criteria andOutPriceEqualTo(BigDecimal value) {
            addCriterion("out_price =", value, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceNotEqualTo(BigDecimal value) {
            addCriterion("out_price <>", value, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceGreaterThan(BigDecimal value) {
            addCriterion("out_price >", value, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("out_price >=", value, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceLessThan(BigDecimal value) {
            addCriterion("out_price <", value, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("out_price <=", value, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceIn(List<BigDecimal> values) {
            addCriterion("out_price in", values, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceNotIn(List<BigDecimal> values) {
            addCriterion("out_price not in", values, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_price between", value1, value2, "outPrice");
            return (Criteria) this;
        }

        public Criteria andOutPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_price not between", value1, value2, "outPrice");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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