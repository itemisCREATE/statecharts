package org.yakindu.sct.generator.cpp;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.generator.c.GenmodelEntries;
import org.yakindu.sct.generator.cpp.Naming;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class ITimedStatemachine {
  @Inject
  private Naming _naming;
  
  @Inject
  private GenmodelEntries _genmodelEntries;
  
  public void generateITimedStatemachine(final ExecutionFlow flow, final GeneratorEntry entry, final IFileSystemAccess fsa) {
    String _iTimedStatemachine = this._naming.iTimedStatemachine();
    String _hpp = this._naming.hpp(_iTimedStatemachine);
    CharSequence _content = this.content(flow, entry);
    fsa.generateFile(_hpp, _content);
  }
  
  private CharSequence content(final ExecutionFlow it, final GeneratorEntry entry) {
    StringConcatenation _builder = new StringConcatenation();
    String _licenseText = this._genmodelEntries.getLicenseText(entry);
    _builder.append(_licenseText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#ifndef ");
    String _iTimedStatemachine = this._naming.iTimedStatemachine();
    String _define = this._naming.define(_iTimedStatemachine);
    _builder.append(_define, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    String _iTimedStatemachine_1 = this._naming.iTimedStatemachine();
    String _define_1 = this._naming.define(_iTimedStatemachine_1);
    _builder.append(_define_1, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"");
    String _typesModule = this._naming.typesModule(it);
    String _hpp = this._naming.hpp(_typesModule);
    _builder.append(_hpp, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("#include \"");
    String _iTimerService = this._naming.iTimerService();
    String _hpp_1 = this._naming.hpp(_iTimerService);
    _builder.append(_hpp_1, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append("* Interface for state machines which use timed event triggers.");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class ITimedStatemachine {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Set the ITimerService for the state machine. It must be set");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* externally on a timed state machine before a run cycle can be correct");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* executed.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void setTimerService(ITimerService* timerService) = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Returns the currently used timer service.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual ITimerService* getTimerService() = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Callback method if a time event occurred.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void raiseTimeEvent(sc_eventid event) = 0;");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* ");
    String _iTimedStatemachine_2 = this._naming.iTimedStatemachine();
    String _define_2 = this._naming.define(_iTimedStatemachine_2);
    _builder.append(_define_2, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
