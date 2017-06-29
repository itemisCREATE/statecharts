package org.yakindu.sct.model.sgraph.test.resource;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.model.resource.SCTXtextIntegrationModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SCTTestInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return Guice.createInjector(new SharedStateModule(), new SCTXtextIntegrationModule());
	}

}