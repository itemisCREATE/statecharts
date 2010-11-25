package org.eclipselabs.mscript.language.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.ArraySubscript;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionConstructor;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeFunctionTransformer;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {

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
		Function function = new FunctionConstructor().construct(functionDefinition, getChain());
		
		List<DataType> templateParameterDataTypes = new ArrayList<DataType>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
			IntegerType realType = TypeSystemFactory.eINSTANCE.createIntegerType();
			realType.setUnit(TypeSystemUtil.createUnit());
			templateParameterDataTypes.add(realType);
			parameterDeclaration.getName();
		}
		List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
			IntegerType realType = TypeSystemFactory.eINSTANCE.createIntegerType();
			realType.setUnit(TypeSystemUtil.createUnit());
			inputParameterDataTypes.add(realType);
			parameterDeclaration.getName();
		}
		ImperativeFunction imperativeFunction = new ImperativeFunctionTransformer().transform(function, templateParameterDataTypes, inputParameterDataTypes);

		System.out.println("### " + functionDefinition.getName());
		System.out.println("--- Initialize compound:");
		System.out.println(new CompoundCGenerator().doSwitch(imperativeFunction.getInitializationCompound()));
		for (Compound compound : imperativeFunction.getComputationCompounds()) {
			System.out.println("--- Computation compound:");
			System.out.println(new CompoundCGenerator().doSwitch(compound));
		}
		System.out.println();
	}
	
}
