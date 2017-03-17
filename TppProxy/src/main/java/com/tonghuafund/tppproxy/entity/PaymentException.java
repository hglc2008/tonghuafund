package com.tonghuafund.tppproxy.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付异常
 * 
 * @author changstone
 * 
 * @create datetime 2016年2月29日
 */
public class PaymentException extends RuntimeException {
	private static final long serialVersionUID = -3576960523537551579L;

	private static Map<String, String> errorMap = new HashMap<String, String>();

	static {
		errorMap.put("00001", "IPP请求报文为null");
		errorMap.put("00002", "IPP请求Base64反编码异常");
		errorMap.put("00003", "IPP请求类型不支持");
		errorMap.put("00004", "IPP请求签名异常");
		errorMap.put("00005", "IPP请求字段验证失败");
		errorMap.put("00006", "无对应的账户信息");
	}

	/**
	 * 错误代码.
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
