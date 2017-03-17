package com.tonghuafund.tppproxy.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.allinpay.util.LoggerUtil;

public class TppProxyEnv {
	private static String abPath = "D:/tppapp/proxyConfig/TppProxyEnv.properties";
	private static String ippPublicKey;
	private static String tppPrivateKey;
	private static String tppPrivteKeyPassword;
	private static String tppMchtBusinessType;
	private static String ippNotifyUrl;
	private static String ippBgNotifyUrl;
	private static String tppProxyNotifyUrl;
	private static String tppProxyBgNotifyUrl;

	static {
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		File file = new File(path, "TppProxyEnv.properties");
//		File file = new File(abPath);

		Properties p = new Properties();
		try {
			InputStream in = new FileInputStream(file);
			p.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LoggerUtil.debug("初始化文件加载完毕:" + p);
		if (p != null) {
			ippPublicKey = p.getProperty("ipp.publicKey");
			tppPrivateKey = p.getProperty("tpp.privateKey");
			tppPrivteKeyPassword = p.getProperty("tpp.privateKey.password");
			tppMchtBusinessType = p.getProperty("tpp.request.msg.businessType");
			ippNotifyUrl= p.getProperty("ipp.notify.url");
			ippBgNotifyUrl= p.getProperty("ipp.bg.notify.url");
			tppProxyNotifyUrl= p.getProperty("tpp.proxy.notify.url");
			tppProxyBgNotifyUrl= p.getProperty("tpp.proxy.bg.notify.url");
		}
	}

	public static String getIppPublicKey() {
		return ippPublicKey;
	}

	public static String getTppPrivateKey() {
		return tppPrivateKey;
	}

	public static String getTppPrivteKeyPassword() {
		return tppPrivteKeyPassword;
	}

	public static String getTppMchtBusinessType() {
		return tppMchtBusinessType;
	}

	public static String getIppNotifyUrl() {
		return ippNotifyUrl;
	}

	public static String getIppBgNotifyUrl() {
		return ippBgNotifyUrl;
	}

	public static String getTppProxyNotifyUrl() {
		return tppProxyNotifyUrl;
	}

	public static String getTppProxyBgNotifyUrl() {
		return tppProxyBgNotifyUrl;
	}

}
