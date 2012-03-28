/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test;

import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.validation.ErrorAcceptor;
import org.yakindu.sct.model.stext.validation.ITypeAnalyzer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class StaticTypeAnalyzerTest {

	@Inject
	private ITypeAnalyzer analyzer;
	@Inject
	IParser parser;
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		analyzer.setErrorAcceptor(new ErrorAcceptor());
	}

	// Unary
	@Test
	public void testUnarySuccess() {
		// int
		assertTrue(analyzer.isInteger(inferType("1")));
		assertTrue(analyzer.isInteger(inferType("-1")));
		assertTrue(analyzer.isInteger(inferType("0")));
		// real
		assertTrue(analyzer.isReal(inferType("1.0")));
		assertTrue(analyzer.isReal(inferType("-1.0")));
		assertTrue(analyzer.isReal(inferType("0.0")));
		// string
		assertTrue(analyzer.isString(inferType("'42'")));
		// boolean
		assertTrue(analyzer.isBoolean(inferType("true")));
		assertTrue(analyzer.isBoolean(inferType("false")));
	}

	// Add
	@Test
	public void testAddSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 + 2")));
		assertTrue(analyzer.isReal(inferType("1.0 + 2")));
		assertTrue(analyzer.isReal(inferType("2 + 1.0")));
		assertTrue(analyzer.isInteger(inferType("1 + 2 + 3.0")));
	}

	@Test
	public void testAddException1() {
		expectOperatorPlusException();
		inferType("true + 5");
	}

	@Test
	public void testAddException2() {
		expectOperatorPlusException();
		inferType("false + 5");
	}

	@Test
	public void testAddException3() {
		expectOperatorPlusException();
		inferType("5 + false");
	}

	@Test
	public void testAddException4() {
		expectOperatorPlusException();
		inferType("true + (3 * 5)");
	}

	@Test
	public void testAddException5() {
		expectOperatorPlusException();
		inferType("(3 * 5) + true");
	}

	@Test
	public void testAddException6() {
		expectOperatorPlusException();
		inferType("3.0 +  true");
	}

	@Test
	public void testAddException7() {
		expectOperatorPlusException();
		inferType("3.0 + 'string'");
	}

	// substract
	@Test
	public void testSubstractSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 - 2")));
		assertTrue(analyzer.isReal(inferType("1.0 - 2")));
		assertTrue(analyzer.isReal(inferType("2 - 1.0")));
		assertTrue(analyzer.isInteger(inferType("1 - 2 - 3.0")));
	}

	@Test
	public void testSubstractException1() {
		expectOperatorSubstractException();
		inferType("true - 5");
	}

	@Test
	public void testSubstractException2() {
		expectOperatorSubstractException();
		inferType("false - 5");
	}

	@Test
	public void testSubstractException3() {
		expectOperatorSubstractException();
		inferType("5 - false");
	}

	@Test
	public void testSubstractException4() {
		expectOperatorSubstractException();
		inferType("true - (3 * 5)");
	}

	@Test
	public void testSubstractException5() {
		expectOperatorSubstractException();
		inferType("(3 * 5) - true");
	}

	@Test
	public void testSubstractException6() {
		expectOperatorSubstractException();
		inferType("3.0 -  true");
	}

	@Test
	public void testSubstractException7() {
		expectOperatorSubstractException();
		inferType("3.0 -  'string'");
	}

	// multiply
	@Test
	public void testMultiplySuccess() {
		assertTrue(analyzer.isInteger(inferType("1 * 2")));
		assertTrue(analyzer.isReal(inferType("1.0 * 2")));
		assertTrue(analyzer.isReal(inferType("2 * 1.0")));
		assertTrue(analyzer.isInteger(inferType("1 * 2 * 3.0")));
	}

	@Test
	public void testMultiplyException1() {
		expectOperatorMultiplyException();
		inferType("true * 5");
	}

	@Test
	public void testMultiplyException2() {
		expectOperatorMultiplyException();
		inferType("false * 5");
	}

	@Test
	public void testMultiplyException3() {
		expectOperatorMultiplyException();
		inferType("5 * false");
	}

	@Test
	public void testMultiplyException4() {
		expectOperatorMultiplyException();
		inferType("true * (3 - 5)");
	}

	@Test
	public void testMultiplyException5() {
		expectOperatorMultiplyException();
		inferType("(3 + 5) * true");
	}

	@Test
	public void testMultiplyException6() {
		expectOperatorMultiplyException();
		inferType("3.0 *  true");
	}

	@Test
	public void testMultiplyException7() {
		expectOperatorMultiplyException();
		inferType("3.0 *  'string'");
	}

	// divide
	@Test
	public void testDivideSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 / 2")));
		assertTrue(analyzer.isReal(inferType("1.0 / 2")));
		assertTrue(analyzer.isReal(inferType("2 / 1.0")));
		assertTrue(analyzer.isInteger(inferType("1 / 2 / 3.0")));
	}

	@Test
	public void testDivideException1() {
		expectOperatorDivideException();
		inferType("true / 5");
	}

	@Test
	public void testDivideException2() {
		expectOperatorDivideException();
		inferType("false / 5");
	}

	@Test
	public void testDivideException3() {
		expectOperatorDivideException();
		inferType("5 / false");
	}

	@Test
	public void testDivideException4() {
		expectOperatorDivideException();
		inferType("true / (3 - 5)");
	}

	@Test
	public void testDivideException5() {
		expectOperatorDivideException();
		inferType("(3 + 5) / true");
	}

	@Test
	public void testDivideException6() {
		expectOperatorDivideException();
		inferType("3.0 /  true");
	}

	@Test
	public void testDivideException7() {
		expectOperatorDivideException();
		inferType("3.0 /  'string'");
	}

	// mod
	@Test
	public void testModSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 % 2")));
		assertTrue(analyzer.isReal(inferType("1.0 % 2")));
		assertTrue(analyzer.isReal(inferType("2 % 1.0")));
		assertTrue(analyzer.isInteger(inferType("1 % 2 % 3.0")));
	}

	@Test
	public void testModException1() {
		expectOperatorModException();
		inferType("true % 5");
	}

	@Test
	public void testModException2() {
		expectOperatorModException();
		inferType("false % 5");
	}

	@Test
	public void testModException3() {
		expectOperatorModException();
		inferType("5 % false");
	}

	@Test
	public void testModException4() {
		expectOperatorModException();
		inferType("true % (3 - 5)");
	}

	@Test
	public void testModException5() {
		expectOperatorModException();
		inferType("(3 + 5) % true");
	}

	@Test
	public void testModException6() {
		expectOperatorModException();
		inferType("3.0 % true");
	}

	@Test
	public void testModException7() {
		expectOperatorModException();
		inferType("3.0 % 'string'");
	}

	// Logical And Or Not
	@Test
	public void testLogicalSuccess() {
		assertTrue(analyzer.isBoolean(inferType("true || false")));
		assertTrue(analyzer.isBoolean(inferType("true || false && true")));
		assertTrue(analyzer
				.isBoolean(inferType("true || true &&( false || true)")));
		assertTrue(analyzer.isBoolean(inferType("!true")));
		assertTrue(analyzer.isBoolean(inferType("!true && !false")));
	}

	@Test
	public void testLogicalException1() {
		expectLogicalAndException();
		inferType("true && 5");
	}

	@Test
	public void testLogicalException2() {
		expectLogicalOrException();
		inferType("false || 5");
	}

	@Test
	public void testLogicalException3() {
		expectLogicalAndException();
		inferType("5 && false");
	}

	@Test
	public void testLogicalException4() {
		expectLogicalAndException();
		inferType("true && (3 - 5)");
	}

	@Test
	public void testLogicalException5() {
		expectLogicalOrException();
		inferType("(3 + 5) || true");
	}

	@Test
	public void testLogicalException6() {
		expectLogicalAndException();
		inferType("3.0 &&  true");
	}

	@Test
	public void testLogicalException7() {
		expectLogicalNotException();
		inferType("!3");
	}

	@Test
	public void testLogicalException8() {
		expectLogicalNotException();
		inferType("!1.2");
	}

	@Test
	public void testLogicalException9() {
		expectLogicalNotException();
		inferType("!'Test'");
	}

	// LogicalRelation 
	@Test
	public void testLogicalRelationSuccess() {
		assertTrue(analyzer.isBoolean(inferType("5 < 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 < 3")));

		assertTrue(analyzer.isBoolean(inferType("5 <= 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 <= 3")));

		assertTrue(analyzer.isBoolean(inferType("5 > 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 >= 3")));

		assertTrue(analyzer.isBoolean(inferType("5 == 3")));
		assertTrue(analyzer.isBoolean(inferType("'string' == 'string'")));
		assertTrue(analyzer.isBoolean(inferType("5.0 == 3")));
		assertTrue(analyzer.isBoolean(inferType("true == false")));

		assertTrue(analyzer.isBoolean(inferType("5 != 3")));
		assertTrue(analyzer.isBoolean(inferType("'string' != 'string'")));
		assertTrue(analyzer.isBoolean(inferType("5.0 != 3")));
		assertTrue(analyzer.isBoolean(inferType("true != false")));
	}

	@Test
	public void testLogicalRelationSmallerException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		inferType("3.0 < true");
	}

	@Test
	public void testLogicalRelationSmallerException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '<'");
		inferType("'string' < 5");
	}

	@Test
	public void testLogicalRelationSmallerException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		inferType("1.0 < false");
	}

	@Test
	public void testLogicalRelationSmallerEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		inferType("3.0 <= true");
	}

	@Test
	public void testLogicalRelationSmallerEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '<='");
		inferType("'string' <= 5");
	}

	@Test
	public void testLogicalRelationSmallerEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		inferType("1.0 <= false");
	}

	@Test
	public void testLogicalRelationGreaterException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>'");
		inferType("3.0 > true");
	}

	@Test
	public void testLogicalRelationGreaterException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '>'");
		inferType("'string' > 5");
	}

	@Test
	public void testLogicalRelationGreaterException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>'");
		inferType("1.0 > false");
	}

	@Test
	public void testLogicalRelationGreaterEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>='");
		inferType("3.0 >= true");
	}

	@Test
	public void testLogicalRelationGreaterEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '>='");
		inferType("'string' >= 5");
	}

	@Test
	public void testLogicalRelationGreaterEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>='");
		inferType("1.0 >= false");
	}

	@Test
	public void testLogicalRelationEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '=='");
		inferType("3.0 == true");
	}

	@Test
	public void testLogicalRelationEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '=='");
		inferType("'string' == 5");
	}

	@Test
	public void testLogicalRelationEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '=='");
		inferType("1.0 == false");
	}

	@Test
	public void testLogicalRelationNotEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '!='");
		inferType("3.0 != true");
	}

	@Test
	public void testLogicalRelationNotEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '!='");
		inferType("'string' != 5");
	}

	@Test
	public void testLogicalRelationNotEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '!='");
		inferType("1.0 != false");
	}

	@Test
	public void testComplexExpressionsSuccess() {
		analyzer.isBoolean(inferType("((((3 * 7) + 5) % 2) > 97) || false"));
		analyzer.isBoolean(inferType("!true != false && (3 > (7 * 5 + 3))"));
	}

	// TODO: BitwiseOrExpression, BitwiseAndExpression, BitwiseXOrExpression

	/**
	 * Convenience from here...
	 */
	private void expectOperatorPlusException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '+' can only be applied to numbers!");
	}

	private void expectOperatorSubstractException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '-' can only be applied to numbers!");
	}

	private void expectOperatorMultiplyException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '*' can only be applied to numbers!");
	}

	private void expectOperatorDivideException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '/' can only be applied to numbers!");
	}

	private void expectOperatorModException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '%' can only be applied to numbers!");
	}

	private void expectLogicalAndException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '&&' can only be applied to boolean values!");
	}

	private void expectLogicalOrException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '||' can only be applied to boolean values!");
	}

	private void expectLogicalNotException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '!' can only be applied to boolean values!");
	}

	protected Type inferType(String expression) {
		ParserRule rule = XtextFactory.eINSTANCE.createParserRule();
		rule.setName("Expression");
		IParseResult parse = parser.parse(rule, new StringReader(expression));
		EObject statement = parse.getRootASTElement();
		return analyzer.inferType((Statement) statement);
	}

}
