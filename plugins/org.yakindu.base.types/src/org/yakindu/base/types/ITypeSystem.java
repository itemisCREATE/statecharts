/**
 * Copyright (c) 2013 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import java.util.List;

import com.google.inject.ImplementedBy;

/**
 * Generic type system representation, which is responsible of listing the
 * available types ({@link #getTypes()}) and inferring types for certain
 * operations (or feature calls - not yet supported).
 * 
 * @author Alexander Nyßen - Initial contribution and API
 */
@ImplementedBy(DefaultTypeSystem.class)
public interface ITypeSystem {

	public enum UnaryOperators implements ITypeSystemOperator {
		LOGICAL_NOT("!"), POSITIVE("+"), NEGATIVE("-"), COMPLEMENT("~");

		private String symbol;

		UnaryOperators(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	};

	public enum BinaryOperators implements ITypeSystemOperator {
		LOGICAL_OR("||"), LOGICAL_AND("&&"), BITWISE_OR("|"), BITWISE_AND("&"), BITWISE_XOR("^"), SMALLER("<"), SMALLER_EQUAL(
				"<="), GREATER(">"), GREATER_EQUAL(">="), EQUAL("=="), NOT_EQUAL("!="), MULTIPLY("*"), DIV("/"), MOD(
				"%"), ADD("+"), SUBTRACT("-"), LEFT_SHIFT("<<"), RIGHT_SHIFT(">>"), ASSIGN("="), ASSIGN_MULTIPLY("*="), ASSIGN_DIV(
				"/="), ASSIGN_MOD("%="), ASSIGN_ADD("+="), ASSIGN_SUBTRACT("-="), ASSIGN_LEFT_SHIFT("<<="), ASSIGN_RIGHT_SHIFT(
				">>="), ASSIGN_BITWISE_AND("&="), ASSIGN_BITWISE_XOR("^="), ASSIGN_BITWISE_OR("|=");

		private String symbol;

		BinaryOperators(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	};

	public enum TernaryOperators implements ITypeSystemOperator {
		CONDITIONAL("?");

		private String symbol;

		TernaryOperators(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	};

	public interface ITypeSystemOperator {
		public String getSymbol();
	}

	public Type getVoidType();

	public Type getBooleanType();

	public Type getIntegerType();

	public Type getRealType();

	public Type getStringType();
	
	public boolean isVoidType(InferredType inferredType);

	public boolean isBooleanType(InferredType inferredType);

	public boolean isIntegerType(InferredType inferredType);

	public boolean isRealType(InferredType inferredType);

	public boolean isStringType(InferredType inferredType);
	
	public boolean isVoidType(Type type);

	public boolean isBooleanType(Type type);

	public boolean isIntegerType(Type type);

	public boolean isRealType(Type type);

	public boolean isStringType(Type type);
	
	public Object defaultValue(InferredType type);

	public Object defaultValue(Type type);

	public void createArrayType(Type array);
	
	/**
	 * Returns a list of all types known in this type system.
	 * 
	 * @return The list of all types known in the type system
	 */
	public List<Type> getTypes();

	/**
	 * Infer a type for a given literal. The literal may represent a primitive
	 * value (primitive type literal) or an instance specification (complex type
	 * literal).
	 * 
	 * @param literal
	 *            The literal for which to infer a type
	 * @return An {@link InferenceResult} containing the {@link InferredType}
	 *         for the literal (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the type inference. The result may also contain both, an
	 *         inferred type and issues.
	 */
	public InferenceResult inferTypeForLiteral(Object literal);

	/**
	 * Responsible of inferring the type for a given unary expression (e.g. a
	 * complement), where the type of the operand is already inferred.
	 * 
	 * @param operandType
	 *            The inferred type of the operand of the unary expression
	 * @param unaryOperator
	 *            The unary operator by which the expression is identified
	 * @return An {@link InferenceResult} containing the {@link InferredType} of
	 *         the expression (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the type inference. The result may also contain both, an
	 *         inferred type and issues.
	 */
	public InferenceResult inferType(InferredType operandType, ITypeSystemOperator unaryOperator);

	/**
	 * Responsible of inferring the type for a given binary expression (e.g. an
	 * assignment), where the types of the two operands are already inferred.
	 * 
	 * @param firstOperandType
	 *            The inferred type of the first operand of the binary
	 *            expression
	 * @param secondOperandType
	 *            The inferred type of the second operand of the binary
	 *            expression
	 * @param binaryOperator
	 *            The binary operator by which the expression is identified
	 * @return An {@link InferenceResult} containing the {@link InferredType} of
	 *         the expression (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the type inference. The result may also contain both, an
	 *         inferred type and issues.
	 */
	public InferenceResult inferType(InferredType firstOperandType, InferredType secondOperandType,
			ITypeSystemOperator binaryOperator);

	/**
	 * Responsible of inferring the type for a given ternary expression (e.g. a
	 * conditional expression), where the types of the three operands are
	 * already inferred.
	 * 
	 * @param firstOperandType
	 *            The inferred type of the first operand of the ternary
	 *            expression, e.g. the condition part the inferred type of the
	 *            condition expression
	 * @param secondOperandType
	 *            The inferred type of the second operand of a ternary
	 *            expression, e.g. in case of a conditional expression, the
	 *            inferred type of the <code>true</code> case
	 * @param thirdOperandType
	 *            The inferred type of the third operator of a ternary
	 *            expression, e.g. in case of a conditional expression, the
	 *            inferred type of the <code>false</code> case
	 * @param ternaryOperator
	 *            The ternary operator by which the ternary expression is
	 *            identified, e.g. '?' for conditionals.
	 * @return An {@link InferenceResult} containing the {@link InferredType} of
	 *         the expression (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the inference. The result may also contain both, an
	 *         inferred type and issues, if for instance the condition part of a
	 *         conditional expression is not of type boolean but the true and
	 *         false cases provide valid type information that can be used to
	 *         calculate the type of the expression.
	 */
	public InferenceResult inferType(InferredType firstOperandType, InferredType secondOperandType,
			InferredType thirdOperandType, ITypeSystemOperator ternaryOperator);

	/**
	 * Returns the list of all concrete types, provided by the type system, that
	 * match the given inferred type, i.e. are compatible to its listed type and
	 * fulfill the given type constraints.
	 * 
	 * @param inferredType
	 *            The inferred type to evaluate
	 * @return The subset of all types returned via {@link #getTypes()} that is
	 *         compatible to the given inferred type.
	 */
	public List<Type> getTypes(InferredType inferredType);

}
