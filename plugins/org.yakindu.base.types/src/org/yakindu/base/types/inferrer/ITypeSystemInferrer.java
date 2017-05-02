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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ITypeSystemInferrer {

	public static final String EXCEPTION_CODE = "RuntimeException";
	public static final String NO_INFER_METHOD_CODE = "NoInferMethod";
	public static final String IS_TYPE_CODE = "NotExpectedType.";
	public static final String NOT_TYPE_CODE = "NotType";
	public static final String NOT_SAME_CODE = "NotSame";
	public static final String NOT_COMPATIBLE_CODE = "IncompatibleTypes";
	public static final String NOT_INFERRABLE_TYPE_PARAMETER_CODE = "NotInferrableTypeParameter";

	public static class InferenceResult {

		private Type type;
		private List<InferenceResult> bindings = new ArrayList<>();

		protected InferenceResult(Type type) {
			Assert.isNotNull(type);
			this.type = type;
		}

		protected InferenceResult(Type type, List<InferenceResult> bindings) {
			Assert.isNotNull(type);
			Assert.isNotNull(bindings);
			this.type = type;
			this.bindings.addAll(bindings);
		}

		public static InferenceResult from(Type type) {
			return new InferenceResult(type);
		}

		public static InferenceResult from(Type type, List<InferenceResult> bindings) {
			return new InferenceResult(type, bindings);
		}

		public Type getType() {
			return type;
		}

		public List<InferenceResult> getBindings() {
			return bindings;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(type.toString());
			if (bindings.size() > 0) {
				builder.append("<");
				String sep = "";
				for (InferenceResult type : bindings) {
					builder.append(sep);
					builder.append(type.toString());
					sep = ",";
				}
				builder.append(">");
			}
			return builder.toString();
		}
	}

	public InferenceResult infer(EObject object, IValidationIssueAcceptor acceptor);

	public InferenceResult infer(EObject object);

}
