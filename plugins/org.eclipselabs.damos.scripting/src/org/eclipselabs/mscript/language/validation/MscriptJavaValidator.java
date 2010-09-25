package org.eclipselabs.mscript.language.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.mscript.language.ast.ArrayReference;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Subscript;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;
import org.eclipselabs.mscript.language.validation.AbstractMscriptJavaValidator;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {

	private static final Set<String> RESERVED_BUILTIN_FUNCTIONS = new HashSet<String>();
	
	{
		// Numeric Functions and Conversion Functions
		RESERVED_BUILTIN_FUNCTIONS.add("abs");
		RESERVED_BUILTIN_FUNCTIONS.add("sign");
		RESERVED_BUILTIN_FUNCTIONS.add("sqrt");
		RESERVED_BUILTIN_FUNCTIONS.add("Integer");
		RESERVED_BUILTIN_FUNCTIONS.add("String");
		
		// Event Triggering Mathematical Functions
		RESERVED_BUILTIN_FUNCTIONS.add("div");
		RESERVED_BUILTIN_FUNCTIONS.add("mod");
		RESERVED_BUILTIN_FUNCTIONS.add("rem");
		RESERVED_BUILTIN_FUNCTIONS.add("ceil");
		RESERVED_BUILTIN_FUNCTIONS.add("floor");
		RESERVED_BUILTIN_FUNCTIONS.add("integer");
		
		// Built-in Mathematical Functions and External Built-in Functions
		RESERVED_BUILTIN_FUNCTIONS.add("sin");
		RESERVED_BUILTIN_FUNCTIONS.add("cos");
		RESERVED_BUILTIN_FUNCTIONS.add("tan");
		RESERVED_BUILTIN_FUNCTIONS.add("asin");
		RESERVED_BUILTIN_FUNCTIONS.add("acos");
		RESERVED_BUILTIN_FUNCTIONS.add("atan");
		RESERVED_BUILTIN_FUNCTIONS.add("atan2");
		RESERVED_BUILTIN_FUNCTIONS.add("sinh");
		RESERVED_BUILTIN_FUNCTIONS.add("cosh");
		RESERVED_BUILTIN_FUNCTIONS.add("tanh");
		RESERVED_BUILTIN_FUNCTIONS.add("exp");
		RESERVED_BUILTIN_FUNCTIONS.add("log");
		RESERVED_BUILTIN_FUNCTIONS.add("log10");
		
		// Derivative and Special Purpose Operators with Function Syntax
		RESERVED_BUILTIN_FUNCTIONS.add("der");
		RESERVED_BUILTIN_FUNCTIONS.add("delay");
		RESERVED_BUILTIN_FUNCTIONS.add("cardinality");
		RESERVED_BUILTIN_FUNCTIONS.add("homotopy");
		RESERVED_BUILTIN_FUNCTIONS.add("semiLinear");
		RESERVED_BUILTIN_FUNCTIONS.add("Subtask.decouple");
		
		// Event-Related Operators with Function Syntax
		RESERVED_BUILTIN_FUNCTIONS.add("initial");
		RESERVED_BUILTIN_FUNCTIONS.add("terminal");
		RESERVED_BUILTIN_FUNCTIONS.add("noEvent");
		RESERVED_BUILTIN_FUNCTIONS.add("smooth");
		RESERVED_BUILTIN_FUNCTIONS.add("sample");
		RESERVED_BUILTIN_FUNCTIONS.add("pre");
		RESERVED_BUILTIN_FUNCTIONS.add("edge");
		RESERVED_BUILTIN_FUNCTIONS.add("change");
		RESERVED_BUILTIN_FUNCTIONS.add("reinit");
	}
	
//	@Check
//	public void checkReservedBuiltinFunctionCallMustNotBeUsed(SymbolReference functionCall) {
//		String name = "";
//		if (functionCall instanceof NamedFunctionCall) {
//			NamedFunctionCall namedFunctionCall = (NamedFunctionCall) functionCall;
//			List<String> identifiers = namedFunctionCall.getName().getIdentifiers();
//			if (identifiers.size() == 1) {
//				name = identifiers.get(0);
//			} else if (identifiers.size() > 1) {
//				StringBuilder sb = new StringBuilder();
//				for (String identifier : identifiers) {
//					if (sb.length() > 0) {
//						sb.append(".");
//					}
//					sb.append(identifier);
//				}
//				name = sb.toString();
//			}
//		} else if (functionCall instanceof KeywordFunctionCall) {
//			name = ((KeywordFunctionCall) functionCall).getName();
//		}
//		if (RESERVED_BUILTIN_FUNCTIONS.contains(name)) {
//			error("Reserved operator '" + name + "()' must not be used", AstPackage.KEYWORD_FUNCTION_CALL);
//		}
//	}

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
		
		return container instanceof Subscript && ((Subscript) container).eContainer() instanceof ArrayReference;
	}

//	@Check
//	public void checkParenthesizedExpressionMustContainZeroOrOneExpression(ParenthesizedExpression parenthesizedExpression) {
//		if (parenthesizedExpression.getExpressionList().getExpressions().size() > 1) {
//			error("Parenthesized expression must not contain more than one expression", AstPackage.PARENTHESIZED_EXPRESSION);
//		}
//	}
	
//	@Check
//	public void checkArrayConstructionOperatorMustNotContainNamedArguments(ArrayConstructionOperator arrayConstructionOperator) {
//		if (!arrayConstructionOperator.getArgumentList().getNamedArguments().isEmpty()) {
//			error("Array construction operator must not contain named arguments", AstPackage.ARRAY_CONSTRUCTION_OPERATOR__ARGUMENT_LIST);
//		}
//	}

	@Check
	public void checkUnitExpressionNumeratorMustConsistOfSymbolsOrOne(UnitExpressionNumerator numerator) {
		if (numerator.getFactors().isEmpty() && numerator.getOne() != 1) {
			error("Invalid unit numerator", AstPackage.UNIT_EXPRESSION_NUMERATOR__ONE);
		}
	}
	
//	@Check
//	public void checkUnitExpressionFactorIsValid(UnitExpressionFactor factor) {
//		try {
//			new UnitNormalizer().normalize(factor, factor.eContainer() instanceof UnitExpressionDenominator, null);
//		} catch (InvalidUnitExpressionOperandException e) {
//			error("Invalid unit operand '" + factor.getOperand()+ "'", AstPackage.UNIT_EXPRESSION_FACTOR__OPERAND);
//		}
//	}

}
