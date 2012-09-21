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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.emf.clipboard.core.BasePasteOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteTarget;

/**
 * The default paste operation.  Extensibility is provided by the callback
 * methods of the {@link IClipboardSupport} implementation for the specific
 * EMF metamodel.
 * <p>
 * <b>Note</b> that this class is not intended to be extended
 * by clients.  Clients may not instantiate it.
 * </p>
 * 
 * @see org.eclipse.gmf.runtime.emf.clipboard.core.OverrideCopyOperation
 * 
 * @author Yasser Lulu
 */
public class PasteOperation
	extends BasePasteOperation {

	private Map parentPasteRecordMap;

	private PasteTarget parent;

	private Map hintsMap;

	/**
	 * Initializes me.
	 * 
	 * @param monitor an optional monitor to track paste progress
	 * @param clipboardSupport the clipboard support object governing this
	 *     copy/paste operation
	 * @param string the string obtained from the system clipboard, that
	 *     contains the serial form of the copied objects that are to be
	 *     pasted
	 * @param parent the target object into which the copied elements are to
	 *     be pasted.  This object will be their "parent"
	 * @param loadOptionsMap map of EMF resource load options for
	 *     deserialization of the resource that was copied to the clipboard
	 * @param hintsMap the map of copy hints, possibly empty.  Hints are defined
	 *     by the {@link org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil} class
	 * 
	 * @throws Exception if anything goes wrong in initializing the paste
	 *     operation
	 * 
	 * @see org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil#MERGE_HINT_WEAK
	 * @see org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardUtil#MERGE_HINT_STRONG
	 */
	public PasteOperation(IProgressMonitor monitor,
			IClipboardSupport clipboardSupport, String string,
			PasteTarget parent, Map loadOptionsMap, Map hintsMap)
		throws Exception {
		super(monitor, loadOptionsMap, ResourceInfoProcessor
			.getResourceInfo(string), clipboardSupport);
		this.hintsMap = (hintsMap == null) ? Collections.EMPTY_MAP
			: hintsMap;
		parentPasteRecordMap = new HashMap();
		this.parent = parent;
	}

	private final PasteIntoParentOperation getParentPasteProcess(
			PasteTarget parentElement)
		throws Exception {
		PasteIntoParentOperation parentPasteProcess = (PasteIntoParentOperation) parentPasteRecordMap
			.get(parentElement);
		if (parentPasteProcess == null) {
			
			IClipboardSupport helper = getClipboardOperationHelper();
			if (helper instanceof IClipboardSupport2
					&& ((IClipboardSupport2) helper)
							.shouldOverridePasteIntoParentOperation(
									parentElement, getHintsMap())) {
				parentPasteProcess = ((IClipboardSupport2) helper)
						.getPasteIntoParentOperation(this, parentElement,
								getHintsMap());
			} 
			
			if (parentPasteProcess == null) {
				parentPasteProcess = new PasteIntoParentOperation(this,
						parentElement, getHintsMap());
			}
			parentPasteRecordMap.put(parentElement, parentPasteProcess);
		}
		return parentPasteProcess;
	}

	public void paste()
		throws Exception {
		getProgressMonitor().worked(WORK_UNIT);
		if (isCancelled()) {
			throwCancelException();
		}
		PasteIntoParentOperation parentPasteProcess = getParentPasteProcess(parent);
		if (isCancelled()) {
			throwCancelException();
		}
		parentPasteProcess.paste();
		if (getCriticalResolveFailuresSet().isEmpty() == false) {
			throwException(PASTE, new IllegalStateException(
				"Critical Resolve Failure While Pasting")); //$NON-NLS-1$
		}
	}

	public BasePasteOperation getSpawningPasteOperation() {
		//for emphasis only
		return null;
	}

	/**
	 * Obtains the paste hints with which I was initialized.
	 * 
	 * @return my hints
	 */
	public Map getHintsMap() {
		return hintsMap;
	}

}