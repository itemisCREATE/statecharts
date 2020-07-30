/** 
 * Copyright (c) 2019committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.generator.c.extensions.Naming

class StatechartIncludeProvider implements IncludeProvider {
	@Inject IPackageImport2URIMapper includeMapper;
	@Inject extension SgraphExtensions
	@Inject extension Naming

	override getIncludes(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		val List<CharSequence> sctImports = newArrayList
		val set = sourceElement.eResource.resourceSet
		packageImports.filter[name.endsWith(".sct")].forEach[ import | 
			val resource = set.getResource(import.fileURI, true)
			val submachine = resource.contents.filter(Statechart).head
			if(submachine instanceof Statechart) {
				sctImports += submachine.submachineInclude
			}
		]
		return sctImports
	}
	
	protected def submachineInclude(Statechart submachine) {
		if (submachine.hasOperations)
			'''#include "«submachine.module.client.h»"'''
		else
			'''#include "«submachine.module.h»"'''
	}

	protected def getPackageImports(ExecutionFlow flow) {
		val statechart = flow.sourceElement as Statechart
		val statechartImports = statechart.scopes.filter(ImportScope).map[imports].flatten
		return statechartImports.map [
			includeMapper.findPackageImport(statechart.eResource, it)
		].filter[isPresent].map[get]

	}

}
