package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.core.extensions.AnnotationExtensions;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public abstract class AbstractContentFragmentProvider<T> implements Provider<T> {
	@Inject
	protected Injector injector;
	@Inject
	protected AnnotationExtensions annotationExtensions;

	protected boolean isEventDriven() {
		GeneratorEntry entry = injector.getInstance(GeneratorEntry.class);
		return annotationExtensions.isEventDriven(entry);
	}
}
