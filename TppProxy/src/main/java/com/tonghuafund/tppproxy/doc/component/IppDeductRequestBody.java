package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class IppDeductRequestBody extends AbstractIppRequestBodyDoc{

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

	@XStreamAlias("cur_type")
	private String curType = "156";

	// 金额以分为单位
	@XStreamAlias("amt_tran")
	private String amount;

	@XStreamAlias("abstract_msg")
	private String abstractMsg;

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

	public String getAbstractMsg() {
		return abstractMsg;
	}

	public void setAbstractMsg(String abstractMsg) {
		this.abstractMsg = abstractMsg;
	}

	public String getAddtnlData1() {
		return addtnlData1;
	}

	public void setAddtnlData1(String addtnlData1) {
		this.addtnlData1 = addtnlData1;
	}

}
