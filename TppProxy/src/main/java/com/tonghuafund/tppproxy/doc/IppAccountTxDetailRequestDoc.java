package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppAccountTxDetailRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;
	
	@XStreamAlias("request")
	private IppAccountTxDetailRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppAccountTxDetailRequestBody getBody() {
		return body;
	}

	public void setBody(IppAccountTxDetailRequestBody body) {
		this.body = body;
	}
	
	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.ACCOUNT_TX_DETAIL;
	}
}
