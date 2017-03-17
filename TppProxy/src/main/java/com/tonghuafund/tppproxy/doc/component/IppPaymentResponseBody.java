package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class IppPaymentResponseBody extends AbstractIppResponseBodyDoc {

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;

	@XStreamAlias("channel_id")
	private String channelID;

	@XStreamAlias("date_settlmt")
	private String dateSettlmt;

	@XStreamAlias("acct_num")
	private String acctNum;

	@XStreamAlias("cur_type")
	private String curType = "156";

	// 金额以分为单位
	@XStreamAlias("amt_tran")
	private String amount;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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
