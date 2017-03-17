package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppVerifyCodeResponseBody;

@XStreamAlias("transaction")
public class IppVerifyCodeResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;

	@XStreamAlias("response")
	private IppVerifyCodeResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppVerifyCodeResponseBody getBody() {
		return body;
	}

	public void setBody(IppVerifyCodeResponseBody body) {
		this.body = body;
	}
}
