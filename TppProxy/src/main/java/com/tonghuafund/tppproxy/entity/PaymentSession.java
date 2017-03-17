package com.tonghuafund.tppproxy.entity;

import java.io.Serializable;

import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.component.AbstractIppResponseBodyDoc;

/**
 * ֧������
 * 
 * @author changstone
 * 
 * @create datetime 2016��2��29��
 */
public class PaymentSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7427591147961641044L;
	/**
	 * ������Ψһ��ʶ��
	 */
	private String entityID;
	private String transCode;
	private String requestContent;
	private String responseContent;
	private AbstractIppRequestDoc ippRequestDoc;
	private AbstractIppResponseDoc ippResponseDoc;
	private int payState;
	private int state;

	public String getEntityID() {
		return entityID;
	}

	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public int getPayState() {
		return payState;
	}

	public void setPayState(int payState) {
		this.payState = payState;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public AbstractIppRequestDoc getIppRequestDoc() {
		return ippRequestDoc;
	}

	public void setIppRequestDoc(AbstractIppRequestDoc ippRequestDoc) {
		this.ippRequestDoc = ippRequestDoc;
	}

	public AbstractIppResponseDoc getIppResponseDoc() {
		return ippResponseDoc;
	}

	public void setIppResponseDoc(AbstractIppResponseDoc ippResponseDoc) {
		this.ippResponseDoc = ippResponseDoc;
	}

	/**
	 * ����֧��״̬
	 * 
	 * @param payState
	 */
	public void updatetPayState(int payState) {
		this.payState = payState;
		state = (state | payState);
	}

}
