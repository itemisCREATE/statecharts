/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext.builder.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.injectors.StextInjectorProvider;
import org.yakindu.sct.simulation.runtime.stext.RTScope;
import org.yakindu.sct.simulation.runtime.stext.RTStatement;
import org.yakindu.sct.simulation.runtime.stext.StatementSequence;
import org.yakindu.sct.simulation.runtime.stext.RTVariable;
import org.yakindu.sct.simulation.runtime.stext.builder.BuilderException;
import org.yakindu.sct.simulation.runtime.stext.builder.STextBuilder;

import com.google.inject.Inject;

/**
 * 
 * @author axel terfloth
 * @author andreas muelder
 * 
 */

@RunWith(XtextRunner.class)
@InjectWith(StextInjectorProvider.class)
public class STextBuilderTest {

	private static class RuntimeTestScope extends RTScope {

		public List<String> trace = new ArrayList<String>();
		public String called;
		public String raised;

		@Override
		public RTVariable getVariable(String varName) {
			trace.add("var:" + varName);
			return super.getVariable(varName);
		}

		@Override
		public void call(String procedureId) {
			trace.add("call:" + procedureId);
			super.call(procedureId);
			called = procedureId;
		}

		@Override
		public void raise(String signal) {
			trace.add("raise:" + signal);
			super.raise(signal);
			raised = signal;
		}

	}

	protected RuntimeTestScope scope;
	
	@Inject
	protected IParser parser;
	@Inject
	protected ILinker linker;
	@Inject
	protected XtextResource resource;

	private STextBuilder expressionBuilder;

	@Before
	public void setUp() throws Exception {
		scope = new RuntimeTestScope();
		expressionBuilder = new STextBuilder();
		resource.setURI(URI
				.createURI("platform:/resource/testProject/embedded.stext"));
	}

	private EObject parseExpression(String expression, Scope context,
			String ruleName) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(
				expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		if (context != null)
			resource.getContents().add(context);
		linker.linkModel(result.getRootASTElement(),
				new ListBasedDiagnosticConsumer());
		if (result.hasSyntaxErrors()) {
			StringBuilder errorMessages = new StringBuilder();
			Iterable<INode> syntaxErrors = result.getSyntaxErrors();
			for (INode iNode : syntaxErrors) {
				errorMessages.append(iNode.getSyntaxErrorMessage());
				errorMessages.append("\n");
			}
			throw new RuntimeException(
					"Could not parse expression, syntax errors: "
							+ errorMessages);
		}
		return rootASTElement;
	}

