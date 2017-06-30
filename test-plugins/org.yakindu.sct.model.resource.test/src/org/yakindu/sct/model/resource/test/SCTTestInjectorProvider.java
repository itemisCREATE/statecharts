package org.yakindu.sct.model.resource.test;

import static com.google.inject.Guice.createInjector;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class SCTTestInjectorProvider implements IInjectorProvider {


	public Injector getInjector() {


		Module with2 = Modules.override(new STextRuntimeModule()).with(new SharedStateModule());

		Module with3 = Modules.override(with2).with((Module) new STextUiModule(STextActivator.getInstance()));

		return createInjector(with3);
	}

}