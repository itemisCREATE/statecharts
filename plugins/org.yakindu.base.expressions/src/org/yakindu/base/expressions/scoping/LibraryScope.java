/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.expressions.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LibraryScope extends AbstractScope {

	private List<URI> uris;
	private List<IEObjectDescription> result;
	private ResourceSet set;

	public LibraryScope(IScope parent, URI... uris) {
		super(parent, false);
		this.uris = new ArrayList<URI>();
		for (URI uri : uris) {
			if (URIConverter.INSTANCE.exists(uri, null)) {
				this.uris.add(uri);
			}
		}
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		if (result == null) {
			result = Lists.newArrayList();
			set = new ResourceSetImpl();
			for (URI uri : uris) {
				Resource resource = set.getResource(uri, true);
				Iterable<IEObjectDescription> iterable = Scopes
						.scopedElementsFor(Lists.newArrayList(resource.getAllContents()));
				Iterables.addAll(result, iterable);
			}
		}
		return result;
	}
}