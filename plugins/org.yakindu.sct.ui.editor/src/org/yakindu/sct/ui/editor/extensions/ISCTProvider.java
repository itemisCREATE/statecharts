package org.yakindu.sct.ui.editor.extensions;

import org.eclipse.emf.ecore.EObject;

public interface ISCTProvider {

	public boolean isProviderFor(EObject semanticElement);
}
