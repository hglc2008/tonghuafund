package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppDeductRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;
@Service("ippDeductRequestDocParamValidator")
public class IppDeductRequestDocParamValidator extends BaseRequestParamValidator {

	@Override
	public void validBody(AbstractIppRequestBodyDoc body) throws PaymentException {
		IppDeductRequestBody requestBody = (IppDeductRequestBody) body;
		if (StringUtil.isEmpty(requestBody.getAcctNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAmount()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getChannelID()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");

	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.DEDUCT;
	}

}
