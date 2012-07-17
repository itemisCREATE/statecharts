package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.Literal
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.sexec.TimeEvent

class ActionCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	
	
		/** todo externalize */
	def dispatch access (VariableDefinition it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier»'''
		
	/** todo externalize */
	def dispatch access (EventDefinition it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier»_raised'''
		
	/** todo externalize */
	def dispatch access (TimeEvent it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier»_raised'''
		
	def dispatch access (EObject it) 
		'''#warning can't access elements of type «getClass().name»'''
		
	
	
	def dispatch code (Statement it) 
		'''#error TODO: generate code for «getClass().name»'''

	
	def dispatch code (Literal it)
		'''#error unknown literal type «getClass().name» '''
	
	def dispatch code (StringLiteral it) 
		'''"«value»"'''	

	def dispatch code (BoolLiteral it) 
		'''«IF value»bool_true«ELSE»bool_false«ENDIF»'''	

	def dispatch code (IntLiteral it) 
		'''«value.toString»'''	

	def dispatch code (RealLiteral it) 
		'''«value.toString»'''	
		
	def dispatch code (HexLiteral it) 
		'''«value.toString»'''	

	def dispatch code (PrimitiveValueExpression it) 
		'''«value.code»'''	

		
	def dispatch code (ElementReferenceExpression it) 
		'''«reference.access»'''
		
		
	def dispatch code (AssignmentExpression it)
		'''«varRef.code» «operator.literal» «expression.code»'''
		


	/* Logical Expressions */
	
	def dispatch code (LogicalOrExpression it)
		'''«rightOperand.code» || «leftOperand.code»'''
		
	
///* EventRaising */
//String toCCode(EventRaisingExpression eventRaising) :
//	((eventRaising.value == null)?"":
//	"((" + eventRaising.event.getEventName() + "*)" + eventRaising.statemachineHandleName() + "->" + eventRaising.getInterfaceName() + "." + eventRaising.event.getEventName() + ")->value = " 
//	+ eventRaising.value.toCCode() + ";") + 
//	" statemachine_cy_setEvent(&" + eventRaising.statemachineHandleName() + 
//	"->base, " + eventRaising.statemachineHandleName() + "->" + 
//	eventRaising.getInterfaceName() + "." + 
//	eventRaising.event.getEventName() + "); ";
//
//String addValue(EventRaisingExpression event) :
//  ( (event.value == null)?"":("((" +event.event.getEventName() + "*)ev)->value = " + event.value.toCCode() + "; ") );
//
///* Logical Expressions */
//String toCCode(LogicalOrExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + " || " + " ( " + expression.rightOperand.toCCode() + " ) ";
//  	
//String toCCode(LogicalAndExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + " && " + " ( " + expression.rightOperand.toCCode() + " ) ";
//
//String toCCode(LogicalNotExpression expression) :
//  	" ~" + " ( " + expression.operand.toCCode() + " ) ";
//
//String toCCode(LogicalRelationExpression expression) :
//	if (expression.leftOperand.inferType().isString()) then
//		"("+expression.leftOperand.toCCode()+"==NULL?"+expression.rightOperand.toCCode()+"==NULL:strcmp("+expression.leftOperand.toCCode()+", "+expression.rightOperand.toCCode()+")==0)"
//	else
//		" ( " + expression.leftOperand.toCCode() + " ) " + getOperator(expression.operator) + " ( " + expression.rightOperand.toCCode() + " ) ";
//    
//String toCCode(BitwiseAndExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + " & " + " ( " + expression.rightOperand.toCCode() + " ) ";
//
//String toCCode(BitwiseOrExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + " | " + " ( " + expression.rightOperand.toCCode() + " ) ";
//
//String toCCode(BitwiseXorExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + " ^ " + " ( " + expression.rightOperand.toCCode() + " ) ";
//
//String toCCode(NumericalAddSubtractExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + getOperator(expression.operator) + " ( " + expression.rightOperand.toCCode() + " ) ";
//  	
//String toCCode(NumericalMultiplyDivideExpression expression) :
//  	" ( " + expression.leftOperand.toCCode() + " ) " + getOperator(expression.operator) + " ( " + expression.rightOperand.toCCode() + " ) ";
//
//
//String toCCode(NumericalUnaryExpression expression) :
//    getOperator(expression.operator) + " ( " + expression.operand.toCCode() + " ) ";
//
///* can not handle internal scope  */
//
//ExecutionFlow getExecutionFlow(InterfaceScope this) : ((ExecutionFlow)this.eContainer);
//String interfaceObjectName(InterfaceScope this) : "iface" + ((this.name == null)?"":this.name.toFirstUpper());
//
//String getOperator(AdditiveOperator operator) : 
//    switch(operator) {
//    	case(AdditiveOperator::plus) : " + "
//    	case(AdditiveOperator::minus) : " - "
//    	default : ""
//    };
//
//String getOperator(MultiplicativeOperator operator) : 
//    switch(operator) {
//    	case(MultiplicativeOperator::mul) : " * "
//    	case(MultiplicativeOperator::div) : " / "
//    	case(MultiplicativeOperator::mod) : " % "
//    	default : ""
//    };
//
//String getOperator(RelationalOperator operator) :
//	switch (operator) {
//	  case (RelationalOperator::greater) : " > "
//	  case (RelationalOperator::greaterEqual) : " >= "
//	  case (RelationalOperator::smaller) : " < "
//	  case (RelationalOperator::smallerEqual) : " <= "
//	  case (RelationalOperator::equals) : " == "
//	  case (RelationalOperator::notEquals) : " != "
//	  default : ""
//	};
//
//String getOperator(UnaryOperator operator) :
//	switch (operator) {
//	  case (UnaryOperator::negative) : " -"
//	  case (UnaryOperator::positive) : " + "
//	  case (UnaryOperator::complement) : " ~ "
//	  default : ""
//	};
//
//Set[EventDefinition] getInEvents(Scope interface) : 
//	{};
//
//Set[EventDefinition] getOutEvents(Scope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::OUT);
//
//Set[EventDefinition] getLocalEvents(Scope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::LOCAL);
//  
//Set[EventDefinition] getInEvents(InterfaceScope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::IN);
//
//Set[EventDefinition] getOutEvents(InterfaceScope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::OUT);
//
//Set[EventDefinition] getLocalEvents(InterfaceScope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::LOCAL);
//
//Set[EventDefinition] getInEvents(InternalScope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::IN);
//
//Set[EventDefinition] getOutEvents(InternalScope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::OUT);
//
//Set[EventDefinition] getLocalEvents(InternalScope interface) : 
//	interface.declarations.typeSelect(EventDefinition).select(e|e.direction == Direction::LOCAL);
//
//// is this just relevant for events?
//String toCCode(ElementReferenceExpression ref) :
//	ref.reference.toCCode()+ (if (ref.operationCall) then "("+ref.getInterfaceCallComma()+ref.args.toCCode().toString(",")+")" else "");
//
//String toCCode(EObject ref) :
//	"/* toCode not defined for: "+ref+" */";
//String toCCode(Feature ref) :
//	"/* toCode not defined for: "+ref+" */";
//String toCCode(FeatureCall ref) :
//	ref.feature.toCCode()+ (if (ref.operationCall) then "("+ref.getInterfaceCallComma()+ref.args.toCCode().toString(",")+")" else "");
//
//String toCCode(Declaration dec) :
//	"Declartion type not specified";
//
//String toCCode(OperationDefinition dec) :
//	" " +dec.getMethodName();
//
//String toCCode(TimeEvent time_ev) :
//    " ( eventSet_check( &"+time_ev.statemachineHandleName()+"->base.eventSet, " + time_ev.getEventEnumName() + ") ) ";
//
//String toCCode(VariableDefinition var) :
//    " " + var.statemachineHandleName() + "->" + var.getInterface() + 
//    "." + var.getName() + " ";
//	
//String toCCode(EventDefinition evDef) :
//    " ( eventSet_check( &" + evDef.statemachineHandleName() + "->base.eventSet, " + evDef.getEventEnumName() + ") ) ";
//
///*
//String toCCode(EventRaisedReferenceExpression errExp) :
//	" eventSet_check( &" + errExp.statemachineHandleName() + "->base.eventSet, " + errExp.value.getEventEnumName() + ")";
//*/
//String toCCode(EventValueReferenceExpression evrExp) :
//	"((" +evrExp.value.getEventName() + "*)" + evrExp.statemachineHandleName() + "->base.eventList[" + evrExp.value.getEventEnumName() + "])->value";
//
//String toCCode(ActiveStateReferenceExpression asrExp) :
//	"isActive("+asrExp.value.StateEnumName()+") /* function not implemented yet */";
//
//List[Scope] getUsableScopes(List[Scope] scList) :
//	scList.select(e| InterfaceScope.isInstance(e) || InternalScope.isInstance(e));
	
}