package org.yakindu.base.types.validation;

@SuppressWarnings("serial")
public class TypeValidationException extends Exception {
	private String errorCode;
	
	public TypeValidationException(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
