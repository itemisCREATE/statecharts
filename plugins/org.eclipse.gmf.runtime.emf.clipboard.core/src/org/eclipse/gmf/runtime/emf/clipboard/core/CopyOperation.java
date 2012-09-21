/******************************************************************************
 * Copyright (c) 2002, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import org.eclipse.gmf.runtime.emf.clipboard.core.internal.ResourceInfoProcessor;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.SavingEMFResource;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.SerializationEMFResource;

/**
 * The default copy operation.  Extensibility is provided by the callback
 * methods of the {@link IClipboardSupport} implementation for the specific
 * EMF metamodel.
 * <p>
 * <b>Note</b> that this class is not intended to be extended "directly"
 * by clients.  Clients may not instantiate it.  Clients that need to extend
 * or override this default copy operation should extend the
 * {@link OverrideCopyOperation} class, instead.
 * </p>
 * 
 * @see OverrideCopyOperation
 * 
 * @author Yasser Lulu
 */
public class CopyOperation
	extends ClipboardOperation {

	private static final int KILOBYTE = 1024;

	private static final int BUFFER_SIZE = 128 * KILOBYTE;

	/** String constant for the value "copy". */
	public static final String COPY = "copy"; //$NON-NLS-1$

	private static final URI COPY_URI = URI.createFileURI(""); //$NON-NLS-1$

	private Map hintMap;

	private Collection eObjects;

	private CopyParentsCopier copyParentsCopierCopier;

	private OverrideCopyOperation overrideCopyOperation;

	/**
	 * Initializes me.
	 * 
	 * @param monitor the optional progress monitor (can be <code>null</code>)
	 * @param clipboardSupport the clipboard support for the EMF metamodel
	 * @param eObjects the {@link EObject}s to copy
	 * @param hintMap the map of copy hints, possibly empty.  Hints are defined
	 *     by the {@link org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil} class
	 * 
	 * @see org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil#RECYCLE_HINT_ID
	 * @see org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil#IGNORE_RECYCLE_HINT_ID
	 */
	public CopyOperation(IProgressMonitor monitor,
		IClipboardSupport clipboardSupport, Collection eObjects,
		Map hintMap) {
		super(monitor, clipboardSupport);
		this.eObjects = eObjects;
		this.hintMap = hintMap;
	}

	/**
	 * Obtains my hint map.
	 * 
	 * @return my hint map
	 */
	protected Map getEObjectsHintMap() {
		return hintMap;
	}

	/**
	 * Performs the copy operation.
	 * 
	 * @return the serialized form of the copied objects, suitable for placing
	 *     on the system clipboard for later pasting
	 * @throws Exception if anything goes wrong in performing the copy
	 */
	public String copy() throws Exception {
		if (getClipboardOperationHelper().shouldOverrideCopyOperation(
			getEObjects(), getEObjectsHintMap())) {
			overrideCopyOperation = getClipboardOperationHelper()
				.getOverrideCopyOperation(this);
			//by returning a null op, it means disallow coying, thus return
			// empty string
			return (overrideCopyOperation != null) ? overrideCopyOperation
				.copy() : ""; //$NON-NLS-1$
		}
        return doCopy();

	}

    protected String doCopy() throws Exception{
        CopyObjects copyObjects = getAuxiliaryObjects();
        if (isCancelled()) {
            throwCancelException();
        }
        
        return saveEObjects(copyObjects, COPY_URI, "UTF-8", //$NON-NLS-1$
            SerializationEMFResource.SAVE_OPTIONS, getEObjectsHintMap());
    }

    
	private String saveEObjects(CopyObjects copyObjects, URI uri,
		String encoding, Map saveOptions, Map hints) throws Exception {
		SavingEMFResource res = null;
		try {
			try {
				res = new SavingEMFResource(uri, encoding, saveOptions,
					getCopyParentsCopier().getCopy2ObjectMap(), copyObjects,
					getClipboardOperationHelper());
			} catch (Exception ex) {
				//if the ctor of the saving resource threw an exception, then				
				//something is wrong with elements we have, usually a problem with a
				// detached view-element that renderes it un-copy-able.
				throwUncopyableException();
			}
			ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
			res.save(out, null);
			String dataStr = out.toString(encoding);
			String infoStr = ResourceInfoProcessor.getResourceInfo(dataStr
				.length(), encoding, res, hints, copyObjects);
			return dataStr + infoStr;
		} finally {
			if (res != null) {
				res.unload();
			}
		}
	}

	private void extractCopyAlwaysObjects(Collection mainObjects,
		Set combinedCopyAlwaysSet, Map copyAlwaysMap) {
		Iterator mainEObjectIt = mainObjects.iterator();
		EObject originalEObject = null;
		Set copyAlwaysSet = new HashSet();
		while (mainEObjectIt.hasNext()) {
			originalEObject = (EObject) mainEObjectIt.next();
			getCopyAlwaysObjects(originalEObject, copyAlwaysSet,
				combinedCopyAlwaysSet);
			//now get copy-always for the originalObject's children,
			//   recursively.  Use eAllContents() instead of
			//   EcoreUtil.getAllProperContents() because we really need all
			//   of the model sub-tree
			Iterator childrenIt = originalEObject.eAllContents();
			EObject directChild = null;
			while (childrenIt.hasNext()) {
				directChild = (EObject) childrenIt.next();
				getCopyAlwaysObjects(directChild, copyAlwaysSet,
					combinedCopyAlwaysSet);
			}
			if (copyAlwaysSet.isEmpty() == false) {
				copyAlwaysMap.put(originalEObject, copyAlwaysSet);
				copyAlwaysSet = new HashSet();
			}
		}

		//just to be safe, remove non-copyables
		removeNonCopyableObject(combinedCopyAlwaysSet);

		//		we are doing this because copyAlways objects are copied with all
		// their
		//content recursively (i.e., treated as original objects
		removeEmbeddedChildren(new ArrayList(combinedCopyAlwaysSet),
			combinedCopyAlwaysSet);
	}

	private void extractCopyAlwaysObjects(CopyObjects copyObjects) {
		extractCopyAlwaysObjects(copyObjects.originalObjects,
			copyObjects.combinedCopyAlwaysSet, copyObjects.copyAlwaysMap);

		//Now, remove copy always objects that are copied anyways
		copyObjects.combinedCopyAlwaysSet
			.removeAll(copyObjects.originalObjects);
		removeEmbeddedChildren(copyObjects.originalObjects,
			copyObjects.combinedCopyAlwaysSet);

		if (copyObjects.combinedCopyAlwaysSet.isEmpty()) {
			return;
		}

		Set nonCheckedCopyAlwaysSet = new HashSet(
			copyObjects.combinedCopyAlwaysSet);
		do {
			Set startingCopyAlwaysSet = new HashSet(
				copyObjects.combinedCopyAlwaysSet);
			extractCopyAlwaysObjects(nonCheckedCopyAlwaysSet,
				copyObjects.combinedCopyAlwaysSet, copyObjects.copyAlwaysMap);
			Set newCopyAlwaysSet = new HashSet(
				copyObjects.combinedCopyAlwaysSet);
			newCopyAlwaysSet.removeAll(startingCopyAlwaysSet);
			nonCheckedCopyAlwaysSet = newCopyAlwaysSet;
		} while (nonCheckedCopyAlwaysSet.isEmpty() == false);
	}

	private Map removeEmbeddedChildren(Collection parents, Collection childs) {
		Map removedEmbeddedChild2Parent = new HashMap();
		Iterator parentsIt = parents.iterator();
		EObject parent = null;
		EObject child = null;
		while (parentsIt.hasNext()) {
			parent = (EObject) parentsIt.next();
			Iterator childIt = childs.iterator();
			while (childIt.hasNext()) {
				child = (EObject) childIt.next();
				if (ClipboardSupportUtil.isChild(parent, child)) {
					childIt.remove();
					removedEmbeddedChild2Parent.put(child, parent);
				}
			}
		}
		return removedEmbeddedChild2Parent;
	}

	private void extractCopyParentsObjects(CopyObjects copyObjects) {
		List list = new ArrayList();
		list.addAll(copyObjects.originalObjects);
		list.addAll(copyObjects.combinedCopyAlwaysSet);

		Iterator it = list.iterator();
		EObject eObject = null;
		EObject copyParent = null;
		while (it.hasNext()) {
			eObject = (EObject) it.next();
			copyParent = getTopMostCopyParentObject(eObject);
			if (copyParent != null) {
				Set objectSet = (Set) copyObjects.copyParent2ObjectsMap
					.get(copyParent);
				if (objectSet == null) {
					objectSet = new HashSet();
					copyObjects.copyParent2ObjectsMap
						.put(copyParent, objectSet);
				}
				objectSet.add(eObject);
				//build initial objectsToCopyParentMap
				copyObjects.objectsToCopyParentMap.put(eObject, copyParent);
			}
		}

		if (copyObjects.copyParent2ObjectsMap.isEmpty()) {
			return;
		}

		Set copyParentSet = copyObjects.copyParent2ObjectsMap.keySet();
		removeEmbeddedChildren(copyObjects.originalObjects, copyParentSet);
		Set copyParentSetCopy = new HashSet(copyParentSet);
		//collapse the copyParent2ObjectsMap by removing embedded copy-parents
		Map removedEmbeddedChild2Parent = removeEmbeddedChildren(
			copyParentSetCopy, copyParentSet);

		//build the ancestry path from each object to its top-most copyParent
		Set embeddedCopyParents = new HashSet();
		buildEmbeddedCopyParentChain(copyObjects.objectsToCopyParentMap
			.keySet(), embeddedCopyParents, copyParentSet);

		//add those who we won't indirectly copy by copier
		list.addAll(copyParentSet);

		Iterator copyParentsIt = copyParentSet.iterator();
		copyParent = null;
		EObject parentCopy = null;
		while (copyParentsIt.hasNext()) {
			copyParent = (EObject) copyParentsIt.next();
			parentCopy = getCopyParentsCopier().copyParent(copyParent,
				embeddedCopyParents, list);
			copyObjects.copyParent2CopyMap.put(copyParent, parentCopy);
		}
		//now copy refs
		getCopyParentsCopier().copyReferences();

		//re-build objectsToCopyParentMap
		list.removeAll(copyParentSet);
		it = list.iterator();
		while (it.hasNext()) {
			eObject = (EObject) it.next();
			copyParent = (EObject) copyObjects.objectsToCopyParentMap
				.get(eObject);
			EObject replacementCopyParent = (EObject) removedEmbeddedChild2Parent
				.get(copyParent);
			if (replacementCopyParent != null) {
				copyObjects.objectsToCopyParentMap.put(eObject,
					replacementCopyParent);
			}
		}
	}

	private void buildEmbeddedCopyParentChain(Set objectsWithCopyParent,
		Set embeddedCopyParents, Set copyParentSet) {
		Iterator it = objectsWithCopyParent.iterator();
		EObject eObject = null;
		while (it.hasNext()) {
			eObject = (EObject) it.next();
			while (copyParentSet.contains(eObject.eContainer()) == false) {
				embeddedCopyParents.add(eObject.eContainer());
				eObject = eObject.eContainer();
			}
		}
	}

	/**
	 * Obtains my complete set of objects that must always be copied, that are
	 * related to the original selection but not of it.
	 * 
	 * @return my combined set of "copy always" objects; may be empty
	 */
	public Set getCombinedCopyAlwaysSet() {
		return getAuxiliaryObjects().combinedCopyAlwaysSet;
	}
	
	protected CopyObjects getAuxiliaryObjects() {
		CopyObjects copyObjects = new CopyObjects(getEObjects());
		extractCopyAlwaysObjects(copyObjects);
		extractCopyParentsObjects(copyObjects);
		if (isCancelled()) {
			throwCancelException();
		}

		//we are doing this because copyAlways objects are copied with all
		// their
		//content recursively (i.e., treated as original objects), so if a
		//copyAlways happen to be a parent of an original object, then there is
		//no need to copy the original.We will use a copy of the original
		// object
		//list to remove the embedded children from so that the list of
		// originals
		//is available for us later on.
		List originalObjectsCopy = new ArrayList(copyObjects.originalObjects);
		removeEmbeddedChildren(copyObjects.combinedCopyAlwaysSet,
			originalObjectsCopy);

		//now combine them all
		copyObjects.totalCopyObjects.addAll(originalObjectsCopy);
		copyObjects.totalCopyObjects.addAll(copyObjects.copyParent2CopyMap
			.values());
		copyObjects.totalCopyObjects.addAll(copyObjects.combinedCopyAlwaysSet);
		return copyObjects;
	}

	private void removeNonCopyableObject(Collection collection) {
		// model roots are not copyable
		Iterator it = collection.iterator();
		EObject eObject = null;
		while (it.hasNext()) {
			eObject = (EObject) it.next();
			if (eObject.eContainer() == null) {
				it.remove();
			}
		}
	}

	private EObject getTopMostCopyParentObject(EObject eChild) {
		if ((eChild == null) || (eChild.eContainmentFeature() == null)
			|| (eChild.eContainer() == null)) {
			return null;
		}
		EObject copyParent = null;
		if (getClipboardOperationHelper().hasPasteOption(eChild,
			eChild.eContainmentFeature(), PasteOption.PARENT)) {
			copyParent = getTopMostCopyParentObject(eChild.eContainer());
			if (copyParent == null) {
				if ((eChild.eContainer() != null)
					&& (eChild.eContainer().eContainer() != null)) {
					copyParent = eChild.eContainer();
				}
			}
		}
		return copyParent;
	}

	private void getCopyAlwaysObjects(EObject eObject, Set copyAlwaysObjects,
		Set combinedCopyAlwaysSet) {
		Iterator refIt = eObject.eClass().getEAllReferences().iterator();
		EReference ref = null;
		while (refIt.hasNext()) {
			ref = (EReference) refIt.next();
			if ((ref.isContainment() == false) && (eObject.eIsSet(ref))) {
				Object value = eObject.eGet(ref, true);
				if (getClipboardOperationHelper().isCopyAlways(eObject, ref,
					value)) {
					if (FeatureMapUtil.isMany(eObject,ref)) {
						List vals = (List) value;
						if (vals.isEmpty() == false) {
							Iterator valIt = vals.iterator();
							while (valIt.hasNext()) {
								EObject val = (EObject) valIt.next();
								if (combinedCopyAlwaysSet.contains(val) == false) {
									copyAlwaysObjects.add(val);
									combinedCopyAlwaysSet.add(val);
								}
							}
						}
					} else if (value != null) {
						if (combinedCopyAlwaysSet.contains(value) == false) {
							copyAlwaysObjects.add(value);
							combinedCopyAlwaysSet.add(value);
						}
					}
				}
			}
		}
	}

	private void throwCancelException() {
		throwCancelException(COPY);
	}

	private void throwUncopyableException() {
		throwException(COPY,
			new IllegalArgumentException("Uncopyable Object")); //$NON-NLS-1$
	}

	/**
	 * @since 1.3
	 */
	protected CopyParentsCopier getCopyParentsCopier() {
		if (copyParentsCopierCopier == null) {
			copyParentsCopierCopier = new CopyParentsCopier();
		}
		return copyParentsCopierCopier;

	}

	/**
	 * @since 1.3
	 */
	protected class CopyParentsCopier
		extends EcoreUtil.Copier {

		private static final long serialVersionUID = 6178429496879264655L;

		private Map copyToObjectMap = new HashMap();

		private Collection doNotCopyEObjects;

		private Collection embeddedCopyParents;

		EObject copyParent(EObject eParent,
			Collection embeddedCopyParentsCollection,
			Collection doNotCopyEObjectsCollection) {
			this.embeddedCopyParents = embeddedCopyParentsCollection;
			this.doNotCopyEObjects = doNotCopyEObjectsCollection;
			EObject copiedParent = copy(eParent);
			this.doNotCopyEObjects = null;
			embeddedCopyParents = null;
			return copiedParent;
		}

		public EObject copy(EObject eObject) {
			EObject copiedObject = (EObject) get(eObject);
			if (copiedObject != null) {
				return copiedObject;
			}
			copiedObject = super.copy(eObject);
			copyToObjectMap.put(copiedObject, eObject);
			return copiedObject;
		}

		Map getObject2CopyMap() {
			return this;
		}

		public Map getCopy2ObjectMap() {
			return copyToObjectMap;
		}

		private Collection copyAll(EObject eOwnerObject, EReference eReference) {
			if (!eOwnerObject.eIsSet(eReference))
				return Collections.EMPTY_LIST;

			List list = (List) eOwnerObject.eGet(eReference);
			Collection result = new ArrayList(list.size());
			int lowerBound = eReference.getLowerBound();
			List noneCopied = new ArrayList(list.size());
			Iterator it = list.iterator();
			while (it.hasNext()) {
				EObject eObject = (EObject) it.next();
				if ((doNotCopyEObjects != null)
					&& (doNotCopyEObjects.contains(eObject))) {
					continue;
				}
				if ((embeddedCopyParents != null)
					&& (embeddedCopyParents.contains(eObject))) {
					result.add(copy(eObject));
					if ((lowerBound != 0) && (result.size() == lowerBound)) {
						return result;
					}
					continue;
				}
				noneCopied.add(eObject);
			}

			it = noneCopied.iterator();
			while (it.hasNext()) {
				EObject eObject = (EObject) it.next();
				result.add(copy(eObject));
				if ((lowerBound != 0) && (result.size() == lowerBound)) {
					return result;
				}
			}
			return result;
		}

		protected void copyAttribute(EAttribute eAttribute, EObject eObject,
			EObject copiedEObject) {
			//we don't test EAttributes for isCritical...
			super.copyAttribute(eAttribute, eObject, copiedEObject);
		}

		protected void copyContainment(EReference eReference, EObject eObject,
			EObject copiedEObject) {
			if (eObject.eIsSet(eReference)) {
				//do not copy the child that originated the copyParent request
				// (copy-parent-request <-> non-null-child)
				if (doNotCopyEObjects != null) {
					//many-refs will be handled in copyAll function
					if (!FeatureMapUtil.isMany(eObject,eReference)) {
						if (doNotCopyEObjects
							.contains(eObject.eGet(eReference))) {
							return;
						}
					}
				}
				if (isCritical(eObject, eReference)) {
					if (FeatureMapUtil.isMany(eObject,eReference)) {
						((Collection) copiedEObject.eGet(eReference))
							.addAll(copyAll(eObject, eReference));
					} else {
						EObject childEObject = (EObject) eObject
							.eGet(eReference);
						copiedEObject.eSet(eReference,
							childEObject == null ? null : copy(childEObject));
					}
				}
			}
		}

		protected void copyReference(EReference eReference, EObject eObject,
			EObject copiedEObject) {
			if (isCritical(eObject, eReference)) {
				super.copyReference(eReference, eObject, copiedEObject);
			}
		}

		private boolean isCritical(EObject eObject, EReference eReference) {
			int lowerBound = eReference.getLowerBound();
			int upperBound = eReference.getUpperBound();
			if (upperBound == 0) {
				return false;
			}
			if (FeatureMapUtil.isMany(eObject, eReference) && !eObject.eIsSet(eReference))
				return false;
			Object value = eObject.eGet(eReference);
			if (value == null) {
				return false;
			}
			if (eReference.isMany()) {
				List list = (List) value;
				if (list.isEmpty()) {
					return false;
				}
				if (embeddedCopyParents != null) {
					if (ClipboardSupportUtil.containsAny(list, embeddedCopyParents)) {
						return true;
					}
				}
				if (lowerBound == upperBound) {
					return true;
				}
				if (lowerBound > 0) {
					return true;
				}
				if (eReference.isChangeable() == false) {
					return true;
				}
			} else if ((eReference.isUnsettable() == false)
				|| ((embeddedCopyParents != null) && (embeddedCopyParents
					.contains(value)))) {
				return true;
			}
			return getClipboardOperationHelper().hasPasteOption(eObject,
				eReference, PasteOption.CRITICAL);
		}
	} //CopyParentsCopier

	/**
	 * @return Returns the eObjectList.
	 */
	protected Collection getEObjects() {
		return eObjects;
	}
}