package com.tonghuafund.tppproxy.notify;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonghuafund.tppproxy.notify.http.HttpPushMessageComService;

/**
 * 消息的推送处理，此处为观察者模式的观察者
 * 
 * @author changstone
 * 
 * @create datetime 2016年3月17日
 */
@Service("messagePushHandler")
public class MessagePushHandler implements IMessagePushHandler {
	private LinkedList<MessagePush> msgQueue = new LinkedList<MessagePush>();
	private static final int POOL_SIZE = 4;
	ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
	private ExecutorService threadPool = Executors.newFixedThreadPool(POOL_SIZE);
	
	@Autowired
	private HttpPushMessageComService comService;

	@Override
	public void handle(MessagePush push) {
		synchronized (msgQueue) {
			msgQueue.add(push);
		}
	}

	public MessagePushHandler() {
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				for (int i = 0; i < msgQueue.size() && i < 50; i++) {
					synchronized (msgQueue) {
						MessagePush message = msgQueue.remove();
						threadPool.execute(new PushTask(message));
					}

				}
			}
		}, 1, 10, TimeUnit.SECONDS);
	}

	class PushTask implements Runnable {
		MessagePush message;

		@Override
		public void run() {
			boolean flag = comService.doPush(message);
			if (!flag) {
				message.increaseFailCount();
				if (message.getFailCount() < 3) {
					synchronized (msgQueue) {
						msgQueue.add(message);
					}
				}
			}
		}

		public PushTask(MessagePush message) {
			super();
			this.message = message;
		}

	}
}
