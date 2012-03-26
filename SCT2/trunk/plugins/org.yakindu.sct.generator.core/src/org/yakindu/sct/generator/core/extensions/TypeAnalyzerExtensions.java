package org.yakindu.sct.generator.core.extensions;

import static org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator.CONTEXT_INJECTOR_PROPERTY_NAME;

import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.IExecutionContextAware;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.validation.ITypeAnalyzer;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class TypeAnalyzerExtensions implements IExecutionContextAware {
	@Inject
	ITypeAnalyzer typeAnalyzer;

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
		return typeAnalyzer.isBoolean(type);
	}

	public boolean isInteger(Type type) {
		return typeAnalyzer.isInteger(type);
	}

	public boolean isReal(Type type) {
		return typeAnalyzer.isReal(type);
	}

	public boolean isString(Type type) {
		return typeAnalyzer.isString(type);
	}

	public Type inferType(Statement stmt) {
		return typeAnalyzer.inferType(stmt);
	}

}
