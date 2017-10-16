/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.classes

import org.yakindu.base.types.Declaration
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.language.Modifier
import org.yakindu.sct.generator.c.language.Type
import org.yakindu.sct.generator.c.language.TypeQualifier
import org.yakindu.sct.generator.c.language.Variable
import org.yakindu.sct.generator.core.language.Comment
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.core.language.IVariable
import org.yakindu.sct.generator.cpp.language.FriendClass
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 * 
 */
class StatechartInterfaceClass extends AbstractStatechartInterfaceClass {

	override build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent,
		StatechartScope scope) {
		super.build(flow, entry, artifactConfigs, parent, scope)
		
		this.name = scope.interfaceName
		this.documentation = new Comment('''Inner class for «scope.simpleName» interface scope.''')

		createScopeDeclarationFunctions(scope)

		val innerClassVisibility = getInnerClassVisibility()
		addMember(new FriendClass(parent.name), innerClassVisibility)

		scope.declarations.map[interfaceMember].filter[!nullOrEmpty].flatten.filter[it !== null].forEach[addMember(innerClassVisibility)]
	}

	def dispatch Iterable<IVariable> interfaceMember(Declaration it) {
		null
	}
	
	def dispatch Iterable<IVariable> interfaceMember(VariableDefinition it) {
		if (type.name != Type.VOID) {
			val member = new Variable(typeSpecifier.targetLanguageName, it.name.asEscapedIdentifier)
			if (const) {
				member.typeQualifier = TypeQualifier.CONST
				member.modifiers += Modifier.STATIC
			}
			#[member]
		} else
			null
	}

	def dispatch Iterable<IVariable> interfaceMember(EventDefinition it) {
		val raisedFlag = new Variable()
		raisedFlag.type = Type.BOOL
		raisedFlag.name = it.name.asIdentifier + "_raised"
		if (hasValue) {
			val eventValue = new Variable(it.typeSpecifier.targetLanguageName, it.name.asIdentifier + "_value")
			#[raisedFlag, eventValue]
		} else
			#[raisedFlag]
	}

	def dispatch Iterable<IVariable> interfaceMember(TimeEvent it) {
		#[new Variable(Type.BOOL, shortName.raised)]
	}

}
