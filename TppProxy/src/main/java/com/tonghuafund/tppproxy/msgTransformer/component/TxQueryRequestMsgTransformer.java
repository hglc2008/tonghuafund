package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.TransQueryV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.TransQueryV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.TransQueryV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppTxQueryRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

/**
 * 扣款报文转换
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月1日
 */
@Service("txQueryRequestMsgTransformer")
public class TxQueryRequestMsgTransformer extends BaseRequestMsgTransformer {

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		// 1 类型转换
		IppTxQueryRequestBody body = (IppTxQueryRequestBody) ippRequest.getBody();

		// 2报文bean
		TransQueryV10RequestDoc doc = new TransQueryV10RequestDoc();
		TransQueryV10RequestEnvelope envelope = new TransQueryV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("09");
		head.setTransCode("4001");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		TransQueryV10RequestTxInfo txInfo = new TransQueryV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setOriTraceNo(body.getOrgReqTraceNum());
		txInfo.setOriTransDate(body.getOrgTransDate());
		txInfo.setOriTransTime("121212");
		envelope.setTxInfo(txInfo);

		doc.setEnvelope(envelope);

		// 4.2 请求实体
		PaymentRequest request = new PaymentRequest();
		request.setCharset("utf-8");
		request.setRequestBean(doc);
		return request;
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.TX_QUERY;
	}

}
