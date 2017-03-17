package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppContractSignResponseBody;

@XStreamAlias("transaction")
public class IppContractSignResponseDoc extends AbstractIppResponseDoc{

	@XStreamAlias("head")
	private BaseIppResponseHead head;
	
	@XStreamAlias("response")
	private IppContractSignResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppContractSignResponseBody getBody() {
		return body;
	}

	public void setBody(IppContractSignResponseBody body) {
		this.body = body;
	}
}
