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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.expressions.STextExpressionParser.LinkingException;
import org.yakindu.sct.model.stext.scoping.ContextPredicateProvider;
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

	private Scope internalScope = null;
	private Scope interfaceScope = null;

	private String statement;
	private String ruleName;
	private S[] scopes;
	private boolean isLinkable;

	public STextScopeProviderTest(String statement, String ruleName, S[] scopes, Boolean isLinkable) {
		this.statement = statement;
		this.ruleName = ruleName;
		this.scopes = scopes;
		this.isLinkable = isLinkable;

		STextInjectorProvider provider = new STextInjectorProvider();
		provider.getInjector().injectMembers(this);
	}

	@Before
	public void setup() {
		internalScope = createInternalScope(INTERNAL_SCOPE);
		interfaceScope = createInterfaceScope(INTERFACE_SCOPE);
	}

	@Test
	public void test() {
		try {
			parseExpression(statement, ruleName, getScopes(scopes));
			if (!isLinkable)
				fail(String.format(
						"Expected not to be linkable [parse '%s' in rule '%s' for scope '%s' expected linkable = '%s']",
						statement, ruleName, scopes, isLinkable));
		} catch (LinkingException e) {
			if (isLinkable)
				fail("Expected linkable but... '" + e.getMessage() + "'");
			else if(e.getMessage().contains("Couldn't resolve reference to EObject"));
		}
	}

	/**
	 * @see {@link ContextPredicateProvider#filter}
	 */
	@Parameters(name = "{index}: parse {0} in rule {1} expected linkable = {3}")
	public static Iterable<Object[]> data1() {
		return Arrays
				.asList(new Object[][]{//
						/* testGuardScopingSuccess */
						{"[e1]", ReactionTrigger.class.getSimpleName(), intn, true}, //
						{"[Interface1.e3]", ReactionTrigger.class.getSimpleName(), intf, true}, //
						{"[e1 && e2]", ReactionTrigger.class.getSimpleName(), intn, true}, //
						{"[e1 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), intn_intf, true}, //
						{"[Interface1.e4 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), intf, true}, //
						/*
						 * filter.put(key(ASSIGNMENT_EXPRESSION),
						 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
						 */
						{"myInt = 0", ReactionEffect.class.getSimpleName(), intn, true}, //
						{"myInt = Interface1.myInt2", ReactionEffect.class.getSimpleName(), intn_intf, true}, //
						{"myInt = myOpp3()", ReactionEffect.class.getSimpleName(), intn, true}, //
						{"myBool = e1", ReactionEffect.class.getSimpleName(), intn, true}, //
						/*
						 * filter.put(key(CONDITIONAL_EXPRESSION),
						 * VARIABLES_AND_OPERATIONS)
						 */
						{"myBool ? myOpp(1) : myOpp(2)", Expression.class.getSimpleName(), intn, true}, //
						{"myOpp4() ? myInt : myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myBool ? e1 : myOpp(2)", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(LOGICAL_OR_EXPRESSION),
						 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
						 */
						{"myInt || Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt || myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt || e1", Expression.class.getSimpleName(), intn, true}, //
						/*
						 * filter.put(key(LOGICAL_AND_EXPRESSION),
						 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
						 */
						{"myInt && Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt && myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt && e1", Expression.class.getSimpleName(), intn, true}, //
						/*
						 * filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES)
						 */
						{"myInt ^ Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"e1 ^ e2", Expression.class.getSimpleName(), intn, false}, //
						{"myOpp1(1) ^ myOpp3()", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES)
						 */
						{"myInt | Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"e1 | e2", Expression.class.getSimpleName(), intn, false}, //
						{"myOpp1(1) | myOpp3()", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES)
						 */
						{"myInt & Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"e1 & e2", Expression.class.getSimpleName(), intn, false}, //
						{"myOpp1(1) & myOpp3()", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(SHIFT_EXPRESSION), VARIABLES)
						 */
						{"myInt << Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt >> Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"e1 >> e2", Expression.class.getSimpleName(), intn, false}, //
						{"e1 >> e2", Expression.class.getSimpleName(), intn, false}, //
						{"myOpp1(1) >> myOpp3()", Expression.class.getSimpleName(), intn, false}, //
						{"myOpp1(1) << myOpp3()", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(LOGICAL_NOT_EXPRESSION),
						 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
						 */
						{"!Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"!myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"!e1", Expression.class.getSimpleName(), intn, true}, //
						/*
						 * filter.put(key(LOGICAL_RELATION_EXPRESSION),
						 * VARIABLES_OPERATIONS_EVENTS_ENUMERATORS)
						 */
						{"myInt < Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt < myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt < e1", Expression.class.getSimpleName(), intn, true}, //
						{"myInt > Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt > myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt > e1", Expression.class.getSimpleName(), intn, true}, //
						{"myInt <= Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt <= myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt <= e1", Expression.class.getSimpleName(), intn, true}, //
						{"myInt >= Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt >= myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt >= e1", Expression.class.getSimpleName(), intn, true}, //
						{"myInt == Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt == myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt == e1", Expression.class.getSimpleName(), intn, true}, //
						{"myInt != Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt != myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myInt != e1", Expression.class.getSimpleName(), intn, true}, //
						/*
						 * filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION),
						 * VARIABLES_AND_OPERATIONS)
						 */
						{"myInt + Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt - Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myOpp3() + myInt", Expression.class.getSimpleName(), intn, true}, //
						{"myInt - myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myOpp3() + myInt", Expression.class.getSimpleName(), intn, true}, //
						{"myOpp3() - myInt", Expression.class.getSimpleName(), intn, true}, //
						{"e1 + e2", Expression.class.getSimpleName(), intn, false}, //
						{"e1 - e2", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION),
						 * VARIABLES_AND_OPERATIONS)
						 */
						{"myInt * Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myInt / Interface1.myInt2", Expression.class.getSimpleName(), intn_intf, true}, //
						{"myOpp3() * myInt", Expression.class.getSimpleName(), intn, true}, //
						{"myInt / myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"myOpp3() * myInt", Expression.class.getSimpleName(), intn, true}, //
						{"e1 * e2", Expression.class.getSimpleName(), intn, false}, //
						{"e1 / e2", Expression.class.getSimpleName(), intn, false}, //
						/*
						 * filter.put(key(NUMERICAL_UNARY_EXPRESSION),
						 * VARIABLES_AND_OPERATIONS)
						 */
						{"-myInt", Expression.class.getSimpleName(), intn, true}, //
						{"+myInt", Expression.class.getSimpleName(), intn, true}, //
						{"-myOpp3()", Expression.class.getSimpleName(), intn, true}, //
						{"+myOpp3()", Expression.class
								.getSimpleName(), intn, true}, //
				{"-e1", Expression.class.getSimpleName(), intn, false}, //
				{"+e1", Expression.class.getSimpleName(), intn, false}, //
				/*
				 * filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS)
				 */
				{"valueof(e2)", Expression.class.getSimpleName(), intn, true}, //
				{"valueof(myInt)", Expression.class.getSimpleName(), intn, false}, //
				{"valueof(myOpp3())", Expression.class.getSimpleName(), intn, false}, //
				/*
				 * filter.put(key(VARIABLE_DEFINITION, TYPED_ELEMENT__TYPE),
				 * TYPES)
				 */
				{"var x : integer", VariableDefinition.class.getSimpleName(), intn, true}, //
				{"var x : e1", VariableDefinition.class.getSimpleName(), intn, false}, //
				/* filter.put(key(REGULAR_EVENT_SPEC), EVENTS) */
				{"e1 / myInt = 0", LocalReaction.class.getSimpleName(), intn, true}, //
				{"myOpp(4) / myInt = 10", LocalReaction.class.getSimpleName(), intn, false}, //
				{"myInt / myInt = 10", LocalReaction.class.getSimpleName(), intn, false}, //
		});
	}
	/** convenience because real scopes will be build after proper injection */
	private enum S {
		INTERNAL, INTERFACE;

		@Override
		public String toString() {
			switch (this) {
				case INTERNAL :
					return "INTERNAL";
				case INTERFACE :
					return "INTERFACE";
				default :
					return "UNKNOWN";
			}
		}
	}
	private final static S[] intn = new S[]{S.INTERNAL};
	private final static S[] intf = new S[]{S.INTERFACE};
	private final static S[] intn_intf = new S[]{S.INTERNAL, S.INTERFACE};

	private Scope[] getScopes(S[] scopes) {
		Scope[] newArrayList = new Scope[scopes.length];
		for (int i = 0; i < newArrayList.length; i++) {
			switch (scopes[i]) {
				case INTERFACE :
					newArrayList[i] = interfaceScope;
					break;
				case INTERNAL :
					newArrayList[i] = internalScope;
					break;
				default :
					throw new IllegalArgumentException("unsupported scope");
			}
		}
		return newArrayList;
	}
}
