package org.yakindu.sct.ui.integration.stext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionsProvider;
import org.yakindu.sct.ui.integration.stext.modules.TransitionRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.TransitionUIModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionExpressionProvider extends AbstractExpressionsProvider
		implements IExpressionsProvider {

	public Injector createInjector() {
		return Guice.createInjector(Modules.override(
				Modules.override(new TransitionRuntimeModule())
						.with(new TransitionUIModule(ExtensionsActivator
								.getDefault()))).with(new SharedStateModule()));
	}

	public int getStyle() {
		return SWT.SINGLE;
	}

	@Override
	protected EClass getType() {
		return SGraphPackage.Literals.TRANSITION;
	}

	@Override
	protected String getResourceExtension() {
		return "sct";
	}

}
