package org.btsoft.jf.cloud.core.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.context.RequestManagement;
import org.btsoft.jf.cloud.core.auth.user.UserInfo;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.service.IUserQueryService;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 
 * @author chenbin
 * @date 2018年7月5日 下午11:10:36
 */
public class CloudRequestContextFilter implements Filter {
	
	private final static Logger logger = LoggerFactory.getLogger(CloudRequestContextFilter.class);
	
	@Autowired
	private IUserQueryService userQueryService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		logger.info("Request Method:{},Request Url:{}", req.getMethod(),req.getRequestURI());
		String cloudZuul=req.getHeader("x-cloud-zuul");
		if("true".equals(cloudZuul)){
			String userInfo=req.getHeader("x-user-info");
			CommonResult<UserInfo> cr;
			if(StringUtils.isNotEmpty(userInfo)) {
				cr= (CommonResult<UserInfo>) JSON.parseObject(userInfo,
						new TypeReference<CommonResult<UserInfo>>() {
						});
			}else {
				//获取鉴权token
				String token=req.getHeader("Authorization");
				cr= userQueryService.findUserByToken(token);
			}
			
			RequestContext rc=new RequestContext();
			UserInfo user=EntityUtils.copyProperties(cr.getData(), UserInfo.class);
			rc.setUser(user);
			RequestManagement.setCurrent(rc);
		}
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
	}

}
