package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateQpResponseBody;

@XStreamAlias("transaction")
public class IppAuthenticateQpResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;
	
	@XStreamAlias("response")
	private IppAuthenticateQpResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppAuthenticateQpResponseBody getBody() {
		return body;
	}

	public void setBody(IppAuthenticateQpResponseBody body) {
		this.body = body;
	}
}
