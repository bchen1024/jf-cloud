package org.btsoft.jf.cloud.zuul.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author chenbin
 *
 */
@Component
public class AuthorizationFilter extends ZuulFilter {

    private final static Logger logger= LoggerFactory.getLogger(AuthorizationFilter.class);
    
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -300;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri=request.getRequestURI();
        String method=request.getMethod();
        if("OPTIONS".equals(method)) {
        	ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由  
            ctx.setResponseStatusCode(200);// 返回错误码  
            ctx.setResponseBody("success");
            return null;
        }
        logger.debug(String.format("[%s] %s",request.getMethod(),uri));
        
        //跳过鉴权
        if(uri.contains("/public/") || uri.contains("/auth/") || uri.contains("swagger") || uri.contains("api-docs")){
        	ctx.setSendZuulResponse(true);// 对该请求进行路由  
            ctx.setResponseStatusCode(200);
        }else{
        	//获取鉴权token，优先从Header中获取，取不到再从入
			String token=request.getHeader("Authorization");
			if(StringUtils.isEmpty(token)) {
				token=request.getParameter("token");
			}
			
			//如果token为空，无权限
			if(StringUtils.isEmpty(token)) {
				this.setErrorResponse(ctx, "zuul.token.null");
			}else{
				logger.info(String.format("Token:%s",token));
				ctx.addZuulRequestHeader("Authorization", token);
				ctx.addZuulRequestHeader("Cloud-Zuul", "true");
				//ctx.addZuulRequestHeader("appCode", request.getHeader("appCode"));
				ctx.setSendZuulResponse(true);// 对该请求进行路由  
	            ctx.setResponseStatusCode(200);
			}
        }
        return null;
    }
    
    private void setErrorResponse(RequestContext ctx,String errorCode){
    	ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由  
        ctx.setResponseStatusCode(401);// 返回错误码  
        Map<String,Object> map=new HashMap<String,Object>(2);
        map.put("status", 401);
        map.put("errorCode", errorCode);
        ctx.setResponseBody(JSON.toJSONString(map));
    }
}
