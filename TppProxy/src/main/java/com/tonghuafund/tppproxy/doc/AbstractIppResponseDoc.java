package com.tonghuafund.tppproxy.doc;

import com.tonghuafund.tppproxy.doc.component.AbstractIppResponseBodyDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
/**
 * ipp的响应报文抽象类
 * @author changstone

 * @create datetime 2016年3月1日
 */
public abstract class AbstractIppResponseDoc {
	public abstract BaseIppResponseHead getHead();
	public abstract AbstractIppResponseBodyDoc getBody();
}
