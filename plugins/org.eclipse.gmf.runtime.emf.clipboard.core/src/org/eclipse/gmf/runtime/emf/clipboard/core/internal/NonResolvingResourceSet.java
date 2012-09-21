/******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Yasser Lulu
 */
class NonResolvingResourceSet extends ResourceSetImpl {
    private ResourceSet resourceSet;

    NonResolvingResourceSet(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
    }

    /**
     * @return list of adapter factories
     */
    public EList getAdapterFactories() {
        return resourceSet.getAdapterFactories();
    }

    /**
     * @param uri
     * @param loadOnDemand
     * @return object from URI
     */
    public EObject getEObject(URI uri, boolean loadOnDemand) {
        return null;//return null, don't resolve
    }

    /**
     * @return package registry
     */
    public Registry getPackageRegistry() {
        return resourceSet.getPackageRegistry();
    }

    /**
     * @param uri
     * @param loadOnDemand
     * @return resource from URI
     */
    public Resource getResource(URI uri, boolean loadOnDemand) {
        return resourceSet.getResource(uri, loadOnDemand);
    }

    /**
     * @return resource factory registry
     */
    public org.eclipse.emf.ecore.resource.Resource.Factory.Registry getResourceFactoryRegistry() {
        return resourceSet.getResourceFactoryRegistry();
    }

    /**
     * @return URI converter
     */
    public URIConverter getURIConverter() {
        return resourceSet.getURIConverter();
    }

}