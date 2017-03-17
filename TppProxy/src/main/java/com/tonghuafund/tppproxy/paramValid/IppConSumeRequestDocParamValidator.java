package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppConSumeRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;

@Service("ippConSumeRequestDocParamValidator")
public class IppConSumeRequestDocParamValidator extends BaseRequestParamValidator{

	@Override
	public void validBody(AbstractIppRequestBodyDoc body) {
		IppConSumeRequestBody requestBody = (IppConSumeRequestBody) body;
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getBusNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getOrderNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getMchntName()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getDateSettlmt()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAmtTran()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAmtPay()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getTraceFee()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getReqsUrl()))
			throw new PaymentException("00005");
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.CONSUME;
	}
}
