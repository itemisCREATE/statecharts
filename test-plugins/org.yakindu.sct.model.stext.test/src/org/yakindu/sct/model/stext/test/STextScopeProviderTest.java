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

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.yakindu.base.types.Expression;
import org.yakindu.sct.model.stext.expressions.STextExpressionParser.LinkingException;
import org.yakindu.sct.model.stext.scoping.ContextPredicateProvider;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;

/**
 * @author andreas muelder - Initial contribution and API
 * @author Johannes Dicks - Add tests covering {@link ContextPredicateProvider}
 */
@RunWith(Parameterized.class)
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

	public static final String INTERFACE_SCOPE_AND_INTERNAL_SCOPE = INTERNAL_SCOPE + "\n" + INTERFACE_SCOPE;

	private String statement;
	private String ruleName;
	private String scopes;
	private boolean isLinkable;
	
	public STextScopeProviderTest(String statement, String ruleName, String scopes, Boolean isLinkable) {
		this.statement = statement;
		this.ruleName = ruleName;
		this.scopes = scopes;
		this.isLinkable = isLinkable;

		STextInjectorProvider provider = new STextInjectorProvider();
		provider.getInjector().injectMembers(this);
	}

	@Test
	public void test() {
		try {
			parseExpression(statement, ruleName, scopes);
			if (!isLinkable)
				fail(String.format(
						"Expected not to be linkable [parse '%s' in rule '%s' for scope '%s' expected linkable = '%s']",
						statement, ruleName, scopes, isLinkable));
		} catch (LinkingException e) {
			if (isLinkable)
				throw new RuntimeException("Expected linkable but : "+e.getMessage(),e);
		}
	}

	/**
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Parameters(name = "{index}: {0} in rule {1} expected to be invalid = {3}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { //
				/* testGuardScopingSuccess */
				{ "[e1]", ReactionTrigger.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "[Interface1.e3]", ReactionTrigger.class.getSimpleName(), INTERFACE_SCOPE, true }, //
				{ "[e1 && e2]", ReactionTrigger.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "[e1 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "[Interface1.e4 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), INTERFACE_SCOPE, true }, //
				/*
				 * filter.put(key(ASSIGNMENT_EXPRESSION),
				 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
				 */
				{ "myInt = 0", ReactionEffect.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt = Interface1.myInt2", ReactionEffect.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt = myOpp3()", ReactionEffect.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myBool = e1", ReactionEffect.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(CONDITIONAL_EXPRESSION),
				 * VARIABLES_AND_OPERATIONS)
				 */
				{ "myBool ? myOpp(1) : myOpp(2)", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myOpp4() ? myInt : myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true}, //
				{ "myBool ? e1 : myOpp(2)", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				/*
				 * filter.put(key(LOGICAL_OR_EXPRESSION),
				 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
				 */
				{ "myBool || Interface1.myBool2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myBool || myOpp4()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myBool || e1", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(LOGICAL_AND_EXPRESSION),
				 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
				 */
				{ "myBool && Interface1.myBool2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myBool && myOpp4()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myBool && e1", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES)
				 */
				{ "myInt ^ Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "e1 ^ e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "myOpp3() ^ myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES)
				 */
				{ "myInt | Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "e1 | e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "myOpp3() | myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES)
				 */
				{ "myInt & Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "e1 & e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "myOpp3() & myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
				 */
				{ "myInt << Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt >> Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "e1 >> e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "e1 >> e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "myOpp3() >> myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myOpp3() << myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(LOGICAL_NOT_EXPRESSION),
				 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
				 */
				{ "!Interface1.myBool2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE, true }, //
				{ "!myOpp4()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "!e1", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(LOGICAL_RELATION_EXPRESSION),
				 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
				 */
				{ "myInt < Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt < myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt > Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt > myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt <= Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt <= myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt >= Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt >= myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt == Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt == myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt != Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt != myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				/*
				 * filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION),
				 * VARIABLES_AND_OPERATIONS)
				 */
				{ "myInt + Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt - Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myOpp3() + myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt - myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myOpp3() + myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myOpp3() - myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "e1 + e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "e1 - e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				/*
				 * filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION),
				 * VARIABLES_AND_OPERATIONS)
				 */
				{ "myInt * Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myInt / Interface1.myInt2", Expression.class.getSimpleName(), INTERFACE_SCOPE_AND_INTERNAL_SCOPE,
						true }, //
				{ "myOpp3() * myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myInt / myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "myOpp3() * myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "e1 * e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "e1 / e2", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				/*
				 * filter.put(key(NUMERICAL_UNARY_EXPRESSION),
				 * VARIABLES_AND_OPERATIONS)
				 */
				{ "-myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "+myInt", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "-myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "+myOpp3()", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				{ "-e1", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				{ "+e1", Expression.class.getSimpleName(), INTERNAL_SCOPE, false }, //
				/*
				 * filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS)
				 */
				{ "valueof(e2)", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				// { "valueof(myInt)", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, // context predicates can't validate this expression. This will be done in the SText validation instead.
				// { "valueof(myOpp3())", Expression.class.getSimpleName(), INTERNAL_SCOPE, true }, // context predicates can't validate this expression. This will be done in the SText validation instead.
				/*
				 * filter.put(key(VARIABLE_DEFINITION, TYPED_ELEMENT__TYPE),
				 * TYPES)
				 */
				{ "var x : integer", "ScopeDeclaration", INTERNAL_SCOPE, true }, //
				/* filter.put(key(REGULAR_EVENT_SPEC), EVENTS) */
				{ "e1 / myInt = 0", LocalReaction.class.getSimpleName(), INTERNAL_SCOPE, true }, //
				//{ "myOpp(4) / myInt = 10", LocalReaction.class.getSimpleName(), INTERNAL_SCOPE, true }, // context predicates can't validate this expression. This will be done in the SText validation instead.
				//{ "myInt / myInt = 10", LocalReaction.class.getSimpleName(), INTERNAL_SCOPE, true }, // context predicates can't validate this expression. This will be done in the SText validation instead.
		});
	}
}