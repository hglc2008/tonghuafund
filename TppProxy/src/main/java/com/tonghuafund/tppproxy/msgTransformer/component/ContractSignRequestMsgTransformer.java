package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.ContractSignV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.ContractSignV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.ContractSignV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppContractSignRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("contractSignRequestMsgTransformer")
public class ContractSignRequestMsgTransformer extends BaseRequestMsgTransformer{

	
	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppContractSignRequestBody body = (IppContractSignRequestBody) ippRequest.getBody();

		// 1.报文bean
		ContractSignV10RequestDoc doc = new ContractSignV10RequestDoc();
		ContractSignV10RequestEnvelope envelope = new ContractSignV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("08");
		head.setTransCode("1002");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		head.setNotifyUrl(TppProxyEnv.getTppProxyNotifyUrl());
		head.setBgNotifyUrl(TppProxyEnv.getTppProxyBgNotifyUrl());
		envelope.setHead(head);

		ContractSignV10RequestTxInfo txInfo = new ContractSignV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setBankCode(body.getChannelID());
		txInfo.setAcctName(body.getHldName());
		txInfo.setAcctCat(body.getAcctType());
		txInfo.setAcctNo(body.getAcctNum());
		txInfo.setPhoneNo(body.getTelNum());
		txInfo.setIdType(body.getCerType());
		txInfo.setIdNo(body.getCerNum());
		txInfo.setExtendInfo(body.getAddtnlData1());
		envelope.setTxInfo(txInfo);

		doc.setEnvelope(envelope);

		// 2. 请求实体
		PaymentRequest request = new PaymentRequest();
		request.setCharset("utf-8");
		request.setRequestBean(doc);
		return request;
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.CONTRACT_SIGN;
	}
}
