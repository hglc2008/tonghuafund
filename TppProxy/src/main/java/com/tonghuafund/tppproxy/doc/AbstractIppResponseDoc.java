package com.tonghuafund.tppproxy.doc;

import com.tonghuafund.tppproxy.doc.component.AbstractIppResponseBodyDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
/**
 * ipp����Ӧ���ĳ�����
 * @author changstone

 * @create datetime 2016��3��1��
 */
public abstract class AbstractIppResponseDoc {
	public abstract BaseIppResponseHead getHead();
	public abstract AbstractIppResponseBodyDoc getBody();
}