	protected Scope createContextScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("SimpleScope");
		IParseResult result = parser.parse(parserRule, new StringReader(
				contextScope));
		return (Scope) result.getRootASTElement();
	}

	protected RTStatement parseReactionEffect(String expression) {
		Scope defaultScope = createContextScope("event abc operation foo() var a : integer");
		EObject rootElement = parseExpression(expression, defaultScope,
				"ReactionEffect");
		return (RTStatement) expressionBuilder.build(rootElement);
	}

	@Test
	public void testInvalidAction() {
		try {
			RTStatement stmt = parseReactionEffect("1");
			assertNull(stmt);
			fail("Exception expected !");
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void testRaise() {

		RTStatement stmt = parseReactionEffect("raise abc;");

		assertNotNull(stmt);
		assertTrue(stmt instanceof StatementSequence);
		assertEquals(1, ((StatementSequence) stmt).size());

		stmt.execute(scope);
		assertEquals("abc", scope.raised);
	}

	@Test
	public void testProcedureCall() {
		RTStatement stmt = parseReactionEffect("foo();");

		assertNotNull(stmt);
		assertTrue(stmt instanceof StatementSequence);
		assertEquals(1, ((StatementSequence) stmt).size());

		stmt.execute(scope);
		assertEquals("foo", scope.called);
	}

	@Test
	public void testMultiStatement() {

		RTStatement stmt = parseReactionEffect("raise abc;foo();");

		assertNotNull(stmt);
		assertTrue(stmt instanceof StatementSequence);

		assertEquals(2, ((StatementSequence) stmt).size());

		stmt.execute(scope);
		assertEquals("abc", scope.raised);
		assertEquals("foo", scope.called);
	}

	@Test
	public void testIntVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = 42;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}

	@Test
	public void testHexVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = 0xFF;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0xFF, scope.getValue("a"));
	}

	@Test
	public void testBoolTrueVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = true;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testBoolFalseVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = false;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(false, scope.getValue("a"));
	}

	@Test
	public void testFloatVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = 42.0;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42.0f, scope.getValue("a"));
	}

	@Test
	public void testStringVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = \"fortytwo\";");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals("fortytwo", scope.getValue("a"));
	}

	@Test
	public void testIntStringVariableAssignment() {
		RTStatement stmt = parseReactionEffect("a = \"42\";");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals("42", scope.getValue("a"));
	}

	@Test
	public void testConditionalTrue() {
		RTStatement stmt = parseReactionEffect("a = true ? 42 : 1;");
		assertNotNull(stmt);

		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}

	@Test
	public void testConditionalFalse() {
		RTStatement stmt = parseReactionEffect("a = false ? 42 : 1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(1, scope.getValue("a"));
	}

	@Test
	public void testBooleanOr() {
		RTStatement stmt = parseReactionEffect("a = true || false;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testBooleanAnd() {
		RTStatement stmt = parseReactionEffect("a = true && false;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(false, scope.getValue("a"));
	}

	@Test
	public void testBitwiseXor() {
		RTStatement stmt = parseReactionEffect("a = 0xF0F0 ^ 0xFF00;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0x0FF0, scope.getValue("a"));
	}

	@Test
	public void testBitwiseOr() {
		RTStatement stmt = parseReactionEffect("a = 0xF0F0 | 0xFFFF;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0xFFFF, scope.getValue("a"));
	}

	@Test
	public void testBitwiseAnd() {
		RTStatement stmt = parseReactionEffect("a = 0xF0F0 & 0xFFFF;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0x0F0F0, scope.getValue("a"));
	}

	@Test
	public void testBoolEqual() {
		RTStatement stmt = parseReactionEffect("a = false == false;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntEqual() {
		RTStatement stmt = parseReactionEffect("a = 1 == 1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testFloatEqual() {
		RTStatement stmt = parseReactionEffect("a = 1.0f == 1.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);
		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testBoolNotEqual() {
		RTStatement stmt = parseReactionEffect("a = true != false;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntNotEqual() {
		RTStatement stmt = parseReactionEffect("a = 1 != 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testFloatNotEqual() {
		RTStatement stmt = parseReactionEffect("a = 1.0f != 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntGreaterEqual() {
		RTStatement stmt = parseReactionEffect("a = 2 >= 1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testFloatGreaterEqual() {
		RTStatement stmt = parseReactionEffect("a = 2.0f >= 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntSmallerEqual() {
		RTStatement stmt = parseReactionEffect("a = 1 <= 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testFloatSmallerEqual() {
		RTStatement stmt = parseReactionEffect("a = 2.0f <= 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntGreater() {
		RTStatement stmt = parseReactionEffect("a = 2 > 1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testFloatGreater() {
		RTStatement stmt = parseReactionEffect("a = 2.1f > 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntSmaller() {
		RTStatement stmt = parseReactionEffect("a = 1 < 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testFloatSmaller() {
		RTStatement stmt = parseReactionEffect("a = 2.0f < 2.1f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	@Test
	public void testIntPositive() {
		RTStatement stmt = parseReactionEffect("a = +1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(1, scope.getValue("a"));
	}

	@Test
	public void testFloatPositive() {
		RTStatement stmt = parseReactionEffect("a = +1.0;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(1.0f, scope.getValue("a"));
	}

	@Test
	public void testIntNegative() {
		RTStatement stmt = parseReactionEffect("a = -1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(-1, scope.getValue("a"));
	}

	@Test
	public void testFloatNegative() {
		RTStatement stmt = parseReactionEffect("a = -1.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(-1.0f, scope.getValue("a"));
	}

	@Test
	public void testIntPlus() {
		RTStatement stmt = parseReactionEffect("a = 42 + 1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(43, scope.getValue("a"));
	}

	@Test
	public void testFloatPlus() {
		RTStatement stmt = parseReactionEffect("a = 42.0 + 1.0;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(43.0f, scope.getValue("a"));
	}

	@Test
	public void testIntMinus() {
		RTStatement stmt = parseReactionEffect("a = 42 - 1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(41, scope.getValue("a"));
	}

	@Test
	public void testFloatMinus() {
		RTStatement stmt = parseReactionEffect("a = 42.0f - 1.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(41.0f, scope.getValue("a"));
	}

	@Test
	public void testIntMultiply() {
		RTStatement stmt = parseReactionEffect("a = 42 * 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(84, scope.getValue("a"));
	}

	@Test
	public void testFloatMultiply() {
		RTStatement stmt = parseReactionEffect("a = 42.0f * 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(84.0f, scope.getValue("a"));
	}

	@Test
	public void testIntDivide() {
		RTStatement stmt = parseReactionEffect("a = 42 / 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(21, scope.getValue("a"));
	}

	@Test
	public void testFloatDivide() {
		RTStatement stmt = parseReactionEffect("a = 42.0f / 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(21.0f, scope.getValue("a"));
	}

	@Test
	public void testIntModulo() {
		RTStatement stmt = parseReactionEffect("a = 42 % 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0, scope.getValue("a"));
	}

	@Test
	public void testFloatModulo() {
		RTStatement stmt = parseReactionEffect("a = 42.0f % 2.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0.0f, scope.getValue("a"));
	}

	@Test
	public void testIntLeft() {
		RTStatement stmt = parseReactionEffect("a = 42 << 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(168, scope.getValue("a"));
	}

	@Test
	public void testFloatLeft() {
		try {
			RTStatement stmt = parseReactionEffect("a = 42.0f << 2.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntRight() {
		RTStatement stmt = parseReactionEffect("a = 42 >> 2;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(10, scope.getValue("a"));
	}

	@Test
	public void testFloatRight() {
		try {
			RTStatement stmt = parseReactionEffect("a = 42.0f >> 2.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntAnd() {
		RTStatement stmt = parseReactionEffect("a= 9 & 12;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(8, scope.getValue("a"));
	}

	@Test
	public void testFloatAnd() {
		try {
			RTStatement stmt = parseReactionEffect("a= 9.0f & 12.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(8.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntXor() {
		RTStatement stmt = parseReactionEffect("a= 9 ^ 12;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(5, scope.getValue("a"));
	}

	@Test
	public void testFloatXor() {
		try {
			RTStatement stmt = parseReactionEffect("a= 9.0f ^ 12.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(5.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntOr() {
		RTStatement stmt = parseReactionEffect("a= 9 | 12;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(13, scope.getValue("a"));
	}

	@Test
	public void testFloatOr() {
		try {
			RTStatement stmt = parseReactionEffect("a= 9.0f | 12.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(13.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntBitComplement() {
		RTStatement stmt = parseReactionEffect("a= ~9;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(-10, scope.getValue("a"));
	}

	@Test
	public void testFloatBitComplement() {
		try {
			RTStatement stmt = parseReactionEffect("a= ~9.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(-10.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testNot() {
		RTStatement stmt = parseReactionEffect("a = ! true;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(false, scope.getValue("a"));
	}

	@Test
	public void testPrirority() {
		RTStatement stmt = parseReactionEffect("a = 1 + 2 * 3;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(7, scope.getValue("a"));
	}

	@Test
	public void testNested() {
		RTStatement stmt = parseReactionEffect("a = (1 + 2) * 3;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(9, scope.getValue("a"));
	}

	@Test
	public void testIntPlusAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a+=42;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(84, scope.getValue("a"));
	}

	@Test
	public void testFloatPlusAssign() {
		RTStatement stmt = parseReactionEffect("a=42.0; a+=42.0;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(84.0f, scope.getValue("a"));
	}

	@Test
	public void testIntMinusAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a-=10;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(32, scope.getValue("a"));
	}

	@Test
	public void testFloatMinusAssign() {
		RTStatement stmt = parseReactionEffect("a=42.0f; a-=10.0;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(32.0f, scope.getValue("a"));
	}

	@Test
	public void testIntMultAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a*=1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}

	@Test
	public void testFloatMultAssign() {
		RTStatement stmt = parseReactionEffect("a=42.0f; a*=1.0;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42.0f, scope.getValue("a"));
	}

	@Test
	public void testIntDivAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a/=1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}

	@Test
	public void testFloatDivAssign() {
		RTStatement stmt = parseReactionEffect("a=42.0f; a/=1.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(42.0f, scope.getValue("a"));
	}

	@Test
	public void testIntModAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a%=1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0, scope.getValue("a"));
	}

	@Test
	public void testFloatModAssign() {
		RTStatement stmt = parseReactionEffect("a=42.0f; a%=1.0f;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(0.0f, scope.getValue("a"));
	}

	@Test
	public void testIntLeftAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a<<=1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(84, scope.getValue("a"));
	}

	@Test
	public void testFloatLeftAssign() {
		try {
			RTStatement stmt = parseReactionEffect("a=42.0f; a<<=1.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntRightAssign() {
		RTStatement stmt = parseReactionEffect("a=42; a>>=1;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(21, scope.getValue("a"));
	}

	@Test
	public void testFloatRightAssign() {
		try {
			RTStatement stmt = parseReactionEffect("a=42.0f; a>>=1.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntAndAssign() {
		RTStatement stmt = parseReactionEffect("a=9; a&=12;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(8, scope.getValue("a"));
	}

	@Test
	public void testFloatAndAssign() {
		try {
			RTStatement stmt = parseReactionEffect("a=42.0f; a&=1.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntXorAssign() {
		RTStatement stmt = parseReactionEffect("a=9; a^=12;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(5, scope.getValue("a"));
	}

	@Test
	public void testFloatXorAssign() {
		try {
			RTStatement stmt = parseReactionEffect("a=42.0f; a^=1.0f;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testIntOrAssign() {
		RTStatement stmt = parseReactionEffect("a=9; a|=12;");
		scope.addVariable(new RTVariable("a"));
		stmt.execute(scope);

		assertEquals(13, scope.getValue("a"));
	}

	@Test
	public void testFloatOrAssign() {
		try {
			RTStatement stmt = parseReactionEffect("a=42.0; a|=1.0;");
			scope.addVariable(new RTVariable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	/**
	 * If there is no builder method for the eClass of an EObject then a
	 * BuilderException must be raised.
	 */
	@Test
	public void testBuildFromUnknownEClass() {

		class TestBuilder extends STextBuilder {
			public Object testBuild(EObject obj) {
				return build(obj);
			}
		}
		;

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Bla");

		DynamicEObjectImpl eObj = new DynamicEObjectImpl(eClass);

		TestBuilder builder = new TestBuilder();

		try {
			builder.testBuild(eObj);

			fail("BuilderException expected!");
		} catch (BuilderException e) {
		}
	}

//	public void testSimpleGuardExpression() {
//		RTExpression expr = buildGuardWithDefaultScope("true");
//		assertEquals(true, expr.execute(scope));
//	}

	// @Test
	// public void testGuardExpression() {
	// RTExpression expr = buildGuardWithDefaultScope("(a % 3) != 0");
	// scope.addVariable(new Variable("a"));
	//
	// scope.getVariable("a").setValue(1);
	// assertEquals(true, expr.execute(scope));
	//
	// scope.getVariable("a").setValue(3);
	// assertEquals(false, expr.execute(scope));
	// }
	//
	// @Test
	// public void testTriggerExpression() {
	// List<RTTrigger> triggers = ExpressionBuilder
	// .buildTriggers("e1, after(100), e2");
	//
	// assertEquals(3, triggers.size());
	//
	// assertTrue(triggers.get(0) instanceof RTTrigger.SignalEvent);
	// assertEquals("e1",
	// ((RTTrigger.SignalEvent) triggers.get(0)).getSignal());
	//
	// assertTrue(triggers.get(1) instanceof RTTrigger.TimeEvent);
	// assertTrue(((RTTrigger.TimeEvent) triggers.get(1)).getDurationExp()
	// instanceof Constant);
	//
	// assertEquals("e2",
	// ((RTTrigger.SignalEvent) triggers.get(2)).getSignal());
	// assertTrue(triggers.get(2) instanceof RTTrigger.SignalEvent);
	// }
	//
	// @Test
	// public void testTimeTrigger() {
	// List<RTTrigger> triggers = ExpressionBuilder.buildTriggers("after(x)");
	//
	// assertEquals(1, triggers.size());
	//
	// assertTrue(triggers.get(0) instanceof RTTrigger.TimeEvent);
	// assertTrue(((RTTrigger.TimeEvent) triggers.get(0)).getDurationExp()
	// instanceof VariableRef);
	// }
}
