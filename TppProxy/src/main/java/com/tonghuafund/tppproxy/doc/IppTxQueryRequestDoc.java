package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppTxQueryRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

/**
 * 未决交易查询
 * 
 * @author changlei
 * 
 */
@XStreamAlias("transaction")
public class IppTxQueryRequestDoc extends AbstractIppRequestDoc {
	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppTxQueryRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppTxQueryRequestBody getBody() {
		return body;
	}

	public void setBody(IppTxQueryRequestBody body) {
		this.body = body;
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.TX_QUERY;
	}
}
