package org.yakindu.sct.generator.c;

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION;

import org.yakindu.base.types.Annotation;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public abstract class AbstractContentFragmentProvider<T> implements Provider<T> {
	@Inject
	protected Injector injector;

	protected boolean isEventDriven() {
		GeneratorEntry entry = injector.getInstance(GeneratorEntry.class);
		Statechart statechart = (Statechart) entry.getElementRef();
		Annotation eventDrivenAnnotation = statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION);
		return eventDrivenAnnotation != null;
	}
}
