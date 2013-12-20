/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */ 
package org.yakindu.sct.generator.genmodel.ui.wizard

import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.Collections
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.yakindu.sct.model.sgen.ParameterTypes
import org.yakindu.sct.model.sgen.SGenFactory
import com.google.inject.Provider
import org.eclipse.core.resources.IWorkspace
import com.google.inject.Inject
import org.eclipse.xtext.parser.IEncodingProvider

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
class GeneratorProjectTemplate {
	
	IProgressMonitor monitor
	
	@Inject Provider<IWorkspace> workspaceProvider;
	@Inject IEncodingProvider encodingProvider; 
	
	def setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor
	}

	def generate(ProjectData data) {
		monitor.beginTask("Create YAKINDU Xpand Generator Project", 16);
		val project = workspaceProvider.get().root.getProject(data.projectName);
		project.create(monitor.sub)
		project.open(monitor.sub)
		monitor.worked(1)
		project.createFolder('src')
		if (data.generatorType == GeneratorType::Xtend){
			project.createFolder('xtend-gen')
		}
		project.getFile('.settings/org.eclipse.core.resources.prefs')
			.write(data.projectSettings(encodingProvider.getEncoding(URI::createPlatformResourceURI(project.location.toString, true))))
		project.getFile('.settings/org.eclipse.jdt.core.prefs')
			.write(data.jdtSettings())
		if (data.generatorType != GeneratorType::Java) {
			project.getFile('.settings/org.eclipse.xtend.shared.ui.prefs')
				.write(data.xpandSettings)
		}
		project.getFile('build.properties').write(data.buildProperties)
		project.getFile('META-INF/MANIFEST.MF').write(data.manifest)
		if (data.pluginExport) {
			project.getFile('plugin.xml').write(data.plugin)
			if (data.generatorType == GeneratorType::Xpand) {
				project.getFile('src/'+data.generatorClass.javaFilename)
					.write(data.xpandGenerator)
			}
			if (data.typeLibrary) {
				project.createFolder('library')
				project.getFile('library/FeatureTypeLibrary.xmi')
					.write(data.featureLibrary)
				project.getFile('src/'+data.providerClass.javaFilename)
					.write(data.defaultProvider)
				project.getFile('src/'+data.libraryConstantsClass.javaFilename)
					.write(data.libraryConstants)
			}	
		}
		project.getFile('.classpath').write(data.classpath);
		project.getFile('.project').write(data.projectFile);
		switch data.generatorType {
			case GeneratorType::Xpand :
				project.getFile('src/'+data.targetPackage.asFolder+'/'+data.templateName+'.xpt').
					write(resource('XpandDefaultTemplate.xpt'.fromMyFolder,'iso-8859-1'))
			case GeneratorType::Xtend :
				project.getFile('src/'+data.generatorClass.xtendFilename).
					write(data.xtendGenerator)
			case GeneratorType::Java :
				project.getFile('src/'+data.generatorClass.javaFilename).
					write(data.javaGenerator)
		}
	}
	
	def fromMyFolder(String s) {
		'org/yakindu/sct/generator/genmodel/ui/wizard/'+s
	}
	
	def sub(IProgressMonitor mon) {
		new SubProgressMonitor(mon,1)
	}
	
	def templateName(ProjectData data) {
		if (data.pluginExport || data.generatorType != GeneratorType::Xpand)
			data.generatorClass.simpleName
		else
			'Main'
	}
	
	def targetPackage(ProjectData data) {
		if (data.pluginExport)
			data.generatorClass.packageName
		else
			'org.yakindu.sct.generator.xpand'
	}
	
	def asFolder(String s) {
		s.replaceAll('\\.','/')
	}
	
	def javaPathToXpand(String s) {
		s.replaceAll('\\.','::')
	}
	
	def simpleName(String s) {
		s.substring(s.lastIndexOf('.')+1)
	}
	
	def packageName(String s) {
		s.substring(0, s.lastIndexOf('.'))	
	}
	
	def providerClass(ProjectData data){
		data.generatorClass+'DefaultValueProvider'
	}

	def libraryConstantsClass(ProjectData data){
		data.providerClass.packageName+'.IFeatureConstants'
	}
	
	def javaFilename(String s) {
		s.replaceAll('\\.','/')+'.java'
	}
	def xtendFilename(String s) {
		s.replaceAll('\\.','/')+'.xtend'
	}
	
	def featureLibrary(ProjectData data) {
		val factory = SGenFactory::eINSTANCE
		val lib = factory.createFeatureTypeLibrary
		lib.name=data.generatorName
		val type = factory.createFeatureType
		type.name='MyFeature'
		val parameter = factory.createFeatureParameter
		parameter.name='MyParameter'
		parameter.parameterType=ParameterTypes::STRING
		type.parameters.add(parameter)
		lib.types.add(type)
		return lib		
	}
	
	def write(IFile file, EObject object) {
		val uri = URI::createPlatformResourceURI(file.fullPath.toString,true)
		val resourceSet = new ResourceSetImpl()
		val resource = resourceSet.createResource(uri)
		resource.contents.add(object)
		resource.save(Collections::emptyMap)
	}
	
	def write(IFile file, CharSequence content) {
		file.write(content.toString)
	}

	def write(IFile file, String content) {
		if (!file.parent.exists) {
			createFolderHierarchy(file.parent as IFolder,monitor.sub)
		}
		val stream = new ByteArrayInputStream(content.getBytes(file.charset))
		try {
			if (file.exists) {
				file.setContents(stream, true, true, monitor.sub)
			} else {
				val submonitor = monitor.sub
				file.create(stream, true, submonitor)
				file.setCharset(encodingProvider.getEncoding(URI::createPlatformResourceURI(file.location.toString, true)), submonitor)
			}
		} catch (Exception e) {
			e.printStackTrace
		} finally{
			stream.close();
		}
		monitor.worked(1)
	}
	
	def createFolder(IContainer container, String folderPath) {
		createFolderHierarchy(container.getFolder(new Path(folderPath)),monitor.sub);
		monitor.worked(1)
	}

	 def void createFolderHierarchy(IFolder folder, IProgressMonitor submonitor) {
		if (!folder.exists) {
			if (!folder.parent.exists
					&& folder.parent.type == IResource::FOLDER) {
				createFolderHierarchy(folder.parent as IFolder,submonitor);
			}
			folder.create(true, true, monitor);
		}
	}
	
	def escapeForXml(String s) {
		StringEscapeUtils::escapeXml(s)
	}
	
	def resource(String path, String encoding) {
		val inStream = Thread::currentThread.contextClassLoader.getResourceAsStream(path)
		val outStream = new ByteArrayOutputStream()
		try {
			val buffer = new BufferedInputStream(inStream)
			var result=0;
			while ((result=buffer.read) != -1 ) {
				outStream.write(result as byte)
			}
			outStream.toString(encoding)
		} finally {
			inStream.close
		}
	}
	
	def projectFile(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<projectDescription>
			<name>«data.projectName»</name>
			<comment></comment>
			<projects>
			</projects>
			<buildSpec>
				«IF data.generatorType != GeneratorType::Java»
					<buildCommand>
						<name>org.eclipse.xtend.shared.ui.xtendBuilder</name>
						<arguments>
						</arguments>
					</buildCommand>
				«ENDIF»
				<buildCommand>
					<name>org.eclipse.pde.ManifestBuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
				<buildCommand>
					<name>org.eclipse.pde.SchemaBuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
				<buildCommand>
					<name>org.eclipse.jdt.core.javabuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
				«IF data.generatorType == GeneratorType::Xtend»
					<buildCommand>
						<name>org.eclipse.xtext.ui.shared.xtextBuilder</name>
						<arguments>
						</arguments>
					</buildCommand>				
				«ENDIF»
			</buildSpec>
			<natures>
				<nature>org.eclipse.jdt.core.javanature</nature>
				<nature>org.eclipse.pde.PluginNature</nature>
				«IF data.generatorType != GeneratorType::Java»
					<nature>org.eclipse.xtend.shared.ui.xtendXPandNature</nature>
				«ENDIF»
				«IF data.generatorType == GeneratorType::Xtend»
					<nature>org.eclipse.xtext.ui.shared.xtextNature</nature>
				«ENDIF»
			</natures>
		</projectDescription>
	'''
	
	def classpath(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<classpath>
			«IF data.generatorType == GeneratorType::Xtend»
				<classpathentry kind="src" path="xtend-gen"/>
			«ENDIF»
			<classpathentry kind="src" path="src"/>
			<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
			<classpathentry kind="con" path="org.eclipse.pde.core.requiredPlugins"/>
			<classpathentry kind="output" path="bin"/>
		</classpath>
	'''
	
	def manifest(ProjectData data)'''
		Manifest-Version: 1.0
		Bundle-ManifestVersion: 2
		Bundle-Name: «data.projectName»
		Bundle-SymbolicName: «data.projectName»; singleton:=true
		Bundle-Version: 1.0.0
		Require-Bundle: org.eclipse.jdt.core;bundle-version="3.5.0",
		 org.apache.commons.logging,
		 org.apache.log4j;resolution:=optional,
		 com.ibm.icu;bundle-version="4.0.1",
		 org.antlr.runtime;bundle-version="3.0.0",
		 org.eclipse.core.runtime;bundle-version="3.5.0",
		 org.eclipse.emf.mwe.utils;bundle-version="0.7.0",
		 org.eclipse.emf.ecore.xmi;bundle-version="2.5.0",
		 org.eclipse.jface.text;bundle-version="3.5.0",
		«IF data.generatorType == GeneratorType::Xpand || data.generatorType == GeneratorType::Xtend»
			«' '»org.eclipse.xpand;bundle-version="0.7.0",
			«' '»org.eclipse.xtend;bundle-version="0.7.0",
			«' '»org.eclipse.xtend.typesystem.emf;bundle-version="0.7.0",
			«' '»org.eclipse.xtend.profiler;resolution:=optional,
		«ENDIF»
		«IF data.generatorType == GeneratorType::Xtend»
			«' '»org.eclipse.xtext.xbase.lib;bundle-version="2.0.1",
			«' '»org.eclipse.xtend.lib;bundle-version="2.0.1",
		«ENDIF»
		«IF data.pluginExport || data.generatorType != GeneratorType::Xpand»
			«' '»org.yakindu.sct.generator.core;bundle-version="1.0.0",
		«ENDIF»
		 org.yakindu.sct.model.sgen;bundle-version="1.0.0",
		 org.yakindu.sct.model.sexec;bundle-version="1.0.0",
		 org.yakindu.sct.model.stext;bundle-version="1.0.0",
		 org.yakindu.sct.model.sgraph;bundle-version="1.0.0"
		Bundle-RequiredExecutionEnvironment: J2SE-1.5
	'''
	
	def plugin(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<?eclipse version="3.4"?>
		<plugin>
		   <extension
		         point="org.yakindu.sct.generator.core.generator">
		      <SCTGenerator class="«data.generatorClass»"
		            description="«data.generatorDescription.escapeForXml»"
		            id="«data.generatorId»"
		            name="«data.generatorName.escapeForXml»"
		            contentType="statechart"
		            elementRefType="org.yakindu.sct.model.sgraph.Statechart">
		            «IF data.typeLibrary»
		            <FeatureLibrary
		            	library_id="«data.projectName».FeatureTypeLibrary">
		            </FeatureLibrary>
		            «ENDIF»
		      </SCTGenerator>
		   </extension>
		«IF data.typeLibrary»
		   <extension
		         point="org.yakindu.sct.generator.core.featuretypes">
		      <FeatureLibrary
		      	library_id="«data.projectName».FeatureTypeLibrary"
		      	defaultProvider="«data.providerClass»"
		      	uri="platform:/plugin/«data.projectName»/library/FeatureTypeLibrary.xmi">
		      </FeatureLibrary>
		   </extension>
		«ENDIF»   
		</plugin>
	'''
	
	def xpandGenerator(ProjectData data) '''
		package «data.generatorClass.packageName»;
		
		import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;
		
		/**
		 * Generator using Xpand template "«data.generatorClass.javaPathToXpand»::main"
		 */
		public class «data.generatorClass.simpleName» extends AbstractXpandBasedCodeGenerator {
		
			@Override
			public String getTemplatePath() {
				return "«data.generatorClass.javaPathToXpand»::main";
			}
		}
	'''
	
	def javaGenerator(ProjectData data) '''
		package «data.generatorClass.packageName»;

		import java.io.File;
		import java.io.FileOutputStream;
		import org.yakindu.sct.generator.core.AbstractWorkspaceGenerator;
		import org.yakindu.sct.model.sexec.ExecutionFlow;
		import org.yakindu.sct.model.sexec.ExecutionState;
		import org.yakindu.sct.model.sgen.GeneratorEntry;
		import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator;
		import org.eclipse.xtext.generator.IFileSystemAccess;
		
		public class «data.generatorClass.simpleName» extends AbstractWorkspaceGenerator implements IExecutionFlowGenerator{
			private static final String LBR = "\n\r";

			public void generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {
				StringBuilder builder = new StringBuilder();
				builder.append("The name of the Statemachine is ");
				builder.append(flow.getName());
				builder.append(LBR).append(LBR);
				builder.append("The Statemachine has the following states:");
				builder.append(LBR).append(LBR);
				for (ExecutionState state : flow.getStates()) {
					builder.append(
							state.getName().replaceFirst(flow.getName() + "\\.", ""))
							.append(LBR);
				}
				File targetFolder = getTargetFolder(entry);
				File targetFile = new File(targetFolder.getPath() + File.separator
						+ flow.getName() + ".txt");
				write(targetFolder, targetFile, builder.toString());
				refreshTargetProject(entry);
			}
		
			private void write(File targetFolder, File targetFile, String content) {
				try {
					targetFolder.mkdirs();
					FileOutputStream out = new FileOutputStream(targetFile);
					out.write(content.getBytes());
					out.close();
				} catch (Exception e) {
					writeToConsole(e);
				}
			}
		}
	'''
	def xtendGenerator(ProjectData data) '''
		package «data.generatorClass.packageName»

		import java.io.File
		import java.io.FileOutputStream
		import org.yakindu.sct.model.sgen.GeneratorEntry
		import org.yakindu.sct.model.sexec.ExecutionFlow
		import org.yakindu.sct.model.sexec.ExecutionState
		import org.yakindu.sct.generator.core.AbstractWorkspaceGenerator
		import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
		import org.eclipse.xtext.generator.IFileSystemAccess
		
		class «data.generatorClass.simpleName» extends AbstractWorkspaceGenerator implements IExecutionFlowGenerator {
		
			override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {
				entry.targetFolder.write(flow.name+'.txt',flow.info)
				refreshTargetProject(entry)
			}
		
			def info(ExecutionFlow flow) {''«"'"»
				The name of the Statemachine is '«'«'»flow.name»'

				The Statemachine has the following states:
		
				«'«'»FOR ExecutionState state : flow.states»
					«'«'»state.name.replaceFirst(flow.name+'\\.','')»
				«'«'»ENDFOR»
			''«"'"».toString}
		
			def write(File dir, String filename, String content) {
				try {
					dir.mkdirs
					val bos = new FileOutputStream(new File(dir.path+File::separator+filename))
					bos.write(content.bytes)
					bos.close
				} catch(Exception e) {
					writeToConsole(e)
				}
			}
		}
	'''
	
	
	def defaultProvider(ProjectData data) '''
		package «data.providerClass.packageName»;
		
		import static «data.libraryConstantsClass».LIBRARY_NAME;
		import static «data.libraryConstantsClass».MY_PARAMETER;
		
		import org.eclipse.core.runtime.IStatus;
		import org.eclipse.core.runtime.Status;
		import org.eclipse.emf.ecore.EObject;
		import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
		import org.yakindu.sct.model.sgen.FeatureParameterValue;
		import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
			
		/**
		 * Default value provider for «data.generatorName» feature library
		 */
		public class «data.providerClass.simpleName» extends AbstractDefaultFeatureValueProvider {
		

			public boolean isProviderFor(FeatureTypeLibrary library) {
				return library.getName().equals(LIBRARY_NAME);
			}

			@Override
			protected void setDefaultValue(FeatureParameterValue parameterValue,
					EObject context) {
				String parameterName = parameterValue.getParameter().getName();
				if (MY_PARAMETER.equals(parameterName)) {
					parameterValue.setValue("default value");
				}
			}
		
			public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
				String parameterName = parameterValue.getParameter().getName();
				// TODO implement validation
				// return error("Illegal parameter value");
				return Status.OK_STATUS;
			}
		}
	'''
	
	def libraryConstants(ProjectData data) '''
		package «data.libraryConstantsClass.packageName»;
		
		public interface «data.libraryConstantsClass.simpleName» {
			public static final String LIBRARY_NAME = "«data.generatorName»";
			public static final String MY_FEATURE = "MyFeature";
			public static final String MY_PARAMETER = "MyParameter";
		}
	'''
	
	def projectSettings(ProjectData data, String encoding) '''
		eclipse.preferences.version=1
		encoding/<project>=«encoding»
	'''

	def xpandSettings(ProjectData data) '''
		eclipse.preferences.version=1
		project.specific.metamodel=true
		metamodelContributor=org.eclipse.xtend.typesystem.emf.ui.EmfMetamodelContributor
	'''
	
	def jdtSettings(ProjectData data) '''
		eclipse.preferences.version=1
		org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.5
		org.eclipse.jdt.core.compiler.compliance=1.5
		org.eclipse.jdt.core.compiler.source=1.5
	'''
	
	def buildProperties(ProjectData data) '''
		source.. = src«IF data.generatorType == GeneratorType::Xtend»,\
			xtend-gen
		«ENDIF»
		«IF data.pluginExport»
			bin.includes = META-INF/,.,plugin.xml
		«ELSE»
			bin.includes = META-INF/,.
		«ENDIF»
	'''
	 
 }