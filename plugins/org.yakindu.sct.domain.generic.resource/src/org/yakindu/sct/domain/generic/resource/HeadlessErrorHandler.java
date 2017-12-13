package org.yakindu.sct.domain.generic.resource;

import org.yakindu.sct.model.stext.scoping.STextScopeProvider.ErrorHandlerDelegate;

public class HeadlessErrorHandler<T> extends ErrorHandlerDelegate<T> {
	@Override
	public T handle(Object[] params, Throwable throwable) {
		throw new HeadlessError(throwable);
	}

}
