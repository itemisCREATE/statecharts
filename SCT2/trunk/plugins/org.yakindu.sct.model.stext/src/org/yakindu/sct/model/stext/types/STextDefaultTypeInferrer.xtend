/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.sct.model.stext.types

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.core.runtime.IStatus
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.inferrer.DefaultExpressionsTypeInferrer
import org.yakindu.base.types.Event
import org.yakindu.base.types.Feature
import org.yakindu.base.types.ITypeSystem
import org.yakindu.base.types.InferenceIssue
import org.yakindu.base.types.InferenceResult
import org.yakindu.base.types.InferredType
import org.yakindu.base.types.Type
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.types.ITypeSystem.BinaryOperators
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.TypedElement
import java.lang.reflect.ParameterizedType

/**
 * 
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Complete revision of API
 *  
 */
 @Singleton
class STextDefaultTypeInferrer extends DefaultExpressionsTypeInferrer implements ISTextTypeInferrer {
	
	@Inject protected extension
	ITypeSystem ts
	
	
	
	override inferType(VariableDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("Definition may not be null")
		}
		else{
			definition.doInferType
		}
	}
	
	override inferType(EventDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("Definition may not be null")
		}
		else{
			definition.doInferType
		}
	}
	
	def dispatch InferenceResult doInferType(VariableDefinition definition) {
		if(definition.type == null) {
 				return new InferenceResult(null, new InferenceIssue("Could not infer type of variable: " + definition.name, IStatus::ERROR))
 		}
 		else{
 			var varType = new InferenceResult(new InferredType(definition.type))
 			if(definition.initialValue != null){
 				val valueType = definition.initialValue.doInferType
 				if(valueType.type == null){
					return valueType
 				}
 			
 				// reuse the assignment logic of the type system
 				val result = inferResult(varType, valueType, BinaryOperators.ASSIGN)
 				if(result.type == null){
 					return new InferenceResult(null, new InferenceIssue("Cannot assign a value of type " + valueType.type.type.name + " to a variable of type " + varType.type.type.name + ".", IStatus::ERROR))
 				}	
 			}
 			return varType
 		}
	}

	def dispatch InferenceResult doInferType(EventDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("EventDefinition may not be null")
		}
		if(definition.type == null){
			return new InferenceResult(new InferredType(voidType))
		}
		return new InferenceResult(new InferredType(definition.type))
	}

	def dispatch InferenceResult doInferType(OperationDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("EventDefinition may not be null")
		}
		if(definition.type == null){
			return new InferenceResult(new InferredType(voidType))
		}
		return new InferenceResult(new InferredType(definition.type))
	}
	
	def dispatch InferenceResult doInferType(Type type) {
		return new InferenceResult(new InferredType(type))
	}
	
	
	
	def dispatch InferenceResult doInferType(InterfaceScope s){
		// TODO: this could be handled via the type system
		return new InferenceResult(voidType)	
	}
	
	def dispatch InferenceResult doInferType(InternalScope s){
		// TODO: this could be handled via the type system
		return new InferenceResult(voidType)	
	}

	def dispatch InferenceResult doInferType(Expression e) {
		throw new UnsupportedOperationException("Unsupported expression type " + e)
	}
	
	
	
	def dispatch InferenceResult doInferType(AssignmentExpression expression){
		return inferResult(expression.varRef.doInferType, expression.expression.doInferType, getTypeSystemOperator(expression.operator))
	}
	
	def dispatch InferenceResult doInferType(EventRaisingExpression eventRaising){
 		val eventType = eventRaising.event.doInferType
 		if(eventType.type == null) {
 			return eventType
 		}
 		else{
 			if(eventRaising.value == null){
 				if(!eventType.type.voidType){
 					return new InferenceResult(null, new InferenceIssue("Need to assign a value to an event of type " + eventType.type.type.name + ".", IStatus::ERROR))
 				}	
 				return eventType
 			}
 			else{
 				val valueType = eventRaising.value.doInferType
 				if(valueType.type == null){
 					return valueType
 				}
 			
 				// reuse the assignment logic of the type system
 				val result = inferResult(eventType, valueType, BinaryOperators.ASSIGN)
 				if(result.type == null){
 					return new InferenceResult(null, new InferenceIssue("Cannot assign a value of type " + valueType.type.type.name + " to an event of type " + eventType.type.type.name + ".", IStatus::ERROR))
 				}
 				else {
 					return result
 				}
 			}
 		}
	}
	
	
	 
	def dispatch InferenceResult doInferType(ActiveStateReferenceExpression expression){
		return new InferenceResult(getBooleanType)
	}

	def dispatch InferenceResult doInferType(ElementReferenceExpression expression){
		if(expression.reference instanceof EventDefinition && !(expression.eContainer instanceof EventRaisingExpression
				|| expression.eContainer instanceof EventValueReferenceExpression)){
			// in case we are not inside an raise or valueOf expression, the event is a shortcut for isRaised(event) and thus, we may return boolean here
			return new InferenceResult(getBooleanType)
		}
		else {
			// inference of the reference type is not context dependent
			return expression.reference.doInferType
		}
	}
	
	def dispatch InferenceResult doInferType(FeatureCall featureCall){
		if(featureCall.feature instanceof Event /*Definition*/ 
			&& !(featureCall.eContainer instanceof EventRaisingExpression) 
			&& !(featureCall.eContainer instanceof EventValueReferenceExpression)
		){
			// e1 is a shortcut for isRaised(e1) and thus we have to return boolean here
			return new InferenceResult(getBooleanType)
		}
		if (featureCall.feature instanceof Feature) {
			val type = (featureCall.feature as Feature).type
			if (type != null) {
				if (type instanceof TypeParameter) {
					var current = featureCall
					while(!(current.owner instanceof ElementReferenceExpression)) current = current.owner as FeatureCall
					var typedElement = ((featureCall.owner as ElementReferenceExpression).reference as TypedElement)
					var index = (typedElement.type as org.yakindu.base.types.ParameterizedType).parameter.indexOf(type)
					var innerType = typedElement.typeArguments.get(index)
					return new InferenceResult(new InferredType(innerType))
				}
				return new InferenceResult(new InferredType(type))
			}
			return new InferenceResult(getVoidType)
		}
		return featureCall.feature.doInferType
	}

	def dispatch InferenceResult doInferType(EventValueReferenceExpression expression) {
		return doInferType(expression.value)
	}

}
