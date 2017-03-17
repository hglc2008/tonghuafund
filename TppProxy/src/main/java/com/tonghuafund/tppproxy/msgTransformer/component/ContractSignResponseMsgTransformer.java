package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AuthenticateV10ResponseTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.ContractSignV10ResponseTxInfo;
import com.allinpay.ipps.entity.component.v10.underlie.V10Head;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppAuthenticateResponseDoc;
import com.tonghuafund.tppproxy.doc.IppContractSignResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateResponseBody;
import com.tonghuafund.tppproxy.doc.component.IppContractSignRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppContractSignResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("contractSignResponseMsgTransformer")
public class ContractSignResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppContractSignResponseDoc responseDoc = new IppContractSignResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
//		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.CONTRACT_SIGN);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
//		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		

		IppContractSignResponseBody body = new IppContractSignResponseBody();
//		IppContractSignRequestBody reqBody = (IppContractSignRequestBody) ippRequestDoc.getBody();

//		body.setReqTraceNum(body.getReqTraceNum());
//		body.setChannelID(reqBody.getChannelID());
//		body.setDateSettlmt(reqBody.getDateSettlmt());
//		body.setAcctNum(reqBody.getAcctNum());

		if ("0".equals(tppResponse.getFlag())) {
			V10Head v10head = (V10Head) tppResponse.getResponseBean().getEnvelope().getHead();
			ContractSignV10ResponseTxInfo txInfo = (ContractSignV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
					.getTxInfo());
			
			head.setInstId(txInfo.getMerchantNo());
			head.setVerNum(v10head.getVersionNo());
			
			body.setReqTraceNum(v10head.getTraceNo());
			body.setChannelID(txInfo.getBankCode());
			body.setDateSettlmt(v10head.getTransDate());
			body.setAcctNum(txInfo.getAcctNo());
			body.setRespTraceNum(txInfo.getIppTraceNum());
			body.setRespCode(getIppCodeFromErrorCode(txInfo.getRetCode()));
			body.setRespMsg(txInfo.getRetMsg());
		} else {
			ErrorResponseDoc errorDoc = (ErrorResponseDoc) tppResponse.getResponseBean();
			body.setRespTraceNum(null);
			body.setRespCode(getIppCodeFromErrorCode(errorDoc.getErrorCode()));
			body.setRespMsg(errorDoc.getErrorMessage());
		}
		responseDoc.setHead(head);
		responseDoc.setBody(body);

		return responseDoc;
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.CONTRACT_SIGN;
	}
}
