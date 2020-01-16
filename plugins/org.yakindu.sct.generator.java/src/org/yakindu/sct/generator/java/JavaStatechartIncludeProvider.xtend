/** 
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java

import com.google.common.collect.Sets
import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorModel
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport
import org.yakindu.sct.model.stext.stext.ImportScope

class JavaStatechartIncludeProvider extends JavaIncludeProvider {

	@Inject
	protected IPackageImport2URIMapper includeMapper;

	@Inject
	protected extension StatechartUtil
	
	@Inject
	protected extension Naming

	@Inject
	protected extension GenmodelEntries

	override Iterable<String> getImports(ExecutionFlow it, GeneratorModel genModel) {
		val imports = Sets.newHashSet
		for (PackageImport p : statechartImports) {
			val typesRes = (sourceElement as Statechart).eResource.resourceSet.getResource(p.uri, true);
			val submachineChart = typesRes.subchart
			val submachineClass = submachineChart.statemachineClassName
			val subEntry = genModel.getEntry(submachineChart)
			val submachineImport = submachineChart.getImplementationPackageName(subEntry) + "." + submachineClass
			imports.add(submachineImport)
		}
		return imports
	}
	
	protected def getSubchart(Resource typesRes) {
		typesRes.contents.filter(Package).head.member.filter(ComplexType).filter[!(it instanceof EnumerationType)].map[getOriginStatechart].filterNull.head
	}

	protected def getStatechartImports(ExecutionFlow flow) {
		val statechart = flow.sourceElement as Statechart
		val statechartImports = statechart.scopes.filter(ImportScope).map[imports].flatten
		return statechartImports.map [
			includeMapper.findPackageImport(statechart.eResource, it)
		].filter[isPresent].map[get].filter[fileURI.fileExtension.equals("sct")]
	}

	protected def getEntry(GeneratorModel genModel, Statechart statechart) {
		genModel.entries.filter[elementRef instanceof Statechart].findFirst [
			(elementRef as Statechart).name == statechart.name
		]
	}
}
