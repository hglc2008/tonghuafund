package com.tonghuafund.tppproxy.doc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
import com.tonghuafund.tppproxy.doc.component.IppDeductRequestBody;
import com.tonghuafund.tppproxy.entity.IppTransCode;

/**
 * µ¥±Ê¿Û¿î
 * 
 * @author changlei
 * 
 */
@XStreamAlias("transaction")
public class IppDeductRequestDoc extends AbstractIppRequestDoc{
	@XStreamAlias("head")
	private BaseIppRequestHead head;

	@XStreamAlias("request")
	private IppDeductRequestBody body;

	public BaseIppRequestHead getHead() {
		return head;
	}

	public void setHead(BaseIppRequestHead head) {
		this.head = head;
	}

	public IppDeductRequestBody getBody() {
		return body;
	}

	public void setBody(IppDeductRequestBody body) {
		this.body = body;
	}
	
	@Override
	public String getSupportTransCode() {
		return IppTransCode.DEDUCT;
	}
}
