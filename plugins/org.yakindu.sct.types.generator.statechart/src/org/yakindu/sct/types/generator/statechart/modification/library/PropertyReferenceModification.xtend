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
package org.yakindu.sct.types.generator.statechart.modification.library

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.util.ContainmentExtensions
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.modification.library.ReferenceExtension
import org.yakindu.sct.types.generator.statechart.annotation.SCTGeneratorAnnotationLibrary
import org.yakindu.sct.types.modification.IModification

/**
 * Transforms references to public properties by their respective getters or setters.
 * 
 * Needs PropertyAccessModification to be called beforehand.
 * 
 */
class PropertyReferenceModification implements IModification {
	
	@Inject
	protected extension PropertyAccessModification
	
	@Inject
	protected extension PackageNavigationExtensions
	
	@Inject
	protected extension ExpressionBuilder
	
	@Inject
	protected extension ReferenceExtension
	
	@Inject
	protected extension ContainmentExtensions
	
	@Inject
	protected extension ExpressionExtensions
	
	@Inject protected extension SCTGeneratorAnnotationLibrary

	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		val interfaceTypes = p.allComplexTypes.filter[isInterfaceGroup]
		interfaceTypes.forEach[ iface |
			iface.eAllContents.filter(Property).filter[!const].forEach [ prop |
				prop.references.forEach[toWriteAccess(it, prop)]
				prop.references.forEach[toReadAccess(it, prop)]
			]
		]
		return p
	}
	
	protected def dispatch toReadAccess(EObject reference, Property prop) {
		throw new IllegalStateException("Could not transform reference to read access: " + reference)
	}

	protected def dispatch toReadAccess(FeatureCall reference, Property prop) {
		if (!reference.containedIn(prop.readAccess) && !reference.containedIn(prop.writeAccess)) {
			
			if (!(reference.eContainer instanceof PostFixUnaryExpression)) {
				EcoreUtil.replace(reference, reference.owner._fc(prop.readAccess))
			}
		}
	}

	protected def dispatch toReadAccess(ElementReferenceExpression reference, Property prop) {
		if (!reference.containedIn(prop.readAccess) && !reference.containedIn(prop.writeAccess) && !reference.containedIn(prop.assign)) {
			
			if (!(reference.eContainer instanceof PostFixUnaryExpression)) {
				EcoreUtil.replace(reference, prop.readAccess._call)
			}
		}
	}

	protected def dispatch toWriteAccess(EObject reference, Property prop) {
		throw new IllegalStateException("Could not transform reference to write access: " + reference)
	}

	protected def dispatch toWriteAccess(FeatureCall reference, Property prop) {
		if (reference.eContainer instanceof AssignmentExpression) {
			val assignment = reference.eContainer as AssignmentExpression
			if (assignment.varRef == reference) {
				if (!reference.containedIn(prop.writeAccess) && !reference.containedIn(prop.assign)) {
					val method = getWriteMethod(prop, assignment)
					
					switch(assignment.operator) {
						case ADD_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._plus(EcoreUtil.copy(assignment.expression))))
						case SUB_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._minus(EcoreUtil.copy(assignment.expression))))
						case DIV_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._divide(EcoreUtil.copy(assignment.expression))))
						case MULT_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._multiply(EcoreUtil.copy(assignment.expression))))
						case OR_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._bitwiseOr(EcoreUtil.copy(assignment.expression))))
						case AND_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._bitwiseAnd(EcoreUtil.copy(assignment.expression))))
						case XOR_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._bitwiseXor(EcoreUtil.copy(assignment.expression))))
						case LEFT_SHIFT_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._leftShift(EcoreUtil.copy(assignment.expression))))
						case RIGHT_SHIFT_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._rightShift(EcoreUtil.copy(assignment.expression))))
						case MOD_ASSIGN:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, reference.owner.featureOrReference._ref._fc(prop.readAccess)._mod(EcoreUtil.copy(assignment.expression))))
						default:
							EcoreUtil.replace(assignment,
								reference.owner._fc(method, EcoreUtil.copy(assignment.expression)))
						
					}
					
				}
			}
		}
	}

	protected def dispatch toWriteAccess(ElementReferenceExpression reference, Property prop) {
		if (reference.eContainer instanceof AssignmentExpression) {
			val assignment = reference.eContainer as AssignmentExpression
			if (assignment.varRef == reference) {
				if (!reference.containedIn(prop.writeAccess) && !reference.containedIn(prop.assign)) {
					val method = getWriteMethod(prop, assignment)
					
					switch(assignment.operator) {
						case ADD_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._plus(EcoreUtil.copy(assignment.expression))))
						case SUB_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._minus(EcoreUtil.copy(assignment.expression))))
						case DIV_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._divide(EcoreUtil.copy(assignment.expression))))
						case MULT_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._multiply(EcoreUtil.copy(assignment.expression))))
						case OR_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._bitwiseOr(EcoreUtil.copy(assignment.expression))))
						case AND_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._bitwiseAnd(EcoreUtil.copy(assignment.expression))))
						case XOR_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._bitwiseXor(EcoreUtil.copy(assignment.expression))))
						case LEFT_SHIFT_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._leftShift(EcoreUtil.copy(assignment.expression))))
						case RIGHT_SHIFT_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._rightShift(EcoreUtil.copy(assignment.expression))))
						case MOD_ASSIGN:
							EcoreUtil.replace(assignment, method._call(prop.readAccess._call._mod(EcoreUtil.copy(assignment.expression))))
						default:
							EcoreUtil.replace(assignment, method._call(EcoreUtil.copy(assignment.expression)))
						
					}
				}
			}
		}
	}
	
	protected def getWriteMethod(Property prop, AssignmentExpression assignment) {
		if (assignment.needsAssignMethod) prop.assign else prop.writeAccess
	}
	

}
