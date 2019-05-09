/*
 * (c) by committers of YAKINDU */
package org.yakindu.base.expressions.formatting2

import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
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
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeSpecifier

class ExpressionsFormatter extends AbstractEObjectBasedFormatter {

	def dispatch void format(AssignmentExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		expression.format
		varRef.format
	}

	def dispatch void format(ConditionalExpression it, extension IFormattableDocument document) {
		allRegionsFor.keywords("?", ":").forEach[surround[oneSpace]]
		trueCase.format
		falseCase.format
		condition.format
	}

	def dispatch void format(LogicalOrExpression it, extension IFormattableDocument document) {
		regionFor.keyword("||").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(LogicalAndExpression it, extension IFormattableDocument document) {
		regionFor.keyword("&&").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(LogicalNotExpression it, extension IFormattableDocument document) {
		regionFor.keyword("!").surround[noSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY;]
		operand.format
	}

	def dispatch void format(BitwiseOrExpression it, extension IFormattableDocument document) {
		regionFor.keyword("|").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(BitwiseXorExpression it, extension IFormattableDocument document) {
		regionFor.keyword("^").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(BitwiseAndExpression it, extension IFormattableDocument document) {
		regionFor.keyword("&").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(LogicalRelationExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(ShiftExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(NumericalAddSubtractExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(NumericalMultiplyDivideExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(NumericalUnaryExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		operand.format
	}

	def dispatch void format(PrimitiveValueExpression primitiveValueExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(BlockExpression it, extension IFormattableDocument document) {
		interior[indent]
		regionFor.keywordPairs('{', '}').forEach [
			key.append[newLines]
			key.prepend[oneSpace]
			value.prepend[newLine]
		]
		expressions.forEach[format]
	}

	def dispatch void format(IfExpression it, extension IFormattableDocument document) {
		regionFor.keyword("if").append[oneSpace]
		regionFor.keyword("else").surround[oneSpace; priority = IHiddenRegionFormatter.HIGH_PRIORITY]
		condition.format
		then.format
		^else.format
		append[newLines]
	}

	def dispatch void format(SwitchExpression switchExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(SwitchCase switchCase, extension IFormattableDocument document) {
	}

	def dispatch void format(EventRaisingExpression eventRaisingExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(WhileExpression it, extension IFormattableDocument document) {
		regionFor.keyword("while").append[oneSpace]
		condition.format
		body.format
		append[newLines]
	}

	def dispatch void format(ForExpression it, extension IFormattableDocument document) {
		regionFor.keyword("for").append[oneSpace]
		it.varInits.forEach[prepend[noSpace]]
		condition.format
		varUpdates.forEach[prepend[noSpace]]
		body.format
		append[newLines]
	}

	def dispatch void format(Property property, extension IFormattableDocument document) {
	}

	def dispatch void format(ReturnExpression returnExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(ThrowExpression throwExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(FeatureCall it, extension IFormattableDocument document) {
		regionFor.keyword(".").surround[noSpace]
		arguments.forEach[format]
		expressions.forEach[format]
		arraySelector.forEach[format]
	}

	def dispatch void format(ElementReferenceExpression elementReferenceExpression,
		extension IFormattableDocument document) {
	}

	def dispatch void format(Argument it, extension IFormattableDocument document) {
		prepend[oneSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY]
		append[noSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY]
		value.format
	}

	def dispatch void format(ParenthesizedExpression parenthesizedExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(TypeSpecifier typeSpecifier, extension IFormattableDocument document) {
	}

	def dispatch void format(PostFixUnaryExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[noSpace]
			}
		]
		operand.format
	}

	def dispatch void format(TypeCastExpression typeCastExpression, extension IFormattableDocument document) {
	}

	def dispatch void format(MetaCall metaCall, extension IFormattableDocument document) {
	}
}
