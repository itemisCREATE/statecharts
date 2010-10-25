package org.eclipselabs.mscript.language.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.mscript.language.ast.ArrayElementReference;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.Subscript;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;
import org.eclipselabs.mscript.language.interpreter.FunctorConstructor;
import org.eclipselabs.mscript.language.interpreter.IFunctor;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.Interpreter;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.value.AnyValue;
import org.eclipselabs.mscript.language.interpreter.value.INumericValue;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.IValueFactory;
import org.eclipselabs.mscript.language.interpreter.value.ValueFactory;
import org.eclipselabs.mscript.typesystem.RealType;
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
		
		while (container != null && !(container instanceof Subscript)) {
			container = container.eContainer();
		}
		
		return container instanceof Subscript && ((Subscript) container).eContainer() instanceof ArrayElementReference;
	}

	@Check
	public void checkUnitExpressionNumeratorMustConsistOfSymbolsOrOne(UnitExpressionNumerator numerator) {
		if (numerator.getFactors().isEmpty() && numerator.getOne() != 1) {
			error("Invalid unit numerator", AstPackage.UNIT_EXPRESSION_NUMERATOR__ONE);
		}
	}
	
	@Check
	public void checkFunctionDefinition(FunctionDefinition functionDefinition) {
		IValueFactory valueFactory = new ValueFactory();
		IInterpreterContext context = new InterpreterContext(getChain(), valueFactory, true);
		List<IValue> templateArguments = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameters()) {
			// TODO: should be AnyType instead of RealType
			RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
			realType.setUnit(TypeSystemUtil.createUnit());
			templateArguments.add(new AnyValue(realType));
		}
		IFunctor functor = new FunctorConstructor().construct(context, functionDefinition, templateArguments);

		List<IValue> inputValues = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameters()) {
			RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
			realType.setUnit(TypeSystemUtil.createUnit());
			inputValues.add(valueFactory.createRealValue(realType, 7));
		}
		for (int i = 0; i < 10; ++i) {
			System.out.print(functionDefinition.getName() + ": ");
			List<IValue> outputValues = new Interpreter().execute(context, functor, inputValues);
			for (IValue value : outputValues) {
				if (value instanceof INumericValue) {
					INumericValue numericValue = (INumericValue) value;
					System.out.print(numericValue.doubleValue() + ", ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
