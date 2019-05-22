package org.yakindu.sct.types.generator.cpp.modifications

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

class RemoveInitialValuesModification implements IModification {
	
	@Inject protected extension CoreCGeneratorAnnotationLibrary
	@Inject protected ITypeSystem ts
	@Inject protected extension TypeBuilder
	
	override modify(Collection<Package> packages) {
		packages.map[eAllContents.toList].flatten.filter(ComplexType).forEach[modify]
		packages
	}
	
	def protected modify(ComplexType it) {
		features.filter(Property).filter[!(isStatic && isConst)].forEach[
			if(ts.isSame(type, ts.getType(ITypeSystem.ARRAY))) {
				val arraySizeExpression = (initialValue as FeatureCall).arguments.head.value
				if(arraySizeExpression instanceof PrimitiveValueExpression) {
					val literal = arraySizeExpression.value
					if(literal instanceof IntLiteral) {
						arraySize = literal.value
					}
				}
			}
			initialValue = null
		]
	}
	
}