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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.test.util.STextTestScopeProvider;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - additional tests
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class TypeInferrerTest extends AbstractSTextTest {

	@Inject
	private ITypeInferrer analyzer;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Inject
	private ITypeSystemAccess ts;

	// Unary
	@Test
	public void testUnarySuccess() {
		// int
		assertTrue(ts.isInteger(getType("1")));
		assertTrue(ts.isInteger(getType("0x0F")));
		assertTrue(ts.isInteger(getType("-1")));
		assertTrue(ts.isInteger(getType("0")));
		assertTrue(ts.isInteger(getType("myInt")));
		// real
		assertTrue(ts.isReal(getType("1.0")));
		assertTrue(ts.isReal(getType("-1.0")));
		assertTrue(ts.isReal(getType("0.0")));
		assertTrue(ts.isReal(getType("myReal")));
		// string
		assertTrue(ts.isString(getType("'42'")));
		assertTrue(ts.isString(getType("myString")));
		// boolean
		assertTrue(ts.isBoolean(getType("true")));
		assertTrue(ts.isBoolean(getType("false")));
		assertTrue(ts.isBoolean(getType("myBool")));
		// event
		assertTrue(ts.isBoolean(getType("event1")));
	}

	// Add
	@Test
	public void testAddSuccess() {
		Statement statement = (Statement) super.parseExpression("1+2",
				super.internalScope(), Expression.class.getSimpleName());
		analyzer.getType(statement);
		assertTrue(ts.isInteger(analyzer.getType(statement)));

		assertTrue(ts.isInteger(getType("1 + 2")));
		assertTrue(ts.isInteger(getType("1 + 0x0F")));
		assertTrue(ts.isInteger(getType("0x0F + 0x0F")));
		assertTrue(ts.isInteger(getType("myInt + 0x0F")));
		assertTrue(ts.isInteger(getType("myInt + 2")));
		assertTrue(ts.isReal(getType("1.1 + 2")));
		assertTrue(ts.isReal(getType("2 + 1.0")));
		assertTrue(ts.isReal(getType("1 + 2 + 3.0")));
	}

	@Test
	public void testAddException1() {
		expectOperatorPlusException();
		getType("true + 5");
	}

	@Test
	public void testAddException2() {
		expectOperatorPlusException();
		getType("false + 5");
	}

	@Test
	public void testAddException3() {
		expectOperatorPlusException();
		getType("5 + false");
	}

	@Test
	public void testAddException4() {
		expectOperatorPlusException();
		getType("true + (3 * 5)");
	}

	@Test
	public void testAddException5() {
		expectOperatorPlusException();
		getType("(3 * 5) + true");
	}

	@Test
	public void testAddException6() {
		expectOperatorPlusException();
		getType("3.0 +  true");
	}

	@Test
	public void testAddException7() {
		expectOperatorPlusException();
		getType("3.0 + 'string'");
	}

	@Test
	public void testAddException8() {
		expectOperatorPlusException();
		getType("myInt + 'string'");
	}

	// substract
	@Test
	public void testSubstractSuccess() {
		assertTrue(ts.isInteger(getType("1 - 2")));
		assertTrue(ts.isInteger(getType("0x0F - 2")));
		assertTrue(ts.isInteger(getType("0x0F - 0x0F")));
		assertTrue(ts.isInteger(getType("0x0F- myInt")));
		assertTrue(ts.isInteger(getType("myInt - 2")));
		assertTrue(ts.isReal(getType("1.0 - 2")));
		assertTrue(ts.isReal(getType("2 - 1.0")));
		assertTrue(ts.isReal(getType("myReal - 1.0")));
		assertTrue(ts.isReal(getType("1 - 2 - 3.0")));
	}

	@Test
	public void testSubstractException1() {
		expectOperatorSubstractException();
		getType("true - 5");
	}

	@Test
	public void testSubstractException2() {
		expectOperatorSubstractException();
		getType("false - 5");
	}

	@Test
	public void testSubstractException3() {
		expectOperatorSubstractException();
		getType("5 - false");
	}

	@Test
	public void testSubstractException4() {
		expectOperatorSubstractException();
		getType("true - (3 * 5)");
	}

	@Test
	public void testSubstractException5() {
		expectOperatorSubstractException();
		getType("(3 * 5) - true");
	}

	@Test
	public void testSubstractException6() {
		expectOperatorSubstractException();
		getType("3.0 -  true");
	}

	@Test
	public void testSubstractException7() {
		expectOperatorSubstractException();
		getType("3.0 -  'string'");
	}

	@Test
	public void testSubstractException8() {
		expectOperatorSubstractException();
		getType("myReal -  'string'");
	}

	// multiply
	@Test
	public void testMultiplySuccess() {
		assertTrue(ts.isInteger(getType("1 * 2")));
		assertTrue(ts.isInteger(getType("1 * 0x0F")));
		assertTrue(ts.isInteger(getType("0x0F * myInt")));
		assertTrue(ts.isReal(getType("myInt * myReal")));
		assertTrue(ts.isReal(getType("1.0 * 2")));
		assertTrue(ts.isReal(getType("2 * 1.0")));
		assertTrue(ts.isReal(getType("1 * 2 * 3.0")));
	}

	@Test
	public void testMultiplyException1() {
		expectOperatorMultiplyException();
		getType("true * 5");
	}

	@Test
	public void testMultiplyException2() {
		expectOperatorMultiplyException();
		getType("false * 5");
	}

	@Test
	public void testMultiplyException3() {
		expectOperatorMultiplyException();
		getType("5 * false");
	}

	@Test
	public void testMultiplyException4() {
		expectOperatorMultiplyException();
		getType("true * (3 - 5)");
	}

	@Test
	public void testMultiplyException5() {
		expectOperatorMultiplyException();
		getType("(3 + 5) * true");
	}

	@Test
	public void testMultiplyException6() {
		expectOperatorMultiplyException();
		getType("3.0 *  true");
	}

	@Test
	public void testMultiplyException7() {
		expectOperatorMultiplyException();
		getType("3.0 *  'string'");
	}

	@Test
	public void testMultiplyException8() {
		expectOperatorMultiplyException();
		getType("myReal *  'string'");
	}

	// divide
	@Test
	public void testDivideSuccess() {
		assertTrue(ts.isInteger(getType("1 / 2")));
		assertTrue(ts.isInteger(getType("1 / myInt")));
		assertTrue(ts.isInteger(getType("1 / 0x0F")));
		assertTrue(ts.isInteger(getType("0x0F / 0x0F")));
		assertTrue(ts.isInteger(getType("myInt / 0x0F")));
		assertTrue(ts.isReal(getType("1.0 / 2")));
		assertTrue(ts.isReal(getType("2 / 1.0")));
		assertTrue(ts.isReal(getType("1 / 2 / 3.0")));
	}

	@Test
	public void testDivideException1() {
		expectOperatorDivideException();
		getType("true / 5");
	}

	@Test
	public void testDivideException2() {
		expectOperatorDivideException();
		getType("false / 5");
	}

	@Test
	public void testDivideException3() {
		expectOperatorDivideException();
		getType("5 / false");
	}

	@Test
	public void testDivideException4() {
		expectOperatorDivideException();
		getType("true / (3 - 5)");
	}

	@Test
	public void testDivideException5() {
		expectOperatorDivideException();
		getType("(3 + 5) / true");
	}

	@Test
	public void testDivideException6() {
		expectOperatorDivideException();
		getType("3.0 /  true");
	}

	@Test
	public void testDivideException7() {
		expectOperatorDivideException();
		getType("3.0 /  'string'");
	}

	@Test
	public void testDivideException8() {
		expectOperatorDivideException();
		getType("3.0 /  myString");
	}

	// mod
	@Test
	public void testModSuccess() {
		assertTrue(ts.isInteger(getType("1 % 2")));
		assertTrue(ts.isInteger(getType("1 % 0x0F")));
		assertTrue(ts.isInteger(getType("0x0F % 0x0F")));
		assertTrue(ts.isInteger(getType("myInt % 0x0F")));
		assertTrue(ts.isReal(getType("1.0 % 2")));
		assertTrue(ts.isReal(getType("2 % 1.0")));
		assertTrue(ts.isReal(getType("2 % myReal")));
		assertTrue(ts.isReal(getType("1 % 2 % 3.0")));
	}

	@Test
	public void testModException1() {
		expectOperatorModException();
		getType("true % 5");
	}

	@Test
	public void testModException2() {
		expectOperatorModException();
		getType("false % 5");
	}

	@Test
	public void testModException3() {
		expectOperatorModException();
		getType("5 % false");
	}

	@Test
	public void testModException4() {
		expectOperatorModException();
		getType("true % (3 - 5)");
	}

	@Test
	public void testModException5() {
		expectOperatorModException();
		getType("(3 + 5) % true");
	}

	@Test
	public void testModException6() {
		expectOperatorModException();
		getType("3.0 % true");
	}

	@Test
	public void testModException7() {
		expectOperatorModException();
		getType("3.0 % 'string'");
	}

	@Test
	public void testModException8() {
		expectOperatorModException();
		getType("3.0 % myString");
	}

	@Test
	public void testModException9() {
		expectOperatorModException();
		getType("3.0 % myString");
	}

	// Logical And Or Not
	@Test
	public void testLogicalSuccess() {
		assertTrue(ts.isBoolean(getType("true || false")));
		assertTrue(ts.isBoolean(getType("true || myBool")));
		assertTrue(ts.isBoolean(getType("true || false && true")));
		assertTrue(ts.isBoolean(getType("true || true &&( false || true)")));
		assertTrue(ts.isBoolean(getType("!true")));
		assertTrue(ts.isBoolean(getType("!myBool")));
		assertTrue(ts.isBoolean(getType("!event1")));
		assertTrue(ts.isBoolean(getType("!true && !false")));
		assertTrue(ts.isBoolean(getType("event1 && !event1")));
		assertTrue(ts.isBoolean(getType("event1 || event1")));
	}

	@Test
	public void testLogicalException1() {
		expectLogicalAndException();
		getType("true && 5");
	}

	@Test
	public void testLogicalException2() {
		expectLogicalOrException();
		getType("false || 5");
	}

	@Test
	public void testLogicalException3() {
		expectLogicalAndException();
		getType("5 && false");
	}

	@Test
	public void testLogicalException4() {
		expectLogicalAndException();
		getType("true && (3 - 5)");
	}

	@Test
	public void testLogicalException5() {
		expectLogicalOrException();
		getType("(3 + 5) || true");
	}

	@Test
	public void testLogicalException6() {
		expectLogicalAndException();
		getType("3.0 &&  true");
	}

	@Test
	public void testLogicalException7() {
		expectLogicalNotException();
		getType("!3");
	}

	@Test
	public void testLogicalException8() {
		expectLogicalNotException();
		getType("!1.2");
	}

	@Test
	public void testLogicalException9() {
		expectLogicalNotException();
		getType("!'Test'");
	}

	@Test
	public void testLogicalException10() {
		expectLogicalNotException();
		getType("!myString");
	}

	// LogicalRelation
	@Test
	public void testLogicalRelationSuccess() {
		assertTrue(ts.isBoolean(getType("5 < 3")));
		assertTrue(ts.isBoolean(getType("5.0 < 3")));
		assertTrue(ts.isBoolean(getType("5.0 < myInt")));

		assertTrue(ts.isBoolean(getType("5 <= 3")));
		assertTrue(ts.isBoolean(getType("5.0 <= 3")));
		assertTrue(ts.isBoolean(getType("5.0 <= myInt")));

		assertTrue(ts.isBoolean(getType("5 > 3")));
		assertTrue(ts.isBoolean(getType("5.0 >= 3")));
		assertTrue(ts.isBoolean(getType("5.0 >= myInt")));

		assertTrue(ts.isBoolean(getType("5 == 3")));
		assertTrue(ts.isBoolean(getType("'string' == 'string'")));
		assertTrue(ts.isBoolean(getType("5.0 == 3")));
		assertTrue(ts.isBoolean(getType("true == myBool")));
		assertTrue(ts.isBoolean(getType("true == event1")));

		assertTrue(ts.isBoolean(getType("5 != 3")));
		assertTrue(ts.isBoolean(getType("'string' != 'string'")));
		assertTrue(ts.isBoolean(getType("5.0 != 3")));
		assertTrue(ts.isBoolean(getType("true != myBool")));
		assertTrue(ts.isBoolean(getType("true != event1")));
	}

	@Test
	public void testLogicalRelationSmallerException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		getType("3.0 < true");
	}

	@Test
	public void testLogicalRelationSmallerException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '<'");
		getType("'string' < 5");
	}

	@Test
	public void testLogicalRelationSmallerException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		getType("1.0 < false");
	}


	@Test
	public void testLogicalRelationSmallerEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		getType("3.0 <= true");
	}

	@Test
	public void testLogicalRelationSmallerEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '<='");
		getType("'string' <= 5");
	}

	@Test
	public void testLogicalRelationSmallerEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		getType("1.0 <= false");
	}
	
	@Test
	public void testLogicalRelationGreaterException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>'");
		getType("3.0 > true");
	}

	@Test
	public void testLogicalRelationGreaterException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '>'");
		getType("'string' > 5");
	}

	@Test
	public void testLogicalRelationGreaterException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>'");
		getType("1.0 > false");
	}

	@Test
	public void testLogicalRelationGreaterEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>='");
		getType("3.0 >= true");
	}

	@Test
	public void testLogicalRelationGreaterEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '>='");
		getType("'string' >= 5");
	}

	@Test
	public void testLogicalRelationGreaterEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>='");
		getType("1.0 >= false");
	}

	@Test
	public void testLogicalRelationEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '=='");
		getType("3.0 == true");
	}

	@Test
	public void testLogicalRelationEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '=='");
		getType("'string' == 5");
	}

	@Test
	public void testLogicalRelationEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '=='");
		getType("1.0 == false");
	}

	@Test
	public void testLogicalRelationNotEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '!='");
		getType("3.0 != true");
	}

	@Test
	public void testLogicalRelationNotEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '!='");
		getType("'string' != 5");
	}

	@Test
	public void testLogicalRelationNotEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '!='");
		getType("1.0 != false");
	}

	@Test
	public void testAssignmentSuccess() {
		getType("myInt = 5 * 3");
		getType("myInt = 0x0F * 3");
		getType("myInt = 0x0F * 0x0F");
		getType("myInt = myInt * 0x0F");
		getType("myBool = true || false");
		getType("myString = 'string'");
		getType("myReal = 2.0 - 7");
		getType("myBool = event1");
	}

	@Test
	public void testAssignmentException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		getType("myInt = true");
	}

	@Test
	public void testAssignmentException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		getType("myInt = myBool");
	}

	/**
	 * the {@link STextTestScopeProvider} adds a dummy state named 'chart.r1.A'
	 * to the Scope.
	 */
	@Test
	public void testActiveSuccess() throws Exception {
		assertTrue(ts.isBoolean(getType("active(chart.r1.A)")));
		assertTrue(ts.isBoolean(getType("!active(chart.r1.A)")));
		assertTrue(ts.isBoolean(getType("true || active(chart.r1.A)")));
		assertTrue(ts.isBoolean(getType("active(chart.r1.A) && false")));
		assertTrue(ts.isBoolean(getType("myBool = active(chart.r1.A)")));
	}

	@Test
	public void testActiveException1() throws Exception {
		expectOperatorPlusException();
		getType("active(chart.r1.A) + 1");
	}

	@Test
	public void testActiveException2() throws Exception {
		expectOperatorSubstractException();
		getType("active(chart.r1.A) -1");
	}

	@Test
	public void testActiveException3() throws Exception {
		expectOperatorMultiplyException();
		getType("active(chart.r1.A) *1");
	}

	@Test
	public void testActiveException4() throws Exception {
		expectOperatorDivideException();
		getType("active(chart.r1.A) /1");
	}

	@Test
	public void testActiveException5() throws Exception {
		expectOperatorModException();
		getType("active(chart.r1.A) % true");
	}

	@Test
	public void testActiveException6() throws Exception {
		expectLogicalAndException();
		getType("active(chart.r1.A) && myInt");
	}

	@Test
	public void testActiveException7() throws Exception {
		expectLogicalOrException();
		getType("active(chart.r1.A) || myString");
	}

	@Test
	public void testActiveException8() throws Exception {
		expectLogicalNotException();
		getType("active(chart.r1.A) && !myString");
	}

	@Test
	public void testBitwiseLogicalRelationSuccess() {
		assertTrue(ts.isInteger(getType(" 5 & 3")));
		assertTrue(ts.isInteger(getType(" 5 | 3")));
		assertTrue(ts.isInteger(getType(" 5 ^ 3")));
		assertTrue(ts.isInteger(getType(" ~3")));
		assertTrue(ts.isInteger(getType("3 << 2")));
		assertTrue(ts.isInteger(getType("5 >> 2")));
		assertTrue(ts.isInteger(getType("myInt << 4")));
		assertTrue(ts.isInteger(getType("myInt >> 4")));
	}

	@Test
	public void testBitwiseAndException1() throws Exception {
		expectBitwiseAndException();
		getType(" 5 & true");
	}

	@Test
	public void testBitwiseAndException2() throws Exception {
		expectBitwiseAndException();
		getType(" 5 & 1.0");
	}

	@Test
	public void testBitwiseAndException3() throws Exception {
		expectBitwiseAndException();
		getType(" 5 & 'myString'");
	}

	@Test
	public void testBitwiseOrException1() throws Exception {
		expectBitwiseOrException();
		getType(" 5 | true");
	}

	@Test
	public void testBitwiseOrException2() throws Exception {
		expectBitwiseOrException();
		getType(" 5 | 1.0");
	}

	@Test
	public void testBitwiseOrException3() throws Exception {
		expectBitwiseOrException();
		getType(" 5 | myString");
	}

	@Test
	public void testBitwiseXorException1() throws Exception {
		expectBitwiseXorException();
		getType(" 5 ^ true");
	}

	@Test
	public void testBitwiseXorException2() throws Exception {
		expectBitwiseXorException();
		getType(" 5 ^ 7.0");
	}

	@Test
	public void testBitwiseXorException3() throws Exception {
		expectBitwiseXorException();
		getType(" 5 ^ myString");
	}

	@Test
	public void testBitwiseComplementException1() throws Exception {
		expectBitwiseComplementException();
		getType(" ~true");
	}

	@Test
	public void testBitwiseComplementException2() throws Exception {
		expectBitwiseComplementException();
		getType(" ~9.0 ");
	}

	@Test
	public void testBitwiseComplementException3() throws Exception {
		expectBitwiseComplementException();
		getType(" ~myString");
	}

	@Test
	public void testBitwiseLeftShiftException1() throws Exception {
		expectBitwiseLeftShiftException();
		getType(" 5 << true");
	}

	@Test
	public void testBitwiseLeftShiftException2() throws Exception {
		expectBitwiseLeftShiftException();
		getType(" 5 << 7.0");
	}

	@Test
	public void testBitwiseLeftShiftException3() throws Exception {
		expectBitwiseLeftShiftException();
		getType(" 5 << myString");
	}

	@Test
	public void testBitwiseRightShiftException1() throws Exception {
		expectBitwiseRightShiftException();
		getType(" 5 >> true");
	}

	@Test
	public void testBitwiseRightShiftException2() throws Exception {
		expectBitwiseRightShiftException();
		getType(" 5 >> 7.0");
	}

	@Test
	public void testBitwiseRightShiftException3() throws Exception {
		expectBitwiseRightShiftException();
		getType(" 5 >> myString");
	}

	@Test
	public void testComplexExpressionsSuccess() {
		ts.isBoolean(getType("((((3 * myInt) + 5) % 2) > 97) || false"));
		ts.isBoolean(getType("!true != myBool && (3 > (myReal * 5 + 3))"));
		ts.isInteger(getType("3 * 3 + 7 / (3 * myInt % 8)"));
	}

	@Test
	public void testEventRaisingSuccess() {

		Scope context = createValuedEventsScope();
		// int events
		EObject statement = super.parseExpression("raise intEvent : 42",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
		// bool events
		statement = super.parseExpression("raise boolEvent : myBool", context,
				EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
		// real events
		statement = super.parseExpression("raise realEvent : 2.0 - 3.0",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
		// string events
		statement = super.parseExpression("raise stringEvent : 'string'",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
		// no valued Events
		statement = super.parseExpression("raise event1", internalScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);

	}

	@Test
	public void testValueOfSuccess() {
		Scope context = createValuedEventsScope();
		// int events
		EObject statement = super.parseExpression("valueof(intEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		ts.isInteger(analyzer.getType((Statement) statement));
		// bool events
		statement = super.parseExpression("valueof(boolEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		ts.isBoolean(analyzer.getType((Statement) statement));
		// real events
		statement = super.parseExpression("valueof(realEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		ts.isReal(analyzer.getType((Statement) statement));
		// string events
		statement = super.parseExpression("valueof(stringEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		ts.isString(analyzer.getType((Statement) statement));
		// void events
		statement = super.parseExpression("valueof(voidEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		ts.isVoid(analyzer.getType((Statement) statement));
	}

	@Test
	public void testEventIsRaisedSuccess() {
		EObject statement = super.parseExpression("myBool = abc",
				internalScope(), Expression.class.getSimpleName());
		analyzer.getType((Statement) statement);
	}

	@Test
	public void testEventRaisingException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		EObject statement = super.parseExpression("raise intEvent : true",
				createValuedEventsScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
	}

	@Test
	public void testEventRaisingException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		EObject statement = super.parseExpression("raise intEvent : myBool",
				createValuedEventsScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
	}

	@Test
	public void testEventRaisingException3() {
		Scope context = createValuedEventsScope();
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type null to a variable of type string");
		EObject statement = super.parseExpression("raise stringEvent", context,
				EventRaisingExpression.class.getSimpleName());
		analyzer.getType((Statement) statement);
	}

	@Test
	public void testOperationSuccess() {
		EObject statement = super.parseExpression("myInt = myOpp1()",
				internalScope(), Expression.class.getSimpleName());
		analyzer.getType((Statement) statement);
	}

	@Test
	public void testOperationException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type integer to a variable of type boolean");
		EObject statement = super.parseExpression("myBool = myOpp1()",
				internalScope(), Expression.class.getSimpleName());
		analyzer.getType((Statement) statement);
	}

	@Test
	public void parenthesizedExpression() {
		assertTrue(ts.isBoolean(getType("( true || false )")));
		assertTrue(ts.isInteger(getType("( 5 )")));
		assertTrue(ts.isReal(getType("( 7.5 / 1.2 )")));
		assertTrue(ts.isString(getType("( 'abc' )")));
	}

	/**
	 * 
	 * exception.expect(TypeCheckException.class); exception .expectMessage(
	 * "Can not assign a value of type integer to a variable of type boolean");
	 * EObject statement = super.parseExpression("myBool = myOpp1()", null,
	 * VariableDefinition); analyzer.getType((Statement) statement);
	 * 
	 */

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

	private void expectBitwiseAndException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '&' can only be applied to integers!");

	}

	private void expectBitwiseOrException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '|' can only be applied to integers!");

	}

	private void expectBitwiseXorException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '^' can only be applied to integers!");

	}

	private void expectBitwiseComplementException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '~' can only be applied to integers!");

	}

	private void expectBitwiseLeftShiftException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '<<' can only be applied to integers!");

	}

	private void expectBitwiseRightShiftException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '>>' can only be applied to integers!");

	}

	private Scope createValuedEventsScope() {
		return createInternalScope("internal: var myBool : boolean event intEvent : integer  event boolEvent : boolean event realEvent : real event stringEvent : string event voidEvent : void");
	}

	protected Type getType(String expression) {
		EObject statement = super.parseExpression(expression,
				super.internalScope(), Expression.class.getSimpleName());
		assertNotNull(statement);
		return analyzer.getType((Statement) statement);
	}

}
