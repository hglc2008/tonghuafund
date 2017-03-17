package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.DeductV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppDeductResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppDeductRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppDeductResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

/**
 * 扣款报文转换
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月1日
 */
@Service("deductResponseMsgTransformer")
public class DeductResponseMsgTransformer extends BaseResponseMsgTransformer {

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppDeductResponseDoc responseDoc = new IppDeductResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.DEDUCT);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);

		IppDeductResponseBody body = new IppDeductResponseBody();
		IppDeductRequestBody reqBody = (IppDeductRequestBody) ippRequestDoc.getBody();

		body.setAcctNum(reqBody.getAcctNum());
		body.setAmount(reqBody.getAmount());
		body.setChannelID(reqBody.getChannelID());
		body.setCurType("156");
		body.setDateSettlmt(reqBody.getDateSettlmt());
		body.setReqTraceNum(reqBody.getReqTraceNum());

		if ("0".equals(tppResponse.getFlag())) {
			DeductV10ResponseTxInfo txInfo = (DeductV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
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
		return IppTransCode.DEDUCT;
	}

}
