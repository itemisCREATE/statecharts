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
package org.yakindu.sct.types.generator.statechart.c.modification

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.types.StatemachineProperties
import org.yakindu.sct.model.sexec.transformation.ArrayType
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification
import org.yakindu.sct.types.modification.util.ReferenceExtension

class NextStateIndexModification implements IModification {

	@Inject protected extension StatemachineProperties
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ITypeSystem tys
	@Inject protected extension ArrayType
	@Inject protected extension ReferenceExtension
	@Inject protected extension TypeBuilder
	@Inject protected extension CoreCGeneratorAnnotationLibrary
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val stateVectorProp = p.eAllContents.filter(Property).findFirst[name == "stateVector"]
		val orthogonalStates = typesFactory.createProperty => [ prop |
			prop.name = "maxOrthogonalStates"
			prop.initialValue = EcoreUtil.copy(
				((stateVectorProp.initialValue as FeatureCall).arguments.head as Argument).value)
			prop.typeSpecifier = typesFactory.createTypeSpecifier => [ ts |
				ts.type = tys.getType(ITypeSystem.INTEGER)
			]
			prop.visibility = Visibility.PROTECTED
			prop.const = true
			prop.static = true

			prop._annotateWith(defineAnnotation)
		]
		addConstant(p, orthogonalStates)

		stateVectorProp.references.forEach [ ref |
			val fc = ref.eContainer
			if (fc instanceof FeatureCall) {
				if (fc.feature == _array._length) {
					EcoreUtil.replace(fc, orthogonalStates._ref)
				}
			}
		]

		return p
	}

	protected def boolean addConstant(Package p, Property orthogonalStates) {
		p.member += orthogonalStates
	}

}
