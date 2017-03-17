package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppDeductResponseBody;

/**
 * µ¥±Ê¿Û¿î
 * 
 * @author changlei
 * 
 */
@XStreamAlias("transaction")
public class IppDeductResponseDoc extends AbstractIppResponseDoc {
	@XStreamAlias("head")
	private BaseIppResponseHead head;

	@XStreamAlias("response")
	private IppDeductResponseBody body;

	public BaseIppResponseHead getHead() {
		return head;
	}

	public void setHead(BaseIppResponseHead head) {
		this.head = head;
	}

	public IppDeductResponseBody getBody() {
		return body;
	}

	public void setBody(IppDeductResponseBody body) {
		this.body = body;
	}

}
