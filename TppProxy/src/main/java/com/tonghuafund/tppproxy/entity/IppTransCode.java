package com.tonghuafund.tppproxy.entity;

/**
 * ipp交易类型代码
 * 
 * @author changstone
 * 
 * @create datetime 2016年2月29日
 */
public class IppTransCode {
	public static final String DEDUCT = "2001";
	public static final String PAYMENT = "2002";
	public static final String TX_QUERY = "3001";
	public static final String AUTHENTICATE = "1001";
	public static final String AUTHENTICATE_QP = "1005";
	public static final String VERIFY_CODE = "1004";
	public static final String CONTRACT_SIGN = "1002";
	public static final String TRANSFER_ACCT = "2009";
	public static final String ACCOUNT_BALANCE = "3003";
	public static final String ACCOUNT_TX_DETAIL = "3004";
	public static final String CONSUME = "5010";
	public static final String TX_REFUND = "5110";
}
