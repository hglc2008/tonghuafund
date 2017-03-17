package com.tonghuafund.tppproxy.dao.mapper;

import java.util.List;

import com.tonghuafund.tppproxy.dao.Criteria;
import com.tonghuafund.tppproxy.dao.GwContract;

public interface GwContractMapper {
	/**
	 * 根据条件查询记录集
	 */
	List<GwContract> selectByExample(Criteria example);

	/**
	 * 根据主键查询记录
	 */
	GwContract selectByPrimaryKey(Long rowID);

	/**
	 * 根据主键查询记录
	 */
	GwContract selectFirstByAcctNO(String acctNo);

}