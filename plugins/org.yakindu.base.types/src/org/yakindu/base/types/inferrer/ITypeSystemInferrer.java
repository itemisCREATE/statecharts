/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.inferrer;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;

import com.google.inject.ImplementedBy;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(ITypeSystemInferrer.NullTypeInferrer.class)
public interface ITypeSystemInferrer {

	public static final String EXCEPTION_CODE = "RuntimeExcpetion";
	public static final String NO_INFER_METHOD_CODE = "NoInferMethod";
	public static final String IS_TYPE_CODE = "NotExpectedType.";
	public static final String NOT_TYPE_CODE = "NotType";
	public static final String NOT_SAME_CODE = "NotSame";
	public static final String NOT_COMPATIBLE_CODE = "IncompatibleTypes";

	public Type inferType(EObject object, IValidationIssueAcceptor acceptor);

	public static class NullTypeInferrer implements ITypeSystemInferrer {

		@Override
		public Type inferType(EObject object, IValidationIssueAcceptor acceptor) {
			return null;
		}

	}

}
