/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.extensions;

import static org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator.CONTEXT_INJECTOR_PROPERTY_NAME;

import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.IExecutionContextAware;
import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.base.types.Type;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class TypeAnalyzerExtensions implements IExecutionContextAware {

	@Inject
	private ISTextTypeInferrer typeInferrer;
	@Inject
	private ISTextTypeSystem typeSystem;
	@Inject
	private ICodegenTypeSystemAccess typeSystemAccess;

	public void setExecutionContext(ExecutionContext ctx) {
		Injector injector = null;
		if (ctx.getGlobalVariables().get(CONTEXT_INJECTOR_PROPERTY_NAME) != null) {
			injector = (Injector) ctx.getGlobalVariables()
					.get(CONTEXT_INJECTOR_PROPERTY_NAME).getValue();
		} else if (ctx.getGlobalVariables().get(Injector.class.getName()) != null) {
			injector = (Injector) ctx.getGlobalVariables()
					.get(Injector.class.getName()).getValue();
		}
		if (injector != null) {
			injector.injectMembers(this);
		}
	}

	public boolean isStringType(Type type) {
		return typeSystem.isStringType(new InferredType(type));
	}

	public Type getType(Statement stmt) {
		if (stmt instanceof Expression) {
			InferredType type = typeInferrer.inferType((Expression) stmt)
					.getType();
			if (type != null) {
				return typeSystem.getTypes(type).iterator().next();
			}
		}
		return null;
	}

}
