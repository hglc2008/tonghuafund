package com.tonghuafund.tppproxy.notify;

/**
 * ��Ϣ�����ʹ����˴�Ϊ�۲���ģʽ�ĳ�������
 * 
 * @author changstone
 * 
 * @create datetime 2016��3��17��
 */
public interface IMessagePushReceiver {
	public void addHandler(IMessagePushHandler hanlder);
	public void removeHandler(IMessagePushHandler hanlder);
	public void push(MessagePush push);
}
