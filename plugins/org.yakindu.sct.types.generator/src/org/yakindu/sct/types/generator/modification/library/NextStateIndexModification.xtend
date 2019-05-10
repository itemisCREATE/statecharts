package org.yakindu.sct.types.generator.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sequencer.types.StatemachineProperties
import org.yakindu.sct.model.sexec.transformation.ArrayType
import org.yakindu.sct.types.modification.IModification

class NextStateIndexModification implements IModification {

	@Inject protected extension StatemachineProperties
	@Inject protected extension ExpressionBuilder
	@Inject protected extension ITypeSystem tys
	@Inject protected extension ArrayType
	@Inject protected extension ReferenceExtension
	@Inject protected extension TypeBuilder
	extension TypesFactory typesFactory = TypesFactory.eINSTANCE

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val stateVectorProp = p.eAllContents.filter(Property).findFirst[name == "stateVector"]
		val outerClass = p.member.filter(ComplexType).head
		val orthogonalStates = typesFactory.createProperty => [ prop |
			prop.name = "maxOrthogonalStates"
			prop.initialValue = EcoreUtil.copy(
				((stateVectorProp.initialValue as FeatureCall).arguments.head as Argument).value)
			prop.typeSpecifier = typesFactory.createTypeSpecifier => [ ts |
				ts.type = tys.getType(ITypeSystem.INTEGER)
			]
			val annotationType = createAnnotationType => [ at |
				at.name = "DEFINE"
			]
			prop._annotateWith(annotationType)
		]
		outerClass.features += orthogonalStates

		stateVectorProp.references.forEach [ ref |
			val fc = ref.eContainer
			if (fc instanceof FeatureCall) {
				if (fc.feature == _array._length) {
					EcoreUtil.replace(fc, orthogonalStates._ref)
				}
			}
		]
		p
	}

}
