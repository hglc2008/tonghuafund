package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppTxQueryResponseBody;

@XStreamAlias("transaction")
public class IppTxQueryResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;

	@XStreamAlias("response")
	private IppTxQueryResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppTxQueryResponseBody getBody() {
		return body;
	}

	public void setBody(IppTxQueryResponseBody body) {
		this.body = body;
	}
}
