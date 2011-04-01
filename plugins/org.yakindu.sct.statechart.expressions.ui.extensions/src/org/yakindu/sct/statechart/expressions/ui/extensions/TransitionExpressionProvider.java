package org.yakindu.sct.statechart.expressions.ui.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.extensions.IExpressionsProvider;
import org.yakindu.sct.statechart.expressions.ui.extensions.modules.TransitionRuntimeModule;
import org.yakindu.sct.statechart.expressions.ui.extensions.modules.TransitionUIModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionExpressionProvider implements IExpressionsProvider {

	public boolean isProviderFor(EObject semanticElement) {
		return StatechartPackage.TRANSITION == semanticElement.eClass()
				.getClassifierID();
	}

	public Injector getInjector() {
		return Guice.createInjector(Modules.override(
				Modules.override(new TransitionRuntimeModule())
						.with(new TransitionUIModule(ExtensionsActivator
								.getDefault()))).with(new SharedStateModule()));
	}

	public int getStyle() {
		return SWT.SINGLE;
	}

}
