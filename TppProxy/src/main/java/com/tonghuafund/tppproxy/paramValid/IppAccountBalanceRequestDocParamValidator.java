package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppAccountBalanceRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;

@Service("ippAccountBalanceRequestDocParamValidator")
public class IppAccountBalanceRequestDocParamValidator extends BaseRequestParamValidator{

	@Override
	public void validBody(AbstractIppRequestBodyDoc body) {
		IppAccountBalanceRequestBody requestBody = (IppAccountBalanceRequestBody) body;
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAcctNum()))
			throw new PaymentException("00005");
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.ACCOUNT_BALANCE;
	}
}
