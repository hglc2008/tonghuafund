package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppAccountBalanceRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppAccountBalanceRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;
	
	@XStreamAlias("request")
	private IppAccountBalanceRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppAccountBalanceRequestBody getBody() {
		return body;
	}

	public void setBody(IppAccountBalanceRequestBody body) {
		this.body = body;
	}
	
	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.ACCOUNT_BALANCE;
	}
}
