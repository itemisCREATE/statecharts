package org.yakindu.sct.types.generator.c.modifications

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.modification.IModification

class CreateRootTypeParameterModification implements IModification {
	
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionBuilder
	@Inject protected CTypeSystem cts
	
	override modify(Collection<Package> packages) {
		packages.map[eAllContents.toList].flatten.filter(Operation).forEach[modify]
		packages
	}
	
	def protected modify(Operation op) {
		val containerTypes = EcoreUtil2.getAllContainers(op).filter(ComplexType).toList
		val ownContainer = containerTypes.head
		val rootContainer = containerTypes.last
		if(ownContainer !== null) {
			// Create parameter from root container
			val rootParam = typesFactory.createParameter => [
				name = rootContainer.name.toFirstLower
				typeSpecifier = cts.makePointer(_typeSpecifier(rootContainer))
			]
			op.parameters.add(0, rootParam)
			
			// Calculate the chain of instances that lead from the root type to the location of the operation
			val instanceHierarchy = containerTypes.map[instanceInContainer].filterNull.toList
			
			// Get all features of the container type and find their usages in this operation
			val siblingFeatures = ownContainer.features.reject[it === op].toSet
			val usages = op.eAllContents.filter(ArgumentExpression).filter[siblingFeatures.contains(declaration)].toList
			
			// Replace all usages with appropriate feature calls.
			usages.forEach[
				EcoreUtil.replace(it, replaceUsageWithContainerFeatureCall(it, rootParam, instanceHierarchy + #[it.declaration]))
			]
			
		}
	}
	
	def protected FeatureCall replaceUsageWithContainerFeatureCall(ArgumentExpression it, Parameter rootParam, Iterable<Declaration> instances) {
		instances.toList.reverseView.fold(rootParam._ref as Expression, [owner, feature | _fc(owner, feature)]) as FeatureCall
	}
	
	def protected dispatch Declaration declaration(FeatureCall it) {
		feature
	}
	
	def protected dispatch Declaration declaration(ElementReferenceExpression it) {
		if(reference instanceof Declaration) reference as Declaration else null
	}
	
	def protected dispatch Declaration declaration(ArgumentExpression it) {
		null
	}
	
	def protected Declaration instanceInContainer(ComplexType inner) {
		val outer = inner.eContainer
		if(outer instanceof ComplexType) {
			outer.features.filter(Property).findFirst[type === inner]
		}
	}
}