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
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.types.Type
import org.yakindu.base.types.PrimitiveType

/**
 * @author Robin Herrmann
 */
class TypedRxCHeader implements IContentTemplate {
	@Inject extension Naming
	@Inject extension GenmodelEntries

	Type payloadType
	Set<IncludeProvider> includeProviders

	new(Type typeAlias, Naming naming, GenmodelEntries genmodelEntries, Set<IncludeProvider> includeProviders) {
		this._naming = naming
		this._genmodelEntries = genmodelEntries
		this.payloadType = typeAlias
		this.includeProviders = includeProviders
	}
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		#ifndef «payloadType.typedRxcModule.define»_H_
		#define «payloadType.typedRxcModule.define»_H_
		
		#include "«(rxcModule.h).relativeTo(payloadType.typedRxcModule.h)»"
		«getTypeAliasInclude(locations)»
		
		#ifdef __cplusplus
		extern "C" {
		#endif

		declare_sc_reactive_extensions(«payloadType.name»)

		#ifdef __cplusplus
		}
		#endif
		
				
		#endif /* «payloadType.typedRxcModule.define»_H_ */
		'''
	}
	
	def getTypeAliasInclude(ExecutionFlow flow, IGenArtifactConfigurations locations) {
		// primitve types like int32_t are handled in sc_types.h, which is already included in sc_rxc.h
		if(payloadType instanceof PrimitiveType) {
			return ''''''
		}
		val package = EcoreUtil2.getContainerOfType(payloadType, org.yakindu.base.types.Package)
		val header =  package.name.split("\\.").last.h
		for (i : includeProviders){
			return i.getIncludes(flow, locations).findFirst[include | include.toString.contains(header)]
		}
		return '''// Can not find include for «payloadType.name»'''
	}

}
	
	
