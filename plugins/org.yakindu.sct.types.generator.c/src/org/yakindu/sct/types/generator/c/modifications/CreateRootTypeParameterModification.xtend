package org.yakindu.sct.types.generator.c.modifications

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
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
	protected ExpressionsFactory expFactory = ExpressionsFactory.eINSTANCE
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionBuilder
	@Inject protected CTypeSystem cts
	
	override modify(Collection<Package> packages) {
		val ops = packages.map[eAllContents.toList].flatten.filter(Operation).toList
		ops.forEach[modify]
		ops.forEach[adaptCalls]
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
			
			// Replace all feature usages with appropriate feature calls.
			usages.forEach[
				val aS = arrSel
				val args = arguments
				EcoreUtil.replace(it, 
					replaceUsageWithContainerFeatureCall(it, rootParam, instanceHierarchy.reverseView + #[it.declaration]) => [
						it.arraySelector += aS
						it.arguments += args
					]
				)
			]			
		}
	}
	
	def protected adaptCalls(Operation op) {
		val containerTypes = EcoreUtil2.getAllContainers(op).filter(ComplexType).toList
		val rootContainer = containerTypes.last
		
		// Refactor all calls to use the new parameter introduced in modify
		val opCalls = rootContainer.eAllContents.filter(ArgumentExpression).filter[declaration === op].toList
		opCalls.forEach[ call |
			val context = EcoreUtil2.getContainerOfType(call, Operation)
			if(context instanceof Operation) {
				val contextRootParam = context.parameters.head
				val myRootParam = op.parameters.head
				if(cts.isSame(contextRootParam.type, myRootParam.type) && cts.isSame(cts.pointsTo(contextRootParam).type, cts.pointsTo(myRootParam).type)) {
					call.arguments.add(0 , expFactory.createArgument => [value = contextRootParam._ref])
				}
			}
		] 
	}
	
	def protected FeatureCall replaceUsageWithContainerFeatureCall(ArgumentExpression it, Parameter rootParam, Iterable<Declaration> instances) {
		instances.toList.fold(rootParam._ref as Expression, [owner, feature | _fc(owner, feature)]) as FeatureCall
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
	
	def protected dispatch List<Expression> getArrSel(FeatureCall it) {
		arraySelector
	}
	
	def protected dispatch List<Expression> getArrSel(ElementReferenceExpression it) {
		arraySelector
	}
	
	def protected dispatch List<Expression> getArrSel(ArgumentExpression it) {
		null
	}
	
	def protected Declaration instanceInContainer(ComplexType inner) {
		val outer = inner.eContainer
		if(outer instanceof ComplexType) {
			outer.features.filter(Property).findFirst[type === inner]
		}
	}
}