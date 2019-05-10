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
package org.yakindu.sct.types.generator.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.sct.types.modification.IModification

/**
 * Moves all declarations of inner types to their outer type while qualifying their names. Empty inner types are removed.
 * 
 */
class FlattenInnerTypesModification implements IModification {
	
	@Inject 
	protected extension ComplexTypeNavigationExtensions
	
	@Inject 
	protected extension PackageNavigationExtensions
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.forEach[ rootType |
			// go from leaf types upwards and move declarations step-by-step while renaming them
			while (!rootType.innerTypes.isEmpty) {
				rootType.innerTypes.filter[isLeaf].forEach [ leaf |
					leaf.features.clone.forEach [ f |
						f.qualifyName
						f.moveUp
					]
					EcoreUtil.remove(leaf)
				]
			}
		]
		return p
	}
	
	protected def innerTypes(ComplexType rootType) {
		rootType.eAllContents.filter(ComplexType).filter[!isInterfaceGroupType].filter[!isEnumerationType].toList
	}
	
	protected def boolean isLeaf(ComplexType ct) {
		ct.features.filter(ComplexType).isNullOrEmpty
	}
	
	protected def boolean isInterfaceGroupType(ComplexType ct) {
		ct.getAnnotationOfType("InterfaceGroup") !== null
	}
	
	protected def boolean isEnumerationType(ComplexType ct) {
		ct instanceof EnumerationType
	}
	
	protected def void moveUp(Declaration decl) {
		val myType = decl.eContainer as ComplexType
		val outerType = myType.eContainer
		if (outerType instanceof ComplexType) {
			outerType.features += decl
		} else {
			throw new IllegalStateException("Could not move declaration to outer type: " + decl)
		}
	}
	
	protected def void qualifyName(Declaration decl) {
		decl.name = decl.eContainer.name + "_" + decl.name
	}
	
	protected def dispatch name(EObject e) { "" }
	protected def dispatch name(NamedElement e) { e.getName }
	
}
