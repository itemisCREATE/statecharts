/******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;


/**
 * A convenient default implementation of most of the features required of
 * a clipboard support utility.
 * <p>
 * This class is intended to be extended by clients.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public class AbstractClipboardSupport
	implements IClipboardSupport {

	private static final Object NULL_TOKEN = Boolean.FALSE;
	private final Map nameFeatureMap = new java.util.HashMap();
	
	/**
	 * Initializes me.
	 */
	public AbstractClipboardSupport() {
		super();
	}

	/**
	 * By default, there are no collisions in pasting.
	 * 
	 * @return the {@link PasteAction#ADD} action, always
	 */
	public PasteAction getPasteCollisionAction(EClass eClass) {
		return PasteAction.ADD;
	}

	/**
	 * By default, the following paste options are supported:
	 * <ul>
	 * <li>{@link PasteOption#NORMAL}: always</li>
	 * <li>others: never</li>
	 * </ul>
	 */
	public boolean hasPasteOption(EObject contextEObject,
			EStructuralFeature eStructuralFeature, PasteOption pasteOption) {
		if (pasteOption.equals(PasteOption.NORMAL)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * By default, transient and derived references are never copied, and
	 * containment references always are copied.
	 */
	public boolean isCopyAlways(EObject context, EReference eReference,
			Object value) {
		if ((eReference.isTransient()) || (eReference.isDerived())) {
			return false;
		} else {
			return eReference.isContainment();
		}
	}

	/**
	 * By default, don't provide any child paste override behaviour.
	 * 
	 * @return <code>false</code>, always
	 */
	public boolean shouldOverrideChildPasteOperation(EObject parentElement,
			EObject childEObject) {
		return false;
	}

	/**
	 * By default, don't provide any copy override behaviour.
	 * 
	 * @return <code>false</code>, always
	 */
	public boolean shouldOverrideCopyOperation(Collection eObjects, Map hintMap) {
		return false;
	}

	/**
	 * By default, don't provide any child paste override behaviour.
	 * 
	 * @return <code>null</code>, always
	 */
	public OverridePasteChildOperation getOverrideChildPasteOperation(
			PasteChildOperation overriddenChildPasteOperation) {
		return null;
	}

	/**
	 * By default, don't provide any copy override behaviour.
	 * 
	 * @return <code>null</code>, always
	 */
	public OverrideCopyOperation getOverrideCopyOperation(
			CopyOperation overriddenCopyOperation) {
		return null;
	}

	/**
	 * By default, don't exclude any objects from the copy operation.
	 * 
	 * @return an empty collection
	 */
	public Collection getExcludedCopyObjects(Set eObjects) {
		return Collections.EMPTY_SET;
	}

	/**
	 * By default, assumes that the <code>eObject</code> is attached to
	 * an XML resource, and returns that.
	 */
	public XMLResource getResource(EObject eObject) {
		return (XMLResource) eObject.eResource();
	}

	/**
	 * By default, we always remember the containment feature of an object,
	 * unless it is an Ecore element (such as an annotation) or it is a
	 * detached element.
	 * 
	 * @return <code>false</code> if the <code>eObject</code> is an Ecore
	 *     object or is detached; <code>true</code>, otherwise
	 */
	public boolean shouldSaveContainmentFeature(EObject eObject) {
		if (EcorePackage.eINSTANCE == eObject.eClass().getEPackage()) {
			return false;
		}
		
		try {
			eObject.eResource().getURIFragment(eObject);
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	/**
	 * By default, there is no post processing to be done.
	 */
	public void performPostPasteProcessing(Set pastedEObjects) {
		// nothing to do
	}

	/**
	 * Obtains the cached name attribute of an eClass, or <code>null</code>
	 * if it has no attribute named "name".
	 * 
	 * @param eClass an EClass
	 * @return the cached "name" attribute
	 */
	protected EAttribute getNameAttribute(EClass eClass) {
		EAttribute result = null;
		
		Object value = nameFeatureMap.get(eClass);
		if (value != NULL_TOKEN) {
			result = (EAttribute) value;
			
			if (result == null) {
				nameFeatureMap.put(eClass, NULL_TOKEN);
				
				// look for an attribute named "name"
				for (Iterator iter = eClass.getEAllAttributes().iterator(); iter.hasNext();) {
					EAttribute next = (EAttribute) iter.next();
					
					if ((next.getEType().getInstanceClass() == String.class)
							&& next.getUpperBound() == 1
							&& "name".equalsIgnoreCase(next.getName())) { //$NON-NLS-1$
						
						result = next;
						nameFeatureMap.put(eClass, result);
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * By default, elements are nameable if they have an {@link EAttribute}
	 * named "name".
	 */
	public boolean isNameable(EObject eObject) {
		return getNameAttribute(eObject.eClass()) != null;
	}

	public String getName(EObject eObject) {
		EAttribute attr = getNameAttribute(eObject.eClass());
		
		if (attr == null) {
			throw new IllegalArgumentException("eObject not nameable"); //$NON-NLS-1$
		}
		
		return (String) eObject.eGet(attr);
	}

	public void setName(EObject eObject, String name) {
		EAttribute attr = getNameAttribute(eObject.eClass());
		
		if (attr == null) {
			throw new IllegalArgumentException("eObject not nameable"); //$NON-NLS-1$
		}
		
		eObject.eSet(attr, name);
	}

	/**
	 * Simply removes an <code>eObject</code> from its container.
	 */
	public void destroy(EObject eObject) {
		EcoreUtil.remove(eObject);
		
		if (eObject.eResource() != null) {
			// it was a cross-resource-contained element
			eObject.eResource().getContents().remove(eObject);
		}
	}

	/**
	 * Default implementation does nothing, for those applications that do not
	 * support creation notifications.
	 */
	public void sendCreateNotification(EObject eObject) {
		// do nothing
	}

	/**
	 * @return <code>true</code> if the <code>reference</code>'s type is
	 *      compatible with the <code>containedType</code>; <code>false</code>,
	 *      otherwise
	 */
	public boolean canContain(EObject container, EReference reference,
			EClass containedType) {
		return reference.getEContainingClass().isSuperTypeOf(container.eClass())
			&& reference.getEReferenceType().isSuperTypeOf(containedType);
	}

}
