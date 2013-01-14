package org.yakindu.sct.model.extensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class SExecExtensions {
  public boolean isTimed(final ExecutionFlow it) {
    EList<Scope> _scopes = it.getScopes();
    final Function1<Scope,Boolean> _function = new Function1<Scope,Boolean>() {
        public Boolean apply(final Scope it) {
          EList<Declaration> _declarations = it.getDeclarations();
          Iterable<TimeEvent> _filter = Iterables.<TimeEvent>filter(_declarations, TimeEvent.class);
          int _size = IterableExtensions.size(_filter);
          boolean _greaterThan = (_size > 0);
          return Boolean.valueOf(_greaterThan);
        }
      };
    Iterable<Scope> _filter = IterableExtensions.<Scope>filter(_scopes, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  public boolean hasHistory(final ExecutionFlow it) {
    boolean _and = false;
    StateVector _historyVector = it.getHistoryVector();
    boolean _notEquals = (!Objects.equal(_historyVector, null));
    if (!_notEquals) {
      _and = false;
    } else {
      StateVector _historyVector_1 = it.getHistoryVector();
      int _size = _historyVector_1.getSize();
      boolean _greaterThan = (_size > 0);
      _and = (_notEquals && _greaterThan);
    }
    return _and;
  }
  
  public boolean hasOutgoingEvents(final Scope it) {
    List<EventDefinition> _outgoingEvents = this.getOutgoingEvents(it);
    boolean _isEmpty = _outgoingEvents.isEmpty();
    boolean _not = (!_isEmpty);
    return _not;
  }
  
  public List<EventDefinition> getOutgoingEvents(final Scope it) {
    ArrayList<EventDefinition> _xblockexpression = null;
    {
      ArrayList<EventDefinition> _arrayList = new ArrayList<EventDefinition>();
      final ArrayList<EventDefinition> events = _arrayList;
      EList<Declaration> _declarations = it.getDeclarations();
      Iterable<EventDefinition> _filter = Iterables.<EventDefinition>filter(_declarations, EventDefinition.class);
      final Procedure1<EventDefinition> _function = new Procedure1<EventDefinition>() {
          public void apply(final EventDefinition ev) {
            Direction _direction = ev.getDirection();
            boolean _equals = Objects.equal(_direction, Direction.OUT);
            if (_equals) {
              events.add(ev);
            }
          }
        };
      IterableExtensions.<EventDefinition>forEach(_filter, _function);
      _xblockexpression = (events);
    }
    return _xblockexpression;
  }
  
  public boolean hasIncomingEvents(final Scope it) {
    List<EventDefinition> _incomingEvents = this.getIncomingEvents(it);
    boolean _isEmpty = _incomingEvents.isEmpty();
    boolean _not = (!_isEmpty);
    return _not;
  }
  
  public List<EventDefinition> getIncomingEvents(final Scope it) {
    ArrayList<EventDefinition> _xblockexpression = null;
    {
      ArrayList<EventDefinition> _arrayList = new ArrayList<EventDefinition>();
      final ArrayList<EventDefinition> events = _arrayList;
      EList<Declaration> _declarations = it.getDeclarations();
      Iterable<EventDefinition> _filter = Iterables.<EventDefinition>filter(_declarations, EventDefinition.class);
      final Procedure1<EventDefinition> _function = new Procedure1<EventDefinition>() {
          public void apply(final EventDefinition ev) {
            Direction _direction = ev.getDirection();
            boolean _equals = Objects.equal(_direction, Direction.IN);
            if (_equals) {
              events.add(ev);
            }
          }
        };
      IterableExtensions.<EventDefinition>forEach(_filter, _function);
      _xblockexpression = (events);
    }
    return _xblockexpression;
  }
  
  public Iterable<InterfaceScope> getInterfaceScopes(final ExecutionFlow it) {
    EList<Scope> _scopes = it.getScopes();
    Iterable<InterfaceScope> _filter = Iterables.<InterfaceScope>filter(_scopes, InterfaceScope.class);
    return _filter;
  }
  
  public Iterable<VariableDefinition> getVariableDefinitions(final Scope it) {
    EList<Declaration> _declarations = it.getDeclarations();
    Iterable<VariableDefinition> _filter = Iterables.<VariableDefinition>filter(_declarations, VariableDefinition.class);
    return _filter;
  }
  
  public InternalScope getInternalScope(final ExecutionFlow it) {
    EList<Scope> _scopes = it.getScopes();
    Iterable<InternalScope> _filter = Iterables.<InternalScope>filter(_scopes, InternalScope.class);
    InternalScope _head = IterableExtensions.<InternalScope>head(_filter);
    return _head;
  }
  
  protected Declaration _definition(final ElementReferenceExpression it) {
    Declaration _xifexpression = null;
    EObject _reference = it.getReference();
    if ((_reference instanceof Declaration)) {
      EObject _reference_1 = it.getReference();
      _xifexpression = ((Declaration) _reference_1);
    }
    return _xifexpression;
  }
  
  protected Declaration _definition(final FeatureCall it) {
    Declaration _xifexpression = null;
    EObject _feature = it.getFeature();
    if ((_feature instanceof Declaration)) {
      EObject _feature_1 = it.getFeature();
      _xifexpression = ((Declaration) _feature_1);
    }
    return _xifexpression;
  }
  
  protected Declaration _definition(final Expression it) {
    return null;
  }
  
  public Event event(final Declaration it) {
    Event _xifexpression = null;
    if ((it instanceof Event)) {
      _xifexpression = ((Event) it);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected List<ExecutionState> _subStates(final ExecutionState it) {
    EList<ExecutionScope> _subScopes = it.getSubScopes();
    ArrayList<ExecutionState> _arrayList = new ArrayList<ExecutionState>();
    final Function2<ArrayList<ExecutionState>,ExecutionScope,ArrayList<ExecutionState>> _function = new Function2<ArrayList<ExecutionState>,ExecutionScope,ArrayList<ExecutionState>>() {
        public ArrayList<ExecutionState> apply(final ArrayList<ExecutionState> a, final ExecutionScope s) {
          ArrayList<ExecutionState> _xblockexpression = null;
          {
            List<ExecutionState> _subStates = SExecExtensions.this.subStates(s);
            a.addAll(_subStates);
            _xblockexpression = (a);
          }
          return _xblockexpression;
        }
      };
    ArrayList<ExecutionState> _fold = IterableExtensions.<ExecutionScope, ArrayList<ExecutionState>>fold(_subScopes, _arrayList, _function);
    return _fold;
  }
  
  protected List<ExecutionState> _subStates(final ExecutionRegion it) {
    EList<ExecutionScope> _subScopes = it.getSubScopes();
    ArrayList<ExecutionState> _arrayList = new ArrayList<ExecutionState>();
    final Function2<ArrayList<ExecutionState>,ExecutionScope,ArrayList<ExecutionState>> _function = new Function2<ArrayList<ExecutionState>,ExecutionScope,ArrayList<ExecutionState>>() {
        public ArrayList<ExecutionState> apply(final ArrayList<ExecutionState> a, final ExecutionScope s) {
          ArrayList<ExecutionState> _xblockexpression = null;
          {
            a.add(((ExecutionState) s));
            List<ExecutionState> _subStates = SExecExtensions.this.subStates(s);
            a.addAll(_subStates);
            _xblockexpression = (a);
          }
          return _xblockexpression;
        }
      };
    ArrayList<ExecutionState> _fold = IterableExtensions.<ExecutionScope, ArrayList<ExecutionState>>fold(_subScopes, _arrayList, _function);
    return _fold;
  }
  
  protected List<ExecutionState> _subStates(final ExecutionScope it) {
    ArrayList<ExecutionState> _arrayList = new ArrayList<ExecutionState>();
    return _arrayList;
  }
  
  public Iterable<Check> referencedChecks(final ExecutionNode it) {
    EList<Reaction> _reactions = it.getReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          boolean _and = false;
          Check _check = r.getCheck();
          boolean _notEquals = (!Objects.equal(_check, null));
          if (!_notEquals) {
            _and = false;
          } else {
            Check _check_1 = r.getCheck();
            EList<CheckRef> _refs = _check_1.getRefs();
            int _size = _refs.size();
            boolean _greaterThan = (_size > 0);
            _and = (_notEquals && _greaterThan);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
    final Function1<Reaction,Check> _function_1 = new Function1<Reaction,Check>() {
        public Check apply(final Reaction it) {
          Check _check = it.getCheck();
          return _check;
        }
      };
    Iterable<Check> _map = IterableExtensions.<Reaction, Check>map(_filter, _function_1);
    return _map;
  }
  
  public Iterable<Step> referencedEffects(final ExecutionNode it) {
    EList<Reaction> _reactions = it.getReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          boolean _and = false;
          Step _effect = r.getEffect();
          boolean _notEquals = (!Objects.equal(_effect, null));
          if (!_notEquals) {
            _and = false;
          } else {
            Step _effect_1 = r.getEffect();
            EList<Call> _caller = _effect_1.getCaller();
            int _size = _caller.size();
            boolean _greaterThan = (_size > 0);
            _and = (_notEquals && _greaterThan);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
    final Function1<Reaction,Step> _function_1 = new Function1<Reaction,Step>() {
        public Step apply(final Reaction r) {
          Step _effect = r.getEffect();
          return _effect;
        }
      };
    Iterable<Step> _map = IterableExtensions.<Reaction, Step>map(_filter, _function_1);
    return _map;
  }
  
  public List<Step> checkFunctions(final ExecutionFlow it) {
    ArrayList<Step> _xblockexpression = null;
    {
      ArrayList<Step> _arrayList = new ArrayList<Step>();
      final ArrayList<Step> funcs = _arrayList;
      Iterable<Check> _referencedChecks = this.referencedChecks(it);
      Iterables.<Step>addAll(funcs, _referencedChecks);
      EList<ExecutionState> _states = it.getStates();
      final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
          public void apply(final ExecutionState s) {
            Iterable<Check> _referencedChecks = SExecExtensions.this.referencedChecks(s);
            Iterables.<Step>addAll(funcs, _referencedChecks);
          }
        };
      IterableExtensions.<ExecutionState>forEach(_states, _function);
      EList<ExecutionNode> _nodes = it.getNodes();
      final Procedure1<ExecutionNode> _function_1 = new Procedure1<ExecutionNode>() {
          public void apply(final ExecutionNode n) {
            Iterable<Check> _referencedChecks = SExecExtensions.this.referencedChecks(n);
            Iterables.<Step>addAll(funcs, _referencedChecks);
          }
        };
      IterableExtensions.<ExecutionNode>forEach(_nodes, _function_1);
      _xblockexpression = (funcs);
    }
    return _xblockexpression;
  }
  
  public List<Step> effectFunctions(final ExecutionFlow it) {
    ArrayList<Step> _arrayList = new ArrayList<Step>();
    final ArrayList<Step> funcs = _arrayList;
    Iterable<Step> _referencedEffects = this.referencedEffects(it);
    Iterables.<Step>addAll(funcs, _referencedEffects);
    EList<ExecutionState> _states = it.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState s) {
          Iterable<Step> _referencedEffects = SExecExtensions.this.referencedEffects(s);
          Iterables.<Step>addAll(funcs, _referencedEffects);
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    EList<ExecutionNode> _nodes = it.getNodes();
    final Procedure1<ExecutionNode> _function_1 = new Procedure1<ExecutionNode>() {
        public void apply(final ExecutionNode n) {
          Iterable<Step> _referencedEffects = SExecExtensions.this.referencedEffects(n);
          Iterables.<Step>addAll(funcs, _referencedEffects);
        }
      };
    IterableExtensions.<ExecutionNode>forEach(_nodes, _function_1);
    return funcs;
  }
  
  public List<Step> entryActionFunctions(final ExecutionFlow it) {
    ArrayList<Step> _arrayList = new ArrayList<Step>();
    final ArrayList<Step> funcs = _arrayList;
    Step _entryAction = it.getEntryAction();
    boolean _isCalled = this.isCalled(_entryAction);
    if (_isCalled) {
      Step _entryAction_1 = it.getEntryAction();
      funcs.add(_entryAction_1);
    }
    EList<ExecutionState> _states = it.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState s) {
          Step _entryAction = s.getEntryAction();
          boolean _isCalled = SExecExtensions.this.isCalled(_entryAction);
          if (_isCalled) {
            Step _entryAction_1 = s.getEntryAction();
            funcs.add(_entryAction_1);
          }
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    return funcs;
  }
  
  public List<Step> exitActionFunctions(final ExecutionFlow it) {
    ArrayList<Step> _arrayList = new ArrayList<Step>();
    final ArrayList<Step> funcs = _arrayList;
    Step _exitAction = it.getExitAction();
    boolean _isCalled = this.isCalled(_exitAction);
    if (_isCalled) {
      Step _exitAction_1 = it.getExitAction();
      funcs.add(_exitAction_1);
    }
    EList<ExecutionState> _states = it.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState s) {
          Step _exitAction = s.getExitAction();
          boolean _isCalled = SExecExtensions.this.isCalled(_exitAction);
          if (_isCalled) {
            Step _exitAction_1 = s.getExitAction();
            funcs.add(_exitAction_1);
          }
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    return funcs;
  }
  
  public boolean isCalled(final Step it) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(it, null));
    if (!_notEquals) {
      _and = false;
    } else {
      EList<Call> _caller = it.getCaller();
      int _size = _caller.size();
      boolean _greaterThan = (_size > 0);
      _and = (_notEquals && _greaterThan);
    }
    return _and;
  }
  
  public List<Step> enterSequenceFunctions(final ExecutionFlow it) {
    ArrayList<Step> _arrayList = new ArrayList<Step>();
    final ArrayList<Step> funcs = _arrayList;
    Sequence _enterSequence = it.getEnterSequence();
    boolean _isCalled = this.isCalled(_enterSequence);
    if (_isCalled) {
      Sequence _enterSequence_1 = it.getEnterSequence();
      funcs.add(_enterSequence_1);
    }
    EList<ExecutionState> _states = it.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState s) {
          Sequence _enterSequence = s.getEnterSequence();
          boolean _isCalled = SExecExtensions.this.isCalled(_enterSequence);
          if (_isCalled) {
            Sequence _enterSequence_1 = s.getEnterSequence();
            funcs.add(_enterSequence_1);
          }
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    EList<ExecutionRegion> _regions = it.getRegions();
    final Procedure1<ExecutionRegion> _function_1 = new Procedure1<ExecutionRegion>() {
        public void apply(final ExecutionRegion s) {
          Sequence _enterSequence = s.getEnterSequence();
          boolean _isCalled = SExecExtensions.this.isCalled(_enterSequence);
          if (_isCalled) {
            Sequence _enterSequence_1 = s.getEnterSequence();
            funcs.add(_enterSequence_1);
          }
          Sequence _deepEnterSequence = s.getDeepEnterSequence();
          boolean _isCalled_1 = SExecExtensions.this.isCalled(_deepEnterSequence);
          if (_isCalled_1) {
            Sequence _deepEnterSequence_1 = s.getDeepEnterSequence();
            funcs.add(_deepEnterSequence_1);
          }
          Sequence _shallowEnterSequence = s.getShallowEnterSequence();
          boolean _isCalled_2 = SExecExtensions.this.isCalled(_shallowEnterSequence);
          if (_isCalled_2) {
            Sequence _shallowEnterSequence_1 = s.getShallowEnterSequence();
            funcs.add(_shallowEnterSequence_1);
          }
        }
      };
    IterableExtensions.<ExecutionRegion>forEach(_regions, _function_1);
    return funcs;
  }
  
  public List<Step> exitSequenceFunctions(final ExecutionFlow it) {
    ArrayList<Step> _arrayList = new ArrayList<Step>();
    final ArrayList<Step> funcs = _arrayList;
    Sequence _exitSequence = it.getExitSequence();
    boolean _isCalled = this.isCalled(_exitSequence);
    if (_isCalled) {
      Sequence _exitSequence_1 = it.getExitSequence();
      funcs.add(_exitSequence_1);
    }
    EList<ExecutionState> _states = it.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState s) {
          Sequence _exitSequence = s.getExitSequence();
          boolean _isCalled = SExecExtensions.this.isCalled(_exitSequence);
          if (_isCalled) {
            Sequence _exitSequence_1 = s.getExitSequence();
            funcs.add(_exitSequence_1);
          }
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    EList<ExecutionRegion> _regions = it.getRegions();
    final Procedure1<ExecutionRegion> _function_1 = new Procedure1<ExecutionRegion>() {
        public void apply(final ExecutionRegion s) {
          Sequence _exitSequence = s.getExitSequence();
          boolean _isCalled = SExecExtensions.this.isCalled(_exitSequence);
          if (_isCalled) {
            Sequence _exitSequence_1 = s.getExitSequence();
            funcs.add(_exitSequence_1);
          }
        }
      };
    IterableExtensions.<ExecutionRegion>forEach(_regions, _function_1);
    return funcs;
  }
  
  public List<Step> reactFunctions(final ExecutionFlow it) {
    ArrayList<Step> _arrayList = new ArrayList<Step>();
    final ArrayList<Step> funcs = _arrayList;
    Sequence _reactSequence = it.getReactSequence();
    boolean _isCalled = this.isCalled(_reactSequence);
    if (_isCalled) {
      Sequence _reactSequence_1 = it.getReactSequence();
      funcs.add(_reactSequence_1);
    }
    EList<ExecutionState> _states = it.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState s) {
          Sequence _reactSequence = s.getReactSequence();
          boolean _isCalled = SExecExtensions.this.isCalled(_reactSequence);
          if (_isCalled) {
            Sequence _reactSequence_1 = s.getReactSequence();
            funcs.add(_reactSequence_1);
          }
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    EList<ExecutionNode> _nodes = it.getNodes();
    final Procedure1<ExecutionNode> _function_1 = new Procedure1<ExecutionNode>() {
        public void apply(final ExecutionNode s) {
          Sequence _reactSequence = s.getReactSequence();
          boolean _isCalled = SExecExtensions.this.isCalled(_reactSequence);
          if (_isCalled) {
            Sequence _reactSequence_1 = s.getReactSequence();
            funcs.add(_reactSequence_1);
          }
        }
      };
    IterableExtensions.<ExecutionNode>forEach(_nodes, _function_1);
    return funcs;
  }
  
  protected Reaction _reaction(final Check it) {
    EObject _eContainer = it.eContainer();
    return ((Reaction) _eContainer);
  }
  
  protected Reaction _reaction(final EObject it) {
    EObject _eContainer = it.eContainer();
    Reaction _reaction = _eContainer==null?(Reaction)null:this.reaction(_eContainer);
    return _reaction;
  }
  
  protected Reaction _reaction(final Reaction it) {
    return it;
  }
  
  public boolean isEntryAction(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isEntryAction = this.isEntryAction(_eContainer, it);
    return _isEntryAction;
  }
  
  protected boolean _isEntryAction(final ExecutionFlow it, final Step s) {
    Step _entryAction = it.getEntryAction();
    boolean _equals = Objects.equal(_entryAction, s);
    return _equals;
  }
  
  protected boolean _isEntryAction(final ExecutionState it, final Step s) {
    Step _entryAction = it.getEntryAction();
    boolean _equals = Objects.equal(_entryAction, s);
    return _equals;
  }
  
  protected boolean _isEntryAction(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isExitAction(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isExitAction = this.isExitAction(_eContainer, it);
    return _isExitAction;
  }
  
  protected boolean _isExitAction(final ExecutionFlow it, final Step s) {
    Step _exitAction = it.getExitAction();
    boolean _equals = Objects.equal(_exitAction, s);
    return _equals;
  }
  
  protected boolean _isExitAction(final ExecutionState it, final Step s) {
    Step _exitAction = it.getExitAction();
    boolean _equals = Objects.equal(_exitAction, s);
    return _equals;
  }
  
  protected boolean _isExitAction(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isEffect(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isEffect = this.isEffect(_eContainer, it);
    return _isEffect;
  }
  
  protected boolean _isEffect(final Reaction it, final Step s) {
    Step _effect = it.getEffect();
    boolean _equals = Objects.equal(_effect, s);
    return _equals;
  }
  
  protected boolean _isEffect(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isEnterSequence(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isEnterSequence = this.isEnterSequence(_eContainer, it);
    return _isEnterSequence;
  }
  
  protected boolean _isEnterSequence(final ExecutionScope it, final Step s) {
    Sequence _enterSequence = it.getEnterSequence();
    boolean _equals = Objects.equal(_enterSequence, s);
    return _equals;
  }
  
  protected boolean _isEnterSequence(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isDeepEnterSequence(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isDeepEnterSequence = this.isDeepEnterSequence(_eContainer, it);
    return _isDeepEnterSequence;
  }
  
  protected boolean _isDeepEnterSequence(final ExecutionRegion it, final Step s) {
    Sequence _deepEnterSequence = it.getDeepEnterSequence();
    boolean _equals = Objects.equal(_deepEnterSequence, s);
    return _equals;
  }
  
  protected boolean _isDeepEnterSequence(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isShallowEnterSequence(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isShallowEnterSequence = this.isShallowEnterSequence(_eContainer, it);
    return _isShallowEnterSequence;
  }
  
  protected boolean _isShallowEnterSequence(final ExecutionRegion it, final Step s) {
    Sequence _shallowEnterSequence = it.getShallowEnterSequence();
    boolean _equals = Objects.equal(_shallowEnterSequence, s);
    return _equals;
  }
  
  protected boolean _isShallowEnterSequence(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isExitSequence(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isExitSequence = this.isExitSequence(_eContainer, it);
    return _isExitSequence;
  }
  
  protected boolean _isExitSequence(final ExecutionScope it, final Step s) {
    Sequence _exitSequence = it.getExitSequence();
    boolean _equals = Objects.equal(_exitSequence, s);
    return _equals;
  }
  
  protected boolean _isExitSequence(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isReactSequence(final Step it) {
    EObject _eContainer = it.eContainer();
    boolean _isReactSequence = this.isReactSequence(_eContainer, it);
    return _isReactSequence;
  }
  
  protected boolean _isReactSequence(final ExecutionNode it, final Step s) {
    Sequence _reactSequence = it.getReactSequence();
    boolean _equals = Objects.equal(_reactSequence, s);
    return _equals;
  }
  
  protected boolean _isReactSequence(final EObject it, final Step s) {
    return false;
  }
  
  public boolean isCheckFunction(final Step it) {
    return (it instanceof Check);
  }
  
  public Declaration definition(final Expression it) {
    if (it instanceof ElementReferenceExpression) {
      return _definition((ElementReferenceExpression)it);
    } else if (it instanceof FeatureCall) {
      return _definition((FeatureCall)it);
    } else if (it != null) {
      return _definition(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public List<ExecutionState> subStates(final ExecutionScope it) {
    if (it instanceof ExecutionRegion) {
      return _subStates((ExecutionRegion)it);
    } else if (it instanceof ExecutionState) {
      return _subStates((ExecutionState)it);
    } else if (it != null) {
      return _subStates(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public Reaction reaction(final EObject it) {
    if (it instanceof Check) {
      return _reaction((Check)it);
    } else if (it instanceof Reaction) {
      return _reaction((Reaction)it);
    } else if (it != null) {
      return _reaction(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public boolean isEntryAction(final EObject it, final Step s) {
    if (it instanceof ExecutionFlow) {
      return _isEntryAction((ExecutionFlow)it, s);
    } else if (it instanceof ExecutionState) {
      return _isEntryAction((ExecutionState)it, s);
    } else if (it != null) {
      return _isEntryAction(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isExitAction(final EObject it, final Step s) {
    if (it instanceof ExecutionFlow) {
      return _isExitAction((ExecutionFlow)it, s);
    } else if (it instanceof ExecutionState) {
      return _isExitAction((ExecutionState)it, s);
    } else if (it != null) {
      return _isExitAction(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isEffect(final EObject it, final Step s) {
    if (it instanceof Reaction) {
      return _isEffect((Reaction)it, s);
    } else if (it != null) {
      return _isEffect(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isEnterSequence(final EObject it, final Step s) {
    if (it instanceof ExecutionScope) {
      return _isEnterSequence((ExecutionScope)it, s);
    } else if (it != null) {
      return _isEnterSequence(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isDeepEnterSequence(final EObject it, final Step s) {
    if (it instanceof ExecutionRegion) {
      return _isDeepEnterSequence((ExecutionRegion)it, s);
    } else if (it != null) {
      return _isDeepEnterSequence(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isShallowEnterSequence(final EObject it, final Step s) {
    if (it instanceof ExecutionRegion) {
      return _isShallowEnterSequence((ExecutionRegion)it, s);
    } else if (it != null) {
      return _isShallowEnterSequence(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isExitSequence(final EObject it, final Step s) {
    if (it instanceof ExecutionScope) {
      return _isExitSequence((ExecutionScope)it, s);
    } else if (it != null) {
      return _isExitSequence(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
  
  public boolean isReactSequence(final EObject it, final Step s) {
    if (it instanceof ExecutionNode) {
      return _isReactSequence((ExecutionNode)it, s);
    } else if (it != null) {
      return _isReactSequence(it, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, s).toString());
    }
  }
}
