package com.tonghuafund.tppproxy.msgTransformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.allinpay.ipps.entity.PaymentResponse;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;

/**
 * 把tpp的响应报文，转成ipp的响应报文
 * 
 * @author changstone
 *
 * @create datetime 2016年3月1日
 */
public abstract class BaseResponseMsgTransformer {
	protected DateFormat dateformatDate = new SimpleDateFormat("yyyyMMdd");
	protected DateFormat dateformatTime = new SimpleDateFormat("HHmmss");

	private static Map<String, String> errorCode2IppCode = new HashMap<String, String>();
	// private static Map<String, String> retCode2IppCode = new HashMap<String,
	// String>();

	static {
		errorCode2IppCode.put("000000", "00000");
		errorCode2IppCode.put("100000", "10000");
		errorCode2IppCode.put("200000", "20000");
		errorCode2IppCode.put("00002", "43017");
		errorCode2IppCode.put("00002", "43017");
		errorCode2IppCode.put("00003", "43017");
		errorCode2IppCode.put("42001", "43017");
		errorCode2IppCode.put("42002", "43017");
		errorCode2IppCode.put("42003", "43017");
		errorCode2IppCode.put("42005", "43017");
		errorCode2IppCode.put("40014", "43017");

	}

	public static String getIppCodeFromErrorCode(String errorCode) {
		String ippCode = errorCode2IppCode.get(errorCode);
		if (ippCode == null) {
			ippCode = "43030";
		}
		return ippCode;
	}

	public static String getIppCodeFromRetCode(String errorCode) {
		return errorCode.substring(0,5);
	}

	public abstract AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse);

	// 支持的交易类型
	public abstract String getSupportTransCode();
}
