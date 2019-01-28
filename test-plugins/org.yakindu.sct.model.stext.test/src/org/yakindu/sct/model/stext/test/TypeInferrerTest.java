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

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.expressions.expressions.Argument;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.test.util.AbstractTypeInferrerTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.test.util.STextTestScopeProvider;
import org.yakindu.sct.model.stext.test.util.StextTestFactory;
import org.yakindu.sct.model.stext.test.util.TypesTestFactory;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - additional tests
 * @author Alexander Nyßen - Adopted to changes in type system
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class TypeInferrerTest extends AbstractTypeInferrerTest {

	@Inject
	protected TypesTestFactory typesFactory;
	
	// Unary
	@Test
	public void testNumericalUnaryExpressionSuccess() {
		// int
		assertTrue(isIntegerType(inferType("1")));
		assertTrue(isIntegerType(inferType("0x0F")));
		assertTrue(isIntegerType(inferType("0b00001")));
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
		// tilde
		assertTrue(isIntegerType(inferType(" ~3")));
	}

	@Test
	public void testNumericalUnaryExpressionFailure() {
		expectIssue(inferType("~true"), "Bitwise operator '~' may only be applied on integer types, not on boolean.");
		expectIssue(inferType("~9.0"), "Bitwise operator '~' may only be applied on integer types, not on real.");
		expectIssue(inferType("~stringVar"),
				"Bitwise operator '~' may only be applied on integer types, not on string.");
	}

	// AddSubtract
	@Test
	public void testNumericalAddSubtractExpression() {
		// add
		assertTrue(isIntegerType(inferTypeForExpression("1+2", internalScope())));
		assertTrue(isIntegerType(inferType("1 + 2")));
		assertTrue(isIntegerType(inferType("1 + 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F + 0x0F")));
		assertTrue(isIntegerType(inferType("intVar + 0x0F")));
		assertTrue(isIntegerType(inferType("1 + 0b11")));
		assertTrue(isIntegerType(inferType("0b01 + 0b1110")));
		assertTrue(isIntegerType(inferType("intVar + 0B101010")));
		assertTrue(isIntegerType(inferType("intVar + 2")));
		assertTrue(isRealType(inferType("1.1 + 2")));
		assertTrue(isRealType(inferType("2 + 1.0")));
		assertTrue(isRealType(inferType("1 + 2 + 3.0")));
		// subtract
		assertTrue(isIntegerType(inferType("1 - 2")));
		assertTrue(isIntegerType(inferType("0x0F - 2")));
		assertTrue(isIntegerType(inferType("0x0F - 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F- intVar")));
		assertTrue(isIntegerType(inferType("1 - 0b11")));
		assertTrue(isIntegerType(inferType("0b01 - 0b1110")));
		assertTrue(isIntegerType(inferType("intVar - 0B101010")));
		assertTrue(isIntegerType(inferType("intVar - 2")));
		assertTrue(isRealType(inferType("1.0 - 2")));
		assertTrue(isRealType(inferType("2 - 1.0")));
		assertTrue(isRealType(inferType("realVar - 1.0")));
		assertTrue(isRealType(inferType("1 - 2 - 3.0")));
	}

	@Test
	public void testNumericalAddSubtractExpressionFailure() {
		// add
		expectIssue(inferType("true + 5"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("false + 5"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("5 + false"),
				"Arithmetic operator '+' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("true + (3 * 5)"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("(3 * 5) + true"),
				"Arithmetic operator '+' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("3.0 +  true"),
				"Arithmetic operator '+' may only be applied on numeric types, not on real and boolean.");
		expectIssue(inferType("3.0 + 'string'"),
				"Arithmetic operator '+' may only be applied on numeric types, not on real and string.");
		expectIssue(inferType("intVar + 'string'"),
				"Arithmetic operator '+' may only be applied on numeric types, not on integer and string.");
		// subtract
		expectIssue(inferType("true - 5"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("false - 5"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("5 - false"),
				"Arithmetic operator '-' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("true - (3 * 5)"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("(3 * 5) - true"),
				"Arithmetic operator '-' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("3.0 -  true"),
				"Arithmetic operator '-' may only be applied on numeric types, not on real and boolean.");
		expectIssue(inferType("3.0 -  'string'"),
				"Arithmetic operator '-' may only be applied on numeric types, not on real and string.");
		expectIssue(inferType("intVar - 'string'"),
				"Arithmetic operator '-' may only be applied on numeric types, not on integer and string.");
	}

	// multiply
	@Test
	public void testMultiplyDivideExpressionSuccess() {
		// multiply
		// integer
		assertTrue(isIntegerType(inferType("1 * 2")));
		assertTrue(isIntegerType(inferType("1 * 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F * intVar")));
		assertTrue(isIntegerType(inferType("1 * 0B11")));
		assertTrue(isIntegerType(inferType("0b01101 * intVar")));
		// real
		assertTrue(isRealType(inferType("intVar * realVar")));
		assertTrue(isRealType(inferType("1.0 * 2")));
		assertTrue(isRealType(inferType("2 * 1.0")));
		assertTrue(isRealType(inferType("1 * 2 * 3.0")));

		// divide
		// integer
		assertTrue(isIntegerType(inferType("1 / 2")));
		assertTrue(isIntegerType(inferType("1 / intVar")));
		assertTrue(isIntegerType(inferType("1 / 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F / 0x0F")));
		assertTrue(isIntegerType(inferType("intVar / 0x0F")));
		assertTrue(isIntegerType(inferType("1 / 0b01")));
		assertTrue(isIntegerType(inferType("0x0F / 0b10")));
		assertTrue(isIntegerType(inferType("intVar / 0b011")));
		// real
		assertTrue(isRealType(inferType("1.0 / 2")));
		assertTrue(isRealType(inferType("2 / 1.0")));
		assertTrue(isRealType(inferType("1 / 2 / 3.0")));

		// modulo
		// integer
		assertTrue(isIntegerType(inferType("1 % 2")));
		assertTrue(isIntegerType(inferType("1 % 0x0F")));
		assertTrue(isIntegerType(inferType("0x0F % 0x0F")));
		assertTrue(isIntegerType(inferType("intVar % 0x0F")));
		assertTrue(isIntegerType(inferType("1 % 0b0001")));
		assertTrue(isIntegerType(inferType("0x0F % 0b1")));
		assertTrue(isIntegerType(inferType("intVar % 0b001")));
		
		// real
		assertTrue(isRealType(inferType("1.0 % 2")));
		assertTrue(isRealType(inferType("2 % 1.0")));
		assertTrue(isRealType(inferType("2 % realVar")));
		assertTrue(isRealType(inferType("1 % 2 % 3.0")));
	}

	@Test
	public void testMultiplyDivideExpressionFailure() {
		// multiply
		expectIssue(inferType("true * 5"),
				"Arithmetic operator '*' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("5 * false"),
				"Arithmetic operator '*' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("true * (3 - 5)"),
				"Arithmetic operator '*' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("(3 + 5) * true"),
				"Arithmetic operator '*' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("3.0 *  true"),
				"Arithmetic operator '*' may only be applied on numeric types, not on real and boolean.");
		expectIssue(inferType("3.0 *  'string'"),
				"Arithmetic operator '*' may only be applied on numeric types, not on real and string.");
		expectIssue(inferType("realVar *  'string'"),
				"Arithmetic operator '*' may only be applied on numeric types, not on real and string.");
		// divide
		expectIssue(inferType("true / 5"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("false / 5"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("5 / false"),
				"Arithmetic operator '/' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("true / (3 - 5)"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("(3 + 5) / true"),
				"Arithmetic operator '/' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("3.0 /  true"),
				"Arithmetic operator '/' may only be applied on numeric types, not on real and boolean.");
		expectIssue(inferType("3.0 /  'string'"),
				"Arithmetic operator '/' may only be applied on numeric types, not on real and string.");
		expectIssue(inferType("realVar /  stringVar"),
				"Arithmetic operator '/' may only be applied on numeric types, not on real and string.");
		// mod
		expectIssue(inferType("true % 5"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("false % 5"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("5 % false"),
				"Arithmetic operator '%' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("true % (3 - 5)"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("(3 + 5) % true"),
				"Arithmetic operator '%' may only be applied on numeric types, not on integer and boolean.");
		expectIssue(inferType("3.0 % true"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and boolean.");
		expectIssue(inferType("3.0 % 'string'"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and string.");
		expectIssue(inferType("3.0 % stringVar"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and string.");
		expectIssue(inferType("realVar % stringVar"),
				"Arithmetic operator '%' may only be applied on numeric types, not on real and string.");
	}

	// LogicalAndExpression
	@Test
	public void testLogicalAndExpressionSuccess() {
		assertTrue(isBooleanType(inferType("true && false")));
		assertTrue(isBooleanType(inferType("true && boolVar")));
		assertTrue(isBooleanType(inferType("boolEvent && valueof(boolEvent)")));
		assertTrue(isBooleanType(inferType("boolEvent && intEvent"))); // intEvent
																		// is a
																		// shortcut
																		// for
																		// isRaised(intEvent),
																		// thus
																		// of
																		// boolean
																		// type
		assertTrue(isBooleanType(inferType("boolEvent && boolEvent")));
	}

	@Test
	public void testLogicalAndExpressionFailure() {
		expectIssue(inferType("true && 5"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(inferType("5 && false"),
				"Logical operator '&&' may only be applied on boolean types, not on integer and boolean.");
		expectIssue(inferType("3.0 &&  true"),
				"Logical operator '&&' may only be applied on boolean types, not on real and boolean.");
		expectIssue(inferType("5 && boolEvent"),
				"Logical operator '&&' may only be applied on boolean types, not on integer and boolean.");
		expectIssue(inferType("true && 'string'"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and string.");
		expectIssue(inferType("true && 1.2"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and real.");
	}

	// LogicalOrExpression
	@Test
	public void testLogicalOrExpressionSuccess() {
		assertTrue(isBooleanType(inferType("true || false")));
		assertTrue(isBooleanType(inferType("true || boolVar")));
		assertTrue(isBooleanType(inferType("boolEvent || valueof(boolEvent)")));
		assertTrue(isBooleanType(inferType("boolEvent || intEvent"))); // intEvent
																		// is a
																		// shortcut
																		// for
																		// isRaised(intEvent),
																		// thus
																		// of
																		// boolean
																		// type
		assertTrue(isBooleanType(inferType("boolEvent || boolEvent")));
	}

	@Test
	public void testLogicalOrExpressionFailure() {
		expectIssue(inferType("false || 5"),
				"Logical operator '||' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(inferType("5 || true"),
				"Logical operator '||' may only be applied on boolean types, not on integer and boolean.");
		expectIssue(inferType("3.0 ||  true"),
				"Logical operator '||' may only be applied on boolean types, not on real and boolean.");
		expectIssue(inferType("5 || boolEvent"),
				"Logical operator '||' may only be applied on boolean types, not on integer and boolean.");
		expectIssue(inferType("5 || 'string'"),
				"Logical operator '||' may only be applied on boolean types, not on integer and string.");
		expectIssue(inferType("5 || 1.2"),
				"Logical operator '||' may only be applied on boolean types, not on integer and real.");
	}

	// LogicalNotExpression
	@Test
	public void testLogicalNotExpressionSuccess() {
		assertTrue(isBooleanType(inferType("!true")));
		assertTrue(isBooleanType(inferType("!boolVar")));
		assertTrue(isBooleanType(inferType("!valueof(boolEvent)")));
		assertTrue(isBooleanType(inferType("!intEvent"))); // intEvent is a
															// shortcut for
															// isRaised(intEvent),
															// thus of boolean
															// type
		assertTrue(isBooleanType(inferType("!boolEvent")));
	}

	@Test
	public void testLogicalNotExpressionFailure() {
		expectIssue(inferType("!3"), "Logical operator '!' may only be applied on boolean types, not on integer.");
		expectIssue(inferType("!1.2"), "Logical operator '!' may only be applied on boolean types, not on real.");
		expectIssue(inferType("!'Test'"), "Logical operator '!' may only be applied on boolean types, not on string.");
	}

	// LogicalRelation
	@Test
	public void testLogicalRelationExpressionSuccess() {
		// smaller
		assertTrue(isBooleanType(inferType("5 < 3")));
		assertTrue(isBooleanType(inferType("5.0 < 3")));
		assertTrue(isBooleanType(inferType("5.0 < intVar")));
		assertTrue(isBooleanType(inferType("5.0 < valueof(intEvent)")));
		// smallerEqual
		assertTrue(isBooleanType(inferType("5 <= 3")));
		assertTrue(isBooleanType(inferType("5.0 <= 3")));
		assertTrue(isBooleanType(inferType("5.0 <= intVar")));
		assertTrue(isBooleanType(inferType("5.0 <= valueof(intEvent)")));
		// greater
		assertTrue(isBooleanType(inferType("5 > 3")));
		assertTrue(isBooleanType(inferType("5.0 > 3")));
		assertTrue(isBooleanType(inferType("5.0 > intVar")));
		assertTrue(isBooleanType(inferType("5.0 > valueof(intEvent)")));
		// greaterEqual
		assertTrue(isBooleanType(inferType("5 >= 3")));
		assertTrue(isBooleanType(inferType("5.0 >= 3")));
		assertTrue(isBooleanType(inferType("5.0 >= intVar")));
		assertTrue(isBooleanType(inferType("5.0 >= valueof(intEvent)")));
		// equal
		assertTrue(isBooleanType(inferType("5 == 3")));
		assertTrue(isBooleanType(inferType("'string' == 'string'")));
		assertTrue(isBooleanType(inferType("5.0 == 3")));
		assertTrue(isBooleanType(inferType("true == boolVar")));
		assertTrue(isBooleanType(inferType("true == boolEvent")));
		assertTrue(isBooleanType(inferType("true == valueof(boolEvent)")));
		// not equal
		assertTrue(isBooleanType(inferType("5 != 3")));
		assertTrue(isBooleanType(inferType("'string' != 'string'")));
		assertTrue(isBooleanType(inferType("5.0 != 3")));
		assertTrue(isBooleanType(inferType("true != boolVar")));
		assertTrue(isBooleanType(inferType("true != boolEvent")));
		assertTrue(isBooleanType(inferType("true != valueof(boolEvent)")));

	}

	@Test
	public void testLogicalRelationExpressionFailure() {
		// smaller
		expectIssue(inferType("3.0 < true"),
				"Comparison operator '<' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("'string' < 5"),
				"Comparison operator '<' may only be applied on compatible types, not on string and integer.");
		expectIssue(inferType("1.0 < false"),
				"Comparison operator '<' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("1.0 < boolEvent"),
				"Comparison operator '<' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				// intEvent is a shortcut for isRaised(intEvent), thus of
				// boolean type
				inferType("5 < intEvent"),
				"Comparison operator '<' may only be applied on compatible types, not on integer and boolean.");
		// smallerEqual
		expectIssue(inferType("3.0 <= true"),
				"Comparison operator '<=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("'string' <= 5"),
				"Comparison operator '<=' may only be applied on compatible types, not on string and integer.");
		expectIssue(inferType("1.0 <= false"),
				"Comparison operator '<=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("1.0 <= boolEvent"),
				"Comparison operator '<=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				// intEvent is a shortcut for isRaised(intEvent), thus of
				// boolean type
				inferType("5 <= intEvent"),
				"Comparison operator '<=' may only be applied on compatible types, not on integer and boolean.");
		// greater
		expectIssue(inferType("3.0 > true"),
				"Comparison operator '>' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("'string' > 5"),
				"Comparison operator '>' may only be applied on compatible types, not on string and integer.");
		expectIssue(inferType("1.0 > false"),
				"Comparison operator '>' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				// intEvent is a shortcut for isRaised(intEvent), thus of
				// boolean type
				inferType("5 <= intEvent"),
				"Comparison operator '<=' may only be applied on compatible types, not on integer and boolean.");
		// greaterEqual
		expectIssue(inferType("3.0 >= true"),
				"Comparison operator '>=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("'string' >= 5"),
				"Comparison operator '>=' may only be applied on compatible types, not on string and integer.");
		expectIssue(inferType("1.0 >= false"),
				"Comparison operator '>=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				// intEvent is a shortcut for isRaised(intEvent), thus of
				// boolean type
				inferType("5 >= intEvent"),
				"Comparison operator '>=' may only be applied on compatible types, not on integer and boolean.");
		// equal
		expectIssue(inferType("3.0 == true"),
				"Comparison operator '==' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("'string' == 5"),
				"Comparison operator '==' may only be applied on compatible types, not on string and integer.");
		expectIssue(inferType("1.0 == false"),
				"Comparison operator '==' may only be applied on compatible types, not on real and boolean.");
		expectIssue(
				// intEvent is a shortcut for isRaised(intEvent), thus of
				// boolean type
				inferType("5 == intEvent"),
				"Comparison operator '==' may only be applied on compatible types, not on integer and boolean.");
		// not equal
		expectIssue(inferType("3.0 != true"),
				"Comparison operator '!=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("'string' != 5"),
				"Comparison operator '!=' may only be applied on compatible types, not on string and integer.");
		expectIssue(inferType("1.0 != false"),
				"Comparison operator '!=' may only be applied on compatible types, not on real and boolean.");
		expectIssue(inferType("intVar != 'string'"),
				"Comparison operator '!=' may only be applied on compatible types, not on integer and string.");
		expectIssue(
				// intEvent is a shortcut for isRaised(intEvent), thus of
				// boolean type
				inferType("5 != intEvent"),
				"Comparison operator '!=' may only be applied on compatible types, not on integer and boolean.");
	}

	@Test
	public void testAssignmentExpressionSuccess() {
		// assignment without operator
		// integer
		assertTrue(isIntegerType(inferType("intVar = 5 * 3")));
		assertTrue(isIntegerType(inferType("intVar = 0x0F * 3")));
		assertTrue(isIntegerType(inferType("intVar = intVar * 0x0F")));
		assertTrue(isIntegerType(inferType("intVar = 0b01 * 3")));
		assertTrue(isIntegerType(inferType("intVar = intVar * 0b01111")));
		assertTrue(isIntegerType(inferType("ABC.intVar = 42")));
		// boolean
		assertTrue(isBooleanType(inferType("boolVar = true || false")));
		assertTrue(isBooleanType(inferType("boolVar = boolEvent")));
		// string
		assertTrue(isStringType(inferType("stringVar = 'string'")));
		// real
		assertTrue(isRealType(inferType("realVar = 2.0 - 7")));

		// assignment with operator
		assertTrue(isIntegerType(inferType("intVar += 2")));
		assertTrue(isIntegerType(inferType("intVar -= 7")));
		assertTrue(isIntegerType(inferType("intVar *= 25")));
		assertTrue(isIntegerType(inferType("intVar /= 2")));
		assertTrue(isIntegerType(inferType("intVar %= 5")));

		// bitwise
		assertTrue(isIntegerType(inferType("intVar &= 12")));
		assertTrue(isIntegerType(inferType("intVar |= 25")));
		assertTrue(isIntegerType(inferType("intVar ^=  6")));
		assertTrue(isIntegerType(inferType("intVar <<= 215")));
		assertTrue(isIntegerType(inferType("intVar >>= 215")));
	}

	@Test
	public void testAssignmentExpressionFailure() {
		// integer and real
		expectIssue(inferType("intVar += 2.0"),
				"Assignment operator '+=' may only be applied on compatible types, not on integer and real.");
		expectIssue(inferType("intVar -= 2.0"),
				"Assignment operator '-=' may only be applied on compatible types, not on integer and real.");
		expectIssue(inferType("intVar /= 2.0"),
				"Assignment operator '/=' may only be applied on compatible types, not on integer and real.");
		expectIssue(inferType("intVar *= 2.0"),
				"Assignment operator '*=' may only be applied on compatible types, not on integer and real.");
		expectIssue(inferType("intVar = true"),
				"Assignment operator '=' may only be applied on compatible types, not on integer and boolean.");
		// integer and boolean
		expectIssue(inferType("intVar = boolVar"),
				"Assignment operator '=' may only be applied on compatible types, not on integer and boolean.");
		expectIssue(inferType("intVar &= boolVar"),
				"Assignment operator '&=' may only be applied on compatible types, not on integer and boolean.");
		expectIssue(inferType("intVar |= boolVar"),
				"Assignment operator '|=' may only be applied on compatible types, not on integer and boolean.");
		expectIssue(inferType("intVar ^= boolVar"),
				"Assignment operator '^=' may only be applied on compatible types, not on integer and boolean.");
		expectIssue(inferType("intVar >>= boolVar"),
				"Assignment operator '>>=' may only be applied on compatible types, not on integer and boolean.");
		expectIssue(inferType("intVar <<= boolVar"),
				"Assignment operator '<<=' may only be applied on compatible types, not on integer and boolean.");
		// integer and string
		expectIssue(inferType("intVar &= 'string'"),
				"Assignment operator '&=' may only be applied on compatible types, not on integer and string.");
		expectIssue(inferType("intVar |= 'string'"),
				"Assignment operator '|=' may only be applied on compatible types, not on integer and string.");
		expectIssue(inferType("intVar ^= 'string'"),
				"Assignment operator '^=' may only be applied on compatible types, not on integer and string.");
		expectIssue(inferType("intVar >>= 'string'"),
				"Assignment operator '>>=' may only be applied on compatible types, not on integer and string.");
		expectIssue(inferType("intVar <<= 'string'"),
				"Assignment operator '<<=' may only be applied on compatible types, not on integer and string.");
	}

	/**
	 * the {@link STextTestScopeProvider} adds a dummy state named 'chart.r1.A'
	 * to the Scope.
	 */
	@Test
	public void testActiveStateReferenceExpressionSuccess() throws Exception {
		assertTrue(isBooleanType(inferType("active(chart.r1.A)")));
		assertTrue(isBooleanType(inferType("!active(chart.r1.A)")));
		assertTrue(isBooleanType(inferType("true || active(chart.r1.A)")));
		assertTrue(isBooleanType(inferType("active(chart.r1.A) && false")));
		assertTrue(isBooleanType(inferType("boolVar = active(chart.r1.A)")));
	}

	@Test
	public void testActiveStateReferenceExpressionFailure() throws Exception {
		expectIssue(inferType("active(chart.r1.A) + 1"),
				"Arithmetic operator '+' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("active(chart.r1.A) - 1"),
				"Arithmetic operator '-' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("active(chart.r1.A) * 1"),
				"Arithmetic operator '*' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("active(chart.r1.A) / 1"),
				"Arithmetic operator '/' may only be applied on numeric types, not on boolean and integer.");
		expectIssue(inferType("active(chart.r1.A) % true"),
				"Arithmetic operator '%' may only be applied on numeric types, not on boolean and boolean.");
		expectIssue(inferType("active(chart.r1.A) && intVar"),
				"Logical operator '&&' may only be applied on boolean types, not on boolean and integer.");
		expectIssue(inferType("active(chart.r1.A) || stringVar"),
				"Logical operator '||' may only be applied on boolean types, not on boolean and string.");
		expectIssue(inferType("active(chart.r1.A) || !stringVar"),
				"Logical operator '!' may only be applied on boolean types, not on string.");
	}

	// bitwise
	@Test
	public void testBitwiseXorExpressionSuccess() {
		assertTrue(isIntegerType(inferType(" 5 ^ 3")));
	}

	@Test
	public void testBitwiseXorExpressionFailure() {
		expectIssue(inferType("5 ^ true"),
				"Bitwise operator '^' may only be applied on integer types, not on integer and boolean.");
		expectIssue(inferType("5 ^ 1.0"),
				"Bitwise operator '^' may only be applied on integer types, not on integer and real.");
		expectIssue(inferType("5 ^ 'stringVar'"),
				"Bitwise operator '^' may only be applied on integer types, not on integer and string.");
	}

	@Test
	public void testBitwiseOrExpressionSuccess() {
		assertTrue(isIntegerType(inferType(" 5 | 3")));
	}

	@Test
	public void testBitwiseOrExpressionFailure() {
		expectIssue(inferType("5 | true"),
				"Bitwise operator '|' may only be applied on integer types, not on integer and boolean.");
		expectIssue(inferType("5 | 1.0"),
				"Bitwise operator '|' may only be applied on integer types, not on integer and real.");
		expectIssue(inferType("5 | 'stringVar'"),
				"Bitwise operator '|' may only be applied on integer types, not on integer and string.");
	}

	@Test
	public void testBitwiseAndExpressionSuccess() {
		assertTrue(isIntegerType(inferType(" 5 & 3")));
	}

	@Test
	public void testBitwiseAndExpressionFailure() {
		expectIssue(inferType("5 & true"),
				"Bitwise operator '&' may only be applied on integer types, not on integer and boolean.");
		expectIssue(inferType("5 & 1.0"),
				"Bitwise operator '&' may only be applied on integer types, not on integer and real.");
		expectIssue(inferType("5 & 'stringVar'"),
				"Bitwise operator '&' may only be applied on integer types, not on integer and string.");
	}

	@Test
	public void testShiftExpressionSuccess() {
		assertTrue(isIntegerType(inferType("3 << 2")));
		assertTrue(isIntegerType(inferType("5 >> 2")));
		assertTrue(isIntegerType(inferType("intVar << 4")));
		assertTrue(isIntegerType(inferType("intVar >> 4")));
	}

	@Test
	public void testShiftExpressionFailure() {
		expectIssue(inferType("5 << true"),
				"Bitwise operator '<<' may only be applied on integer types, not on integer and boolean.");
		expectIssue(inferType("5 << 7.0"),
				"Bitwise operator '<<' may only be applied on integer types, not on integer and real.");
		expectIssue(inferType("5 << stringVar"),
				"Bitwise operator '<<' may only be applied on integer types, not on integer and string.");

		expectIssue(inferType("5 >> true"),
				"Bitwise operator '>>' may only be applied on integer types, not on integer and boolean.");
		expectIssue(inferType("5 >> 7.0"),
				"Bitwise operator '>>' may only be applied on integer types, not on integer and real.");
		expectIssue(inferType("5 >> stringVar"),
				"Bitwise operator '>>' may only be applied on integer types, not on integer and string.");
	}
	@Test
	public void testPostfixIncrementDecrementSuccess() {
		assertTrue(isIntegerType(inferType("intVar++")));
		assertTrue(isRealType(inferType("realVar++")));
		assertTrue(isIntegerType(inferType("intVar--")));
		assertTrue(isRealType(inferType("realVar--")));
	}
	@Test
	public void testPostfixIncrementDecrementFailure() {
		expectIssue(inferType("boolVar++"),
				"Incompatible types boolean and real.");
		expectIssue(inferType("stringVar++"),
				"Incompatible types string and real.");
		expectIssue(inferType("boolVar--"),
				"Incompatible types boolean and real.");
		expectIssue(inferType("stringVar--"),
				"Incompatible types string and real.");
	}

	@Test
	// No Expression in SText.xtext
	public void testComplexExpressionsSuccess() {
		assertTrue(isBooleanType(inferType("((((3 * intVar) + 5) % 2) > 97) || false")));
		assertTrue(isBooleanType(inferType("!true != boolVar && (3 > (realVar * 5 + 3))")));
		assertTrue(isIntegerType(inferType("3 * 3 + 7 / (3 * intVar % 8)")));
	}

	@Test
	public void testEventRaisingExpressionSuccess() {
		assertTrue(isIntegerType(inferType("raise intEvent : 42", EventRaisingExpression.class.getSimpleName())));
		assertTrue(isBooleanType(inferType("raise boolEvent : boolVar", EventRaisingExpression.class.getSimpleName())));
		assertTrue(isRealType(inferType("raise realEvent : 2.0 - 3.0", EventRaisingExpression.class.getSimpleName())));
		assertTrue(isStringType(inferType("raise stringEvent : 'string'", EventRaisingExpression.class.getSimpleName())));
		assertTrue(isVoidType(inferType("raise voidEvent", EventRaisingExpression.class.getSimpleName())));
		assertTrue(isIntegerType(inferType("raise ABC.intEvent : 42", EventRaisingExpression.class.getSimpleName())));
	}

	@Test
	public void testEventRaisingExpressionFailure() {
		expectIssue(inferType("raise intEvent : true", EventRaisingExpression.class.getSimpleName()),
				"Cannot assign a value of type boolean to an event of type integer.");
		expectIssue(inferType("raise intEvent : boolVar", EventRaisingExpression.class.getSimpleName()),
				"Cannot assign a value of type boolean to an event of type integer.");
		expectIssue(inferType("raise stringEvent", EventRaisingExpression.class.getSimpleName()),
				"Need to assign a value to an event of type string.");
		expectIssue(inferType("raise intEvent : true", EventRaisingExpression.class.getSimpleName()),
				"Cannot assign a value of type boolean to an event of type integer.");
		expectIssue(inferType("raise ABC.intEvent", EventRaisingExpression.class.getSimpleName()),
				"Need to assign a value to an event of type integer.");
	}

	@Test
	public void testEventIsRaisedSuccess() {
		assertTrue(isBooleanType(inferTypeForExpression("boolVar = intEvent", internalScope())));
		assertTrue(isBooleanType(inferTypeForExpression("ABC.boolVar = ABC.intEvent", interfaceScope())));
	}

	@Test
	// VariableDefinition is a statement, not an expression
	public void testVariableDefinitionSuccess() {
		assertTrue(isBooleanType(inferType("var boolVar : boolean = !true", "ScopeDeclaration")));
		assertTrue(isIntegerType(inferType("var intVar : integer = 5", "ScopeDeclaration")));
		assertTrue(isRealType(inferType("var realVar : real = 0.5", "ScopeDeclaration")));
		assertTrue(isRealType(inferType("var realVar : real = 5", "ScopeDeclaration"))); // coercion
		assertTrue(isStringType(inferType("var stringVar : string = 'test'", "ScopeDeclaration")));
	}

	@Test
	// VariableDefinition is a statement, not an expression
	public void testVariableDefinitionFailure() {
		expectIssue(inferType("var boolVar : boolean = 5", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type integer to a variable of type boolean.");
		expectIssue(
				inferType("var boolVar : boolean = 0.5", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type real to a variable of type boolean.");
		expectIssue(
				inferType("var boolVar : boolean = 'text'", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type string to a variable of type boolean.");
		expectIssue(
				inferType("var intVar : integer = true", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type boolean to a variable of type integer.");
		expectIssue(
				inferType("var intVar : integer = 0.5", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type real to a variable of type integer.");
		expectIssue(
				inferType("var intVar : integer = 'text'", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type string to a variable of type integer.");

		expectIssue(inferType("var realVar : real = true", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type boolean to a variable of type real.");
		expectIssue(
				inferType("var realVar : real = 'text'", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type string to a variable of type real.");

		expectIssue(
				inferType("var stringVar : string = true", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type boolean to a variable of type string.");
		expectIssue(
				inferType("var stringVar : string = 5", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type integer to a variable of type string.");
		expectIssue(
				inferType("var stringVar : string = 0.5", "ScopeDeclaration", interfaceScope()),
				"Cannot assign a value of type real to a variable of type string.");
	}

	// PrimitiveValueExpression
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
	public void testOperationSuccess() {
		assertTrue(isIntegerType(inferType("intVar = intOp()")));
	}

	@Test
	public void testOperationFailure() {
		expectIssue(inferType("boolVar = intOp()"),
				"Assignment operator '=' may only be applied on compatible types, not on boolean and integer.");
	}
	
	@Test
	public void testOperationCall() {
		String scope = "internal " 
				+ "operation opInt(p:integer) : void "
				+ "operation opReal(p:real) : void "
				+ "operation opString(p:string) : void "
				+ "operation opBoolean(p:boolean) : void "
				+ "operation opSubInt(p:SubInt) : void "
				+ "operation opSubReal(p:SubReal) : void "
				+ "operation opSubString(p:SubString) : void "
				+ "operation opSubBool(p:SubBool) : void "
				+ "var vi : integer "
				+ "var vr : real "
				+ "var vb : boolean "
				+ "var vs : string "
				+ "var vsi : SubInt "
				+ "var vsr : SubReal "
				+ "var vsb : SubBool "
				+ "var vss : SubString ";
		
		expectNoErrors("opInt(1)", scope);
		expectNoErrors("opInt(vi)", scope);
		expectNoErrors("opInt(vsi)", scope);
		
		expectNoErrors("opReal(1.1)", scope);
		expectNoErrors("opReal(1)", scope);
		expectNoErrors("opReal(vr)", scope);
		expectNoErrors("opReal(vsr)", scope);
		
		expectNoErrors("opString(\"hello\")", scope);
		expectNoErrors("opString(vs)", scope);
		expectNoErrors("opString(vss)", scope);
		
		expectNoErrors("opBoolean(true)", scope);
		expectNoErrors("opBoolean(vb)", scope);
		expectNoErrors("opBoolean(vsb)", scope);
		
		expectErrors("opInt(1.1)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opInt(vr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opInt(vsr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		
		expectErrors("opSubInt(vi)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opSubReal(vr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opSubBool(vb)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opSubString(vs)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		
		// TODO: actually one would expect these to work
//		expectNoErrors("opSubInt(1)", scope);
//		expectNoErrors("opSubReal(1.1)", scope);
//		expectNoErrors("opSubBool(true)", scope);
//		expectNoErrors("opSubString(\"hello\")", scope);
	}
	
	@Test
	public void testOperationCallVarArgs() {
		String scope = "internal " 
				+ "operation opInt(p...:integer) : void "
				+ "operation opReal(p...:real) : void "
				+ "operation opString(p...:string) : void "
				+ "operation opBoolean(p...:boolean) : void "
				+ "operation opSubInt(p...:SubInt) : void "
				+ "operation opSubReal(p...:SubReal) : void "
				+ "operation opSubString(p...:SubString) : void "
				+ "operation opSubBool(p...:SubBool) : void "
				+ "var vi : integer "
				+ "var vr : real "
				+ "var vb : boolean "
				+ "var vs : string "
				+ "var vsi : SubInt "
				+ "var vsr : SubReal "
				+ "var vsb : SubBool "
				+ "var vss : SubString ";
		
		expectNoErrors("opInt(1)", scope);
		expectNoErrors("opInt(vi)", scope);
		expectNoErrors("opInt(vsi)", scope);
		expectNoErrors("opInt(1, vi, vsi)", scope);
		
		expectNoErrors("opReal(1.1)", scope);
		expectNoErrors("opReal(1)", scope);
		expectNoErrors("opReal(vr)", scope);
		expectNoErrors("opReal(vsr)", scope);
		expectNoErrors("opReal(1.1, 1, vr, vsr)", scope);
		
		expectNoErrors("opString(\"hello\")", scope);
		expectNoErrors("opString(vs)", scope);
		expectNoErrors("opString(vss)", scope);
		expectNoErrors("opString(\"hello\", vs, vss)", scope);
		
		expectNoErrors("opBoolean(true)", scope);
		expectNoErrors("opBoolean(vb)", scope);
		expectNoErrors("opBoolean(vsb)", scope);
		expectNoErrors("opBoolean(true, vb, vsb)", scope);
		
		expectErrors("opInt(1.1)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opInt(vr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opInt(vsr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);
		expectErrors("opInt(1.1, vr, vsr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 3);
		
		expectErrors("opSubInt(vi, vi)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2);
		expectErrors("opSubReal(vr, vr)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2);
		expectErrors("opSubBool(vb, vb)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2);
		expectErrors("opSubString(vs, vs)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2);
		
	}

	@Test
	public void testOperationCallWithOptionalParameter() {
		OperationDefinition opDef = StextTestFactory._createOperation("opWithOptionals",
				StextFactory.eINSTANCE.createInternalScope());

		Parameter pReq = typesFactory.createParameter("pReq", ITypeSystem.INTEGER, false);
		Parameter pOpt = typesFactory.createParameter("pOpt", ITypeSystem.INTEGER, true);
		opDef.getParameters().add(pReq);
		opDef.getParameters().add(pOpt);

		Argument boolArg = (Argument) parseExpression("true", Argument.class.getSimpleName());
		Argument intArg = (Argument) parseExpression("17", Argument.class.getSimpleName());

		// opWithOptionals(17, 17) => valid
		ElementReferenceExpression opCall1 = StextTestFactory._createOperationCall(opDef, intArg, intArg);
		expectNoErrors(opCall1);

		// opWithOptionals(17) => valid, because of optional parameter
		ElementReferenceExpression opCall2 = StextTestFactory._createOperationCall(opDef, intArg);
		expectNoErrors(opCall2);

		// opWithOptionals(true) => invalid
		ElementReferenceExpression opCall3 = StextTestFactory._createOperationCall(opDef, boolArg);
		expectError(opCall3, ITypeSystemInferrer.NOT_COMPATIBLE_CODE);
	}

	@Test
	public void testParenthesizedExpression() {
		assertTrue(isBooleanType(inferType("( true || false )")));
		assertTrue(isIntegerType(inferType("( 5 )")));
		assertTrue(isRealType(inferType("( 7.5 / 1.2 )")));
		assertTrue(isStringType(inferType("( 'abc' )")));
	}

	@Test
	public void testTypeCastExpressionSuccess() {
		assertTrue(isBooleanType(inferType("( true as boolean)")));
		assertTrue(isIntegerType(inferType("( 7.5 as integer )")));
		assertTrue(isRealType(inferType(" 7 as real ")));
		assertTrue(isStringType(inferType("( 'abc' as string )")));
	}

	@Test
	public void testTypeCastExpressionFailure() {
		expectIssue(inferType("true as integer"), "Cannot cast from boolean to integer.");
		expectIssue(inferType("true as string"), "Cannot cast from boolean to string.");
		expectIssue(inferType("5 as string"), "Cannot cast from integer to string.");
		expectIssue(inferType("5.5 as string"), "Cannot cast from real to string.");
	}

	@Test
	public void testTernaryExpression() {
		assertTrue(isIntegerType(inferType("(1<2) ? 4 : 5")));
		assertTrue(isBooleanType(inferType("(true) ? false : true")));

		expectIssue(inferType("(true) ? 4 : false"), "Could not determine a common type for integer and boolean.");
	}
	
	@Test
	public void testParameterizedType() {
		assertTrue(isBooleanType(
				inferTypeResultForExpression("t.prop1", "internal var t:ComplexParameterizedType<boolean, integer>").getType()));
		assertTrue(isIntegerType(
				inferTypeResultForExpression("t.prop2", "internal var t:ComplexParameterizedType<boolean, integer>").getType()));
		
		assertTrue(isBooleanType(inferTypeResultForExpression("t.prop1.prop1",
				"internal var t:ComplexParameterizedType<ComplexParameterizedType<boolean, integer>, integer>").getType()));

		expectNoErrors("b = t.op(true, 10)",
				"internal var t:ComplexParameterizedType<boolean, integer> var b:boolean");

		expectErrors("b = t.op(true, 10.5)",
				"internal var t:ComplexParameterizedType<boolean, integer> var b:boolean", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1);

		assertTrue(isBooleanType(inferTypeResultForExpression("b = t.op(true, 10)",
				"internal var t:ComplexParameterizedType<integer> var b:boolean").getType()));
		
		assertTrue(
				isAnyType(inferTypeResultForExpression("t.prop1", "internal var t:ComplexParameterizedType<>").getType()));

		assertTrue(isAnyType(inferTypeResultForExpression("t.prop1", "internal var t:ComplexParameterizedType").getType()));
		
		assertTrue(isIntegerType(inferTypeResultForExpression("t.op(1, 2)", "internal var t:ComplexParameterizedType").getType()));
		
		expectNoErrors("b = t.op2()", "internal: var t:ComplexParameterizedType<integer, boolean> var b: boolean");

		assertTrue(isAnyType(inferTypeResultForExpression("t.prop1.prop1",
				"internal var t:ComplexParameterizedType<ComplexParameterizedType<>, integer>").getType()));
		
		expectNoErrors("t2 = t.prop3",
				"internal "
				+ "var t:ComplexParameterizedType<boolean, integer> "
				+ "var t2:ComplexParameterizedType<integer, boolean>");
		
		expectErrors("t = t.prop3",
				"internal "
				+ "var t:ComplexParameterizedType<boolean, integer> "
				+ "var t2:ComplexParameterizedType<integer, boolean>", 
				ITypeSystemInferrer.NOT_SAME_CODE, 2);
	}
	
	@Test
	public void testOperationWithParameterizedType() {
		String scopes = ""
				+ "internal "
				+ "var t1:ComplexParameterizedType<boolean, integer>"
				+ "var t2:ComplexParameterizedType<integer, boolean>"
				+ "operation op(p:ComplexParameterizedType<boolean, integer>) : void";
		expectNoErrors("op(t1)", scopes);
		expectErrors("op(t2)", scopes, ITypeSystemInferrer.NOT_SAME_CODE, 2);
	}
	
	@Test
	public void testNullType() {
		String scope = "internal var cp:ComplexType var i:integer";

		expectNoErrors("cp == null", scope);
		expectNoErrors("null != cp", scope);
		expectNoErrors("cp = null", scope);

		expectIssue(inferTypeResult("null = cp", Expression.class.getSimpleName(), scope).getType(),
				"Assignment operator '=' may only be applied on compatible types, not on null and ComplexType.");
		expectIssue(inferTypeResult("i == null", Expression.class.getSimpleName(), scope).getType(),
				"Comparison operator '==' may only be applied on compatible types, not on integer and null.");
		expectIssue(inferTypeResult("i = null", Expression.class.getSimpleName(), scope).getType(),
				"Assignment operator '=' may only be applied on compatible types, not on integer and null.");
	}
	
	/**
	 * Uses a model of the following function:
	 * 
	 * template <typename T>
	 * T templateOp(T a, T b) {
	 * 		return a > b ? a : b;
	 * }
	 */
	@Test
	public void testOperationWithTypeParameters() {
		String scopes = ""
				+ "internal "
				+ "var myI : integer "
				+ "var myF : real "
				+ "var myB: boolean "
				+ "var myCPT: ComplexParameterizedType<boolean, integer> "
				+ "var myCPT2: ComplexParameterizedType<integer, boolean> ";
		
		expectNoErrors("myI = templateOp(myI, myI)", scopes);
		assertTrue(isIntegerType(inferTypeResultForExpression("myI = templateOp(myI, myI)", scopes).getType()));
		
		expectNoErrors("myF = templateOp(3+5, 2.3)", scopes);
		assertTrue(isRealType(inferTypeResultForExpression("myF = templateOp(3+5, 2.3)", scopes).getType()));
		
		expectNoErrors("myCPT = templateOp(myCPT, myCPT)", scopes);
		
		expectError("myB = templateOp(myI, myI)", scopes, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE);
		expectError("myB = templateOp(3+5, boolean)", scopes, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE);
		
		expectErrors("myCPT2 = templateOp(myCPT, myCPT)", scopes, ITypeSystemInferrer.NOT_SAME_CODE, 2);
		expectErrors("myCPT = templateOp(myCPT, myCPT2)", scopes, ITypeSystemInferrer.NOT_SAME_CODE, 2);
	}
	
	@Test
	public void testNestedGenericElementInferrer() {
		String scope = ""
				+ "import nestedTemplate "
				+ "internal: "
				+ "var nestedCPT: ComplexParameterizedType<boolean, integer> "
				+ "var myI: integer "
				+ "var myB: boolean ";
		
		expectError("myI = nestedOp(3)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE);
		expectNoErrors("myI = nestedOp(nestedCPT)", scope);
		expectError("myB = nestedOp(nestedCPT)", scope, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE);
	}
	
	@Test
	public void testNestedNestedGenericElementInferrer() {
		String scope = ""
				+ "import nestedNestedTemplate "
				+ "internal: "
				+ "var nestedCPT: ComplexParameterizedType<ComplexParameterizedType<boolean, string>, integer> "
				+ "var myS: string "
				+ "var b: boolean ";
		
		expectNoErrors("myS = nestedNestedOp(nestedCPT)", scope);
		expectError("b = nestedNestedOp(nestedCPT)", scope, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE);
	}
	
	@Test
	public void testGenericFeatureCall() {
		String scope = ""
				+ "internal: "
				+ "var cmo: ParameterizedMethodOwner "
				+ "var i: integer "
				+ "var r: real "
				+ "var b: boolean ";
		
		expectNoErrors("i = cmo.genericOp(1, 2)", scope);
		expectNoErrors("r = cmo.genericOp(1.3, 2)", scope);
		expectNoErrors("r = cmo.genericOp(1, 2)", scope);
		expectNoErrors("b = cmo.genericOp(true, 2)", scope);
		expectNoErrors("b = cmo.genericOp(true, 2)", scope);
		expectError("i = cmo.genericOp(1.3, 2)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE);
		expectError("r = cmo.genericOp(false, 2)", scope, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE);
		expectError("b = cmo.genericOp(1.3, 2)", scope, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE);
	}
	
	@Test
	public void testOperationOverloading() {
		String scopes = ""
				+ "internal "
				+ "var b : boolean "
				+ "var i : integer "
				+ "var owner: ComplexTypeWithOverloadedOperations ";
		
		expectNoErrors("i = owner.overloaded(1)", scopes);
		assertTrue(isIntegerType(inferTypeResultForExpression("i = owner.overloaded(1)", scopes).getType()));

		expectNoErrors("b = owner.overloaded(true)", scopes);
		assertTrue(isBooleanType(inferTypeResultForExpression("b = owner.overloaded(true)", scopes).getType()));
	}
	
	@Test
	public void testSubTypeOfGenericType() {
		String scope = ""
				+ "internal "
				+ "var i : integer "
				+ "var b : boolean "
				+ "var st : SubTypeOfGenericType<integer> "
				+ "var sst : SubSubTypeOfGenericType ";
		
		expectNoErrors("i = st.get()", scope);
		assertTrue(isIntegerType(inferTypeResultForExpression("st.get()", scope).getType()));
		
		expectNoErrors("st.add(i)", scope);
		assertTrue(isVoidType(inferTypeResultForExpression("st.add(i)", scope).getType()));
		
		expectNoErrors("b = sst.get()", scope);
		assertTrue(isBooleanType(inferTypeResultForExpression("sst.get()", scope).getType()));
		
		expectNoErrors("sst.add(b)", scope);
		assertTrue(isVoidType(inferTypeResultForExpression("sst.add(b)", scope).getType()));
	}
	
	@Test
	public void testTargetTypeInferrence() {
		String scope = ""
				+ "internal: "
				+ "var cmo: ParameterizedMethodOwner "
				+ "var i: integer "
				+ "var b: boolean = cmo.genericOpWoParams() "
				+ "var nestedCPT: ComplexParameterizedType<ComplexParameterizedType<boolean, string>, integer> = cmo.genericOpWoParams()";
		
		// target type from assignment
		expectOk("i = cmo.genericOpWoParams()", scope);
		assertTrue(isIntegerType(inferTypeResultForExpression("i = cmo.genericOpWoParams()", scope).getType()));
		
		// target type from variable initialization
		assertTrue(isBooleanType(inferTypeResultForExpression("b", scope).getType()));
		assertTrue(isBooleanType(inferTypeResultForExpression("nestedCPT.prop1.prop1", scope).getType()));
		assertTrue(isStringType(inferTypeResultForExpression("nestedCPT.prop1.prop2", scope).getType()));
		assertTrue(isIntegerType(inferTypeResultForExpression("nestedCPT.prop2", scope).getType()));
		
		// target type from operation parameter
		expectOk("cmo.concreteOp(cmo.genericOpWoParams())", scope);
	}
}
