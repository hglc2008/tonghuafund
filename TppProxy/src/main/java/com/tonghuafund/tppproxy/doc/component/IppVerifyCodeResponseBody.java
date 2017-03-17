package com.tonghuafund.tppproxy.doc.component;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class IppVerifyCodeResponseBody extends AbstractIppResponseBodyDoc{

	@XStreamAlias("req_trace_num")
	private String reqTraceNum;

	@XStreamAlias("org_req_trace_num")
	private String orgReqTraceNum;

	@XStreamAlias("org_trans_date")
	private String orgTransDate;
	
	@XStreamAlias("verify_code")
	private String verifyCode;
	
	@XStreamAlias("resp_trace_num")
	private String respTraceNum;
	
	@XStreamAlias("resp_code")
	private String respCode;
	
	@XStreamAlias("resp_msg")
	private String respMsg;
	
	@XStreamAlias("org_date_settlmt")
	private String orgDateSettlmt;

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

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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

	public String getOrgDateSettlmt() {
		return orgDateSettlmt;
	}

	public void setOrgDateSettlmt(String orgDateSettlmt) {
		this.orgDateSettlmt = orgDateSettlmt;
	}
}
