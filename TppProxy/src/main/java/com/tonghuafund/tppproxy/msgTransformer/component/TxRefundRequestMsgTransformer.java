package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.SReFundV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.SReFundV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.SReFundV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppTxRefundRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("txRefundRequestMsgTransformer")
public class TxRefundRequestMsgTransformer extends BaseRequestMsgTransformer{

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppTxRefundRequestBody body = (IppTxRefundRequestBody) ippRequest.getBody();

		// 1.报文bean
		SReFundV10RequestDoc doc = new SReFundV10RequestDoc();
		SReFundV10RequestEnvelope envelope = new SReFundV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("50");
		head.setTransCode("2010");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		SReFundV10RequestTxInfo txInfo = new SReFundV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setTransAmount(body.getAmtTran());
		txInfo.setCurrency(body.getCurType());
		txInfo.setOriSerialNo(body.getOrgReqTraceNum());
		txInfo.setOriTransDate(body.getOrgTransDate());
		txInfo.setOriTransTime("1111");
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
		return IppTransCode.TX_REFUND;
	}
}
