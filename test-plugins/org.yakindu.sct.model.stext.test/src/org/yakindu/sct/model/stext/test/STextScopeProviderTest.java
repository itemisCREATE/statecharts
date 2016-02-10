/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.test;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.expressions.STextExpressionParser.LinkingException;
import org.yakindu.sct.model.stext.scoping.ContextPredicateProvider;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;

/**
 * @author andreas muelder - Initial contribution and API
 * @author Johannes Dicks - Add tests covering {@link ContextPredicateProvider}
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class STextScopeProviderTest extends AbstractSTextTest {

	public static final String INTERNAL_SCOPE = "" + //
			"internal: " + //
			"	in event e1 : void" + //
			"	in event e2 : void" + //
			"	var myInt : integer" + //
			"	var myBool : boolean" + //
			"	operation myOpp(param1 : integer) : void" + //
			"	operation myOpp3() : integer" + //
			"	operation myOpp4() : boolean" + //
			"	operation myOpp5() : integer";

	public static final String INTERFACE_SCOPE = "" + //
			"interface Interface1:" + //
			"	in event e3 : void" + //
			"	in event e4 : void" + //
			"	var myInt2 : integer" + //
			"	var myBool2 : boolean" + //
			"	operation myOpp2(param1 : integer) : void";

	private Scope internalScope = null;
	private Scope interfaceScope = null;

	@Before
	public void setup() {
		internalScope = createInternalScope(INTERNAL_SCOPE);
		interfaceScope = createInterfaceScope(INTERFACE_SCOPE);
	}

	@Test
	public void testGuardScopingSuccess() throws Exception {
		parseExpression("[e1]", ReactionTrigger.class.getSimpleName(), internalScope);
		parseExpression("[Interface1.e3]", ReactionTrigger.class.getSimpleName(), interfaceScope);
		parseExpression("[e1 && e2]", ReactionTrigger.class.getSimpleName(), internalScope);
		parseExpression("[e1 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), internalScope, interfaceScope);
		parseExpression("[Interface1.e4 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), interfaceScope);
	}

	/**
	 * filter.put(key(ASSIGNMENT_EXPRESSION),
	 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testAssignmentExpressionSuccess() throws Exception {
		parseExpression("myInt = 0", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt = Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt = myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myBool = e1", ReactionEffect.class.getSimpleName(), internalScope);

	}
	/**
	 * filter.put(key(CONDITIONAL_EXPRESSION), VARIABLES_AND_OPERATIONS);
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testConditionalExpressionSuccess() throws Exception {
		parseExpression("myBool ? myOpp(1) : myOpp(2)", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myOpp4() ? myInt : myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(CONDITIONAL_EXPRESSION), VARIABLES_AND_OPERATIONS);
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testConditionalExpressionError() throws Exception {
		parseExpression("myBool ? e1 : myOpp(2)", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(LOGICAL_OR_EXPRESSION),
	 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testLogicalOrExpressionSuccess() throws Exception {
		parseExpression("myInt || Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt || myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt || e1", ReactionEffect.class.getSimpleName(), internalScope);

	}
	/**
	 * filter.put(key(LOGICAL_AND_EXPRESSION),
	 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testLogicalAndExpressionSuccess() throws Exception {
		parseExpression("myInt && Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt && myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt && e1", ReactionEffect.class.getSimpleName(), internalScope);

	}

	/**
	 * filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testBitWiseXOrExpressionSuccess() throws Exception {
		parseExpression("myInt ^ Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
	}
	
	/**
	 * filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testBitWiseXOrExpressionErrorWithEvents() throws Exception {
		parseExpression("e1 ^ e2", ReactionEffect.class.getSimpleName(), internalScope);
	}
	
	/**
	 * filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testBitWiseXOrExpressionErrorWithOperation() throws Exception {
		parseExpression("myOpp1(1) ^ myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
	}
	
	/**
	 * filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testBitWiseOrExpressionSuccess() throws Exception {
		parseExpression("myInt | Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
	}
	/**
	 * filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testBitWiseOrExpressionErrorWithEvents() throws Exception {
		parseExpression("e1 | e2", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testBitWiseOrExpressionErrorWithOperation() throws Exception {
		parseExpression("myOpp1(1) | myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		
	}
	/**
	 * filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testBitWiseAndExpressionSuccess() throws Exception {
		parseExpression("myInt & Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
	}
	/**
	 * filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testBitWiseAndExpressionErrorWithEvent() throws Exception {
		parseExpression("e1 & e2", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testBitWiseAndExpressionErrorWithOperation() throws Exception {
		parseExpression("myOpp1(1) & myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testShiftExpressionSuccess() throws Exception {
		parseExpression("myInt << Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt >> Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
	}
	/**
	 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testShiftExpressionErrorWithEventToRight() throws Exception {
		// check events
		parseExpression("e1 >> e2", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testShiftExpressionErrorWithEventToLeft() throws Exception {
		parseExpression("e1 >> e2", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testShiftExpressionErrorWithOperationToRight() throws Exception {
		parseExpression("myOpp1(1) >> myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testShiftExpressionErrorWithOperationToLeft() throws Exception {
		parseExpression("myOpp1(1) << myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
	}

	/**
	 * filter.put(key(LOGICAL_NOT_EXPRESSION),
	 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testLogicalNotExpressionSuccess() throws Exception {
		parseExpression("myInt != Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt != myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt != e1", ReactionEffect.class.getSimpleName(), internalScope);
	}

	/**
	 * filter.put(key(LOGICAL_RELATION_EXPRESSION),
	 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
	 * 
	 * less than < greater than > equal or less than <= equal or greater than >=
	 * equal == not equal !=
	 * 
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testLogicalRelationExpressionSuccess() throws Exception {
		// check <
		parseExpression("myInt < Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt < myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt < e1", ReactionEffect.class.getSimpleName(), internalScope);
		// check >
		parseExpression("myInt > Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt > myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt > e1", ReactionEffect.class.getSimpleName(), internalScope);
		// check <=
		parseExpression("myInt <= Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt <= myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt <= e1", ReactionEffect.class.getSimpleName(), internalScope);
		// check >=
		parseExpression("myInt >= Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt >= myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt >= e1", ReactionEffect.class.getSimpleName(), internalScope);
		// check ==
		parseExpression("myInt == Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt == myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt == e1", ReactionEffect.class.getSimpleName(), internalScope);
		// check !=
		parseExpression("myInt != Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt != myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt != e1", ReactionEffect.class.getSimpleName(), internalScope);

	}

	/**
	 * filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION),
	 * VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testNumericalAddSubstractExpressionSuccess() throws Exception {
		parseExpression("myInt + Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt - Interface1.myInt2", ReactionEffect.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myOpp3() + myInt", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myInt - myOpp3()", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myOpp3() + myInt", ReactionEffect.class.getSimpleName(), internalScope);
		parseExpression("myOpp3() - myInt", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION),
	 * VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testNumericalAddExpressionError() throws Exception {
		
		parseExpression("e1 + e2", ReactionEffect.class.getSimpleName(), internalScope);
	
	}
	/**
	 * filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION),
	 * VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testNumericalSubstractExpressionError() throws Exception {
		parseExpression("e1 - e2", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION),
	 * VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testNumericalMultiplyDevideExpressionSuccess() throws Exception {
		parseExpression("myInt * Interface1.myInt2", Guard.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myInt / Interface1.myInt2", Guard.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("myOpp3() * myInt", Guard.class.getSimpleName(), internalScope);
		parseExpression("myInt / myOpp3()", Guard.class.getSimpleName(), internalScope);
		parseExpression("myOpp3() * myInt", Guard.class.getSimpleName(), internalScope);
		parseExpression("myOpp3() / myInt", Guard.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION),
	 * VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testNumericalMultiplyExpressionError() throws Exception {
		parseExpression("e1 * e2", Guard.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION),
	 * VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testNumericalDevideExpressionError() throws Exception {
		parseExpression("e1 / e2", Guard.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_UNARY_EXPRESSION), VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testNumericalUnaryExpressionSuccess() throws Exception {
		parseExpression("-myInt", Guard.class.getSimpleName(), internalScope);
		parseExpression("+myInt", Guard.class.getSimpleName(), internalScope);
		parseExpression("-myOpp3()", Guard.class.getSimpleName(), internalScope);
		parseExpression("+myOpp3()", Guard.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_UNARY_EXPRESSION), VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testNumericalUnaryMinusExpressionError() throws Exception {
		parseExpression("-e1", Expression.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(NUMERICAL_UNARY_EXPRESSION), VARIABLES_AND_OPERATIONS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testNumericalUnaryPlusExpressionError() throws Exception {
		parseExpression("+e1", Expression.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test
	public void testEventValueReferenceExpressionSuccess() throws Exception {
		parseExpression("valueof(e2)", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testEventValueReferenceExpressionErrorOfVairable() throws Exception {
		parseExpression("valueof(myInt)", ReactionEffect.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS)
	 * 
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Test(expected=LinkingException.class)
	public void testEventValueReferenceExpressionErrorOfOperation() throws Exception {
		parseExpression("valueof(myOpp3())", ReactionEffect.class.getSimpleName(), internalScope);
	}

	/**
	 * filter.put(key(VARIABLE_DEFINITION, TYPED_ELEMENT__TYPE), TYPES)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVariableDefinitionSuccess() throws Exception {
		parseExpression("var x : integer", VariableDefinition.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(VARIABLE_DEFINITION, TYPED_ELEMENT__TYPE), TYPES)
	 * 
	 * @throws Exception
	 */
	@Test(expected=LinkingException.class)
	public void testVariableDefinitionError() throws Exception {
		parseExpression("var x : e1", VariableDefinition.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(REGULAR_EVENT_SPEC), EVENTS)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReactionTriggerSuccess() throws Exception {
		parseExpression("e1 / myInt = 0", LocalReaction.class.getSimpleName(), internalScope);
	}
	/**
	 * filter.put(key(REGULAR_EVENT_SPEC), EVENTS)
	 * 
	 * @throws Exception
	 */
	@Test(expected=LinkingException.class)
	public void testReactionTriggerErrorWithOperation() throws Exception {
		parseExpression("myOpp(4) / myInt = 10", LocalReaction.class.getSimpleName(), internalScope);
	}
	
	/**
	 * filter.put(key(REGULAR_EVENT_SPEC), EVENTS)
	 * 
	 * @throws Exception
	 */
	@Test(expected=LinkingException.class)
	public void testReactionTriggerErrorWithVariable() throws Exception {
		parseExpression("myInt / myInt = 10", LocalReaction.class.getSimpleName(), internalScope);
	}
}
