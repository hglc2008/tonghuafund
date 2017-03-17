package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("transItems")
public class IppAccountTxDetailTransItems {

	@XStreamAlias("sequence_num")
	private String sequenceNum;
	
	@XStreamAlias("tran_date")
	private String tranDate;
	
	@XStreamAlias("tran_time")
	private String tranTime;
	
	@XStreamAlias("amt_tran")
	private String amtTran;
	
	@XStreamAlias("balance_amt")
	private String balanceAmt;
	
	@XStreamAlias("dorc_msg")
	private String dorcMsg;
	
	@XStreamAlias("destination_acct_num")
	private String destinationAcctNum;
	
	@XStreamAlias("destination_hld_name")
	private String destinationHldName;
	
	@XStreamAlias("abstract_msg")
	private String abstractMsg;
	
	@XStreamAlias("trace_num")
	private String traceNum;

	public String getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(String sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getAmtTran() {
		return amtTran;
	}

	public void setAmtTran(String amtTran) {
		this.amtTran = amtTran;
	}

	public String getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(String balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	public String getDorcMsg() {
		return dorcMsg;
	}

	public void setDorcMsg(String dorcMsg) {
		this.dorcMsg = dorcMsg;
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

	public String getAbstractMsg() {
		return abstractMsg;
	}

	public void setAbstractMsg(String abstractMsg) {
		this.abstractMsg = abstractMsg;
	}

	public String getTraceNum() {
		return traceNum;
	}

	public void setTraceNum(String traceNum) {
		this.traceNum = traceNum;
	}
}
