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
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.Visibility
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.types.generator.modification.library.ComplexTypeNavigationExtensions
import org.yakindu.sct.types.generator.modification.library.ContainmentExtensions
import org.yakindu.sct.types.generator.modification.library.ReferenceExtension
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.model.sequencer.ModelSequencerNaming

class DefaultInterfacePropertyAccessModification implements IModification {
	
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension ComplexTypeNavigationExtensions
	@Inject protected extension ContainmentExtensions
	@Inject protected extension ExpressionBuilder
	
	@Inject protected extension ModelSequencerNaming
	@Inject protected extension ReferenceExtension
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.forEach[ ct |
			val defaultIfaceType = ct.defaultIfaceType
			if (defaultIfaceType !== null) {
				val typeProp = ct.getInterfaceProperty(defaultIfaceType)
				defaultIfaceType.operations.filter[visibility == Visibility.PUBLIC].filter[body !== null].forEach[ op |
					val newOp = EcoreUtil.copy(op)
					newOp.eAllContents.filter(ElementReferenceExpression).filter[reference instanceof Property].forEach[qualifyWith(typeProp)]
					ct.add(newOp)
				]
			}
		]
		p
	}
	
	protected def getDefaultIfaceType(ComplexType ct) {
		ct.complexTypes.filter[isInterfaceType].filter[name == defaultInterfaceTypeName].head
	}
	
	protected def isInterfaceType(Type t) {
		t.getAnnotationOfType("InterfaceGroup") !== null
	}
	
	protected def getInterfaceProperty(ComplexType ct, ComplexType iface) {
		ct.properties.findFirst[type == iface]
	}
	
}
