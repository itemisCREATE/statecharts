/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.util;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;

public class StatechartUtil {
	public boolean isStatemachineType(Type type) {
		if (type instanceof ComplexType) {
			for(TypeSpecifier t : type.getSuperTypes()) {
				return t.getType().getName().equals("Statemachine");
			}
		}
		return false;
	}
}
