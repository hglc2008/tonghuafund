package com.tonghuafund.tppproxy.notify;

/**
 * 消息的推送处理，此处为观察者模式的抽象观察者
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月17日
 */
public interface IMessagePushHandler {
	public void handle(MessagePush push);
}
