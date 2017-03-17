package com.tonghuafund.tppproxy.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * ǩԼ��ϵ��
 */
public class GwContract implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id��ʶ<seq>
	 */
	private Long rowID;

	/**
	 * ����ID
	 */
	private String agentID;

	/**
	 * �̻���
	 */
	private String mchtID;

	/**
	 * �˻�����
	 */
	private String acctCat;

	/**
	 * �����˻�����
	 */
	private String acctName;

	/**
	 * �����˻�
	 */
	private String acctNo;

	/**
	 * ֤������
	 */
	private String idCardType;

	/**
	 * ֤����
	 */
	private String idCardNO;

	/**
	 * �̻�ǩԼЭ���
	 */
	private String mchtContractNO;

	/**
	 * ����ǩԼЭ���
	 */
	private String bankContractNO;

	/**
	 * Э��״̬
	 */
	private Short sate;

	/**
	 * ����ʱ��
	 */
	private Date createDatetime;

	/**
	 * ������¼�Ĳ���Ա
	 */
	private String createOperator;

	/**
	 * ������ʱ��
	 */
	private Date lastUpdateDatetime;

	/**
	 * �����µĲ���Ա
	 */
	private String lastUpdateOperator;

	/**
	 * ����ǩԼЭ�����������ID
	 */
	private Integer channelID;

	/**
	 * �绰����
	 */
	private String phoneNO;

	/**
	 * �����޶�
	 */
	private Long quotaPerOrder;

	/**
	 * �����޶�
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