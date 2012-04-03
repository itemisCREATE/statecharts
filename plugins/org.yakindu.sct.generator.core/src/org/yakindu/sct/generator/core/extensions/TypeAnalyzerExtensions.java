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
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class TypeAnalyzerExtensions implements IExecutionContextAware {
	@Inject
	private ITypeInferrer typeInferrer;
	@Inject
	private ITypeSystemAccess access;

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

	public boolean isBoolean(Type type) {
		return access.isBoolean(type);
	}

	public boolean isInteger(Type type) {
		return access.isInteger(type);
	}

	public boolean isReal(Type type) {
		return access.isReal(type);
	}

	public boolean isString(Type type) {
		return access.isString(type);
	}

	public Type getType(Statement stmt) {
		return typeInferrer.getType(stmt);
	}

}
