package com.tonghuafund.tppproxy.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * ����������ѯ��
 */
public class Criteria {
    /**
     * ���������ѯֵ
     */
    private Map<String, Object> condition;

    /**
     * �Ƿ�����
     */
    protected boolean distinct;

    /**
     * �����ֶ�
     */
    protected String orderByClause;

    protected Criteria(Criteria example) {
        this.orderByClause = example.orderByClause;
        this.condition = example.condition;
        this.distinct = example.distinct;
    }

    public Criteria() {
        condition = new HashMap<String, Object>();
    }

    public void clear() {
        condition.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * @param condition 
	 *            ��ѯ����������
	 * @param value
	 *            ��ѯ��ֵ
     */
    public Criteria put(String condition, Object value) {
        this.condition.put(condition, value);
        return (Criteria) this;
    }

    /**
     * @param orderByClause 
	 *            �����ֶ�
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @param distinct 
	 *            �Ƿ�����
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Deprecated
    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    @Deprecated
    public Map<String, Object> getCondition() {
        return condition;
    }
}