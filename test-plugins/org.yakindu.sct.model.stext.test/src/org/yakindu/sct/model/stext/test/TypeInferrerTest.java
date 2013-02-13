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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.test.util.STextTestScopeProvider;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - additional tests
 * @author Alexander Nyßen - Adopted to changes in type system
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class TypeInferrerTest extends AbstractSTextTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Inject
	public ISTextTypeSystem typeSystem;
	@Inject
	private ISTextTypeInferrer typeInferrer;

	// Unary
	@Test
	public void testUnarySuccess() {
		// int
		assertTrue(isIntegerType(inferType("1")));
		assertTrue(isIntegerType(inferType("0x0F")));
		assertTrue(isIntegerType(inferType("-1")));
		assertTrue(isIntegerType(inferType("0")));
		assertTrue(isIntegerType(inferType("intVar")));
		// real
		assertTrue(isRealType(inferType("1.0")));
		assertTrue(isRealType(inferType("-1.0")));
		assertTrue(isRealType(inferType("0.0")));
		assertTrue(isRealType(inferType("realVar")));
		// string
		assertTrue(isStringType(inferType("'42'")));
		assertTrue(isStringType(inferType("stringVar")));
		// boolean
		assertTrue(isBooleanType(inferType("true")));
		assertTrue(isBooleanType(inferType("false")));
		assertTrue(isBooleanType(inferType("boolVar")));
		assertTrue(isBooleanType(inferType("boolEvent")));
	}

	// Add
	@Test
	public void testAddSuccess() {
		assertTrue(isIntegerType(inferType("1+2", internalScope())));
		assertTrue(isIntegerType(inferType("1 + 2")));
		assertTrue(isIntegerType(inferType("1 + 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F + 0x0F")));
		assertTrue(isIntegerType(inferType("intVar + 0x0F")));
		assertTrue(isIntegerType(inferType("intVar + 2")));
		assertTrue(isRealType(inferType("1.1 + 2")));
		assertTrue(isRealType(inferType("2 + 1.0")));
		assertTrue(isRealType(inferType("1 + 2 + 3.0")));
	}

	@Test
	public void testAddFailure() {
		expectIssue(
				inferType("true + 5"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("false + 5"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("5 + false"),
				"Arithmetic operator '+' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("true + (3 * 5)"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("(3 * 5) + true"),
				"Arithmetic operator '+' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("3.0 +  true"),
				"Arithmetic operator '+' may only be applied on numeric types, not on real and boolean.");
		expectIssue(
				inferType("3.0 + 'string'"),
				"Arithmetic operator '+' may only be applied on numeric types, not on real and string.");
		expectIssue(
				inferType("intVar + 'string'"),
				"Arithmetic operator '+' may only be applied on numeric types, not on integer and string.");
	}

	// substract
	@Test
	public void testSubstractSuccess() {
		assertTrue(isIntegerType(inferType("1 - 2")));
		assertTrue(isIntegerType(inferType("0x0F - 2")));
		assertTrue(isIntegerType(inferType("0x0F - 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F- intVar")));
		assertTrue(isIntegerType(inferType("intVar - 2")));
		assertTrue(isRealType(inferType("1.0 - 2")));
		assertTrue(isRealType(inferType("2 - 1.0")));
		assertTrue(isRealType(inferType("realVar - 1.0")));
		assertTrue(isRealType(inferType("1 - 2 - 3.0")));
	}

	@Test
	public void testSubstractFailure() {
		expectIssue(
				inferType("true - 5"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("false - 5"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("5 - false"),
				"Arithmetic operator '-' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("true - (3 * 5)"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("(3 * 5) - true"),
				"Arithmetic operator '-' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("3.0 -  true"),
				"Arithmetic operator '-' may only be applied on numeric types, not on real and boolean.");
		expectIssue(
				inferType("3.0 -  'string'"),
				"Arithmetic operator '-' may only be applied on numeric types, not on real and string.");
		expectIssue(
				inferType("realVar -  'string'"),
				"Arithmetic operator '-' may only be applied on numeric types, not on real and string.");
	}

	// multiply
	@Test
	public void testMultiplySuccess() {
		assertTrue(isIntegerType(inferType("1 * 2")));
		assertTrue(isIntegerType(inferType("1 * 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F * intVar")));
		assertTrue(isRealType(inferType("intVar * realVar")));
		assertTrue(isRealType(inferType("1.0 * 2")));
		assertTrue(isRealType(inferType("2 * 1.0")));
		assertTrue(isRealType(inferType("1 * 2 * 3.0")));
	}

	@Test
	public void testMultiplyFailure() {
		expectIssue(
				inferType("true * 5"),
				"Arithmetic operator '*' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("5 * false"),
				"Arithmetic operator '*' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("true * (3 - 5)"),
				"Arithmetic operator '*' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("(3 + 5) * true"),
				"Arithmetic operator '*' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("3.0 *  true"),
				"Arithmetic operator '*' may only be applied on numeric types, not on real and boolean.");
		expectIssue(
				inferType("3.0 *  'string'"),
				"Arithmetic operator '*' may only be applied on numeric types, not on real and string.");
		expectIssue(
				inferType("realVar *  'string'"),
				"Arithmetic operator '*' may only be applied on numeric types, not on real and string.");
	}

	// divide
	@Test
	public void testDivideSuccess() {
		assertTrue(isIntegerType(inferType("1 / 2")));
		assertTrue(isIntegerType(inferType("1 / intVar")));
		assertTrue(isIntegerType(inferType("1 / 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F / 0x0F")));
		assertTrue(isIntegerType(inferType("intVar / 0x0F")));
		assertTrue(isRealType(inferType("1.0 / 2")));
		assertTrue(isRealType(inferType("2 / 1.0")));
		assertTrue(isRealType(inferType("1 / 2 / 3.0")));
	}

	@Test
	public void testDivideFailure() {
		expectIssue(
				inferType("true / 5"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("false / 5"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("5 / false"),
				"Arithmetic operator '/' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("true / (3 - 5)"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("(3 + 5) / true"),
				"Arithmetic operator '/' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("3.0 /  true"),
				"Arithmetic operator '/' may only be applied on numeric types, not on real and boolean.");
		expectIssue(
				inferType("3.0 /  'string'"),
				"Arithmetic operator '/' may only be applied on numeric types, not on real and string.");
		expectIssue(
				inferType("3.0 /  stringVar"),
				"Arithmetic operator '/' may only be applied on numeric types, not on real and string.");
	}

	// mod
	@Test
	public void testModSuccess() {
		assertTrue(isIntegerType(inferType("1 % 2")));
		assertTrue(isIntegerType(inferType("1 % 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F % 0x0F")));
		assertTrue(isIntegerType(inferType("intVar % 0x0F")));
		assertTrue(isRealType(inferType("1.0 % 2")));
		assertTrue(isRealType(inferType("2 % 1.0")));
		assertTrue(isRealType(inferType("2 % realVar")));
		assertTrue(isRealType(inferType("1 % 2 % 3.0")));
	}

	@Test
	public void testModFailure() {
		expectIssue(
				inferType("true % 5"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("false % 5"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("5 % false"),
				"Arithmetic operator '%' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("true % (3 - 5)"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("(3 + 5) % true"),
				"Arithmetic operator '%' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(
				inferType("3.0 % true"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and boolean.");
		expectIssue(
				inferType("3.0 % 'string'"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and string.");
		expectIssue(
				inferType("3.0 % stringVar"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and string.");
		expectIssue(
				inferType("3.0 % stringVar"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and string.");
	}

	// Logical And Or Not
	@Test
	public void testLogicalSuccess() {
		assertTrue(isBooleanType(inferType("true || false")));
		assertTrue(isBooleanType(inferType("true || boolVar")));
		assertTrue(isBooleanType(inferType("true || false && true")));
		assertTrue(isBooleanType(inferType("true || true &&( false || true)")));
		assertTrue(isBooleanType(inferType("!true")));
		assertTrue(isBooleanType(inferType("!boolVar")));
		assertTrue(isBooleanType(inferType("!boolEvent")));
		assertTrue(isBooleanType(inferType("!true && !false")));
		assertTrue(isBooleanType(inferType("boolEvent && !boolEvent")));
		assertTrue(isBooleanType(inferType("boolEvent || boolEvent")));
	}

	@Test
	public void testLogicalFailure() {
		expectIssue(
				inferType("true && 5"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(
				inferType("false || 5"),
				"Logical operator '||' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(
				inferType("5 && false"),
				"Logical operator '&&' may only be applied on boolean types, not on integer and boolean.");
		expectIssue(
				inferType("true && (3 - 5)"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(
				inferType("(3 + 5) || true"),
				"Logical operator '||' may only be applied on boolean types, not on integer and boolean.");
		expectIssue(
				inferType("3.0 &&  true"),
				"Logical operator '&&' may only be applied on boolean types, not on real and boolean.");
		expectIssue(inferType("!3"),
				"Logical operator '!' may only be applied on boolean types, not on integer.");
		expectIssue(inferType("!1.2"),
				"Logical operator '!' may only be applied on boolean types, not on real.");
		expectIssue(inferType("!'Test'"),
				"Logical operator '!' may only be applied on boolean types, not on string.");
		expectIssue(inferType("!stringVar"),
				"Logical operator '!' may only be applied on boolean types, not on string.");
		expectIssue(
				inferType("5 && boolEvent"),
				"Logical operator '&&' may only be applied on boolean types, not on integer and boolean.");
	}

	// LogicalRelation
	@Test
	public void testLogicalRelationSuccess() {
		assertTrue(isBooleanType(inferType("5 < 3")));
		assertTrue(isBooleanType(inferType("5.0 < 3")));
		assertTrue(isBooleanType(inferType("5.0 < intVar")));

		assertTrue(isBooleanType(inferType("5 <= 3")));
		assertTrue(isBooleanType(inferType("5.0 <= 3")));
		assertTrue(isBooleanType(inferType("5.0 <= intVar")));

		assertTrue(isBooleanType(inferType("5 > 3")));
		assertTrue(isBooleanType(inferType("5.0 >= 3")));
		assertTrue(isBooleanType(inferType("5.0 >= intVar")));

		assertTrue(isBooleanType(inferType("5 == 3")));
		assertTrue(isBooleanType(inferType("'string' == 'string'")));
		assertTrue(isBooleanType(inferType("5.0 == 3")));
		assertTrue(isBooleanType(inferType("true == boolVar")));
		assertTrue(isBooleanType(inferType("true == boolEvent")));

		assertTrue(isBooleanType(inferType("5 != 3")));
		assertTrue(isBooleanType(inferType("'string' != 'string'")));
		assertTrue(isBooleanType(inferType("5.0 != 3")));
		assertTrue(isBooleanType(inferType("true != boolVar")));
		assertTrue(isBooleanType(inferType("true != boolEvent")));
	}

	@Test
	public void testLogicalRelationFailure() {
		expectIssue(
				inferType("3.0 < true"),
				"Comparison operator '<' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("'string' < 5"),
				"Comparison operator '<' may only be applied on compatible types, not on string and integer.");
		expectIssue(
				inferType("1.0 < false"),
				"Comparison operator '<' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("1.0 < boolEvent"),
				"Comparison operator '<' may only be applied on compatible types, not on real and boolean.");

		expectIssue(
				inferType("3.0 <= true"),
				"Comparison operator '<=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("'string' <= 5"),
				"Comparison operator '<=' may only be applied on compatible types, not on string and integer.");
		expectIssue(
				inferType("1.0 <= false"),
				"Comparison operator '<=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("1.0 <= boolEvent"),
				"Comparison operator '<=' may only be applied on compatible types, not on real and boolean.");

		expectIssue(
				inferType("3.0 > true"),
				"Comparison operator '>' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("'string' > 5"),
				"Comparison operator '>' may only be applied on compatible types, not on string and integer.");
		expectIssue(
				inferType("1.0 > false"),
				"Comparison operator '>' may only be applied on compatible types, not on real and boolean.");

		expectIssue(
				inferType("3.0 >= true"),
				"Comparison operator '>=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("'string' >= 5"),
				"Comparison operator '>=' may only be applied on compatible types, not on string and integer.");
		expectIssue(
				inferType("1.0 >= false"),
				"Comparison operator '>=' may only be applied on compatible types, not on real and boolean.");

		expectIssue(
				inferType("3.0 == true"),
				"Comparison operator '==' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("'string' == 5"),
				"Comparison operator '==' may only be applied on compatible types, not on string and integer.");
		expectIssue(
				inferType("1.0 == false"),
				"Comparison operator '==' may only be applied on compatible types, not on real and boolean.");

		expectIssue(
				inferType("3.0 != true"),
				"Comparison operator '!=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				inferType("'string' != 5"),
				"Comparison operator '!=' may only be applied on compatible types, not on string and integer.");
		expectIssue(
				inferType("1.0 != false"),
				"Comparison operator '!=' may only be applied on compatible types, not on real and boolean.");
	}

	@Test
	public void testAssignmentSuccess() {
		assertTrue(isIntegerType(inferType("intVar = 5 * 3")));
		assertTrue(isIntegerType(inferType("intVar = 0x0F * 3")));
		assertTrue(isIntegerType(inferType("intVar = intVar * 0x0F")));
		assertTrue(isBooleanType(inferType("boolVar = true || false")));
		assertTrue(isBooleanType(inferType("boolVar = boolEvent")));
		assertTrue(isStringType(inferType("stringVar = 'string'")));
		assertTrue(isRealType(inferType("realVar = 2.0 - 7")));
		assertTrue(isIntegerType(inferType("ABC.intVar = 42")));
	}

	@Test
	public void testAssignmentFailure() {
		expectIssue(
				inferType("intVar = true"),
				"Assignment operator '=' may only be applied on compatible types, not on integer and boolean.");
		expectIssue(
				inferType("intVar = boolVar"),
				"Assignment operator '=' may only be applied on compatible types, not on integer and boolean.");
	}

	/**
	 * the {@link STextTestScopeProvider} adds a dummy state named 'chart.r1.A'
	 * to the Scope.
	 */
	@Test
	public void testActiveSuccess() throws Exception {
		assertTrue(isBooleanType(inferType("active(chart.r1.A)")));
		assertTrue(isBooleanType(inferType("!active(chart.r1.A)")));
		assertTrue(isBooleanType(inferType("true || active(chart.r1.A)")));
		assertTrue(isBooleanType(inferType("active(chart.r1.A) && false")));
		assertTrue(isBooleanType(inferType("boolVar = active(chart.r1.A)")));
	}

	@Test
	public void testActiveFailure() throws Exception {
		expectIssue(
				inferType("active(chart.r1.A) + 1"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("active(chart.r1.A) - 1"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("active(chart.r1.A) * 1"),
				"Arithmetic operator '*' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("active(chart.r1.A) / 1"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(
				inferType("active(chart.r1.A) % true"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and boolean.");
		expectIssue(
				inferType("active(chart.r1.A) && intVar"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(
				inferType("active(chart.r1.A) || stringVar"),
				"Logical operator '||' may only be applied on boolean types, not on boolean and string.");
		expectIssue(inferType("active(chart.r1.A) || !stringVar"),
				"Logical operator '!' may only be applied on boolean types, not on string.");
	}

	@Test
	public void testBitwiseSuccess() {
		assertTrue(isIntegerType(inferType(" 5 & 3")));
		assertTrue(isIntegerType(inferType(" 5 | 3")));
		assertTrue(isIntegerType(inferType(" 5 ^ 3")));
		assertTrue(isIntegerType(inferType(" ~3")));
		assertTrue(isIntegerType(inferType("3 << 2")));
		assertTrue(isIntegerType(inferType("5 >> 2")));
		assertTrue(isIntegerType(inferType("intVar << 4")));
		assertTrue(isIntegerType(inferType("intVar >> 4")));
	}

	@Test
	public void testBitwiseFailure() throws Exception {
		expectIssue(
				inferType("5 & true"),
				"Bitwise operator '&' may only be applied on integer types, not on integer and boolean.");
		expectIssue(
				inferType("5 & 1.0"),
				"Bitwise operator '&' may only be applied on integer types, not on integer and real.");
		expectIssue(
				inferType("5 & 'stringVar'"),
				"Bitwise operator '&' may only be applied on integer types, not on integer and string.");

		expectIssue(
				inferType("5 | true"),
				"Bitwise operator '|' may only be applied on integer types, not on integer and boolean.");
		expectIssue(
				inferType("5 | 1.0"),
				"Bitwise operator '|' may only be applied on integer types, not on integer and real.");
		expectIssue(
				inferType("5 | 'stringVar'"),
				"Bitwise operator '|' may only be applied on integer types, not on integer and string.");

		expectIssue(
				inferType("5 ^ true"),
				"Bitwise operator '^' may only be applied on integer types, not on integer and boolean.");
		expectIssue(
				inferType("5 ^ 1.0"),
				"Bitwise operator '^' may only be applied on integer types, not on integer and real.");
		expectIssue(
				inferType("5 ^ 'stringVar'"),
				"Bitwise operator '^' may only be applied on integer types, not on integer and string.");

		expectIssue(inferType("~true"),
				"Bitwise operator '~' may only be applied on integer types, not on boolean.");
		expectIssue(inferType("~9.0"),
				"Bitwise operator '~' may only be applied on integer types, not on real.");
		expectIssue(inferType("~stringVar"),
				"Bitwise operator '~' may only be applied on integer types, not on string.");

		expectIssue(
				inferType("5 << true"),
				"Bitwise operator '<<' may only be applied on integer types, not on integer and boolean.");
		expectIssue(
				inferType("5 << 7.0"),
				"Bitwise operator '<<' may only be applied on integer types, not on integer and real.");
		expectIssue(
				inferType("5 << stringVar"),
				"Bitwise operator '<<' may only be applied on integer types, not on integer and string.");

		expectIssue(
				inferType("5 >> true"),
				"Bitwise operator '>>' may only be applied on integer types, not on integer and boolean.");
		expectIssue(
				inferType("5 >> 7.0"),
				"Bitwise operator '>>' may only be applied on integer types, not on integer and real.");
		expectIssue(
				inferType("5 >> stringVar"),
				"Bitwise operator '>>' may only be applied on integer types, not on integer and string.");
	}

	@Test
	public void testComplexExpressionsSuccess() {
		assertTrue(isBooleanType(inferType("((((3 * intVar) + 5) % 2) > 97) || false")));
		assertTrue(isBooleanType(inferType("!true != boolVar && (3 > (realVar * 5 + 3))")));
		assertTrue(isIntegerType(inferType("3 * 3 + 7 / (3 * intVar % 8)")));
	}

	@Test
	public void testEventRaisingSuccess() {
		assertTrue(isIntegerType(inferType("raise intEvent : 42",
				EventRaisingExpression.class.getSimpleName())));
		assertTrue(isBooleanType(inferType("raise boolEvent : boolVar",
				EventRaisingExpression.class.getSimpleName())));
		assertTrue(isRealType(inferType("raise realEvent : 2.0 - 3.0",
				EventRaisingExpression.class.getSimpleName())));
		assertTrue(isStringType(inferType("raise stringEvent : 'string'",
				EventRaisingExpression.class.getSimpleName())));
		assertTrue(isVoidType(inferType("raise voidEvent",
				EventRaisingExpression.class.getSimpleName())));

		assertTrue(isIntegerType(inferType("raise ABC.intEvent : 42",
				EventRaisingExpression.class.getSimpleName())));
	}

	@Test
	public void testEventRaisingFailure() {
		expectIssue(
				inferType("raise intEvent : true",
						EventRaisingExpression.class.getSimpleName()),
				"Cannot assign a value of type boolean to an event of type integer.");
		expectIssue(
				inferType("raise intEvent : boolVar",
						EventRaisingExpression.class.getSimpleName()),
				"Cannot assign a value of type boolean to an event of type integer.");
		expectIssue(
				inferType("raise stringEvent",
						EventRaisingExpression.class.getSimpleName()),
				"Need to assign a value to an event of type string.");
		expectIssue(
				inferType("raise intEvent : true",
						EventRaisingExpression.class.getSimpleName()),
				"Cannot assign a value of type boolean to an event of type integer.");
		expectIssue(
				inferType("raise ABC.intEvent",
						EventRaisingExpression.class.getSimpleName()),
				"Need to assign a value to an event of type integer.");
	}

	@Test
	public void testVariableDefinitionSuccess() {
		assertTrue(isBooleanType(inferType("var boolVar : boolean = !true",
				VariableDefinition.class.getSimpleName())));
		assertTrue(isIntegerType(inferType("var intVar : integer = 5",
				VariableDefinition.class.getSimpleName())));
		assertTrue(isRealType(inferType("var realVar : real = 0.5",
				VariableDefinition.class.getSimpleName())));
		assertTrue(isRealType(inferType("var realVar : real = 5",
				VariableDefinition.class.getSimpleName()))); // coercion
		assertTrue(isStringType(inferType("var stringVar : string = 'test'",
				VariableDefinition.class.getSimpleName())));
	}

	@Test
	public void testVariableDefinitionFailure() {
		expectIssue(
				inferType("var boolVar : boolean = 5",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type integer to a variable of type boolean.");
		expectIssue(
				inferType("var boolVar : boolean = 0.5",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type real to a variable of type boolean.");
		expectIssue(
				inferType("var boolVar : boolean = 'text'",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type string to a variable of type boolean.");

		expectIssue(
				inferType("var intVar : integer = true",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type boolean to a variable of type integer.");
		expectIssue(
				inferType("var intVar : integer = 0.5",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type real to a variable of type integer.");
		expectIssue(
				inferType("var intVar : integer = 'text'",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type string to a variable of type integer.");

		expectIssue(
				inferType("var realVar : real = true",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type boolean to a variable of type real.");
		expectIssue(
				inferType("var realVar : real = 'text'",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type string to a variable of type real.");

		expectIssue(
				inferType("var stringVar : string = true",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type boolean to a variable of type string.");
		expectIssue(
				inferType("var stringVar : string = 5",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type integer to a variable of type string.");
		expectIssue(
				inferType("var stringVar : string = 0.5",
						VariableDefinition.class.getSimpleName(),
						interfaceScope()),
				"Cannot assign a value of type real to a variable of type string.");
	}

	@Test
	public void testValueOfSuccess() {
		assertTrue(isIntegerType(inferType("valueof(intEvent)")));
		assertTrue(isBooleanType(inferType("valueof(boolEvent)")));
		assertTrue(isRealType(inferType("valueof(realEvent)")));
		assertTrue(isStringType(inferType("valueof(stringEvent)")));
		assertTrue(isVoidType(inferType("valueof(voidEvent)")));

		assertTrue(isIntegerType(inferType("valueof(ABC.intEvent)")));
	}

	@Test
	public void testEventIsRaisedSuccess() {
		assertTrue(isBooleanType(inferType("boolVar = intEvent",
				internalScope())));
		assertTrue(isBooleanType(inferType("ABC.boolVar = ABC.intEvent",
				interfaceScope())));
	}

	@Test
	public void testOperationSuccess() {
		assertTrue(isIntegerType(inferType("intVar = intOp()")));
	}

	@Test
	public void testOperationFailure() {
		expectIssue(
				inferType("boolVar = intOp()"),
				"Assignment operator '=' may only be applied on compatible types, not on boolean and integer.");
	}

	@Test
	public void parenthesizedExpression() {
		assertTrue(isBooleanType(inferType("( true || false )")));
		assertTrue(isIntegerType(inferType("( 5 )")));
		assertTrue(isRealType(inferType("( 7.5 / 1.2 )")));
		assertTrue(isStringType(inferType("( 'abc' )")));
	}

	protected InferenceResult inferType(String expression) {
		return inferType(expression, super.internalScope(),
				super.interfaceScope());
	}

	protected InferenceResult inferType(String expression, String parserRule) {
		return inferType(expression, parserRule, super.internalScope(),
				super.interfaceScope());
	}

	protected InferenceResult inferType(String expression, Scope... scopes) {
		return inferType(expression, Expression.class.getSimpleName(), scopes);
	}

	protected InferenceResult inferType(String expression, String parserRule,
			Scope... scopes) {
		EObject parseResult = super.parseExpression(expression, parserRule,
				scopes);
		assertNotNull(parseResult);
		if (parseResult instanceof Expression) {
			return typeInferrer.inferType((Expression) parseResult);
		} else if (parseResult instanceof EventDefinition) {
			return typeInferrer.inferType((EventDefinition) parseResult);
		} else if (parseResult instanceof VariableDefinition) {
			return typeInferrer.inferType((VariableDefinition) parseResult);
		} else {
			throw new IllegalArgumentException("Unsupported parse result.");
		}
	}

	private boolean isVoidType(InferenceResult inferenceResult) {
		if (inferenceResult.getType() == null) {
			throw new IllegalArgumentException();
		}
		return typeSystem.isVoidType(inferenceResult.getType());
	}

	private boolean isIntegerType(InferenceResult inferenceResult) {
		if (inferenceResult.getType() == null) {
			throw new IllegalArgumentException(inferenceResult.getIssues()
					.iterator().next().getMessage());
		}
		return typeSystem.isIntegerType(inferenceResult.getType());
	}

	private boolean isRealType(InferenceResult inferenceResult) {
		if (inferenceResult.getType() == null) {
			throw new IllegalArgumentException(inferenceResult.getIssues()
					.iterator().next().getMessage());
		}
		return typeSystem.isRealType(inferenceResult.getType());
	}

	private boolean isBooleanType(InferenceResult inferenceResult) {
		if (inferenceResult.getType() == null) {
			throw new IllegalArgumentException(inferenceResult.getIssues()
					.iterator().next().getMessage());
		}
		return typeSystem.isBooleanType(inferenceResult.getType());
	}

	private boolean isStringType(InferenceResult inferenceResult) {
		if (inferenceResult.getType() == null) {
			throw new IllegalArgumentException(inferenceResult.getIssues()
					.iterator().next().getMessage());
		}
		return typeSystem.isStringType(inferenceResult.getType());
	}

	private void expectIssue(InferenceResult inferenceResult, String message) {
		if (inferenceResult == null) {
			throw new IllegalArgumentException();
		}
		if (inferenceResult.getIssues().isEmpty()) {
			TestCase.fail("No issue detected.");
		}
		if (inferenceResult.getIssues().size() > 1) {
			fail("Expected only one issue but detected "
					+ inferenceResult.getIssues().size());
		}
		assertEquals(message, inferenceResult.getIssues().iterator().next()
				.getMessage());
	}

}
