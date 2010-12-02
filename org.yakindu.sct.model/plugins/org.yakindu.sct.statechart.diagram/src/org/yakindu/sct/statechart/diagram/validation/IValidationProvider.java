package org.yakindu.sct.statechart.diagram.validation;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author muelder
 * 
 */
public interface IValidationProvider {

	public boolean isProviderFor(EObject semanticElement);

	public Set<IStatus> validate(EObject semanticElement);
}
