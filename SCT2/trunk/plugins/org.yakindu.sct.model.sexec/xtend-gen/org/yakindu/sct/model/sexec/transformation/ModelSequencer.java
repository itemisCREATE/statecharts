package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.Cycle;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.transformation.FactoryExtension;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class ModelSequencer {
  
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private FactoryExtension factory;
  
  @Inject
  private StatechartExtensions sct;
  
  public ExecutionFlow transform(final Statechart sc) {
    {
      ExecutionFlow _create = this.factory.create(sc);
      final ExecutionFlow ef = _create;
      this.mapScopes(sc, ef);
      this.mapStates(sc, ef);
      this.defineStateVector(ef, sc);
      this.defineEnterSequence(ef, sc);
      this.defineStateCycles(ef, sc);
      this.retargetDeclRefs(ef);
      return ef;
    }
  }
  
  public ExecutionFlow mapScopes(final Statechart sc, final ExecutionFlow flow) {
    ExecutionFlow _xblockexpression = null;
    {
      EList<Scope> _scopes = flow.getScopes();
      EList<Scope> _scopes_1 = sc.getScopes();
      final Function1<Scope,Scope> _function = new Function1<Scope,Scope>() {
          public Scope apply(final Scope scope) {
            Scope _map = ModelSequencer.this.map(scope);
            return _map;
          }
        };
      List<Scope> _map_1 = ListExtensions.<Scope, Scope>map(_scopes_1, _function);
      _scopes.addAll(_map_1);
      _xblockexpression = (flow);
    }
    return _xblockexpression;
  }
  
  public Scope map(final Scope scope) {
    {
      Scope _create = this.factory.create(scope);
      final Scope _scope = _create;
      EList<Declaration> _declarations = _scope.getDeclarations();
      EList<Declaration> _declarations_1 = scope.getDeclarations();
      final Function1<Declaration,Declaration> _function = new Function1<Declaration,Declaration>() {
          public Declaration apply(final Declaration decl) {
            Declaration _map = ModelSequencer.this.map(decl);
            return _map;
          }
        };
      List<Declaration> _map_1 = ListExtensions.<Declaration, Declaration>map(_declarations_1, _function);
      final Function1<Declaration,Boolean> _function_1 = new Function1<Declaration,Boolean>() {
          public Boolean apply(final Declaration e) {
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(e, null);
            return ((Boolean)_operator_notEquals);
          }
        };
      Iterable<Declaration> _filter = IterableExtensions.<Declaration>filter(_map_1, _function_1);
      CollectionExtensions.<Declaration>addAll(_declarations, _filter);
      return _scope;
    }
  }
  
  protected Declaration _map(final Declaration decl) {
    return null;
  }
  
  protected Declaration _map(final EventDefinition e) {
    {
      EventDefinition _create = this.factory.create(e);
      final EventDefinition _e = _create;
      return _e;
    }
  }
  
  protected Declaration _map(final VariableDefinition v) {
    {
      VariableDefinition _create = this.factory.create(v);
      final VariableDefinition _v = _create;
      return _v;
    }
  }
  
  public ExecutionFlow mapStates(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            return (e instanceof org.yakindu.sct.model.sgraph.State);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(content, _function);
      final Iterable<EObject> allStates = _filter;
      EList<ExecutionState> _states = r.getStates();
      final Function1<EObject,ExecutionState> _function_1 = new Function1<EObject,ExecutionState>() {
          public ExecutionState apply(final EObject s) {
            ExecutionState _mapState = ModelSequencer.this.mapState(((State) s));
            return _mapState;
          }
        };
      Iterable<ExecutionState> _map = IterableExtensions.<EObject, ExecutionState>map(allStates, _function_1);
      CollectionExtensions.<ExecutionState>addAll(_states, _map);
      return r;
    }
  }
  
  public ExecutionState mapState(final State state) {
    ExecutionState _xblockexpression = null;
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = ModelSequencer.this.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      boolean _isSimple = state.isSimple();
      _state.setLeaf(_isSimple);
      _xblockexpression = (_state);
    }
    return _xblockexpression;
  }
  
  public Reaction mapTransition(final Transition t) {
    {
      Reaction _create = this.factory.create(t);
      final Reaction r = _create;
      Trigger _trigger = t.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = t.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(t);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  public Sequence mapToEffect(final Transition t) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence sequence = _createSequence;
      Vertex _source = t.getSource();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_source, null);
      if (_operator_notEquals) {
        EList<Step> _steps = sequence.getSteps();
        Vertex _source_1 = t.getSource();
        ExitState _newExitStateStep = this.newExitStateStep(((State) _source_1));
        _steps.add(_newExitStateStep);
      }
      Effect _effect = t.getEffect();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_effect, null);
      if (_operator_notEquals_1) {
        EList<Step> _steps_1 = sequence.getSteps();
        Effect _effect_1 = t.getEffect();
        Sequence _mapEffect = this.mapEffect(_effect_1);
        _steps_1.add(_mapEffect);
      }
      Vertex _target = t.getTarget();
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_target, null);
      if (_operator_notEquals_2) {
        EList<Step> _steps_2 = sequence.getSteps();
        Vertex _target_1 = t.getTarget();
        EnterState _newEnterStateStep = this.newEnterStateStep(((State) _target_1));
        _steps_2.add(_newEnterStateStep);
      }
      return sequence;
    }
  }
  
  protected Sequence _mapEffect(final Effect effect) {
    return null;
  }
  
  protected Sequence _mapEffect(final ReactionEffect effect) {
    Sequence _xifexpression = null;
    EList<Statement> _actions = effect.getActions();
    boolean _isEmpty = _actions.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    if (_operator_not) {
      {
        SexecFactory _sexecFactory = this.sexecFactory();
        Sequence _createSequence = _sexecFactory.createSequence();
        final Sequence sequence = _createSequence;
        sequence.setName("reaction_action");
        EList<Step> _steps = sequence.getSteps();
        EList<Statement> _actions_1 = effect.getActions();
        final Function1<Statement,Execution> _function = new Function1<Statement,Execution>() {
            public Execution apply(final Statement stmnt) {
              Execution _mapToExecution = ModelSequencer.this.mapToExecution(stmnt);
              return _mapToExecution;
            }
          };
        List<Execution> _map = ListExtensions.<Statement, Execution>map(_actions_1, _function);
        _steps.addAll(_map);
        return sequence;
      }
    }
    return _xifexpression;
  }
  
  public Execution mapToExecution(final Statement stmnt) {
    Execution _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Execution _createExecution = _sexecFactory.createExecution();
      final Execution exec = _createExecution;
      Statement _copy = EcoreUtil.<Statement>copy(stmnt);
      exec.setStatement(_copy);
      _xblockexpression = (exec);
    }
    return _xblockexpression;
  }
  
  public ExecutionFlow defineStateCycles(final ExecutionFlow flow, final Statechart sc) {
    {
      EList<ExecutionState> _states = flow.getStates();
      final Function1<ExecutionState,Boolean> _function = new Function1<ExecutionState,Boolean>() {
          public Boolean apply(final ExecutionState s) {
            boolean _isLeaf = s.isLeaf();
            return ((Boolean)_isLeaf);
          }
        };
      Iterable<ExecutionState> _filter = IterableExtensions.<ExecutionState>filter(_states, _function);
      final Function1<ExecutionState,Cycle> _function_1 = new Function1<ExecutionState,Cycle>() {
          public Cycle apply(final ExecutionState s_1) {
            Cycle _defineCycle = ModelSequencer.this.defineCycle(s_1);
            return _defineCycle;
          }
        };
      IterableExtensions.<ExecutionState>forEach(_filter, _function_1);
      return flow;
    }
  }
  
  public Cycle defineCycle(final ExecutionState state) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Cycle _createCycle = _sexecFactory.createCycle();
      final Cycle cycle = _createCycle;
      state.setCycle(cycle);
      EList<Reaction> _reactions = state.getReactions();
      Iterable<Reaction> _reverseView = ListExtensions.<Reaction>reverseView(_reactions);
      final Function2<If,Reaction,If> _function = new Function2<If,Reaction,If>() {
          public If apply(final If s , final Reaction reaction) {
            If _xblockexpression = null;
            {
              SexecFactory _sexecFactory_1 = ModelSequencer.this.sexecFactory();
              If _createIf = _sexecFactory_1.createIf();
              If ifStep = _createIf;
              Check _check = reaction.getCheck();
              CheckRef _newRef = ModelSequencer.this.factory.newRef(_check);
              ifStep.setCheck(_newRef);
              Step _effect = reaction.getEffect();
              Call _newCall = ModelSequencer.this.factory.newCall(_effect);
              ifStep.setThenStep(_newCall);
              ifStep.setElseStep(s);
              _xblockexpression = (ifStep);
            }
            return _xblockexpression;
          }
        };
      If _fold = IterableExtensions.<Reaction, If>fold(_reverseView, ((If) null), _function);
      final If step = _fold;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(step, null);
      if (_operator_notEquals) {
        EList<Step> _steps = cycle.getSteps();
        _steps.add(step);
      }
      return cycle;
    }
  }
  
  protected Check _mapToCheck(final Trigger tr) {
    return null;
  }
  
  protected Check _mapToCheck(final ReactionTrigger tr) {
    {
      Check _createCheck = this.factory.createCheck(tr);
      final Check check = _createCheck;
      Statement _buildCondition = this.buildCondition(tr);
      check.setCondition(_buildCondition);
      return check;
    }
  }
  
  protected Statement _buildCondition(final Trigger t) {
    return null;
  }
  
  protected Statement _buildCondition(final ReactionTrigger t) {
    Expression _xifexpression = null;
    EList<EventSpec> _triggers = t.getTriggers();
    boolean _isEmpty = _triggers.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    if (_operator_not) {
      EList<EventSpec> _triggers_1 = t.getTriggers();
      Iterable<EventSpec> _reverseView = ListExtensions.<EventSpec>reverseView(_triggers_1);
      final Function2<Expression,EventSpec,Expression> _function = new Function2<Expression,EventSpec,Expression>() {
          public Expression apply(final Expression s , final EventSpec e) {
            Expression _xifexpression_1 = null;
            boolean _operator_equals = ObjectExtensions.operator_equals(s, null);
            if (_operator_equals) {
              Expression _raised = ModelSequencer.this.raised(e);
              _xifexpression_1 = _raised;
            } else {
              Expression _raised_1 = ModelSequencer.this.raised(e);
              Expression _or = ModelSequencer.this.or(_raised_1, s);
              _xifexpression_1 = _or;
            }
            return _xifexpression_1;
          }
        };
      Expression _fold = IterableExtensions.<EventSpec, Expression>fold(_reverseView, ((Expression) null), _function);
      _xifexpression = _fold;
    }
    return _xifexpression;
  }
  
  public Expression or(final Expression left, final Expression right) {
    LogicalOrExpression _xblockexpression = null;
    {
      StextFactory _stextFactory = this.stextFactory();
      LogicalOrExpression _createLogicalOrExpression = _stextFactory.createLogicalOrExpression();
      final LogicalOrExpression or = _createLogicalOrExpression;
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
  
  protected Expression _raised(final EventSpec e) {
    return null;
  }
  
  protected Expression _raised(final RegularEventSpec e) {
    {
      StextFactory _stextFactory = this.stextFactory();
      ElementReferenceExpression _createElementReferenceExpression = _stextFactory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      Event _event = e.getEvent();
      EventDefinition _create = this.factory.create(((EventDefinition) _event));
      r.setValue(_create);
      return r;
    }
  }
  
  public void defineStateVector(final ExecutionFlow flow, final Statechart sc) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      StateVector _createStateVector = _sexecFactory.createStateVector();
      flow.setStateVector(_createStateVector);
      StateVector _stateVector = flow.getStateVector();
      _stateVector.setOffset(0);
      StateVector _stateVector_1 = flow.getStateVector();
      int _maxOrthogonality = this.sct.maxOrthogonality(sc);
      _stateVector_1.setSize(_maxOrthogonality);
    }
  }
  
  public Sequence defineEnterSequence(final ExecutionFlow flow, final Statechart sc) {
    {
      EList<Region> _regions = sc.getRegions();
      final Function1<Region,EnterState> _function = new Function1<Region,EnterState>() {
          public EnterState apply(final Region r) {
            Entry _entry = ModelSequencer.this.entry(r);
            State _target = ModelSequencer.this.target(_entry);
            EnterState _newEnterStateStep = ModelSequencer.this==null?(EnterState)null:ModelSequencer.this.newEnterStateStep(_target);
            return _newEnterStateStep;
          }
        };
      List<EnterState> _map = ListExtensions.<Region, EnterState>map(_regions, _function);
      final Function1<EnterState,Boolean> _function_1 = new Function1<EnterState,Boolean>() {
          public Boolean apply(final EnterState e) {
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(e, null);
            return ((Boolean)_operator_notEquals);
          }
        };
      Iterable<EnterState> _filter = IterableExtensions.<EnterState>filter(_map, _function_1);
      final Iterable<EnterState> enterSteps = _filter;
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence enterSequence = _createSequence;
      enterSequence.setName("enter");
      final Function1<EnterState,Boolean> _function_2 = new Function1<EnterState,Boolean>() {
          public Boolean apply(final EnterState e_1) {
            EList<Step> _steps = enterSequence.getSteps();
            boolean _add = _steps.add(e_1);
            return ((Boolean)_add);
          }
        };
      IterableExtensions.<EnterState>forEach(enterSteps, _function_2);
      flow.setEnterSequence(enterSequence);
      return enterSequence;
    }
  }
  
  public EnterState newEnterStateStep(final State s) {
    {
      EnterState ess = ((EnterState) null);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      if (_operator_notEquals) {
        {
          SexecFactory _sexecFactory = this.sexecFactory();
          EnterState _createEnterState = _sexecFactory.createEnterState();
          ess = _createEnterState;
          ExecutionState _create = this.factory.create(s);
          ess.setState(_create);
        }
      }
      return ess;
    }
  }
  
  public ExitState newExitStateStep(final State s) {
    {
      ExitState ess = ((ExitState) null);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      if (_operator_notEquals) {
        {
          SexecFactory _sexecFactory = this.sexecFactory();
          ExitState _createExitState = _sexecFactory.createExitState();
          ess = _createExitState;
          ExecutionState _create = this.factory.create(s);
          ess.setState(_create);
        }
      }
      return ess;
    }
  }
  
  public void retargetDeclRefs(final ExecutionFlow flow) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(flow);
      final List<EObject> allContent = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            boolean _operator_or = false;
            if ((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition)) {
              _operator_or = true;
            } else {
              _operator_or = BooleanExtensions.operator_or((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition), (e instanceof org.yakindu.sct.model.stext.stext.VariableDefinition));
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(allContent, _function);
      List<EObject> _list = IterableExtensions.<EObject>toList(_filter);
      final List<EObject> declared = _list;
      final Function1<EObject,Boolean> _function_1 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e_1) {
            return (e_1 instanceof org.yakindu.sct.model.stext.stext.ElementReferenceExpression);
          }
        };
      Iterable<EObject> _filter_1 = IterableExtensions.<EObject>filter(allContent, _function_1);
      final Function1<EObject,ElementReferenceExpression> _function_2 = new Function1<EObject,ElementReferenceExpression>() {
          public ElementReferenceExpression apply(final EObject s) {
            return ((ElementReferenceExpression) s);
          }
        };
      Iterable<ElementReferenceExpression> _map = IterableExtensions.<EObject, ElementReferenceExpression>map(_filter_1, _function_2);
      final Function1<ElementReferenceExpression,Object> _function_3 = new Function1<ElementReferenceExpression,Object>() {
          public Object apply(final ElementReferenceExpression ere) {
            Object _retarget = ModelSequencer.this.retarget(ere, declared);
            return _retarget;
          }
        };
      IterableExtensions.<ElementReferenceExpression>forEach(_map, _function_3);
      final Function1<EObject,Boolean> _function_4 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e_2) {
            return (e_2 instanceof org.yakindu.sct.model.stext.stext.Assignment);
          }
        };
      Iterable<EObject> _filter_2 = IterableExtensions.<EObject>filter(allContent, _function_4);
      final Function1<EObject,Assignment> _function_5 = new Function1<EObject,Assignment>() {
          public Assignment apply(final EObject s_1) {
            return ((Assignment) s_1);
          }
        };
      Iterable<Assignment> _map_1 = IterableExtensions.<EObject, Assignment>map(_filter_2, _function_5);
      final Function1<Assignment,Object> _function_6 = new Function1<Assignment,Object>() {
          public Object apply(final Assignment ere_1) {
            Object _retarget_1 = ModelSequencer.this.retarget(ere_1, declared);
            return _retarget_1;
          }
        };
      IterableExtensions.<Assignment>forEach(_map_1, _function_6);
    }
  }
  
  public Object retarget(final ElementReferenceExpression ere, final List<EObject> declared) {
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
  
  public Object retarget(final Assignment assign, final List<EObject> declared) {
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
  
  protected Declaration _replaced(final VariableDefinition vd) {
    VariableDefinition _create = this.factory.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final EventDefinition ed) {
    EventDefinition _create = this.factory.create(ed);
    return _create;
  }
  
  public SexecFactory sexecFactory() {
    return SexecFactory.eINSTANCE;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public Entry entry(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    final Function1<Vertex,Boolean> _function = new Function1<Vertex,Boolean>() {
        public Boolean apply(final Vertex v) {
          boolean _operator_and = false;
          if (!(v instanceof org.yakindu.sct.model.sgraph.Entry)) {
            _operator_and = false;
          } else {
            boolean _operator_or = false;
            boolean _operator_or_1 = false;
            String _name = v.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, null);
            if (_operator_equals) {
              _operator_or_1 = true;
            } else {
              String _name_1 = v.getName();
              boolean _equals = "".equals(_name_1);
              _operator_or_1 = BooleanExtensions.operator_or(_operator_equals, _equals);
            }
            if (_operator_or_1) {
              _operator_or = true;
            } else {
              String _name_2 = v.getName();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_2, "default");
              _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_1);
            }
            _operator_and = BooleanExtensions.operator_and((v instanceof org.yakindu.sct.model.sgraph.Entry), _operator_or);
          }
          return ((Boolean)_operator_and);
        }
      };
    Vertex _findFirst = IterableExtensions.<Vertex>findFirst(_vertices, _function);
    return ((Entry) _findFirst);
  }
  
  public State target(final Entry entry) {
    EList<Transition> _outgoingTransitions = entry==null?(EList<Transition>)null:entry.getOutgoingTransitions();
    Transition _get = _outgoingTransitions==null?(Transition)null:_outgoingTransitions.get(0);
    Vertex _target = _get==null?(Vertex)null:_get.getTarget();
    return ((State) _target);
  }
  
  public Declaration map(final Declaration e) {
    if ((e instanceof EventDefinition)) {
      return _map((EventDefinition)e);
    } else if ((e instanceof VariableDefinition)) {
      return _map((VariableDefinition)e);
    } else if ((e instanceof Declaration)) {
      return _map((Declaration)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e).toString());
    }
  }
  
  public Sequence mapEffect(final Effect effect) {
    if ((effect instanceof ReactionEffect)) {
      return _mapEffect((ReactionEffect)effect);
    } else if ((effect instanceof Effect)) {
      return _mapEffect((Effect)effect);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(effect).toString());
    }
  }
  
  public Check mapToCheck(final Trigger tr) {
    if ((tr instanceof ReactionTrigger)) {
      return _mapToCheck((ReactionTrigger)tr);
    } else if ((tr instanceof Trigger)) {
      return _mapToCheck((Trigger)tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(tr).toString());
    }
  }
  
  public Statement buildCondition(final Trigger t) {
    if ((t instanceof ReactionTrigger)) {
      return _buildCondition((ReactionTrigger)t);
    } else if ((t instanceof Trigger)) {
      return _buildCondition((Trigger)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(t).toString());
    }
  }
  
  public Expression raised(final EventSpec e) {
    if ((e instanceof RegularEventSpec)) {
      return _raised((RegularEventSpec)e);
    } else if ((e instanceof EventSpec)) {
      return _raised((EventSpec)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e).toString());
    }
  }
  
  public Declaration replaced(final Declaration ed) {
    if ((ed instanceof EventDefinition)) {
      return _replaced((EventDefinition)ed);
    } else if ((ed instanceof VariableDefinition)) {
      return _replaced((VariableDefinition)ed);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(ed).toString());
    }
  }
}