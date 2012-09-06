package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.StextFactory;

@SuppressWarnings("all")
public class FlowOptimizer {
  private boolean _inlineReactions;
  
  public boolean inlineReactions(final boolean b) {
    boolean __inlineReactions = this._inlineReactions = b;
    return __inlineReactions;
  }
  
  private boolean _inlineEntryActions;
  
  public boolean inlineEntryActions(final boolean b) {
    boolean __inlineEntryActions = this._inlineEntryActions = b;
    return __inlineEntryActions;
  }
  
  private boolean _inlineExitActions;
  
  public boolean inlineExitActions(final boolean b) {
    boolean __inlineExitActions = this._inlineExitActions = b;
    return __inlineExitActions;
  }
  
  private boolean _inlineEnterSequences;
  
  public boolean inlineEnterSequences(final boolean b) {
    boolean __inlineEnterSequences = this._inlineEnterSequences = b;
    return __inlineEnterSequences;
  }
  
  private boolean _inlineEnterRegion;
  
  public boolean inlineEnterRegion(final boolean b) {
    boolean __inlineEnterRegion = this._inlineEnterRegion = b;
    return __inlineEnterRegion;
  }
  
  private boolean _inlineExitRegion;
  
  public boolean inlineExitRegion(final boolean b) {
    boolean __inlineExitRegion = this._inlineExitRegion = b;
    return __inlineExitRegion;
  }
  
  private boolean _inlineExitSequences;
  
  public boolean inlineExitSequences(final boolean b) {
    boolean __inlineExitSequences = this._inlineExitSequences = b;
    return __inlineExitSequences;
  }
  
  private boolean _inlineChoices;
  
  public boolean inlineChoices(final boolean b) {
    boolean __inlineChoices = this._inlineChoices = b;
    return __inlineChoices;
  }
  
  private boolean _inlineEntries;
  
  public boolean inlineEntries(final boolean b) {
    boolean __inlineEntries = this._inlineEntries = b;
    return __inlineEntries;
  }
  
