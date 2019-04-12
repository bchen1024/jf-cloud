package org.btsoft.jf.cloud.core.exception;

import java.util.List;

import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author chenbin
 * @date 2018年6月7日 上午12:25:28
 */
@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> CommonResult<T> handleException(Exception e) {
		e.printStackTrace();
		return CommonResultUtils.fail(ExceptionConstants.SYS_EXCEPTION_CODE, e.getMessage());
	}

	@ExceptionHandler(ApplicationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> CommonResult<T> handleException(ApplicationException e) {
		return CommonResultUtils.fail(e.getHttpCode(),e.getErrorCode(), e.getMessage(), e.getArgs());
	}
	
	@ExceptionHandler(ApplicationI18nException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> CommonResult<T> handleException(ApplicationI18nException e) {
		return CommonResultUtils.fail(e.getHttpCode(),e.getErrorCode(), e.getMessage(), e.getArgs(),true);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> CommonResult<T> handleValidException(MethodArgumentNotValidException e) {
		BindingResult bindingResult=e.getBindingResult();
		List<FieldError> errors=bindingResult.getFieldErrors();
		if(!CollectionUtils.isEmpty(errors)){
			FieldError fieldError=errors.get(0);
			return CommonResultUtils.fail(fieldError.getField()+"."+fieldError.getCode(), fieldError.getDefaultMessage());
		}
		return CommonResultUtils.fail(e.getMessage(), e.getMessage());
	}
}
