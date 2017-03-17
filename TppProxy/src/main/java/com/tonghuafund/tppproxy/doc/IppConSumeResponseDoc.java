package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppConSumeResponseBody;

@XStreamAlias("transaction")
public class IppConSumeResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;
	
	@XStreamAlias("response")
	private IppConSumeResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppConSumeResponseBody getBody() {
		return body;
	}

	public void setBody(IppConSumeResponseBody body) {
		this.body = body;
	}
}
