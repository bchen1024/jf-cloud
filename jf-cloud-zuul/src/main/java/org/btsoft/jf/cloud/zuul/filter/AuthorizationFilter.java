package org.btsoft.jf.cloud.zuul.filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.btsoft.jf.cloud.zuul.util.ZuulUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
    
    @Autowired
	private RestTemplate restTempate;
    
    @Value("${jf.auth.user.url:http://jf-cloud-platform/platform/auth/user}")
    private String authUserUrl;
    
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
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
        if(HttpMethod.OPTIONS.matches(method)) {
        	ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由  
            ctx.setResponseStatusCode(200);// 返回错误码  
            ctx.setResponseBody("success");
            return null;
        }
        logger.info("Method:{},Url:{}", method,uri);
        
        //跳过鉴权
        if(ZuulUtils.skipAuthentication(request)){
        	ctx.setSendZuulResponse(true);// 对该请求进行路由  
            ctx.setResponseStatusCode(200);
        }else{
        	String token=ZuulUtils.getToken(request);
			//如果token为空，无权限
			if(StringUtils.isEmpty(token)) {
				ZuulUtils.zuulResponse(ctx, false, 401, "zuul.token.null", "Rquest Header's token cannot be empty");
			}else{
				
				String userInofStr=this.getUserInfo(token);
				if(!StringUtils.isEmpty(userInofStr)) {
					try {
						ctx.addZuulRequestHeader("x-user-info", new String(userInofStr.getBytes(),"UTF-8"));
					} catch (UnsupportedEncodingException e) {
						logger.error("x-user-info set error");
					} 
				}
				 
				ctx.addZuulRequestHeader("Authorization", token);
				ctx.addZuulRequestHeader("x-cloud-zuul", "true");
				if(StringUtils.isEmpty(request.getHeader("appCode"))) {
					ctx.addZuulRequestHeader("x-app-code", request.getHeader("appCode"));
				}
				ctx.setSendZuulResponse(true);
	            ctx.setResponseStatusCode(200);
			}
        }
        return null;
    }
    
    private String getUserInfo(String token) {
    	Map<String, Object> userTokenDTO = new HashMap<String, Object>(1);
		userTokenDTO.put("token", token);
		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String, Object>>(userTokenDTO);
		ResponseEntity<String> rn = restTempate.exchange(authUserUrl, HttpMethod.POST,
				requestEntity, String.class);
		return rn.getBody();
    }
}
