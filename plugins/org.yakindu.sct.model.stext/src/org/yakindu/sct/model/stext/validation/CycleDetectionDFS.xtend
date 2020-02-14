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
package org.yakindu.sct.model.stext.validation

import java.util.ArrayList
import java.util.Iterator
import java.util.List
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.util.DFS
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport
import org.yakindu.sct.model.stext.stext.ImportScope

/**
 * @autho robin herrmann - Initial contribution and API
 */
class CycleDetectionDFS extends DFS {
	
	val IPackageImport2URIMapper mapper
	
	new(IPackageImport2URIMapper mapper) {
		this.mapper = mapper
	}

	override Iterator<Statechart> getElementLinks(Object element) {
		if (element instanceof Statechart) {
			return element.getSubcharts
		}
	}

	def Iterator<Statechart> getSubcharts(Statechart it) {
		val ArrayList<Statechart> subcharts = newArrayList
		val packageImports = getPackageImports(it)
		for (packageImport : packageImports) {
			val subchart = eResource.resourceSet.getResource(packageImport.fileURI, true).contents.filter(Statechart).
				head
			subcharts.add(subchart)
		}
		return subcharts.iterator
	}
	
	protected def List<PackageImport> getPackageImports(Statechart it) {
		scopes.filter(ImportScope).map[imports].flatten.toSet.filter[it.endsWith(".sct")].map [ import |
			mapper.findPackageImport(eResource, import)
		].filter[isPresent].map[get].toList
	}
	
}
