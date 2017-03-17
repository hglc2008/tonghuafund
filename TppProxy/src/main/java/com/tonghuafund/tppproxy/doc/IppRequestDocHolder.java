package com.tonghuafund.tppproxy.doc;

import java.util.HashMap;
import java.util.Map;

import com.tonghuafund.tppproxy.entity.IppTransCode;

public class IppRequestDocHolder {
	private static IppRequestDocHolder instance;

	private Map<String, AbstractIppRequestDoc> requestDocMap = null;

	private IppRequestDocHolder() {
		super();
		requestDocMap = new HashMap<String, AbstractIppRequestDoc>();
		requestDocMap.put(IppTransCode.DEDUCT, new IppDeductRequestDoc());
		requestDocMap.put(IppTransCode.PAYMENT, new IppPaymentRequestDoc());
		requestDocMap.put(IppTransCode.TX_QUERY, new IppTxQueryRequestDoc());
		requestDocMap.put(IppTransCode.AUTHENTICATE, new IppAuthenticateRequestDoc());
		requestDocMap.put(IppTransCode.AUTHENTICATE_QP,new IppAuthenticateQpRequestDoc());
		requestDocMap.put(IppTransCode.VERIFY_CODE,new IppVerifyCodeRequestDoc());
		requestDocMap.put(IppTransCode.CONTRACT_SIGN,new IppContractSignRequestDoc());
		requestDocMap.put(IppTransCode.TRANSFER_ACCT,new IppTransferAcctRequestDoc());
		requestDocMap.put(IppTransCode.ACCOUNT_BALANCE,new IppAccountBalanceRequestDoc());
		requestDocMap.put(IppTransCode.ACCOUNT_TX_DETAIL,new IppAccountTxDetailRequestDoc());
		requestDocMap.put(IppTransCode.CONSUME,new IppConSumeRequestDoc());
		requestDocMap.put(IppTransCode.TX_REFUND,new IppTxRefundRequestDoc());
	}

	public AbstractIppRequestDoc getBeanRequestDoc(String transCode) {
		return requestDocMap.get(transCode);
	}

	public static IppRequestDocHolder getInstance() {
		if (instance == null) {
			instance = new IppRequestDocHolder();
		}
		return instance;
	}

}
