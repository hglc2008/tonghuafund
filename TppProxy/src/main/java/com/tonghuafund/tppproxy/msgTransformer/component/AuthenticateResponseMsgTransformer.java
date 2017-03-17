package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AuthenticateV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppAuthenticateResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("authenticateResponseMsgTransformer")
public class AuthenticateResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppAuthenticateResponseDoc responseDoc = new IppAuthenticateResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.AUTHENTICATE);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);

		IppAuthenticateResponseBody body = new IppAuthenticateResponseBody();
		IppAuthenticateRequestBody reqBody = (IppAuthenticateRequestBody) ippRequestDoc.getBody();

		body.setReqTraceNum(reqBody.getReqTraceNum());
		body.setChannelID(reqBody.getChannelID());
		body.setDateSettlmt(reqBody.getDateSettlmt());
		body.setAcctNum(reqBody.getAcctNum());

		if ("0".equals(tppResponse.getFlag())) {
			AuthenticateV10ResponseTxInfo txInfo = (AuthenticateV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
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
		return IppTransCode.AUTHENTICATE;
	}
}
