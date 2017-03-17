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
 * ��׼����ǩ����ǩ����.
 * </pre>
 */
@Component("wztSecurityService")
public class WztSecurityService {

	private static final String SIGNATURE_ALGORITHM = "SHA1withRSA"; // ǩ���㷨
	private static final String ENCODE_TYPE = "GBK";
	private PrivateKey privateKey;
	private PublicKey publicKey;

	// ��ʼ��
	private void init() {
		// 1 ��ȡ��Կ˽Կ·����˽Կ����

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
			// 2 ��ʼ��˽Կ
			FileInputStream priStream = new FileInputStream(privateKeyPath);
			KeyStore ks = KeyStore.getInstance("PKCS12");
			ks.load(priStream, privateKeyPassword.toCharArray());
			priStream.close();
			Enumeration<String> enumas = ks.aliases();
			String keyAlias = null;
			if (enumas.hasMoreElements()) {
				keyAlias = enumas.nextElement();
			}
			privateKey = (PrivateKey) ks.getKey(keyAlias, privateKeyPassword.toCharArray()); // �õ�˽Կ
			LoggerUtil.info("˽Կ��ʼ���ɹ�" + privateKeyPath);

			// 3 ��ʼ����Կ
			FileInputStream fis = new FileInputStream(publicKeyPath);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			Certificate cert = cf.generateCertificate(fis);
			publicKey = cert.getPublicKey();
			LoggerUtil.info("��Կ��ʼ���ɹ�" + publicKeyPath);
		} catch (Exception e) {
			e.printStackTrace();
			privateKey = null;
			publicKey = null;
		}

	}

	/**
	 * ��ǩ
	 */
	public boolean isVerified(String src, String mac) {
		// return true; // For test
		// 1 ��Կ��ǩ
		if (publicKey == null) {
			init();
		}
		// 2 ��ǩ
		BaseScSecureUtil secure = new BaseScSecureUtil();
		return secure.verifySign(publicKey, SIGNATURE_ALGORITHM, src, ENCODE_TYPE);

	}

	/**
	 * ǩ��
	 */
	public String sign(String signSrcMsg) {

		// 1 ˽Կ
		if (privateKey == null) {
			init();
		}

		// 2 ��ǩ
		BaseScSecureUtil secure = new BaseScSecureUtil();
		try {
			// ��XML�ļ����м�ǩ
			String signedData = secure.signMsg(privateKey, SIGNATURE_ALGORITHM, signSrcMsg.getBytes(ENCODE_TYPE));
			return signedData;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
