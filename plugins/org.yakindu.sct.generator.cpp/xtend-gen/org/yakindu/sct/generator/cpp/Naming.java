package org.yakindu.sct.generator.cpp;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class Naming extends org.yakindu.sct.generator.c.Naming {
  public String hpp(final String it) {
    String _plus = (it + ".hpp");
    return _plus;
  }
  
  public String cpp(final String it) {
    String _plus = (it + ".cpp");
    return _plus;
  }
  
  public String abstractModule(final ExecutionFlow it) {
    String _module = this.module(it);
    String _plus = ("I" + _module);
    return _plus;
  }
  
  public String iStatemachine() {
    return "IStatemachine";
  }
  
  public String iTimedStatemachine() {
    return "ITimedStatemachine";
  }
  
  public String iTimerService() {
    return "ITimerService";
  }
  
  public String timeEvent() {
    return "TimeEvent";
  }
  
  public String getInterfaceName(final InterfaceScope it) {
    String _name = it.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      String _name_1 = it.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      return ("SCI" + _firstUpper);
    } else {
      return "SCInterface";
    }
  }
  
  public String getInterfaceOperationCallbackName(final InterfaceScope it) {
    String _interfaceName = this.getInterfaceName(it);
    String _plus = (_interfaceName + "OperationCallback");
    return _plus;
  }
  
  public String getInternalOperationCallbackName() {
    return "InternalOperationCallback";
  }
  
  public String asFunction(final OperationDefinition it) {
    String _name = it.getName();
    String _asIdentifier = this.asIdentifier(_name);
    String _firstLower = StringExtensions.toFirstLower(_asIdentifier);
    return _firstLower;
  }
  
  public String asRaiser(final EventDefinition it) {
    String _name = it.getName();
    String _asIdentifier = this.asIdentifier(_name);
    String _firstLower = StringExtensions.toFirstLower(_asIdentifier);
    String _plus = ("raise_" + _firstLower);
    return _plus;
  }
  
  public String asRaised(final EventDefinition it) {
    String _name = it.getName();
    String _asIdentifier = this.asIdentifier(_name);
    String _firstLower = StringExtensions.toFirstLower(_asIdentifier);
    String _plus = ("isRaised_" + _firstLower);
    return _plus;
  }
  
  public String asGetter(final EventDefinition it) {
    String _name = it.getName();
    String _asIdentifier = this.asIdentifier(_name);
    String _firstLower = StringExtensions.toFirstLower(_asIdentifier);
    String _plus = ("get_" + _firstLower);
    String _plus_1 = (_plus + "_value");
    return _plus_1;
  }
  
  public String asGetter(final VariableDefinition it) {
    String _name = it.getName();
    String _asIdentifier = this.asIdentifier(_name);
    String _firstLower = StringExtensions.toFirstLower(_asIdentifier);
    String _plus = ("get_" + _firstLower);
    return _plus;
  }
  
  public String asSetter(final VariableDefinition it) {
    String _name = it.getName();
    String _asIdentifier = this.asIdentifier(_name);
    String _firstLower = StringExtensions.toFirstLower(_asIdentifier);
    String _plus = ("set_" + _firstLower);
    return _plus;
  }
}
