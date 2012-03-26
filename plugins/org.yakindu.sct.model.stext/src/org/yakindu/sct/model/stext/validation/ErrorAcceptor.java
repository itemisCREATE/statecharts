package org.yakindu.sct.model.stext.validation;

public class ErrorAcceptor {
	public void acceptError(String msg) {
		throw new TypeCheckException(msg);
	}
}
