package org.eclipselabs.mscript.language.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.AnyValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.ArraySubscript;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.internal.util.EObjectTreeIterator;
import org.eclipselabs.mscript.language.util.SyntaxStatus;
import org.eclipselabs.mscript.typesystem.AnyDataType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {

	@Check
	public void checkStatelessFunctionDefinition(FunctionDefinition functionDefinition) {
		if (!functionDefinition.isStateful()) {
			for (StateVariableDeclaration stateVariableDeclaration : functionDefinition.getStateVariableDeclarations()) {
				error("Stateless functions must not declare state variables", stateVariableDeclaration, null);
			}
		}
	}

	@Check
	public void checkBeginExpressionMustBeInsideArraySubscript(BeginExpression beginExpression) {
		if (!isInsideArraySubscript(beginExpression)) {
			error("'begin' may only appear inside array subscripts", AstPackage.BEGIN_EXPRESSION);
		}
	}

	@Check
	public void checkEndExpressionMustBeInsideArraySubscript(EndExpression endExpression) {
		if (!isInsideArraySubscript(endExpression)) {
			error("'end' may only appear inside array subscripts", AstPackage.END_EXPRESSION);
		}
	}
	
	private boolean isInsideArraySubscript(EObject eObject) {
		EObject container = eObject.eContainer();
		
		while (container != null && !(container instanceof ArraySubscript)) {
			container = container.eContainer();
		}
		
		return container instanceof ArraySubscript && ((ArraySubscript) container).eContainer() instanceof ArrayElementAccess;
	}

	@Check
	public void checkUnitExpressionNumeratorMustConsistOfSymbolsOrOne(UnitExpressionNumerator numerator) {
		if (numerator.getFactors().isEmpty() && numerator.getOne() != 1) {
			error("Invalid unit numerator", AstPackage.UNIT_EXPRESSION_NUMERATOR__ONE);
		}
	}
	
	@Check
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
	
}
