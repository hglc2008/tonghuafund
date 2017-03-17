package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class IppTransferAcctResponseBody extends AbstractIppResponseBodyDoc{
	
	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("acct_num")
	private String acctNum;
	
	@XStreamAlias("cur_type")
	private String curType;
	
	@XStreamAlias("amt_tran")
	private String amtTran;
	
	@XStreamAlias("destination_channel_id")
	private String destinationChannelId;
	
	@XStreamAlias("destination_acct_num")
	private String destinationAcctNum;
	
	@XStreamAlias("destination_hld_name")
	private String destinationHldName;
	
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

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getCurType() {
		return curType;
	}

	public void setCurType(String curType) {
		this.curType = curType;
	}

	public String getAmtTran() {
		return amtTran;
	}

	public void setAmtTran(String amtTran) {
		this.amtTran = amtTran;
	}

	public String getDestinationChannelId() {
		return destinationChannelId;
	}

	public void setDestinationChannelId(String destinationChannelId) {
		this.destinationChannelId = destinationChannelId;
	}

	public String getDestinationAcctNum() {
		return destinationAcctNum;
	}

	public void setDestinationAcctNum(String destinationAcctNum) {
		this.destinationAcctNum = destinationAcctNum;
	}

	public String getDestinationHldName() {
		return destinationHldName;
	}

	public void setDestinationHldName(String destinationHldName) {
		this.destinationHldName = destinationHldName;
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
