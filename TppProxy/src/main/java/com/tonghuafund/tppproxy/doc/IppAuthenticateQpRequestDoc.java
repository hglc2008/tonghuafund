package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateQpRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppAuthenticateQpRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;
	
	@XStreamAlias("request")
	private IppAuthenticateQpRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppAuthenticateQpRequestBody getBody() {
		return body;
	}

	public void setBody(IppAuthenticateQpRequestBody body) {
		this.body = body;
	}
	
	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.AUTHENTICATE_QP;
	}
}
