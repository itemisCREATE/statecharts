package org.yakindu.sct.generator.core.extensions;

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Annotation;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

public class AnnotationExtensions {
	public boolean isEventDriven(GeneratorEntry entry) {
		Statechart statechart = (Statechart) entry.getElementRef();
		return isEventDriven(statechart);
	}

	public boolean isEventDriven(Statechart statechart) {
		Annotation eventDrivenAnnotation = statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION);
		return eventDrivenAnnotation != null;
	}

	public boolean isEventDriven(ExecutionFlow flow) {
		EObject sourceElement = flow.getSourceElement();
		if (sourceElement instanceof Statechart) {
			return isEventDriven((GeneratorEntry) sourceElement);
		} else {
			return false;
		}
	}
}
