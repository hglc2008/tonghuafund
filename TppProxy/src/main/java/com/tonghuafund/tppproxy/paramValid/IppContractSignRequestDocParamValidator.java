package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppContractSignRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;

@Service("ippContractSignRequestDocParamValidator")
public class IppContractSignRequestDocParamValidator extends BaseRequestParamValidator{

	@Override
	public void validBody(AbstractIppRequestBodyDoc body) throws PaymentException {
		IppContractSignRequestBody requestBody = (IppContractSignRequestBody) body;
		if (StringUtil.isEmpty(requestBody.getAcctNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAcctType()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getDateSettlmt()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getHldName()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getCerType()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getCerNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getReqsUrl()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getRespUrl()))
			throw new PaymentException("00005");
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.CONTRACT_SIGN;
	}
}
