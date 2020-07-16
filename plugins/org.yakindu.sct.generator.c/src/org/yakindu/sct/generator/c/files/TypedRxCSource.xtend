/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.base.types.TypeSpecifier

/**
 * @author Robin Herrmann
 */
class TypedRxCSource implements IContentTemplate {
	@Inject extension Naming
	@Inject extension GenmodelEntries

	TypeSpecifier ts

	new(TypeSpecifier ts, Naming naming, GenmodelEntries genmodelEntries) {
		this.ts = ts
		this._naming = naming
		this._genmodelEntries = genmodelEntries
	}
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		#include "«(ts.typedRxcModule.h).relativeTo(ts.typedRxcModule.c)»"
		
		define_sc_reactive_extensions(«ts.typeName»)

		'''
	}
}