package com.tonghuafund.tppproxy.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.allinpay.ets.tp.og.wzt.WztSecurityService;
import com.allinpay.ipps.entity.PaymentRequest;
import com.allinpay.ipps.entity.PaymentResponse;
import com.allinpay.ipps.entity.component.v10.ContractSignV10ForwardResponseDoc;
import com.allinpay.ipps.entity.component.v10.ErrorResponseDoc;
import com.allinpay.ipps.service.PaymentService;
import com.allinpay.ipps.service.transaction.enrichment.EnrichmentException;
import com.allinpay.ipps.util.XStreamParser;
import com.allinpay.util.StringUtil;
import com.tonghuafund.tppproxy.doc.AbstractIppRequestDoc;
import com.tonghuafund.tppproxy.doc.AbstractIppResponseDoc;
import com.tonghuafund.tppproxy.doc.IppRequestDocHolder;
import com.tonghuafund.tppproxy.entity.PaymentException;
import com.tonghuafund.tppproxy.entity.PaymentSession;
import com.tonghuafund.tppproxy.entity.TppProxyEnv;
import com.tonghuafund.tppproxy.msgTransformer.BaseRequestMsgTransformer;
import com.tonghuafund.tppproxy.msgTransformer.BaseResponseMsgTransformer;
import com.tonghuafund.tppproxy.notify.MessagePush;
import com.tonghuafund.tppproxy.notify.MessagePushHandler;
import com.tonghuafund.tppproxy.paramValid.BaseRequestParamValidator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller("tppProxyController")
@RequestMapping("Proxy")
public class TppProxyController {
	private static String reqBase64 = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiID8+PHRyYW5zYWN0aW9uPjxoZWFkPjxwcm9jZXNzaW5nX2NvZGU+MTAwNDwvcHJvY2Vzc2luZ19jb2RlPjxpbnN0X2lkPjIwMDAwMDIxMTMwNzAwMDwvaW5zdF9pZD48dHJhbnNfZGF0ZT4yMDE2MDMzMTwvdHJhbnNfZGF0ZT48dHJhbnNfdGltZT4xNDEyMjM8L3RyYW5zX3RpbWU+PHZlcl9udW0+MS4wPC92ZXJfbnVtPjxzaWduX2NvZGU+S2tmaG9kL2lTTU1vdkQ0cmN6WHk2MFQ0czlRZUlGRDJnZzdsMkhFd0N5SUNyYVFZOGwxYnV1TCsxR3hxR1ZQakNYQW1nTzV6bjR6MGdtRUNrRGJpWGl3d3VGL1VSa0EvSDRvWmhXcVVlN2p0TWVkaStYeEwrQVlXcW1ja2VLb1lvMUI2a1dXbk9XZzVSaWNDQVZmUTZsYTkxcnYzOCtlMmx0RDUwb2JTQkpNPTwvc2lnbl9jb2RlPjwvaGVhZD48cmVxdWVzdD48cmVxX3RyYWNlX251bT42MDMzMTM3NDcxPC9yZXFfdHJhY2VfbnVtPjxvcmdfcmVxX3RyYWNlX251bT42MDMzMTM3NDY3PC9vcmdfcmVxX3RyYWNlX251bT48b3JnX3RyYW5zX2RhdGU+MjAxNjAzMzE8L29yZ190cmFuc19kYXRlPjx2ZXJpZnlfY29kZT4xMjM0NTY8L3ZlcmlmeV9jb2RlPjwvcmVxdWVzdD48L3RyYW5zYWN0aW9uPg==";
	// 签约响应
	private static String signResp = "PFJFU1BPTlNFPjxFTlZFTE9QRT48SEVBRD48VkVSU0lPTj52MS4wPC9WRVJTSU9OPjxCVVNJTkVTU19UWVBFPjAzPC9CVVNJTkVTU19UWVBFPjxQQVlfVFlQRT4wODwvUEFZX1RZUEU+PFRSQU5TX0NPREU+MTAwMjwvVFJBTlNfQ09ERT48QUdFTlRfSUQ+OTAwMDAyMDEyMDMwMDAxPC9BR0VOVF9JRD48VFJBQ0VfTlVNPlROLTIwMTQwMzI0MTg0MDU0PC9UUkFDRV9OVU0+PFRSQU5TX0RBVEU+MjAxNDAzMjQ8L1RSQU5TX0RBVEU+PFRSQU5TX1RJTUU+MTg0MDU0PC9UUkFOU19USU1FPjwvSEVBRD48VFhfSU5GTz48TUVSQ0hBTlRfTk8+OTAwMDAyMDEyMDMwMDAxPC9NRVJDSEFOVF9OTz48QUNDVF9DQVQ+MDE8L0FDQ1RfQ0FUPjxBQ0NUX05PPjYyMjMyNTAwMDcyNjg2MzM8L0FDQ1RfTk8+PENPTlRSQUNUX05PPjE0MDMyNDE4NDA1NzAwMDk8L0NPTlRSQUNUX05PPjxSRVRfQ09ERT4wMDAwMDA8L1JFVF9DT0RFPjxSRVRfTVNHPuS6pOaYk+aIkOWKnzwvUkVUX01TRz48SVBQX1RSQUNFX05VTT4xNDAzMjQxODQwNTcwMDA5PC9JUFBfVFJBQ0VfTlVNPjxJUFBfVFJBTlNfREFURT4yMDE0MDMyNDwvSVBQX1RSQU5TX0RBVEU+PElQUF9UUkFOU19USU1FPjE4NDEwMjwvSVBQX1RSQU5TX1RJTUU+PEVYVEVORF9JTkZPPjwvRVhURU5EX0lORk8+PC9UWF9JTkZPPjwvRU5WRUxPUEU+PFNJR05BVFVSRT48U0lHTl9UWVBFPjA8L1NJR05fVFlQRT48U0lHTl9NU0c+NkZGNTlFNTNGQzI1MENEREE2MzhDRkE1QTk1QUNBMDE8L1NJR05fTVNHPjwvU0lHTkFUVVJFPjwvUkVTUE9OU0U+";

