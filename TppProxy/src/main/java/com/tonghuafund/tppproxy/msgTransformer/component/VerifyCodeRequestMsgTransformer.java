package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.VerifyCodeV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.allinpay.ipps.entity.component.v10.underlie.VerifyCodeV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.VerifyCodeV10RequestTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppVerifyCodeRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("verifyCodeRequestMsgTransformer")
public class VerifyCodeRequestMsgTransformer extends BaseRequestMsgTransformer{

	
	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppVerifyCodeRequestBody body = (IppVerifyCodeRequestBody) ippRequest.getBody();

		// 1.报文bean
		VerifyCodeV10RequestDoc doc = new VerifyCodeV10RequestDoc();
		VerifyCodeV10RequestEnvelope envelope = new VerifyCodeV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("99");
		head.setTransCode("1004");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		VerifyCodeV10RequestTxInfo txInfo = new VerifyCodeV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setOriTraceNum(body.getOrgReqTraceNum());
		txInfo.setOriTransDate(body.getOrgTransDate());
		txInfo.setOriTransTime("1212");
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
		return IppTransCode.VERIFY_CODE;
	}
}
