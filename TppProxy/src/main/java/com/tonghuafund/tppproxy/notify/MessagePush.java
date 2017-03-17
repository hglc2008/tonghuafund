package com.tonghuafund.tppproxy.notify;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息推送实体
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月17日
 */
public class MessagePush implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 推送的目标URL
	 */
	private String url;
	/**
	 * 推送的内容
	 */
	private Map<String, String> content;
	// 推送失败次数,3次丢弃，并记录日志
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
