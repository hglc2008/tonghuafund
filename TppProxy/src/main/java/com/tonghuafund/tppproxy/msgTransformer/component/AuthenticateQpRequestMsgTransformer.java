package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.AuthenticateQpV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AuthenticateQpV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.AuthenticateQpV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateQpRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("authenticateQpRequestMsgTransformer")
public class AuthenticateQpRequestMsgTransformer extends BaseRequestMsgTransformer{

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppAuthenticateQpRequestBody body = (IppAuthenticateQpRequestBody) ippRequest.getBody();

		// 1.报文bean
		AuthenticateQpV10RequestDoc doc = new AuthenticateQpV10RequestDoc();
		AuthenticateQpV10RequestEnvelope envelope = new AuthenticateQpV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("08");
		head.setTransCode("1005");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		AuthenticateQpV10RequestTxInfo txInfo = new AuthenticateQpV10RequestTxInfo();
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
		return IppTransCode.AUTHENTICATE_QP;
	}
}
