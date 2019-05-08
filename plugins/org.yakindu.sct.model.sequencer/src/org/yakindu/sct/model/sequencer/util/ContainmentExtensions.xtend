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
package org.yakindu.sct.model.sequencer.util

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.FeatureMapUtil
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Package

class ContainmentExtensions {

	def dispatch add(EObject e, Declaration decl) {
		throw new IllegalArgumentException("Can't add Declaration to EObject: " + e);
	}

	def dispatch add(Package p, Declaration decl) {
		p.member.add(decl)
	}

	def dispatch add(ComplexType cT, Declaration decl) {
		cT.features.add(decl)
	}

	def dispatch add(BlockExpression block, Expression exp) {
		block.expressions.add(exp)
	}

	/** 
	 * EcoreUtil.replace(EObject, EObject) copied and changed to handle multiple replacement objects
	 */
	def replaceBy(EObject eObject, EObject... replacementObjects) {
		val container = eObject.eContainer();
		if (container !== null) {
			val feature = eObject.eContainmentFeature();
			if (FeatureMapUtil.isMany(container, feature)) {
				val list = container.eGet(feature) as List<Object>
				val idx = list.indexOf(eObject)
				list.remove(idx)
				list.addAll(idx, replacementObjects)
			} else {
				throw new IllegalArgumentException("Cannot add multiple objects to single-valued containment feature " + feature)
			}
		}
		val resource = (eObject as InternalEObject).eDirectResource();
		if (resource !== null) {
			val list = resource.getContents();
			val idx = list.indexOf(eObject)
			list.remove(idx)
			list.addAll(idx, replacementObjects)
		}
	}
	
	def boolean containedIn(EObject exp, EObject toCheck) {
		var container = exp.eContainer
		if (container === null) {
			return false
		}
		if (container === toCheck) {
			return true;
		}
		return container.containedIn(toCheck)
	}
}
