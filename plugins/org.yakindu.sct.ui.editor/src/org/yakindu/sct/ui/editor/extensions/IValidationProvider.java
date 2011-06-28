package org.yakindu.sct.ui.editor.extensions;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author muelder
 * 
 */
public interface IValidationProvider extends ISCTProvider {

	public Set<IStatus> validate(EObject semanticElement);
}
