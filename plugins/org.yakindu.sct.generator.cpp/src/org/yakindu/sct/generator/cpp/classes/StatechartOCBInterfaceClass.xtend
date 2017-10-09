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

import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.core.language.Comment
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.cpp.language.Constructor
import org.yakindu.sct.generator.cpp.language.Function
import org.yakindu.sct.generator.cpp.language.Modifier
import org.yakindu.sct.generator.cpp.language.Visibility
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope

/**
 * @author rbeckmann
 *
 */
class StatechartOCBInterfaceClass extends AbstractStatechartInterfaceClass {
	
	new(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent, InterfaceScope scope) {
		super(flow, entry, artifactConfigs, parent, scope)
		
		this.documentation = new Comment('''Inner class for «scope.simpleName» interface scope operation callbacks.''')
		
		this.name = scope.interfaceOCBName
		
		if(!entry.useStaticOPC) {
			val destructor = new Constructor() 
			destructor.name = "~" + scope.interfaceOCBName
			destructor.pure = true
			destructor.modifiers += Modifier.VIRTUAL
			addMember(destructor, Visibility.PUBLIC)
		}
		
		scope.operations.forEach[
			val callback = new Function
			callback.name = it.name.asEscapedIdentifier
			callback.type = new CustomType(it.typeSpecifier.targetLanguageName)
			if(entry.useStaticOPC) {
				callback.modifiers += Modifier.STATIC
			} else {
				callback.modifiers += Modifier.VIRTUAL
				callback.pure = true
			}
		]
	}
	
}