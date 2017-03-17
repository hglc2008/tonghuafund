package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppVerifyCodeRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppVerifyCodeRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;
	
	@XStreamAlias("request")
	private IppVerifyCodeRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppVerifyCodeRequestBody getBody() {
		return body;
	}

	public void setBody(IppVerifyCodeRequestBody body) {
		this.body = body;
	}
	
	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.VERIFY_CODE;
	}
}
