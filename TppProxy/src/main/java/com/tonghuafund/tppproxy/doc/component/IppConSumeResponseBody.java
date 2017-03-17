package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class IppConSumeResponseBody extends AbstractIppResponseBodyDoc{
	
	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("bus_num")
	private String busNum;
	
	@XStreamAlias("order_num")
	private String orderNum;
	
	@XStreamAlias("date_settlmt")
	private String dateSettlmt;
	
	@XStreamAlias("amt_tran")
	private String amtTran;
	
	@XStreamAlias("amt_pay")
	private String amtPay;
	
	@XStreamAlias("trace_fee")
	private String traceFee;
	
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

	public String getBusNum() {
		return busNum;
	}

	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDateSettlmt() {
		return dateSettlmt;
	}

	public void setDateSettlmt(String dateSettlmt) {
		this.dateSettlmt = dateSettlmt;
	}

	public String getAmtTran() {
		return amtTran;
	}

	public void setAmtTran(String amtTran) {
		this.amtTran = amtTran;
	}

	public String getAmtPay() {
		return amtPay;
	}

	public void setAmtPay(String amtPay) {
		this.amtPay = amtPay;
	}

	public String getTraceFee() {
		return traceFee;
	}

	public void setTraceFee(String traceFee) {
		this.traceFee = traceFee;
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
