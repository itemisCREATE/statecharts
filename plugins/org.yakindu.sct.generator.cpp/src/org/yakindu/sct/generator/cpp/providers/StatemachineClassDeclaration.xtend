/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.CodeGeneratorFragmentProvider
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.files.StatemachineHeader
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.generator.cpp.submodules.InternalFunctions
import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.generator.cpp.submodules.TracingFunctions
import org.yakindu.sct.generator.cpp.submodules.lifecycle.LifecycleFunctions
import org.yakindu.sct.generator.cpp.templates.ClassDeclaration
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

@GeneratorContribution(StatemachineHeader.HEADER_TARGET)
class StatemachineClassDeclaration implements ISourceFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension StatechartExtensions
	
	@Inject protected GeneratorEntry entry
	
	@Inject protected extension InternalFunctions
	@Inject protected extension InterfaceFunctions
	@Inject protected extension TimingFunctions
	@Inject protected extension TracingFunctions
	@Inject protected extension LifecycleFunctions
	
	@Inject protected CodeGeneratorFragmentProvider fragmentProvider
	
	public static final String CLASS_PUBLIC_TARGET = StatemachineHeader.HEADER_TARGET + ".Class.Public"
	public static final String CLASS_PROTECTED_TARGET = StatemachineHeader.HEADER_TARGET + ".Class.Protected"
	public static final String CLASS_PRIVATE_TARGET = StatemachineHeader.HEADER_TARGET + ".Class.Private"
	public static final String CLASS_INNER_TARGET = StatemachineHeader.HEADER_TARGET + ".Class.InnerClasses"
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		generateClass(it, artifactConfigs, new ClassDeclaration).generate
	}
	
	def generateClass(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs, ClassDeclaration classDecl) {
		classDecl.name(module)
			.constructorDeclaration()
			.destructorDeclaration()
		interfaceExtensions.forEach[classDecl.superType(it)]
		
		fragmentProvider.get(CLASS_PUBLIC_TARGET, it, artifactConfigs).forEach[ fragment | 
			classDecl.publicMember(fragment.get(it, artifactConfigs))
		]
		
		fragmentProvider.get(CLASS_PROTECTED_TARGET, it, artifactConfigs).forEach[ fragment | 
			classDecl.protectedMember(fragment.get(it, artifactConfigs))
		]
		
		fragmentProvider.get(CLASS_PRIVATE_TARGET, it, artifactConfigs).forEach[ fragment | 
			classDecl.privateMember(fragment.get(it, artifactConfigs))
		]
		
		fragmentProvider.get(CLASS_INNER_TARGET, it, artifactConfigs).forEach[ fragment | 
			classDecl.member(entry.innerClassVisibility, fragment.get(it, artifactConfigs))
		]
					
		classDecl
	}
	
	def protected constructors(ClassDeclaration classDecl) {
		classDecl
			.constructorDeclaration()
			.destructorDeclaration()
	}
	
	def protected getInterfaceExtensions(ExecutionFlow flow) {

		var interfaces = newArrayList;

		if (flow.timed) {
			interfaces += "public " + timedStatemachineInterface
		}

		interfaces += "public " + statemachineInterface

		return interfaces;
	}
}
