package org.yakindu.sct.model.sexec.interpreter.test;

import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.base.expressions.interpreter.base.ExpressionInterpreter;
import org.yakindu.base.expressions.interpreter.base.IInterpreter;
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder;

@SuppressWarnings("all")
public class ExpressionExecutionTest {
  @Extension
  private ExpressionBuilder exprBuilder;
  
  @Extension
  private IInterpreter exprInterpreter;
  
  @Before
  public void setUp() {
    ExpressionBuilder _expressionBuilder = new ExpressionBuilder();
    this.exprBuilder = _expressionBuilder;
    ExpressionInterpreter _expressionInterpreter = new ExpressionInterpreter();
    this.exprInterpreter = _expressionInterpreter;
  }
  
  @Test
  public void testPrimitiveIntegerValueExpression() {
    Assert.assertEquals(Long.valueOf(42L), this.exprInterpreter.evaluate(this.exprBuilder._integer(Integer.valueOf(42))));
  }
  
  @Test
  public void testPrimitiveDoubleValueExpression() {
    Assert.assertEquals(Double.valueOf(4.2), this.exprInterpreter.evaluate(this.exprBuilder._double(Double.valueOf(4.2))));
  }
  
  @Test
  public void testPrimitiveFloatValueExpression() {
    Assert.assertEquals(Float.valueOf(4.2f), this.exprInterpreter.evaluate(this.exprBuilder._float(Float.valueOf(4.2f))));
  }
  
  @Test
  public void testTrue() {
    Assert.assertEquals(Boolean.TRUE, this.exprInterpreter.evaluate(this.exprBuilder._true()));
  }
  
  @Test
  public void testFalse() {
    Assert.assertEquals(Boolean.FALSE, this.exprInterpreter.evaluate(this.exprBuilder._false()));
  }
  
  @Test
  public void testParenthesisOfInteger() {
    Assert.assertEquals(Long.valueOf(42L), this.exprInterpreter.evaluate(this.exprBuilder._parenthesis(this.exprBuilder._integer(Integer.valueOf(42)))));
  }
  
  @Test
  public void testLogicalOr() {
    Assert.assertEquals(Boolean.valueOf(true), this.exprInterpreter.evaluate(this.exprBuilder._or(this.exprBuilder._true(), this.exprBuilder._false())));
    Assert.assertEquals(Boolean.valueOf(true), this.exprInterpreter.evaluate(this.exprBuilder._or(this.exprBuilder._false(), this.exprBuilder._true())));
    Assert.assertEquals(Boolean.valueOf(true), this.exprInterpreter.evaluate(this.exprBuilder._or(this.exprBuilder._true(), this.exprBuilder._true())));
    Assert.assertEquals(Boolean.valueOf(false), this.exprInterpreter.evaluate(this.exprBuilder._or(this.exprBuilder._false(), this.exprBuilder._false())));
  }
  
  @Test
  public void testLogicalAnd() {
    Assert.assertEquals(Boolean.valueOf(false), this.exprInterpreter.evaluate(this.exprBuilder._and(this.exprBuilder._true(), this.exprBuilder._false())));
    Assert.assertEquals(Boolean.valueOf(false), this.exprInterpreter.evaluate(this.exprBuilder._and(this.exprBuilder._false(), this.exprBuilder._true())));
    Assert.assertEquals(Boolean.valueOf(true), this.exprInterpreter.evaluate(this.exprBuilder._and(this.exprBuilder._true(), this.exprBuilder._true())));
    Assert.assertEquals(Boolean.valueOf(false), this.exprInterpreter.evaluate(this.exprBuilder._and(this.exprBuilder._false(), this.exprBuilder._false())));
  }
  
  @Test
  public void testPlusMinus() {
    Assert.assertEquals(Long.valueOf(30L), this.exprInterpreter.evaluate(this.exprBuilder._plus(this.exprBuilder._integer(Integer.valueOf(10)), this.exprBuilder._integer(Integer.valueOf(20)))));
    Assert.assertEquals(Long.valueOf(10l), this.exprInterpreter.evaluate(this.exprBuilder._minus(this.exprBuilder._integer(Integer.valueOf(30)), this.exprBuilder._integer(Integer.valueOf(20)))));
    Assert.assertEquals(Long.valueOf(17l), this.exprInterpreter.evaluate(this.exprBuilder._minus(this.exprBuilder._plus(this.exprBuilder._integer(Integer.valueOf(30)), this.exprBuilder._integer(Integer.valueOf(2))), this.exprBuilder._minus(this.exprBuilder._integer(Integer.valueOf(20)), this.exprBuilder._integer(Integer.valueOf(5))))));
  }
  
  @Test
  public void testMultiplicative() {
    Assert.assertEquals(Long.valueOf(200L), this.exprInterpreter.evaluate(this.exprBuilder._multiply(this.exprBuilder._integer(Integer.valueOf(10)), this.exprBuilder._integer(Integer.valueOf(20)))));
    Assert.assertEquals(Long.valueOf(3l), this.exprInterpreter.evaluate(this.exprBuilder._divide(this.exprBuilder._integer(Integer.valueOf(30)), this.exprBuilder._integer(Integer.valueOf(10)))));
    Assert.assertEquals(Long.valueOf(4l), this.exprInterpreter.evaluate(this.exprBuilder._modulo(this.exprBuilder._integer(Integer.valueOf(10)), this.exprBuilder._integer(Integer.valueOf(6)))));
  }
  
  @Test
  public void testBitwise() {
    Assert.assertEquals(Long.valueOf(4L), this.exprInterpreter.evaluate(this.exprBuilder._bitwiseAnd(this.exprBuilder._integer(Integer.valueOf(7)), this.exprBuilder._integer(Integer.valueOf(28)))));
    Assert.assertEquals(Long.valueOf(31l), this.exprInterpreter.evaluate(this.exprBuilder._bitwiseOr(this.exprBuilder._integer(Integer.valueOf(7)), this.exprBuilder._integer(Integer.valueOf(28)))));
    Assert.assertEquals(Long.valueOf(27l), this.exprInterpreter.evaluate(this.exprBuilder._bitwiseXor(this.exprBuilder._integer(Integer.valueOf(7)), this.exprBuilder._integer(Integer.valueOf(28)))));
  }
}
