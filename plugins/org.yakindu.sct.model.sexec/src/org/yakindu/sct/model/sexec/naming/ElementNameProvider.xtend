/**
 *   Copyright (c) 2016 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 * 		@author René Beckmann (beckmann@itemis.de)
 */

package org.yakindu.sct.model.sexec.naming

import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.yakindu.sct.model.sexec.Reaction
import java.util.List
import java.util.ArrayList
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class ElementNameProvider {
	@Inject StextNameProvider provider
	@Inject protected extension SExecExtensions

	def List<String> elementNameSegments(NamedElement e) {
		val name = elementName(e);
		var ArrayList<String> l;
		if (name !== null) {
			l = new ArrayList<String>(name.getSegments());
		} else {
			l = new ArrayList<String>();
		}

		return l;
	}

	def protected dispatch QualifiedName elementName(ExecutionFlow it) {
		return null;
	}

	def protected dispatch QualifiedName elementName(ExecutionScope it) {
		return sourceElement.elementName()
	}

	def protected dispatch QualifiedName elementName(ExecutionState it) {
		return sourceElement.elementName()
	}

	def protected dispatch QualifiedName elementName(EObject it) {
		eContainer?.elementName()
	}

	def protected dispatch QualifiedName elementName(ExecutionNode it) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}

	// TODO: we should merge the region/vertex case into this base implementation; we should check whether it is used in any case at all (otherwise it could be replaced with the body of vertexOrRegionName)
	def protected dispatch QualifiedName elementName(NamedElement it) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}

	def protected dispatch QualifiedName elementName(Reaction it) {
		provider.getFullyQualifiedName(it).skipFirst(2)
	}

	def protected dispatch QualifiedName elementName(Region it) {
		return provider.getFullyQualifiedName(it).skipFirst(1)
	}

	def protected dispatch QualifiedName elementName(Step it) {
		var parentName = eContainer.elementName
		// parent name may be null
		if (( isEnterSequence || isCheckFunction || isEffect ) && (name !== null) && (!name.trim.empty))
			parentName.append(name)
		else
			parentName
	}

	def protected dispatch QualifiedName elementName(Vertex it) {
		return provider.getFullyQualifiedName(it).skipFirst(1)
	}

}
