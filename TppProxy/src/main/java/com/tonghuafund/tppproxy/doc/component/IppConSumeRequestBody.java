package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class IppConSumeRequestBody extends AbstractIppRequestBodyDoc{

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("bus_num")
	private String busNum;
	
	@XStreamAlias("order_num")
	private String orderNum;
	
	@XStreamAlias("mchnt_name")
	private String mchntName;
	
	@XStreamAlias("date_settlmt")
	private String dateSettlmt;
	
	@XStreamAlias("cur_type")
	private String curType;
	
	@XStreamAlias("amt_tran")
	private String amtTran;
	
	@XStreamAlias("amt_pay")
	private String amtPay;
	
	@XStreamAlias("trace_fee")
	private String traceFee;
	
	@XStreamAlias("reqs_url")
	private String reqsUrl;
	
	@XStreamAlias("resp_url")
	private String respUrl;
	
	@XStreamAlias("addtnl_data1")
	private String addtnlData1;
	
	@XStreamAlias("addtnl_data2")
	private String addtnlData2;

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

	public String getMchntName() {
		return mchntName;
	}

	public void setMchntName(String mchntName) {
		this.mchntName = mchntName;
	}

	public String getDateSettlmt() {
		return dateSettlmt;
	}

	public void setDateSettlmt(String dateSettlmt) {
		this.dateSettlmt = dateSettlmt;
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

	public String getAddtnlData2() {
		return addtnlData2;
	}

	public void setAddtnlData2(String addtnlData2) {
		this.addtnlData2 = addtnlData2;
	}
	
}
