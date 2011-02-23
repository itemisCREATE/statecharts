package org.yakindu.sct.statechart.expressions.ui.extensions;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.extensions.IExpressionsProvider;

import com.google.inject.Injector;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionExpressionProvider implements IExpressionsProvider {

	@Override
	public boolean isProviderFor(EObject semanticElement) {
		return StatechartPackage.TRANSITION == semanticElement.eClass()
				.getClassifierID();
	}

	@Override
	public Injector getInjector() {
		return ExtensionsActivator.getDefault().getExpressionsInjector();
	}

}
