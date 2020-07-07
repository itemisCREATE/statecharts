package org.yakindu.sct.model.sexec.interpreter.test;

import java.util.Arrays;
import java.util.function.Consumer;
import org.yakindu.base.expressions.interpreter.base.BaseExecution;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;

@SuppressWarnings("all")
public class SexecExecution extends BaseExecution {
  @Override
  public void provideExecution(final Object program) {
    this.execution(program);
  }
  
  protected void _execution(final Object it) {
  }
  
  protected void _execution(final Sequence it) {
    final Consumer<Step> _function = (Step step) -> {
      this._exec(step);
    };
    it.getSteps().forEach(_function);
  }
  
  public void execution(final Object it) {
    if (it instanceof Sequence) {
      _execution((Sequence)it);
      return;
    } else if (it != null) {
      _execution(it);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