  public ExecutionFlow transform(final ExecutionFlow flow) {
    ExecutionFlow _xblockexpression = null;
    {
      this.replaceTrueIfs(flow);
      if (this._inlineReactions) {
        this.inlineReactionChecks(flow);
        this.inlineReactionEffects(flow);
      }
      if (this._inlineEntryActions) {
        EList<ExecutionState> _states = flow.getStates();
        final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
            public void apply(final ExecutionState state) {
              Step _entryAction = state.getEntryAction();
              FlowOptimizer.this.inline(_entryAction);
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states, _function);
      }
      if (this._inlineExitActions) {
        EList<ExecutionState> _states_1 = flow.getStates();
        final Procedure1<ExecutionState> _function_1 = new Procedure1<ExecutionState>() {
            public void apply(final ExecutionState state) {
              Step _exitAction = state.getExitAction();
              FlowOptimizer.this.inline(_exitAction);
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states_1, _function_1);
      }
      if (this._inlineEnterSequences) {
        EList<ExecutionState> _states_2 = flow.getStates();
        final Procedure1<ExecutionState> _function_2 = new Procedure1<ExecutionState>() {
            public void apply(final ExecutionState state) {
              Sequence _enterSequence = state.getEnterSequence();
              FlowOptimizer.this.inline(_enterSequence);
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states_2, _function_2);
      }
      if (this._inlineExitSequences) {
        EList<ExecutionState> _states_3 = flow.getStates();
        final Procedure1<ExecutionState> _function_3 = new Procedure1<ExecutionState>() {
            public void apply(final ExecutionState state) {
              Sequence _exitSequence = state.getExitSequence();
              FlowOptimizer.this.inline(_exitSequence);
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states_3, _function_3);
      }
      if (this._inlineExitRegion) {
        TreeIterator<EObject> _eAllContents = flow.eAllContents();
        Iterator<ExecutionRegion> _filter = Iterators.<ExecutionRegion>filter(_eAllContents, ExecutionRegion.class);
        final Procedure1<ExecutionRegion> _function_4 = new Procedure1<ExecutionRegion>() {
            public void apply(final ExecutionRegion region) {
              Sequence _exitSequence = region.getExitSequence();
              FlowOptimizer.this.inline(_exitSequence);
            }
          };
        IteratorExtensions.<ExecutionRegion>forEach(_filter, _function_4);
      }
      if (this._inlineEnterRegion) {
        TreeIterator<EObject> _eAllContents_1 = flow.eAllContents();
        Iterator<ExecutionRegion> _filter_1 = Iterators.<ExecutionRegion>filter(_eAllContents_1, ExecutionRegion.class);
        final Procedure1<ExecutionRegion> _function_5 = new Procedure1<ExecutionRegion>() {
            public void apply(final ExecutionRegion region) {
              Sequence _enterSequence = region.getEnterSequence();
              FlowOptimizer.this.inline(_enterSequence);
            }
          };
        IteratorExtensions.<ExecutionRegion>forEach(_filter_1, _function_5);
      }
      if (this._inlineChoices) {
        EList<ExecutionNode> _nodes = flow.getNodes();
        Iterable<ExecutionChoice> _filter_2 = Iterables.<ExecutionChoice>filter(_nodes, ExecutionChoice.class);
        final Procedure1<ExecutionChoice> _function_6 = new Procedure1<ExecutionChoice>() {
            public void apply(final ExecutionChoice node) {
              EList<Reaction> _reactions = node.getReactions();
              final Procedure1<Reaction> _function = new Procedure1<Reaction>() {
                  public void apply(final Reaction r) {
                    Check _check = r.getCheck();
                    FlowOptimizer.this.inline(_check);
                    Step _effect = r.getEffect();
                    FlowOptimizer.this.inline(_effect);
                  }
                };
              IterableExtensions.<Reaction>forEach(_reactions, _function);
            }
          };
        IterableExtensions.<ExecutionChoice>forEach(_filter_2, _function_6);
        EList<ExecutionNode> _nodes_1 = flow.getNodes();
        Iterable<ExecutionChoice> _filter_3 = Iterables.<ExecutionChoice>filter(_nodes_1, ExecutionChoice.class);
        final Procedure1<ExecutionChoice> _function_7 = new Procedure1<ExecutionChoice>() {
            public void apply(final ExecutionChoice node) {
              Sequence _reactSequence = node.getReactSequence();
              FlowOptimizer.this.inline(_reactSequence);
            }
          };
        IterableExtensions.<ExecutionChoice>forEach(_filter_3, _function_7);
      }
      if (this._inlineEntries) {
        EList<ExecutionNode> _nodes_2 = flow.getNodes();
        Iterable<ExecutionEntry> _filter_4 = Iterables.<ExecutionEntry>filter(_nodes_2, ExecutionEntry.class);
        final Procedure1<ExecutionEntry> _function_8 = new Procedure1<ExecutionEntry>() {
            public void apply(final ExecutionEntry node) {
              EList<Reaction> _reactions = node.getReactions();
              final Procedure1<Reaction> _function = new Procedure1<Reaction>() {
                  public void apply(final Reaction r) {
                    Check _check = r.getCheck();
                    FlowOptimizer.this.inline(_check);
                    Step _effect = r.getEffect();
                    FlowOptimizer.this.inline(_effect);
                  }
                };
              IterableExtensions.<Reaction>forEach(_reactions, _function);
            }
          };
        IterableExtensions.<ExecutionEntry>forEach(_filter_4, _function_8);
        EList<ExecutionNode> _nodes_3 = flow.getNodes();
        Iterable<ExecutionEntry> _filter_5 = Iterables.<ExecutionEntry>filter(_nodes_3, ExecutionEntry.class);
        final Procedure1<ExecutionEntry> _function_9 = new Procedure1<ExecutionEntry>() {
            public void apply(final ExecutionEntry node) {
              Sequence _reactSequence = node.getReactSequence();
              FlowOptimizer.this.inline(_reactSequence);
            }
          };
        IterableExtensions.<ExecutionEntry>forEach(_filter_5, _function_9);
      }
      _xblockexpression = (flow);
    }
    return _xblockexpression;
  }
  
  public void replaceTrueIfs(final ExecutionFlow flow) {
    TreeIterator<EObject> _eAllContents = flow.eAllContents();
    Iterator<If> _filter = Iterators.<If>filter(_eAllContents, If.class);
    final Function1<If,Boolean> _function = new Function1<If,Boolean>() {
        public Boolean apply(final If i) {
          Check _check = i.getCheck();
          boolean _alwaysTrue = FlowOptimizer.this.alwaysTrue(_check);
          return Boolean.valueOf(_alwaysTrue);
        }
      };
    Iterator<If> _filter_1 = IteratorExtensions.<If>filter(_filter, _function);
    final Procedure1<If> _function_1 = new Procedure1<If>() {
        public void apply(final If i) {
          Step _thenStep = i.getThenStep();
          FlowOptimizer.this.substituteBy(i, _thenStep);
        }
      };
    IteratorExtensions.<If>forEach(_filter_1, _function_1);
  }
  
  public Step substituteBy(final Step orig, final Step substitute) {
    EObject _eContainer = orig.eContainer();
    Step _substitute = this.substitute(_eContainer, orig, substitute);
    return _substitute;
  }
  
  protected Step _substitute(final Object parent, final Step orig, final Step subst) {
    return null;
  }
  
  protected Step _substitute(final Sequence parent, final Step orig, final Step subst) {
    Step _xifexpression = null;
    EList<Step> _steps = parent.getSteps();
    boolean _contains = _steps.contains(orig);
    if (_contains) {
      EList<Step> _steps_1 = parent.getSteps();
      EList<Step> _steps_2 = parent.getSteps();
      int _indexOf = _steps_2.indexOf(orig);
      Step _set = _steps_1.set(_indexOf, subst);
      _xifexpression = _set;
    }
    return _xifexpression;
  }
  
  protected Step _substitute(final If parent, final Step orig, final Step subst) {
    Step _xblockexpression = null;
    {
      Step _thenStep = parent.getThenStep();
      boolean _equals = Objects.equal(_thenStep, orig);
      if (_equals) {
        parent.setThenStep(subst);
      } else {
        Step _elseStep = parent.getElseStep();
        boolean _equals_1 = Objects.equal(_elseStep, orig);
        if (_equals_1) {
          parent.setElseStep(subst);
        }
      }
      _xblockexpression = (subst);
    }
    return _xblockexpression;
  }
  
  public boolean alwaysTrue(final Check check) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(check, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Statement _condition = check.getCondition();
      _and = (_notEquals && (_condition instanceof PrimitiveValueExpression));
    }
    if (_and) {
      Statement _condition_1 = check.getCondition();
      final PrimitiveValueExpression pve = ((PrimitiveValueExpression) _condition_1);
      boolean _and_1 = false;
      Literal _value = pve.getValue();
      if (!(_value instanceof BoolLiteral)) {
        _and_1 = false;
      } else {
        Literal _value_1 = pve.getValue();
        boolean _isValue = ((BoolLiteral) _value_1).isValue();
        _and_1 = ((_value instanceof BoolLiteral) && _isValue);
      }
      return _and_1;
    }
    return false;
  }
  
  protected boolean _empty(final Step step) {
    return false;
  }
  
  protected boolean _empty(final Sequence seq) {
    EList<Step> _steps = seq.getSteps();
    int _size = _steps.size();
    boolean _equals = (_size == 0);
    return _equals;
  }
  
  public void inlineReactionChecks(final ExecutionFlow flow) {
    EList<ExecutionState> _states = flow.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState state) {
          FlowOptimizer.this.inlineReactionChecks(state);
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
  }
  
  public ExecutionState inlineReactionChecks(final ExecutionState state) {
    ExecutionState _xblockexpression = null;
    {
      EList<Reaction> _reactions = state.getReactions();
      final Function1<Reaction,Check> _function = new Function1<Reaction,Check>() {
          public Check apply(final Reaction r) {
            Check _check = r.getCheck();
            return _check;
          }
        };
      List<Check> _map = ListExtensions.<Reaction, Check>map(_reactions, _function);
      final List<Check> checks = IterableExtensions.<Check>toList(_map);
      final Procedure1<Check> _function_1 = new Procedure1<Check>() {
          public void apply(final Check c) {
            FlowOptimizer.this.inline(c);
          }
        };
      IterableExtensions.<Check>forEach(checks, _function_1);
      _xblockexpression = (state);
    }
    return _xblockexpression;
  }
  
  public Check inline(final Check c) {
    Check _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(c, null));
      if (_notEquals) {
        ArrayList<CheckRef> _arrayList = new ArrayList<CheckRef>();
        final List<CheckRef> cRefs = _arrayList;
        EList<CheckRef> _refs = c.getRefs();
        cRefs.addAll(_refs);
        for (final CheckRef ref : cRefs) {
          {
            final Check clone = EcoreUtil.<Check>copy(c);
            EObject _eContainer = ref.eContainer();
            this.substitute(_eContainer, ref, clone);
            ref.setCheck(null);
          }
        }
      }
      _xblockexpression = (c);
    }
    return _xblockexpression;
  }
  
