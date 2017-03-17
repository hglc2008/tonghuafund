package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.AuthenticateV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AuthenticateV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.AuthenticateV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("authenticateRequestMsgTransformer")
public class AuthenticateRequestMsgTransformer extends BaseRequestMsgTransformer{

	
	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppAuthenticateRequestBody body = (IppAuthenticateRequestBody) ippRequest.getBody();

		// 1.报文bean
		AuthenticateV10RequestDoc doc = new AuthenticateV10RequestDoc();
		AuthenticateV10RequestEnvelope envelope = new AuthenticateV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("08");
		head.setTransCode("1001");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		AuthenticateV10RequestTxInfo txInfo = new AuthenticateV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setBankCode(body.getChannelID());
		txInfo.setAcctName(body.getHldName());
		txInfo.setAcctCat(body.getAcctType());
		txInfo.setAcctNo(body.getAcctNum());
		txInfo.setIdType(body.getCerType());
		txInfo.setIdNo(body.getCerNum());
		txInfo.setPhoneNo(body.getTelNum());
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
		return IppTransCode.AUTHENTICATE;
	}
}
