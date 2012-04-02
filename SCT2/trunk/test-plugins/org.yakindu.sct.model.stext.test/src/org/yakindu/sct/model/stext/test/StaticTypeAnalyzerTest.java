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
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.validation.ITypeAnalyzer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class StaticTypeAnalyzerTest extends AbstractSTextTest {

	@Inject
	private ITypeAnalyzer analyzer;
	@Rule
	public ExpectedException exception = ExpectedException.none();

	// Unary
	@Test
	public void testUnarySuccess() {
		// int
		assertTrue(analyzer.isInteger(inferType("1")));
		assertTrue(analyzer.isInteger(inferType("-1")));
		assertTrue(analyzer.isInteger(inferType("0")));
		assertTrue(analyzer.isInteger(inferType("myInt")));
		// real
		assertTrue(analyzer.isReal(inferType("1.0")));
		assertTrue(analyzer.isReal(inferType("-1.0")));
		assertTrue(analyzer.isReal(inferType("0.0")));
		assertTrue(analyzer.isReal(inferType("myReal")));
		// string
		assertTrue(analyzer.isString(inferType("'42'")));
		assertTrue(analyzer.isString(inferType("myString")));
		// boolean
		assertTrue(analyzer.isBoolean(inferType("true")));
		assertTrue(analyzer.isBoolean(inferType("false")));
		assertTrue(analyzer.isBoolean(inferType("myBool")));
	}

	// Add
	@Test
	public void testAddSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 + 2")));
		assertTrue(analyzer.isInteger(inferType("myInt + 2")));
		assertTrue(analyzer.isReal(inferType("1.1 + 2")));
		assertTrue(analyzer.isReal(inferType("2 + 1.0")));
		assertTrue(analyzer.isReal(inferType("1 + 2 + 3.0")));
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

	@Test
	public void testAddException8() {
		expectOperatorPlusException();
		inferType("myInt + 'string'");
	}

	// substract
	@Test
	public void testSubstractSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 - 2")));
		assertTrue(analyzer.isInteger(inferType("myInt - 2")));
		assertTrue(analyzer.isReal(inferType("1.0 - 2")));
		assertTrue(analyzer.isReal(inferType("2 - 1.0")));
		assertTrue(analyzer.isReal(inferType("myReal - 1.0")));
		assertTrue(analyzer.isReal(inferType("1 - 2 - 3.0")));
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

	@Test
	public void testSubstractException8() {
		expectOperatorSubstractException();
		inferType("myReal -  'string'");
	}

	// multiply
	@Test
	public void testMultiplySuccess() {
		assertTrue(analyzer.isInteger(inferType("1 * 2")));
		assertTrue(analyzer.isReal(inferType("myInt * myReal")));
		assertTrue(analyzer.isReal(inferType("1.0 * 2")));
		assertTrue(analyzer.isReal(inferType("2 * 1.0")));
		assertTrue(analyzer.isReal(inferType("1 * 2 * 3.0")));
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

	@Test
	public void testMultiplyException8() {
		expectOperatorMultiplyException();
		inferType("myReal *  'string'");
	}

	// divide
	@Test
	public void testDivideSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 / 2")));
		assertTrue(analyzer.isInteger(inferType("1 / myInt")));
		assertTrue(analyzer.isReal(inferType("1.0 / 2")));
		assertTrue(analyzer.isReal(inferType("2 / 1.0")));
		assertTrue(analyzer.isReal(inferType("1 / 2 / 3.0")));
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

	@Test
	public void testDivideException8() {
		expectOperatorDivideException();
		inferType("3.0 /  myString");
	}

	// mod
	@Test
	public void testModSuccess() {
		assertTrue(analyzer.isInteger(inferType("1 % 2")));
		assertTrue(analyzer.isReal(inferType("1.0 % 2")));
		assertTrue(analyzer.isReal(inferType("2 % 1.0")));
		assertTrue(analyzer.isReal(inferType("2 % myReal")));
		assertTrue(analyzer.isReal(inferType("1 % 2 % 3.0")));
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

	@Test
	public void testModException8() {
		expectOperatorModException();
		inferType("3.0 % myString");
	}

	// Logical And Or Not
	@Test
	public void testLogicalSuccess() {
		assertTrue(analyzer.isBoolean(inferType("true || false")));
		assertTrue(analyzer.isBoolean(inferType("true || myBool")));
		assertTrue(analyzer.isBoolean(inferType("true || false && true")));
		assertTrue(analyzer
				.isBoolean(inferType("true || true &&( false || true)")));
		assertTrue(analyzer.isBoolean(inferType("!true")));
		assertTrue(analyzer.isBoolean(inferType("!myBool")));
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

	@Test
	public void testLogicalException10() {
		expectLogicalNotException();
		inferType("!myString");
	}

	// LogicalRelation
	@Test
	public void testLogicalRelationSuccess() {
		assertTrue(analyzer.isBoolean(inferType("5 < 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 < 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 < myInt")));

		assertTrue(analyzer.isBoolean(inferType("5 <= 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 <= 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 <= myInt")));

		assertTrue(analyzer.isBoolean(inferType("5 > 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 >= 3")));
		assertTrue(analyzer.isBoolean(inferType("5.0 >= myInt")));

		assertTrue(analyzer.isBoolean(inferType("5 == 3")));
		assertTrue(analyzer.isBoolean(inferType("'string' == 'string'")));
		assertTrue(analyzer.isBoolean(inferType("5.0 == 3")));
		assertTrue(analyzer.isBoolean(inferType("true == myBool")));

		assertTrue(analyzer.isBoolean(inferType("5 != 3")));
		assertTrue(analyzer.isBoolean(inferType("'string' != 'string'")));
		assertTrue(analyzer.isBoolean(inferType("5.0 != 3")));
		assertTrue(analyzer.isBoolean(inferType("true != myBool")));
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
	public void testAssignmentSuccess() {
		inferType("myInt = 5 * 3");
		inferType("myBool = true || false");
		inferType("myString = 'string'");
		inferType("myReal = 2.0 - 7");
	}

	@Test
	public void testAssignmentException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		inferType("myInt = true");
	}

	@Test
	public void testAssignmentException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		inferType("myInt = myBool");
	}

	@Test
	public void testComplexExpressionsSuccess() {
		analyzer.isBoolean(inferType("((((3 * myInt) + 5) % 2) > 97) || false"));
		analyzer.isBoolean(inferType("!true != myBool && (3 > (myReal * 5 + 3))"));
		analyzer.isInteger(inferType("3 * 3 + 7 / (3 * myInt % 8)"));
	}

	// TODO: BitwiseOrExpression, BitwiseAndExpression, BitwiseXOrExpression

	@Test
	public void testEventRaisingSuccess() {

		Scope context = createValuedEventsScope();
		// int events
		EObject statement = super.parseExpression("raise intEvent : 42",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
		// bool events
		statement = super.parseExpression("raise boolEvent : myBool", context,
				EventRaisingExpression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
		// real events
		statement = super.parseExpression("raise realEvent : 2.0 - 3.0",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
		// string events
		statement = super.parseExpression("raise stringEvent : 'string'",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
	}

	@Test
	public void testValueOfSuccess() {
		Scope context = createValuedEventsScope();
		// int events
		EObject statement = super.parseExpression("valueof(intEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		analyzer.isInteger(analyzer.inferType((Statement) statement));
		// bool events
		statement = super.parseExpression("valueof(boolEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		analyzer.isBoolean(analyzer.inferType((Statement) statement));
		// real events
		statement = super.parseExpression("valueof(realEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		analyzer.isReal(analyzer.inferType((Statement) statement));
		// string events
		statement = super.parseExpression("valueof(stringEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		analyzer.isString(analyzer.inferType((Statement) statement));
		// void events
		statement = super.parseExpression("valueof(voidEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		analyzer.isVoid(analyzer.inferType((Statement) statement));
	}

	@Test
	public void testEventIsRaisedSuccess() {
		EObject statement = super.parseExpression("myBool = abc",
				createDefaultScope(), Expression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
	}

	@Test
	public void testEventRaisingException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		EObject statement = super.parseExpression("raise intEvent : true",
				createValuedEventsScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
	}

	@Test
	public void testEventRaisingException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		EObject statement = super.parseExpression("raise intEvent : myBool",
				createValuedEventsScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.inferType((Statement) statement);
	}

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

	private Scope createValuedEventsScope() {
		return createContextScope("internal: var myBool : boolean event intEvent : integer = 22 event boolEvent : boolean event realEvent : real event stringEvent : string event voidEvent : void");
	}

	protected Type inferType(String expression) {
		EObject statement = super.parseExpression(expression,
				super.createDefaultScope(), Expression.class.getSimpleName());
		assertNotNull(statement);
		return analyzer.inferType((Statement) statement);
	}

}
