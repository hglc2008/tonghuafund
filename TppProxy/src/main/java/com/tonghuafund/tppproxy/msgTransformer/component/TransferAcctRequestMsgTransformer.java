package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.TransferApplyV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.TransferApplyV10Payee;
import com.allinpay.ipps.entity.component.v10.underlie.TransferApplyV10Payer;
import com.allinpay.ipps.entity.component.v10.underlie.TransferApplyV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.TransferApplyV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppTransferAcctRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

@Service("transferAcctRequestMsgTransformer")
public class TransferAcctRequestMsgTransformer extends BaseRequestMsgTransformer{

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		IppTransferAcctRequestBody body = (IppTransferAcctRequestBody)ippRequest.getBody();
		
		//1.1tpp报文bean
		TransferApplyV10RequestDoc doc = new TransferApplyV10RequestDoc();
		TransferApplyV10RequestEnvelope envelope = new TransferApplyV10RequestEnvelope();
		
		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("09");
		head.setTransCode("2009");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		head.setBgNotifyUrl(TppProxyEnv.getTppProxyBgNotifyUrl());
		envelope.setHead(head);
		
		TransferApplyV10RequestTxInfo txInfo = new TransferApplyV10RequestTxInfo();
		txInfo.setMerchantNo(ippRequest.getHead().getInstId());
		txInfo.setTransAmount(body.getAmtTran());
		txInfo.setCurrency(body.getCurType());
		txInfo.setTransferType(body.getTransferType());
		TransferApplyV10Payer payer = new TransferApplyV10Payer();
		payer.setPayerBankCode(body.getChannelID());
		payer.setRoute("");
		payer.setPayerAcctName(body.getHldName());
		payer.setPayerAcctCat(body.getAcctType());
		payer.setPayerAcctNo(body.getAcctNum());
		payer.setPayerIdType("");
		payer.setPayerIdNo("");
		payer.setPayerContractNo("");
		txInfo.setPayer(payer);
		TransferApplyV10Payee payee = new TransferApplyV10Payee();
		payee.setPayeeBankCode(body.getDestinationChannelId());
		payee.setPayeeBankNo(body.getBnkCode());
		payee.setPayeeBankName("");
		payee.setPayeeBankProvince(body.getBnkProvince());
		payee.setPayeeBankCity(body.getBnkCity());
		payee.setPayeeAcctCat(body.getDestinationAcctType());
		payee.setPayeeAcctName(body.getDestinationHldName());
		payee.setPayeeAcctNo(body.getDestinationAcctNum());
		txInfo.setPayee(payee);
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
		return IppTransCode.TRANSFER_ACCT;
	}
}
