package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;
import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.yakindu.sct.generator.genmodel.ui.wizard.GeneratorType;
import org.yakindu.sct.generator.genmodel.ui.wizard.ProjectData;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.SGenFactory;

@SuppressWarnings("all")
public class GeneratorProjectTemplate {
  
  private IProgressMonitor monitor;
  
  public IProgressMonitor setMonitor(final IProgressMonitor monitor) {
    IProgressMonitor _monitor = this.monitor = monitor;
    return _monitor;
  }
  
  public void generate(final ProjectData data) throws IOException, UnsupportedEncodingException, CoreException {
    {
      this.monitor.beginTask("Create YAKINDU Xpand Generator Project", 16);
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      String _projectName = data.getProjectName();
      IProject _project = _root.getProject(_projectName);
      final IProject project = _project;
      SubProgressMonitor _sub = this.sub(this.monitor);
      project.create(_sub);
      SubProgressMonitor _sub_1 = this.sub(this.monitor);
      project.open(_sub_1);
      this.monitor.worked(1);
      this.createFolder(project, "src");
      GeneratorType _generatorType = data.getGeneratorType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_generatorType, GeneratorType.Xtend);
      if (_operator_equals) {
        this.createFolder(project, "xtend-gen");
      }
      IFile _file = project.getFile(".settings/org.eclipse.core.resources.prefs");
      String _encoding = ResourcesPlugin.getEncoding();
      StringConcatenation _projectSettings = this.projectSettings(data, _encoding);
      this.write(_file, _projectSettings);
      IFile _file_1 = project.getFile(".settings/org.eclipse.jdt.core.prefs");
      StringConcatenation _jdtSettings = this.jdtSettings(data);
      this.write(_file_1, _jdtSettings);
      GeneratorType _generatorType_1 = data.getGeneratorType();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_generatorType_1, GeneratorType.Java);
      if (_operator_notEquals) {
        IFile _file_2 = project.getFile(".settings/org.eclipse.xtend.shared.ui.prefs");
        StringConcatenation _xpandSettings = this.xpandSettings(data);
        this.write(_file_2, _xpandSettings);
      }
      IFile _file_3 = project.getFile("build.properties");
      StringConcatenation _buildProperties = this.buildProperties(data);
      this.write(_file_3, _buildProperties);
      IFile _file_4 = project.getFile("META-INF/MANIFEST.MF");
      StringConcatenation _manifest = this.manifest(data);
      this.write(_file_4, _manifest);
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        {
          IFile _file_5 = project.getFile("plugin.xml");
          StringConcatenation _plugin = this.plugin(data);
          this.write(_file_5, _plugin);
          GeneratorType _generatorType_2 = data.getGeneratorType();
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(_generatorType_2, GeneratorType.Xpand);
          if (_operator_equals_1) {
            String _generatorClass = data.getGeneratorClass();
            String _javaFilename = this.javaFilename(_generatorClass);
            String _operator_plus = StringExtensions.operator_plus("src/", _javaFilename);
            IFile _file_6 = project.getFile(_operator_plus);
            StringConcatenation _xpandGenerator = this.xpandGenerator(data);
            this.write(_file_6, _xpandGenerator);
          }
          boolean _isTypeLibrary = data.isTypeLibrary();
          if (_isTypeLibrary) {
            {
              this.createFolder(project, "library");
              IFile _file_7 = project.getFile("library/FeatureTypeLibrary.xmi");
              FeatureTypeLibrary _featureLibrary = this.featureLibrary(data);
              this.write(_file_7, _featureLibrary);
              String _providerClass = this.providerClass(data);
              String _javaFilename_1 = this.javaFilename(_providerClass);
              String _operator_plus_1 = StringExtensions.operator_plus("src/", _javaFilename_1);
              IFile _file_8 = project.getFile(_operator_plus_1);
              StringConcatenation _defaultProvider = this.defaultProvider(data);
              this.write(_file_8, _defaultProvider);
              String _libraryConstantsClass = this.libraryConstantsClass(data);
              String _javaFilename_2 = this.javaFilename(_libraryConstantsClass);
              String _operator_plus_2 = StringExtensions.operator_plus("src/", _javaFilename_2);
              IFile _file_9 = project.getFile(_operator_plus_2);
              StringConcatenation _libraryConstants = this.libraryConstants(data);
              this.write(_file_9, _libraryConstants);
            }
          }
        }
      }
      IFile _file_10 = project.getFile(".classpath");
      StringConcatenation _classpath = this.classpath(data);
      this.write(_file_10, _classpath);
      IFile _file_11 = project.getFile(".project");
      StringConcatenation _projectFile = this.projectFile(data);
      this.write(_file_11, _projectFile);
      GeneratorType _generatorType_3 = data.getGeneratorType();
      final GeneratorType __valOfSwitchOver = _generatorType_3;
      boolean matched = false;
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,GeneratorType.Xpand)) {
          matched=true;
          String _targetPackage = this.targetPackage(data);
          String _asFolder = this.asFolder(_targetPackage);
          String _operator_plus_3 = StringExtensions.operator_plus("src/", _asFolder);
          String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "/");
          String _templateName = this.templateName(data);
          String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, _templateName);
          String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, ".xpt");
          IFile _file_12 = project.getFile(_operator_plus_6);
          String _fromMyFolder = this.fromMyFolder("XpandDefaultTemplate.xpt");
          String _resource = this.resource(_fromMyFolder, "iso-8859-1");
          this.write(_file_12, _resource);
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,GeneratorType.Xtend)) {
          matched=true;
          String _generatorClass_1 = data.getGeneratorClass();
          String _xtendFilename = this.xtendFilename(_generatorClass_1);
          String _operator_plus_7 = StringExtensions.operator_plus("src/", _xtendFilename);
          IFile _file_13 = project.getFile(_operator_plus_7);
          StringConcatenation _xtendGenerator = this.xtendGenerator(data);
          this.write(_file_13, _xtendGenerator);
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,GeneratorType.Java)) {
          matched=true;
          String _generatorClass_2 = data.getGeneratorClass();
          String _javaFilename_3 = this.javaFilename(_generatorClass_2);
          String _operator_plus_8 = StringExtensions.operator_plus("src/", _javaFilename_3);
          IFile _file_14 = project.getFile(_operator_plus_8);
          StringConcatenation _javaGenerator = this.javaGenerator(data);
          this.write(_file_14, _javaGenerator);
        }
      }
    }
  }
  
  public String fromMyFolder(final String s) {
    String _operator_plus = StringExtensions.operator_plus("org/yakindu/sct/generator/genmodel/ui/wizard/", s);
    return _operator_plus;
  }
  
  public SubProgressMonitor sub(final IProgressMonitor mon) {
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(mon, 1);
    return _subProgressMonitor;
  }
  
  public String templateName(final ProjectData data) {
    String _xifexpression = null;
    boolean _operator_or = false;
    boolean _isPluginExport = data.isPluginExport();
    if (_isPluginExport) {
      _operator_or = true;
    } else {
      GeneratorType _generatorType = data.getGeneratorType();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_generatorType, GeneratorType.Xpand);
      _operator_or = BooleanExtensions.operator_or(_isPluginExport, _operator_notEquals);
    }
    if (_operator_or) {
      String _generatorClass = data.getGeneratorClass();
      String _simpleName = this.simpleName(_generatorClass);
      _xifexpression = _simpleName;
    } else {
      _xifexpression = "Main";
    }
    return _xifexpression;
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
  
  public String libraryConstantsClass(final ProjectData data) {
    String _providerClass = this.providerClass(data);
    String _packageName = this.packageName(_providerClass);
    String _operator_plus = StringExtensions.operator_plus(_packageName, ".IFeatureConstants");
    return _operator_plus;
  }
  
  public String javaFilename(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    String _operator_plus = StringExtensions.operator_plus(_replaceAll, ".java");
    return _operator_plus;
  }
  
  public String xtendFilename(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    String _operator_plus = StringExtensions.operator_plus(_replaceAll, ".xtend");
    return _operator_plus;
  }
  
  public FeatureTypeLibrary featureLibrary(final ProjectData data) {
    {
      final SGenFactory factory = SGenFactory.eINSTANCE;
      FeatureTypeLibrary _createFeatureTypeLibrary = factory.createFeatureTypeLibrary();
      final FeatureTypeLibrary lib = _createFeatureTypeLibrary;
      String _generatorName = data.getGeneratorName();
      lib.setName(_generatorName);
      FeatureType _createFeatureType = factory.createFeatureType();
      final FeatureType type = _createFeatureType;
      type.setName("MyFeature");
      FeatureParameter _createFeatureParameter = factory.createFeatureParameter();
      final FeatureParameter parameter = _createFeatureParameter;
      parameter.setName("MyParameter");
      parameter.setParameterType(ParameterTypes.STRING);
      EList<FeatureParameter> _parameters = type.getParameters();
      _parameters.add(parameter);
      EList<FeatureType> _types = lib.getTypes();
      _types.add(type);
      return lib;
    }
  }
  
  public void write(final IFile file, final EObject object) throws IOException {
    {
      IPath _fullPath = file.getFullPath();
      String _string = _fullPath.toString();
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_string, true);
      final URI uri = _createPlatformResourceURI;
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      final ResourceSetImpl resourceSet = _resourceSetImpl;
      Resource _createResource = resourceSet.createResource(uri);
      final Resource resource = _createResource;
      EList<EObject> _contents = resource.getContents();
      _contents.add(object);
      Map<Object,Object> _emptyMap = Collections.<Object, Object>emptyMap();
      resource.save(_emptyMap);
    }
  }
  
  public void write(final IFile file, final StringConcatenation content) throws IOException, UnsupportedEncodingException, CoreException {
    String _string = content.toString();
    this.write(file, _string);
  }
  
  public void write(final IFile file, final String content) throws IOException, UnsupportedEncodingException, CoreException {
    {
      IContainer _parent = file.getParent();
      boolean _exists = _parent.exists();
      boolean _operator_not = BooleanExtensions.operator_not(_exists);
      if (_operator_not) {
        IContainer _parent_1 = file.getParent();
        SubProgressMonitor _sub = this.sub(this.monitor);
        this.createFolderHierarchy(((IFolder) _parent_1), _sub);
      }
      String _charset = file.getCharset();
      byte[] _bytes = content.getBytes(_charset);
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      final ByteArrayInputStream stream = _byteArrayInputStream;
      try {
        boolean _exists_1 = file.exists();
        if (_exists_1) {
          SubProgressMonitor _sub_1 = this.sub(this.monitor);
          file.setContents(stream, true, true, _sub_1);
        } else {
          {
            SubProgressMonitor _sub_2 = this.sub(this.monitor);
            final SubProgressMonitor submonitor = _sub_2;
            file.create(stream, true, submonitor);
            String _encoding = ResourcesPlugin.getEncoding();
            file.setCharset(_encoding, submonitor);
          }
        }
      } catch (final Exception e) { 
        e.printStackTrace();
      } finally {
        stream.close();
      }
      this.monitor.worked(1);
    }
  }
  
  public void createFolder(final IContainer container, final String folderPath) throws CoreException {
    {
      Path _path = new Path(folderPath);
      IFolder _folder = container.getFolder(_path);
      SubProgressMonitor _sub = this.sub(this.monitor);
      this.createFolderHierarchy(_folder, _sub);
      this.monitor.worked(1);
    }
  }
  
  public Object createFolderHierarchy(final IFolder folder, final IProgressMonitor submonitor) throws CoreException {
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
          this.createFolderHierarchy(((IFolder) _parent_2), submonitor);
        }
        folder.create(true, true, this.monitor);
      }
    }
    return _xifexpression;
  }
  
  public String escapeForXml(final String s) {
    String _escapeXml = StringEscapeUtils.escapeXml(s);
    return _escapeXml;
  }
  
  public String resource(final String path, final String encoding) throws IOException, UnsupportedEncodingException {
    String _xblockexpression = null;
    {
      Thread _currentThread = Thread.currentThread();
      ClassLoader _contextClassLoader = _currentThread.getContextClassLoader();
      InputStream _resourceAsStream = _contextClassLoader.getResourceAsStream(path);
      final InputStream inStream = _resourceAsStream;
      ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
      final ByteArrayOutputStream outStream = _byteArrayOutputStream;
      String _xtrycatchfinallyexpression = null;
      try {
        String _xblockexpression_1 = null;
        {
          BufferedInputStream _bufferedInputStream = new BufferedInputStream(inStream);
          final BufferedInputStream buffer = _bufferedInputStream;
          int result = 0;
          int _read = buffer.read();
          int _result = result = _read;
          int _operator_minus = IntegerExtensions.operator_minus(1);
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_result), ((Integer)_operator_minus));
          Boolean _xwhileexpression = _operator_notEquals;
          while (_xwhileexpression) {
            outStream.write(((byte) result));
            int _read_1 = buffer.read();
            int _result_1 = result = _read_1;
            int _operator_minus_1 = IntegerExtensions.operator_minus(1);
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(((Integer)_result_1), ((Integer)_operator_minus_1));
            _xwhileexpression = _operator_notEquals_1;
          }
          String _string = outStream.toString(encoding);
          _xblockexpression_1 = (_string);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } finally {
        inStream.close();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation projectFile(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<projectDescription>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>");
    String _projectName = data.getProjectName();
    _builder.append(_projectName, "	");
    _builder.append("</name>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<comment></comment>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<projects>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</projects>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<buildSpec>");
    _builder.newLine();
    {
      GeneratorType _generatorType = data.getGeneratorType();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_generatorType, GeneratorType.Java);
      if (_operator_notEquals) {
        _builder.append("\t\t");
        _builder.append("<buildCommand>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<name>org.eclipse.xtend.shared.ui.xtendBuilder</name>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<arguments>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("</arguments>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</buildCommand>");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.pde.ManifestBuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.pde.SchemaBuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.jdt.core.javabuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    {
      GeneratorType _generatorType_1 = data.getGeneratorType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_generatorType_1, GeneratorType.Xtend);
      if (_operator_equals) {
        _builder.append("\t\t");
        _builder.append("<buildCommand>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<name>org.eclipse.xtext.ui.shared.xtextBuilder</name>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("<arguments>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("</arguments>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</buildCommand>\t\t\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("</buildSpec>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<natures>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<nature>org.eclipse.jdt.core.javanature</nature>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<nature>org.eclipse.pde.PluginNature</nature>");
    _builder.newLine();
    {
      GeneratorType _generatorType_2 = data.getGeneratorType();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_generatorType_2, GeneratorType.Java);
      if (_operator_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("<nature>org.eclipse.xtend.shared.ui.xtendXPandNature</nature>");
        _builder.newLine();
      }
    }
    {
      GeneratorType _generatorType_3 = data.getGeneratorType();
      boolean _operator_equals_1 = ObjectExtensions.operator_equals(_generatorType_3, GeneratorType.Xtend);
      if (_operator_equals_1) {
        _builder.append("\t\t");
        _builder.append("<nature>org.eclipse.xtext.ui.shared.xtextNature</nature>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("</natures>");
    _builder.newLine();
    _builder.append("</projectDescription>");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation classpath(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<classpath>");
    _builder.newLine();
    {
      GeneratorType _generatorType = data.getGeneratorType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_generatorType, GeneratorType.Xtend);
      if (_operator_equals) {
        _builder.append("\t");
        _builder.append("<classpathentry kind=\"src\" path=\"xtend-gen\"/>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"src\" path=\"src\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"output\" path=\"bin\"/>");
    _builder.newLine();
    _builder.append("</classpath>");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation manifest(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    String _projectName = data.getProjectName();
    _builder.append(_projectName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-SymbolicName: ");
    String _projectName_1 = data.getProjectName();
    _builder.append(_projectName_1, "");
    _builder.append("; singleton:=true");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-Version: 1.0.0");
    _builder.newLine();
    _builder.append("Require-Bundle: org.eclipse.jdt.core;bundle-version=\"3.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.apache.commons.logging,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.apache.log4j;resolution:=optional,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("com.ibm.icu;bundle-version=\"4.0.1\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.antlr.runtime;bundle-version=\"3.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.core.runtime;bundle-version=\"3.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.emf.mwe.utils;bundle-version=\"0.7.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.emf.ecore.xmi;bundle-version=\"2.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.jface.text;bundle-version=\"3.5.0\",");
    _builder.newLine();
    {
      boolean _operator_or = false;
      GeneratorType _generatorType = data.getGeneratorType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_generatorType, GeneratorType.Xpand);
      if (_operator_equals) {
        _operator_or = true;
      } else {
        GeneratorType _generatorType_1 = data.getGeneratorType();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_generatorType_1, GeneratorType.Xtend);
        _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or) {
        _builder.append(" ", "");
        _builder.append("org.eclipse.xpand;bundle-version=\"0.7.0\",");
        _builder.newLineIfNotEmpty();
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtend;bundle-version=\"0.7.0\",");
        _builder.newLineIfNotEmpty();
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtend.typesystem.emf;bundle-version=\"0.7.0\",");
        _builder.newLineIfNotEmpty();
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtend.profiler;resolution:=optional,");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GeneratorType _generatorType_2 = data.getGeneratorType();
      boolean _operator_equals_2 = ObjectExtensions.operator_equals(_generatorType_2, GeneratorType.Xtend);
      if (_operator_equals_2) {
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtext.xbase.lib;bundle-version=\"2.0.1\",");
        _builder.newLineIfNotEmpty();
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtext.xtend2.lib;bundle-version=\"2.0.1\",");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _operator_or_1 = false;
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        _operator_or_1 = true;
      } else {
        GeneratorType _generatorType_3 = data.getGeneratorType();
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_generatorType_3, GeneratorType.Xpand);
        _operator_or_1 = BooleanExtensions.operator_or(_isPluginExport, _operator_notEquals);
      }
      if (_operator_or_1) {
        _builder.append(" ", "");
        _builder.append("org.yakindu.sct.generator.core;bundle-version=\"1.0.0\",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.sgen;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.sexec;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.stext;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.sgraph;bundle-version=\"1.0.0\"");
    _builder.newLine();
    _builder.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5");
    _builder.newLine();
    return _builder;
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
        String _projectName = data.getProjectName();
        _builder.append(_projectName, "         ");
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
  
  public StringConcatenation xpandGenerator(final ProjectData data) {
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
  
  public StringConcatenation javaGenerator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _generatorClass = data.getGeneratorClass();
    String _packageName = this.packageName(_generatorClass);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.File;");
    _builder.newLine();
    _builder.append("import java.io.FileOutputStream;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.AbstractWorkspaceGenerator;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sexec.ExecutionFlow;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sexec.ExecutionState;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgen.GeneratorEntry;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _generatorClass_1 = data.getGeneratorClass();
    String _simpleName = this.simpleName(_generatorClass_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractWorkspaceGenerator implements IExecutionFlowGenerator{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private static final String LBR = \"\\n\\r\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void generate(ExecutionFlow flow, GeneratorEntry entry) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("StringBuilder builder = new StringBuilder();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("builder.append(\"The name of the Statemachine is \");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("builder.append(flow.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("builder.append(LBR).append(LBR);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("builder.append(\"The Statemachine has the following states:\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("builder.append(LBR).append(LBR);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (ExecutionState state : flow.getStates()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.append(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("state.getName().replaceFirst(flow.getName() + \"\\\\.\", \"\"))");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append(".append(LBR);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("File targetFolder = getTargetFolder(entry);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("File targetFile = new File(targetFolder.getPath() + File.separator");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("+ flow.getName() + \".txt\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("write(targetFolder, targetFile, builder.toString());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refreshTargetProject(entry);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void write(File targetFolder, File targetFile, String content) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("targetFolder.mkdirs();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("FileOutputStream out = new FileOutputStream(targetFile);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("out.write(content.getBytes());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("out.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("writeToConsole(e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation xtendGenerator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _generatorClass = data.getGeneratorClass();
    String _packageName = this.packageName(_generatorClass);
    _builder.append(_packageName, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.File");
    _builder.newLine();
    _builder.append("import java.io.FileOutputStream");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgen.GeneratorEntry");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sexec.ExecutionFlow");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sexec.ExecutionState");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.AbstractWorkspaceGenerator");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _generatorClass_1 = data.getGeneratorClass();
    String _simpleName = this.simpleName(_generatorClass_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractWorkspaceGenerator implements IExecutionFlowGenerator {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override generate(ExecutionFlow flow, GeneratorEntry entry) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("entry.targetFolder.write(flow.name+\'.txt\',flow.info)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refreshTargetProject(entry)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def info(ExecutionFlow flow) {\'\'");
    _builder.append("\'", "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("The name of the Statemachine is \'");
    _builder.append("\u00AB", "		");
    _builder.append("flow.name\u00BB\'");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("The Statemachine has the following states:");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\u00AB", "		");
    _builder.append("FOR ExecutionState state : flow.states\u00BB");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("\u00AB", "			");
    _builder.append("state.name.replaceFirst(flow.name+\'\\\\.\',\'\')\u00BB");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("\u00AB", "		");
    _builder.append("ENDFOR\u00BB");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'\'");
    _builder.append("\'", "	");
    _builder.append(".toString}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def write(File dir, String filename, String content) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("dir.mkdirs");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val bos = new FileOutputStream(new File(dir.path+File::separator+filename))");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("bos.write(content.bytes)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("bos.close");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch(Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("writeToConsole(e)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
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
    _builder.append("import static ");
    String _libraryConstantsClass = this.libraryConstantsClass(data);
    _builder.append(_libraryConstantsClass, "");
    _builder.append(".LIBRARY_NAME;");
    _builder.newLineIfNotEmpty();
    _builder.append("import static ");
    String _libraryConstantsClass_1 = this.libraryConstantsClass(data);
    _builder.append(_libraryConstantsClass_1, "");
    _builder.append(".MY_PARAMETER;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.IStatus;");
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.Status;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgen.FeatureParameterValue;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgen.FeatureTypeLibrary;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgraph.Statechart;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Default value provider for ");
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
    _builder.append("if (MY_PARAMETER.equals(parameterName)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("parameterValue.setValue(\"default value\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IStatus validateParameterValue(FeatureParameterValue parameterValue) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String parameterName = parameterValue.getParameter().getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// TODO implement validation");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// return error(\"Illegal parameter value\");");
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
  
  public StringConcatenation libraryConstants(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _libraryConstantsClass = this.libraryConstantsClass(data);
    String _packageName = this.packageName(_libraryConstantsClass);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _libraryConstantsClass_1 = this.libraryConstantsClass(data);
    String _simpleName = this.simpleName(_libraryConstantsClass_1);
    _builder.append(_simpleName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public static final String LIBRARY_NAME = \"");
    String _generatorName = data.getGeneratorName();
    _builder.append(_generatorName, "	");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public static final String MY_FEATURE = \"MyFeature\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final String MY_PARAMETER = \"MyParameter\";");
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
    return _builder;
  }
  
  public StringConcatenation jdtSettings(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.5");
    _builder.newLine();
    _builder.append("org.eclipse.jdt.core.compiler.compliance=1.5");
    _builder.newLine();
    _builder.append("org.eclipse.jdt.core.compiler.source=1.5");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation buildProperties(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("source.. = src");
    {
      GeneratorType _generatorType = data.getGeneratorType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_generatorType, GeneratorType.Xtend);
      if (_operator_equals) {
        _builder.append(",\\");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("xtend-gen");
        _builder.newLine();
      }
    }
    {
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        _builder.append("bin.includes = META-INF/,.,plugin.xml");
        _builder.newLine();} else {
        _builder.append("bin.includes = META-INF/,.");
        _builder.newLine();
      }
    }
    return _builder;
  }
}