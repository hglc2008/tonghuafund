package com.tonghuafund.tppproxy.notify;

import java.io.Serializable;
import java.util.Map;

/**
 * ��Ϣ����ʵ��
 * 
 * @author changstone
 * 
 * @create datetime 2016��3��17��
 */
public class MessagePush implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���͵�Ŀ��URL
	 */
	private String url;
	/**
	 * ���͵�����
	 */
	private Map<String, String> content;
	// ����ʧ�ܴ���,3�ζ���������¼��־
	private int failCount = 0;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getContent() {
		return content;
	}

	public void setContent(Map<String, String> content) {
		this.content = content;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public void increaseFailCount() {
		this.failCount++;
	}

}
