package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppTransferAcctResponseBody;

@XStreamAlias("transaction")
public class IppTransferAcctResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;

	@XStreamAlias("response")
	private IppTransferAcctResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppTransferAcctResponseBody getBody() {
		return body;
	}

	public void setBody(IppTransferAcctResponseBody body) {
		this.body = body;
	}
}
