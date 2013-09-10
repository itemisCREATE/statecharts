/**
 * 
 */
package org.yakindu.sct.model.stext.types;

import org.yakindu.base.types.ITypeSystem;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftOperator;

import com.google.inject.ImplementedBy;

/**
 * Extension of {@link ITypeSystem}, which defines the operators that have to be
 * supported by an {@link ITypeSystem} to be used in combination with SText. The
 * extension also offers means to infer types for SText literals.
 * 
 * @author Alexander Nyßen (alexander.nyssen@itemis.de) - Inital contribution
 *         and API
 * 
 */
@ImplementedBy(STextDefaultTypeSystem.class)
public interface ISTextTypeSystem extends ITypeSystem {

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
		LOGICAL_OR("||"), LOGICAL_AND("&&"), BITWISE_OR("|"), BITWISE_AND("&"), BITWISE_XOR(
				"^"), SMALLER(RelationalOperator.SMALLER.getLiteral()), SMALLER_EQUAL(
				RelationalOperator.SMALLER_EQUAL.getLiteral()), GREATER(
				RelationalOperator.GREATER.getLiteral()), GREATER_EQUAL(
				RelationalOperator.GREATER_EQUAL.getLiteral()), EQUAL(
				RelationalOperator.EQUALS.getLiteral()), NOT_EQUAL(
				RelationalOperator.NOT_EQUALS.getLiteral()), MULTIPLY(
				MultiplicativeOperator.MUL.getLiteral()), DIV(
				MultiplicativeOperator.DIV.getLiteral()), MOD(
				MultiplicativeOperator.MOD.getLiteral()), ADD(
				AdditiveOperator.PLUS.getLiteral()), SUBTRACT(
				AdditiveOperator.MINUS.getLiteral()), LEFT_SHIFT(
				ShiftOperator.LEFT.getLiteral()), RIGHT_SHIFT(
				ShiftOperator.RIGHT.getLiteral()), ASSIGN(
				AssignmentOperator.ASSIGN.getLiteral()), ASSIGN_MULTIPLY(
				AssignmentOperator.MULT_ASSIGN.getLiteral()), ASSIGN_DIV(
				AssignmentOperator.DIV_ASSIGN.getLiteral()), ASSIGN_MOD(
				AssignmentOperator.MOD_ASSIGN.getLiteral()), ASSIGN_ADD(
				AssignmentOperator.ADD_ASSIGN.getLiteral()), ASSIGN_SUBTRACT(
				AssignmentOperator.SUB_ASSIGN.getLiteral()), ASSIGN_LEFT_SHIFT(
				AssignmentOperator.LEFT_SHIFT_ASSIGN.getLiteral()), ASSIGN_RIGHT_SHIFT(
				AssignmentOperator.RIGHT_SHIFT_ASSIGN.getLiteral()), ASSIGN_BITWISE_AND(
				AssignmentOperator.AND_ASSIGN.getLiteral()), ASSIGN_BITWISE_XOR(
				AssignmentOperator.XOR_ASSIGN.getLiteral()), ASSIGN_BITWISE_OR(
				AssignmentOperator.OR_ASSIGN.getLiteral());

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

}
