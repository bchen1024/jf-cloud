package org.btsoft.jf.cloud.core.exception;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午11:59:33
 */
public class ArgumentsValidException extends RuntimeException {

	private static final long serialVersionUID = 7079022815940782283L;

	private String errorCode;

	private String message;

	private Object[] args;

	public ArgumentsValidException(String errorCode) {
		this.errorCode = errorCode;
	}

	public ArgumentsValidException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public ArgumentsValidException(String errorCode, String message, Object[] args) {
		this.errorCode = errorCode;
		this.message = message;
		this.args = args;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}
