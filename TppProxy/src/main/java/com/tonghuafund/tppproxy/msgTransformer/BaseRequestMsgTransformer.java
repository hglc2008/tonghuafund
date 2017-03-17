package com.tonghuafund.tppproxy.msgTransformer;

import org.springframework.beans.factory.annotation.Autowired;

import com.allinpay.ipps.entity.PaymentRequest;
import com.tonghuafund.tppproxy.dao.mapper.GwContractMapper;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;

/**
 * 把ipp的请求报文，转成tpp的请求报文
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月1日
 */
public abstract class BaseRequestMsgTransformer {
	@Autowired
	protected GwContractMapper gwContractMapper;
	// 查询数据库的DAO

	// 请求转换器
	public abstract PaymentRequest transform(AbstractIppRequestDoc ippRequest);

	// 支持的交易类型
	public abstract String getSupportTransCode();

	public void setGwContractMapper(GwContractMapper gwContractMapper) {
		this.gwContractMapper = gwContractMapper;
	}

}
