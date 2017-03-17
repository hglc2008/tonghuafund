package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;

@Service("ippAccountTxDetailRequestDocParamValidator")
public class IppAccountTxDetailRequestDocParamValidator extends BaseRequestParamValidator{

	@Override
	public void validBody(AbstractIppRequestBodyDoc body) {
		IppAccountTxDetailRequestBody requestBody = (IppAccountTxDetailRequestBody) body;
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAcctNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getBgnData()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getEndData()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getPageSize()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getPageIndex()))
			throw new PaymentException("00005");

	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.ACCOUNT_TX_DETAIL;
	}
}
