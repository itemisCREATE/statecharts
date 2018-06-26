package org.yakindu.sct.model.stext.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;

public interface ISCTExtensions {
	public SpecificationElement getContextElement(EObject context);
	
	public ScopedElement getScopedElement(EObject context);
	
	public Statechart getStatechart(EObject context);
	
	public Statechart getStatechart(final Resource context);
}
