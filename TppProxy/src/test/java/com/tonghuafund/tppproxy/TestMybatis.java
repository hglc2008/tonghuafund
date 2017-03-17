package com.tonghuafund.tppproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tonghuafund.tppproxy.dao.GwContract;
import com.tonghuafund.tppproxy.dao.mapper.GwContractMapper;

public class TestMybatis {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// ¥”classpath÷–º”‘ÿ
		GwContractMapper mapper = (GwContractMapper) context.getBean("gwContractMapper");
		GwContract item = mapper.selectFirstByAcctNO("6223250007268633");
		System.out.println("ok");
	}
}
