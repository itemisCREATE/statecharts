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
package org.yakindu.sct.model.sgraph.util;

import static org.yakindu.sct.commons.StreamUtils.select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * Traverses all referenced subcharts in a cycle-free DFS manner.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubchartDFS extends DFS {

	@Override
	public Iterator<Property> getElementLinks(Object element) {
		if (element instanceof Statechart) {
			return getSubcharts((Statechart) element).iterator();
		} else if (element instanceof Property) {
			Property variableDefinition = (Property) element;
			return getSubcharts(getStatechart(variableDefinition)).iterator();
		}
		return new ArrayList<Property>().iterator();
	}

	public static Statechart getStatechart(Property definition) {
		URI statemachineURI = definition.getType().eResource().getURI().trimFileExtension().appendFileExtension("sct");
		if (!URIConverter.INSTANCE.exists(statemachineURI, null)) {
			return null;
		}
		Resource resource = definition.eResource().getResourceSet().getResource(statemachineURI, true);
		return (Statechart) EcoreUtil.getObjectByType(resource.getContents(), SGraphPackage.Literals.STATECHART);

	}

	protected List<Property> getSubcharts(Statechart element) {
		return element.getScopes().stream().flatMap(scope -> scope.getDeclarations().stream())
				.flatMap(select(Property.class))
				.filter(v -> v.getType().eResource() != null)
				.filter(v -> !(v.getType() instanceof EnumerationType))
				.filter(v -> "sct_types".equals(v.getType().eResource().getURI().fileExtension()))
				.collect(Collectors.toList());
	}

}

