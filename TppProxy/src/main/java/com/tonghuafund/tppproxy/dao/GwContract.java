package com.tonghuafund.tppproxy.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * 签约关系表
 */
public class GwContract implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id标识<seq>
	 */
	private Long rowID;

	/**
	 * 代理ID
	 */
	private String agentID;

	/**
	 * 商户号
	 */
	private String mchtID;

	/**
	 * 账户类型
	 */
	private String acctCat;

	/**
	 * 银行账户名称
	 */
	private String acctName;

	/**
	 * 银行账户
	 */
	private String acctNo;

	/**
	 * 证件类型
	 */
	private String idCardType;

	/**
	 * 证件号
	 */
	private String idCardNO;

	/**
	 * 商户签约协议号
	 */
	private String mchtContractNO;

	/**
	 * 银行签约协议号
	 */
	private String bankContractNO;

	/**
	 * 协议状态
	 */
	private Short sate;

	/**
	 * 创建时间
	 */
	private Date createDatetime;

	/**
	 * 创建记录的操作员
	 */
	private String createOperator;

	/**
	 * 最后更新时间
	 */
	private Date lastUpdateDatetime;

	/**
	 * 最后更新的操作员
	 */
	private String lastUpdateOperator;

	/**
	 * 银行签约协议号所属渠道ID
	 */
	private Integer channelID;

	/**
	 * 电话号码
	 */
	private String phoneNO;

	/**
	 * 单笔限额
	 */
	private Long quotaPerOrder;

	/**
	 * 单日限额
	 */
	private Long quotaPerDay;

	public Long getRowID() {
		return rowID;
	}

	public void setRowID(Long rowID) {
		this.rowID = rowID;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public String getMchtID() {
		return mchtID;
	}

	public void setMchtID(String mchtID) {
		this.mchtID = mchtID;
	}

	public String getAcctCat() {
		return acctCat;
	}

	public void setAcctCat(String acctCat) {
		this.acctCat = acctCat;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getIdCardNO() {
		return idCardNO;
	}

	public void setIdCardNO(String idCardNO) {
		this.idCardNO = idCardNO;
	}

	public String getMchtContractNO() {
		return mchtContractNO;
	}

	public void setMchtContractNO(String mchtContractNO) {
		this.mchtContractNO = mchtContractNO;
	}

	public String getBankContractNO() {
		return bankContractNO;
	}

	public void setBankContractNO(String bankContractNO) {
		this.bankContractNO = bankContractNO;
	}

	public Short getSate() {
		return sate;
	}

	public void setSate(Short sate) {
		this.sate = sate;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public Date getLastUpdateDatetime() {
		return lastUpdateDatetime;
	}

	public void setLastUpdateDatetime(Date lastUpdateDatetime) {
		this.lastUpdateDatetime = lastUpdateDatetime;
	}

	public String getLastUpdateOperator() {
		return lastUpdateOperator;
	}

	public void setLastUpdateOperator(String lastUpdateOperator) {
		this.lastUpdateOperator = lastUpdateOperator;
	}

	public Integer getChannelID() {
		return channelID;
	}

	public void setChannelID(Integer channelID) {
		this.channelID = channelID;
	}

	public String getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	public Long getQuotaPerOrder() {
		return quotaPerOrder;
	}

	public void setQuotaPerOrder(Long quotaPerOrder) {
		this.quotaPerOrder = quotaPerOrder;
	}

	public Long getQuotaPerDay() {
		return quotaPerDay;
	}

	public void setQuotaPerDay(Long quotaPerDay) {
		this.quotaPerDay = quotaPerDay;
	}

}