package com.allinpay.ets.tp.og.wzt;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;

import org.springframework.stereotype.Component;

import com.allinpay.ets.tp.og.wzt.util.BaseScSecureUtil;
import com.allinpay.util.LoggerUtil;
import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;

/**
 * <pre>
 * 标准银行签名验签方法.
 * </pre>
 */
@Component("wztSecurityService")
public class WztSecurityService {

	private static final String SIGNATURE_ALGORITHM = "SHA1withRSA"; // 签名算法
	private static final String ENCODE_TYPE = "GBK";
	private PrivateKey privateKey;
	private PublicKey publicKey;

	// 初始化
	private void init() {
		// 1 读取公钥私钥路径和私钥密码

		String privateKeyPath = TppProxyEnv.getTppPrivateKey();
		String privateKeyPassword = TppProxyEnv.getTppPrivteKeyPassword();
		String publicKeyPath = TppProxyEnv.getIppPublicKey();
		if (StringUtil.isEmpty(privateKeyPath) || StringUtil.isEmpty(publicKeyPath)
				|| StringUtil.isEmpty(privateKeyPassword)) {
			privateKey = null;
			publicKey = null;
			return;
		}

		try {
			// 2 初始化私钥
			FileInputStream priStream = new FileInputStream(privateKeyPath);
			KeyStore ks = KeyStore.getInstance("PKCS12");
			ks.load(priStream, privateKeyPassword.toCharArray());
			priStream.close();
			Enumeration<String> enumas = ks.aliases();
			String keyAlias = null;
			if (enumas.hasMoreElements()) {
				keyAlias = enumas.nextElement();
			}
			privateKey = (PrivateKey) ks.getKey(keyAlias, privateKeyPassword.toCharArray()); // 得到私钥
			LoggerUtil.info("私钥初始化成功" + privateKeyPath);

			// 3 初始化公钥
			FileInputStream fis = new FileInputStream(publicKeyPath);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			Certificate cert = cf.generateCertificate(fis);
			publicKey = cert.getPublicKey();
			LoggerUtil.info("公钥初始化成功" + publicKeyPath);
		} catch (Exception e) {
			e.printStackTrace();
			privateKey = null;
			publicKey = null;
		}

	}

	/**
	 * 验签
	 */
	public boolean isVerified(String src, String mac) {
		// return true; // For test
		// 1 公钥验签
		if (publicKey == null) {
			init();
		}
		// 2 验签
		BaseScSecureUtil secure = new BaseScSecureUtil();
		return secure.verifySign(publicKey, SIGNATURE_ALGORITHM, src, ENCODE_TYPE);

	}

	/**
	 * 签名
	 */
	public String sign(String signSrcMsg) {

		// 1 私钥
		if (privateKey == null) {
			init();
		}

		// 2 加签
		BaseScSecureUtil secure = new BaseScSecureUtil();
		try {
			// 对XML文件进行加签
			String signedData = secure.signMsg(privateKey, SIGNATURE_ALGORITHM, signSrcMsg.getBytes(ENCODE_TYPE));
			return signedData;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
