package com.allinpay.ets.tp.og.wzt.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 标准银行加密签名工具类
 */
public class BaseScSecureUtil {

	/**
	 * 签名
	 * 
	 * @param msg
	 */
	public String signMsg(PrivateKey privateKey, String algorithm, byte[] srcData) {
		try {
			Signature signature = Signature.getInstance(algorithm);
			signature.initSign(privateKey);
			signature.update(srcData);
			byte[] signData = signature.sign();
			return new BASE64Encoder().encode(signData);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("签名失败：找不到RSA算法的密钥生成器！", e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException("签名失败：私钥无效", e);
		} catch (SignatureException e) {
			throw new RuntimeException("签名失败：signature执行签名失败", e);
		}
	}

	/**
	 * 验签
	 * 
	 * @param publicKey
	 * @param algorithm
	 * @param plainMsg
	 * @param encode
	 * @return
	 */
	public boolean verifySign(PublicKey publicKey, String algorithm, String plainMsg, String encode) {
		try {
			// 1 取明文和签名
			String mac = getTagValue(plainMsg, "sign_code");
			String srcMsg = deleteTagValue(plainMsg, "sign_code");
			// 2 验签
			Signature signature = Signature.getInstance(algorithm);
			signature.initVerify(publicKey);
			signature.update(srcMsg.getBytes(encode));
			BASE64Decoder base64Decode = new BASE64Decoder();
			byte[] macData = base64Decode.decodeBuffer(mac);
			return (signature.verify(macData));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("验签失败：找不到RSA算法的密钥生成器！", e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException("验签失败：公钥无效", e);
		} catch (SignatureException e) {
			throw new RuntimeException("验签失败：signature执行验签失败", e);
		} catch (IOException e) {
			throw new RuntimeException("验签失败： IO Exception", e);
		}
	}

	/**
	 * 取标签内容
	 * 
	 * @param strXML
	 * @param tagName
	 * @return
	 */
	private String getTagValue(String strXML, String tagName) {
		if (null == tagName || "".equals(tagName)) {
			return "";
		}
		String startTag = "<" + tagName + ">";
		String endTag = "</" + tagName + ">";
		if (null == strXML || strXML.indexOf(startTag) == -1 || strXML.indexOf(endTag) == -1) {
			return "";
		}

		return strXML.substring(strXML.indexOf(startTag) + startTag.length(), strXML.indexOf(endTag));
	}

	/**
	 * 删除xml中的元素
	 * 
	 * @param strXML
	 * @param tagName
	 * @return
	 */
	private String deleteTagValue(String strXML, String tagName) {
		if (null == tagName || "".equals(tagName)) {
			return strXML;
		}
		String startTag = "<" + tagName + ">";
		String endTag = "</" + tagName + ">";
		if (null == strXML || strXML.indexOf(startTag) == -1 || strXML.indexOf(endTag) == -1) {
			return strXML;
		}

		return strXML.substring(0, strXML.indexOf(startTag))
				+ strXML.substring(strXML.indexOf(endTag) + startTag.length() + 1);
	}

	public static void main(String[] args) {
		// String aa =
		// "<transaction><head><processing_code>5010</processing_code><brk_id>50010001</brk_id>"
		// +
		// "<sts_trans_date>20130529</sts_trans_date><sts_trans_time>114621</sts_trans_time>"
		// +
		// "<date_settlmt>20130529</date_settlmt><version_num>1.0</version_num>"
		// +
		// "<sign_code>TKC/ri3DTQ5NfDS7piDQEZsWXRcRq0B9EC4NJm5TnyO6PqgoRerwYoGQ43ZKhpwE9esD+"
		// +
		// "6X8ROE8a4gRR2w7kQr5UChu1E75nDIOq86ZuC61J2Yi0IFj1ebIa4zSGVBSBq5WL5YwptWOqeg6haVAW"
		// +
		// "ZYxu7LhsEH/CnqO2cu6cbg=</sign_code></head><request><sts_trace_num>3052900108</sts_trace_num>"
		// +
		// "<amt_tran>0.12</amt_tran><amt_pay>0.12</amt_pay><web_url>http://192.168.11.157:8080"
		// +
		// "/iebankp/recv/htsB2CReBack</web_url><resp_url>http://192.168.11.157:8080/iebankp/"
		// + "recv/htsB2CReBack</resp_url></request></transaction>";
		//
		// BaseScSecureUtil as = new BaseScSecureUtil();
		//
		// System.out.println(as.veriSign(aa));

	}
}
