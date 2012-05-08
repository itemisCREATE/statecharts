package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sgraph.RegularState;

@SuppressWarnings("all")
public class TraceExtensions {
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public boolean isAddTraceSteps() {
    return this._addTraceSteps;
  }
  
  public ReactionFired newTraceReactionFired(final Reaction r) {
    ReactionFired _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final ReactionFired rf = _factory.createReactionFired();
      rf.setReaction(r);
      _xblockexpression = (rf);
    }
    return _xblockexpression;
  }
  
  public TraceNodeExecuted newTraceNodeExecuted(final ExecutionNode node) {
    TraceNodeExecuted _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final TraceNodeExecuted t = _factory.createTraceNodeExecuted();
      t.setNode(node);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceStateEntered newTraceStateEntered(final ExecutionState state) {
    TraceStateEntered _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final TraceStateEntered t = _factory.createTraceStateEntered();
      t.setState(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceStateExited newTraceStateExited(final ExecutionState state) {
    TraceStateExited _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final TraceStateExited t = _factory.createTraceStateExited();
      t.setState(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public boolean traceStateExited(final Sequence seq, final ExecutionState state) {
    boolean _xifexpression = false;
    boolean _isAddTraceSteps = this.isAddTraceSteps();
    if (_isAddTraceSteps) {
      EList<Step> _steps = seq.getSteps();
      TraceStateExited _newTraceStateExited = this.newTraceStateExited(state);
      boolean _add = _steps.add(_newTraceStateExited);
      _xifexpression = _add;
    }
    return _xifexpression;
  }
  
  public boolean traceStateExited(final Sequence seq, final RegularState state) {
    boolean _xifexpression = false;
    boolean _isAddTraceSteps = this.isAddTraceSteps();
    if (_isAddTraceSteps) {
      ExecutionState _create = this.mapping.create(state);
      boolean _traceStateExited = this.traceStateExited(seq, _create);
      _xifexpression = _traceStateExited;
    }
    return _xifexpression;
  }
}
