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

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.resources.IContainer
import org.eclipse.core.runtime.Path
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource
import org.eclipse.xtend.shared.ui.wizards.EclipseHelper
import org.eclipse.core.resources.ResourcesPlugin
import org.apache.commons.lang.StringEscapeUtils
/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
class ProjectTemplate {
	
	def doGenerate(ProjectData data, IProgressMonitor monitor) {
		var folderPath = 'src/'+data.targetPackage.asFolder
		createFolder(folderPath,data.project, monitor)
		var generatorFolder = data.project.getFolder(new Path(folderPath))
		
		EclipseHelper::createFile('.settings/org.eclipse.core.resources.prefs',data.project,
			data.projectSettings(ResourcesPlugin::encoding).toString,monitor)
		
		EclipseHelper::createFile('.settings/org.eclipse.xtend.shared.ui.prefs',data.project,
			data.xpandSettings.toString,monitor)
		
		EclipseHelper::createFile(data.templateName+'.xpt',generatorFolder,
			resource('DefaultTemplate.xpt','iso-8859-1'),monitor)
		
		if (data.pluginExport) {
			EclipseHelper::createFile('plugin.xml',data.project,data.plugin.toString,monitor)
			EclipseHelper::createFile('src/'+data.generatorClass.javaFilename,data.project,data.generator.toString,monitor)
			if (data.typeLibrary) {
				createFolder('library', data.project, monitor)
				//TODO create FeatureTypeLibrary.xmi							
			}
			EclipseHelper::createFile('build.properties',data.project,data.buildProperties.toString,monitor)
		}
	}
	
	
	def templateName(ProjectData data) {
		if (data.pluginExport)
			data.generatorClass.simpleName
		else
			'Main'
	}
	
	def resource(String name, String encoding) {
		XpandGeneratorProjectWizard::getResourceContents(name,encoding)
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
	
	def javaFilename(String s) {
		s.replaceAll('\\.','/')+'.java'
	}
	
	def createFolder(String folderPath, IContainer container,
			IProgressMonitor monitor) {
		createFolderHierarchy(container.getFolder(new Path(folderPath)), monitor);
	}

	 def createFolderHierarchy(IFolder folder, IProgressMonitor monitor) {
		if (!folder.exists) {
			if (!folder.parent.exists
					&& folder.parent.type == IResource::FOLDER) {
				createFolderHierarchy(folder.parent as IFolder, monitor);
			}
			folder.create(true, true, monitor);
		}
	}
	
	def escapeForXml(String s) {
		StringEscapeUtils::escapeXml(s)
	}
	
	
	def plugin(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<?eclipse version="3.4"?>
		<plugin>
		   <extension
		         point="org.yakindu.sct.generator.core.generator">
		      <SCTGenerator class="«data.generatorClass»"
		            description="«data.generatorDescription.escapeForXml»"
		            id="«data.generatorId»"
		            name="«data.generatorName.escapeForXml»">
		      </SCTGenerator>
		   </extension>
		«IF data.typeLibrary»
		   <extension
		         point="org.yakindu.sct.generator.core.featuretypes">
		      <FeatureLibrary generatorId="«data.generatorId»" 
		      defaultProvider="«data.providerClass»"
		            uri="platform:/plugin/«data.project.name»/library/FeatureTypeLibrary.xmi">
		      </FeatureLibrary>
		   </extension>
		«ENDIF»   
		</plugin>
	'''
	
	def generator(ProjectData data) '''
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
	
	def defaultProvider(ProjectData data) '''
		package «data.providerClass.packageName»;
		
		import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
		
		/**
		 * Default value proivder for «data.generatorName» feature library
		 */
		public class «data.providerClass.simpleName» extends AbstractDefaultFeatureValueProvider {
		
			private static final String LIBRARY_NAME = "«data.generatorName»";
			
			@Override
			protected void setDefaultValue(FeatureParameterValue parameterValue,
					Statechart statechart) {
				String parameterName = parameterValue.getParameter().getName();
				//TODO: set the default values
			}
		
			public boolean isProviderFor(FeatureTypeLibrary library) {
				return library.getName().equals(LIBRARY_NAME);
			}
		
			public IStatus validateParameterValue(FeatureParameterValue value) {
				String name = value.getParameter().getName();
				//TODO implement validation
				return Status.OK_STATUS;
			}
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
	
	def buildProperties(ProjectData data) '''
		source.. = src/,\
		           src-gen
		bin.includes = META-INF/,\
		               .,\
		               plugin.xml
	'''
 }