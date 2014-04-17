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
package org.yakindu.sct.simulation.core.debugmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.base.NamedElement;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugElement extends DebugElement {

	public SCTDebugElement(IDebugTarget target, String resourceString) {
		super(target);
		this.resourceString = resourceString;
	}

	private String resourceString;

	public String getResourceString() {
		return resourceString;
	}

	public String getModelIdentifier() {
		return IDebugConstants.ID_DEBUG_MODEL;
	}

	public String fullQfn(NamedElement element) {
		List<String> qfnFragments = new ArrayList<String>();
		qfnFragments.add(element.getName());
		EObject current = element;
		while (!(current.eContainer() != EcoreUtil.getRootContainer(current))) {
			current = current.eContainer();
			if (current instanceof NamedElement) {
				String name = ((NamedElement) current).getName();
				if (name != null) {
					qfnFragments.add(name.replaceAll(" ", ""));
				} else {
					qfnFragments.add("<name>");
				}
			}
		}
		Collections.reverse(qfnFragments);
		StringBuilder sb = new StringBuilder();

		sb.append(element.getName() != null ? element.getName() : element.eClass().getName());
		sb.append("  (");
		String sep = "";
		for (String s : qfnFragments) {
			sb.append(sep).append(s);
			sep = ".";
		}
		sb.append(")");

		sb.append(" resource: ");
		sb.append(element.eResource().getURI().lastSegment());
		return sb.toString();
	}

}
