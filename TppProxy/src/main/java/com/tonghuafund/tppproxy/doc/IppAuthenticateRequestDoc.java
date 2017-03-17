package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppAuthenticateRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppAuthenticateRequestDoc extends AbstractIppRequestDoc{
	
	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppAuthenticateRequestBody body;



	public BaseIppRequestHead getHead() {
		return head;
	}



	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}



	public IppAuthenticateRequestBody getBody() {
		return body;
	}



	public void setBody(IppAuthenticateRequestBody body) {
		this.body = body;
	}



	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.AUTHENTICATE;
	}

}
