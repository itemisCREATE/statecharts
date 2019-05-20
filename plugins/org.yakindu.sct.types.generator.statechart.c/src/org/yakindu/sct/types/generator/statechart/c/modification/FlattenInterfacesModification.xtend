/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.statechart.c.modification

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

/*
 * Copy of FlattenComplexTypes to avoid underscores. Needed to keep API standard. Can probably removed/changed with 4.0
 */
class FlattenInterfacesModification implements IModification {
	@Inject protected extension SequencerAnnotationLibrary
	@Inject protected extension CoreCGeneratorAnnotationLibrary

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(ComplexType).filter[isInterfaceGroup].toList.forEach [ct | // additional filter on "InterfaceGroup" annotation
			ct.name = ct.getContainmentHierarchy
			ct.rootType = EcoreUtil2.getAllContainers(ct).filter(ComplexType).last
			p.member += ct
		]

		return p
	}

	def protected String getContainmentHierarchy(ComplexType it) {
		if (eContainer instanceof ComplexType) {
			return getContainmentHierarchy(eContainer as ComplexType) + name // removed underscore at this point
		}
		return name
	}

}
