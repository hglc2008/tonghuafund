package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.TransferApplyV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppTransferAcctResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppTransferAcctRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppTransferAcctResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("transferAcctResponseMsgTransformer")
public class TransferAcctResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppTransferAcctResponseDoc responseDoc = new IppTransferAcctResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.TRANSFER_ACCT);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);
		
		IppTransferAcctResponseBody body = new IppTransferAcctResponseBody();
		IppTransferAcctRequestBody reqBody = (IppTransferAcctRequestBody)ippRequestDoc.getBody();
		body.setReqTraceNum(reqBody.getReqTraceNum());
		body.setAcctNum(reqBody.getAcctNum());
		body.setAmtTran(reqBody.getAmtTran());
		body.setCurType(reqBody.getCurType());
		body.setDestinationAcctNum(reqBody.getDestinationAcctNum());
		body.setDestinationChannelId(reqBody.getDestinationChannelId());
		body.setDestinationHldName(reqBody.getDestinationHldName());
		
		if ("0".equals(tppResponse.getFlag())) {
			TransferApplyV10ResponseTxInfo txInfo = (TransferApplyV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
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
		return IppTransCode.TRANSFER_ACCT;
	}
}
