package com.inspur.exampleproject.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.http.HttpHeaders;

public class HeaderUtil2 {
	/**
	 * 创建接口成功时返回的Header提示
	 * @param alertMsg
	 * @return
	 */
	public static HttpHeaders createOKHeader(String alertTitle, String alertMsg){
		HttpHeaders headers = new HttpHeaders();
		try {
			alertMsg = URLEncoder.encode(alertMsg, "UTF-8");
			alertTitle = URLEncoder.encode(alertTitle, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        headers.add("x-okheader-msg", alertMsg);
        headers.add("x-okheader-title", alertTitle);
        return headers;
	}
	
	/**
	 * 创建接口警告提示时返回的Header提示
	 * @param alertMsg
	 * @return
	 */
	public static HttpHeaders createWarningHeader(String alertTitle, String alertMsg){
		HttpHeaders headers = new HttpHeaders();
		try {
			alertMsg = URLEncoder.encode(alertMsg, "UTF-8");
			alertTitle = URLEncoder.encode(alertTitle, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        headers.add("x-warningheader-msg", alertMsg);
        headers.add("x-warningheader-title", alertTitle);
        return headers;
	}
	
	/**
	 * 创建接口错误时返回的Header提示
	 * @param alertMsg
	 * @return
	 */
	public static HttpHeaders createErrorHeader(String alertTitle, String alertMsg){
		HttpHeaders headers = new HttpHeaders();
		try {
			alertMsg = URLEncoder.encode(alertMsg, "UTF-8");
			alertTitle = URLEncoder.encode(alertTitle, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        headers.add("x-errorheader-msg", alertMsg);
        headers.add("x-errorheader-title", alertTitle);
        return headers;
	}
}
