package org.yakindu.sct.generator.genmodel.ui.wizard;

import com.google.common.base.Objects;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.yakindu.sct.generator.genmodel.ui.wizard.GeneratorType;
import org.yakindu.sct.generator.genmodel.ui.wizard.ProjectData;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.SGenFactory;

/**
 * @author holger willebrandt - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratorProjectTemplate {
  private IProgressMonitor monitor;
  
  public IProgressMonitor setMonitor(final IProgressMonitor monitor) {
    IProgressMonitor _monitor = this.monitor = monitor;
    return _monitor;
  }
  
  public Object generate(final ProjectData data) {
    try {
      Object _xblockexpression = null;
      {
        this.monitor.beginTask("Create YAKINDU Xpand Generator Project", 16);
        IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot _root = _workspace.getRoot();
        final IProject project = _root.getProject(data.projectName);
        SubProgressMonitor _sub = this.sub(this.monitor);
        project.create(_sub);
        SubProgressMonitor _sub_1 = this.sub(this.monitor);
        project.open(_sub_1);
        this.monitor.worked(1);
        this.createFolder(project, "src");
        boolean _equals = Objects.equal(data.generatorType, GeneratorType.Xtend);
        if (_equals) {
          this.createFolder(project, "xtend-gen");
        }
        IFile _file = project.getFile(".settings/org.eclipse.core.resources.prefs");
        String _encoding = ResourcesPlugin.getEncoding();
        CharSequence _projectSettings = this.projectSettings(data, _encoding);
        this.write(_file, _projectSettings);
        IFile _file_1 = project.getFile(".settings/org.eclipse.jdt.core.prefs");
        CharSequence _jdtSettings = this.jdtSettings(data);
        this.write(_file_1, _jdtSettings);
        boolean _notEquals = (!Objects.equal(data.generatorType, GeneratorType.Java));
        if (_notEquals) {
          IFile _file_2 = project.getFile(".settings/org.eclipse.xtend.shared.ui.prefs");
          CharSequence _xpandSettings = this.xpandSettings(data);
          this.write(_file_2, _xpandSettings);
        }
        IFile _file_3 = project.getFile("build.properties");
        CharSequence _buildProperties = this.buildProperties(data);
        this.write(_file_3, _buildProperties);
        IFile _file_4 = project.getFile("META-INF/MANIFEST.MF");
        CharSequence _manifest = this.manifest(data);
        this.write(_file_4, _manifest);
        if (data.pluginExport) {
          IFile _file_5 = project.getFile("plugin.xml");
          CharSequence _plugin = this.plugin(data);
          this.write(_file_5, _plugin);
          boolean _equals_1 = Objects.equal(data.generatorType, GeneratorType.Xpand);
          if (_equals_1) {
            String _javaFilename = this.javaFilename(data.generatorClass);
            String _plus = ("src/" + _javaFilename);
            IFile _file_6 = project.getFile(_plus);
            CharSequence _xpandGenerator = this.xpandGenerator(data);
            this.write(_file_6, _xpandGenerator);
          }
          if (data.typeLibrary) {
            this.createFolder(project, "library");
            IFile _file_7 = project.getFile("library/FeatureTypeLibrary.xmi");
            FeatureTypeLibrary _featureLibrary = this.featureLibrary(data);
            this.write(_file_7, _featureLibrary);
            String _providerClass = this.providerClass(data);
            String _javaFilename_1 = this.javaFilename(_providerClass);
            String _plus_1 = ("src/" + _javaFilename_1);
            IFile _file_8 = project.getFile(_plus_1);
            CharSequence _defaultProvider = this.defaultProvider(data);
            this.write(_file_8, _defaultProvider);
            String _libraryConstantsClass = this.libraryConstantsClass(data);
            String _javaFilename_2 = this.javaFilename(_libraryConstantsClass);
            String _plus_2 = ("src/" + _javaFilename_2);
            IFile _file_9 = project.getFile(_plus_2);
            CharSequence _libraryConstants = this.libraryConstants(data);
            this.write(_file_9, _libraryConstants);
          }
        }
        IFile _file_10 = project.getFile(".classpath");
        CharSequence _classpath = this.classpath(data);
        this.write(_file_10, _classpath);
        IFile _file_11 = project.getFile(".project");
        CharSequence _projectFile = this.projectFile(data);
        this.write(_file_11, _projectFile);
        Object _switchResult = null;
        final GeneratorType _switchValue = data.generatorType;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,GeneratorType.Xpand)) {
            _matched=true;
            String _targetPackage = this.targetPackage(data);
            String _asFolder = this.asFolder(_targetPackage);
            String _plus_3 = ("src/" + _asFolder);
            String _plus_4 = (_plus_3 + "/");
            String _templateName = this.templateName(data);
            String _plus_5 = (_plus_4 + _templateName);
            String _plus_6 = (_plus_5 + ".xpt");
            IFile _file_12 = project.getFile(_plus_6);
            String _fromMyFolder = this.fromMyFolder("XpandDefaultTemplate.xpt");
            String _resource = this.resource(_fromMyFolder, "iso-8859-1");
            this.write(_file_12, _resource);
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,GeneratorType.Xtend)) {
            _matched=true;
            String _xtendFilename = this.xtendFilename(data.generatorClass);
            String _plus_7 = ("src/" + _xtendFilename);
            IFile _file_13 = project.getFile(_plus_7);
            CharSequence _xtendGenerator = this.xtendGenerator(data);
            this.write(_file_13, _xtendGenerator);
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,GeneratorType.Java)) {
            _matched=true;
            String _javaFilename_3 = this.javaFilename(data.generatorClass);
            String _plus_8 = ("src/" + _javaFilename_3);
            IFile _file_14 = project.getFile(_plus_8);
            CharSequence _javaGenerator = this.javaGenerator(data);
            this.write(_file_14, _javaGenerator);
          }
        }
        _xblockexpression = (_switchResult);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String fromMyFolder(final String s) {
    String _plus = ("org/yakindu/sct/generator/genmodel/ui/wizard/" + s);
    return _plus;
  }
  
  public SubProgressMonitor sub(final IProgressMonitor mon) {
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(mon, 1);
    return _subProgressMonitor;
  }
  
  public String templateName(final ProjectData data) {
    String _xifexpression = null;
    boolean _or = false;
    if (data.pluginExport) {
      _or = true;
    } else {
      boolean _notEquals = (!Objects.equal(data.generatorType, GeneratorType.Xpand));
      _or = (data.pluginExport || _notEquals);
    }
    if (_or) {
      String _simpleName = this.simpleName(data.generatorClass);
      _xifexpression = _simpleName;
    } else {
      _xifexpression = "Main";
    }
    return _xifexpression;
  }
  
  public String targetPackage(final ProjectData data) {
    String _xifexpression = null;
    if (data.pluginExport) {
      String _packageName = this.packageName(data.generatorClass);
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
    int _plus = (_lastIndexOf + 1);
    String _substring = s.substring(_plus);
    return _substring;
  }
  
  public String packageName(final String s) {
    int _lastIndexOf = s.lastIndexOf(".");
    String _substring = s.substring(0, _lastIndexOf);
    return _substring;
  }
  
  public String providerClass(final ProjectData data) {
    String _plus = (data.generatorClass + "DefaultValueProvider");
    return _plus;
  }
  
  public String libraryConstantsClass(final ProjectData data) {
    String _providerClass = this.providerClass(data);
    String _packageName = this.packageName(_providerClass);
    String _plus = (_packageName + ".IFeatureConstants");
    return _plus;
  }
  
  public String javaFilename(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    String _plus = (_replaceAll + ".java");
    return _plus;
  }
  
  public String xtendFilename(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    String _plus = (_replaceAll + ".xtend");
    return _plus;
  }
  
  public FeatureTypeLibrary featureLibrary(final ProjectData data) {
    final SGenFactory factory = SGenFactory.eINSTANCE;
    final FeatureTypeLibrary lib = factory.createFeatureTypeLibrary();
    lib.setName(data.generatorName);
    final FeatureType type = factory.createFeatureType();
    type.setName("MyFeature");
    final FeatureParameter parameter = factory.createFeatureParameter();
    parameter.setName("MyParameter");
    parameter.setParameterType(ParameterTypes.STRING);
    EList<FeatureParameter> _parameters = type.getParameters();
    _parameters.add(parameter);
    EList<FeatureType> _types = lib.getTypes();
    _types.add(type);
    return lib;
  }
  
  public void write(final IFile file, final EObject object) {
    try {
      IPath _fullPath = file.getFullPath();
      String _string = _fullPath.toString();
      final URI uri = URI.createPlatformResourceURI(_string, true);
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      final ResourceSetImpl resourceSet = _resourceSetImpl;
      final Resource resource = resourceSet.createResource(uri);
      EList<EObject> _contents = resource.getContents();
      _contents.add(object);
      Map<Object,Object> _emptyMap = Collections.<Object, Object>emptyMap();
      resource.save(_emptyMap);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void write(final IFile file, final CharSequence content) {
    String _string = content.toString();
    this.write(file, _string);
  }
  
  public void write(final IFile file, final String content) {
    try {
      IContainer _parent = file.getParent();
      boolean _exists = _parent.exists();
      boolean _not = (!_exists);
      if (_not) {
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
          final SubProgressMonitor submonitor = this.sub(this.monitor);
          file.create(stream, true, submonitor);
          String _encoding = ResourcesPlugin.getEncoding();
          file.setCharset(_encoding, submonitor);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        stream.close();
      }
      this.monitor.worked(1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createFolder(final IContainer container, final String folderPath) {
    Path _path = new Path(folderPath);
    IFolder _folder = container.getFolder(_path);
    SubProgressMonitor _sub = this.sub(this.monitor);
    this.createFolderHierarchy(_folder, _sub);
    this.monitor.worked(1);
  }
  
  public void createFolderHierarchy(final IFolder folder, final IProgressMonitor submonitor) {
    try {
      boolean _exists = folder.exists();
      boolean _not = (!_exists);
      if (_not) {
        boolean _and = false;
        IContainer _parent = folder.getParent();
        boolean _exists_1 = _parent.exists();
        boolean _not_1 = (!_exists_1);
        if (!_not_1) {
          _and = false;
        } else {
          IContainer _parent_1 = folder.getParent();
          int _type = _parent_1.getType();
          boolean _equals = (_type == IResource.FOLDER);
          _and = (_not_1 && _equals);
        }
        if (_and) {
          IContainer _parent_2 = folder.getParent();
          this.createFolderHierarchy(((IFolder) _parent_2), submonitor);
        }
        folder.create(true, true, this.monitor);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String escapeForXml(final String s) {
    String _escapeXml = StringEscapeUtils.escapeXml(s);
    return _escapeXml;
  }
  
  public String resource(final String path, final String encoding) {
    try {
      String _xblockexpression = null;
      {
        Thread _currentThread = Thread.currentThread();
        ClassLoader _contextClassLoader = _currentThread.getContextClassLoader();
        final InputStream inStream = _contextClassLoader.getResourceAsStream(path);
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
            int _minus = (-1);
            boolean _notEquals = (_result != _minus);
            boolean _while = _notEquals;
            while (_while) {
              outStream.write(((byte) result));
              int _read_1 = buffer.read();
              int _result_1 = result = _read_1;
              int _minus_1 = (-1);
              boolean _notEquals_1 = (_result_1 != _minus_1);
              _while = _notEquals_1;
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence projectFile(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<projectDescription>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>");
    _builder.append(data.projectName, "	");
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
      boolean _notEquals = (!Objects.equal(data.generatorType, GeneratorType.Java));
      if (_notEquals) {
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
      boolean _equals = Objects.equal(data.generatorType, GeneratorType.Xtend);
      if (_equals) {
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
      boolean _notEquals_1 = (!Objects.equal(data.generatorType, GeneratorType.Java));
      if (_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("<nature>org.eclipse.xtend.shared.ui.xtendXPandNature</nature>");
        _builder.newLine();
      }
    }
    {
      boolean _equals_1 = Objects.equal(data.generatorType, GeneratorType.Xtend);
      if (_equals_1) {
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
  
  public CharSequence classpath(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<classpath>");
    _builder.newLine();
    {
      boolean _equals = Objects.equal(data.generatorType, GeneratorType.Xtend);
      if (_equals) {
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
  
  public CharSequence manifest(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    _builder.append(data.projectName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-SymbolicName: ");
    _builder.append(data.projectName, "");
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
      boolean _or = false;
      boolean _equals = Objects.equal(data.generatorType, GeneratorType.Xpand);
      if (_equals) {
        _or = true;
      } else {
        boolean _equals_1 = Objects.equal(data.generatorType, GeneratorType.Xtend);
        _or = (_equals || _equals_1);
      }
      if (_or) {
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
      boolean _equals_2 = Objects.equal(data.generatorType, GeneratorType.Xtend);
      if (_equals_2) {
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtext.xbase.lib;bundle-version=\"2.0.1\",");
        _builder.newLineIfNotEmpty();
        _builder.append(" ", "");
        _builder.append("org.eclipse.xtend2.lib;bundle-version=\"2.0.1\",");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _or_1 = false;
      if (data.pluginExport) {
        _or_1 = true;
      } else {
        boolean _notEquals = (!Objects.equal(data.generatorType, GeneratorType.Xpand));
        _or_1 = (data.pluginExport || _notEquals);
      }
      if (_or_1) {
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
  
  public CharSequence plugin(final ProjectData data) {
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
    _builder.append(data.generatorClass, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("description=\"");
    String _escapeForXml = this.escapeForXml(data.generatorDescription);
    _builder.append(_escapeForXml, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("id=\"");
    _builder.append(data.generatorId, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("name=\"");
    String _escapeForXml_1 = this.escapeForXml(data.generatorName);
    _builder.append(_escapeForXml_1, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("contentType=\"statechart\"");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("elementRefType=\"org.yakindu.sct.model.sgraph.Statechart\">");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("</SCTGenerator>");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("</extension>");
    _builder.newLine();
    {
      if (data.typeLibrary) {
        _builder.append("<extension");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("point=\"org.yakindu.sct.generator.core.featuretypes\">");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("<FeatureLibrary generatorId=\"");
        _builder.append(data.generatorId, "   ");
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
        _builder.append(data.projectName, "         ");
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
  
  public CharSequence xpandGenerator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this.packageName(data.generatorClass);
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
    String _javaPathToXpand = this.javaPathToXpand(data.generatorClass);
    _builder.append(_javaPathToXpand, " ");
    _builder.append("::main\"");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this.simpleName(data.generatorClass);
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
    String _javaPathToXpand_1 = this.javaPathToXpand(data.generatorClass);
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
  
  public CharSequence javaGenerator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this.packageName(data.generatorClass);
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
    _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this.simpleName(data.generatorClass);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractWorkspaceGenerator implements IExecutionFlowGenerator{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private static final String LBR = \"\\n\\r\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {");
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
  
  public CharSequence xtendGenerator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this.packageName(data.generatorClass);
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
    _builder.append("import org.eclipse.xtext.generator.IFileSystemAccess");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _simpleName = this.simpleName(data.generatorClass);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractWorkspaceGenerator implements IExecutionFlowGenerator {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {");
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
  
  public CharSequence defaultProvider(final ProjectData data) {
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
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgen.FeatureParameterValue;");
    _builder.newLine();
    _builder.append("import org.yakindu.sct.model.sgen.FeatureTypeLibrary;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Default value provider for ");
    _builder.append(data.generatorName, " ");
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
    _builder.append("EObject context) {");
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
  
  public CharSequence libraryConstants(final ProjectData data) {
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
    _builder.append(data.generatorName, "	");
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
  
  public CharSequence projectSettings(final ProjectData data, final String encoding) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("encoding/<project>=");
    _builder.append(encoding, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence xpandSettings(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("project.specific.metamodel=true");
    _builder.newLine();
    _builder.append("metamodelContributor=org.eclipse.xtend.typesystem.emf.ui.EmfMetamodelContributor");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence jdtSettings(final ProjectData data) {
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
  
  public CharSequence buildProperties(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("source.. = src");
    {
      boolean _equals = Objects.equal(data.generatorType, GeneratorType.Xtend);
      if (_equals) {
        _builder.append(",\\");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("xtend-gen");
        _builder.newLine();
      }
    }
    {
      if (data.pluginExport) {
        _builder.append("bin.includes = META-INF/,.,plugin.xml");
        _builder.newLine();
      } else {
        _builder.append("bin.includes = META-INF/,.");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
