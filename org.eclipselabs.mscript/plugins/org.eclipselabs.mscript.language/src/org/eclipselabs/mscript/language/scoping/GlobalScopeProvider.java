/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipselabs.mscript.language.ast.Definition;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class GlobalScopeProvider extends ImportUriGlobalScopeProvider {
	
	@Inject
	private ResourceSet resourceSet;
	
	private static volatile List<IEObjectDescription> eObjectDescriptions;

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider#getScope(org.eclipse.xtext.scoping.IScope, org.eclipse.emf.ecore.resource.Resource, boolean, org.eclipse.emf.ecore.EClass, com.google.common.base.Predicate)
	 */
//	@Override
//	protected IScope getScope(IScope parent, Resource context, boolean ignoreCase, EClass type,
//			Predicate<IEObjectDescription> filter) {
//		return new AbstractScope(parent, ignoreCase) {
//			
//			@Override
//			protected Iterable<IEObjectDescription> getAllLocalElements() {
//				return getEObjectDescriptions();
//			}
//			
//		};
//	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider#getScope(org.eclipse.emf.ecore.resource.Resource, boolean, org.eclipse.emf.ecore.EClass, com.google.common.base.Predicate)
	 */
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		return new AbstractScope(IScope.NULLSCOPE, ignoreCase) {
			
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				return getEObjectDescriptions();
			}
			
		};
	}
	
	private List<IEObjectDescription> getEObjectDescriptions() {
		if (eObjectDescriptions != null) {
			return eObjectDescriptions;
		}
		synchronized (GlobalScopeProvider.class) {
			if (eObjectDescriptions == null) {
				eObjectDescriptions = new ArrayList<IEObjectDescription>();
				URI uri = URI.createPlatformPluginURI("/org.eclipselabs.mscript.language/model/MscriptLibrary.xmi", true);
				Resource resource = resourceSet.getResource(uri, true);
				for (EObject eObject : resource.getContents().get(0).eContents()) {
					eObjectDescriptions.add(EObjectDescription.create(((Definition) eObject).getName(), eObject));
				}
				resource.unload();
			}
		}
		return eObjectDescriptions;
	}
	
}
