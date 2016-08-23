package org.yakindu.sct.generator.core;

import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;

public interface GeneratorModule {

	public abstract void configure(GeneratorEntry entry, Binder binder);

}
