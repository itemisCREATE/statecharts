package org.yakindu.sct.generator.cpp;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.generator.c.GenmodelEntries;
import org.yakindu.sct.generator.cpp.Naming;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class IStatemachine {
  @Inject
  private Naming _naming;
  
  @Inject
  private GenmodelEntries _genmodelEntries;
  
  public void generateIStatemachine(final ExecutionFlow flow, final GeneratorEntry entry, final IFileSystemAccess fsa) {
    String _iStatemachine = this._naming.iStatemachine();
    String _hpp = this._naming.hpp(_iStatemachine);
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
    String _iStatemachine = this._naming.iStatemachine();
    String _define = this._naming.define(_iStatemachine);
    _builder.append(_define, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    String _iStatemachine_1 = this._naming.iStatemachine();
    String _define_1 = this._naming.define(_iStatemachine_1);
    _builder.append(_define_1, "");
    _builder.append("_H_");
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
    _builder.append("class IStatemachine {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Initializes the statemachine. Use to init internal variables etc.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void init() = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Enters the statemachine. Sets the statemachine in a defined state.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void enter() = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Exits the statemachine. Leaves the statemachine with a defined state.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void exit() = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("* Start a run-to-completion cycle.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("virtual void runCycle() = 0;");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* ");
    String _iStatemachine_2 = this._naming.iStatemachine();
    String _define_2 = this._naming.define(_iStatemachine_2);
    _builder.append(_define_2, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
