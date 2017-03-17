package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class IppAccountTxDetailRequestBody extends AbstractIppRequestBodyDoc{

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("channel_id")
	private String channelId;
	
	@XStreamAlias("acct_type")
	private String acctType;
	
	@XStreamAlias("acct_num")
	private String acctNum;
	
	@XStreamAlias("hld_name")
	private String hldName;
	
	@XStreamAlias("bgn_data")
	private String bgnData;
	
	@XStreamAlias("end_data")
	private String endData;
	
	@XStreamAlias("page_size")
	private String pageSize;
	
	@XStreamAlias("page_index")
	private String pageIndex;
	
	@XStreamAlias("addtnl_data1")
	private String addtnlData1;

	public String getReqTraceNum() {
		return reqTraceNum;
	}

	public void setReqTraceNum(String reqTraceNum) {
		this.reqTraceNum = reqTraceNum;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public String getBgnData() {
		return bgnData;
	}

	public void setBgnData(String bgnData) {
		this.bgnData = bgnData;
	}

	public String getEndData() {
		return endData;
	}

	public void setEndData(String endData) {
		this.endData = endData;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getAddtnlData1() {
		return addtnlData1;
	}

	public void setAddtnlData1(String addtnlData1) {
		this.addtnlData1 = addtnlData1;
	}
}
