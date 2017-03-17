package com.tonghuafund.tppproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// ¥”classpath÷–º”‘ÿ
		Object obj1 = context.getBean("deductRequestMsgTransformer");
		Object obj2 = context.getBean("ippDeductRequestDocParamValidator");
		Object obj3 = context.getBean("tppProxyController");
		System.out.println("ok");
	}
}
