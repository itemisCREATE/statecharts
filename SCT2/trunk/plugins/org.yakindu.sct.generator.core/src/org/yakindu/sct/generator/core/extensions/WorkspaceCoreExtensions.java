package org.yakindu.sct.generator.core.extensions;

import static org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator.CONTEXT_INJECTOR_PROPERTY_NAME;

import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.IExecutionContextAware;
import org.yakindu.sct.generator.core.IGeneratorBridge;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class WorkspaceCoreExtensions implements IExecutionContextAware {
	@Inject(optional = true)
	IGeneratorBridge bridge;

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

	public void writeToConsole(String s) {
		if (bridge != null) {
			bridge.writeToConsole(s);
		}
	}

	public FeatureParameterValue getFeatureParameter(GeneratorEntry entry,
			String featureName, String paramName) {
		if (bridge != null) {
			return bridge.getFeatureParameter(entry, featureName, paramName);
		}
		return null;
	}

	public void refreshTargetProject(GeneratorEntry entry) {
		if (bridge != null) {
			bridge.refreshTargetProject(entry);
		}

	}
}
