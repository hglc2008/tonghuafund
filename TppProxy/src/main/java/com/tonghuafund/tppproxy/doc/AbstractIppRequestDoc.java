package com.tonghuafund.tppproxy.doc;

import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
/**
 * ipp的请求报文抽象类
 * @author changstone

 * @create datetime 2016年3月1日
 */
public abstract class AbstractIppRequestDoc {
	public abstract BaseIppRequestHead getHead();
	public abstract AbstractIppRequestBodyDoc getBody();
	public abstract String getSupportTransCode();
}
