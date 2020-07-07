package org.yakindu.sct.model.sexec.interpreter.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sexec.extensions.SexecBuilder;
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder;
import org.yakindu.sct.model.sruntime.ExecutionSlot;
import org.yakindu.sct.model.sruntime.ExecutionVariable;
import org.yakindu.sct.model.sruntime.SRuntimeFactory;
import org.yakindu.sct.simulation.core.sexec.interpreter.SexecInterpreter;

@SuppressWarnings("all")
public class SexecExecutiontest {
  protected static class TestModule extends AbstractModule {
    @Override
    protected void configure() {
      this.<ITypeSystem>bind(ITypeSystem.class).to(GenericTypeSystem.class);
    }
  }
  
  @Extension
  private SRuntimeFactory sruntimeFactory = SRuntimeFactory.eINSTANCE;
  
  @Inject
  @Extension
  private ExpressionBuilder exprBuilder;
  
  @Inject
  @Extension
  private SexecBuilder sexecBuilder;
  
  @Inject
  @Extension
  private SexecInterpreter sexecInterpreter;
  
  @Before
  public void setUp() {
    SexecExecutiontest.TestModule _testModule = new SexecExecutiontest.TestModule();
    final Injector injector = Guice.createInjector(_testModule);
    injector.injectMembers(this);
  }
  
  @Test
  public void testAssign() {
    final Property x = this.sexecBuilder._variable("x", "integer");
    List<ExecutionSlot> _slots = this.sexecInterpreter.getExecutionContext().getSlots();
    ExecutionVariable _createExecutionVariable = this.sruntimeFactory.createExecutionVariable();
    final Procedure1<ExecutionVariable> _function = (ExecutionVariable it) -> {
      it.setName(x.getName());
    };
    ExecutionVariable _doubleArrow = ObjectExtensions.<ExecutionVariable>operator_doubleArrow(_createExecutionVariable, _function);
    _slots.add(_doubleArrow);
    this.sexecInterpreter.evaluate(this.sexecBuilder._sequence(
      this.sexecBuilder._declare(x), 
      this.sexecBuilder._assign(x, this.exprBuilder._integer(Integer.valueOf(42)))));
    Assert.assertEquals(Long.valueOf(42L), this.sexecInterpreter.getExecutionContext().getSlot("x").getValue());
  }
}
