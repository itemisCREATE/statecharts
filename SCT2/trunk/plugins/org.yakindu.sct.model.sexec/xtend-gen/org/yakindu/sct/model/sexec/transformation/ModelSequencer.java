package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

@SuppressWarnings("all")
public class ModelSequencer {
  
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  private final HashMap<ArrayList<?>,ExecutionFlow> _createCache_transform = new HashMap<ArrayList<?>,ExecutionFlow>();
  
  public ExecutionFlow transform(final Statechart statechart) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(statechart);
    ExecutionFlow result;
    synchronized (_createCache_transform) {
      if (_createCache_transform.containsKey(_cacheKey)) {
        return _createCache_transform.get(_cacheKey);
      }
      ExecutionFlow _createExecutionFlow = SexecFactory.eINSTANCE.createExecutionFlow();
      result = _createExecutionFlow;
      _createCache_transform.put(_cacheKey, result);
    }
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            boolean _operator_and = false;
            if (!(e instanceof org.yakindu.sct.model.sgraph.State)) {
              _operator_and = false;
            } else {
              boolean _isSimple = ((State) e).isSimple();
              _operator_and = BooleanExtensions.operator_and((e instanceof org.yakindu.sct.model.sgraph.State), _isSimple);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(content, _function);
      Iterable<EObject> leafStates = _filter;
      final Function1<EObject,Boolean> _function_1 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject state) {
            EList<ExecutionState> _states = result.getStates();
            ExecutionState _transform = ModelSequencer.this.transform(((State) state));
            boolean _add = _states.add(_transform);
            return ((Boolean)_add);
          }
        };
      IterableExtensions.<EObject>forEach(leafStates, _function_1);
    }
    return result;
  }
  
  private final HashMap<ArrayList<?>,ExecutionState> _createCache_transform_1 = new HashMap<ArrayList<?>,ExecutionState>();
  
  public ExecutionState transform(final State state) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(state);
    ExecutionState result;
    synchronized (_createCache_transform_1) {
      if (_createCache_transform_1.containsKey(_cacheKey)) {
        return _createCache_transform_1.get(_cacheKey);
      }
      ExecutionState _createExecutionState = SexecFactory.eINSTANCE.createExecutionState();
      result = _createExecutionState;
      _createCache_transform_1.put(_cacheKey, result);
    }
    {
      String _name = state.getName();
      result.setSimpleName(_name);
      QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(state);
      String _string = _fullyQualifiedName.toString();
      result.setName(_string);
    }
    return result;
  }
}