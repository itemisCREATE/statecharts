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
package org.yakindu.sct.types.generator.statechart.cpp.modifications

import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.statechart.c.modification.NextStateIndexModification
import org.yakindu.sct.types.modification.IModification

class CppNextStateIndexModification extends NextStateIndexModification implements IModification {
	override boolean addConstant(Package p, Property orthogonalStates) {
		p.member.filter(ComplexType).head.features += orthogonalStates
	}
}