	@Autowired
	private PaymentService paymentService;
	private NumberFormat nformat = new DecimalFormat("0000");
	private DateFormat dateformat = new SimpleDateFormat("yyMMddHHmm");
	private static AtomicInteger seqnum = new AtomicInteger(1);
	private BASE64Encoder encoder = new BASE64Encoder();
	private BASE64Decoder decoder = new BASE64Decoder();
	private static final String CHAR_SET = "gbk";

	// 把ipp的请求报文转成tpp的请求报文
	private Map<String, BaseRequestMsgTransformer> requestTransformerMap = new HashMap<String, BaseRequestMsgTransformer>();
	// 把tpp的响应报文转成ipp的响应报文
	private Map<String, BaseResponseMsgTransformer> responseTransformerMap = new HashMap<String, BaseResponseMsgTransformer>();
	// 把tpp的响应报文转成ipp的响应报文
	private Map<String, BaseRequestParamValidator> requestParamValidatorMap = new HashMap<String, BaseRequestParamValidator>();
	@Autowired
	private WztSecurityService securityService;

	@Autowired
	private MessagePushHandler messagePushHandler;

	private Logger logger = Logger.getLogger(TppProxyController.class);
	private static final String XML_HEAD = "<?xml version='1.0' encoding='UTF-8' ?>";
	private static final String VERSION_NUM_XMLTAG_END = "</ver_num>";
	private static final String SIGN_CODE_XMLTAG_START = "<sign_code>";
	private static final String SIGN_CODE_XMLTAG_END = "</sign_code>";

