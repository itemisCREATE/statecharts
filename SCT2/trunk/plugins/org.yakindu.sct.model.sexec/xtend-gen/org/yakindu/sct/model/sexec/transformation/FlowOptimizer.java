package org.yakindu.sct.model.sexec.transformation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.EObjectExtensions;
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
        {
          this.inlineReactionChecks(flow);
          this.inlineReactionEffects(flow);
        }
      }
      if (this._inlineEntryActions) {
        EList<ExecutionState> _states = flow.getStates();
        final Function1<ExecutionState,Step> _function = new Function1<ExecutionState,Step>() {
            public Step apply(final ExecutionState state) {
              Step _entryAction = state.getEntryAction();
              Step _inline = FlowOptimizer.this.inline(_entryAction);
              return _inline;
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states, _function);
      }
      if (this._inlineExitActions) {
        EList<ExecutionState> _states_1 = flow.getStates();
        final Function1<ExecutionState,Step> _function_1 = new Function1<ExecutionState,Step>() {
            public Step apply(final ExecutionState state_1) {
              Step _exitAction = state_1.getExitAction();
              Step _inline_1 = FlowOptimizer.this.inline(_exitAction);
              return _inline_1;
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states_1, _function_1);
      }
      if (this._inlineEnterSequences) {
        EList<ExecutionState> _states_2 = flow.getStates();
        final Function1<ExecutionState,Step> _function_2 = new Function1<ExecutionState,Step>() {
            public Step apply(final ExecutionState state_2) {
              Sequence _enterSequence = state_2.getEnterSequence();
              Step _inline_2 = FlowOptimizer.this.inline(_enterSequence);
              return _inline_2;
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states_2, _function_2);
      }
      if (this._inlineExitSequences) {
        EList<ExecutionState> _states_3 = flow.getStates();
        final Function1<ExecutionState,Step> _function_3 = new Function1<ExecutionState,Step>() {
            public Step apply(final ExecutionState state_3) {
              Sequence _exitSequence = state_3.getExitSequence();
              Step _inline_3 = FlowOptimizer.this.inline(_exitSequence);
              return _inline_3;
            }
          };
        IterableExtensions.<ExecutionState>forEach(_states_3, _function_3);
      }
      if (this._inlineExitRegion) {
        Iterable<EObject> _allContentsIterable = EObjectExtensions.allContentsIterable(flow);
        Iterable<ExecutionRegion> _filter = IterableExtensions.<ExecutionRegion>filter(_allContentsIterable, org.yakindu.sct.model.sexec.ExecutionRegion.class);
        final Function1<ExecutionRegion,Step> _function_4 = new Function1<ExecutionRegion,Step>() {
            public Step apply(final ExecutionRegion region) {
              Sequence _exitSequence_1 = region.getExitSequence();
              Step _inline_4 = FlowOptimizer.this.inline(_exitSequence_1);
              return _inline_4;
            }
          };
        IterableExtensions.<ExecutionRegion>forEach(_filter, _function_4);
      }
      if (this._inlineEnterRegion) {
        Iterable<EObject> _allContentsIterable_1 = EObjectExtensions.allContentsIterable(flow);
        Iterable<ExecutionRegion> _filter_1 = IterableExtensions.<ExecutionRegion>filter(_allContentsIterable_1, org.yakindu.sct.model.sexec.ExecutionRegion.class);
        final Function1<ExecutionRegion,Step> _function_5 = new Function1<ExecutionRegion,Step>() {
            public Step apply(final ExecutionRegion region_1) {
              Sequence _enterSequence_1 = region_1.getEnterSequence();
              Step _inline_5 = FlowOptimizer.this.inline(_enterSequence_1);
              return _inline_5;
            }
          };
        IterableExtensions.<ExecutionRegion>forEach(_filter_1, _function_5);
      }
      if (this._inlineChoices) {
        {
          EList<ExecutionNode> _nodes = flow.getNodes();
          Iterable<ExecutionChoice> _filter_2 = IterableExtensions.<ExecutionChoice>filter(_nodes, org.yakindu.sct.model.sexec.ExecutionChoice.class);
          final Function1<ExecutionChoice,ExecutionChoice> _function_6 = new Function1<ExecutionChoice,ExecutionChoice>() {
              public ExecutionChoice apply(final ExecutionChoice node) {
                ExecutionChoice _xblockexpression_1 = null;
                {
                  EList<Reaction> _reactions = node.getReactions();
                  final Function1<Reaction,Step> _function_7 = new Function1<Reaction,Step>() {
                      public Step apply(final Reaction r) {
                        Step _xblockexpression_2 = null;
                        {
                          Check _check = r.getCheck();
                          FlowOptimizer.this.inline(_check);
                          Step _effect = r.getEffect();
                          Step _inline_6 = FlowOptimizer.this.inline(_effect);
                          _xblockexpression_2 = (_inline_6);
                        }
                        return _xblockexpression_2;
                      }
                    };
                  IterableExtensions.<Reaction>forEach(_reactions, _function_7);
                  _xblockexpression_1 = (node);
                }
                return _xblockexpression_1;
              }
            };
          IterableExtensions.<ExecutionChoice>forEach(_filter_2, _function_6);
          EList<ExecutionNode> _nodes_1 = flow.getNodes();
          Iterable<ExecutionChoice> _filter_3 = IterableExtensions.<ExecutionChoice>filter(_nodes_1, org.yakindu.sct.model.sexec.ExecutionChoice.class);
          final Function1<ExecutionChoice,Step> _function_8 = new Function1<ExecutionChoice,Step>() {
              public Step apply(final ExecutionChoice node_1) {
                Sequence _reactSequence = node_1.getReactSequence();
                Step _inline_7 = FlowOptimizer.this.inline(_reactSequence);
                return _inline_7;
              }
            };
          IterableExtensions.<ExecutionChoice>forEach(_filter_3, _function_8);
        }
      }
      if (this._inlineEntries) {
        {
          EList<ExecutionNode> _nodes_2 = flow.getNodes();
          Iterable<ExecutionEntry> _filter_4 = IterableExtensions.<ExecutionEntry>filter(_nodes_2, org.yakindu.sct.model.sexec.ExecutionEntry.class);
          final Function1<ExecutionEntry,ExecutionEntry> _function_9 = new Function1<ExecutionEntry,ExecutionEntry>() {
              public ExecutionEntry apply(final ExecutionEntry node_2) {
                ExecutionEntry _xblockexpression_3 = null;
                {
                  EList<Reaction> _reactions_1 = node_2.getReactions();
                  final Function1<Reaction,Step> _function_10 = new Function1<Reaction,Step>() {
                      public Step apply(final Reaction r_1) {
                        Step _xblockexpression_4 = null;
                        {
                          Check _check_1 = r_1.getCheck();
                          FlowOptimizer.this.inline(_check_1);
                          Step _effect_1 = r_1.getEffect();
                          Step _inline_8 = FlowOptimizer.this.inline(_effect_1);
                          _xblockexpression_4 = (_inline_8);
                        }
                        return _xblockexpression_4;
                      }
                    };
                  IterableExtensions.<Reaction>forEach(_reactions_1, _function_10);
                  _xblockexpression_3 = (node_2);
                }
                return _xblockexpression_3;
              }
            };
          IterableExtensions.<ExecutionEntry>forEach(_filter_4, _function_9);
          EList<ExecutionNode> _nodes_3 = flow.getNodes();
          Iterable<ExecutionEntry> _filter_5 = IterableExtensions.<ExecutionEntry>filter(_nodes_3, org.yakindu.sct.model.sexec.ExecutionEntry.class);
          final Function1<ExecutionEntry,Step> _function_11 = new Function1<ExecutionEntry,Step>() {
              public Step apply(final ExecutionEntry node_3) {
                Sequence _reactSequence_1 = node_3.getReactSequence();
                Step _inline_9 = FlowOptimizer.this.inline(_reactSequence_1);
                return _inline_9;
              }
            };
          IterableExtensions.<ExecutionEntry>forEach(_filter_5, _function_11);
        }
      }
      _xblockexpression = (flow);
    }
    return _xblockexpression;
  }
  
  public void replaceTrueIfs(final ExecutionFlow flow) {
    Iterable<EObject> _allContentsIterable = EObjectExtensions.allContentsIterable(flow);
    Iterable<If> _filter = IterableExtensions.<If>filter(_allContentsIterable, org.yakindu.sct.model.sexec.If.class);
    final Function1<If,Boolean> _function = new Function1<If,Boolean>() {
        public Boolean apply(final If i) {
          Check _check = i.getCheck();
          boolean _alwaysTrue = FlowOptimizer.this.alwaysTrue(_check);
          return ((Boolean)_alwaysTrue);
        }
      };
    Iterable<If> _filter_1 = IterableExtensions.<If>filter(_filter, _function);
    final Function1<If,Step> _function_1 = new Function1<If,Step>() {
        public Step apply(final If i_1) {
          Step _thenStep = i_1.getThenStep();
          Step _substituteBy = FlowOptimizer.this.substituteBy(i_1, _thenStep);
          return _substituteBy;
        }
      };
    IterableExtensions.<If>forEach(_filter_1, _function_1);
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
      boolean _operator_equals = ObjectExtensions.operator_equals(_thenStep, orig);
      if (_operator_equals) {
        parent.setThenStep(subst);
      } else {
        Step _elseStep = parent.getElseStep();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_elseStep, orig);
        if (_operator_equals_1) {
          parent.setElseStep(subst);
        }
      }
      _xblockexpression = (subst);
    }
    return _xblockexpression;
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
  
  protected boolean _empty(final Step step) {
    return false;
  }
  
  protected boolean _empty(final Sequence seq) {
    EList<Step> _steps = seq.getSteps();
    int _size = _steps.size();
    boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
    return _operator_equals;
  }
  
  public void inlineReactionChecks(final ExecutionFlow flow) {
    EList<ExecutionState> _states = flow.getStates();
    final Function1<ExecutionState,ExecutionState> _function = new Function1<ExecutionState,ExecutionState>() {
        public ExecutionState apply(final ExecutionState state) {
          ExecutionState _inlineReactionChecks = FlowOptimizer.this.inlineReactionChecks(state);
          return _inlineReactionChecks;
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
      List<Check> _list = IterableExtensions.<Check>toList(_map);
      final List<Check> checks = _list;
      final Function1<Check,Check> _function_1 = new Function1<Check,Check>() {
          public Check apply(final Check c) {
            Check _inline = FlowOptimizer.this.inline(c);
            return _inline;
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
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(c, null);
      if (_operator_notEquals) {
        {
          ArrayList<CheckRef> _arrayList = new ArrayList<CheckRef>();
          final List<CheckRef> cRefs = _arrayList;
          EList<CheckRef> _refs = c.getRefs();
          cRefs.addAll(_refs);
          for (final CheckRef ref : cRefs) {
            {
              Check _copy = EcoreUtil.<Check>copy(c);
              final Check clone = _copy;
              EObject _eContainer = ref.eContainer();
              this.substitute(_eContainer, ref, clone);
              ref.setCheck(null);
            }
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
      boolean _operator_equals = ObjectExtensions.operator_equals(_check, pre);
      if (_operator_equals) {
        owner.setCheck(post);
      }
      _xblockexpression = (post);
    }
    return _xblockexpression;
  }
  
  public void inlineReactionEffects(final ExecutionFlow flow) {
    EList<ExecutionState> _states = flow.getStates();
    final Function1<ExecutionState,ExecutionState> _function = new Function1<ExecutionState,ExecutionState>() {
        public ExecutionState apply(final ExecutionState state) {
          ExecutionState _inlineReactionEffects = FlowOptimizer.this.inlineReactionEffects(state);
          return _inlineReactionEffects;
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
      List<Step> _list = IterableExtensions.<Step>toList(_map);
      final List<Step> effects = _list;
      final Function1<Step,Step> _function_1 = new Function1<Step,Step>() {
          public Step apply(final Step e) {
            Step _inline = FlowOptimizer.this.inline(e);
            return _inline;
          }
        };
      IterableExtensions.<Step>forEach(effects, _function_1);
      _xblockexpression = (state);
    }
    return _xblockexpression;
  }
  
  public void inlineEntryAndExitActions(final ExecutionFlow flow) {
    {
      EList<ExecutionState> _states = flow.getStates();
      final Function1<ExecutionState,Step> _function = new Function1<ExecutionState,Step>() {
          public Step apply(final ExecutionState state) {
            Step _entryAction = state.getEntryAction();
            Step _inline = FlowOptimizer.this.inline(_entryAction);
            return _inline;
          }
        };
      IterableExtensions.<ExecutionState>forEach(_states, _function);
      EList<ExecutionState> _states_1 = flow.getStates();
      final Function1<ExecutionState,Step> _function_1 = new Function1<ExecutionState,Step>() {
          public Step apply(final ExecutionState state_1) {
            Step _exitAction = state_1.getExitAction();
            Step _inline_1 = FlowOptimizer.this.inline(_exitAction);
            return _inline_1;
          }
        };
      IterableExtensions.<ExecutionState>forEach(_states_1, _function_1);
    }
  }
  
  public Step inline(final Step step) {
    Step _xblockexpression = null;
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(step, null);
      if (_operator_notEquals) {
        {
          ArrayList<Call> _arrayList = new ArrayList<Call>();
          final List<Call> calls = _arrayList;
          EList<Call> _caller = step.getCaller();
          calls.addAll(_caller);
          for (final Call caller : calls) {
            {
              Step _stepCopy = this.stepCopy(step);
              final Step clone = _stepCopy;
              EObject _eContainer = caller.eContainer();
              boolean _substituteCall = this.substituteCall(_eContainer, caller, clone);
              if (_substituteCall) {
                caller.setStep(null);
              } else {
                String _operator_plus = StringExtensions.operator_plus("Did not substitute \'", step);
                String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\' call from \'");
                EObject _eContainer_1 = caller.eContainer();
                String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _eContainer_1);
                String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "\'.");
                System.out.println(_operator_plus_3);
              }
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
    {
      Step _step = owner.getStep();
      boolean _operator_equals = ObjectExtensions.operator_equals(_step, pre);
      if (_operator_equals) {
        {
          owner.setStep(post);
          return true;
        }
      }
      return false;
    }
  }
  
  protected boolean _substituteCall(final HistoryEntry owner, final Call pre, final Step post) {
    {
      Step _initialStep = owner.getInitialStep();
      boolean _operator_equals = ObjectExtensions.operator_equals(_initialStep, pre);
      if (_operator_equals) {
        {
          owner.setInitialStep(post);
          return true;
        }
      }
      Step _historyStep = owner.getHistoryStep();
      boolean _operator_equals_1 = ObjectExtensions.operator_equals(_historyStep, pre);
      if (_operator_equals_1) {
        {
          owner.setHistoryStep(post);
          return true;
        }
      }
      return false;
    }
  }
  
  protected boolean _substituteCall(final Sequence owner, final Call call, final Step step) {
    {
      EList<Step> _steps = owner.getSteps();
      boolean _contains = _steps.contains(call);
      if (_contains) {
        {
          EList<Step> _steps_1 = owner.getSteps();
          EList<Step> _steps_2 = owner.getSteps();
          int _indexOf = _steps_2.indexOf(call);
          _steps_1.set(_indexOf, step);
          return true;
        }
      }
      return false;
    }
  }
  
  protected boolean _substituteCall(final If owner, final Call call, final Step step) {
    {
      Step _thenStep = owner.getThenStep();
      boolean _operator_equals = ObjectExtensions.operator_equals(_thenStep, call);
      if (_operator_equals) {
        {
          owner.setThenStep(step);
          return true;
        }
      } else {
        Step _elseStep = owner.getElseStep();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_elseStep, call);
        if (_operator_equals_1) {
          {
            owner.setElseStep(step);
            return true;
          }
        }
      }
      return false;
    }
  }
  
  protected Step _stepCopy(final Step step) {
    Step _copy = EcoreUtil.<Step>copy(step);
    return _copy;
  }
  
  protected Step _stepCopy(final Sequence seq) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence _copy = _createSequence;
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
      If _createIf = _sexecFactory.createIf();
      final If _copy = _createIf;
      String _name = _if.getName();
      _copy.setName(_name);
      String _comment = _if.getComment();
      _copy.setComment(_comment);
      Check _check = _if.getCheck();
      Step _stepCopy = this.stepCopy(_check);
      _copy.setCheck(((Check) _stepCopy));
      Step _xifexpression = null;
      Step _thenStep = _if.getThenStep();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_thenStep, null);
      if (_operator_notEquals) {
        Step _thenStep_1 = _if.getThenStep();
        Step _stepCopy_1 = this.stepCopy(_thenStep_1);
        _xifexpression = _stepCopy_1;
      } else {
        _xifexpression = null;
      }
      _copy.setThenStep(_xifexpression);
      Step _xifexpression_1 = null;
      Step _elseStep = _if.getElseStep();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_elseStep, null);
      if (_operator_notEquals_1) {
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
      Call _createCall = _sexecFactory.createCall();
      final Call _copy = _createCall;
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
      CheckRef _createCheckRef = _sexecFactory.createCheckRef();
      final CheckRef _copy = _createCheckRef;
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
      HistoryEntry _createHistoryEntry = _sexecFactory.createHistoryEntry();
      final HistoryEntry _copy = _createHistoryEntry;
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
      StateSwitch _createStateSwitch = _sexecFactory.createStateSwitch();
      final StateSwitch _copy = _createStateSwitch;
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
      StateCase _createStateCase = _sexecFactory.createStateCase();
      final StateCase _copy = _createStateCase;
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
    if ((owner instanceof If)
         && (pre instanceof Check)
         && (post instanceof Check)) {
      return _substitute((If)owner, (Check)pre, (Check)post);
    } else if ((owner instanceof If)
         && (pre instanceof Step)
         && (post instanceof Step)) {
      return _substitute((If)owner, (Step)pre, (Step)post);
    } else if ((owner instanceof Sequence)
         && (pre instanceof Step)
         && (post instanceof Step)) {
      return _substitute((Sequence)owner, (Step)pre, (Step)post);
    } else if ((owner instanceof EObject)
         && (pre instanceof Check)
         && (post instanceof Check)) {
      return _substitute((EObject)owner, (Check)pre, (Check)post);
    } else if ((owner instanceof Object)
         && (pre instanceof Step)
         && (post instanceof Step)) {
      return _substitute((Object)owner, (Step)pre, (Step)post);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(owner, pre, post).toString());
    }
  }
  
  public boolean empty(final Step seq) {
    if ((seq instanceof Sequence)) {
      return _empty((Sequence)seq);
    } else if ((seq instanceof Step)) {
      return _empty((Step)seq);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(seq).toString());
    }
  }
  
  public boolean substituteCall(final EObject owner, final Call pre, final Step post) {
    if ((owner instanceof HistoryEntry)
         && (pre instanceof Call)
         && (post instanceof Step)) {
      return _substituteCall((HistoryEntry)owner, (Call)pre, (Step)post);
    } else if ((owner instanceof If)
         && (pre instanceof Call)
         && (post instanceof Step)) {
      return _substituteCall((If)owner, (Call)pre, (Step)post);
    } else if ((owner instanceof Sequence)
         && (pre instanceof Call)
         && (post instanceof Step)) {
      return _substituteCall((Sequence)owner, (Call)pre, (Step)post);
    } else if ((owner instanceof StateCase)
         && (pre instanceof Call)
         && (post instanceof Step)) {
      return _substituteCall((StateCase)owner, (Call)pre, (Step)post);
    } else if ((owner instanceof EObject)
         && (pre instanceof Call)
         && (post instanceof Step)) {
      return _substituteCall((EObject)owner, (Call)pre, (Step)post);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(owner, pre, post).toString());
    }
  }
  
  public Step stepCopy(final Step cref) {
    if ((cref instanceof CheckRef)) {
      return _stepCopy((CheckRef)cref);
    } else if ((cref instanceof Call)) {
      return _stepCopy((Call)cref);
    } else if ((cref instanceof HistoryEntry)) {
      return _stepCopy((HistoryEntry)cref);
    } else if ((cref instanceof If)) {
      return _stepCopy((If)cref);
    } else if ((cref instanceof Sequence)) {
      return _stepCopy((Sequence)cref);
    } else if ((cref instanceof StateSwitch)) {
      return _stepCopy((StateSwitch)cref);
    } else if ((cref instanceof Step)) {
      return _stepCopy((Step)cref);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(cref).toString());
    }
  }
}