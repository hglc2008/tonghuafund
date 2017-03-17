package com.tonghuafund.tppproxy.msgTransformer.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10ResponseDetailItem;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10ResponseDetailItemArray;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10ResponseQueryInfo;
import com.allinpay.ipps.entity.component.v10.underlie.AccountTxDetailV10ResponseTxInfo;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppAccountTxDetailResponseDoc;
import com.tonghuafund.tppproxy.doc.component.BaseIppResponseHead;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailRequestBody;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailResponseBody;
import com.tonghuafund.tppproxy.doc.component.IppAccountTxDetailTransItems;
import com.tonghuafund.tppproxy.entity.IppTransCode;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;

@Service("accountTxDetailResponseMsgTransformer")
public class AccountTxDetailResponseMsgTransformer extends BaseResponseMsgTransformer{

	@Override
	public AbstractIppResponseDoc transform(AbstractIppRequestDoc ippRequestDoc, PaymentResponse tppResponse) {
		IppAccountTxDetailResponseDoc responseDoc = new IppAccountTxDetailResponseDoc();
		BaseIppResponseHead head = new BaseIppResponseHead();
		head.setInstId(ippRequestDoc.getHead().getInstId());
		head.setProcessingCode(IppTransCode.ACCOUNT_TX_DETAIL);
		Date date = new Date();
		head.setTransDate(dateformatDate.format(date));
		head.setTransTime(dateformatTime.format(date));
		head.setVerNum(ippRequestDoc.getHead().getVerNum());
		responseDoc.setHead(head);

		IppAccountTxDetailResponseBody body = new IppAccountTxDetailResponseBody();
		IppAccountTxDetailRequestBody reqBody = (IppAccountTxDetailRequestBody) ippRequestDoc.getBody();

		body.setReqTraceNum(reqBody.getReqTraceNum());
		body.setChannelId(reqBody.getChannelId());
		body.setAcctNum(reqBody.getAcctNum());
		body.setPageIndex(reqBody.getPageIndex());

		if ("0".equals(tppResponse.getFlag())) {
			AccountTxDetailV10ResponseTxInfo txInfo = (AccountTxDetailV10ResponseTxInfo) (tppResponse.getResponseBean().getEnvelope()
					.getTxInfo());
			AccountTxDetailV10ResponseQueryInfo queryInfo = txInfo.getQueryInfo();
			List<IppAccountTxDetailTransItems> responseItems = new ArrayList<IppAccountTxDetailTransItems>();
			body.setRespTraceNum("");
			body.setTotalPage(queryInfo.getTotalPage());
			body.setPagePosStr(queryInfo.getPagePosStr());
			body.setPageMoreFlag(queryInfo.getPageMoreFlag());
			body.setPageRecNum(queryInfo.getPageRecNum());
			body.setCurType("156");
			body.setRespCode(getIppCodeFromErrorCode(queryInfo.getRetCode()));
			body.setRespMsg(queryInfo.getRetMsg());
			
			AccountTxDetailV10ResponseDetailItemArray arrays = txInfo.getDetailItemArray();
			List<AccountTxDetailV10ResponseDetailItem> itemArray = arrays.getItemArray();
			if(null != itemArray && itemArray.size() > 0){
				for(AccountTxDetailV10ResponseDetailItem item : itemArray){
					IppAccountTxDetailTransItems responseItem = new IppAccountTxDetailTransItems();
					responseItem.setSequenceNum("");
					responseItem.setTranDate(item.getBankTransDate());
					responseItem.setTranTime(item.getBankTransTime());
					responseItem.setAmtTran(item.getTransAmount());
					responseItem.setBalanceAmt(item.getAcctBalance());
					responseItem.setDorcMsg(item.getTransType());
					responseItem.setDestinationAcctNum(item.getOpAcctNo());
					responseItem.setDestinationHldName(item.getOpAcctName());
					responseItem.setTraceNum(item.getBankTraceNum());
					responseItems.add(responseItem);
				}
				
				body.setTransItems(responseItems);
			}
			
		} else {
			ErrorResponseDoc errorDoc = (ErrorResponseDoc) tppResponse.getResponseBean();
			body.setRespTraceNum(null);
			body.setRespCode(getIppCodeFromErrorCode(errorDoc.getErrorCode()));
			body.setRespMsg(errorDoc.getErrorMessage());
		}
		responseDoc.setBody(body);

		return responseDoc;
	}

	@Override
	public String getSupportTransCode() {
		return IppTransCode.ACCOUNT_TX_DETAIL;
	}
}
