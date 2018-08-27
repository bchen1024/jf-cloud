package org.btsoft.jf.cloud.core.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.btsoft.jf.cloud.core.auth.context.RequestContext;
import org.btsoft.jf.cloud.core.auth.context.RequestManagement;
import org.btsoft.jf.cloud.core.auth.context.RequestUser;
import org.btsoft.jf.cloud.core.auth.entity.UserInfo;
import org.btsoft.jf.cloud.core.base.result.CommonResult;
import org.btsoft.jf.cloud.core.base.service.IUserQueryService;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

/**
 * 
 * @author chenbin
 * @date 2018年7月5日 下午11:10:36
 */
@Order(-200)
@WebFilter(filterName="cloudRequestContextFilter",urlPatterns={"/**"})
public class CloudRequestContextFilter implements Filter {
	
	@Autowired
	private IUserQueryService userQueryService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String cloudZuul=req.getHeader("Cloud-Zuul");
		if("true".equals(cloudZuul)){
			//获取鉴权token
			String token=req.getHeader("Authorization");
			CommonResult<UserInfo> cr= userQueryService.findUserByToken(token);
			RequestContext rc=new RequestContext();
			RequestUser user=EntityUtils.copyProperties(cr.getData(), RequestUser.class);
			rc.setUser(user);
			RequestManagement.setCurrent(rc);
		}
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
	}

}
