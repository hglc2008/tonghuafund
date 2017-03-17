package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.SReFundV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppTxRefundResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppTxRefundRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppTxRefundResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("txRefundResponseMsgTransformer")
public class TxRefundResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppTxRefundResponseDoc responseDoc = new IppTxRefundResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.CONSUME);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);

		IppTxRefundResponseBody body = new IppTxRefundResponseBody();
		IppTxRefundRequestBody reqBody = (IppTxRefundRequestBody) ippRequestDoc.getBody();

		body.setReqTraceNum(reqBody.getReqTraceNum());
		body.setOrgReqTraceNum(reqBody.getOrgReqTraceNum());
		body.setOrgTransDate(reqBody.getOrgTransDate());
		body.setAmtTran(reqBody.getAmtTran());
		body.setCurType(reqBody.getCurType());

		if ("0".equals(tppResponse.getFlag())) {
			SReFundV10ResponseTxInfo txInfo = (SReFundV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
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
		return IppTransCode.TX_REFUND;
	}
}
