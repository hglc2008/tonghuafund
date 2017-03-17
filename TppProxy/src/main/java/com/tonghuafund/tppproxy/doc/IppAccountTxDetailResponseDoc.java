package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailResponseBody;

@XStreamAlias("transaction")
public class IppAccountTxDetailResponseDoc extends AbstractIppResponseDoc{
	
	@XStreamAlias("head")
	private BaseIppResponseHead head;
	
	@XStreamAlias("response")
	private IppAccountTxDetailResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppAccountTxDetailResponseBody getBody() {
		return body;
	}

	public void setBody(IppAccountTxDetailResponseBody body) {
		this.body = body;
	}

}
