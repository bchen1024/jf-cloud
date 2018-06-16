package org.btsoft.jf.cloud.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 上午12:03:58
 */
public class RequestUtils {
	
	public static String getRemortIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				ip = "Unknown";
			}
		}
		return ip;
	}
	
	public static InetAddress getInetAddress(HttpServletRequest request) {
		String hostIp=getRemortIP(request);
		InetAddress inet;
		try {
			inet = InetAddress.getByName(hostIp);
		} catch (UnknownHostException e) {
			return null;
		}
		return inet;
	}
	
	public static String getClient(HttpServletRequest req) {
		String client=req.getHeader("Client");
		if(StringUtils.isEmpty(client)) {
			String ua=req.getHeader("User-Agent");
			if(ua.contains("Android")) {
				client="Android";
			}else if(ua.contains("iPhone")) {
				client="iPhone";
			}else if(ua.contains("iPad")) {
				client="iPad";
			}else if(ua.contains("Windows Phone")) {
				client="Windows Phone";
			}else {
				return "PC";
			}
		}
		return client;
	}

}
