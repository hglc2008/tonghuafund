package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.PaymentV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppPaymentResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppPaymentRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppPaymentResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

/**
 * �����ת��
 * 
 * @author changstone
 * 
 * @create datetime 2016��3��1��
 */
@Service("paymentResponseMsgTransformer")
public class PaymentResponseMsgTransformer extends BaseResponseMsgTransformer {

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppPaymentResponseDoc responseDoc = new IppPaymentResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.PAYMENT);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);

		IppPaymentResponseBody body = new IppPaymentResponseBody();
		IppPaymentRequestBody reqBody = (IppPaymentRequestBody) ippRequestDoc.getBody();

		body.setAcctNum(reqBody.getAcctNum());
		body.setAmount(reqBody.getAmount());
		body.setChannelID(reqBody.getChannelID());
		body.setCurType("156");
		body.setDateSettlmt(reqBody.getDateSettlmt());
		body.setReqTraceNum(reqBody.getReqTraceNum());

		if ("0".equals(tppResponse.getFlag())) {
			PaymentV10ResponseTxInfo txInfo = (PaymentV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
					.getTxInfo());
			body.setRespTraceNum(txInfo.getIppTraceNum());
			body.setRespCode(getIppCodeFromErrorCode(txInfo.getRetCode()));
			body.setRespMsg(txInfo.getRetMsg());
		} else {
			ErrorResponseDoc errorDoc = (ErrorResponseDoc) tppResponse.getResponseBean();
			body.setRespTraceNum(null);
			body.setRespCode(getIppCodeFromErrorCode(errorDoc.getErrorCode()));
			body.setRespMsg(errorDoc.getErrorMessage());
		}
		responseDoc.setBody(body);

		return responseDoc;
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.PAYMENT;
	}

}
