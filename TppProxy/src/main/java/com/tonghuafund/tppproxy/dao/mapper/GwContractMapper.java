package com.tonghuafund.tppproxy.dao.mapper;

import java.util.List;

import com.tonghuafund.tppproxy.dao.Criteria;
import com.tonghuafund.tppproxy.dao.GwContract;

public interface GwContractMapper {
	/**
	 * ����������ѯ��¼��
	 */
	List<GwContract> selectByExample(Criteria example);

	/**
	 * ����������ѯ��¼
	 */
	GwContract selectByPrimaryKey(Long rowID);

	/**
	 * ����������ѯ��¼
	 */
	GwContract selectFirstByAcctNO(String acctNo);

}