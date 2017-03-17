package com.tonghuafund.tppproxy.paramValid;

import org.springframework.stereotype.Service;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.IppTransferAcctRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.entity.PaymentException;

@Service("ippTransferAcctRequestDocParamValidator")
public class IppTransferAcctRequestDocParamValidator extends BaseRequestParamValidator{

	@Override
	public void validBody(AbstractIppRequestBodyDoc body)
			throws PaymentException {
		IppTransferAcctRequestBody requestBody = (IppTransferAcctRequestBody)body;
		if (StringUtil.isEmpty(requestBody.getReqTraceNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getTransferType()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAcctNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getHldName()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getAmtTran()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getDestinationChannelId()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getBnkCode()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getDestinationAcctNum()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(requestBody.getDestinationHldName()))
			throw new PaymentException("00005");
		
	}

	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.TRANSFER_ACCT;
	}

}
