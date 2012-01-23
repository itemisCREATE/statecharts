package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.ReactionBuilder;
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.Operation;
import org.yakindu.sct.model.stext.stext.OperationCall;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class ModelSequencer {
  
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private StatechartExtensions sct;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private StructureMapping structureMapping;
  
  @Inject
  private BehaviorMapping behaviorMapping;
  
  @Inject
  private ReactionBuilder reactBuilder;
  
  @Inject
  private SequenceBuilder seqBuilder;
  
  @Inject
  private StateVectorBuilder svBuilder;
  
  @Inject
  private TraceExtensions trace;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public ExecutionFlow transform(final Statechart sc) {
    {
      ExecutionFlow _create = this.mapping.create(sc);
      final ExecutionFlow ef = _create;
      this.structureMapping.mapScopes(sc, ef);
      this.structureMapping.mapRegularStates(sc, ef);
      this.structureMapping.mapRegions(sc, ef);
      this.structureMapping.mapPseudoStates(sc, ef);
      this.structureMapping.mapTimeEvents(sc, ef);
      this.svBuilder.defineStateVector(ef, sc);
      this.svBuilder.defineHistoryStateVector(ef, sc);
      this.behaviorMapping.mapEntryActions(sc, ef);
      this.behaviorMapping.mapExitActions(sc, ef);
      this.seqBuilder.defineStateEnterSequences(ef, sc);
      this.seqBuilder.defineStateExitSequences(ef, sc);
      this.seqBuilder.defineStatechartEnterSequence(ef, sc);
      this.seqBuilder.defineStatechartExitSequence(ef, sc);
      this.behaviorMapping.mapTransitions(sc, ef);
      this.behaviorMapping.mapLocalReactions(sc, ef);
      this.behaviorMapping.mapChoiceTransitions(sc, ef);
      this.reactBuilder.defineEntryReactions(sc, ef);
      this.reactBuilder.defineRegularStateReactions(ef, sc);
      this.reactBuilder.definePseudoStateReactions(ef, sc);
      this.retargetDeclRefs(ef);
      return ef;
    }
  }
  
  public void retargetDeclRefs(final ExecutionFlow flow) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(flow);
      final List<EObject> allContent = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            boolean _operator_or = false;
            boolean _operator_or_1 = false;
            if ((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition)) {
              _operator_or_1 = true;
            } else {
              _operator_or_1 = BooleanExtensions.operator_or((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition), (e instanceof org.yakindu.sct.model.stext.stext.VariableDefinition));
            }
            if (_operator_or_1) {
              _operator_or = true;
            } else {
              _operator_or = BooleanExtensions.operator_or(_operator_or_1, (e instanceof org.yakindu.sct.model.stext.stext.Operation));
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(allContent, _function);
      Set<EObject> _set = IterableExtensions.<EObject>toSet(_filter);
      final Set<EObject> declared = _set;
      Iterable<ElementReferenceExpression> _filter_1 = IterableExtensions.<ElementReferenceExpression>filter(allContent, org.yakindu.sct.model.stext.stext.ElementReferenceExpression.class);
      final Function1<ElementReferenceExpression,Object> _function_1 = new Function1<ElementReferenceExpression,Object>() {
          public Object apply(final ElementReferenceExpression ere) {
            Object _retarget = ModelSequencer.this.retarget(ere, declared);
            return _retarget;
          }
        };
      IterableExtensions.<ElementReferenceExpression>forEach(_filter_1, _function_1);
      Iterable<Assignment> _filter_2 = IterableExtensions.<Assignment>filter(allContent, org.yakindu.sct.model.stext.stext.Assignment.class);
      final Function1<Assignment,Object> _function_2 = new Function1<Assignment,Object>() {
          public Object apply(final Assignment ere_1) {
            Object _retarget_1 = ModelSequencer.this.retarget(ere_1, declared);
            return _retarget_1;
          }
        };
      IterableExtensions.<Assignment>forEach(_filter_2, _function_2);
      Iterable<OperationCall> _filter_3 = IterableExtensions.<OperationCall>filter(allContent, org.yakindu.sct.model.stext.stext.OperationCall.class);
      final Function1<OperationCall,Object> _function_3 = new Function1<OperationCall,Object>() {
          public Object apply(final OperationCall call) {
            Object _retarget_2 = ModelSequencer.this.retarget(call, declared);
            return _retarget_2;
          }
        };
      IterableExtensions.<OperationCall>forEach(_filter_3, _function_3);
    }
  }
  
  public Object retarget(final ElementReferenceExpression ere, final Collection<EObject> declared) {
    Object _xifexpression = null;
    Declaration _value = ere.getValue();
    boolean _contains = declared.contains(_value);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Declaration _value_1 = ere.getValue();
      Declaration _replaced = this.replaced(_value_1);
      ere.setValue(_replaced);
    }
    return _xifexpression;
  }
  
  public Object retarget(final Assignment assign, final Collection<EObject> declared) {
    Object _xifexpression = null;
    Variable _varRef = assign.getVarRef();
    boolean _contains = declared.contains(_varRef);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Variable _varRef_1 = assign.getVarRef();
      Declaration _replaced = this.replaced(((VariableDefinition) _varRef_1));
      assign.setVarRef(((Variable) _replaced));
    }
    return _xifexpression;
  }
  
  public Object retarget(final OperationCall call, final Collection<EObject> declared) {
    Object _xifexpression = null;
    Operation _operation = call.getOperation();
    boolean _contains = declared.contains(_operation);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Operation _operation_1 = call.getOperation();
      Declaration _replaced = this.replaced(_operation_1);
      call.setOperation(((Operation) _replaced));
    }
    return _xifexpression;
  }
  
  protected Declaration _replaced(final VariableDefinition vd) {
    VariableDefinition _create = this.mapping.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final Operation vd) {
    Operation _create = this.mapping.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final EventDefinition ed) {
    EventDefinition _create = this.mapping.create(ed);
    return _create;
  }
  
  protected Declaration _replaced(final TimeEvent ed) {
    return ed;
  }
  
  public Declaration replaced(final Declaration ed) {
    if ((ed instanceof TimeEvent)) {
      return _replaced((TimeEvent)ed);
    } else if ((ed instanceof EventDefinition)) {
      return _replaced((EventDefinition)ed);
    } else if ((ed instanceof VariableDefinition)) {
      return _replaced((VariableDefinition)ed);
    } else if ((ed instanceof Operation)) {
      return _replaced((Operation)ed);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(ed).toString());
    }
  }
}