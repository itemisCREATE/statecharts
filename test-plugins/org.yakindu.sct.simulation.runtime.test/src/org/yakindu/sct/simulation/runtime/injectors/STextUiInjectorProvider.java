package org.yakindu.sct.simulation.runtime.injectors;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Injector;

public class STextUiInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return STextActivator.getInstance().getInjector(
				STextUiModule.STEXT_LANGUAGE_NAME);
	}

}
