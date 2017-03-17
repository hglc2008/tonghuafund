package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.AccountTxDetailV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10RequestQueryInfo;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("accountTxDetailRequestMsgTransformer")
public class AccountTxDetailRequestMsgTransformer extends BaseRequestMsgTransformer{

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		
		IppAccountTxDetailRequestBody body = (IppAccountTxDetailRequestBody) ippRequest.getBody();

		// 1.报文bean
		AccountTxDetailV10RequestDoc doc = new AccountTxDetailV10RequestDoc();
		AccountTxDetailV10RequestEnvelope envelope = new AccountTxDetailV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("99");
		head.setTransCode("3004");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		AccountTxDetailV10RequestTxInfo txInfo = new AccountTxDetailV10RequestTxInfo();
		AccountTxDetailV10RequestQueryInfo queryInfo = new AccountTxDetailV10RequestQueryInfo();
		
		queryInfo.setMerchantNo(ippRequest.getHead().getInstId());
		queryInfo.setBankCode(body.getChannelId());
		queryInfo.setQueryDate(body.getBgnData());
		queryInfo.setAcctCat(body.getAcctType());
		queryInfo.setAcctName(body.getHldName());
		queryInfo.setAcctNo(body.getAcctNum());
		queryInfo.setContractNo("");
		queryInfo.setPage(body.getPageIndex());
		queryInfo.setPageSize(body.getPageSize());
		queryInfo.setPagePosStr("");
		queryInfo.setRoute("");
		txInfo.setQueryInfo(queryInfo);
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
		return IppTransCode.ACCOUNT_TX_DETAIL;
	}
}
