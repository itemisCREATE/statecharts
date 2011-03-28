package org.yakindu.sct.statechart.expressions.ui.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.extensions.IExpressionsProvider;
import org.yakindu.sct.statechart.expressions.ui.extensions.modules.StatechartRuntimeModule;
import org.yakindu.sct.statechart.expressions.ui.extensions.modules.StatechartUIModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;
/**
 * 
 * @author muelder
 *
 */
public class StatechartExpressionProvider implements IExpressionsProvider {

	
	public boolean isProviderFor(EObject semanticElement) {
		return StatechartPackage.STATECHART == semanticElement.eClass()
				.getClassifierID();
	}

	
	public Injector getInjector() {
		return Guice.createInjector(Modules.override(
				Modules.override(new StatechartRuntimeModule()).with(
						new StatechartUIModule(ExtensionsActivator.getDefault()))).with(
				new SharedStateModule()));
	}

}
