package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.util.StringUtil;
import com.ibm.db2.jcc.a.b;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppTxQueryResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppTxQueryRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppTxQueryResponseBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("txQueryResponseMsgTransformer")
public class TxQueryResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {		
		IppTxQueryResponseDoc responseDoc = new IppTxQueryResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.TX_QUERY);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);
		
		IppTxQueryResponseBody body = new IppTxQueryResponseBody();
		IppTxQueryRequestBody reqBody = (IppTxQueryRequestBody) ippRequestDoc.getBody();
		body.setReqTraceNum(reqBody.getReqTraceNum());
		body.setOrgReqTraceNum(reqBody.getOrgReqTraceNum());
		body.setOrgTransDate(reqBody.getOrgTransDate());
		
		if ("0".equals(tppResponse.getFlag())) {
			String retCode = StringUtil.getTagValue(tppResponse.getResponseContent(), "RET_CODE");
			body.setRespMsg(StringUtil.getTagValue(tppResponse.getResponseContent(), "RET_MSG"));
			body.setRespCode("00000");
			body.setQurRst(getIppCodeFromErrorCode(retCode));
			body.setRespTraceNum(StringUtil.getTagValue(tppResponse.getResponseContent(), "IPP_TRACE_NUM"));
			body.setOrgDateSettlmt(StringUtil.getTagValue(tppResponse.getResponseContent(), "IPP_TRANS_DATE"));
		}else{
			String errorCode = StringUtil.getTagValue(tppResponse.getResponseContent(), "ERROR_CODE");
			
			if("40009".equals(errorCode)){
				body.setRespCode("00000");
				body.setRespMsg(StringUtil.getTagValue(tppResponse.getResponseContent(), "ERROR_MSG"));
				body.setQurRst("43005");
			}else{
				body.setRespCode(getIppCodeFromErrorCode(StringUtil.getTagValue(tppResponse.getResponseContent(), "ERROR_CODE")));
				body.setRespMsg(StringUtil.getTagValue(tppResponse.getResponseContent(), "ERROR_MSG"));
			}		
		}
		
		responseDoc.setBody(body);
		
		return responseDoc;		
	}

	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.TX_QUERY;
	}

}
