package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppContractSignRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppContractSignRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppContractSignRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppContractSignRequestBody getBody() {
		return body;
	}

	public void setBody(IppContractSignRequestBody body) {
		this.body = body;
	}
	
	public String getSupportTransCode() {
		
		return IppTransCode.CONTRACT_SIGN;
	}
}
