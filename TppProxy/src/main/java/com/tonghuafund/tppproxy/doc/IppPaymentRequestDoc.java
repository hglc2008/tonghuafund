package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppPaymentRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

/**
 * µ¥±Ê¸¶¿î
 * 
 * @author changlei
 * 
 */
@XStreamAlias("transaction")
public class IppPaymentRequestDoc  extends AbstractIppRequestDoc {
	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppPaymentRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}
	
	@Override
	public IppPaymentRequestBody getBody() {
		return body;
	}

	public void setBody(IppPaymentRequestBody body) {
		this.body = body;
	}
	@Override
	public String getSupportTransCode() {
		return IppTransCode.PAYMENT;
	}
}
