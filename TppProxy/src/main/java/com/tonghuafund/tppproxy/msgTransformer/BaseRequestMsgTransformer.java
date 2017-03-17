package com.tonghuafund.tppproxy.msgTransformer;

import org.springframework.beans.factory.annotation.Autowired;

import com.allinpay.ipps.entity.PaymentRequest;
import com.tonghuafund.tppproxy.dao.mapper.GwContractMapper;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;

/**
 * ��ipp�������ģ�ת��tpp��������
 * 
 * @author changstone
 * 
 * @create datetime 2016��3��1��
 */
public abstract class BaseRequestMsgTransformer {
	@Autowired
	protected GwContractMapper gwContractMapper;
	// ��ѯ���ݿ��DAO

	// ����ת����
	public abstract PaymentRequest transform(AbstractIppRequestDoc ippRequest);

	// ֧�ֵĽ�������
	public abstract String getSupportTransCode();

	public void setGwContractMapper(GwContractMapper gwContractMapper) {
		this.gwContractMapper = gwContractMapper;
	}

}
