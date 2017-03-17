package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4001交易，未决交易查询
 * 
 * @author changstone
 * 
 * @create datetime 2016年2月29日
 */
@XStreamAlias("request")
public class IppTxQueryRequestBody extends AbstractIppRequestBodyDoc {

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;

	@XStreamAlias("org_req_trace_num")
	private String orgReqTraceNum;

	@XStreamAlias("org_trans_date")
	private String orgTransDate;

	@XStreamAlias("addtnl_data1")
	private String addtnlData1;

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

	public String getAddtnlData1() {
		return addtnlData1;
	}

	public void setAddtnlData1(String addtnlData1) {
		this.addtnlData1 = addtnlData1;
	}

}
