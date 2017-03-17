package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class IppTxRefundRequestBody extends AbstractIppRequestBodyDoc{

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("org_req_trace_num")
	private String orgReqTraceNum;
	
	@XStreamAlias("org_trans_date")
	private String orgTransDate;
	
	@XStreamAlias("date_settlmt")
	private String dateSettlmt;
	
	@XStreamAlias("cur_type")
	private String curType;
	
	@XStreamAlias("amt_tran")
	private String amtTran;
	
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

	public String getOrgReqTraceNum() {
		return orgReqTraceNum;
	}

	public void setOrgReqTraceNum(String orgReqTraceNum) {
		this.orgReqTraceNum = orgReqTraceNum;
	}

	public String getOrgTransDate() {
		return orgTransDate;
	}

	public void setOrgTransDate(String orgTransDate) {
		this.orgTransDate = orgTransDate;
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
