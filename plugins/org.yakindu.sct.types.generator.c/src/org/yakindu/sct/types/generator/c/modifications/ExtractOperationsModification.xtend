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
package org.yakindu.sct.types.generator.c.modifications

import com.google.inject.Inject
import java.util.Collection
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionsHelper
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.types.generator.c.annotation.CoreCGeneratorAnnotationLibrary
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem
import org.yakindu.sct.types.modification.IModification

class ExtractOperationsModification implements IModification {
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension CTypeSystem cts
	@Inject protected extension ExpressionsHelper
	@Inject protected extension ExpressionBuilder
	@Inject protected extension CoreCGeneratorAnnotationLibrary

	protected ExpressionsFactory expFactory = ExpressionsFactory.eINSTANCE
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allOperations.forEach [ op |
			val cT = op.findRootType
			if (cT instanceof ComplexType) {
//				val parentParameter = createParameter(cT, cT.name.toFirstLower)
//				op.parameters.add(0, parentParameter)

				op.replaceFeatureCallWithElementReferenceExpression(p)
				op.renameOperation
				p.member.add(op)
			}
		]
		// add handle to operation calls
//		p.allOperations.forEach [ op |
//			op.eAllContents.filter(ElementReferenceExpression).filter[operationCall].forEach [
//				addArgument(op.parameters.head)
//			]
//		]
		return p
	}
	
	def Type findRootType(Operation it) {
		val containers = EcoreUtil2.getAllContainers(it).filter(ComplexType).toList
		return containers.head.getRootType?:EcoreUtil2.getAllContainers(it).filter(ComplexType).last
		
	}

	def protected addArgument(ElementReferenceExpression expression, Parameter parameter) {
		expression.arguments.add(0, expFactory.createArgument => [ arg |
			arg.value = expFactory.createElementReferenceExpression => [ ele |
				ele.reference = parameter
			]
		])
	}

	def protected renameOperation(Operation op) {
		val ct = op.eContainer
		if (ct instanceof ComplexType) {
			op.name = ct.name + "_" + op.name.toFirstLower // TODO: Can be removed with 4.0. Needed to keep API for OperationDefinitions with Lower/Upper case
		}
	}

	protected def void replaceFeatureCallWithElementReferenceExpression(Operation op, Package p) {
		val container = op.eContainer
		if (container instanceof ComplexType) {
			p.eAllContents.filter(FeatureCall).toList.forEach [ fc |
				if (fc.feature === op) {
					EcoreUtil.replace(fc, expFactory.createElementReferenceExpression => [ ele |
						ele.reference = fc.feature
						ele.arguments += fc.arguments
						ele.arrayAccess = fc.arrayAccess
						ele.arraySelector += fc.arraySelector
						ele.operationCall = fc.operationCall
					])
				} else if (compare(fc.feature, op)) { // TODO: Should work with "==". Is this wrong in sequencer?
					EcoreUtil.replace(fc, expFactory.createElementReferenceExpression => [ ele |
						ele.reference = fc.feature as Operation
						(ele.reference as Operation).name = container.name.toFirstLower + "_" +
							(ele.reference as Operation).name
						ele.reference = fc.feature
						ele.arguments += fc.arguments
						ele.arrayAccess = fc.arrayAccess
						ele.arraySelector += fc.arraySelector
						ele.operationCall = fc.operationCall
					])
				}
			]
		}
	}

	protected def getAllContainers(EObject o) {
		EcoreUtil2.getAllContainers(o).toList
	}

	// TODO: Should work with "==". Is this wrong in sequencer?
	def protected compare(Declaration op1, Operation op2) {
		if (op1 instanceof Operation) {
			if (op1.name == op2.name) {
				val body1 = op1.body
				val body2 = op2.body
				if (body1 instanceof BlockExpression) {
					if (body2 instanceof BlockExpression) {
						if (body1.expressions.length == body2.expressions.length) {
							return true
						}
					}
				}
			}
		}
		return false
	}

	def protected replaceElementReferenceExpressionWithFeatureCall(ElementReferenceExpression exp,
		Parameter parentParameter, EList<Expression> arraySelector) {
		val reference = exp.reference
		val containerType = reference.eContainer
		val rootContainer = EcoreUtil2.getAllContainers(reference).filter(ComplexType).last
		// Use nested if instead of '&&' for automatic type casting
		if (reference instanceof Property) {
			if (containerType instanceof ComplexType) {
				if (isTypeOrPointerOnType(parentParameter, rootContainer)) {
					val containers = getContainerInstances(reference)
					containers.add(reference)
					val fc = containers.fold(parentParameter._ref as Expression, [owner, feature | _fc(owner, feature)]) as FeatureCall
					fc.arrayAccess = !arraySelector.nullOrEmpty
					fc.arraySelector += arraySelector
					EcoreUtil.replace(exp, fc)
				}
			}
		}
	}

	def protected isTypeOrPointerOnType(TypedElement element, Type type) {
		val typeSpecifier = element.typeSpecifier
		if (cts.isSame(typeSpecifier.type, type)) {
			return true
		}
		if (cts.isSame(typeSpecifier.type, cts.getType(CTypeSystem.POINTER))) {
			val pointerTypeSpecifier = typeSpecifier.typeArguments.head
			if (cts.isSame(pointerTypeSpecifier?.type, type)) {
				return true
			}
		}
		return false
	}

	def protected createFeatureCall(EObject owner, Declaration feature) {
		val fc = expFactory.createFeatureCall
		val expr = expFactory.createElementReferenceExpression

		expr.reference = owner
		fc.owner = expr
		fc.feature = feature

		fc
	}

	def protected createParameter(Type type, String name) {
		val param = typesFactory.createParameter
		val ts = typesFactory.createTypeSpecifier => [ ts |
			ts.type = cts.getType(CTypeSystem.POINTER)
			ts.typeArguments += type.typeSpecifier
		]
		param.typeSpecifier = ts
		param.name = name

		param
	}
	
	def protected List<Property> getContainerInstances(Declaration decl) {
		val containers = EcoreUtil2.getAllContainers(decl)
		containers.filter(ComplexType).map[containerInstance].filterNull.toList
	}
	
	def protected Property getContainerInstance(ComplexType cT) {
		val eC = cT.eContainer
		if(eC instanceof ComplexType) {
			eC.features.filter(Property).findFirst[type == cT]
		}
	}
}
