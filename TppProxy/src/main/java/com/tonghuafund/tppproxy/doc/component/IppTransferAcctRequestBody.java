package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class IppTransferAcctRequestBody extends AbstractIppRequestBodyDoc{

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("channel_id")
	private String channelID;

	@XStreamAlias("transfer_type")
	private String transferType;
	
	@XStreamAlias("acct_type")
	private String acctType;
	
	@XStreamAlias("acct_num")
	private String acctNum;
	
	@XStreamAlias("hld_name")
	private String hldName;
	
	@XStreamAlias("cur_type")
	private String curType;
	
	@XStreamAlias("amt_tran")
	private String amtTran;
	
	@XStreamAlias("destination_channel_id")
	private String destinationChannelId;
	
	@XStreamAlias("bnk_code")
	private String bnkCode;
	
	@XStreamAlias("bnk_province")
	private String bnkProvince;
	
	@XStreamAlias("bnk_city")
	private String bnkCity;
	
	@XStreamAlias("destination_acct_type")
	private String destinationAcctType;
	
	@XStreamAlias("destination_acct_num")
	private String destinationAcctNum;
	
	@XStreamAlias("destination_hld_name")
	private String destinationHldName;
	
	@XStreamAlias("resp_url")
	private String respUrl;
	
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

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
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

	public String getBnkCode() {
		return bnkCode;
	}

	public void setBnkCode(String bnkCode) {
		this.bnkCode = bnkCode;
	}

	public String getBnkProvince() {
		return bnkProvince;
	}

	public void setBnkProvince(String bnkProvince) {
		this.bnkProvince = bnkProvince;
	}

	public String getBnkCity() {
		return bnkCity;
	}

	public void setBnkCity(String bnkCity) {
		this.bnkCity = bnkCity;
	}

	public String getDestinationAcctType() {
		return destinationAcctType;
	}

	public void setDestinationAcctType(String destinationAcctType) {
		this.destinationAcctType = destinationAcctType;
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
	
}
