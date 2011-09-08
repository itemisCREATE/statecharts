package org.yakindu.sct.generator.cpp.test.generator;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;

import com.google.inject.Binder;
import com.google.inject.Module;

public class TestModule implements Module{

	public void configure(Binder binder) {
	
		binder.bind(IQualifiedNameProvider.class).to(SimpleNameProvider.class);

	}
	
}