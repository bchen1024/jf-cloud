package org.btsoft.jf.cloud.core.util;

import org.btsoft.jf.cloud.core.base.result.CommonResult;

/**
 * 
 * @author chenbin
 * @date 2018年6月7日 上午12:07:47
 */
public class CommonResultUtils {

	/**
	 * 成功结果处理
	 * 
	 * @param data
	 * @return
	 */
	public static <T> CommonResult<T> success(T data) {
		CommonResult<T> result = new CommonResult<T>();
		result.setData(data);
		return result;
	}

	public static <T> CommonResult<T> fail(String errorCode) {
		CommonResult<T> result = new CommonResult<T>();
		result.setHttpCode(500);
		result.setErrorCode(errorCode);
		return result;
	}

	public static <T> CommonResult<T> fail(String errorCode, String errorMsg) {
		CommonResult<T> result = new CommonResult<T>();
		result.setHttpCode(500);
		result.setErrorCode(errorCode);
		result.setErrorMsg(errorMsg);
		return result;
	}

	public static <T> CommonResult<T> fail(String errorCode, String errorMsg, Object[] args) {
		CommonResult<T> result = new CommonResult<T>();
		result.setHttpCode(500);
		result.setErrorCode(errorCode);
		result.setErrorMsg(errorMsg);
		result.setArgs(args);
		return result;
	}
	
}