  protected Step _substitute(final EObject owner, final Check pre, final Check post) {
    return null;
  }
  
  protected Step _substitute(final If owner, final Check pre, final Check post) {
    Check _xblockexpression = null;
    {
      Check _check = owner.getCheck();
      boolean _equals = Objects.equal(_check, pre);
      if (_equals) {
        owner.setCheck(post);
      }
      _xblockexpression = (post);
    }
    return _xblockexpression;
  }
  
  public void inlineReactionEffects(final ExecutionFlow flow) {
    EList<ExecutionState> _states = flow.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState state) {
          FlowOptimizer.this.inlineReactionEffects(state);
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
  }
  
  public ExecutionState inlineReactionEffects(final ExecutionState state) {
    ExecutionState _xblockexpression = null;
    {
      EList<Reaction> _reactions = state.getReactions();
      final Function1<Reaction,Step> _function = new Function1<Reaction,Step>() {
          public Step apply(final Reaction r) {
            Step _effect = r.getEffect();
            return _effect;
          }
        };
      List<Step> _map = ListExtensions.<Reaction, Step>map(_reactions, _function);
      final List<Step> effects = IterableExtensions.<Step>toList(_map);
      final Procedure1<Step> _function_1 = new Procedure1<Step>() {
          public void apply(final Step e) {
            FlowOptimizer.this.inline(e);
          }
        };
      IterableExtensions.<Step>forEach(effects, _function_1);
      _xblockexpression = (state);
    }
    return _xblockexpression;
  }
  
