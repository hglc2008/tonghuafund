package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.EBankConsumeV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.EBankConsumeV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.EBankConsumeV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppConSumeRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("conSumeRequestMsgTransformer")
public class ConSumeRequestMsgTransformer extends BaseRequestMsgTransformer{

	
	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppConSumeRequestBody body = (IppConSumeRequestBody) ippRequest.getBody();

		// 1.报文bean
		EBankConsumeV10RequestDoc doc = new EBankConsumeV10RequestDoc();
		EBankConsumeV10RequestEnvelope envelope = new EBankConsumeV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("01");
		head.setTransCode("2003");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		EBankConsumeV10RequestTxInfo txInfo = new EBankConsumeV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		//TODO
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
		return IppTransCode.CONSUME;
	}
}
