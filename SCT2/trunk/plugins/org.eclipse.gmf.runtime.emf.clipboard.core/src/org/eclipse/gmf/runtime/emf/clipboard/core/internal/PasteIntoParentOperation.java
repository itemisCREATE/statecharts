/******************************************************************************
 * Copyright (c) 2002, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.runtime.emf.clipboard.core.BasePasteOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardSupportUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ObjectInfo;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteTarget;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.l10n.EMFClipboardCoreMessages;
/**
 * A paste operation that pastes copied elements into their new parent.
 * <p>
 * <b>Note</b> that this class is not intended to be extended
 * by clients.  Clients may not instantiate it.
 * </p>
 * 
 * @author Yasser Lulu
 */
public class PasteIntoParentOperation
	extends BasePasteOperation {

	private PasteTarget element;

	private LoadingEMFResource eLoadedResource;

	private Map childPasteProcessMap;

	private List originalChildObjectInfo;

	private XMLResource parentResource;

	private List containmentAnnotationReferences;

	private EAnnotation serializationAnnotation;

	private Map contentObject2ProxyMap;

	private Map hintsMap = Collections.EMPTY_MAP;

	/**
	 * Gets the XML resource containing the parent element into which I am
	 * pasting child objects.
	 * 
	 * @return the parent object's XML resource
	 */
	public final XMLResource getParentResource() {
		if (parentResource == null) {
			if (element.isResource()) {
				parentResource = (XMLResource)element.getObject();
			} else {
				parentResource = getClipboardOperationHelper().getResource(
					getEObject());
			}
		}
		return parentResource;
	}

	/**
	 * Gets the resource loaded from the clipboard string.
	 * 
	 * @return the clipboard loading resource
	 */
	final LoadingEMFResource getLoadedResource() {
		return eLoadedResource;
	}

	/**
	 * Looks up an object deserialized from the clipboard string by ID.
	 * 
	 * @param objId the object ID to retrieve
	 * @return the corresponding object, or <code>null</code> if not found
	 */
	public EObject getLoadedEObject(String objId) {
		return (EObject) getLoadedResource().getIDToEObjectMapCopy().get(objId);
	}

	/**
	 * Looks up the ID of an object deserialized from the clipboard string.
	 * 
	 * @param eObject the object whose ID is to be retrieved
	 * @return the corresponding ID, or <code>null</code> if not found
	 */
	public String getLoadedEObjectID(EObject eObject) {
		return (String) getLoadedResource().getEObjectToIDMapCopy()
			.get(eObject);
	}

	/**
	 * Retrieves the map of hints with which I was initialized.
	 * 
	 * @return my hints
	 */
	public Map getHintsMap() {
		return hintsMap;
	}

	/**
	 * Initializes me.
	 * 
	 * @param pasteProcess the paste operation that will paste child objects
	 *     into my designated parent object
	 * @param element the designated parent object into which I paste children
	 * @param hintsMap the map of hints for the paste operation
	 * 
	 * @throws Exception if anything goes wrong
	 */
	public PasteIntoParentOperation(PasteOperation pasteProcess,
			PasteTarget element, Map hintsMap)
		throws Exception {
		super(pasteProcess);
		this.element = element;
		this.hintsMap = hintsMap;
		childPasteProcessMap = new HashMap();
		
		//IMPORTANT: ALWAYS LOAD/RELOAD a fresh copy for every parent
		eLoadedResource = loadEObjects();
		
		// Bug 112516: Ensure that we will not attempt to insert GUIDs that
		//    already exist
		if (getHintsMap().containsKey(ClipboardUtil.IGNORE_RECYCLE_HINT_ID) == false) {
			Iterator childEObjectInfoIt = getOriginalChildObjectInfo().iterator();

			while (childEObjectInfoIt.hasNext()) {
				ObjectInfo objectInfo = (ObjectInfo) childEObjectInfoIt.next();
				if (objectInfo.hasHint(ClipboardUtil.RECYCLE_HINT_ID)
						&& findDuplicateGUID(getLoadedEObject(objectInfo.objId))) {
					throwException(
						"PasteIntoParentOperation", //$NON-NLS-1$
						new IllegalArgumentException(
							EMFClipboardCoreMessages.copypaste_duplicateId));
				}
			}
		}
		
		getContentObject2ProxyMap();
	}

	private PasteIntoParentOperation(
			PasteIntoParentOperation pasteIntoParentOperation, PasteTarget element) {
		//use itself as spawner in order to know about any newly pasted
		// elements by
		//this newly cloned operation
		super(pasteIntoParentOperation);
		this.element = element;
		this.hintsMap = pasteIntoParentOperation.getHintsMap();
		childPasteProcessMap = pasteIntoParentOperation.childPasteProcessMap;
		eLoadedResource = pasteIntoParentOperation.getLoadedResource();
		originalChildObjectInfo = pasteIntoParentOperation
			.getOriginalChildObjectInfo();
		parentResource = pasteIntoParentOperation.getParentResource();
		containmentAnnotationReferences = pasteIntoParentOperation
			.getContainmentAnnotationReferences();
		serializationAnnotation = pasteIntoParentOperation
			.getSerializationAnnotation();
		contentObject2ProxyMap = pasteIntoParentOperation
			.getContentObject2ProxyMap();
	}

	/**
	 * Determines whether we will be attempting to paste an element into the
	 * destination resource that already contains the pasted element's GUID.
	 * When this occurs, we fail the paste operation.  The check for duplicate
	 * GUIDs is recursive over the content tree of the element to be pasted.
	 *
	 * @param toPaste the element to be pasted
	 *
	 * @return <code>true</code> if we would be pasting an element whose ID
	 *     already exists in the target resource; <code>false</code>, otherwise
	 */
	private boolean findDuplicateGUID(EObject toPaste) {
		XMLResource parentRes = getParentResource();
		EObject original = (EObject) getContentObject2ProxyMap().get(toPaste);
		URI sourceUri = (original == null)
			? null
			: EcoreUtil.getURI(original).trimFragment();  // this is a proxy

		boolean result = false;

		if (!parentRes.getURI().equals(sourceUri)) {
			// don't need to check anything when pasting into the source
			//    resource (from which we cut in the first place).  OK to
			//    get all contents of 'toPaste' because the clipboard resource
			//    has no cross-resource containment
			Iterator iter = EcoreUtil.getAllContents(Collections.singleton(toPaste));
			while (!result && iter.hasNext()) {
				result = parentRes.getEObject(
					getLoadedEObjectID((EObject) iter.next())) != null;
			}
		}

		return result;
	}

	/**
	 * Creates another paste-into-parent operation just like me, that pastes
	 * into the specified new parent element.
	 * 
	 * @param newElement a new parent element
	 * @return the clone
	 */
	public PasteIntoParentOperation clone(EObject newElement) {
		return new PasteIntoParentOperation(this, new PasteTarget(newElement));
	}

	private void performPostPasteOperations(List operations)
		throws Exception {
		if (operations.isEmpty() == false) {
			List postPasteOperations = new ArrayList();
			Iterator it = operations.iterator();
			while (it.hasNext()) {
				getProgressMonitor().worked(WORK_UNIT);
				if (isCancelled()) {
					throwCancelException();
				}
				PasteChildOperation pasteOperation = (PasteChildOperation) it
					.next();
				pasteOperation.paste();
				PasteChildOperation postPasteOperation = pasteOperation
					.getPostPasteOperation();
				if (postPasteOperation != null) {
					postPasteOperations.add(postPasteOperation);
				}
			}
			//perform those newly added post paste operations
			performPostPasteOperations(postPasteOperations);
		}
	}

	private void resolveLocalProxies() {
		Iterator it = getLoadedResource().getContents().iterator();
		while (it.hasNext()) {
			EObject eObj = (EObject) it.next();
			if ((eObj instanceof EAnnotation) == false) {
				resolveLocalProxies(eObj);
				
				// OK to get all contents of 'eObj' because the clipboard resource
				//    has no cross-resource containment
				Iterator contentIt = eObj.eAllContents();
				while (contentIt.hasNext()) {
					resolveLocalProxies((EObject) contentIt.next());
				}
			}
		}
	}

	private void resolveLocalProxies(EObject eObject) {
		Iterator it = eObject.eClass().getEAllReferences().iterator();
		EReference ref = null;
		while (it.hasNext()) {
			ref = (EReference) it.next();
			if ((ref.isContainment() == false) && ref.isChangeable()) {
				Object value = eObject.eIsSet(ref) ? eObject.eGet(ref, true) : null;
				if (value != null) {
					if (FeatureMapUtil.isMany(eObject, ref)) {
						Collection collection = (Collection) value;
						boolean withInverseElist = (collection instanceof EObjectWithInverseEList);
						Iterator valIt = new ArrayList(collection).iterator();
						while (valIt.hasNext()) {
							EObject eObj = (EObject) valIt.next();
							if (eObj.eIsProxy()) {
								EObject resolved = ClipboardSupportUtil.resolve(eObj,
									getLoadedResource().getIDToEObjectMapCopy());
								if (resolved.eIsProxy() == false) {
									//because we are resolving locally, the
									// inverse-resolving list
									//could get in a situation where the first
									// element resolved itself
									//and then added itself to the reverse list,
									// and now we are trying to do the
									//the same for the reversed list and hence we
									// have this problem.
									if (collection.contains(resolved)) {
										collection.remove(eObj);
									} else {
										EcoreUtil.replace(eObject, ref, eObj,
											resolved);
									}
								} else if (withInverseElist) {
									collection.remove(eObj);
								}
							}
						}
					} else {
						EObject eObj = (EObject) value;
						if (eObj.eIsProxy()) {
							EObject resolved = ClipboardSupportUtil.resolve(eObj,
								getLoadedResource().getIDToEObjectMapCopy());
							if (resolved.eIsProxy() == false) {
								EcoreUtil.replace(eObject, ref, eObj, resolved);
							} else if ( ref.getEOpposite() != null){
								//if it can not resolve to loaded paste resource, then
								//it is an external reference. If it is also a bidirectional
								//reference, clear its value. 
								eObject.eUnset(ref);
							}
						}
					}
				}
			}
		}
	}

	public void paste()
		throws Exception {
		try {
			resolveLocalProxies();
			Iterator childEObjectInfoIt = getOriginalChildObjectInfo()
				.iterator();
			List postPasteOperations = new ArrayList();
			//FIRST: handle original copy elements(explicitly chosen by user)
			while (childEObjectInfoIt.hasNext()) {
				getProgressMonitor().worked(WORK_UNIT);
				if (isCancelled()) {
					throwCancelException();
				}
				ObjectInfo objectInfo = (ObjectInfo) childEObjectInfoIt.next();
				PasteChildOperation childPasteProcess = getChildPasteProcess(objectInfo);
				childPasteProcess.paste();
				PasteChildOperation postPasteOperation = childPasteProcess
					.getPostPasteOperation();
				if (postPasteOperation != null) {
					postPasteOperations.add(postPasteOperation);
				}
			} //while original-copy

			//now, do post-paste processing -recursively
			performPostPasteOperations(postPasteOperations);

			if (getPastedElementSet().isEmpty() == false) {
				//one more chance to cancel, NO CANCELLATION past this point
				getProgressMonitor().worked(WORK_UNIT);
				if (isCancelled()) {
					throwCancelException();
				}
				resolveReferences();
				if (getCriticalResolveFailuresSet().isEmpty()) {
					recycleObjectIds();
				}
				fireCreateEvents();
			}
		} finally {
			if (getLoadedResource() != null) {
				getLoadedResource().unload();
			}
		}
	}

	private void fireCreateEvents() {
		List elements = new ArrayList();
		
		// OK to get all contents because the elements were all pasted into
		//    a single resource (no cross-resource containments)
		Iterator it = EcoreUtil.getAllContents(getPastedElementSet());
		while (it.hasNext()) {
			elements.add(it.next());
		}
		elements.removeAll(getPastedElementSet());
		it = elements.iterator();
		while (it.hasNext()) {
			ClipboardSupportUtil.sendCreateEvent((EObject) it.next());
		}
	}

	private List getOriginalChildObjectInfo() {
		if (originalChildObjectInfo == null) {
			originalChildObjectInfo = getResourceInfo().getObjectInfoTypes(
				ObjectCopyType.OBJ_COPY_TYPE_ORIGINAL);
			//sort them as they are in the resouce content list
			Collections.sort(originalChildObjectInfo,
				new ListIndexComparator(getLoadedResource()
					.getContents()) {

					public int compare(Object obj_1, Object obj_2) {
						return super.compare(
							getLoadedEObject(((ObjectInfo) obj_1).objId),
							getLoadedEObject(((ObjectInfo) obj_2).objId));
					}
				});
		}
		return originalChildObjectInfo;
	}

	/**
	 *  
	 */
	private void recycleObjectIds() {
		if (getHintsMap().containsKey(ClipboardUtil.IGNORE_RECYCLE_HINT_ID)) {
			return;
		}
		Iterator childEObjectInfoIt = getOriginalChildObjectInfo().iterator();
		while (childEObjectInfoIt.hasNext()) {
			ObjectInfo objectInfo = (ObjectInfo) childEObjectInfoIt.next();
			if (objectInfo.hasHint(ClipboardUtil.RECYCLE_HINT_ID)) {
				EObject pastedChildElement = getChildPasteProcess(objectInfo)
					.getPastedElement();
				if (getPastedElementSet().contains(pastedChildElement)) {
					recycleObjectId(pastedChildElement);
					
					// OK to get all contents of 'pastedChildElement' because we
					//    paste all elements into the same resource (no
					//    cross-resource containment)
					TreeIterator contentIt = pastedChildElement.eAllContents();
					while (contentIt.hasNext()) {
						recycleObjectId((EObject) contentIt.next());
					}
				}
			}
		}
	}

	private void recycleObjectId(EObject pastedEObject) {
		String newId = getParentResource().getID(pastedEObject);
		if (newId != null) {
			String originalId = (String) getLoadedEObjectToIDMapCopy().get(
				pastedEObject);
			getParentResource().setID(pastedEObject, originalId);
		} else {
			getParentResource().setID(pastedEObject, null);
		}
	}

	protected LoadingEMFResource loadEObjects()
		throws Exception {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
			getResourceInfo().data.getBytes(getResourceInfo().encoding));
		LoadingEMFResource resource = new LoadingEMFResource(
			getParentResource().getResourceSet(),
			getResourceInfo().encoding, getLoadOptionsMap(),
			getClipboardOperationHelper());
		resource.load(inputStream, null);
		return resource;
	}

	private PasteChildOperation getChildPasteProcess(ObjectInfo childEObjectInfo) {
		PasteChildOperation originalChildPasteProcess = (PasteChildOperation) childPasteProcessMap
			.get(childEObjectInfo);
		if (originalChildPasteProcess == null) {
			originalChildPasteProcess = new PasteChildOperation(this,
				childEObjectInfo);
			childPasteProcessMap.put(childEObjectInfo,
				originalChildPasteProcess);
		}
		return originalChildPasteProcess;
	}

	private void resolveReferences() {
		Iterator it = getPastedElementSet().iterator();
		EObject pastedEObject = null;
		while (it.hasNext()) {
			pastedEObject = (EObject) it.next();
			checkReferences(pastedEObject);
			//now, resolveReferences for contained elements recursively
			// OK to get all contents of 'pastedEObject' because we
			//    paste all elements into the same resource (no
			//    cross-resource containment)
			TreeIterator contentIt = pastedEObject.eAllContents();
			while (contentIt.hasNext()) {
				checkReferences((EObject) contentIt.next());
			}
		} //while
	}

	private void checkReferences(EObject pastedEObject) {
		List references = pastedEObject.eClass().getEAllReferences();
		Iterator refIt = references.iterator();
		EReference reference = null;
		while (refIt.hasNext()) {
			reference = (EReference) refIt.next();
			//Here we will handle non-containment refs only because
			// containments (and, inversely, containers)
			//are copied and/or will be resolved too from
			// pasteSelectionFromString(..)
			if (!reference.isContainment() && !reference.isContainer()
				&& reference.isChangeable()) {
				if (FeatureMapUtil.isMany(pastedEObject, reference)) {
					if (!pastedEObject.eIsSet(reference)) {
						continue;
					}
					Collection currentList = (Collection) pastedEObject
						.eGet(reference);
					if (currentList.isEmpty()) {
						continue;//it has been emptied by the paste process,
						// then ignore it
					}
					Object[] currentValues = currentList.toArray();
					resolveProxyReferences(currentValues);
					currentValues = removeNullEntries(currentValues);
					//replace merged elements if any
					checkMergedElements(currentValues);
					List checkedList = Arrays.asList(currentValues);
					if (currentList.equals(checkedList) == false) {
						ClipboardSupportUtil.setEObjectList(
							pastedEObject, reference, checkedList);
					}
				} else {
					Object currentValue = pastedEObject.eGet(reference);
					if (currentValue == null) {
						continue;//it has been nullified by the paste process,
						// then ignore it
					}
					Object[] currentValues = new Object[] {currentValue};
					resolveProxyReferences(currentValues);
					if (currentValues[0] == null) {
						ClipboardSupportUtil.destroyEObject(pastedEObject,
							reference);
					} else {
						//replace merged element if any
						checkMergedElements(currentValues);
						if (currentValues[0] != currentValue) {
							ClipboardSupportUtil.setEObject(
								pastedEObject, reference,
								(EObject) currentValues[0]);
						}
					}
				}
			}
		}
	}

	private Object[] removeNullEntries(Object[] objects) {
		List newList = new ArrayList();
		for (int i = 0; i < objects.length; ++i) {
			if (objects[i] != null) {
				newList.add(objects[i]);
			}
		}
		return newList.toArray();
	}

	private void resolveProxyReferences(Object[] currentValues) {
		EObject val = null;
		EObject resolvedVal = null;
		for (int i = 0; i < currentValues.length; ++i) {
			boolean replaced = false;
			val = (EObject) currentValues[i];
			if (val.eResource() == getLoadedResource()) {
				//must replace
				val = (EObject) getContentObject2ProxyMap().get(val);
				replaced = true;
				if (val == null) {
					currentValues[i] = null;
					continue;
				}
			}
			if (val.eIsProxy()) {
				resolvedVal = ClipboardSupportUtil.resolve(val, getParentResource());
				if (resolvedVal.eIsProxy()) {
					resolvedVal = EcoreUtil.resolve(val, getParentResource());
				}
				if (resolvedVal.eIsProxy() == false) {
					currentValues[i] = resolvedVal;
				} else if (replaced) {
					//been replaced and still not resolved, then we have two
					// options:
					//Option (1): make proxy again:
					((InternalEObject) currentValues[i])
						.eSetProxyURI(((InternalEObject) val).eProxyURI());
					//Or, Option (2): it's not valid anymore, nullify it:
					//					currentValues[i] = null;
				}
			}
		}
	}

	private void checkMergedElements(Object[] resolvedReferencedEObjects) {
		//This function is called after the merge -if any- has happened,
		//which means a record for the mergedObject must exist keyed by its
		// instance
		//even if when we merged that element we found out that it has been
		// merged already
		//a record would have been entered.
		for (int i = 0; i < resolvedReferencedEObjects.length; ++i) {
			//use the target object only if this object is not in the current
			// "pasted-into" resource
			//Please note that an object could have a merge entry AND be pasted
			//as well in the target resource. This could happen if it played a
			// multi
			//role when copying/pasting: it was copy-parent for some original
			// element +
			//copyAlways for another + it also happened to be a child of an
			// original element.
			if (getEObjectID((EObject) resolvedReferencedEObjects[i]) == null) {
				MergedEObjectInfo info = (MergedEObjectInfo) getAllMergedElementsMap()
					.get(resolvedReferencedEObjects[i]);
				if (info != null) {
					if (info.targetEObjects.size() == 1) {
						resolvedReferencedEObjects[i] = info.targetEObjects
							.get(0);
					} else if (info.targetEObjects.size() > 1) {
						boolean found = false;
						//got merged more than once, pick most suitable!
						Iterator it = info.targetEObjects.iterator();
						while (it.hasNext()) {
							EObject mergeTarget = (EObject) it.next();
							if (isChild(mergeTarget)) {
								resolvedReferencedEObjects[i] = mergeTarget;
								found = true;
								break;
							}
						}
						if (found == false) {
							//no suitable one, then pick the first
							resolvedReferencedEObjects[i] = info.targetEObjects
								.get(0);
						}
					}
				}
			}
		}
	}

	/**
	 * Retrieves the element into which I am pasting children.
	 * 
	 * @return the paste target
	 */
	public final EObject getEObject() {
		if (!element.isResource()) {
			return (EObject)element.getObject();
		}
		return null;
	}

	/**
	 * Retrieves the element into which I am pasting children.
	 * 
	 * @return the paste target
	 */
	public final PasteTarget getPasteTarget() {
		return element;
	}

	/**
	 * Retrieves the mapping of copied objects (deserialized from the
	 * clipboard string) to their IDs.
	 * 
	 * @return the mapping of copied {@link EObject}s to string IDs
	 */
	public Map getLoadedEObjectToIDMapCopy() {
		return getLoadedResource().getEObjectToIDMapCopy();
	}

	/**
	 * Retrieves the mapping of IDs to copied objects (deserialized from the
	 * clipboard string).
	 * 
	 * @return the mapping of string IDs to copied {@link EObject}s
	 */
	public Map getLoadedIDToEObjectMapCopy() {
		return getLoadedResource().getIDToEObjectMapCopy();
	}

	/**
	 * Looks up an object in the resource that I am pasting into, by ID.
	 * 
	 * @param objId the object ID to look up in the parent resource
	 * @return the matching object, or <code>null</code> if not found
	 * 
	 * @see #getParentResource()
	 */
	public EObject getEObject(String objId) {
		return getParentResource().getEObject(objId);
	}

	/**
	 * Looks up an object's ID in the resource that I am pasting into.
	 * 
	 * @param eObject the object in the parent resource to find the ID for
	 * @return the matching ID, or <code>null</code> if not found
	 * 
	 * @see #getParentResource()
	 */
	public String getEObjectID(EObject eObject) {
		return getParentResource().getID(eObject);
	}

	/**
	 * Queries whether the specified <code>eObject</code> is contained within
	 * the subtree of the element that I am pasting into.
	 * 
	 * @param eObject an element
	 * @return <code>true</code> if it is in the containment tree of my paste
	 *     target; <code>false</code>, otherwise
	 */
	protected boolean isChild(EObject eObject) {
		return (eObject != null) ? ClipboardSupportUtil.isChild(getEObject(),
			eObject)
			: false;
	}

	/**
	 * Gets the feature that originally contained the specified object
	 * when it was copied to the clipboard.  This is the feature into which we
	 * would like to paste it, if possible, in my paste target element.
	 * 
	 * @param eObject an eObject being pasted
	 * @return its original containment feature, if it is known;
	 *     <code>null</code>, otherwise
	 */
	public EReference getContainmentFeature(EObject eObject) {
		Iterator it = getContainmentAnnotationReferences().iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			Object ref = it.next();
			if (eObject.equals(obj)) {
				return (EReference) ref;
			}
		}
		return null;
	}

	private EAnnotation getSerializationAnnotation() {
		if (serializationAnnotation == null) {
			Iterator it = getLoadedResource().getContents().iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				if (obj instanceof EAnnotation) {
					EAnnotation eAnnotation = ((EAnnotation) obj)
						.getEAnnotation(SerializationEMFResource.SERIALIZATION_ANNOTATIONS);
					if (eAnnotation != null) {
						serializationAnnotation = eAnnotation;
						break;
					}
				}
			}
		}
		return serializationAnnotation;
	}

	private Map getContentObject2ProxyMap() {
		if (contentObject2ProxyMap == null) {
			contentObject2ProxyMap = new HashMap();
			Iterator annotations = getSerializationAnnotation()
				.getEAnnotations().iterator();
			while (annotations.hasNext()) {
				EAnnotation ref_obj_Annotation = (EAnnotation) annotations
					.next();
				EObject proxy = (EObject) ref_obj_Annotation.getReferences()
					.get(0);
				EObject eObj = ClipboardSupportUtil.resolve(proxy,
					getLoadedIDToEObjectMapCopy());
				assert proxy != eObj: "proxy is the same as eObj"; //we must succeed //$NON-NLS-1$
				contentObject2ProxyMap.put(eObj, proxy);
			}
		}
		return contentObject2ProxyMap;
	}

	/**
	 * @return Returns the containmentAnnotations.
	 */
	protected List getContainmentAnnotationReferences() {
		if (containmentAnnotationReferences == null) {
			containmentAnnotationReferences = new ArrayList();
			Iterator annotations = getSerializationAnnotation()
				.getEAnnotations().iterator();
			while (annotations.hasNext()) {
				EAnnotation ref_obj_Annotation = (EAnnotation) annotations
					.next();
				if (ref_obj_Annotation.getReferences().size() >= 2) {
					EObject eObj = ClipboardSupportUtil.resolve(
						(EObject) ref_obj_Annotation.getReferences().get(0),
						getLoadedIDToEObjectMapCopy());
					containmentAnnotationReferences.add(eObj);
					EObject eRef = EcoreUtil.resolve((EObject) ref_obj_Annotation
						.getReferences().get(1), getParentResource());
					containmentAnnotationReferences.add(eRef);
				}
			}
		}
		return containmentAnnotationReferences;
	}
}