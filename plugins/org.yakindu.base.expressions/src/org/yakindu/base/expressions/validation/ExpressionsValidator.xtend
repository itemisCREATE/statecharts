/** 
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.base.expressions.validation

import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.validation.ComposedChecks
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsPackage
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.Annotation
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesPackage
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.validation.IValidationIssueAcceptor
import org.yakindu.base.types.validation.TypesJavaValidator
import org.yakindu.base.expressions.expressions.EventRaisingExpression
import org.yakindu.base.types.Event
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.util.ExpressionExtensions

/** 
 * @author andreas muelder - Initial contribution and API
 */
@ComposedChecks(validators=#[TypesJavaValidator])
class ExpressionsValidator extends AbstractExpressionsValidator implements IValidationIssueAcceptor {

	@Inject ITypeSystemInferrer typeInferrer
	@Inject extension ExpressionExtensions

	override void accept(ValidationIssue issue) {
		switch (issue.getSeverity()) {
			case ERROR: {
				error(issue.getMessage(), null, issue.getIssueCode())
			}
			case WARNING: {
				warning(issue.getMessage(), null, issue.getIssueCode())
			}
			case INFO: {
			}
		}
	}

	@Check
	def void checkExpression(Expression expression) {
		// Only infer root expressions since inferType infers the expression
		// containment hierarchy
		if(!(expression.eContainer() instanceof Expression)) typeInferrer.infer(expression, this)
	}

	public static final String POSTFIX_ONLY_ON_VARIABLES_CODE = "PostfixOnlyOnVariables"
	public static final String POSTFIX_ONLY_ON_VARIABLES_MSG = "Invalid argument to operator '++/--'"

	@Check
	def void checkPostFixOperatorOnlyOnVariables(PostFixUnaryExpression expression) {
		if (!(expression.getOperand() instanceof ElementReferenceExpression) &&
			!(expression.getOperand() instanceof FeatureCall)) {
			error(POSTFIX_ONLY_ON_VARIABLES_MSG, expression, null, POSTFIX_ONLY_ON_VARIABLES_CODE)
		}
	}

	public static final String ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_CODE = "ErrorDuplicateParameterAssignment"
	public static final String ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_MSG = "Duplicate assignment to parameter '%s'."

	@Check
	def void checkDuplicateParameterAssignment(ArgumentExpression exp) {
		var Set<Parameter> assignedParameters = new HashSet()
		var EList<Argument> arguments = exp.getArguments()
		for (Argument argument : arguments) {
			if (argument.getParameter() !== null) {
				if (assignedParameters.contains(argument.getParameter())) {
					error(String.format(ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_MSG, argument.getParameter().getName()),
						argument, null, ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_CODE)
				}
				assignedParameters.add(argument.getParameter())
			}
		}
	}

	public static final String ERROR_ASSIGNMENT_TO_CONST_CODE = "AssignmentToConst"
	public static final String ERROR_ASSIGNMENT_TO_CONST_MSG = "Assignment to constant not allowed."

	@Check(CheckType.FAST)
	def void checkAssignmentToFinalVariable(AssignmentExpression exp) {
		var Expression varRef = exp.getVarRef()
		var EObject referencedObject = null
		if (varRef instanceof FeatureCall)
			referencedObject = varRef.getFeature()
		else if (varRef instanceof ElementReferenceExpression)
			referencedObject = varRef.getReference()
		if (referencedObject instanceof Property) {
			if (referencedObject.isConst()) {
				error(ERROR_ASSIGNMENT_TO_CONST_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
					ERROR_ASSIGNMENT_TO_CONST_CODE)
			}
		}
	}

	public static final String ERROR_POST_FIX_TO_CONST_CODE = "PostFixToConst"
	public static final String ERROR_POST_FIX_TO_CONST_MSG = "Increment or decrement to constant not allowed."

	@Check(CheckType.FAST)
	def void checkPostFixUnaryExpressionToFinalVariable(PostFixUnaryExpression exp) {
		var Expression operand = exp.getOperand()
		if (operand instanceof ElementReferenceExpression) {
			var EObject reference = operand.getReference()
			if (reference instanceof Property && ((reference as Property)).isConst()) {
				error(ERROR_POST_FIX_TO_CONST_MSG, exp, null, ERROR_POST_FIX_TO_CONST_CODE)
			}
		}
	}

	public static final String ERROR_LEFT_HAND_ASSIGNMENT_CODE = "LeftHandAssignment"
	public static final String ERROR_LEFT_HAND_ASSIGNMENT_MSG = "The left-hand side of an assignment must be a variable."

	@Check(CheckType.FAST)
	def void checkLeftHandAssignment(AssignmentExpression expression) {
		var Expression varRef = expression.getVarRef()
		if (varRef instanceof FeatureCall) {
			var EObject referencedObject = varRef.getFeature()
			if (!(referencedObject instanceof Property)) {
				error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
					ERROR_LEFT_HAND_ASSIGNMENT_CODE)
			}
		} else if (varRef instanceof ElementReferenceExpression) {
			var EObject referencedObject = varRef.getReference()
			if (!(referencedObject instanceof Property) && !(referencedObject instanceof Parameter)) {
				error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
					ERROR_LEFT_HAND_ASSIGNMENT_CODE)
			}
		} else {
			error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
				ERROR_LEFT_HAND_ASSIGNMENT_CODE)
		}
	}

	@Check(CheckType.FAST)
	def void checkOperationArguments_FeatureCall(FeatureCall call) {
		if (call.getFeature() instanceof Operation) {
			var Operation operation = (call.getFeature() as Operation)
			assertOperationArguments(operation, call.getExpressions())
		}
	}

	@Check(CheckType.FAST)
	def void checkOperationArguments_TypedElementReferenceExpression(ElementReferenceExpression call) {
		if (call.getReference() instanceof Operation) {
			var Operation operation = (call.getReference() as Operation)
			assertOperationArguments(operation, call.getExpressions())
		}
	}

	public static final String ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE = "WrongNrOfArgs"
	public static final String ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG = "Wrong number of arguments, expected %s ."

	def protected void assertOperationArguments(Operation operation, List<Expression> args) {
		var EList<Parameter> parameters = operation.getParameters()
		var List<Parameter> optionalParameters = filterOptionalParameters(parameters)
		if ((operation.isVariadic() && operation.getVarArgIndex() > args.size()) || (!operation.isVariadic() &&
			!(args.size() <= parameters.size() && args.size() >= parameters.size() - optionalParameters.size()))) {
			error(String.format(ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG, parameters), null,
				ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE)
		}
	}

	def protected List<Parameter> filterOptionalParameters(EList<Parameter> parameters) {
		var List<Parameter> optionalParameters = new ArrayList()
		for (Parameter p : parameters) {
			if (p.isOptional()) {
				optionalParameters.add(p)
			}
		}
		return optionalParameters
	}

	public static final String ERROR_WRONG_ANNOTATION_TARGET_CODE = "WrongAnnotationTarget"
	public static final String ERROR_WRONG_ANNOTATION_TARGET_MSG = "Annotation '%s' can not be applied on '%s' ."

	@Check(CheckType.FAST)
	def void checkAnnotationTarget(AnnotatableElement element) {
		//Guard for AnnotableElement#getAnnotationInfo container
		if(element.eClass == TypesPackage.Literals.ANNOTATABLE_ELEMENT)
			return
		var EList<Annotation> annotations = element.getAnnotations()
		for (Annotation annotation : annotations) {
			var EList<EObject> targets = annotation.getType().getTargets()
			if (!targets.empty) {
				var boolean found = Iterables.any(
					targets, [EObject input|return ((input as EClass)).isInstance(element)])
				if (!found) {
					error(
						String.format(ERROR_WRONG_ANNOTATION_TARGET_MSG, annotation.getType().getName(),
							element.eClass().name), null, element.getAnnotations().indexOf(annotation),
						ERROR_WRONG_ANNOTATION_TARGET_CODE)
				}
			}
		}
	}

	public static final String CONST_MUST_HAVE_VALUE_MSG = "A constant definition must specify an initial value."
	public static final String CONST_MUST_HAVE_VALUE_CODE = "ConstMustHaveAValue"
	public static final String REFERENCE_TO_VARIABLE = "Cannot reference a variable in a constant initialization."

	@Check(CheckType.FAST)
	def void checkValueDefinitionExpression(Property property) {
		// applies only to constants
		if(!property.isConst()) return;
		var Expression initialValue = property.getInitialValue()
		if (initialValue === null) {
			error(CONST_MUST_HAVE_VALUE_MSG, property, null, CONST_MUST_HAVE_VALUE_CODE)
			return;
		}
		var List<Expression> toCheck = Lists.newArrayList(initialValue)
		var TreeIterator<EObject> eAllContents = initialValue.eAllContents()
		while (eAllContents.hasNext()) {
			var EObject next = eAllContents.next()
			if(next instanceof Expression) toCheck.add(next)
		}
		for (Expression expression : toCheck) {
			var EObject referencedObject = null
			if (expression instanceof FeatureCall)
				referencedObject = expression.getFeature()
			else if (expression instanceof ElementReferenceExpression)
				referencedObject = expression.getReference()
			if (referencedObject instanceof Property) {
				if (!referencedObject.isConst()) {
					error(REFERENCE_TO_VARIABLE, TypesPackage.Literals.PROPERTY__INITIAL_VALUE)
				}
			}
		}
	}

	public static final String DECLARATION_WITH_READONLY = "The keyword '%s' has no effect for '%s' definitions. Can be removed."

	@Check(CheckType.FAST)
	def void checkConstAndReadOnlyDefinitionExpression(Property definition) {
		// applies only for readonly const definitions
		if(!definition.isReadonly() && !definition.isConst()) return;
		var ICompositeNode definitionNode = NodeModelUtils.getNode(definition)
		var String tokenText = NodeModelUtils.getTokenText(definitionNode)
		if(tokenText === null || tokenText.isEmpty()) return;
		if (tokenText.contains(TypesPackage.Literals.PROPERTY__READONLY.getName()) &&
			tokenText.contains(TypesPackage.Literals.PROPERTY__CONST.getName())) {
			warning(
				String.format(DECLARATION_WITH_READONLY, TypesPackage.Literals.PROPERTY__READONLY.getName(),
					TypesPackage.Literals.PROPERTY__CONST.getName()), definition,
				TypesPackage.Literals.PROPERTY__READONLY)
		}
	}

	@Check(CheckType.FAST)
	def void checkAnnotationArguments(Annotation annotation) {
		if (annotation.getType() !== null &&
			annotation.getArguments().size() !== annotation.getType().getProperties().size()) {
			error(String.format(ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG, annotation.getType().getProperties()), null,
				ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE)
		}
	}
	
	@Check(CheckType.FAST)
	def void checkRaisingExpressionEvent(EventRaisingExpression expression) {
		var EObject element = expression.event.featureOrReference
		if (element !== null && (!(element instanceof Event))) {
			var String elementName = ""
			if (element instanceof NamedElement) {
				elementName = element.getName()
			}
			error(String.format("'%s' is not an event.", elementName),
				ExpressionsPackage.Literals.EVENT_RAISING_EXPRESSION__EVENT, -1)
		}
	}
}
