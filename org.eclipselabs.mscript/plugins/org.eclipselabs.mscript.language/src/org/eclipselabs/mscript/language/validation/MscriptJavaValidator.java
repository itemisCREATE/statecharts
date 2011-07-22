package org.eclipselabs.mscript.language.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.AnyValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.InvalidValue;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.AdditiveStepExpression;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.ArraySubscript;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.BuiltinFunction;
import org.eclipselabs.mscript.language.ast.BuiltinVariable;
import org.eclipselabs.mscript.language.ast.CallableElement;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.FunctionCall;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration;
import org.eclipselabs.mscript.language.ast.InputParameterDeclaration;
import org.eclipselabs.mscript.language.ast.IterationAccumulator;
import org.eclipselabs.mscript.language.ast.IterationVariable;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart;
import org.eclipselabs.mscript.language.ast.NegateStepExpression;
import org.eclipselabs.mscript.language.ast.OutputParameterDeclaration;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.ast.StepN;
import org.eclipselabs.mscript.language.ast.TemplateParameterDeclaration;
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.construct.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.construct.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.internal.util.EObjectTreeIterator;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;
import org.eclipselabs.mscript.language.interpreter.StaticEvaluationContext;
import org.eclipselabs.mscript.language.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.mscript.language.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.AnyDataType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {

	@Check
	public void checkStatelessFunction(FunctionDefinition functionDefinition) {
		if (!functionDefinition.isStateful()) {
			for (StateVariableDeclaration stateVariableDeclaration : functionDefinition.getStateVariableDeclarations()) {
				error("The state variable " + stateVariableDeclaration.getName() + " can only be declared in a stateful function", stateVariableDeclaration, null, -1);
			}
		}
	}

	@Check
	public void checkFunctionHasChecks(FunctionDefinition functionDefinition) {
		if (functionDefinition.getChecks().isEmpty()) {
			warning("No static type checking can be performed for function " + functionDefinition.getName() + " since no checks have been defined", functionDefinition, AstPackage.eINSTANCE.getDefinition_Name(), -1);
		}
	}
	
	@Check
	public void checkVariableAccessReferencesVariable(VariableAccess variableAccess) {
		CallableElement ce = variableAccess.getFeature();
		if (!(ce instanceof ParameterDeclaration
				|| ce instanceof StateVariableDeclaration
				|| ce instanceof LetExpressionVariableDeclarationPart
				|| ce instanceof IterationVariable
				|| ce instanceof IterationAccumulator
				|| ce instanceof BuiltinVariable)) {
			error("Invalid variable reference " + variableAccess.getFeature().getName(), null);
		}
	}

	@Check
	public void checkVariableAccessStepExpressionApplication(VariableAccess variableAccess) {
		if (variableAccess.getStepExpression() != null) {
			CallableElement ce = variableAccess.getFeature();
			if (!(ce instanceof InputParameterDeclaration
					|| ce instanceof OutputParameterDeclaration
					|| ce instanceof StateVariableDeclaration)) {
				error("Step expression cannot be specified on " + variableAccess.getFeature().getName(), null);
			}
		}
	}

	@Check
	public void checkFunctionCallReferencesVariable(FunctionCall variableAccess) {
		CallableElement ce = variableAccess.getFeature();
		if (!(ce instanceof FunctionDefinition
				|| ce instanceof FunctionObjectDeclaration
				|| ce instanceof BuiltinFunction)) {
			error("Invalid function call " + variableAccess.getFeature().getName(), null);
		}
	}

	@Check
	public void checkBeginExpressionMustBeInsideArraySubscript(BeginExpression beginExpression) {
		if (!isInsideArraySubscript(beginExpression)) {
			error("'begin' may only appear inside array subscripts", null);
		}
	}

	@Check
	public void checkEndExpressionMustBeInsideArraySubscript(EndExpression endExpression) {
		if (!isInsideArraySubscript(endExpression)) {
			error("'end' may only appear inside array subscripts", null);
		}
	}
	
	@Check
	public void checkStepNNotNegated(NegateStepExpression negateStepExpression) {
		if (negateStepExpression.getOperand() instanceof StepN) {
			warning("Negating step n has no effect", null);
		}
	}

	@Check
	public void checkStepNNotNegated(AdditiveStepExpression additiveStepExpression) {
		if (additiveStepExpression.getRightOperand() instanceof StepN && additiveStepExpression.getOperator() == AdditiveOperator.SUBTRACT) {
			warning("Subtracting step n has no effect, use addition instead", null);
		}
	}

	private boolean isInsideArraySubscript(EObject eObject) {
		EObject container = eObject.eContainer();
		
		while (container != null && !(container instanceof ArraySubscript)) {
			container = container.eContainer();
		}
		
		return container instanceof ArraySubscript && ((ArraySubscript) container).eContainer() instanceof ArrayElementAccess;
	}
	
//	@Check
	public void checkFunctionDefinition(FunctionDefinition functionDefinition) {
		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor().construct(functionDefinition);
		
		SyntaxStatus.addAllSyntaxStatusesToDiagnostics(
				functionDescriptorConstructorResult.getStatus(),
				getChain());
		
		FunctionDescriptor functionDescriptor = functionDescriptorConstructorResult.getFunctionDescriptor();
		
		FunctionModelValidator validator = new FunctionModelValidator();
		for (EObjectTreeIterator it = new EObjectTreeIterator(functionDescriptor, true); it.hasNext();) {
			validator.validate(it.next(), getChain(), new HashMap<Object, Object>());
		}

		List<IValue> templateArguments = new ArrayList<IValue>();
		for (int i = 0, n = functionDefinition.getTemplateParameterDeclarations().size(); i < n; ++i) {
			AnyDataType type = TypeSystemFactory.eINSTANCE.createAnyDataType();
			AnyValue value = new AnyValue(new ComputationContext(), type);
			templateArguments.add(value);
		}

		List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
		for (int i = 0, n = functionDefinition.getInputParameterDeclarations().size(); i < n; ++i) {
			AnyDataType type = TypeSystemFactory.eINSTANCE.createAnyDataType();
			inputParameterDataTypes.add(type);
		}

		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer().transform(functionDescriptor, null, templateArguments, inputParameterDataTypes);

		SyntaxStatus.addAllSyntaxStatusesToDiagnostics(
				functionDefinitionTransformerResult.getStatus(),
				getChain());
	}
	
	@Check
	public void checkTypes(FunctionDefinition functionDefinition) {
		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor().construct(functionDefinition);
		
		SyntaxStatus.addAllSyntaxStatusesToDiagnostics(
				functionDescriptorConstructorResult.getStatus(),
				getChain());
		
		FunctionDescriptor functionDescriptor = functionDescriptorConstructorResult.getFunctionDescriptor();
		
		FunctionModelValidator validator = new FunctionModelValidator();
		for (EObjectTreeIterator it = new EObjectTreeIterator(functionDescriptor, true); it.hasNext();) {
			validator.validate(it.next(), getChain(), new HashMap<Object, Object>());
		}

		StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
		for (org.eclipselabs.mscript.language.ast.Check check : functionDefinition.getChecks()) {
			if (!checkFunctionCheckSignatures(check)) {
				continue;
			}
				
			IStaticEvaluationContext context = new StaticEvaluationContext();

			Iterator<TemplateParameterDeclaration> templateParameterIt = functionDefinition.getTemplateParameterDeclarations().iterator();
			for (Expression argument : check.getTemplateArguments()) {
				staticExpressionEvaluator.evaluate(context, argument);
				context.setValue(templateParameterIt.next(), context.getValue(argument));
			}
			
			Iterator<InputParameterDeclaration> inputParameterIt = functionDefinition.getInputParameterDeclarations().iterator();
			for (DataTypeSpecifier dataTypeSpecifier : check.getInputParameterTypes()) {
				context.setValue(inputParameterIt.next(), new AnyValue(new ComputationContext(), dataTypeSpecifier.getType()));
			}

			IStatus status = new StaticFunctionEvaluator().evaluate(context, functionDescriptor);
			
			if (status.isOK()) {
				Iterator<OutputParameterDeclaration> outputParameterIt = functionDefinition.getOutputParameterDeclarations().iterator();
				for (DataTypeSpecifier dataTypeSpecifier : check.getOutputParameterTypes()) {
					IValue value = context.getValue(outputParameterIt.next());
					if (!(value instanceof InvalidValue) && !dataTypeSpecifier.getType().isEquivalentTo(value.getDataType())) {
						error("Check does not return specified data type", dataTypeSpecifier, null, -1);
					}
				}
			}
			
			SyntaxStatus.addAllSyntaxStatusesToDiagnostics(status, getChain());
		}
		
	}

	private boolean checkFunctionCheckSignatures(org.eclipselabs.mscript.language.ast.Check check) {
		boolean result = true;
		if (check.getTemplateArguments().size() != check.getFunction().getTemplateParameterDeclarations().size()) {
			error("Number of template arguments do not correspond to number of template parameters of function " + check.getFunction().getName(), check, null, -1);
			result = false;
		}
		if (check.getInputParameterTypes().size() != check.getFunction().getInputParameterDeclarations().size()) {
			error("Number of input argument types do not correspond to number of input parameters of function " + check.getFunction().getName(), check, null, -1);
			result = false;
		}
		if (check.getOutputParameterTypes().size() != check.getFunction().getOutputParameterDeclarations().size()) {
			error("Number of output argument types do not correspond to number of output parameters of function " + check.getFunction().getName(), check, null, -1);
			result = false;
		}
		return result;
	}
	
}
