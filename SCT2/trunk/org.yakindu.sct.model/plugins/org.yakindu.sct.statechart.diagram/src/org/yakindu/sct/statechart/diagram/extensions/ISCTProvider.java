package org.yakindu.sct.statechart.diagram.extensions;

import org.eclipse.emf.ecore.EObject;

public interface ISCTProvider {

	public boolean isProviderFor(EObject semanticElement);
}
