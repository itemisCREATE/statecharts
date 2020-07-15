package org.yakindu.sct.generator.core.extensions;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.lib.StatechartAnnotations;

import com.google.inject.Inject;
//Use StatechartAnnotations
@Deprecated
public class AnnotationExtensions {
	
	@Inject StatechartAnnotations statechartAnnotations;
	
	public boolean isEventDriven(GeneratorEntry entry) {
		Statechart statechart = (Statechart) entry.getElementRef();
		return isEventDriven(statechart);
	}

	public boolean isEventDriven(Statechart statechart) {
		return statechartAnnotations.isEventDriven(statechart);
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
