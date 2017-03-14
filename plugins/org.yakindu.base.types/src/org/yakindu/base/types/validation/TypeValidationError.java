package org.yakindu.base.types.validation;

@SuppressWarnings("serial")
public class TypeValidationError {
	private String errorCode;
	private String message;
	
	public TypeValidationError(String msg, String errorCode) {
		this.message = msg;
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	public String getMessage() {
		return message;
	}
}
