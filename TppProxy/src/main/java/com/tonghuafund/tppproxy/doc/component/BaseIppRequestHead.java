package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("head")
public class BaseIppRequestHead {
	// 业务编码
	@XStreamAlias("processing_code")
	private String processingCode;

	// 券商代码
	@XStreamAlias("inst_id")
	private String instId;

	// sts请求交易日期
	@XStreamAlias("trans_date")
	private String transDate;

	// sts请求交易时间
	@XStreamAlias("trans_time")
	private String transTime;

	// 版本号
	@XStreamAlias("ver_num")
	private String verNum;

	// 签名信息
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
