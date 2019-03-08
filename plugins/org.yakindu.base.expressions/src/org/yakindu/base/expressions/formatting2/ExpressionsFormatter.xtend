/*
 * (c) by committers of YAKINDU */
package org.yakindu.base.expressions.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.EventRaisingExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.ForExpression
import org.yakindu.base.expressions.expressions.IfExpression
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MetaCall
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ReturnExpression
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.SwitchCase
import org.yakindu.base.expressions.expressions.SwitchExpression
import org.yakindu.base.expressions.expressions.ThrowExpression
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.WhileExpression
import org.yakindu.base.expressions.services.ExpressionsGrammarAccess
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeSpecifier

class ExpressionsFormatter extends AbstractEObjectBasedFormatter {

	@Inject extension ExpressionsGrammarAccess

	def dispatch void format(AssignmentExpression assignmentExpression, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		assignmentExpression.expression.format
		assignmentExpression.varRef.format
	}

	def dispatch void format(ConditionalExpression conditionalExpression, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		conditionalExpression.trueCase.format
		conditionalExpression.falseCase.format
		conditionalExpression.condition.format
	}

	def dispatch void format(LogicalOrExpression logicalOrExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(LogicalAndExpression logicalAndExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(LogicalNotExpression logicalNotExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(BitwiseOrExpression bitwiseOrExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(BitwiseXorExpression bitwiseXorExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(BitwiseAndExpression bitwiseAndExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(LogicalRelationExpression logicalRelationExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(ShiftExpression shiftExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(NumericalAddSubtractExpression numericalAddSubtractExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(NumericalMultiplyDivideExpression numericalMultiplyDivideExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(NumericalUnaryExpression numericalUnaryExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(PrimitiveValueExpression primitiveValueExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(BlockExpression blockExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(IfExpression ifExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(SwitchExpression switchExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(SwitchCase switchCase, extension IFormattableDocument document) {
	}

	def dispatch void format(EventRaisingExpression eventRaisingExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(WhileExpression whileExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(ForExpression forExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(Property property, extension IFormattableDocument document) {
	}

	def dispatch void format(ReturnExpression returnExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(ThrowExpression throwExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(FeatureCall featureCall, extension IFormattableDocument document) {
	}

	def dispatch void format(ElementReferenceExpression elementReferenceExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(Argument argument, extension IFormattableDocument document) {
	}

	def dispatch void format(ParenthesizedExpression parenthesizedExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(TypeSpecifier typeSpecifier, extension IFormattableDocument document) {
	}

	def dispatch void format(PostFixUnaryExpression postFixUnaryExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(TypeCastExpression typeCastExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(MetaCall metaCall, extension IFormattableDocument document) {
	}
}