	/**
	 * 后台交易
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/transaction")
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean paymentExceptionFlag = false;
		PaymentSession session = new PaymentSession();
		// 1 生成UUID
		session.setEntityID(generateUUID());

		try {
			// 2 包装请求报文
			wrapRequest(request, session);

			// 3 验证签名
			validSecuritySign(session);

			// 4 验证必填字段
			validRequestField(session);
			session.updatetPayState(2);
		} catch (PaymentException e) {
			logger.warn(e);
			e.printStackTrace();
			paymentExceptionFlag = true;
		}

		PaymentResponse tppResponse = null;
		if (paymentExceptionFlag == true) {
			tppResponse = new PaymentResponse();
			tppResponse.setCharset(CHAR_SET);
			tppResponse.setResponseContent(null);
			tppResponse.setFlag("1");
			ErrorResponseDoc errorDoc = new ErrorResponseDoc();
			errorDoc.setErrorCode("11002");
			errorDoc.setErrorMessage("未知的交易处理参数配置错误");
			tppResponse.setResponseBean(errorDoc);
		} else {
			// 5 与TPP交换报文
			PaymentRequest tppRequest = requestTransformerMap.get(session.getTransCode())
					.transform(session.getIppRequestDoc());
			logger.info("订单[" + session.getEntityID() + "]开始请求TPP");
			session.updatetPayState(4);
			tppResponse = paymentService.doTransaction(tppRequest);
			logger.info("订单[" + session.getEntityID() + "]接收到TPP的响应");
			if ("0".equals(tppResponse.getFlag())) {
				session.updatetPayState(64);
			} else {
				session.updatetPayState(32);
			}
		}
		// 6 合成ipp的响应报文
		AbstractIppResponseDoc ippResponse = responseTransformerMap.get(session.getTransCode())
				.transform(session.getIppRequestDoc(), tppResponse);
		session.setIppResponseDoc(ippResponse);
		wrapResponse(session);
		// 7 响应报文签名
		securitySign(session);
		// 8响应报文base64编码
		String tempResponse = encoder.encode(session.getResponseContent().getBytes(CHAR_SET));
		session.setResponseContent(tempResponse.replaceAll("[\r|\n]", ""));

		logger.info("订单[" + session.getEntityID() + "][" + session.getPayState() + "," + session.getState() + "]输出响应:"
				+ session.getResponseContent());
		// 9输出响应
		response.getWriter().print(session.getResponseContent());
	}

	/**
	 * 前台交易
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/transactionWeb")
	public ModelAndView transactionWeb(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean paymentExceptionFlag = false;
		PaymentSession session = new PaymentSession();
		// 1 代理应用收单
		// 1.1 生成UUID
		session.setEntityID(generateUUID());

		try {
			// 1.2 包装请求报文
			wrapRequest(request, session);

			// 1.3 验证签名
			validSecuritySign(session);

			// 1.4 验证必填字段
			validRequestField(session);
			session.updatetPayState(2);
		} catch (PaymentException e) {
			logger.warn(e);
			e.printStackTrace();
			paymentExceptionFlag = true;
		}

		// 2 与TPP交互
		PaymentResponse tppResponse = null;
		if (paymentExceptionFlag == true) {
			tppResponse = new PaymentResponse();
			tppResponse.setCharset(CHAR_SET);
			tppResponse.setResponseContent(null);
			tppResponse.setFlag("1");
			ErrorResponseDoc errorDoc = new ErrorResponseDoc();
			errorDoc.setErrorCode("11002");
			errorDoc.setErrorMessage("未知的交易处理参数配置错误");
			tppResponse.setResponseBean(errorDoc);
		} else {
			// 2.2 与TPP交换报文
			PaymentRequest tppRequest = requestTransformerMap.get(session.getTransCode())
					.transform(session.getIppRequestDoc());
			logger.info("订单[" + session.getEntityID() + "]开始请求TPP");
			session.updatetPayState(4);
			tppResponse = paymentService.doTransaction(tppRequest);
			logger.info("订单[" + session.getEntityID() + "]接收到TPP的响应");
			if ("0".equals(tppResponse.getFlag())) {
				session.updatetPayState(64);
			} else {
				session.updatetPayState(32);
			}
		}

		// 3 把TPP响应发到页面去显示
		ContractSignV10ForwardResponseDoc tppForwardResponse = (ContractSignV10ForwardResponseDoc) tppResponse
				.getResponseBean();
		String url = tppForwardResponse.getUrl();
		Map<String, String> formItemMap = tppForwardResponse.getParaMap();
		ModelAndView view = new ModelAndView();
		view.addObject("url", url);
		view.addObject("formItemMap", formItemMap);
		view.setViewName("signContract");
		return view;
	}

	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// response.getWriter().print("Hello World!");
		Map<String, String> formItemMap = new HashMap<String, String>();
		formItemMap.put("1k", "233");
		formItemMap.put("2k", "333");
		ModelAndView view = new ModelAndView();
		view.addObject("url", "http://123.com");
		view.addObject("formItemMap", formItemMap);
		view.setViewName("signContract");
		return view;
	}

	/**
	 * 后台交易结果推送
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/recv/transaction")
	public void receiveMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PaymentSession session = new PaymentSession();
		// 1 收单
		// 1.1 生成UUID
		session.setEntityID(generateUUID());
		
		logger.info("订单[" + session.getEntityID() + "]receiveMessage:");

		try {
			// 1.2 包装请求报文
			wrapPushRequest(request, session);

		} catch (PaymentException e) {
			logger.warn(e);
			e.printStackTrace();
			// 打印日志
			return;
		}

		// 2 交给sdk处理Tpp推送的消息
		PaymentResponse tppResponse = new PaymentResponse();
		tppResponse.setCharset("utf-8");
		tppResponse.setFlag("0");
		tppResponse.setResponseContent(session.getRequestContent());
		tppResponse.setResponseBean(null);

		try {
			tppResponse = paymentService.handleAsyncResponse(tppResponse);
		} catch (EnrichmentException e) {
			e.printStackTrace();
		}

		// 3 合成推给ipp的响应报文
		AbstractIppResponseDoc ippResponse = responseTransformerMap.get(session.getTransCode()).transform(null,
				tppResponse);

		session.setIppResponseDoc(ippResponse);

		wrapResponse(session);
		// 响应报文签名
		securitySign(session);
		// 响应报文base64编码
		String tempResponse = encoder.encode(session.getResponseContent().getBytes(CHAR_SET));
		session.setResponseContent(tempResponse.replaceAll("[\r|\n]", ""));

		logger.info("订单[" + session.getEntityID() + "][" + session.getPayState() + "," + session.getState() + "]输出响应:"
				+ session.getResponseContent());
		// 4 输出响应
		MessagePush messagePush = new MessagePush();
		messagePush.setUrl(TppProxyEnv.getIppBgNotifyUrl());
		Map<String, String> respMap = new HashMap<String, String>();
		respMap.put("respMsg", session.getResponseContent());
		messagePush.setContent(respMap);

		messagePushHandler.handle(messagePush);
	}

	/**
	 * 后台交易结果推送
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/recv/transactionWeb")
	public ModelAndView receiveMessageWeb(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PaymentSession session = new PaymentSession();
		// 1 收单
		// 1.1 生成UUID
		session.setEntityID(generateUUID());
		
		logger.info("订单[" + session.getEntityID() + "]receiveMessageWeb:");

		try {
			// 1.2 包装请求报文
			wrapPushRequest(request, session);

		} catch (PaymentException e) {
			logger.warn(e);
			e.printStackTrace();
			// 打印日志
			return null;
		}

		// 2 交给sdk处理Tpp推送的消息
		PaymentResponse tppResponse = new PaymentResponse();
		tppResponse.setCharset("utf-8");
		tppResponse.setFlag("0");
		tppResponse.setResponseContent(session.getRequestContent());
		tppResponse.setResponseBean(null);

		try {
			tppResponse = paymentService.handleAsyncResponse(tppResponse);
		} catch (EnrichmentException e) {
			e.printStackTrace();
		}

		// 3 合成推给ipp的响应报文
		AbstractIppResponseDoc ippResponse = responseTransformerMap.get(session.getTransCode()).transform(null,
				tppResponse);

		session.setIppResponseDoc(ippResponse);

		wrapResponse(session);
		// 响应报文签名
		securitySign(session);
		// 响应报文base64编码
		String tempResponse = encoder.encode(session.getResponseContent().getBytes(CHAR_SET));
		session.setResponseContent(tempResponse.replaceAll("[\r|\n]", ""));

		logger.info("订单[" + session.getEntityID() + "][" + session.getPayState() + "," + session.getState() + "]输出响应:"
				+ session.getResponseContent());
		// 4 输出响应
		ModelAndView view = new ModelAndView();
		view.addObject("url", TppProxyEnv.getIppNotifyUrl());
		Map<String, String> respMap = new HashMap<String, String>();
		respMap.put("respMsg", session.getResponseContent());
		view.addObject("formItemMap", respMap);
		view.setViewName("txResultPush");
		return view;
	}

	/**
	 * 产生订单的唯一标识符
	 * 
	 * @return
	 */
	private String generateUUID() {
		String idPrefix = dateformat.format(new Date());
		int temp = seqnum.getAndIncrement();
		if (temp > 9999) {
			seqnum.set(2);
			temp = 1;
		}
		return idPrefix + nformat.format(temp);
	}

