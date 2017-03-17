package com.tonghuafund.tppproxy.doc.component;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("response")
public class IppAccountTxDetailResponseBody extends AbstractIppResponseBodyDoc{
	
	@XStreamAlias("req_trace_num")
	private String reqTraceNum;
	
	@XStreamAlias("channel_id")
	private String channelId;
	
	@XStreamAlias("acct_num")
	private String acctNum;
	
	@XStreamAlias("page_index")
	private String pageIndex;
	
	@XStreamAlias("resp_trace_num")
	private String respTraceNum;
	
	@XStreamAlias("total_page")
	private String totalPage;
	
	@XStreamAlias("page_pos_str")
	private String pagePosStr;
	
	@XStreamAlias("page_more_flag")
	private String pageMoreFlag;
	
	@XStreamAlias("page_rec_num")
	private String pageRecNum;
	
	@XStreamAlias("cur_type")
	private String curType;
	
	@XStreamAlias("resp_code")
	private String respCode;
	
	@XStreamAlias("resp_msg")
	private String respMsg;
	
	@XStreamImplicit
	private List<IppAccountTxDetailTransItems> transItems;

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

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getRespTraceNum() {
		return respTraceNum;
	}

	public void setRespTraceNum(String respTraceNum) {
		this.respTraceNum = respTraceNum;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getPagePosStr() {
		return pagePosStr;
	}

	public void setPagePosStr(String pagePosStr) {
		this.pagePosStr = pagePosStr;
	}

	public String getPageMoreFlag() {
		return pageMoreFlag;
	}

	public void setPageMoreFlag(String pageMoreFlag) {
		this.pageMoreFlag = pageMoreFlag;
	}

	public String getPageRecNum() {
		return pageRecNum;
	}

	public void setPageRecNum(String pageRecNum) {
		this.pageRecNum = pageRecNum;
	}

	public String getCurType() {
		return curType;
	}

	public void setCurType(String curType) {
		this.curType = curType;
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

	public List<IppAccountTxDetailTransItems> getTransItems() {
		return transItems;
	}

	public void setTransItems(List<IppAccountTxDetailTransItems> transItems) {
		this.transItems = transItems;
	}
}
