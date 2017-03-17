package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class IppAuthenticateResponseBody extends AbstractIppResponseBodyDoc{

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
	
	@XStreamAlias("resp_trace_num")
	private String respTraceNum;
	
	@XStreamAlias("resp_code")
	private String respCode;
	
	@XStreamAlias("resp_msg")
	private String respMsg;

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

	public String getRespTraceNum() {
		return respTraceNum;
	}

	public void setRespTraceNum(String respTraceNum) {
		this.respTraceNum = respTraceNum;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
}
