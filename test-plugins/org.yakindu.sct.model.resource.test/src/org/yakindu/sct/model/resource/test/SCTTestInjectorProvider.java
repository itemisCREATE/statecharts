package org.yakindu.sct.model.resource.test;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.model.resource.SCTXtextIntegrationModule;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Injector;
import com.google.inject.Module;

public class SCTTestInjectorProvider implements IInjectorProvider {


	public Injector getInjector() {
		return createInjector(override(override(override(new STextRuntimeModule()).with(getSharedStateModule()))
				.with(new STextUiModule(STextActivator.getInstance()))).with(new SCTXtextIntegrationModule()));
	}

	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}

}