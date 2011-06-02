/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.resource;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * interface for a injection service, that the {@link InjectMembersResource}
 * uses inject object members.
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public interface IMemberInjectionService {
	/**
	 * checks wether this service is for the given {@link EObject}
	 * 
	 * @param object
	 *            the object to check for
	 * @return true if the service is for the specified object, false otherwise
	 */
	public boolean isServiceFor(EObject object);

	/**
	 * Injects the members of the given object. The implementation should know
	 * which members to inject for the specified object.
	 * 
	 * @param object
	 */
	public void injectMembers(EObject object);

	/**
	 * The feature where the information is stored to derive the member values.
	 * 
	 * @return the StructuralFeature where further information is stored
	 */
	public EStructuralFeature getSourceFeature();

	/**
	 * returns a List of Diagnostics
	 */
	public List<Diagnostic> getDiagnostics();

}
