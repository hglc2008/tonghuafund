package com.tonghuafund.tppproxy.notify.http;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.springframework.stereotype.Service;

import com.allinpay.ipps.log.LoggerService;
import com.tonghuafund.tppproxy.notify.MessagePush;

/**
 * TppProxy ���ͽ��׽����Ipp
 * @author changstone

 * @create datetime 2016��3��18��
 */
@Service("httpPushMessageComService")
public class HttpPushMessageComService {
	private static HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();

	static {
		HttpConnectionManagerParams httpConnectionParams = httpConnectionManager.getParams();
		httpConnectionParams.setDefaultMaxConnectionsPerHost(4);
		httpConnectionParams.setMaxTotalConnections(32);
		httpConnectionParams.setConnectionTimeout(20);
		httpConnectionParams.setSoTimeout(20);
	}

	/**
	 * ���ӳ�ʱ ��λ����
	 */
	private int connectionTimeout = 10000;
	/**
	 * ��ȡ��ʱ ��λ����
	 */
	private int readTimeout = 50000;

	public HttpPushMessageComService() {
		super();
	}

	public boolean doPush(MessagePush request) {
		// HTTPClient�ύ
		PostMethod postMethod = null;

		// POST ��ѯ���ױ���
		HttpClient httpclient = new HttpClient(httpConnectionManager);

		postMethod = new PostMethod(request.getUrl());
		NameValuePair[] datas = { new NameValuePair("respMsg", request.getContent().get("respMsg")) };
		postMethod.setRequestBody(datas);

		try {
			int responseCode = httpclient.executeMethod(postMethod);
			LoggerService.debug("responseCode:" + responseCode);
			
			if (responseCode == HttpStatus.SC_OK) {
				return true;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return false;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

}