	private void wrapRequest(HttpServletRequest req, PaymentSession session) throws PaymentException {
		// 1 获取请求报文
//		String reqMsg = req.getParameter("reqMsg");
		String reqMsg = reqBase64;
		logger.info("订单[" + session.getEntityID() + "]recieve:" + reqMsg);
		if (reqMsg == null || reqMsg.length() == 0) {
			throw new PaymentException("00001");
		}

		try {
			byte[] ary = decoder.decodeBuffer(reqMsg);
			reqMsg = new String(ary, CHAR_SET);

			// 2 请求报文base64解码
			session.setRequestContent(reqMsg);
			String transCode = StringUtil.getTagValue(reqMsg, "processing_code");
			session.setTransCode(transCode);
			logger.info("订单[" + session.getEntityID() + "]request message:" + reqMsg);
		} catch (IOException e) {
			e.printStackTrace();
			throw new PaymentException("00002");
		}
		session.updatetPayState(1);
	}

	// 把ipp的响应bean转成xml报文
	private void wrapResponse(PaymentSession session) {
		XStreamParser parser = new XStreamParser();
		String xml = parser.toXML(session.getIppResponseDoc());
		xml = xml.replace("&lt;", "<").replace("&gt;", ">");
		logger.info("订单[" + session.getEntityID() + "]响应明文:" + xml);
		session.setResponseContent(xml);
	}

