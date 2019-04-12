package org.btsoft.jf.cloud.core.web.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * @author chenbin
 * @date 2019-03-10 21:15
 */
@Component
public class RestTemplateTokenInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		System.out.println(JSON.toJSONString(request.getHeaders().get("Authorization")));
		return execution.execute(request, body);
	}

}
