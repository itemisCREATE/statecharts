package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.Operation;
import org.yakindu.sct.model.stext.stext.OperationCall;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
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
      this.mapChoiceTransitions(sc, ef);
      this.defineRegularStateReactions(ef, sc);
      this.definePseudoStateReactions(ef, sc);
      this.retargetDeclRefs(ef);
      return ef;
    }
  }
  
  public ExecutionFlow mapChoiceTransitions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<Choice> _allChoices = this.sct.allChoices(statechart);
      final Function1<Choice,ExecutionChoice> _function = new Function1<Choice,ExecutionChoice>() {
          public ExecutionChoice apply(final Choice choice) {
            ExecutionChoice _mapChoiceTransition = ModelSequencer.this.mapChoiceTransition(choice);
            return _mapChoiceTransition;
          }
        };
      IterableExtensions.<Choice>forEach(_allChoices, _function);
      return r;
    }
  }
  
  public ExecutionChoice mapChoiceTransition(final Choice choice) {
    {
      ExecutionChoice _create = this.mapping.create(choice);
      final ExecutionChoice _choice = _create;
      EList<Reaction> _reactions = _choice.getReactions();
      EList<Transition> _outgoingTransitions = choice.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = ModelSequencer.this.behaviorMapping.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      return _choice;
    }
  }
  
  public ExecutionFlow defineRegularStateReactions(final ExecutionFlow flow, final Statechart sc) {
    {
      List<RegularState> _allRegularStates = this.sct.allRegularStates(sc);
      final List<RegularState> states = _allRegularStates;
      Iterable<State> _filter = IterableExtensions.<State>filter(states, org.yakindu.sct.model.sgraph.State.class);
      final Function1<State,Boolean> _function = new Function1<State,Boolean>() {
          public Boolean apply(final State s) {
            boolean _isSimple = s.isSimple();
            return ((Boolean)_isSimple);
          }
        };
      Iterable<State> _filter_1 = IterableExtensions.<State>filter(_filter, _function);
      final Function1<State,Sequence> _function_1 = new Function1<State,Sequence>() {
          public Sequence apply(final State s_1) {
            Sequence _defineCycle = ModelSequencer.this.defineCycle(s_1);
            return _defineCycle;
          }
        };
      IterableExtensions.<State>forEach(_filter_1, _function_1);
      Iterable<FinalState> _filter_2 = IterableExtensions.<FinalState>filter(states, org.yakindu.sct.model.sgraph.FinalState.class);
      final Function1<FinalState,Sequence> _function_2 = new Function1<FinalState,Sequence>() {
          public Sequence apply(final FinalState s_2) {
            Sequence _defineCycle_1 = ModelSequencer.this.defineCycle(s_2);
            return _defineCycle_1;
          }
        };
      IterableExtensions.<FinalState>forEach(_filter_2, _function_2);
      return flow;
    }
  }
  
  public void definePseudoStateReactions(final ExecutionFlow flow, final Statechart sc) {
    List<Choice> _allChoices = this.sct.allChoices(sc);
    final Function1<Choice,Sequence> _function = new Function1<Choice,Sequence>() {
        public Sequence apply(final Choice choice) {
          Sequence _defineReaction = ModelSequencer.this.defineReaction(choice);
          return _defineReaction;
        }
      };
    IterableExtensions.<Choice>forEach(_allChoices, _function);
  }
  
  public Sequence defineReaction(final Choice choice) {
    {
      ExecutionChoice _create = this.mapping.create(choice);
      final ExecutionChoice execChoice = _create;
      EList<Reaction> _reactions = execChoice.getReactions();
      final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r) {
            Check _check = r.getCheck();
            boolean _alwaysTrue = ModelSequencer.this.alwaysTrue(_check);
            return ((Boolean)_alwaysTrue);
          }
        };
      Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
      List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
      Reaction _head = IterableExtensions.<Reaction>head(_list);
      final Reaction _default_ = _head;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_default_, null);
      if (_operator_notEquals) {
        EList<Reaction> _reactions_1 = execChoice.getReactions();
        EList<Reaction> _reactions_2 = execChoice.getReactions();
        int _size = _reactions_2.size();
        int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)1));
        _reactions_1.move(_operator_minus, _default_);
      }
      Sequence _createReactionSequence = this.createReactionSequence(execChoice, null);
      final Sequence stateReaction = _createReactionSequence;
      Sequence _reactSequence = execChoice.getReactSequence();
      EList<Step> _steps = _reactSequence.getSteps();
      EList<Step> _steps_1 = stateReaction.getSteps();
      _steps.addAll(_steps_1);
      Sequence _reactSequence_1 = execChoice.getReactSequence();
      _reactSequence_1.setName("react");
      Sequence _reactSequence_2 = execChoice.getReactSequence();
      String _name = choice.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of state ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      _reactSequence_2.setComment(_operator_plus_1);
      if (this._addTraceSteps) {
        Sequence _reactSequence_3 = execChoice.getReactSequence();
        EList<Step> _steps_2 = _reactSequence_3.getSteps();
        ExecutionChoice _create_1 = this.mapping.create(choice);
        TraceNodeExecuted _newTraceNodeExecuted = this.trace.newTraceNodeExecuted(_create_1);
        _steps_2.add(0, _newTraceNodeExecuted);
      }
      Sequence _reactSequence_4 = execChoice.getReactSequence();
      return _reactSequence_4;
    }
  }
  
  public boolean alwaysTrue(final Check check) {
    {
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(check, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Statement _condition = check.getCondition();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, (_condition instanceof org.yakindu.sct.model.stext.stext.PrimitiveValueExpression));
      }
      if (_operator_and) {
        {
          Statement _condition_1 = check.getCondition();
          final PrimitiveValueExpression pve = ((PrimitiveValueExpression) _condition_1);
          boolean _operator_and_1 = false;
          Literal _value = pve.getValue();
          if (!(_value instanceof org.yakindu.sct.model.stext.stext.BoolLiteral)) {
            _operator_and_1 = false;
          } else {
            Literal _value_1 = pve.getValue();
            boolean _isValue = ((BoolLiteral) _value_1).isValue();
            _operator_and_1 = BooleanExtensions.operator_and((_value instanceof org.yakindu.sct.model.stext.stext.BoolLiteral), _isValue);
          }
          return _operator_and_1;
        }
      }
      return false;
    }
  }
  
  public Sequence defineCycle(final RegularState state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      Sequence _createReactionSequence = this.createReactionSequence(execState, null);
      final Sequence stateReaction = _createReactionSequence;
      List<RegularState> _parentStates = this.sgraph.parentStates(state);
      final List<RegularState> parents = _parentStates;
      final Function2<Sequence,RegularState,Sequence> _function = new Function2<Sequence,RegularState,Sequence>() {
          public Sequence apply(final Sequence r , final RegularState s) {
            ExecutionState _create_1 = ModelSequencer.this.mapping.create(s);
            Sequence _createReactionSequence_1 = ModelSequencer.this.createReactionSequence(_create_1, r);
            return _createReactionSequence_1;
          }
        };
      Sequence _fold = IterableExtensions.<RegularState, Sequence>fold(parents, null, _function);
      execState.setReactSequence(_fold);
      Sequence _reactSequence = execState.getReactSequence();
      _reactSequence.setName("react");
      Sequence _reactSequence_1 = execState.getReactSequence();
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of state ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      _reactSequence_1.setComment(_operator_plus_1);
      Sequence _reactSequence_2 = execState.getReactSequence();
      return _reactSequence_2;
    }
  }
  
  public Sequence createReactionSequence(final ExecutionNode state, final Step localStep) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence cycle = _createSequence;
      EList<Reaction> _reactions = state.getReactions();
      final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r) {
            boolean _isTransition = r.isTransition();
            boolean _operator_not = BooleanExtensions.operator_not(_isTransition);
            return ((Boolean)_operator_not);
          }
        };
      Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
      List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
      final List<Reaction> localReactions = _list;
      SexecFactory _factory_1 = this.sexec.factory();
      Sequence _createSequence_1 = _factory_1.createSequence();
      Sequence localSteps = _createSequence_1;
      EList<Step> _steps = localSteps.getSteps();
      final Function1<Reaction,If> _function_1 = new Function1<Reaction,If>() {
          public If apply(final Reaction lr) {
            If _xblockexpression = null;
            {
              SexecFactory _factory_2 = ModelSequencer.this.sexec.factory();
              If _createIf = _factory_2.createIf();
              If ifStep = _createIf;
              Check _check = lr.getCheck();
              CheckRef _newRef = ModelSequencer.this.mapping.newRef(_check);
              ifStep.setCheck(_newRef);
              Step _effect = lr.getEffect();
              Call _newCall = ModelSequencer.this.mapping.newCall(_effect);
              ifStep.setThenStep(_newCall);
              _xblockexpression = (ifStep);
            }
            return _xblockexpression;
          }
        };
      List<If> _map = ListExtensions.<Reaction, If>map(localReactions, _function_1);
      _steps.addAll(_map);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(localStep, null);
      if (_operator_notEquals) {
        EList<Step> _steps_1 = localSteps.getSteps();
        CollectionExtensions.<Step>operator_add(_steps_1, localStep);
      }
      EList<Step> _steps_2 = localSteps.getSteps();
      boolean _isEmpty = _steps_2.isEmpty();
      if (_isEmpty) {
        localSteps = null;
      }
      EList<Reaction> _reactions_1 = state.getReactions();
      final Function1<Reaction,Boolean> _function_2 = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r_1) {
            boolean _isTransition_1 = r_1.isTransition();
            return ((Boolean)_isTransition_1);
          }
        };
      Iterable<Reaction> _filter_1 = IterableExtensions.<Reaction>filter(_reactions_1, _function_2);
      List<Reaction> _list_1 = IterableExtensions.<Reaction>toList(_filter_1);
      final List<Reaction> transitionReactions = _list_1;
      Iterable<Reaction> _reverseView = ListExtensions.<Reaction>reverseView(transitionReactions);
      final Function2<Step,Reaction,Step> _function_3 = new Function2<Step,Reaction,Step>() {
          public Step apply(final Step s , final Reaction reaction) {
            Step _xblockexpression_1 = null;
            {
              SexecFactory _factory_3 = ModelSequencer.this.sexec.factory();
              If _createIf_1 = _factory_3.createIf();
              If ifStep_1 = _createIf_1;
              Check _check_1 = reaction.getCheck();
              CheckRef _newRef_1 = ModelSequencer.this.mapping.newRef(_check_1);
              ifStep_1.setCheck(_newRef_1);
              Step _effect_1 = reaction.getEffect();
              Call _newCall_1 = ModelSequencer.this.mapping.newCall(_effect_1);
              ifStep_1.setThenStep(_newCall_1);
              ifStep_1.setElseStep(s);
              _xblockexpression_1 = (((Step) ifStep_1));
            }
            return _xblockexpression_1;
          }
        };
      Step _fold = IterableExtensions.<Reaction, Step>fold(_reverseView, ((Step) localSteps), _function_3);
      final Step transitionStep = _fold;
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(transitionStep, null);
      if (_operator_notEquals_1) {
        EList<Step> _steps_3 = cycle.getSteps();
        _steps_3.add(transitionStep);
      } else {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(localSteps, null);
        if (_operator_notEquals_2) {
          EList<Step> _steps_4 = cycle.getSteps();
          _steps_4.add(localSteps);
        }
      }
      return cycle;
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