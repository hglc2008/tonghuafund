package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppVerifyCodeRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;

@Service("ippVerifyCodeRequestDocParamValidator")
public class IppVerifyCodeRequestDocParamValidator extends BaseRequestParamValidator{

	@Override
	public void validBody(AbstractIppRequestBodyDoc body) throws PaymentException {
		IppVerifyCodeRequestBody requestBody = (IppVerifyCodeRequestBody) body;
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getOrgReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getOrgTransDate()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getVerifyCode()))
			throw new PaymentException("00005");
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.VERIFY_CODE;
	}
}
