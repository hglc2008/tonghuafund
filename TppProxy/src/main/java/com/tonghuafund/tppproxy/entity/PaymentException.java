package com.tonghuafund.tppproxy.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * ֧���쳣
 * 
 * @author changstone
 * 
 * @create datetime 2016��2��29��
 */
public class PaymentException extends RuntimeException {
	private static final long serialVersionUID = -3576960523537551579L;

	private static Map<String, String> errorMap = new HashMap<String, String>();

	static {
		errorMap.put("00001", "IPP������Ϊnull");
		errorMap.put("00002", "IPP����Base64�������쳣");
		errorMap.put("00003", "IPP�������Ͳ�֧��");
		errorMap.put("00004", "IPP����ǩ���쳣");
		errorMap.put("00005", "IPP�����ֶ���֤ʧ��");
		errorMap.put("00006", "�޶�Ӧ���˻���Ϣ");
	}

	/**
	 * �������.
	 */
	private String errorCode;

	/**
	 * @param message
	 * @param cause
	 */
	public PaymentException(String errorCode, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 */
	public PaymentException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	/**
	 * @param cause
	 */
	public PaymentException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 
	 * @return the description of errorCode @throws
	 */
	public String getErrorMessage() {
		return errorMap.get(errorCode);
	}
}
