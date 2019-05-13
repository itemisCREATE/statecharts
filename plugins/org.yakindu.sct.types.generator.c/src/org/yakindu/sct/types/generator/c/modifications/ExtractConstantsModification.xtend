package org.yakindu.sct.types.generator.c.modifications

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionsHelper
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.modification.IModification
import org.yakindu.base.expressions.util.ContainmentExtensions

class ExtractConstantsModification implements IModification {
	@Inject protected extension ExpressionsHelper
	@Inject protected extension ContainmentExtensions

	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val constants = p.eAllContents.filter(ComplexType).toList.map[features].flatten.filter(Property).
			filter[isConst].toList
		constants.forEach[extractConstant(p)]

		p
	}

	def protected extractConstant(Property it, Package p) {
		name = getContainmentHierarchy.filterNull.join("_") + "_" + name
		p.eAllContents.filter(FeatureCall).filter[fc|fc.feature === it].toList.forEach [ fc |
			val ref = elementReference
			EcoreUtil.replace(fc, ref)
		]
		simplifyInitialValue
		p.member.add(it)
	}

	def protected simplifyInitialValue(Property it) {
		initialValue.eAllContents.filter(ElementReferenceExpression).toList.forEach [ eref |
			val reference = eref.reference
			if (reference instanceof Property) {
				EcoreUtil.replace(eref, EcoreUtil.copy(reference.initialValue))
			}
		]
	}

}
