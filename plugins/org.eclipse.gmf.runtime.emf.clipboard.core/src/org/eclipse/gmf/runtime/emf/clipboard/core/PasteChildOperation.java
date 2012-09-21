/******************************************************************************
 * Copyright (c) 2002, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.MergedEObjectInfo;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.ObjectCopyType;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.PasteIntoParentOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.ResourceInfoProcessor;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.l10n.EMFClipboardCoreMessages;


/**
 * An operation to paste a child object into a new target parent object.
 * 
 * @author Yasser Lulu
 */
public class PasteChildOperation
	extends BasePasteOperation {

	/**
	 * Localized prefix to prepend onto element names to disambiguate them
	 * in resolving paste collisions.
	 */
	protected static final String COPY = EMFClipboardCoreMessages.pasteChildOperation_copyPrefix;

	/**
	 * A reusable empty array of paste child operations.
	 */
	protected static final PasteChildOperation[] EMPTY_ARRAY = new PasteChildOperation[0];

	private Map auxiliaryChildPasteProcessMap;

	private PasteChildOperation mainChildPasteProcess;

	private PasteChildOperation postPasteOperation;

	private List alwaysCopyObjectPasteOperations;

	private ObjectInfo childObjectInfo;

	private EObject childEObject;

	private EObject pastedElement;

	private EObject copyParentEObject;

	private ObjectInfo copyParentObjectInfo;

	private EObject directContainerEObject;

	private OverridePasteChildOperation overrideChildPasteOperation;

	private EReference containmentFeature;

	private Map embeddedCopyParentObjectInfoMap = new HashMap();

	/**
	 * Initializes me.
	 * 
	 * @param parentPasteProcess my superordinate operation, that created me
	 *      in order to paste one of its copied objects into its target parent
	 *      object
	 * @param childEObjectInfo the metadata for the child object to be pasted
	 */
	public PasteChildOperation(PasteIntoParentOperation parentPasteProcess,
		ObjectInfo childEObjectInfo) {
		super(parentPasteProcess);
		this.childObjectInfo = childEObjectInfo;
		auxiliaryChildPasteProcessMap = new HashMap();
	}

	/**
	 * Gets the containment feature into which I would prefer to paste my child
	 * element into the parent.
	 * 
	 * @return the preferred containment feature to paste into
	 */
	protected EReference getContainmentFeature() {
		if (containmentFeature == null) {
			containmentFeature = getParentPasteProcess().getContainmentFeature(
				getEObject());
		}
		return containmentFeature;
	}

	/**
	 * Initializes me as an auxiliary to another child paste operation.
	 * 
	 * @param mainChildPasteProcess the main child paste operation
	 * @param childEObjectInfo the metadata for the child object to be pasted
	 */
	private PasteChildOperation(PasteChildOperation mainChildPasteProcess,
		ObjectInfo childEObjectInfo) {
		this(mainChildPasteProcess.getParentPasteProcess(), childEObjectInfo);
		this.mainChildPasteProcess = mainChildPasteProcess;
	}

	/**
	 * Initializes me as an override- or post-paste operation.
	 * 
	 * @param mainChildPasteProcess the paste-child process that I am overriding
	 *     or extending
	 */
	protected PasteChildOperation(PasteChildOperation mainChildPasteProcess) {
		this(mainChildPasteProcess.getParentPasteProcess(),
			mainChildPasteProcess.childObjectInfo);
	}

	/**
	 * Obtains the direct container object, from the deserialized copied elements,
	 * of the object that I am pasting.
	 * 
	 * @return my object's direct container
	 */
	protected EObject getLoadedDirectContainerEObject() {
		if (directContainerEObject == null) {
			directContainerEObject = getLoadedEObject(getChildObjectInfo().containerId);
		}
		return directContainerEObject;
	}

	/**
	 * Obtains the paste operation that created me to paste a child into the
	 * target parent element.
	 * 
	 * @return my parent operation
	 */
	public PasteIntoParentOperation getParentPasteProcess() {
		return (PasteIntoParentOperation) getSpawningPasteOperation();
	}

	/**
	 * Obtains the paste operation that pastes the auxiliary object indicated
	 * by the specified object info.
	 * 
	 * @param auxiliaryChildEObjectInfo the auxiliary object's info
	 * @return the paste operation that pastes the auxiliary object
	 */
	protected PasteChildOperation getAuxiliaryChildPasteProcess(
		ObjectInfo auxiliaryChildEObjectInfo) {
		PasteChildOperation auxiliaryChildPasteProcess = (PasteChildOperation) auxiliaryChildPasteProcessMap
			.get(auxiliaryChildEObjectInfo);
		if (auxiliaryChildPasteProcess == null) {
			auxiliaryChildPasteProcess = makeAuxiliaryChildPasteProcess(auxiliaryChildEObjectInfo);
			if (auxiliaryChildPasteProcess != null) {
				auxiliaryChildPasteProcessMap.put(auxiliaryChildEObjectInfo,
					auxiliaryChildPasteProcess);
			}
		}
		return auxiliaryChildPasteProcess;
	}

	/**
	 * Constructs a paste operation to paste the auxiliary object indicated by
	 * its object info.
	 * 
	 * @param auxiliaryChildEObjectInfo the auxiliary object's info
	 * @return the appropriate paste child operation
	 */
	protected PasteChildOperation makeAuxiliaryChildPasteProcess(
		ObjectInfo auxiliaryChildEObjectInfo) {
		return new PasteChildOperation(this, auxiliaryChildEObjectInfo);
	}

	/**
	 * Retrieves the object that I am pasting from the deserialized clipboard
	 * string into the target parent object.
	 * 
	 * @return the object that I am pasting
	 */
	public EObject getEObject() {
		if (childEObject == null) {
			childEObject = getLoadedEObject(getChildObjectInfo().objId);
		}
		return childEObject;
	}

	/**
	 * After pasting is completed, obtains the element that I pasted.
	 * 
	 * @return the pasted element, or <code>null</code> if I did not succeed
	 *     in pasting
	 */
	public EObject getPastedElement() {
		return pastedElement;
	}

	/**
	 * Looks up an object deserialized from the clipboard string by its ID.
	 *  
	 * @param objId the object ID to look up
	 * @return the corresponding object, or <code>null</code> if not found
	 */
	protected EObject getLoadedEObject(String objId) {
		return getParentPasteProcess().getLoadedEObject(objId);
	}

	/**
	 * Looks up the ID of an object deserialized from the clipboard string.
	 *  
	 * @param eObject the object whose ID we want to look up
	 * @return the corresponding ID, or <code>null</code> if not found
	 */
	protected String getLoadedEObjectID(EObject eObject) {
		return getParentPasteProcess().getLoadedEObjectID(eObject);
	}

	/**
	 * Queries whether the object that I am pasting had its parent object
	 * copied along with it, as an alternative element to try to paste when I
	 * can't be directly pasted into the target element.
	 * 
	 * @return whether my copy object was copied with its parent
	 */
	protected boolean hasCopyParent() {
		return (ResourceInfoProcessor.NONE
			.equals(getChildObjectInfo().copyParentId) == false);
	}

	/**
	 * Queries whether the object that I am pasting was copied because it
	 * is always copied along with an element that was originally selected for
	 * copying.
	 * 
	 * @return whether my copy object is copied because of a "copy always" rule
	 */
	protected boolean isCopyAlways() {
		return (getChildObjectInfo().objCopyType
			.equals(ObjectCopyType.OBJ_COPY_TYPE_ALWAYS));
	}

	/**
	 * Gets the original parent of the object that I am pasting, if it was
	 * copied along with the child.
	 * 
	 * @return the copy parent, or <code>null</code> if it was not copied
	 * 
	 * @see #hasCopyParent()
	 */
	protected EObject getCopyParentEObject() {
		if (copyParentEObject == null) {
			copyParentEObject = getLoadedEObject(getChildObjectInfo().copyParentId);
		}
		return copyParentEObject;
	}

	/**
	 * Looks up an object in the resource to which we are pasting, by its ID.
	 *  
	 * @param objId the object ID to look up
	 * @return the corresponding object, or <code>null</code> if not found
	 */
	protected EObject getEObject(String objId) {
		return getParentPasteProcess().getEObject(objId);
	}

	/**
	 * Looks up the ID of an object in the resource to which we are pasting.
	 *  
	 * @param eObject the object to look up its ID
	 * @return the corresponding ID, or <code>null</code> if not found
	 */
	protected String getEObjectID(EObject eObject) {
		return getParentPasteProcess().getEObjectID(eObject);
	}

	/**
	 * Finds some parent in the containment chain (ancestry) of the parent
	 * element into which I am pasting that my child element can be pasted into.
	 * 
	 * @param preferredTypeName the fully-qualified class name of the preferred
	 *     element type to paste into
	 * @return the suitable parent, if found, otherwise <code>null</code>
	 */
	protected PasteTarget getSuitableParentUsingAncestry(String preferredTypeName) {
		PasteTarget suitableParent = getSuitableParentUsingAncestry(
			getParentTarget(), preferredTypeName, true);
		if (suitableParent == null) {
			suitableParent = getSuitableParentUsingAncestry(getParentTarget(),
				preferredTypeName, false);
		}
		return suitableParent;
	}

	private PasteTarget getSuitableParentUsingAncestry(
			PasteTarget potentialParent, String preferredTypeName,
		boolean strictMatch) {
		PasteTarget suitableParent = checkPotentialParent(potentialParent,
			preferredTypeName, strictMatch);
		if (suitableParent == null && !potentialParent.isResource()) {
			EObject potentialParentObject = (EObject)potentialParent.getObject();
			while ((suitableParent == null)
				&& (potentialParentObject.eContainer() != null)) {
				potentialParentObject = potentialParentObject.eContainer();
				suitableParent = checkPotentialParent(new PasteTarget(potentialParentObject),
					preferredTypeName, strictMatch);
			}
		}
		return suitableParent;
	}

	/**
	 * After pasting has completed, obtains the pasted object corresponding
	 * to the specified originally copied object.
	 * 
	 * @param eObject the originally copied object
	 * @return the corresponding pasted object, or <code>null</code> if the
	 *      <code>eObject</code> was not successfully pasted
	 */
	protected EObject getPastedEObject(EObject eObject) {
		String id = getEObjectID(eObject);
		if (id != null) {
			//it has been pasted as is
			return eObject;
		} else {
			//maybe it has been merged?
			MergedEObjectInfo info = (MergedEObjectInfo) getAllMergedElementsMap()
				.get(eObject);
			if (info != null) {
				if (info.targetEObjects.size() == 1) {
					return (EObject) info.targetEObjects.get(0);
				} else if (info.targetEObjects.size() > 1) {
					//got merged more than once, pick most suitable!
					Iterator it = info.targetEObjects.iterator();
					while (it.hasNext()) {
						EObject mergeTarget = (EObject) it.next();
						if ((getParentTarget().isResource() &&
								getParentTarget().getObject() == mergeTarget.eResource()) ||
								ClipboardSupportUtil.isChild(getParentEObject(), mergeTarget)) {
							return mergeTarget;
						}
					}
					//no suitable one, then pick the first
					return (EObject) info.targetEObjects.get(0);
				}
			}
		}
		return null;
	}

	/**
	 * After pasting has completed, obtains the pasted object corresponding
	 * to the specified originally copied object's parent.
	 * 
	 * @return the corresponding pasted object, or <code>null</code> if the
	 *      copy parent was not successfully pasted
	 */
	protected EObject getPastedDirectCopyParent() {
		return getPastedEObject(getLoadedDirectContainerEObject());
	}

	private EObject doPasteIntoNearestCopyParent(
		EObject topMostCopyParentEObject) throws Exception {
		EObject nearestParent = getLoadedEObject(getChildObjectInfo().containerId);
		while (nearestParent.equals(topMostCopyParentEObject) == false) {
			EObject parentElement = doPasteIntoCopyParent(makeEmbeddedCopyParentObjectInfo(nearestParent));
			if (parentElement != null) {
				return parentElement;
			}
			nearestParent = nearestParent.eContainer();
		}

		return null;
	}

	private EObject doPasteIntoCopyParent(ObjectInfo theCopyParentObjectInfo)
		throws Exception {
		PasteChildOperation copyParentProcess = getAuxiliaryChildPasteProcess(theCopyParentObjectInfo);
		copyParentProcess.paste();
		EObject pastedCopyParent = copyParentProcess.getPastedElement();
		if (pastedCopyParent != null) {
			//the direct copy parent should have been pasted correctly by now
			return doPasteInto(getPastedDirectCopyParent());
		}
		return null;
	}

	private ObjectInfo makeEmbeddedCopyParentObjectInfo(
		EObject embeddedCopyParent) {
		ObjectInfo objectInfo = (ObjectInfo) embeddedCopyParentObjectInfoMap
			.get(embeddedCopyParent);
		if (objectInfo == null) {
			objectInfo = new ObjectInfo();
			objectInfo.objCopyType = ObjectCopyType.OBJ_COPY_TYPE_PARENT;
			objectInfo.objId = getLoadedEObjectID(embeddedCopyParent);
			objectInfo.containerId = getLoadedEObjectID(embeddedCopyParent
				.eContainer());
			objectInfo.containerClass = embeddedCopyParent.eContainer()
				.eClass().getInstanceClassName();
			if (objectInfo.objId.equals(getChildObjectInfo().copyParentId) == false) {
				objectInfo.copyParentId = getChildObjectInfo().copyParentId;
			} else {
				objectInfo.copyParentId = ResourceInfoProcessor.NONE;
			}
			objectInfo.hints = ResourceInfoProcessor.NONE;
			//cache it
			embeddedCopyParentObjectInfoMap.put(embeddedCopyParent, objectInfo);
		}

		return objectInfo;
	}

	private EObject doPasteIntoCopyParent() throws Exception {

		//check if copyParentEObject exists in the target model already
		//try matching direct copy parent ID.
		EObject existingCopyParentEObject = getEObject(getChildObjectInfo().containerId);
		if (existingCopyParentEObject != null) {
			return doPasteInto(existingCopyParentEObject);
		}

		//check if the copy-parent has been
		//pasted already by a sibling paste operation that executed before us?
		EObject pastedDirectCopyParent = getPastedDirectCopyParent();
		if (pastedDirectCopyParent != null) {
			//the direct copy parent should have been pasted correctly already
			return doPasteInto(pastedDirectCopyParent);
		}

		EObject nearestParent = null;
		if (isCopyParentDirectParent() == false) {
			nearestParent = getLoadedEObject(getChildObjectInfo().containerId);
			EObject perent = nearestParent.eContainer();
			EObject root = getCopyParentEObject();
			while ((perent != null) && (perent.equals(root) == false)) {
				existingCopyParentEObject = getPastedEObject(perent);
				if (existingCopyParentEObject != null) {
					break;
				}
				nearestParent = perent;
				perent = nearestParent.eContainer();
			}
			if (existingCopyParentEObject == null) {
				//check the root itself
				existingCopyParentEObject = getPastedEObject(root);
			}
		}

		if (existingCopyParentEObject != null) {
			//the nearestParent copy parent should have been pasted correctly
			// already
			//paste the nearest-parent itself first, the paste the child into
			// it afterwards
			return doPasteIntoCopyParent(makeEmbeddedCopyParentObjectInfo(nearestParent));
		} else {
			//no parent with same ID, and the copy-parent not pasted already,
			//then try other ways to match a parent
			PasteTarget possibleParent = getSuitableParentUsingAncestry(getLoadedDirectContainerEObject()
				.eClass().getInstanceClassName());
			if (possibleParent != null) {
				return doPasteInto(possibleParent);
			} else {
				//no suitable exisiting parent then the copy-parent itself
				//needs to be pasted first
				EObject element = doPasteIntoNearestCopyParent(getCopyParentEObject());
				if (element != null) {
					//found a nearest copy parent and pasted it successfully
					return element;
				}
				//now final try: use the root copy Parent?
				return doPasteIntoCopyParent(getCopyParentObjectInfo());
			}
		}
	}

	/**
	 * Gets the target object into which we are pasting a child.
	 * 
	 * @return the parent (target) object of the paste operation
	 */
	public EObject getParentEObject() {
		return getParentPasteProcess().getEObject();
	}

	/**
	 * Gets the target object into which we are pasting a child.
	 * 
	 * @return the parent (target) object of the paste operation
	 */
	public PasteTarget getParentTarget() {
		return getParentPasteProcess().getPasteTarget();
	}

	/**
	 * Obtains the XML resource into which we are pasting.
	 * 
	 * @return the target resource
	 */
	public XMLResource getParentResource() {
		return getParentPasteProcess().getParentResource();
	}

	/**
	 * Gets an operation to be invoked after I have completed my pasting, to do
	 * some follow-up pasting.  {@link OverridePasteChildOperation}s can
	 * redefine this method to provide custom post-paste behaviour.
	 * <p>
	 * <b>IMPORTANT:</b> This function must be invoked AFTER the paste()
	 * function has been called.
	 * </p>
	 * 
	 * @return an additional operation to do more pasting
	 */
	public PasteChildOperation getPostPasteOperation() {
		return (overrideChildPasteOperation != null) ? overrideChildPasteOperation
			.getPostPasteOperation()
			: doGetPostPasteOperation();
	}

	private PasteChildOperation doGetPostPasteOperation() {
		if ((postPasteOperation == null) && (getPastedElement() != null)
			&& (getAlwaysCopyObjectPasteOperations().isEmpty() == false)) {
			postPasteOperation = new PostPasteChildOperation(this,
				getAlwaysCopyObjectPasteOperations());
		}
		return postPasteOperation;
	}

	public void paste() throws Exception {
		//check if this object has been pasted/merged already for some reason:
		//e.g, copied once because it is a copy-parent, and now we are asked
		//to copy it because it is a copyAlways
		if (getPastedEObject(getEObject()) != null) {
			setPastedElement(getEObject());
			addPastedElement(getPastedElement());
			//set post paste to a NULL operation
			postPasteOperation = PostPasteChildOperation
				.makeNullPostPasteChildOperation(this);
			return;
		}
		//handle diagrams
		if (getClipboardOperationHelper().shouldOverrideChildPasteOperation(
			getParentEObject(), getEObject())) {
			overrideChildPasteOperation = getClipboardOperationHelper()
				.getOverrideChildPasteOperation(this);
			//if the parent was not suitable for pasting a diagram, this
			// happens
			if (overrideChildPasteOperation != null) {
				overrideChildPasteOperation.paste();
				setPastedElement(overrideChildPasteOperation.getPastedElement());
			} else {
				addPasteFailuresObject(getEObject());
			}
			return;
		}

		if (hasCopyParent()) {
			setPastedElement(doPasteIntoCopyParent());
		} else {
			EObject element = null;
			//either it is not a copyAlways, or it is a copyAlways
			// whose
			//original parent didn't resolve, thus, proceed normally
			//by trying to paste in target obj
			element = doPasteInto(getParentTarget());
			
			if (element == null) {
				/*-------------
				 //failed to copy in target parent...then check if it is a copy-always and its
				 // original parent resolves in target model
				 if (isCopyAlways()) {
				 EObject resolvedCopyAlwaysParent = getEObject(getChildObjectInfo().containerId);
				 if (resolvedCopyAlwaysParent != null) {
				 //found original parent for this copyAlways object,
				 // then use it,
				 //instead of user selected parent
				 element = doPasteInto(resolvedCopyAlwaysParent);
				 }
				 }
				 -------------*/
				if ((element == null)
					&& ((getChildObjectInfo()
						.hasHint(ClipboardUtil.PASTE_TO_TARGET_PARENT)) || (isCopyAlways()))) {
					PasteTarget possibleParent = getSuitableParentUsingAncestry(getChildObjectInfo().containerClass);
					if (possibleParent != null) {
						element = doPasteInto(possibleParent);
					}
				}
			}
			setPastedElement(element);
		}

		//did we succeed?
		if (getPastedElement() != null) {
			addPastedElement(getPastedElement());
		} else {
			addPasteFailuresObject(getEObject());
		}
	}

	/**
	 * Pastes my child object into the specified object.
	 * 
	 * @param pasteIntoEObject the object to paste into
	 * @return the newly pasted object, or <code>null</code> if the paste did
	 *     not succeed
	 */
	protected EObject doPasteInto(EObject pasteIntoEObject) {
		if (pasteIntoEObject != null) {
			EReference reference = getPasteContainmentFeature(pasteIntoEObject);
			if (reference != null) {
				return doPasteInto(pasteIntoEObject, reference);
			}
		}
		return null;
	}

	/**
	 * Pastes my child object into the specified object.
	 * 
	 * @param pasteTarget the object to paste into
	 * @return the newly pasted object, or <code>null</code> if the paste did
	 *     not succeed
	 */
	protected EObject doPasteInto(PasteTarget pasteTarget) {
		if (pasteTarget != null) {
			if (pasteTarget.isResource()) {
				return doPasteInto((Resource)pasteTarget.getObject());
			} else {
				return doPasteInto((EObject)pasteTarget.getObject());
			}
		}
		return null;
	}

	/**
	 * Pastes my child object into the specified containment reference of an
	 * object.
	 * 
	 * @param pasteIntoEObject the object to paste into
	 * @param reference the containment reference to paste into
	 * @return the newly pasted object, or <code>null</code> if the paste did
	 *     not succeed
	 */
	protected EObject doPasteInto(EObject pasteIntoEObject, EReference reference) {
		EObject childElement = null;
		Object value = pasteIntoEObject.eGet(reference, true);
		if (FeatureMapUtil.isMany(pasteIntoEObject,reference)) {
			if (handleCollision(reference, (List) value, getEObject(),
				getChildObjectInfo())) {
				childElement = ClipboardSupportUtil.appendEObjectAt(
					pasteIntoEObject, reference, getEObject());
			} else if (getPastedElement() != null) {
				// our pasted element was already assigned by a merge action
				childElement = getPastedElement();
			}
		} else {  // reference is single
			if (handleCollision(reference, (EObject) value, getEObject(),
				getChildObjectInfo())) {
				childElement = ClipboardSupportUtil.setEObject(
					pasteIntoEObject, reference, getEObject());
			} else if (getPastedElement() != null) {
				// our pasted element was already assigned by a merge action
				childElement = getPastedElement();
			}
		}
		return childElement;
	}

	/**
	 * Pastes my child object into the specified resource
	 * 
	 * @param pasteIntoResource the resource to paste into
	 * @return the newly pasted object, or <code>null</code> if the paste did
	 *     not succeed
	 */
	protected EObject doPasteInto(Resource pasteIntoResource) {
		EObject childElement = null;
		if (handleCollision(null, pasteIntoResource.getContents(),
				getEObject(), getChildObjectInfo())) {
			childElement = ClipboardSupportUtil.appendEObject(
				pasteIntoResource, getEObject());
		} else if (getPastedElement() != null) {
			// our pasted element was already assigned by a merge action
			childElement = getPastedElement();
		}

		return childElement;
	}

	/**
	 * Obtains a list of operations to paste the "copy always" objects related
	 * to the object that I am pasting.  By default, these will be executed
	 * as a post-paste operation following me.
	 * 
	 * @return the copy-always object paste operations (which may be empty)
	 * 
	 * @see #getPostPasteOperation()
	 */
	protected List getAlwaysCopyObjectPasteOperations() {
		if (alwaysCopyObjectPasteOperations == null) {
			alwaysCopyObjectPasteOperations = new ArrayList();
			Iterator alwaysCopyEObjectInfoIt = getChildObjectInfo()
				.getCopyAlwaysObjectInfoList().iterator();
			while (alwaysCopyEObjectInfoIt.hasNext()) {
				getProgressMonitor().worked(WORK_UNIT);
				if (isCancelled()) {
					throwCancelException();
				}
				ObjectInfo alwaysCopyObjectInfo = (ObjectInfo) alwaysCopyEObjectInfoIt
					.next();
				if (shouldPasteAlwaysCopyObject(alwaysCopyObjectInfo)) {
					PasteChildOperation pasteOperation = getAuxiliaryChildPasteProcess(alwaysCopyObjectInfo);
					if (pasteOperation != null) {
						alwaysCopyObjectPasteOperations.add(pasteOperation);
					}
				}
			} //while always-copy
		}
		return alwaysCopyObjectPasteOperations;
	}

	/**
	 * Queries whether we should paste the specified "copy always" object
	 * associated with the element we are pasting.  This accounts for the
	 * possibility that the "copy always" object might collide with some element
	 * already in the target resource.
	 * 
	 * @param alwaysCopyObjectInfo info indicating the "copy always" object
	 * @return <code>true</code> if the "copy always" object should be pasted;
	 *      <code>false</code>, otherwise
	 */
	protected boolean shouldPasteAlwaysCopyObject(
		ObjectInfo alwaysCopyObjectInfo) {
		//for a copy always object that exists in the model already, check if
		// this
		//kind of object is "critical", then we need to paste it, note that we
		// are using
		//the exisiting object to query for PasteOption since what matter is
		// the type
		//and not the particular instance itself
		EObject existingObject = getEObject(alwaysCopyObjectInfo.objId);
		EObject loadedEObject = getLoadedEObject(alwaysCopyObjectInfo.objId);
		return ((existingObject == null) || (getClipboardOperationHelper()
			.getPasteCollisionAction(loadedEObject.eClass()) == PasteAction.ADD));

	}

	private PasteTarget checkPotentialParent(PasteTarget potentialParent,
		String preferredTypeName, boolean strictMatch) {
		//match parent on type, if not then try ability to contain the child
		if ((potentialParent.getObject() instanceof EAnnotation) == false) {
			if (potentialParent.isResource()) {
				if (preferredTypeName == null || strictMatch == false) {
					return potentialParent;
				}
			} else {
				EObject potentialParentObject = (EObject)potentialParent.getObject();
				if (potentialParentObject.eClass().getInstanceClassName().equals(
					preferredTypeName)) {
					return potentialParent;
				} else if ((strictMatch == false)
					&& (getPasteContainmentFeature(potentialParentObject) != null)) {
					return potentialParent;
				}
			}
		}
		return null;
	}

	/**
	 * Consults the clipboard support to get the best-match containment feature
	 * of the specified parent object to paste my child object into, according
	 * to the copied object's original containment feature.
	 * 
	 * @param parentEObject the parent to paste into
	 * @return the most appropriate containment feature for the child, or
	 *     <code>null</code> if the parent cannot contain the child at all
	 */
	public EReference getPasteContainmentFeature(EObject parentEObject) {
		return ClipboardSupportUtil.getPasteContainmentFeature(parentEObject,
			getEObject(), getContainmentFeature());
	}

	/**
	 * Handles the collision of an <code>eObject</code> that is to be pasted
	 * into the specified values of a reference, where it collides with one or
	 * more of these existing elements.  This may involve, among other things,
	 * renaming the object to be pasted in order to make its name unique.
	 * 
	 * @param reference the many containment reference into which we want to
	 *     paste the <code>eObject</code>
	 * @param list the current value (list of {@link EObject}s) of the
	 *     containment reference
	 * @param eObject the object that we want to paste, which collides with one
	 *     or more elements in the <code>list</code>
	 * @param eObjectInfo the <code>eObject</code>'s object info meta-data
	 * 
	 * @return <code>true</code> if the collision was resolved so that we
	 *     can go ahead and paste the <code>eObject</code> as intended;
	 *     false, otherwise
	 */
	protected boolean handleCollision(EReference reference, List list,
		EObject eObject, ObjectInfo eObjectInfo) {

		PasteAction pasteCollisionAction = (eObjectInfo.objCopyType
			.equals(ObjectCopyType.OBJ_COPY_TYPE_ALWAYS)) ? PasteAction.CLONE
			: getClipboardOperationHelper().getPasteCollisionAction(
				eObject.eClass());

		if (pasteCollisionAction == PasteAction.DISCARD) {
			//Do not paste. Such elements are typically copied in order to find
			// an appropriate parent
			return false;
		}

		if (list.isEmpty()) {
			return true;
		}

		EObject object = null;
		Iterator it = list.iterator();
		while (it.hasNext()) {
			object = (EObject) it.next();
			if (ClipboardSupportUtil.hasNameCollision(object, eObject)) {
				if (pasteCollisionAction.equals(PasteAction.ADD)) {
					//Create new element with different name
					ClipboardSupportUtil.rename(list, eObject, COPY);
					return true; //insert child
				} else if (pasteCollisionAction.equals(PasteAction.REPLACE)) {
					if (canBeReplaced(object)) {
						//Remove collision element, if any. Create new element
						// in the same location.
						if (reference == null) {
							// paste target is the resouce
							ClipboardSupportUtil.destroyEObjectInResource(object);
						} else {
							ClipboardSupportUtil.destroyEObjectInCollection(object
								.eContainer(), reference, object);
						}
						return true;
					}
					return false; //ignore it since we can't replace the other
				} else if (pasteCollisionAction.equals(PasteAction.IGNORE)) {
					//Leave existing element, if found. Otherwise create new
					// element.
					return false;
				} else if (pasteCollisionAction.equals(PasteAction.MERGE)) {
					mergeEObjects(eObjectInfo
						.hasHint(ClipboardUtil.MERGE_HINT_WEAK), object,
						eObject, eObjectInfo);
					
					// record the existing object that we collided with as the
					//    pasted element, so that we will know that the logical
					//    paste operation succeeded
					setPastedElement(object);
					return false; //don't insert child since we merged it
				} else if (pasteCollisionAction.equals(PasteAction.CLONE)) {
					//Always copy, even if indirectly selected.
					//Y.L. treat it as add???
					ClipboardSupportUtil.rename(list, eObject, COPY);
					return true; //insert child
				}
			} //hasNameCollision
		} //while
		return true; //insert child
	}

	/**
	 * Handles the collision of an <code>eObject</code> that is to be pasted
	 * into the specified scalar reference, where it collides with the
	 * existing element.
	 * 
	 * @param reference the scalar containment reference into which we want to
	 *     paste the <code>eObject</code>
	 * @param object the current value of the containment reference
	 * @param eObject the object that we want to paste, which collides with one
	 *     or more elements in the <code>list</code>
	 * @param eObjectInfo the <code>eObject</code>'s object info meta-data
	 * 
	 * @return <code>true</code> if the collision was resolved so that we
	 *     can go ahead and paste the <code>eObject</code> as intended;
	 *     false, otherwise
	 */
	protected boolean handleCollision(EReference reference, EObject object,
		EObject eObject, ObjectInfo eObjectInfo) {

		PasteAction pasteCollisionAction = (eObjectInfo.objCopyType
			.equals(ObjectCopyType.OBJ_COPY_TYPE_ALWAYS)) ? PasteAction.CLONE
			: getClipboardOperationHelper().getPasteCollisionAction(
				eObject.eClass());

		if (pasteCollisionAction.equals(PasteAction.DISCARD)) {
			//Do not paste. Such elements are typically copied in order to find
			// an appropriate parent
			return false;
		}

		if (object == null) {
			return true;
		}

		if (pasteCollisionAction.equals(PasteAction.ADD)) {
			if (canBeReplaced(object)) {
				//Create new element with different name
				//treat as Replace, since it is a single ref.???
				ClipboardSupportUtil.destroyEObject(object.eContainer(), reference);
				return true;
			}
			return false;
		} else if (pasteCollisionAction.equals(PasteAction.REPLACE)) {
			if (canBeReplaced(object)) {
				//Remove collision element, if any. Create new element in the
				// same location.
				ClipboardSupportUtil.destroyEObject(object.eContainer(), reference);
				return true;
			}
			return false;
		} else if (pasteCollisionAction.equals(PasteAction.IGNORE)) {
			//Leave existing element, if found. Otherwise create new element.
			return false;
		} else if (pasteCollisionAction.equals(PasteAction.MERGE)) {
			mergeEObjects(eObjectInfo.hasHint(ClipboardUtil.MERGE_HINT_WEAK),
				object, eObject, eObjectInfo);
			
			// record the existing object that we collided with as the
			//    pasted element, so that we will know that the logical
			//    paste operation succeeded
			setPastedElement(object);
			return false; //don't insert child since we merged it
		} else if (pasteCollisionAction.equals(PasteAction.CLONE)) {
			if (canBeReplaced(object)) {
				//Always copy, even if indirectly selected.
				//treat as Replace???
				ClipboardSupportUtil.destroyEObject(object.eContainer(), reference);
				return true;
			}
			return false;
		}
		return true; //insert child
	}

	/**
	 * Merges the elements to be pasted into a many containment reference with
	 * those objects already in that reference with which they collide.  This
	 * is used in the resolution of
	 * {@linkplain #handleCollision(EReference, List, EObject, ObjectInfo) collisions}
	 * by {@linkplain PasteAction#MERGE merging}.
	 * 
	 * @param reference the many containment reference to merge objects into
	 * @param targetObjectList the existing objects in the reference collection
	 * @param objectList the objects that we need to merge into the targets
	 * @param objectInfo object info
	 * 
	 * @return the merged lists
	 * 
	 * @see #handleCollision(EReference, List, EObject, ObjectInfo)
	 * @see PasteAction#MERGE
	 */
	protected List mergeLists(EReference reference, List targetObjectList,
		List objectList, ObjectInfo objectInfo) {
		//we did this because the original objectList is unmodifiable
		List mergedList = new ArrayList();
		mergedList.addAll(targetObjectList);
		//Sanity: no point to merge a list into itself
		if (targetObjectList.equals(objectList)) {
			return mergedList;
		}
		EObject eObject = null;
		Iterator childIt = objectList.iterator();
		while (childIt.hasNext()) {
			eObject = (EObject) childIt.next();
			if (handleCollision(reference, mergedList, eObject, objectInfo)) {
				mergedList.add(eObject);
			}
		}
		return mergedList;
	}

	/**
	 * Merges an elements to be pasted with an existing element that collides.
	 * 
	 * @param weakMerge <code>true</code> to perform a
	 *     {@linkplain ClipboardUtil#MERGE_HINT_WEAK weak merge};
	 *     <code>false</code> for a
	 *     {@linkplain ClipboardUtil#MERGE_HINT_STRONG strong merge}
	 * @param targetEObject the existing object to merge into
	 * @param eObject the object that we need to merge into the target
	 * @param objectInfo the <code>eObject</code>'s object info
	 * 
	 * @see #handleCollision(EReference, List, EObject, ObjectInfo)
	 * @see #handleCollision(EReference, EObject, EObject, ObjectInfo)
	 * @see PasteAction#MERGE
	 */
	protected void mergeEObjects(boolean weakMerge, EObject targetEObject,
		EObject eObject, ObjectInfo objectInfo) {
		//Sanity: no point to merge an object into itself
		if (targetEObject.equals(eObject)) {
			return;
		}

		MergedEObjectInfo info = (MergedEObjectInfo) getAllMergedElementsMap()
			.get(eObject);
		//if it has been merged in the very same target, then just return
		if ((info != null) && (info.targetEObjects.contains(targetEObject))) {
			return;
		}

		//no record at all, then create new one
		if (info == null) {
			info = new MergedEObjectInfo();
			info.mergedEObject = eObject;
			info.mergedEObjectID = getLoadedEObjectID(eObject);
			addMergedElementEntry(eObject, info);
		}

		//In the Clipboard Design document this is how it defines Merge types:
		//Weak merges: preserve scalar data in the target element's slots. Only
		// element vector slots are merged.
		//Strong merges: overwrite scalar data in the target element's slots.
		// Element vector slots are also merged.
		//Our interpretation is that scalar == attributes, whereas vector ==
		// references.

		//keep track of what we merged, we need this to resolve refs at the
		// post-paste.
		info.targetEObjects.add(targetEObject);

		//handle refs first
		Iterator it = eObject.eClass().getEAllReferences().iterator();
		EReference reference = null;
		while (it.hasNext()) {
			reference = (EReference) it.next();
			if (reference.isChangeable()) {
				Object unresolvedEObjectValue = eObject.eGet(reference, false);
				if (FeatureMapUtil.isMany(eObject, reference)) {
					List childList = (List) unresolvedEObjectValue;
					if (childList.isEmpty() == false) {
						List targetObjectList = (List) targetEObject.eGet(
							reference, true);
						List mergedList = mergeLists(reference,
							targetObjectList, childList, objectInfo);
						
						// CWD: Don't remove the original -- we're merging!
						// mergedList.removeAll(targetObjectList);
						
						ClipboardSupportUtil.setEObjectList(
							targetEObject, reference, mergedList);
					}
				} else if (unresolvedEObjectValue != null) {
					EObject targetObjectValue = (EObject) targetEObject.eGet(
						reference, true);
					if (handleCollision(reference, targetObjectValue,
						(EObject) unresolvedEObjectValue, objectInfo)) {
						ClipboardSupportUtil.setEObject(
							targetEObject, reference,
							(EObject) unresolvedEObjectValue);
					}
				}
			} //reference.isChangeable()
		} //while

		//now handle attribs if it is a strong merge (default)
		if (weakMerge == false) {
			it = eObject.eClass().getEAllAttributes().iterator();
			EAttribute attribute = null;
			while (it.hasNext()) {
				attribute = (EAttribute) it.next();
				ClipboardSupportUtil.setEAttribute(targetEObject, attribute,
					eObject.eGet(attribute));
			}
		}
	}

	/**
	 * Gets the object info meta-data for the object that I am pasting.
	 * 
	 * @return my child object's meta-data
	 */
	protected ObjectInfo getChildObjectInfo() {
		return childObjectInfo;
	}

	/**
	 * Gets the child paste operation that I am overriding or extending, if I am
	 * an {@linkplain #isAuxiliaryOperation() auxiliary} paste operation.
	 * 
	 * @return my main child paste process, or <code>null</code> if none
	 */
	protected PasteChildOperation getMainChildPasteProcess() {
		return mainChildPasteProcess;
	}

	/**
	 * Queries whether I am an auxiliary operation.
	 * 
	 * @return <code>true</code> if I am an auxiliary paste operation;
	 *      <code>false</code>, otherwise
	 */
	public boolean isAuxiliaryOperation() {
		return (getMainChildPasteProcess() != null);
	}

	/**
	 * Gets the object meta-data for my copy object's parent, if it was
	 * serialized along with the child.
	 * 
	 * @return my copy parent's object info, or <code>null</code> if none
	 */
	protected ObjectInfo getCopyParentObjectInfo() {
		if (copyParentObjectInfo == null) {
			copyParentObjectInfo = (ObjectInfo) getResourceInfo().objects
				.get(getChildObjectInfo().copyParentId);
		}
		return copyParentObjectInfo;
	}

	/**
	 * Queries whether my copy object's parent object that was copied along with
	 * it was a direct container or not.
	 * 
	 * @return <code>true</code> if my copy object's parent was copied and was
	 *    its direct container; <code>false</code>, otherwise
	 */
	protected boolean isCopyParentDirectParent() {
		return getChildObjectInfo().containerId
			.equals(getCopyParentObjectInfo().objId);
	}

	/**
	 * After pasting has completed, records the element that I have successfully
	 * (or not) pasted from the original copy.
	 * 
	 * @param pastedElement the pasted element, or <code>null</code> if pasting
	 *     failed
	 */
	protected void setPastedElement(EObject pastedElement) {
		this.pastedElement = pastedElement;
	}

	/**
	 * Queries whether the specified object that already exists in the target
	 * resource can be replaced by an element being pasted, in case of a
	 * collision that is resolved by
	 * {@linkplain PasteAction#REPLACE replacement}.
	 * 
	 * @param eObject an object in the target model that might be replaced
	 * @return <code>true</code> if it can be replaced;
	 *      <code>false</code>, otherwise
	 * 
	 * @see PasteAction#REPLACE
	 */
	protected boolean canBeReplaced(EObject eObject) {
		if (!getParentTarget().isResource()) {
			// we now know that the target is an EObject
			if (eObject.equals(getParentEObject())) {
				return false;
			}
			if (ClipboardSupportUtil.isChild(eObject, getParentEObject())) {
				return false;
			}
		}
		return true;
	}

}