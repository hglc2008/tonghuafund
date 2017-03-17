package com.tonghuafund.tppproxy.msgTransformer.component;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.component.v10.DeductV10RequestDoc;
import com.allinpay.ipps.entity.component.v10.underlie.DeductV10RequestEnvelope;
import com.allinpay.ipps.entity.component.v10.underlie.DeductV10RequestTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.dao.GwContract;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.IppDeductRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;

/**
 * 扣款报文转换
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月1日
 */
@Service("deductRequestMsgTransformer")
public class DeductRequestMsgTransformer extends BaseRequestMsgTransformer {

	@Override
	public PaymentRequest transform(AbstractIppRequestDoc ippRequest) {
		// 1 查询协议表以补全账户信息
		IppDeductRequestBody body = (IppDeductRequestBody) ippRequest.getBody();
		GwContract contract = gwContractMapper.selectFirstByAcctNO(body.getAcctNum());
		if (contract == null) {
			throw new PaymentException("00006");
		}

		// 2报文bean
		DeductV10RequestDoc doc = new DeductV10RequestDoc();
		DeductV10RequestEnvelope envelope = new DeductV10RequestEnvelope();

		V10Head head = new V10Head();
		head.setVersionNo("v1.0");
		head.setBusinessType(TppProxyEnv.getTppMchtBusinessType());
		head.setPayType("09");
		head.setTransCode("2001");
		head.setAgentId(ippRequest.getHead().getInstId());
		head.setTraceNo(body.getReqTraceNum());
		head.setTransDate(ippRequest.getHead().getTransDate());
		head.setTransTime(ippRequest.getHead().getTransTime());
		envelope.setHead(head);

		DeductV10RequestTxInfo txInfo = new DeductV10RequestTxInfo();
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
		return IppTransCode.DEDUCT;
	}

}
