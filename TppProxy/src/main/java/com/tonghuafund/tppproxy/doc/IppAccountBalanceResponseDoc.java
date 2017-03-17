package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppAccountBalanceResponseBody;

@XStreamAlias("transaction")
public class IppAccountBalanceResponseDoc extends AbstractIppResponseDoc{
	
	@XStreamAlias("head")
	private BaseIppResponseHead head;
	
	@XStreamAlias("response")
	private IppAccountBalanceResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppAccountBalanceResponseBody getBody() {
		return body;
	}

	public void setBody(IppAccountBalanceResponseBody body) {
		this.body = body;
	}

}
