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
package org.yakindu.sct.types.generator.statechart.java.modification

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.ComplexTypeNavigationExtensions
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.sequencer.util.SequencerAnnotationLibrary
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.types.modification.util.ReferenceExtension

/**
 * The model sequence wraps internal scopes in a complex type. To not break API, we need to unwrap this type again.
 */
class UnwrapInternalInterfaceModification implements IModification {
	
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension ComplexTypeNavigationExtensions
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ReferenceExtension
	@Inject protected extension ExpressionBuilder
	@Inject protected extension SequencerAnnotationLibrary
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.forEach[ ct |
			val internalType = ct.internalType
			if (internalType !== null) {
				internalType.replaceBy(internalType.features)
				val internalTypeProperty = ct.getInterfaceProperty(internalType)
				if (internalTypeProperty !== null) {
					internalTypeProperty.retargetReferences
					EcoreUtil.remove(internalTypeProperty)
				}
			}
		]
		p
	}
	
	protected def getInternalType(ComplexType ct) {
		ct.complexTypes.filter[isInterfaceGroup].filter[visibility == Visibility.PROTECTED].head
	}
	
	protected def getInterfaceProperty(ComplexType ct, ComplexType iface) {
		ct.properties.findFirst[type == iface]
	}
	
	protected def void retargetReferences(Property p) {
		p.references.forEach[unqualify]
	}
	
}
