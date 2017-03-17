package com.tonghuafund.tppproxy.doc;

import com.tonghuafund.tppproxy.doc.component.AbstractIppRequestBodyDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppRequestHead;
/**
 * ipp�������ĳ�����
 * @author changstone

 * @create datetime 2016��3��1��
 */
public abstract class AbstractIppRequestDoc {
	public abstract BaseIppRequestHead getHead();
	public abstract AbstractIppRequestBodyDoc getBody();
	public abstract String getSupportTransCode();
}
