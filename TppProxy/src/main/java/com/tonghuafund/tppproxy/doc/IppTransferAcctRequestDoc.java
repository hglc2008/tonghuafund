package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppTransferAcctRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppTransferAcctRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppTransferAcctRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppTransferAcctRequestBody getBody() {
		return body;
	}

	public void setBody(IppTransferAcctRequestBody body) {
		this.body = body;
	}
	
	public String getSupportTransCode() {
		
		return IppTransCode.TRANSFER_ACCT;
	}
}
