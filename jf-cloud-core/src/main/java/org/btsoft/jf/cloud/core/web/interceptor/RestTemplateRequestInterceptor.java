package org.btsoft.jf.cloud.core.web.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {
	
	private final static Logger logger=LoggerFactory.getLogger(RestTemplateRequestInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		traceRequest(request,body);
		return execution.execute(request, body);
	}
	
	private void traceRequest(HttpRequest request, byte[] body) throws IOException {
		logger.debug("===========================restTemplate request begin================================================");
		logger.debug("URI         : {}", request.getURI());
		logger.debug("Method      : {}", request.getMethod());
		logger.debug("Headers     : {}", request.getHeaders());
		logger.debug("Request body: {}", new String(body, "UTF-8"));
		logger.debug("==========================restTemplate request end================================================");
    }
}
