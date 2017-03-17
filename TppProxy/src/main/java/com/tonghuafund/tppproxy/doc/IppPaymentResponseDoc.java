package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppPaymentResponseBody;

/**
 * µ¥±Ê¸¶¿î
 * 
 * @author changlei
 * 
 */
@XStreamAlias("transaction")
public class IppPaymentResponseDoc extends AbstractIppResponseDoc {
	@XStreamAlias("head")
	private BaseIppResponseHead head;

	@XStreamAlias("response")
	private IppPaymentResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppPaymentResponseBody getBody() {
		return body;
	}

	public void setBody(IppPaymentResponseBody body) {
		this.body = body;
	}

}
