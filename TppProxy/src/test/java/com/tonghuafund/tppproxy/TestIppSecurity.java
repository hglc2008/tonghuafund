package com.tonghuafund.tppproxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.allinpay.ets.tp.og.wzt.WztSecurityService;
import com.allinpay.util.StringUtil;

public class TestIppSecurity {
	private static String reqMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><transaction><head><processing_code>2001</processing_code><inst_id>200000211307000</inst_id><trans_date>20160302</trans_date><trans_time>144544</trans_time><ver_num>1.0</ver_num><sign_code>fFPcQp/KQFj0cfVQa/quMP1c+tfL6s+0ZZA+FsDdeeOWfX9WuDewOD6giAu0j0aw5g55CCU5E9s54OgOPgOIG2005VA11JlDE8TnoknOFF9posGzSci/eRXYD5B23fCfB8+0BJ9wfsaLYFNGw7lxJbSNJShNZfr8bp1kxbVwR2U=</sign_code></head><request><req_trace_num>6030237400</req_trace_num><channel_id>100064</channel_id><date_settlmt>20160302</date_settlmt><acct_type>01</acct_type><acct_num>6223250007268633</acct_num><cur_type>156</cur_type><amt_tran>1</amt_tran></request></transaction>";

	public static void main(String[] args) {
//		String str = "123456";
//		System.out.println(str.substring(0,5));
//		
////		String temp=reqMsg.substring(reqMsg.indexOf("<transaction>"));
////		temp=temp.replaceFirst("<sign_code>[\\w\\+/=]+</sign_code>", "");
////		System.out.println(temp);
//		
//		String reqMsg = "<transaction><head><processing_code>2001</processing_code><inst_id>900002012030001</inst_id><trans_date>20160303</trans_date><trans_time>144544</trans_time><ver_num>1.0</ver_num></head><request><req_trace_num>6030237401</req_trace_num><channel_id>00000000</channel_id><date_settlmt>20160302</date_settlmt><acct_type>01</acct_type><acct_num>6223250007268633</acct_num><cur_type>156</cur_type><amt_tran>1</amt_tran></request></transaction>";
//		
//		String src = "<transaction><head><processing_code>2001</processing_code><inst_id>900002012030001</inst_id><trans_date>20160303</trans_date><trans_time>144544</trans_time><ver_num>1.0</ver_num><sign_code>fFPcQp/KQFj0cfVQa/quMP1c+tfL6s+0ZZA+FsDdeeOWfX9WuDewOD6giAu0j0aw5g55CCU5E9s54OgOPgOIG2005VA11JlDE8TnoknOFF9posGzSci/eRXYD5B23fCfB8+0BJ9wfsaLYFNGw7lxJbSNJShNZfr8bp1kxbVwR2U=</sign_code></head><request><req_trace_num>6030237401</req_trace_num><channel_id>00000000</channel_id><date_settlmt>20160302</date_settlmt><acct_type>01</acct_type><acct_num>6223250007268633</acct_num><cur_type>156</cur_type><amt_tran>1</amt_tran></request></transaction>";
//		
//		WztSecurityService wts = new WztSecurityService();
//		
//		String msg = wts.sign(reqMsg);
//		
//		System.out.println(msg);
//		
//		boolean flag = wts.isVerified(src, null);
//		
//		System.out.println(flag);
		
		String fileName = "D:\\tmp\\003.txt";
		File file = new File(fileName);
		
		if(!file.exists()){
			System.out.println("no file !!!");
		}
		
		InputStreamReader read;
		try {
			read = new InputStreamReader(
			        new FileInputStream(file),"utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while((lineTxt = bufferedReader.readLine()) != null){
				System.out.println(lineTxt);			
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
