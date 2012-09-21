/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.MergedEObjectInfo;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.ResourceInfo;


/**
 * Abstract specification of all paste operations, providing common behaviours
 * and enforcing certain protocols.
 * <p>
 * <b>Note</b> that this class is not intended to be extended "directly"
 * by clients.  Clients may not instantiate it.  Clients that need to extend
 * or override the default paste operation should extend the
 * {@link OverridePasteChildOperation} class, instead.  Clients may also extend
 * the {@link PostPasteChildOperation}.
 * </p>
 * 
 * @author Yasser Lulu
 * 
 * @see OverridePasteChildOperation
 * @see PostPasteChildOperation 
 */
public abstract class BasePasteOperation
	extends ClipboardOperation {

	/** A constant whose value is "paste". */
	public static final String PASTE = "paste"; //$NON-NLS-1$

	private Map loadOptionsMap;

	private ResourceInfo resourceInfo;

	private BasePasteOperation spawningPasteOperation;

	private Map mergedElementsMap;

	private Map unmodifiableMergedElementsMap;

	private Set pastedElementSet;

	private Set unmodifiablePastedElementSet;

	private Set criticalResolveFailuresSet;

	private Set unmodifiableCriticalResolveFailuresSet;

	private Set pasteFailuresObjectSet;

	private Set unmodifiablePasteFailuresObjectSet;

	/**
	 * Initializes me.
	 * 
	 * @param monitor an optional monitor to track paste progress
	 * @param loadOptionsMap map of EMF resource load options for
	 *     deserialization of the resource that was copied to the clipboard
	 * @param resourceInfo the resource information data structure to fill in
	 *     when deserializing the copied resource
	 * @param clipboardSupport the clipboard support object governing this
	 *     copy/paste operation
	 */
	public BasePasteOperation(IProgressMonitor monitor,
			Map loadOptionsMap, ResourceInfo resourceInfo,
			IClipboardSupport clipboardSupport) {
		super(monitor, clipboardSupport);
		this.loadOptionsMap = loadOptionsMap;
		this.resourceInfo = resourceInfo;
		mergedElementsMap = new HashMap();
		pastedElementSet = new HashSet();
		pasteFailuresObjectSet = new HashSet();
		criticalResolveFailuresSet = new HashSet();
	}

	/**
	 * Initializes me with a superordinate paste operation that has created me.
	 * I copy much of my environment from it.
	 * 
	 * @param spawningPasteOperation the paste operation that created me
	 */
	public BasePasteOperation(BasePasteOperation spawningPasteOperation) {
		this(spawningPasteOperation.getProgressMonitor(),
			spawningPasteOperation.getLoadOptionsMap(), spawningPasteOperation
				.getResourceInfo(), spawningPasteOperation
				.getClipboardOperationHelper());
		this.spawningPasteOperation = spawningPasteOperation;
	}

	/**
	 * Obtains my resource meta-data structure.
	 * 
	 * @return my resource meta-data
	 */
	protected final ResourceInfo getResourceInfo() {
		return resourceInfo;
	}

	/**
	 * Obtains the EMF resource load options that are used to deserialize the
	 * resource that was copied to the clipboard.
	 * 
	 * @return my load options
	 */
	protected final Map getLoadOptionsMap() {
		return loadOptionsMap;
	}

	/**
	 * Performs the paste operation.
	 * 
	 * @throws Exception if anything goes wrong in pasting
	 */
	public abstract void paste()
		throws Exception;

	/**
	 * Obtains the superordinate paste operation that created me, if any.
	 * 
	 * @return my parent paste operation, or <code>null</code> if I am the
	 *     root operation
	 */
	public BasePasteOperation getSpawningPasteOperation() {
		return spawningPasteOperation;
	}

	/**
	 * Obtains the overall set of all critical resolution failures for the
	 * bigger paste operation, of which my own are a subset.
	 * 
	 * @return the set of all critical resolution failures
	 * 
	 * @see #getCriticalResolveFailuresSet()
	 */
	public final Set getAllCriticalResolveFailuresSet() {
		if (getSpawningPasteOperation() != null) {
			return getSpawningPasteOperation()
				.getAllCriticalResolveFailuresSet();
		} else {
			return getCriticalResolveFailuresSet();
		}
	}

	/**
	 * Obtains the overall map of all merged elements for the
	 * bigger paste operation, of which my own are a subset.
	 * 
	 * @return the map of all merged elements
	 * 
	 * @see #getMergedElementsMap()
	 */
	public final Map getAllMergedElementsMap() {
		if (getSpawningPasteOperation() != null) {
			return getSpawningPasteOperation().getAllMergedElementsMap();
		} else {
			return getMergedElementsMap();
		}
	}

	/**
	 * Obtains the overall set of all elements pasted by the
	 * bigger paste operation, of which my own are a subset.
	 * 
	 * @return the set of all pasted elements
	 * 
	 * @see #getPastedElementSet()
	 */
	public final Set getAllPastedElementSet() {
		if (getSpawningPasteOperation() != null) {
			return getSpawningPasteOperation().getAllPastedElementSet();
		} else {
			return getPastedElementSet();
		}
	}

	/**
	 * Obtains my own subset of critical resolution failures.
	 * 
	 * @return my critical resolution failures
	 * 
	 * @see #getAllCriticalResolveFailuresSet()
	 */
	public final Set getCriticalResolveFailuresSet() {
		if (unmodifiableCriticalResolveFailuresSet == null) {
			unmodifiableCriticalResolveFailuresSet = Collections
				.unmodifiableSet(criticalResolveFailuresSet);
		}
		return unmodifiableCriticalResolveFailuresSet;
	}

	/**
	 * Adds a critical resolution failure to my set and the overall failures set
	 * for the bigger paste operation.
	 * 
	 * @param nonResolvedObject an unresolvable object
	 */
	protected void addCriticalResolveFailure(EObject nonResolvedObject) {
		criticalResolveFailuresSet.add(nonResolvedObject);
		if (getSpawningPasteOperation() != null) {
			getSpawningPasteOperation().addCriticalResolveFailure(
				nonResolvedObject);
		}
	}

	/**
	 * Removes a critical resolution failure from my set and the overall
	 * failures set for the bigger paste operation, for an object which has
	 * turned out resolvable after all.
	 * 
	 * @param newlyResolvedObject an object that did resolve
	 */
	protected void removeCriticalResolveFailure(EObject newlyResolvedObject) {
		if (criticalResolveFailuresSet.remove(newlyResolvedObject)
			&& getSpawningPasteOperation() != null) {
			getSpawningPasteOperation().removeCriticalResolveFailure(
				newlyResolvedObject);
		}
	}

	/**
	 * Obtains my own subset map of merged elements.
	 * 
	 * @return my merged elements
	 * 
	 * @see #getMergedElementsMap()
	 */
	public final Map getMergedElementsMap() {
		if (unmodifiableMergedElementsMap == null) {
			unmodifiableMergedElementsMap = Collections
				.unmodifiableMap(mergedElementsMap);
		}
		return unmodifiableMergedElementsMap;
	}

	/**
	 * Adds a merged element to my map and the overall merges map
	 * for the bigger paste operation.
	 * 
	 * @param mergedObject a merged object (key)
	 * @param mergedEObjectInfo the information about the merge (value)
	 */
	protected void addMergedElementEntry(EObject mergedObject,
			MergedEObjectInfo mergedEObjectInfo) {
		mergedElementsMap.put(mergedObject, mergedEObjectInfo);
		if (getSpawningPasteOperation() != null) {
			getSpawningPasteOperation().addMergedElementEntry(mergedObject,
				mergedEObjectInfo);
		}
	}

	/**
	 * Obtains my own subset of pasted elements.
	 * 
	 * @return my pasted elements
	 * 
	 * @see #getAllPastedElementSet()
	 */
	public final Set getPastedElementSet() {
		if (unmodifiablePastedElementSet == null) {
			unmodifiablePastedElementSet = Collections
				.unmodifiableSet(pastedElementSet);
		}
		return unmodifiablePastedElementSet;
	}

	/**
	 * Adds a successfully pasted element to my set and the overall pasted
	 * elements set for the bigger paste operation.
	 * 
	 * @param pastedElement an element that was successfully pasted
	 */
	protected void addPastedElement(EObject pastedElement) {
		pastedElementSet.add(pastedElement);
		if (getSpawningPasteOperation() != null) {
			getSpawningPasteOperation().addPastedElement(pastedElement);
		}
	}

	/**
	 * Obtains my own subset of objects that failed to paste.
	 * 
	 * @return my failed pastes
	 * 
	 * @see #getAllPasteFailuresObjectSet()
	 */
	public final Set getPasteFailuresObjectSet() {
		if (unmodifiablePasteFailuresObjectSet == null) {
			unmodifiablePasteFailuresObjectSet = Collections
				.unmodifiableSet(pasteFailuresObjectSet);
		}
		return unmodifiablePasteFailuresObjectSet;
	}

	/**
	 * Adds an element that did not successfully paste to my set and the
	 * overall paste failures set for the bigger paste operation.
	 * 
	 * @param eObject an element that was not successfully pasted
	 */
	protected void addPasteFailuresObject(EObject eObject) {
		pasteFailuresObjectSet.add(eObject);
		if (getSpawningPasteOperation() != null) {
			getSpawningPasteOperation().addPasteFailuresObject(eObject);
		}
	}

	/**
	 * Obtains my {@linkplain #getPasteFailuresObjectSet() failed pastes},
	 * or my parent operation's if I have one.
	 * 
	 * @return my parent's paste failures, or my own if I am the
	 *     root paste operation
	 * 
	 * @see #getPasteFailuresObjectSet()
	 */
	public final Set getAllPasteFailuresObjectSet() {
		if (getSpawningPasteOperation() != null) {
			return getSpawningPasteOperation().getAllPasteFailuresObjectSet();
		} else {
			return getPasteFailuresObjectSet();
		}
	}

	/**
	 * Throws an operation cancel exception to end a paste process.     
	 */
	protected void throwCancelException() {
		throwCancelException(PASTE);
	}

}