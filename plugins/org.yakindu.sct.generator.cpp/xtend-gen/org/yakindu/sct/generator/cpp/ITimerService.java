package org.yakindu.sct.generator.cpp;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.generator.c.GenmodelEntries;
import org.yakindu.sct.generator.cpp.Naming;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class ITimerService {
  @Inject
  private Naming _naming;
  
  @Inject
  private GenmodelEntries _genmodelEntries;
  
  public void generateITimerService(final ExecutionFlow flow, final GeneratorEntry entry, final IFileSystemAccess fsa) {
    String _iTimerService = this._naming.iTimerService();
    String _hpp = this._naming.hpp(_iTimerService);
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
    String _iTimerService = this._naming.iTimerService();
    String _define = this._naming.define(_iTimerService);
    _builder.append(_define, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    String _iTimerService_1 = this._naming.iTimerService();
    String _define_1 = this._naming.define(_iTimerService_1);
    _builder.append(_define_1, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"");
    String _iTimedStatemachine = this._naming.iTimedStatemachine();
    String _hpp = this._naming.hpp(_iTimedStatemachine);
    _builder.append(_hpp, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Basic interface for statemachines.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class ITimerService {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* Starts the timing for a time event.");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*/ ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void setTimer(ITimedStatemachine* statemachine, sc_eventid event, sc_integer time, sc_boolean isPeriodic) = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* Unsets the given time event.");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void resetTimer(ITimedStatemachine* statemachine, sc_eventid event) = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* Cancel timer service. Use this to end possible timing threads and free");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* memory resources.");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void cancel() = 0;");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* ");
    String _iTimerService_2 = this._naming.iTimerService();
    String _define_2 = this._naming.define(_iTimerService_2);
    _builder.append(_define_2, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