	/**
	 * 封装TPP推送的响应
	 * 
	 * @param req
	 * @param session
	 * @throws PaymentException
	 */
	private void wrapPushRequest(HttpServletRequest req, PaymentSession session) throws PaymentException {
		// 1 获取请求报文
		String reqMsg = req.getParameter("respMsg");
		logger.info("订单[" + session.getEntityID() + "]recieve:" + reqMsg);
		if (reqMsg == null || reqMsg.length() == 0) {
			throw new PaymentException("00001");
		}

		try {
			byte[] ary = decoder.decodeBuffer(reqMsg);
			String reqMsg1 = new String(ary, "utf-8");

			// 2 请求报文base64解码
			session.setRequestContent(reqMsg);
			String transCode = StringUtil.getTagValue(reqMsg1, "TRANS_CODE");
			session.setTransCode(transCode);
			logger.info("订单[" + session.getEntityID() + "]request message:" + reqMsg1);
		} catch (IOException e) {
			e.printStackTrace();
			throw new PaymentException("00002");
		}
		session.updatetPayState(1);
	}

	// ipp响应报文签名
	private void securitySign(PaymentSession session) {
		StringBuffer buffer = new StringBuffer(session.getResponseContent());
		String signMsg = securityService.sign(session.getResponseContent());

		signMsg = signMsg.replaceAll("[\r|\n]", "");

		buffer.insert(session.getResponseContent().indexOf(VERSION_NUM_XMLTAG_END) + VERSION_NUM_XMLTAG_END.length(),
				SIGN_CODE_XMLTAG_START + signMsg + SIGN_CODE_XMLTAG_END);
		buffer.insert(0, XML_HEAD);
		session.setResponseContent(buffer.toString());
		logger.info("订单[" + session.getEntityID() + "]响应签名:" + session.getResponseContent());
	}

