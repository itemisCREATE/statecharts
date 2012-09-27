package org.yakindu.sct.model.sgraph.test;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return Guice.createInjector(new SGraphTestModule());
	}

}