  public void inlineEntryAndExitActions(final ExecutionFlow flow) {
    EList<ExecutionState> _states = flow.getStates();
    final Procedure1<ExecutionState> _function = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState state) {
          Step _entryAction = state.getEntryAction();
          FlowOptimizer.this.inline(_entryAction);
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states, _function);
    EList<ExecutionState> _states_1 = flow.getStates();
    final Procedure1<ExecutionState> _function_1 = new Procedure1<ExecutionState>() {
        public void apply(final ExecutionState state) {
          Step _exitAction = state.getExitAction();
          FlowOptimizer.this.inline(_exitAction);
        }
      };
    IterableExtensions.<ExecutionState>forEach(_states_1, _function_1);
  }
  
  public Step inline(final Step step) {
    Step _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(step, null));
      if (_notEquals) {
        ArrayList<Call> _arrayList = new ArrayList<Call>();
        final List<Call> calls = _arrayList;
        EList<Call> _caller = step.getCaller();
        calls.addAll(_caller);
        for (final Call caller : calls) {
          {
            final Step clone = this.stepCopy(step);
            EObject _eContainer = caller.eContainer();
            boolean _substituteCall = this.substituteCall(_eContainer, caller, clone);
            if (_substituteCall) {
              caller.setStep(null);
            } else {
              String _plus = ("Did not substitute \'" + step);
              String _plus_1 = (_plus + "\' call from \'");
              EObject _eContainer_1 = caller.eContainer();
              String _plus_2 = (_plus_1 + _eContainer_1);
              String _plus_3 = (_plus_2 + "\'.");
              System.out.println(_plus_3);
            }
          }
        }
      }
      _xblockexpression = (step);
    }
    return _xblockexpression;
  }
  
  protected boolean _substituteCall(final EObject owner, final Call pre, final Step post) {
    return false;
  }
  
  protected boolean _substituteCall(final StateCase owner, final Call pre, final Step post) {
    Step _step = owner.getStep();
    boolean _equals = Objects.equal(_step, pre);
    if (_equals) {
      owner.setStep(post);
      return true;
    }
    return false;
  }
  
  protected boolean _substituteCall(final HistoryEntry owner, final Call pre, final Step post) {
    Step _initialStep = owner.getInitialStep();
    boolean _equals = Objects.equal(_initialStep, pre);
    if (_equals) {
      owner.setInitialStep(post);
      return true;
    }
    Step _historyStep = owner.getHistoryStep();
    boolean _equals_1 = Objects.equal(_historyStep, pre);
    if (_equals_1) {
      owner.setHistoryStep(post);
      return true;
    }
    return false;
  }
  
  protected boolean _substituteCall(final Sequence owner, final Call call, final Step step) {
    EList<Step> _steps = owner.getSteps();
    boolean _contains = _steps.contains(call);
    if (_contains) {
      EList<Step> _steps_1 = owner.getSteps();
      EList<Step> _steps_2 = owner.getSteps();
      int _indexOf = _steps_2.indexOf(call);
      _steps_1.set(_indexOf, step);
      return true;
    }
    return false;
  }
  
  protected boolean _substituteCall(final If owner, final Call call, final Step step) {
    Step _thenStep = owner.getThenStep();
    boolean _equals = Objects.equal(_thenStep, call);
    if (_equals) {
      owner.setThenStep(step);
      return true;
    } else {
      Step _elseStep = owner.getElseStep();
      boolean _equals_1 = Objects.equal(_elseStep, call);
      if (_equals_1) {
        owner.setElseStep(step);
        return true;
      }
    }
    return false;
  }
  
  protected Step _stepCopy(final Step step) {
    Step _copy = EcoreUtil.<Step>copy(step);
    return _copy;
  }
  
  protected Step _stepCopy(final Sequence seq) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final Sequence _copy = _sexecFactory.createSequence();
      String _name = seq.getName();
      _copy.setName(_name);
      String _comment = seq.getComment();
      _copy.setComment(_comment);
      EList<Step> _steps = _copy.getSteps();
      EList<Step> _steps_1 = seq.getSteps();
      final Function1<Step,Step> _function = new Function1<Step,Step>() {
          public Step apply(final Step s) {
            Step _stepCopy = FlowOptimizer.this.stepCopy(s);
            return _stepCopy;
          }
        };
      List<Step> _map = ListExtensions.<Step, Step>map(_steps_1, _function);
      _steps.addAll(_map);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  protected Step _stepCopy(final If _if) {
    If _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final If _copy = _sexecFactory.createIf();
      String _name = _if.getName();
      _copy.setName(_name);
      String _comment = _if.getComment();
      _copy.setComment(_comment);
      Check _check = _if.getCheck();
      Step _stepCopy = this.stepCopy(_check);
      _copy.setCheck(((Check) _stepCopy));
      Step _xifexpression = null;
      Step _thenStep = _if.getThenStep();
      boolean _notEquals = (!Objects.equal(_thenStep, null));
      if (_notEquals) {
        Step _thenStep_1 = _if.getThenStep();
        Step _stepCopy_1 = this.stepCopy(_thenStep_1);
        _xifexpression = _stepCopy_1;
      } else {
        _xifexpression = null;
      }
      _copy.setThenStep(_xifexpression);
      Step _xifexpression_1 = null;
      Step _elseStep = _if.getElseStep();
      boolean _notEquals_1 = (!Objects.equal(_elseStep, null));
      if (_notEquals_1) {
        Step _elseStep_1 = _if.getElseStep();
        Step _stepCopy_2 = this.stepCopy(_elseStep_1);
        _xifexpression_1 = _stepCopy_2;
      } else {
        _xifexpression_1 = null;
      }
      _copy.setElseStep(_xifexpression_1);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  protected Step _stepCopy(final Call call) {
    Call _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final Call _copy = _sexecFactory.createCall();
      String _name = call.getName();
      _copy.setName(_name);
      String _comment = call.getComment();
      _copy.setComment(_comment);
      Step _step = call.getStep();
      _copy.setStep(_step);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  protected Step _stepCopy(final CheckRef cref) {
    CheckRef _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final CheckRef _copy = _sexecFactory.createCheckRef();
      String _name = cref.getName();
      _copy.setName(_name);
      String _comment = cref.getComment();
      _copy.setComment(_comment);
      Check _check = cref.getCheck();
      _copy.setCheck(_check);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  protected Step _stepCopy(final HistoryEntry cref) {
    HistoryEntry _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final HistoryEntry _copy = _sexecFactory.createHistoryEntry();
      String _name = cref.getName();
      _copy.setName(_name);
      String _comment = cref.getComment();
      _copy.setComment(_comment);
      boolean _isDeep = cref.isDeep();
      _copy.setDeep(_isDeep);
      ExecutionRegion _region = cref.getRegion();
      _copy.setRegion(_region);
      Step _initialStep = cref.getInitialStep();
      Step _stepCopy = this.stepCopy(_initialStep);
      _copy.setInitialStep(_stepCopy);
      Step _historyStep = cref.getHistoryStep();
      Step _stepCopy_1 = this.stepCopy(_historyStep);
      _copy.setHistoryStep(_stepCopy_1);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  protected Step _stepCopy(final StateSwitch _switch) {
    StateSwitch _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final StateSwitch _copy = _sexecFactory.createStateSwitch();
      String _name = _switch.getName();
      _copy.setName(_name);
      String _comment = _switch.getComment();
      _copy.setComment(_comment);
      int _stateConfigurationIdx = _switch.getStateConfigurationIdx();
      _copy.setStateConfigurationIdx(_stateConfigurationIdx);
      EList<StateCase> _cases = _copy.getCases();
      EList<StateCase> _cases_1 = _switch.getCases();
      final Function1<StateCase,StateCase> _function = new Function1<StateCase,StateCase>() {
          public StateCase apply(final StateCase c) {
            StateCase _stepCopy = FlowOptimizer.this.stepCopy(c);
            return _stepCopy;
          }
        };
      List<StateCase> _map = ListExtensions.<StateCase, StateCase>map(_cases_1, _function);
      _cases.addAll(_map);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  public StateCase stepCopy(final StateCase _case) {
    StateCase _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final StateCase _copy = _sexecFactory.createStateCase();
      ExecutionState _state = _case.getState();
      _copy.setState(_state);
      Step _step = _case.getStep();
      Step _stepCopy = this.stepCopy(_step);
      _copy.setStep(_stepCopy);
      _xblockexpression = (_copy);
    }
    return _xblockexpression;
  }
  
  public SexecFactory sexecFactory() {
    return SexecFactory.eINSTANCE;
  }
  
  public SGraphFactory sgraphFactory() {
    return SGraphFactory.eINSTANCE;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public Step substitute(final Object owner, final Step pre, final Step post) {
    if (owner instanceof If
         && pre instanceof Check
         && post instanceof Check) {
      return _substitute((If)owner, (Check)pre, (Check)post);
    } else if (owner instanceof If
         && pre != null
         && post != null) {
      return _substitute((If)owner, pre, post);
    } else if (owner instanceof Sequence
         && pre != null
         && post != null) {
      return _substitute((Sequence)owner, pre, post);
    } else if (owner instanceof EObject
         && pre instanceof Check
         && post instanceof Check) {
      return _substitute((EObject)owner, (Check)pre, (Check)post);
    } else if (owner != null
         && pre != null
         && post != null) {
      return _substitute(owner, pre, post);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(owner, pre, post).toString());
    }
  }
  
  public boolean empty(final Step seq) {
    if (seq instanceof Sequence) {
      return _empty((Sequence)seq);
    } else if (seq != null) {
      return _empty(seq);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(seq).toString());
    }
  }
  
  public boolean substituteCall(final EObject owner, final Call pre, final Step post) {
    if (owner instanceof HistoryEntry) {
      return _substituteCall((HistoryEntry)owner, pre, post);
    } else if (owner instanceof If) {
      return _substituteCall((If)owner, pre, post);
    } else if (owner instanceof Sequence) {
      return _substituteCall((Sequence)owner, pre, post);
    } else if (owner instanceof StateCase) {
      return _substituteCall((StateCase)owner, pre, post);
    } else if (owner != null) {
      return _substituteCall(owner, pre, post);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(owner, pre, post).toString());
    }
  }
  
  public Step stepCopy(final Step cref) {
    if (cref instanceof CheckRef) {
      return _stepCopy((CheckRef)cref);
    } else if (cref instanceof Call) {
      return _stepCopy((Call)cref);
    } else if (cref instanceof HistoryEntry) {
      return _stepCopy((HistoryEntry)cref);
    } else if (cref instanceof If) {
      return _stepCopy((If)cref);
    } else if (cref instanceof Sequence) {
      return _stepCopy((Sequence)cref);
    } else if (cref instanceof StateSwitch) {
      return _stepCopy((StateSwitch)cref);
    } else if (cref != null) {
      return _stepCopy(cref);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(cref).toString());
    }
  }
}
