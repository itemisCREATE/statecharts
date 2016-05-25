/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;

/**
 * @author Thomas Kutz - Initial contribution and API
 */
public class TypesUtil {

	public static final String ID_SEPARATOR = ".";

	public static String computeQID(NamedElement element) {
		if (element.getName() == null) {
			return null;
		}

		StringBuilder id = new StringBuilder();
		id.append(element.getName());
		EObject container = element.eContainer();
		while (container != null) {
			if (container.eClass().getEAllStructuralFeatures().contains(BasePackage.Literals.NAMED_ELEMENT__NAME)) {
				String name = (String) container.eGet(BasePackage.Literals.NAMED_ELEMENT__NAME);
				if (name != null) {
					id.insert(0, ID_SEPARATOR);
					id.insert(0, name);
				}
			}
			container = container.eContainer();
		}
		return id.toString();
	}
	
}
