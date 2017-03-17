package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.EBankConsumeV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppConSumeResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppConSumeRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppConSumeResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("conSumeResponseMsgTransformer")
public class ConSumeResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppConSumeResponseDoc responseDoc = new IppConSumeResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.CONSUME);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);

		IppConSumeResponseBody body = new IppConSumeResponseBody();
		IppConSumeRequestBody reqBody = (IppConSumeRequestBody) ippRequestDoc.getBody();

		body.setReqTraceNum(reqBody.getReqTraceNum());
		body.setBusNum(reqBody.getBusNum());
		body.setOrderNum(reqBody.getOrderNum());
		body.setDateSettlmt(reqBody.getDateSettlmt());
		body.setAmtPay(reqBody.getAmtPay());
		body.setAmtTran(reqBody.getAmtTran());
		body.setTraceFee(reqBody.getTraceFee());

		if ("0".equals(tppResponse.getFlag())) {
			EBankConsumeV10ResponseTxInfo txInfo = (EBankConsumeV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
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
		return IppTransCode.CONSUME;
	}
}
