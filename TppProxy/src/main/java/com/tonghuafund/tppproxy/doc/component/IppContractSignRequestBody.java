package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class IppContractSignRequestBody extends AbstractIppRequestBodyDoc{

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("channel_id")
	private String channelID;

	@XStreamAlias("date_settlmt")
	private String dateSettlmt;
	
	@XStreamAlias("acct_type")
	private String acctType;

	@XStreamAlias("acct_num")
	private String acctNum;
	
	@XStreamAlias("hld_name")
	private String hldName;
	
	@XStreamAlias("cer_type")
	private String cerType;
	
	@XStreamAlias("cer_num")
	private String cerNum;
	
	@XStreamAlias("tel_num")
	private String telNum;
	
	@XStreamAlias("reqs_url")
	private String reqsUrl;
	
	@XStreamAlias("resp_url")
	private String respUrl;
	
	@XStreamAlias("addtnl_data1")
	private String addtnlData1;

	public String getReqTraceNum() {
		return reqTraceNum;
	}

	public void setReqTraceNum(String reqTraceNum) {
		this.reqTraceNum = reqTraceNum;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public String getDateSettlmt() {
		return dateSettlmt;
	}

	public void setDateSettlmt(String dateSettlmt) {
		this.dateSettlmt = dateSettlmt;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getHldName() {
		return hldName;
	}

	public void setHldName(String hldName) {
		this.hldName = hldName;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getCerNum() {
		return cerNum;
	}

	public void setCerNum(String cerNum) {
		this.cerNum = cerNum;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getReqsUrl() {
		return reqsUrl;
	}

	public void setReqsUrl(String reqsUrl) {
		this.reqsUrl = reqsUrl;
	}

	public String getRespUrl() {
		return respUrl;
	}

	public void setRespUrl(String respUrl) {
		this.respUrl = respUrl;
	}

	public String getAddtnlData1() {
		return addtnlData1;
	}

	public void setAddtnlData1(String addtnlData1) {
		this.addtnlData1 = addtnlData1;
	}
}
