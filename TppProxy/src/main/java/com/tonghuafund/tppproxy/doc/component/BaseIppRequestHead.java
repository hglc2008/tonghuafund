package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("head")
public class BaseIppRequestHead {
	// ҵ�����
	@XStreamAlias("processing_code")
	private String processingCode;

	// ȯ�̴���
	@XStreamAlias("inst_id")
	private String instId;

	// sts����������
	@XStreamAlias("trans_date")
	private String transDate;

	// sts������ʱ��
	@XStreamAlias("trans_time")
	private String transTime;

	// �汾��
	@XStreamAlias("ver_num")
	private String verNum;

	// ǩ����Ϣ
	@XStreamAlias("sign_code")
	private String signCode;

	public String getProcessingCode() {
		return processingCode;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getVerNum() {
		return verNum;
	}

	public void setVerNum(String verNum) {
		this.verNum = verNum;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

}
