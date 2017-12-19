/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.domain.generic.resource;

import org.yakindu.sct.model.stext.scoping.STextScopeProvider.ErrorHandlerDelegate;

/**
 * 
 * @author johannes dicks - Initial contribution and API
 * 
 */
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
