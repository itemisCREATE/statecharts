package org.yakindu.base.expressions.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BitwiseAndExpression;
import org.yakindu.base.expressions.expressions.BitwiseOrExpression;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.HexLiteral;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;
import org.yakindu.base.expressions.expressions.LogicalRelationExpression;
import org.yakindu.base.expressions.expressions.NullLiteral;
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression;
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression;
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.RealLiteral;
import org.yakindu.base.expressions.expressions.ShiftExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.interpreter.AbstractTypeSystemInterpreter;

public class ExpressionsTypeInterpreter extends AbstractTypeSystemInterpreter {

	public Object interpret(AssignmentExpression e) {
		return null;
	}

	public Object interpret(ConditionalExpression e) {
		return null;
	}

	public Object interpret(LogicalOrExpression e) {
		return null;
	}

	public Object interpret(LogicalAndExpression e) {
		return null;
	}

	public Object interpret(LogicalNotExpression e) {
		return null;
	}

	public Object interpret(BitwiseXorExpression e) {
		return null;
	}

	public Object interpret(BitwiseOrExpression e) {
		return null;
	}

	public Object interpret(BitwiseAndExpression e) {
		return null;
	}

	public Object interpret(ShiftExpression e) {
		return null;
	}

	public Object interpret(LogicalRelationExpression e) {
		return null;

	}

	public Object interpret(NumericalAddSubtractExpression e) {
		return null;
	}

	public Object interpret(NumericalMultiplyDivideExpression e) {
		return null;
	}

	public Object interpret(NumericalUnaryExpression e) {
		return null;
	}

	public Object interpret(TypeCastExpression e) {
		return null;
	}

	public Object interpret(FeatureCall e) {
		return null;
	}

	public Object interpret(ElementReferenceExpression e) {
		return interpretExpression(e.getReference());
	}

	public Object interpret(ParenthesizedExpression e) {
		return interpretExpression(e.getExpression());
	}

	public Object interpret(PrimitiveValueExpression e) {
		return interpretExpression(e.getValue());
	}

	public Object interpret(BoolLiteral literal) {
		return literal.isValue();
	}

	public Object interpret(IntLiteral literal) {
		return literal.getValue();
	}

	public Object interpret(HexLiteral literal) {
		return literal.getValue();
	}

	public Object interpret(RealLiteral literal) {
		return literal.getValue();
	}

	public Object interpret(StringLiteral literal) {
		return literal.getValue();
	}

	public Object interpret(NullLiteral literal) {
		return null;
	}

	public Object interpret(EObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object defaultValue(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

}
