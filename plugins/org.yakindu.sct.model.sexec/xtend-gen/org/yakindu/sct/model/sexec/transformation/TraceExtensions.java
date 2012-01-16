package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceRegionEntered;
import org.yakindu.sct.model.sexec.TraceRegionExited;
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
      ReactionFired _createReactionFired = _factory.createReactionFired();
      final ReactionFired rf = _createReactionFired;
      rf.setReaction(r);
      _xblockexpression = (rf);
    }
    return _xblockexpression;
  }
  
  public TraceNodeExecuted newTraceNodeExecuted(final ExecutionNode node) {
    TraceNodeExecuted _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      TraceNodeExecuted _createTraceNodeExecuted = _factory.createTraceNodeExecuted();
      final TraceNodeExecuted t = _createTraceNodeExecuted;
      t.setNode(node);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceStateEntered newTraceStateEntered(final ExecutionState state) {
    TraceStateEntered _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      TraceStateEntered _createTraceStateEntered = _factory.createTraceStateEntered();
      final TraceStateEntered t = _createTraceStateEntered;
      t.setState(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceStateExited newTraceStateExited(final ExecutionState state) {
    TraceStateExited _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      TraceStateExited _createTraceStateExited = _factory.createTraceStateExited();
      final TraceStateExited t = _createTraceStateExited;
      t.setState(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceRegionExited newTraceRegionExited(final ExecutionRegion state) {
    TraceRegionExited _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      TraceRegionExited _createTraceRegionExited = _factory.createTraceRegionExited();
      final TraceRegionExited t = _createTraceRegionExited;
      t.setRegion(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceRegionEntered newTraceRegionEntered(final ExecutionRegion state) {
    TraceRegionEntered _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      TraceRegionEntered _createTraceRegionEntered = _factory.createTraceRegionEntered();
      final TraceRegionEntered t = _createTraceRegionEntered;
      t.setRegion(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public Boolean traceStateExited(final Sequence seq, final ExecutionState state) {
    Boolean _xifexpression = null;
    boolean _isAddTraceSteps = this.isAddTraceSteps();
    if (_isAddTraceSteps) {
      EList<Step> _steps = seq.getSteps();
      TraceStateExited _newTraceStateExited = this.newTraceStateExited(state);
      boolean _add = _steps.add(_newTraceStateExited);
      _xifexpression = _add;
    }
    return _xifexpression;
  }
  
  public Boolean traceRegionExited(final Sequence seq, final ExecutionRegion state) {
    Boolean _xifexpression = null;
    boolean _isAddTraceSteps = this.isAddTraceSteps();
    if (_isAddTraceSteps) {
      EList<Step> _steps = seq.getSteps();
      TraceRegionExited _newTraceRegionExited = this.newTraceRegionExited(state);
      boolean _add = _steps.add(_newTraceRegionExited);
      _xifexpression = _add;
    }
    return _xifexpression;
  }
  
  public Boolean traceRegionEntered(final Sequence seq, final ExecutionRegion state) {
    Boolean _xifexpression = null;
    boolean _isAddTraceSteps = this.isAddTraceSteps();
    if (_isAddTraceSteps) {
      EList<Step> _steps = seq.getSteps();
      TraceRegionEntered _newTraceRegionEntered = this.newTraceRegionEntered(state);
      boolean _add = _steps.add(_newTraceRegionEntered);
      _xifexpression = _add;
    }
    return _xifexpression;
  }
  
  public Boolean traceStateExited(final Sequence seq, final RegularState state) {
    Boolean _xifexpression = null;
    boolean _isAddTraceSteps = this.isAddTraceSteps();
    if (_isAddTraceSteps) {
      ExecutionState _create = this.mapping.create(state);
      Boolean _traceStateExited = this.traceStateExited(seq, _create);
      _xifexpression = _traceStateExited;
    }
    return _xifexpression;
  }
}