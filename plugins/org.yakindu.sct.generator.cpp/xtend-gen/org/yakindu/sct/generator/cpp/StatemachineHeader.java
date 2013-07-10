package org.yakindu.sct.generator.cpp;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.LinkedList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Type;
import org.yakindu.sct.generator.c.GenmodelEntries;
import org.yakindu.sct.generator.c.Statemachine;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.cpp.Naming;
import org.yakindu.sct.generator.cpp.Navigation;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class StatemachineHeader extends Statemachine {
  @Inject
  private Naming cNaming;
  
  @Inject
  private Navigation _navigation;
  
  @Inject
  private ICodegenTypeSystemAccess _iCodegenTypeSystemAccess;
  
  @Inject
  private GenmodelEntries _genmodelEntries;
  
  public void generateStatemachineHeader(final ExecutionFlow flow, final Statechart sc, final IFileSystemAccess fsa, final GeneratorEntry entry) {
    String _module = this.cNaming.module(flow);
    String _hpp = this.cNaming.hpp(_module);
    CharSequence _statemachineHContent = this.statemachineHContent(flow, entry);
    fsa.generateFile(_hpp, _statemachineHContent);
  }
  
  public CharSequence statemachineHContent(final ExecutionFlow it, final GeneratorEntry entry) {
    StringConcatenation _builder = new StringConcatenation();
    String _licenseText = this._genmodelEntries.getLicenseText(entry);
    _builder.append(_licenseText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#ifndef ");
    String _module = this.cNaming.module(it);
    String _define = this.cNaming.define(_module);
    _builder.append(_define, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    String _module_1 = this.cNaming.module(it);
    String _define_1 = this.cNaming.define(_module_1);
    _builder.append(_define_1, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"");
    String _typesModule = this.cNaming.typesModule(it);
    String _hpp = this.cNaming.hpp(_typesModule);
    _builder.append(_hpp, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("#include \"");
    String _iStatemachine = this.cNaming.iStatemachine();
    String _hpp_1 = this.cNaming.hpp(_iStatemachine);
    _builder.append(_hpp_1, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      boolean _isTimed = this._navigation.isTimed(it);
      if (_isTimed) {
        _builder.append("#include \"");
        String _iTimedStatemachine = this.cNaming.iTimedStatemachine();
        String _hpp_2 = this.cNaming.hpp(_iTimedStatemachine);
        _builder.append(_hpp_2, "");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("/*! \\file Header of the state machine \'");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\'.");
    _builder.newLineIfNotEmpty();
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _module_2 = this.cNaming.module(it);
    _builder.append(_module_2, "");
    _builder.append(" : ");
    String _interfaceExtensions = this.getInterfaceExtensions(it);
    _builder.append(_interfaceExtensions, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _statesEnumDecl = this.statesEnumDecl(it);
    _builder.append(_statesEnumDecl, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    {
      EList<Scope> _scopes = it.getScopes();
      for(final Scope s : _scopes) {
        CharSequence _createScope = this.createScope(s, entry);
        _builder.append(_createScope, "		");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<Scope> _scopes_1 = it.getScopes();
      Iterable<InternalScope> _filter = Iterables.<InternalScope>filter(_scopes_1, InternalScope.class);
      for(final InternalScope s_1 : _filter) {
        _builder.append("\t\t");
        CharSequence _scopeFunctionPrototypes = this.scopeFunctionPrototypes(s_1);
        _builder.append(_scopeFunctionPrototypes, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*! Checks if the specified state is active. */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sc_boolean ");
    String _nameOfIsActiveFunction = this.cNaming.nameOfIsActiveFunction(it);
    _builder.append(_nameOfIsActiveFunction, "		");
    _builder.append("(");
    String _statesEnumType = this.cNaming.statesEnumType(it);
    _builder.append(_statesEnumType, "		");
    _builder.append(" state);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private:");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _statemachineTypeDecl = this.statemachineTypeDecl(it);
    _builder.append(_statemachineTypeDecl, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* ");
    String _module_3 = this.cNaming.module(it);
    String _define_2 = this.cNaming.define(_module_3);
    _builder.append(_define_2, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String getInterfaceExtensions(final ExecutionFlow flow) {
    String interfaces = "";
    boolean _isTimed = this._navigation.isTimed(flow);
    if (_isTimed) {
      String _plus = (interfaces + "public ");
      String _iTimedStatemachine = this.cNaming.iTimedStatemachine();
      String _plus_1 = (_plus + _iTimedStatemachine);
      String _plus_2 = (_plus_1 + ", ");
      interfaces = _plus_2;
    }
    String _plus_3 = (interfaces + "public ");
    String _iStatemachine = this.cNaming.iStatemachine();
    String _plus_4 = (_plus_3 + _iStatemachine);
    interfaces = _plus_4;
    return interfaces;
  }
  
  private CharSequence createScope(final Scope scope, final GeneratorEntry entry) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (scope instanceof InterfaceScope) {
        final InterfaceScope _interfaceScope = (InterfaceScope)scope;
        _matched=true;
        CharSequence _createScope = this.createScope(_interfaceScope, entry);
        _switchResult = _createScope;
      }
    }
    if (!_matched) {
      if (scope instanceof InternalScope) {
        final InternalScope _internalScope = (InternalScope)scope;
        _matched=true;
        CharSequence _createScope = this.createScope(_internalScope);
        _switchResult = _createScope;
      }
    }
    return _switchResult;
  }
  
  private CharSequence createScope(final InterfaceScope scope, final GeneratorEntry entry) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _createInterface = this.createInterface(scope, entry);
    _builder.append(_createInterface, "");
    _builder.newLineIfNotEmpty();
    CharSequence _createOperationCallbackInterface = this.createOperationCallbackInterface(scope);
    _builder.append(_createOperationCallbackInterface, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _interfaceName = this.cNaming.getInterfaceName(scope);
    _builder.append(_interfaceName, "");
    _builder.append("* get");
    String _interfaceName_1 = this.cNaming.getInterfaceName(scope);
    _builder.append(_interfaceName_1, "");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence createInterface(final InterfaceScope scope, final GeneratorEntry entry) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//! Inner class for statechart ");
    String _interfaceName = this.cNaming.getInterfaceName(scope);
    _builder.append(_interfaceName, "");
    _builder.append(" interface scope.");
    _builder.newLineIfNotEmpty();
    _builder.append("class ");
    String _interfaceName_1 = this.cNaming.getInterfaceName(scope);
    _builder.append(_interfaceName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public:");
    _builder.newLine();
    {
      EList<Declaration> _declarations = scope.getDeclarations();
      for(final Declaration d : _declarations) {
        _builder.append("\t\t");
        CharSequence _functionPrototypes = this.functionPrototypes(d);
        _builder.append(_functionPrototypes, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private:");
    _builder.newLine();
    {
      EList<Declaration> _declarations_1 = scope.getDeclarations();
      for(final Declaration d_1 : _declarations_1) {
        _builder.append("\t\t");
        CharSequence _structDeclaration = this.structDeclaration(d_1);
        _builder.append(_structDeclaration, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence createScope(final InternalScope scope) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasOperations = this._navigation.hasOperations(scope);
      if (_hasOperations) {
        _builder.append("class ");
        String _internalOperationCallbackName = this.cNaming.getInternalOperationCallbackName();
        _builder.append(_internalOperationCallbackName, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          Iterable<OperationDefinition> _operations = this._navigation.operations(scope);
          for(final OperationDefinition operation : _operations) {
            _builder.append("\t");
            _builder.append("virtual ");
            String _asFunction = this.cNaming.asFunction(operation);
            _builder.append(_asFunction, "	");
            _builder.append("() = 0;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("virtual void set");
        String _internalOperationCallbackName_1 = this.cNaming.getInternalOperationCallbackName();
        _builder.append(_internalOperationCallbackName_1, "");
        _builder.append("(");
        String _internalOperationCallbackName_2 = this.cNaming.getInternalOperationCallbackName();
        _builder.append(_internalOperationCallbackName_2, "");
        _builder.append("* operationCallback) = 0;");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence createOperationCallbackInterface(final InterfaceScope scope) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasOperations = this._navigation.hasOperations(scope);
      if (_hasOperations) {
        _builder.newLine();
        _builder.append("public interface ");
        String _interfaceOperationCallbackName = this.cNaming.getInterfaceOperationCallbackName(scope);
        _builder.append(_interfaceOperationCallbackName, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          Iterable<OperationDefinition> _operations = this._navigation.operations(scope);
          for(final OperationDefinition operation : _operations) {
            _builder.append("virtual ");
            CharSequence _signature = this.signature(operation);
            _builder.append(_signature, "");
            _builder.append(" = 0;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence signature(final OperationDefinition it) {
    StringConcatenation _builder = new StringConcatenation();
    Type _type = it.getType();
    String _targetLanguageName = this._iCodegenTypeSystemAccess.getTargetLanguageName(_type);
    _builder.append(_targetLanguageName, "");
    _builder.append(" ");
    String _name = it.getName();
    String _asEscapedIdentifier = this.cNaming.asEscapedIdentifier(_name);
    _builder.append(_asEscapedIdentifier, "");
    _builder.append("(");
    {
      EList<Parameter> _parameters = it.getParameters();
      boolean _hasElements = false;
      for(final Parameter parameter : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        Type _type_1 = parameter.getType();
        String _targetLanguageName_1 = this._iCodegenTypeSystemAccess.getTargetLanguageName(_type_1);
        _builder.append(_targetLanguageName_1, "");
        _builder.append(" ");
        String _identifier = this.identifier(parameter);
        _builder.append(_identifier, "");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private String identifier(final Parameter parameter) {
    String _xifexpression = null;
    String _name = parameter.getName();
    boolean _isCKeyword = this.cNaming.isCKeyword(_name);
    if (_isCKeyword) {
      String _name_1 = parameter.getName();
      return (_name_1 + "Arg");
    } else {
      String _name_2 = parameter.getName();
      _xifexpression = _name_2;
    }
    return _xifexpression;
  }
  
  public CharSequence statemachineTypeDecl(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//! the maximum number of orthogonal states defines the dimension of the state configuration vector.");
    _builder.newLine();
    _builder.append("#define ");
    String _type = this.cNaming.type(it);
    String _upperCase = _type.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_MAX_ORTHOGONAL_STATES ");
    StateVector _stateVector = it.getStateVector();
    int _size = _stateVector.getSize();
    _builder.append(_size, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasHistory = this._navigation.hasHistory(it);
      if (_hasHistory) {
        _builder.append("//! dimension of the state configuration vector for history states");
        _builder.newLine();
        _builder.append("#define ");
        String _type_1 = this.cNaming.type(it);
        String _upperCase_1 = _type_1.toUpperCase();
        _builder.append(_upperCase_1, "");
        _builder.append("_MAX_HISTORY_STATES ");
        StateVector _historyVector = it.getHistoryVector();
        int _size_1 = _historyVector.getSize();
        _builder.append(_size_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isTimed = this._navigation.isTimed(it);
      if (_isTimed) {
        _builder.append("sc_boolean timeEvents[");
        LinkedList<TimeEvent> _timeEvents = this._navigation.getTimeEvents(it);
        int _size_2 = _timeEvents.size();
        _builder.append(_size_2, "");
        _builder.append("];");
      }
    }
    _builder.newLineIfNotEmpty();
    String _statesEnumType = this.cNaming.statesEnumType(it);
    _builder.append(_statesEnumType, "");
    _builder.append(" stateConfVector[");
    String _type_2 = this.cNaming.type(it);
    String _upperCase_2 = _type_2.toUpperCase();
    _builder.append(_upperCase_2, "");
    _builder.append("_MAX_ORTHOGONAL_STATES];");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasHistory_1 = this._navigation.hasHistory(it);
      if (_hasHistory_1) {
        String _statesEnumType_1 = this.cNaming.statesEnumType(it);
        _builder.append(_statesEnumType_1, "");
        _builder.append(" historyVector[");
        String _type_3 = this.cNaming.type(it);
        String _upperCase_3 = _type_3.toUpperCase();
        _builder.append(_upperCase_3, "");
        _builder.append("_MAX_HISTORY_STATES];");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("sc_ushort stateConfVectorPosition;");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _functionPrototypes(final EventDefinition it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Direction _direction = it.getDirection();
      boolean _equals = Objects.equal(_direction, Direction.IN);
      if (_equals) {
        _builder.append("/*! Raises the in event \'");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("\' that is defined in the ");
        Scope _scope = this._navigation.scope(it);
        CharSequence _scopeDescription = this.cNaming.scopeDescription(_scope);
        _builder.append(_scopeDescription, "");
        _builder.append(". */ ");
        _builder.newLineIfNotEmpty();
        _builder.append("void ");
        String _asRaiser = this.cNaming.asRaiser(it);
        _builder.append(_asRaiser, "");
        _builder.append("(");
        String _valueParams = this.cNaming.valueParams(it);
        _builder.append(_valueParams, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      } else {
        _builder.append("/*! Checks if the out event \'");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append("\' that is defined in the ");
        Scope _scope_1 = this._navigation.scope(it);
        CharSequence _scopeDescription_1 = this.cNaming.scopeDescription(_scope_1);
        _builder.append(_scopeDescription_1, "");
        _builder.append(" has been raised. */ ");
        _builder.newLineIfNotEmpty();
        _builder.append("sc_boolean ");
        String _asRaised = this.cNaming.asRaised(it);
        _builder.append(_asRaised, "");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          boolean _hasValue = this._navigation.hasValue(it);
          if (_hasValue) {
            _builder.append("/*! Gets the value of the out event \'");
            String _name_2 = it.getName();
            _builder.append(_name_2, "");
            _builder.append("\' that is defined in the ");
            Scope _scope_2 = this._navigation.scope(it);
            CharSequence _scopeDescription_2 = this.cNaming.scopeDescription(_scope_2);
            _builder.append(_scopeDescription_2, "");
            _builder.append(". */ ");
            _builder.newLineIfNotEmpty();
            Type _type = it.getType();
            String _targetLanguageName = this._iCodegenTypeSystemAccess.getTargetLanguageName(_type);
            _builder.append(_targetLanguageName, "");
            _builder.append(" ");
            String _asGetter = this.cNaming.asGetter(it);
            _builder.append(_asGetter, "");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _functionPrototypes(final VariableDefinition it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*! Gets the value of the variable \'");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\' that is defined in the ");
    Scope _scope = this._navigation.scope(it);
    CharSequence _scopeDescription = this.cNaming.scopeDescription(_scope);
    _builder.append(_scopeDescription, "");
    _builder.append(". */ ");
    _builder.newLineIfNotEmpty();
    Type _type = it.getType();
    String _targetLanguageName = this._iCodegenTypeSystemAccess.getTargetLanguageName(_type);
    _builder.append(_targetLanguageName, "");
    _builder.append(" ");
    String _asGetter = this.cNaming.asGetter(it);
    _builder.append(_asGetter, "");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    {
      boolean _isReadonly = it.isReadonly();
      boolean _not = (!_isReadonly);
      if (_not) {
        _builder.append("/*! Sets the value of the variable \'");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append("\' that is defined in the ");
        Scope _scope_1 = this._navigation.scope(it);
        CharSequence _scopeDescription_1 = this.cNaming.scopeDescription(_scope_1);
        _builder.append(_scopeDescription_1, "");
        _builder.append(". */ ");
        _builder.newLineIfNotEmpty();
        _builder.append("void ");
        String _asSetter = this.cNaming.asSetter(it);
        _builder.append(_asSetter, "");
        _builder.append("(");
        Type _type_1 = it.getType();
        String _targetLanguageName_1 = this._iCodegenTypeSystemAccess.getTargetLanguageName(_type_1);
        _builder.append(_targetLanguageName_1, "");
        _builder.append(" value);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence functionPrototypes(final Declaration it) {
    if (it instanceof EventDefinition) {
      return _functionPrototypes((EventDefinition)it);
    } else if (it instanceof VariableDefinition) {
      return _functionPrototypes((VariableDefinition)it);
    } else if (it != null) {
      return _functionPrototypes(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
