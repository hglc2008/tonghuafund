package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppTxRefundResponseBody;

@XStreamAlias("transaction")
public class IppTxRefundResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;

	@XStreamAlias("response")
	private IppTxRefundResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppTxRefundResponseBody getBody() {
		return body;
	}

	public void setBody(IppTxRefundResponseBody body) {
		this.body = body;
	}
}
