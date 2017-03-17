package com.tonghuafund.tppproxy.paramValid;

import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.entity.PaymentException;

/**
 * 验证ipp请求报文
 * 
 * @author changstone
 * 
 * @create datetime 2016年2月29日
 */
public abstract class BaseRequestParamValidator {
	public void validRequestMsg(AbstractIppRequestDoc requestDoc) throws PaymentException {
		validHead(requestDoc.getHead());
		validBody(requestDoc.getBody());
	}

	public void validHead(BaseIppRequestHead head) throws PaymentException {
		if (StringUtil.isEmpty(head.getInstId()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(head.getProcessingCode()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(head.getTransDate()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(head.getTransTime()))
			throw new PaymentException("00005");
		if (StringUtil.isEmpty(head.getVerNum()))
			throw new PaymentException("00005");
	}

	public abstract void validBody(AbstractIppRequestBodyDoc body)throws PaymentException ;

	public abstract String getSupportTransCode();
}
