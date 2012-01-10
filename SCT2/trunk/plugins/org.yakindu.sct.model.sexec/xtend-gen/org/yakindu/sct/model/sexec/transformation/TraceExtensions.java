package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;

@SuppressWarnings("all")
public class TraceExtensions {
  
  @Inject
  private SexecExtensions sexec;
  
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
}