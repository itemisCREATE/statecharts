/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.yakindu.sct.model.sgen.FeatureParameter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FeatureResourceDescription extends AbstractResourceDescription
		implements IResourceDescription {

	public static final String FEATURE_CONTAINER = "featureContainer";

	private final Resource resource;

	private final URI uri;

	@Inject
	IQualifiedNameProvider qualifiedNameProvider;

	public FeatureResourceDescription(Resource resource) {
		this.resource = resource;
		this.uri = getNormalizedURI(resource);
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		Iterator<EObject> contents = resource.getAllContents();
		List<IEObjectDescription> result = Lists.newArrayList();
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			QualifiedName qualifiedName = qualifiedNameProvider.apply(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = new HashMap<String, String>();
				if (eObject instanceof FeatureParameter) {
					userData.put(FEATURE_CONTAINER, getFqName(eObject));
				}
				result.add(new EObjectDescription(qualifiedName, eObject,
						userData));
			}
		}
		return result;
	}

	private String getFqName(EObject eObject) {
		return qualifiedNameProvider.getFullyQualifiedName(
				((FeatureParameter) eObject).getFeatureType()).toString();
	}

	public URI getURI() {
		return uri;
	}

	public Iterable<QualifiedName> getImportedNames() {
		return Lists.newArrayList();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Lists.newArrayList();
	}

}
