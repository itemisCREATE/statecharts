/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.expressions.STextExpressionParser.SyntaxException;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionReaction;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class StextParserRuleTest extends AbstractSTextTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testBoolLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("true", rule);
		parseExpression("false", rule);
		parseExpression("yes", rule);
		parseExpression("no", rule);
	}

	@Test
	public void testIntLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("0", rule);
		parseExpression("4", rule);
		parseExpression("42", rule);
	}

	@Test
	public void testHexLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("0xFFB5C5", rule);
		parseExpression("0XFFB5C5", rule);
	}

	@Test
	public void testBinaryLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("0b1101101", rule);
		parseExpression("0B1110001", rule);
	}

	@Test
	public void testRealLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("0.2f", rule);
		parseExpression("0.2F", rule);
		parseExpression("0.2d", rule);
		parseExpression("0.2D", rule);
	}

	@Test
	public void testStringLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("'Hello World'", rule);
		parseExpression("\"Hello World\"", rule);
		parseExpression("''", rule);
	}

	@Test
	public void testNullLiteral() {
		String rule = PrimitiveValueExpression.class.getSimpleName();
		parseExpression("null", rule);
	}

	/**
	 * VariableDefinition: {VariableDefinition} 'var' ((readonly?='readonly')?) 
	 * name=ID ':' type=[types::Type|FQN] ('='
	 * initialValue=Expression)?;
	 */
	@Test
	public void testVariableDefinition() {
		String rule = VariableDefinition.class.getSimpleName();
		parseExpression("var MyVar : integer", rule);
		parseExpression("var MyVar : integer = 97", rule);
		parseExpression("var readonly MyVar : integer", rule);
		parseExpression("var MyVar : integer = 3 * 3", rule);
		parseExpression("var MyVar : string = null", rule);
	}

	/**
	 * EventDefinition: (direction=Direction)? 'event' name=ID (':'
	 * type=[types::Type|FQN])? (derivation=EventDerivation)?;
	 */
	@Test
	public void testEventDefinition() {
		String rule = EventDefinition.class.getSimpleName();
		parseExpression("event event1", rule);
		parseExpression("event event1 : integer", rule);
		parseExpression("event event1 : boolean", rule);
		parseExpression("in event event1 : integer", rule);
		parseExpression("out event event1 : integer", rule);
		parseExpression("event event1 : integer", rule);
		parseExpression("event event1 : string", rule);

	}

	/**
	 * OperationDefinition: {OperationDefinition} 'operation' name=ID '('
	 * (parameters+=Parameter (',' parameters+=Parameter)*)? ')' (':'
	 * type=[types::Type|FQN])?;
	 */
	@Test
	public void testOperationDefinition() {
		String rule = OperationDefinition.class.getSimpleName();
		parseExpression("operation myOpp()", rule);
		parseExpression("operation myOpp() : boolean", rule);
		parseExpression("operation myOpp(param1: integer)", rule);
		parseExpression("operation myOpp(param1 : boolean) : integer", rule);
		parseExpression("operation myOpp(param1 : boolean, param2 : real) : integer", rule);
		parseExpression("operation myOpp(param1 : real, param2 : real) : integer", rule);
	}

	/**
	 * {ReactionTrigger} ((triggers+=EventSpec ("," triggers+=EventSpec)* (=> '['
	 * guardExpression=Expression ']')?) | ('[' guardExpression=Expression ']'));
	 */
	@Test
	public void testReactionTrigger() {
		String rule = ReactionTrigger.class.getSimpleName();
		// Internal Scope
		parseExpression("intEvent", rule, internalScope());
		parseExpression("after 10 s", rule);
		parseExpression("after 10 ms", rule);
		parseExpression("after 10 us", rule);
		parseExpression("after 10 ns", rule);
		parseExpression("every 10 ns", rule);
		parseExpression("entry", rule);
		parseExpression("exit", rule);
		parseExpression("oncycle", rule);
		parseExpression("always", rule);
		parseExpression("intEvent, after 10s", rule, internalScope());
		parseExpression("intEvent, after 10s, every 10 ms", rule, internalScope());
		parseExpression("intEvent, after 10s [false == true]", rule, internalScope());
		parseExpression("intEvent, after 10s ['' != null]", rule, internalScope());
		parseExpression("intEvent, after 10s [5  > 10]", rule, internalScope());
		parseExpression("ABC.intEvent", rule, interfaceScope());
	}

	/**
	 * DefaultTrigger returns sgraph::Trigger: {DefaultTrigger} ('default' | 'else')
	 * ;
	 */
	@Test
	public void testDefaultTrigger() {
		String rule = DefaultTrigger.class.getSimpleName();
		// Internal Scope
		parseExpression("default", rule);
		parseExpression("else", rule);
	}

	/**
	 * ReactionEffect returns sgraph::Effect: {ReactionEffect} actions+=(Expression
	 * | EventRaisingExpression) (=> ';'
	 * actions+=(Expression|EventRaisingExpression) )* ; // (';')?;
	 */
	@Test
	public void testReactionEffect() {
		String rule = ReactionEffect.class.getSimpleName();
		parseExpression("raise intEvent", rule, internalScope());
		parseExpression("intVar = 5", rule, internalScope());
		parseExpression("voidOp()", rule, internalScope());
		parseExpression("intVar = intOp()", rule, internalScope());

		parseExpression("raise ABC.intEvent : 5", rule, interfaceScope());
		parseExpression("ABC.paramOp()", rule, interfaceScope());
		parseExpression("ABC.paramOp(5,false)", rule, interfaceScope());
		parseExpression("ABC.paramOp(null)", rule, interfaceScope());
		parseExpression("ABC.paramOp(); raise ABC.voidEvent ", rule, interfaceScope());

	}

	/**
	 * TransitionReaction: {TransitionReaction} (trigger=StextTrigger)? ('/'
	 * effect=ReactionEffect)? ('#' (properties+=TransitionProperty)*)?;
	 * 
	 */
	@Test
	public void testReactionProperties() {
		String rule = TransitionReaction.class.getSimpleName();
		parseExpression("# > EntryPoint", rule, interfaceScope());
		parseExpression("# ExitPoint >", rule, interfaceScope());
	}

	/**
	 * LocalReaction: (trigger=ReactionTrigger) =>('/' effect=ReactionEffect) ('#'
	 * properties=ReactionProperties)?;
	 */
	@Test
	public void tesLocalReaction() {
		String rule = LocalReaction.class.getSimpleName();
		parseExpression("entry [ABC.intVar > 10] / raise ABC.intEvent", rule, interfaceScope());
	}

	/**
	 * TransitionReaction: {TransitionReaction} (trigger=ReactionTrigger)? ('/'
	 * effect=ReactionEffect)? ('#' properties=ReactionProperties)?;
	 */
	@Test
	public void testTransitionReaction() {
		String rule = TransitionReaction.class.getSimpleName();
		parseExpression("after 10 s / raise ABC.intEvent", rule, interfaceScope());
	}

	/**
	 * {InterfaceScope} 'interface' (name=ID)? ':' (declarations+=(EventDeclarartion
	 * | VariableDeclaration | OperationDeclaration | Entrypoint | Exitpoint))*;
	 */
	@Test
	public void testInterfaceScope() {
		String rule = InterfaceScope.class.getSimpleName();
		parseExpression("interface :", rule);
		parseExpression("interface ABC:", rule);
		parseExpression("interface : in event Event1", rule);
		parseExpression("interface ABC : var myVar : integer", rule);
		parseExpression("interface : operation myOpp()", rule);
	}

	/**
	 * InternalScope : {InternalScope} 'internal' ':'
	 * (declarations+=(EventDeclarartion | VariableDeclaration |
	 * OperationDeclaration | LocalReaction))*;
	 */
	@Test
	public void testInternalScope() {
		String rule = InternalScope.class.getSimpleName();
		parseExpression("internal :", rule);
		parseExpression("internal : event voidEvent", rule);
		parseExpression("internal : var intVar : integer", rule);
		parseExpression("internal : operation voidOp()", rule);
		parseExpression("internal : every 10 ms / raise intEvent", rule, internalScope());
	}

	/**
	 * StateScope returns sgraph::Scope: {SimpleScope} (declarations+=(LocalReaction
	 * | Entrypoint | Exitpoint))*;
	 */
	@Test
	public void testStateScope() {

	}

	/**
	 * EventDefinition: (direction=Direction)? 'event' name=(ID | Keywords) (':'
	 * typeSpecifier=TypeSpecifier)?;
	 */
	@Test
	public void testInvalidEventNamesUsed() {
		String scope;
		List<String> invalidEventNames = Arrays
				.asList(new String[] { "after", "always", "oncycle", "exit", "entry", "every" });
		for (String name : invalidEventNames) {
			scope = "interface: in event " + name;
			boolean thrown = false;
			try {
				parseExpression(scope, StatechartSpecification.class.getSimpleName());
			} catch (SyntaxException ex) {
				thrown = true;
			}
			assertTrue(thrown);
		}
	}

	/**
	 * EventDefinition: (direction=Direction)? 'event' name=(ID | Keywords) (':'
	 * typeSpecifier=TypeSpecifier)?;
	 * 
	 */
	public void testValidEventNamesUsed() {
		String scope;
		List<String> validEventNames = Arrays.asList(
				new String[] { "namespace", "interface", "internal", "import", "event", "local", "in", "out", "const",
						"var", "readonly", "operation", "default", "else", "raise", "valueof", "active" });
		for (String name : validEventNames) {
			scope = "interface: in event " + name;
			parseExpression(scope, StatechartSpecification.class.getSimpleName());
		}
	}

}
