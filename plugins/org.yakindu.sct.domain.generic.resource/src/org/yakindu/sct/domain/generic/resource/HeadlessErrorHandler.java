package org.yakindu.sct.domain.generic.resource;

import org.yakindu.sct.model.stext.scoping.STextScopeProvider.ErrorHandlerDelegate;

public class HeadlessErrorHandler<T> extends ErrorHandlerDelegate<T> {
	@Override
	public T handle(Object[] params, Throwable throwable) {
		/// XXX: has to be an instance of Error because of
		/// org.eclipse.xtext.util.PolymorphicDispatcher.invoke(Object...)
		throw new HeadlessError(throwable);
		// return delegate.handle(params, throwable);

	}

	public static class HeadlessError extends Error {

		private static final long serialVersionUID = -670534113540254487L;

		public HeadlessError(Throwable throwable) {
			super(throwable);
		}

	}

}
