package com.tonghuafund.tppproxy.notify;

/**
 * 消息的推送处理，此处为观察者模式的抽象主题
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月17日
 */
public interface IMessagePushReceiver {
	public void addHandler(IMessagePushHandler hanlder);
	public void removeHandler(IMessagePushHandler hanlder);
	public void push(MessagePush push);
}
