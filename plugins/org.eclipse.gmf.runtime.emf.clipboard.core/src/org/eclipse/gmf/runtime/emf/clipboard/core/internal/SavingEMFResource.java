/******************************************************************************
 * Copyright (c) 2002, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.gmf.runtime.emf.clipboard.core.CopyObjects;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;

/**
 * @author Yasser Lulu
 */
public class SavingEMFResource
	extends SerializationEMFResource {

	private Map copy2ObjectMap;

	private EList contentList;

	private Set contentSet;

	private CopyObjects copyObjects;

	private Collection excludedObjects;

	public SavingEMFResource(URI uri, String encoding, Map defaultSaveOptions,
		Map copy2ObjectMap, CopyObjects copyObjects,
		IClipboardSupport clipboardOperationHelper) {
		super(encoding, uri, clipboardOperationHelper);
		this.defaultSaveOptions = defaultSaveOptions;
		this.eObjectToIDMap = new HashMap();
		this.idToEObjectMap = new HashMap();
		this.copy2ObjectMap = copy2ObjectMap;
		this.contentSet = new LinkedHashSet(copyObjects.totalCopyObjects);
		this.copyObjects = copyObjects;
		this.excludedObjects = clipboardOperationHelper
			.getExcludedCopyObjects(copyObjects.totalCopyObjects);
		//we must ensure that every EObject in the contentSet has a resource,
		//becuase the serialization process needs that. Those who don't, will
		// be added to us.
		setMissingResource();
		//set containment refs.
		setContainmentFeatures();
		//needed to allow calls to unload() to proceed
		setLoaded(true);
		if (copyObjects.sortTotalCopyObjects) {
			sortContentSetOnOriginalStorageOrder();
		}
	}

	private void sortContentSetOnOriginalStorageOrder() {
		Map parentObjectMap = new HashMap();
		List roots = new ArrayList();
		Iterator it = contentSet.iterator();
		while (it.hasNext()) {
			EObject eObj = (EObject) it.next();
			EObject eParent = eObj.eContainer();
			if (eParent == null) {
				roots.add(eObj);
			} else {
				List children = (List) parentObjectMap.get(eParent);
				if (children == null) {
					children = new ArrayList();
					parentObjectMap.put(eParent, children);
				}
				children.add(eObj);
			}
		}//while

		List list = new ArrayList(roots);
		Iterator entryIt = parentObjectMap.entrySet().iterator();
		while (entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry) entryIt.next();
			
			// get the basic list view of the contents list to avoid resolving
			//    cross-resource containment proxies
			Collections.sort((List) entry.getValue(), new ListIndexComparator(
				((InternalEList) ((EObject) entry.getKey()).eContents()).basicList()));
			list.addAll((List) entry.getValue());
		}
		contentSet = new LinkedHashSet(list);
	}

	private void setContainmentFeatures() {
		EAnnotation containmentAnnotations = EcoreFactory.eINSTANCE
			.createEAnnotation();
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(SERIALIZATION_ANNOTATIONS);
		containmentAnnotations.getEAnnotations().add(eAnnotation);
		Set set = new HashSet(contentSet);
		set.addAll(copyObjects.originalObjects);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			EObject eObj = (EObject) it.next();
			addToSerializationAnnotation(eAnnotation, eObj);
			
			// OK to resolve containment proxies because we must load the
			//    entire model sub-tree in order to copy it
			TreeIterator contentIt = eObj.eAllContents();
			while (contentIt.hasNext()) {
				EObject childEObj = (EObject) contentIt.next();
				if (getClipboardOperationHelper().shouldSaveContainmentFeature(
					childEObj) == false) {
					contentIt.prune();
					continue;
				}
				addToSerializationAnnotation(eAnnotation, childEObj);
			}
		}
		super.getContents().add(containmentAnnotations);
		contentSet.add(containmentAnnotations);
	}

	private void addToSerializationAnnotation(EAnnotation eAnnotation,
		EObject eObj) {
		EObject eObjectWithValidContainer = (eObj.eContainer() == null) ? getOriginalEObject(eObj)
			: eObj;
		EAnnotation ref_obj_Annotation = EcoreFactory.eINSTANCE
			.createEAnnotation();
		ref_obj_Annotation.getReferences().add(eObj);
		if (eObjectWithValidContainer != null) {
			ref_obj_Annotation.getReferences().add(
				eObjectWithValidContainer.eContainmentFeature());
		} else {
			// If there is no containment feature, which is the case when copying a
			// root element, then an unattached EReference is added to the annotation.
			// This EReference ensures that that the annotation references
			// are serialized using CROSS_DOC.
			// A better fix would be to add some intelligence to the sameDocMany(..) method
			// of the XMISameImpl class created in method createXMLSave().
			ref_obj_Annotation.getReferences().add(EcoreFactory.eINSTANCE.createEReference());
		}
		eAnnotation.getEAnnotations().add(ref_obj_Annotation);
	}

	private void setMissingResource() {
		Iterator it = contentSet.iterator();
		EObject eObject = null;
		while (it.hasNext()) {
			eObject = (EObject) it.next();
			if (eObject.eResource() == null) {
				//no resource (detached view-element), therefore add the
				// top-most
				//parent to the us so that a newer call to getResource will
				// succeed.
				// don't add the element itself, since adding the element to a
				//resource will set its container to null,and we want to
				// preserve
				//the container of the original detached element. This means
				// that
				//if the element itself has no container (top-most
				// copyAlwaysCopy),
				//then we'll add it regardless since its parent is already
				// null.
				//therefore add the container of the detached original element
				// so
				//that the container's container will be set to null
				while (eObject.eContainer() != null) {
					eObject = eObject.eContainer();
				}
				super.getContents().add(eObject);
			}
		}

		//let's make sure that things went OK, for if they didn't, the
		//paste process or even the serialization process will fail
		it = contentSet.iterator();
		while (it.hasNext()) {
			eObject = (EObject) it.next();
			if (eObject.eResource() == null) {

				RuntimeException e = new IllegalArgumentException();

				ClipboardPlugin.throwing(getClass(),
					"setMissingResource", e); //$NON-NLS-1$

				throw e;
			}
		}
	}

	public void doLoad(InputStream inputStream, Map options) throws IOException {
		throwUnsupportedOperationException("doLoad", //$NON-NLS-1$
			new UnsupportedOperationException(
				"Can't call load on serializing resource"));//$NON-NLS-1$
	}

	protected XMLSave createXMLSave() {
		return new XMISaveImpl(createXMLHelper()) {

			protected void saveElement(InternalEObject o, EStructuralFeature f) {
				// do not save cross-resource-contained objects as hrefs, because
				//    the clipboard resource must actually duplicate all of the
				//    original data
				saveElement((EObject) o, f);
			}

			protected void saveElement(EObject o, EStructuralFeature f) {
				if (excludedObjects.contains(o)) {
					return;
				}
				super.saveElement(o, f);
			}

			/**
			 * @see org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl#sameDocMany(org.eclipse.emf.ecore.EObject,
			 *      org.eclipse.emf.ecore.EStructuralFeature)
			 */
			protected int sameDocMany(EObject o, EStructuralFeature f) {
				InternalEList values = (InternalEList) helper.getValue(o, f);
				if (values.isEmpty()) {
					return SKIP;
				}

				for (Iterator i = values.basicIterator(); i.hasNext();) {
					InternalEObject value = (InternalEObject) i.next();
					if (value.eIsProxy()
						|| (isInSavingResource(value) == false)) {
						return CROSS_DOC;
					}
				}

				return SAME_DOC;
			}

			/**
			 * @see org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl#sameDocSingle(org.eclipse.emf.ecore.EObject,
			 *      org.eclipse.emf.ecore.EStructuralFeature)
			 */
			protected int sameDocSingle(EObject o, EStructuralFeature f) {
				InternalEObject value = (InternalEObject) helper.getValue(o, f);
				if (value == null) {
					return SKIP;
				} else if (value.eIsProxy()) {
					return CROSS_DOC;
				} else {
					return (isInSavingResource(value)) ? SAME_DOC : CROSS_DOC;
				}
			}

		};
	}

	boolean isInSavingResource(EObject eObject) {
		if (eObject.eResource() == this) {
			return true;
		} else if ((copyObjects.originalObjects.contains(eObject))
			|| (copyObjects.copyParent2CopyMap.values().contains(eObject))
			|| (copyObjects.combinedCopyAlwaysSet.contains(eObject))) {
			return true;
		}
		EObject eContainer = eObject.eContainer();
		while (eContainer != null) {
			if ((copyObjects.originalObjects.contains(eContainer))
				|| (copyObjects.copyParent2CopyMap.values().contains(eContainer))
				|| (copyObjects.combinedCopyAlwaysSet.contains(eContainer))) {
				return true;
			}
			eContainer = eContainer.eContainer();
		}
		return false;
	}

	EObject getOriginalEObject(EObject copiedEObject) {
		return (EObject) copy2ObjectMap.get(copiedEObject);
	}

	private String getOriginalID(EObject eObject) {
		Resource res = eObject.eResource();
		
		if (res != this) {
			if (res instanceof XMLResource) {
				return ((XMLResource) res).getID(eObject);
			} else if (res instanceof ResourceImpl) {
				Map<String, EObject> map = ((ResourceImpl)res).getIntrinsicIDToEObjectMap();
				if (map != null) {
					for (Map.Entry<String, EObject> mapEntry : map.entrySet()) {
						if (eObject.equals(mapEntry.getValue())) {
							return mapEntry.getKey();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.XMLResource#getID(org.eclipse.emf.ecore.EObject)
	 */
	public String getID(EObject eObject) {

		//is this an original object?
		String id = getOriginalID(eObject);
		if (id == null) {
			//no, then, is it a copied object?
			EObject original = (EObject) copy2ObjectMap.get(eObject);
			if (original != null) {
				id = getOriginalID(original);
			} else {
				Resource res = eObject.eResource();
				
				if (res != null) {
					//we'll use our own assigned ids, (detached view-elements bug)
					assert eObject.eResource() == this: "eObject.eResource not same as self"; //$NON-NLS-1$
					id = super.getID(eObject);
				}
			}
		}
		return id;
	}

	/**
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#getContents()
	 */

	private static class ContentBasicEList
		extends EcoreEList.UnmodifiableEList
		implements InternalEList {

		private static final long serialVersionUID = -2551747854798104709L;

		ContentBasicEList(Set contentSet) {
			super(null, null, contentSet.size(), contentSet.toArray());
		}
	}

	public EList getContents() {
		if (contentList == null) {
			contentList = new ContentBasicEList(contentSet);
		}
		return contentList;
	}

	/**
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doUnload()
	 */
	protected void doUnload() {
		//unset resource for those whom we've actually added to ourselves -in the setMissingResource() above
		//be carefull that the super.getContents() list is a ContentsEList and therefore calling clear on it
		//it will end up calling eInverseRemove on the EObjects it holds and they in turn would end up
		//calling the getResource().getContents() to remove themselves, but as we know that our own getContents()
		// list is unmodifiable and this will throw an exception, therefore replace our own getContents() list
		//with our parent's super.getContents() list before we clear it
		contentList = super.getContents(); 
		super.getContents().clear();

	}
}