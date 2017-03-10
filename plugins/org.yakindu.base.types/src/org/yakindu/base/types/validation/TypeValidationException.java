package org.yakindu.base.types.validation;

public class TypeValidationException extends Exception {
	private String errorCode;
	public TypeValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeValidationException(String msg, Throwable arg1, boolean arg2, boolean arg3) {
		super(msg, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public TypeValidationException(String msg, Throwable arg1) {
		super(msg, arg1);
		// TODO Auto-generated constructor stub
	}

	public TypeValidationException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	public TypeValidationException(String msg, String errorCode) {
		super(msg);
		// TODO Auto-generated constructor stub
		this.errorCode = errorCode;
	}

	public TypeValidationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}
}
