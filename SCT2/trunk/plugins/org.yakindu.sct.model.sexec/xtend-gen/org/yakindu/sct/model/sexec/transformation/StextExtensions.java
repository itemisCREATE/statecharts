package org.yakindu.sct.model.sexec.transformation;

import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.StextFactory;

/**
 * @author Axel Terfloth added 'active' extension
 */
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
      final LogicalAndExpression and = _factory.createLogicalAndExpression();
      and.setLeftOperand(left);
      and.setRightOperand(right);
      _xblockexpression = (and);
    }
    return _xblockexpression;
  }
  
  public Expression active(final State state) {
    ActiveStateReferenceExpression _xblockexpression = null;
    {
      StextFactory _factory = this.factory();
      final ActiveStateReferenceExpression active = _factory.createActiveStateReferenceExpression();
      active.setValue(state);
      _xblockexpression = (active);
    }
    return _xblockexpression;
  }
}