	// 如果验签失败则抛出PaymentException
	private void validSecuritySign(PaymentSession session) throws PaymentException {
		String transCode = session.getTransCode();
		// 1 把xml转成bean
		XStreamParser parser = new XStreamParser();
		parser.alias("transaction", IppRequestDocHolder.getInstance().getBeanRequestDoc(transCode).getClass());
		Object obj = parser.fromXML(session.getRequestContent());
		session.setIppRequestDoc((AbstractIppRequestDoc) obj);
		// 2 如果验签失败直接抛异常
		String reqMsg = session.getRequestContent();
		String reqMsgNoXmlHead = reqMsg.substring(reqMsg.indexOf("<transaction>"));
		logger.info("订单[" + session.getEntityID() + "]验签去头:" + reqMsgNoXmlHead);
		String src = reqMsg.substring(reqMsg.indexOf("<transaction>"));
		src = src.replaceFirst("<sign_code>[\\w\\+/=]+</sign_code>", "");
		logger.info("订单[" + session.getEntityID() + "]验签src:" + src);
		logger.info("订单[" + session.getEntityID() + "]验签MAC:" + session.getIppRequestDoc().getHead().getSignCode());
		boolean flag = securityService.isVerified(reqMsgNoXmlHead, session.getIppRequestDoc().getHead().getSignCode());
		if (!flag) {
//			throw new PaymentException("00004");
		}
	}

	private void validRequestField(PaymentSession session) throws PaymentException {
		requestParamValidatorMap.get(session.getTransCode()).validRequestMsg(session.getIppRequestDoc());
	}

	/**
	 * 注册请求转换类
	 * 
	 * @param item
	 */
	public void registBaseRequestMsgTransformer(BaseRequestMsgTransformer item) {
		String key = item.getSupportTransCode();
		requestTransformerMap.put(key, item);

	}

	public void registBaseRequestMsgTransformers(List<BaseRequestMsgTransformer> transformers) {
		for (BaseRequestMsgTransformer item : transformers) {
			registBaseRequestMsgTransformer(item);
		}
	}

	public void registBaseResponseMsgTransformer(BaseResponseMsgTransformer item) {
		String key = item.getSupportTransCode();
		responseTransformerMap.put(key, item);

	}

	public void registBaseResponseMsgTransformers(List<BaseResponseMsgTransformer> transformers) {
		for (BaseResponseMsgTransformer item : transformers) {
			registBaseResponseMsgTransformer(item);
		}
	}

	public void registBaseRequestParamValidator(BaseRequestParamValidator item) {
		String key = item.getSupportTransCode();
		requestParamValidatorMap.put(key, item);
	}

	public void registBaseRequestParamValidators(List<BaseRequestParamValidator> validators) {
		for (BaseRequestParamValidator item : validators) {
			registBaseRequestParamValidator(item);
		}
	}

	public static void main(String[] args) {
		TppProxyController c = new TppProxyController();
		for (int i = 0; i < 200; i++) {
			System.out.println(c.generateUUID());
		}
	}
}
