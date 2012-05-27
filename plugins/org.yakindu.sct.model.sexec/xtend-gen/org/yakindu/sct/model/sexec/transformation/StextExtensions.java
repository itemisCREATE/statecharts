package org.yakindu.sct.model.sexec.transformation;

import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.StextFactory;

@SuppressWarnings("all")
public class StextExtensions {
  public StextFactory factory() {
    return StextFactory.eINSTANCE;
  }
  
  public Expression or(final Expression left, final Expression right) {
    LogicalOrExpression _xblockexpression = null;
    {
      StextFactory _factory = this.factory();
      final LogicalOrExpression or = _factory.createLogicalOrExpression();
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
  
  public Expression and(final Expression left, final Expression right) {
    LogicalAndExpression _xblockexpression = null;
    {
      StextFactory _factory = this.factory();
      final LogicalAndExpression or = _factory.createLogicalAndExpression();
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
}
