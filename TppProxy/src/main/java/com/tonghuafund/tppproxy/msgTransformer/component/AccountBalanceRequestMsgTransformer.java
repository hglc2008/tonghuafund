package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.AccountBalanceV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AccountBalanceV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.AccountBalanceV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppAccountBalanceRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("accountBalanceRequestMsgTransformer")
public class AccountBalanceRequestMsgTransformer extends BaseRequestMsgTransformer{

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppAccountBalanceRequestBody body = (IppAccountBalanceRequestBody) ippRequest.getBody();

		// 1.报文bean
		AccountBalanceV10RequestDoc doc = new AccountBalanceV10RequestDoc();
		AccountBalanceV10RequestEnvelope envelope = new AccountBalanceV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("99");
		head.setTransCode("3003");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		AccountBalanceV10RequestTxInfo txInfo = new AccountBalanceV10RequestTxInfo();
		
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setQueryDate(ippRequest.getHead().getTransDate());
		txInfo.setBankCode(body.getChannelId());
		txInfo.setAcctCat(body.getAcctType());
		txInfo.setAcctName(body.getHldName());
		txInfo.setAcctNo(body.getAcctNum());
		txInfo.setContractNo("");
		txInfo.setRoute("");
		
		
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
		return IppTransCode.ACCOUNT_BALANCE;
	}
}
