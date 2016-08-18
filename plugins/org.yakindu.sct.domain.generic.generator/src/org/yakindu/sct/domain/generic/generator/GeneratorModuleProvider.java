package org.yakindu.sct.domain.generic.generator;

import org.yakindu.sct.domain.extension.IModuleProvider;

import com.google.inject.Module;

public class GeneratorModuleProvider implements IModuleProvider {

	@Override
	public Module getModule(String... options) {
		return new GenericGeneratorModule();
	}

}
