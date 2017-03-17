package com.tonghuafund.tppproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tonghuafund.tppproxy.web.controller.TppProxyController;

public class TestTppProxyController {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// ¥”classpath÷–º”‘ÿ

		TppProxyController controller = (TppProxyController) context.getBean("tppProxyController");
//		controller.service(null, null);
		controller.receiveMessage(null, null);
		System.out.println("ok");
	}

}
