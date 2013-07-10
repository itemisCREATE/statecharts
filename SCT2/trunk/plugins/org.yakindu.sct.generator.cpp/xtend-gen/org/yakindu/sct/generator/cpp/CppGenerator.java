package org.yakindu.sct.generator.cpp;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.generator.c.StatemachineC;
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator;
import org.yakindu.sct.generator.cpp.IStatemachine;
import org.yakindu.sct.generator.cpp.ITimedStatemachine;
import org.yakindu.sct.generator.cpp.ITimerService;
import org.yakindu.sct.generator.cpp.Navigation;
import org.yakindu.sct.generator.cpp.StatemachineHeader;
import org.yakindu.sct.generator.cpp.Types;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * This is the CPP code generators main class.
 * 
 * @author Markus Mühlbrandt
 */
@SuppressWarnings("all")
public class CppGenerator implements IExecutionFlowGenerator {
  @Inject
  private Types _types;
  
  @Inject
  private ITimedStatemachine _iTimedStatemachine;
  
  @Inject
  private ITimerService _iTimerService;
  
  @Inject
  private IStatemachine _iStatemachine;
  
  @Inject
  private StatemachineHeader _statemachineHeader;
  
  @Inject
  private StatemachineC _statemachineC;
  
  @Inject
  private Navigation _navigation;
  
  public void generate(final ExecutionFlow flow, final GeneratorEntry entry, final IFileSystemAccess fsa) {
    EObject _sourceElement = flow.getSourceElement();
    this._types.generateTypesHpp(flow, ((Statechart) _sourceElement), fsa, entry);
    this._iStatemachine.generateIStatemachine(flow, entry, fsa);
    boolean _isTimed = this._navigation.isTimed(flow);
    if (_isTimed) {
      this._iTimedStatemachine.generateITimedStatemachine(flow, entry, fsa);
      this._iTimerService.generateITimerService(flow, entry, fsa);
    }
    EObject _sourceElement_1 = flow.getSourceElement();
    this._statemachineHeader.generateStatemachineHeader(flow, ((Statechart) _sourceElement_1), fsa, entry);
  }
}
