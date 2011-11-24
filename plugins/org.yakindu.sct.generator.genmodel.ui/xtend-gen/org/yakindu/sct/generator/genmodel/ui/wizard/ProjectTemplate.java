package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend.shared.ui.wizards.EclipseHelper;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.yakindu.sct.generator.genmodel.ui.wizard.ProjectData;
import org.yakindu.sct.generator.genmodel.ui.wizard.XpandGeneratorProjectWizard;

@SuppressWarnings("all")
public class ProjectTemplate {
  
  public IFile doGenerate(final ProjectData data, final IProgressMonitor monitor) throws CoreException {
    IFile _xblockexpression = null;
    {
      String _targetPackage = this.targetPackage(data);
      String _asFolder = this.asFolder(_targetPackage);
      String _operator_plus = StringExtensions.operator_plus("src/", _asFolder);
      String folderPath = _operator_plus;
      IProject _project = data.getProject();
      this.createFolder(folderPath, _project, monitor);
      IProject _project_1 = data.getProject();
      Path _path = new Path(folderPath);
      IFolder _folder = _project_1.getFolder(_path);
      IFolder generatorFolder = _folder;
      IProject _project_2 = data.getProject();
      String _encoding = ResourcesPlugin.getEncoding();
      StringConcatenation _projectSettings = this.projectSettings(data, _encoding);
      String _string = _projectSettings.toString();
      EclipseHelper.createFile(".settings/org.eclipse.core.resources.prefs", _project_2, _string, monitor);
      IProject _project_3 = data.getProject();
      StringConcatenation _xpandSettings = this.xpandSettings(data);
      String _string_1 = _xpandSettings.toString();
      EclipseHelper.createFile(".settings/org.eclipse.xtend.shared.ui.prefs", _project_3, _string_1, monitor);
      String _templateName = this.templateName(data);
      String _operator_plus_1 = StringExtensions.operator_plus(_templateName, ".xpt");
      String _resource = this.resource("DefaultTemplate.xpt", "iso-8859-1");
      EclipseHelper.createFile(_operator_plus_1, generatorFolder, _resource, monitor);
      IFile _xifexpression = null;
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        IFile _xblockexpression_1 = null;
        {
          IProject _project_4 = data.getProject();
          StringConcatenation _plugin = this.plugin(data);
          String _string_2 = _plugin.toString();
          EclipseHelper.createFile("plugin.xml", _project_4, _string_2, monitor);
          String _generatorClass = data.getGeneratorClass();
          String _javaFilename = this.javaFilename(_generatorClass);
          String _operator_plus_2 = StringExtensions.operator_plus("src/", _javaFilename);
          IProject _project_5 = data.getProject();
          StringConcatenation _generator = this.generator(data);
          String _string_3 = _generator.toString();
          EclipseHelper.createFile(_operator_plus_2, _project_5, _string_3, monitor);
          boolean _isTypeLibrary = data.isTypeLibrary();
          if (_isTypeLibrary) {
            IProject _project_6 = data.getProject();
            this.createFolder("library", _project_6, monitor);
          }
          IProject _project_7 = data.getProject();
          StringConcatenation _buildProperties = this.buildProperties(data);
          String _string_4 = _buildProperties.toString();
          IFile _createFile = EclipseHelper.createFile("build.properties", _project_7, _string_4, monitor);
          _xblockexpression_1 = (_createFile);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String templateName(final ProjectData data) {
    String _xifexpression = null;
    boolean _isPluginExport = data.isPluginExport();
    if (_isPluginExport) {
      String _generatorClass = data.getGeneratorClass();
      String _simpleName = this.simpleName(_generatorClass);
      _xifexpression = _simpleName;
    } else {
      _xifexpression = "Main";
    }
    return _xifexpression;
  }
  
  public String resource(final String name, final String encoding) {
    String _resourceContents = XpandGeneratorProjectWizard.getResourceContents(name, encoding);
    return _resourceContents;
  }
  
  public String targetPackage(final ProjectData data) {
    String _xifexpression = null;
    boolean _isPluginExport = data.isPluginExport();
    if (_isPluginExport) {
      String _generatorClass = data.getGeneratorClass();
      String _packageName = this.packageName(_generatorClass);
      _xifexpression = _packageName;
    } else {
      _xifexpression = "org.yakindu.sct.generator.xpand";
    }
    return _xifexpression;
  }
  
  public String asFolder(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    return _replaceAll;
  }
  
  public String javaPathToXpand(final String s) {
    String _replaceAll = s.replaceAll("\\.", "::");
    return _replaceAll;
  }
  
  public String simpleName(final String s) {
    int _lastIndexOf = s.lastIndexOf(".");
    int _operator_plus = IntegerExtensions.operator_plus(((Integer)_lastIndexOf), ((Integer)1));
    String _substring = s.substring(_operator_plus);
    return _substring;
  }
  
  public String packageName(final String s) {
    int _lastIndexOf = s.lastIndexOf(".");
    String _substring = s.substring(0, _lastIndexOf);
    return _substring;
  }
  
  public String providerClass(final ProjectData data) {
    String _generatorClass = data.getGeneratorClass();
    String _operator_plus = StringExtensions.operator_plus(_generatorClass, "DefaultValueProvider");
    return _operator_plus;
  }
  
  public String javaFilename(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    String _operator_plus = StringExtensions.operator_plus(_replaceAll, ".java");
    return _operator_plus;
  }
  
  public Object createFolder(final String folderPath, final IContainer container, final IProgressMonitor monitor) throws CoreException {
    Path _path = new Path(folderPath);
    IFolder _folder = container.getFolder(_path);
    Object _createFolderHierarchy = this.createFolderHierarchy(_folder, monitor);
    return _createFolderHierarchy;
  }
  
  public Object createFolderHierarchy(final IFolder folder, final IProgressMonitor monitor) throws CoreException {
    Object _xifexpression = null;
    boolean _exists = folder.exists();
    boolean _operator_not = BooleanExtensions.operator_not(_exists);
    if (_operator_not) {
      {
        boolean _operator_and = false;
        IContainer _parent = folder.getParent();
        boolean _exists_1 = _parent.exists();
        boolean _operator_not_1 = BooleanExtensions.operator_not(_exists_1);
        if (!_operator_not_1) {
          _operator_and = false;
        } else {
          IContainer _parent_1 = folder.getParent();
          int _type = _parent_1.getType();
          boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_type), ((Integer)IResource.FOLDER));
          _operator_and = BooleanExtensions.operator_and(_operator_not_1, _operator_equals);
        }
        if (_operator_and) {
          IContainer _parent_2 = folder.getParent();
          this.createFolderHierarchy(((IFolder) _parent_2), monitor);
        }
        folder.create(true, true, monitor);
      }
    }
    return _xifexpression;
  }
  
  public String escapeForXml(final String s) {
    String _escapeXml = StringEscapeUtils.escapeXml(s);
    return _escapeXml;
  }
  
  public StringConcatenation plugin(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.4\"?>");
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("point=\"org.yakindu.sct.generator.core.generator\">");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<SCTGenerator class=\"");
    String _generatorClass = data.getGeneratorClass();
    _builder.append(_generatorClass, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("description=\"");
    String _generatorDescription = data.getGeneratorDescription();
    String _escapeForXml = this.escapeForXml(_generatorDescription);
    _builder.append(_escapeForXml, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("id=\"");
    String _generatorId = data.getGeneratorId();
    _builder.append(_generatorId, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("name=\"");
    String _generatorName = data.getGeneratorName();
    String _escapeForXml_1 = this.escapeForXml(_generatorName);
    _builder.append(_escapeForXml_1, "            ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("</SCTGenerator>");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("</extension>");
    _builder.newLine();
    {
      boolean _isTypeLibrary = data.isTypeLibrary();
      if (_isTypeLibrary) {
        _builder.append("<extension");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("point=\"org.yakindu.sct.generator.core.featuretypes\">");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("<FeatureLibrary generatorId=\"");
        String _generatorId_1 = data.getGeneratorId();
        _builder.append(_generatorId_1, "   ");
        _builder.append("\" ");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("defaultProvider=\"");
        String _providerClass = this.providerClass(data);
        _builder.append(_providerClass, "   ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("         ");
        _builder.append("uri=\"platform:/plugin/");
        IProject _project = data.getProject();
        String _name = _project.getName();
        _builder.append(_name, "         ");
        _builder.append("/library/FeatureTypeLibrary.xmi\">");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("</FeatureLibrary>");
        _builder.newLine();
        _builder.append("</extension>");
        _builder.newLine();
      }
    }
    _builder.append("</plugin>");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _generatorClass = data.getGeneratorClass();
    String _packageName = this.packageName(_generatorClass);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generator using Xpand template \"");
    String _generatorClass_1 = data.getGeneratorClass();
    String _javaPathToXpand = this.javaPathToXpand(_generatorClass_1);
    _builder.append(_javaPathToXpand, " ");
    _builder.append("::main\"");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _generatorClass_2 = data.getGeneratorClass();
    String _simpleName = this.simpleName(_generatorClass_2);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractXpandBasedCodeGenerator {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getTemplatePath() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    String _generatorClass_3 = data.getGeneratorClass();
    String _javaPathToXpand_1 = this.javaPathToXpand(_generatorClass_3);
    _builder.append(_javaPathToXpand_1, "		");
    _builder.append("::main\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation defaultProvider(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _providerClass = this.providerClass(data);
    String _packageName = this.packageName(_providerClass);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Default value proivder for ");
    String _generatorName = data.getGeneratorName();
    _builder.append(_generatorName, " ");
    _builder.append(" feature library");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _providerClass_1 = this.providerClass(data);
    String _simpleName = this.simpleName(_providerClass_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractDefaultFeatureValueProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final String LIBRARY_NAME = \"");
    String _generatorName_1 = data.getGeneratorName();
    _builder.append(_generatorName_1, "	");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void setDefaultValue(FeatureParameterValue parameterValue,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Statechart statechart) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String parameterName = parameterValue.getParameter().getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//TODO: set the default values");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean isProviderFor(FeatureTypeLibrary library) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return library.getName().equals(LIBRARY_NAME);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IStatus validateParameterValue(FeatureParameterValue value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String name = value.getParameter().getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//TODO implement validation");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Status.OK_STATUS;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation projectSettings(final ProjectData data, final String encoding) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("encoding/<project>=");
    _builder.append(encoding, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation xpandSettings(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("project.specific.metamodel=true");
    _builder.newLine();
    _builder.append("metamodelContributor=org.eclipse.xtend.typesystem.emf.ui.EmfMetamodelContributor");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation buildProperties(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("source.. = src/,\\");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("src-gen");
    _builder.newLine();
    _builder.append("bin.includes = META-INF/,\\");
    _builder.newLine();
    _builder.append("               ");
    _builder.append(".,\\");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("plugin.xml");
    _builder.newLine();
    return _builder;
  }
}