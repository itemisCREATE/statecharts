package org.yakindu.base.expressions.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BitwiseAndExpression;
import org.yakindu.base.expressions.expressions.BitwiseOrExpression;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.HexLiteral;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;
import org.yakindu.base.expressions.expressions.LogicalRelationExpression;
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression;
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression;
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.RealLiteral;
import org.yakindu.base.expressions.expressions.ShiftExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.services.ExpressionsGrammarAccess;

@SuppressWarnings("all")
public class ExpressionsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ExpressionsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ExpressionsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ExpressionsPackage.ASSIGNMENT_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_AssignmentExpression(context, (AssignmentExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.BITWISE_AND_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()) {
					sequence_BitwiseAndExpression(context, (BitwiseAndExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.BITWISE_OR_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()) {
					sequence_BitwiseOrExpression(context, (BitwiseOrExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.BITWISE_XOR_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()) {
					sequence_BitwiseXorExpression(context, (BitwiseXorExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.BOOL_LITERAL:
				if(context == grammarAccess.getBoolLiteralRule() ||
				   context == grammarAccess.getLiteralRule()) {
					sequence_BoolLiteral(context, (BoolLiteral) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.CONDITIONAL_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_ConditionalExpression(context, (ConditionalExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.ELEMENT_REFERENCE_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getElementReferenceExpressionRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getFeatureCallRule() ||
				   context == grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionRule() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalUnaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_ElementReferenceExpression(context, (ElementReferenceExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.FEATURE_CALL:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getFeatureCallRule() ||
				   context == grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionRule() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalUnaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_FeatureCall(context, (FeatureCall) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.HEX_LITERAL:
				if(context == grammarAccess.getHexLiteralRule() ||
				   context == grammarAccess.getLiteralRule()) {
					sequence_HexLiteral(context, (HexLiteral) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.INT_LITERAL:
				if(context == grammarAccess.getIntLiteralRule() ||
				   context == grammarAccess.getLiteralRule()) {
					sequence_IntLiteral(context, (IntLiteral) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.LOGICAL_AND_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()) {
					sequence_LogicalAndExpression(context, (LogicalAndExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.LOGICAL_NOT_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()) {
					sequence_LogicalNotExpression(context, (LogicalNotExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0()) {
					sequence_LogicalOrExpression(context, (LogicalOrExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.LOGICAL_RELATION_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0()) {
					sequence_LogicalRelationExpression(context, (LogicalRelationExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.NUMERICAL_ADD_SUBTRACT_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_NumericalAddSubtractExpression(context, (NumericalAddSubtractExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionRule() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_NumericalMultiplyDivideExpression(context, (NumericalMultiplyDivideExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.NUMERICAL_UNARY_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionRule() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalUnaryExpressionRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_NumericalUnaryExpression(context, (NumericalUnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.PARENTHESIZED_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionRule() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalUnaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_ParenthesizedExpression(context, (ParenthesizedExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.PRIMITIVE_VALUE_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionRule() ||
				   context == grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionRule() ||
				   context == grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getNumericalUnaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimitiveValueExpressionRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_PrimitiveValueExpression(context, (PrimitiveValueExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.REAL_LITERAL:
				if(context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getRealLiteralRule()) {
					sequence_RealLiteral(context, (RealLiteral) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.SHIFT_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0() ||
				   context == grammarAccess.getBitwiseAndExpressionRule() ||
				   context == grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseOrExpressionRule() ||
				   context == grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getBitwiseXorExpressionRule() ||
				   context == grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionRule() ||
				   context == grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalNotExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionRule() ||
				   context == grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getLogicalRelationExpressionRule() ||
				   context == grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0()) {
					sequence_ShiftExpression(context, (ShiftExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionsPackage.STRING_LITERAL:
				if(context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getStringLiteralRule()) {
					sequence_StringLiteral(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (varRef=AssignmentExpression_AssignmentExpression_1_0 operator=AssignmentOperator expression=ConditionalExpression)
	 */
	protected void sequence_AssignmentExpression(EObject context, AssignmentExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0(), semanticObject.getVarRef());
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=BitwiseAndExpression_BitwiseAndExpression_1_0 rightOperand=LogicalRelationExpression)
	 */
	protected void sequence_BitwiseAndExpression(EObject context, BitwiseAndExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BITWISE_AND_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BITWISE_AND_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BITWISE_AND_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BITWISE_AND_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=BitwiseOrExpression_BitwiseOrExpression_1_0 rightOperand=BitwiseAndExpression)
	 */
	protected void sequence_BitwiseOrExpression(EObject context, BitwiseOrExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BITWISE_OR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BITWISE_OR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BITWISE_OR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BITWISE_OR_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=BitwiseXorExpression_BitwiseXorExpression_1_0 rightOperand=BitwiseOrExpression)
	 */
	protected void sequence_BitwiseXorExpression(EObject context, BitwiseXorExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=BOOL
	 */
	protected void sequence_BoolLiteral(EObject context, BoolLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.BOOL_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.BOOL_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condition=ConditionalExpression_ConditionalExpression_1_0 trueCase=LogicalOrExpression falseCase=LogicalOrExpression)
	 */
	protected void sequence_ConditionalExpression(EObject context, ConditionalExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION__CONDITION));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION__TRUE_CASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION__TRUE_CASE));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION__FALSE_CASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION__FALSE_CASE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0(), semanticObject.getTrueCase());
		feeder.accept(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0(), semanticObject.getFalseCase());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (reference=[EObject|ID] (operationCall?='(' (args+=Expression args+=Expression*)?)?)
	 */
	protected void sequence_ElementReferenceExpression(EObject context, ElementReferenceExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (owner=FeatureCall_FeatureCall_1_0 feature=[EObject|ID] (operationCall?='(' (args+=Expression args+=Expression*)?)?)
	 */
	protected void sequence_FeatureCall(EObject context, FeatureCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=HEX
	 */
	protected void sequence_HexLiteral(EObject context, HexLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.HEX_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.HEX_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getHexLiteralAccess().getValueHEXTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_IntLiteral(EObject context, IntLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.INT_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.INT_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=LogicalAndExpression_LogicalAndExpression_1_0 rightOperand=LogicalNotExpression)
	 */
	protected void sequence_LogicalAndExpression(EObject context, LogicalAndExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     operand=BitwiseXorExpression
	 */
	protected void sequence_LogicalNotExpression(EObject context, LogicalNotExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_NOT_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_NOT_EXPRESSION__OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=LogicalOrExpression_LogicalOrExpression_1_0 rightOperand=LogicalAndExpression)
	 */
	protected void sequence_LogicalOrExpression(EObject context, LogicalOrExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=LogicalRelationExpression_LogicalRelationExpression_1_0 operator=RelationalOperator rightOperand=ShiftExpression)
	 */
	protected void sequence_LogicalRelationExpression(EObject context, LogicalRelationExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         leftOperand=NumericalAddSubtractExpression_NumericalAddSubtractExpression_1_0 
	 *         operator=AdditiveOperator 
	 *         rightOperand=NumericalMultiplyDivideExpression
	 *     )
	 */
	protected void sequence_NumericalAddSubtractExpression(EObject context, NumericalAddSubtractExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         leftOperand=NumericalMultiplyDivideExpression_NumericalMultiplyDivideExpression_1_0 
	 *         operator=MultiplicativeOperator 
	 *         rightOperand=NumericalUnaryExpression
	 *     )
	 */
	protected void sequence_NumericalMultiplyDivideExpression(EObject context, NumericalMultiplyDivideExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (operator=UnaryOperator operand=PrimaryExpression)
	 */
	protected void sequence_NumericalUnaryExpression(EObject context, NumericalUnaryExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION__OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_ParenthesizedExpression(EObject context, ParenthesizedExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.PARENTHESIZED_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.PARENTHESIZED_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=Literal
	 */
	protected void sequence_PrimitiveValueExpression(EObject context, PrimitiveValueExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.PRIMITIVE_VALUE_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.PRIMITIVE_VALUE_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=FLOAT
	 */
	protected void sequence_RealLiteral(EObject context, RealLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.REAL_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.REAL_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRealLiteralAccess().getValueFLOATTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=ShiftExpression_ShiftExpression_1_0 operator=ShiftOperator rightOperand=NumericalAddSubtractExpression)
	 */
	protected void sequence_ShiftExpression(EObject context, ShiftExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.SHIFT_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.SHIFT_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.SHIFT_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.SHIFT_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.SHIFT_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.SHIFT_EXPRESSION__RIGHT_OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringLiteral(EObject context, StringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionsPackage.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionsPackage.Literals.STRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
}
