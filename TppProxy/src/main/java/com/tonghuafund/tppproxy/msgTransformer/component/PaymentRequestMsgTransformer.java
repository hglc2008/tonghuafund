package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.PaymentV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.PaymentV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.PaymentV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.dao.GwContract;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppPaymentRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

/**
 * 付款报文转换
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月1日
 */
@Service("paymentRequestMsgTransformer")
public class PaymentRequestMsgTransformer extends BaseRequestMsgTransformer {

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		// 1 查询协议表以补全账户信息
		IppPaymentRequestBody body = (IppPaymentRequestBody) ippRequest.getBody();
		GwContract contract = gwContractMapper.selectFirstByAcctNO(body.getAcctNum());
		if (contract == null) {
			throw new PaymentException("00006");
		}

		// 2报文bean
		PaymentV10RequestDoc doc = new PaymentV10RequestDoc();
		PaymentV10RequestEnvelope envelope = new PaymentV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("09");
		head.setTransCode("2002");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		PaymentV10RequestTxInfo txInfo = new PaymentV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setTransAmount(body.getAmount());
		txInfo.setCurrency("156");
		txInfo.setBankCode(body.getChannelID());
		txInfo.setAcctName(contract.getAcctName());
		txInfo.setAcctCat(contract.getAcctCat());
		txInfo.setAcctNo(body.getAcctNum());
		txInfo.setIdType(contract.getIdCardType());
		txInfo.setIdNo(contract.getIdCardNO());
		txInfo.setExtendInfo(body.getAbstractMsg());
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
		return IppTransCode.PAYMENT;
	}

}
