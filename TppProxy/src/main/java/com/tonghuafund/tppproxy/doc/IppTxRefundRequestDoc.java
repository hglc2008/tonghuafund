package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppTxRefundRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

@XStreamAlias("transaction")
public class IppTxRefundRequestDoc extends AbstractIppRequestDoc{

	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppTxRefundRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppTxRefundRequestBody getBody() {
		return body;
	}

	public void setBody(IppTxRefundRequestBody body) {
		this.body = body;
	}
	
	@Override
	public String getSupportTransCode() {
		
		return IppTransCode.TX_REFUND;
	}
}
