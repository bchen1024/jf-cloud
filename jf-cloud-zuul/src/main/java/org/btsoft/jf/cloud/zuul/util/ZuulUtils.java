package org.btsoft.jf.cloud.zuul.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.btsoft.jf.cloud.zuul.constants.CloudZuulConstants;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.context.RequestContext;

/**
 * 工具类
 * @author chenbin
 * @date 2019-04-27 23:24
 */
public class ZuulUtils {

	/**
	 * 从请求中获取token
	 * @param request
	 * @return
	 * @autor chenbin
	 * @date 2019-04-28 19:38
	 */
	public static String getToken(HttpServletRequest request) {
		//获取鉴权token，优先从Header中获取，取不到再从入
		String token=request.getHeader(CloudZuulConstants.AUTHORIZATION);
		if(StringUtils.isEmpty(token)) {
			token=request.getParameter(CloudZuulConstants.TOKEN);
		}
		return token;
	}
	
	/**
	 * 是否跳过鉴权
	 * @param request
	 * @return
	 * @autor chenbin
	 * @date 2019-04-28 19:41
	 */
	public static boolean skipAuthentication(HttpServletRequest request) {
		String uri=request.getRequestURI();
		if(uri.contains("/public/") || uri.contains("/auth/") || uri.contains("swagger") || uri.contains("api-docs")){
        	return true;
        }
		return false;
	}
	
	/**
	 * 路由响应
	 * @param ctx
	 * @param sendZuulResponse
	 * @param statusCode
	 * @param errorCode
	 * @param message
	 * @autor chenbin
	 * @date 2019-04-28 19:53
	 */
	public static void zuulResponse(RequestContext ctx,boolean sendZuulResponse,int statusCode,String errorCode,String message) {
		ctx.setSendZuulResponse(sendZuulResponse);
        ctx.setResponseStatusCode(statusCode);
        Map<String,Object> map=new HashMap<String,Object>(2);
        map.put("httpCode", statusCode);
        map.put("errorCode", errorCode);
        map.put("message", message);
        ctx.setResponseBody(JSON.toJSONString(map));
	}
}
