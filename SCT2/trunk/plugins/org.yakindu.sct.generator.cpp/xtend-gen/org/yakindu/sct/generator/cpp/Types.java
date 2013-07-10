package org.yakindu.sct.generator.cpp;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.yakindu.sct.generator.c.GenmodelEntries;
import org.yakindu.sct.generator.cpp.Naming;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

@SuppressWarnings("all")
public class Types {
  @Inject
  private Naming _naming;
  
  @Inject
  private GenmodelEntries _genmodelEntries;
  
  public void generateTypesHpp(final ExecutionFlow flow, final Statechart sc, final IFileSystemAccess fsa, final GeneratorEntry entry) {
    String _typesModule = this._naming.typesModule(flow);
    String _hpp = this._naming.hpp(_typesModule);
    CharSequence _typesHContent = this.typesHContent(flow, entry);
    fsa.generateFile(_hpp, _typesHContent);
  }
  
  public CharSequence typesHContent(final ExecutionFlow it, final GeneratorEntry entry) {
    StringConcatenation _builder = new StringConcatenation();
    String _licenseText = this._genmodelEntries.getLicenseText(entry);
    _builder.append(_licenseText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#ifndef ");
    String _typesModule = this._naming.typesModule(it);
    String _define = this._naming.define(_typesModule);
    _builder.append(_define, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    String _typesModule_1 = this._naming.typesModule(it);
    String _define_1 = this._naming.define(_typesModule_1);
    _builder.append(_define_1, "");
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <string>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("typedef unsigned char\tsc_ushort;");
    _builder.newLine();
    _builder.append("typedef int\t\t\t\tsc_integer;  ");
    _builder.newLine();
    _builder.append("typedef double\t\t\tsc_real;");
    _builder.newLine();
    _builder.append("typedef string\t\t\tsc_string;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("typedef void*\t\t\tsc_eventid;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* ");
    String _typesModule_2 = this._naming.typesModule(it);
    String _define_2 = this._naming.define(_typesModule_2);
    _builder.append(_define_2, "");
    _builder.append("_H_ */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
