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

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract definition of an
 * {@link org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport}-defined
 * operation that follows the pasting of a child element into the target parent,
 * to perform additional work.  Post paste operations are created by
 * the {@link PasteChildOperation#getPostPasteOperation() getPostPasteOperation()}
 * method of {@link OverridePasteChildOperation}s.
 * <p>
 * This class is intended to be extended by clients, to provide an auxiliary
 * paste operation in the clipboard support.
 * </p>
 * 
 * @see IClipboardSupport#getOverrideChildPasteOperation(PasteChildOperation)
 * @see PasteChildOperation#getPostPasteOperation()
 * 
 * @author Yasser Lulu
 */
public class PostPasteChildOperation
	extends PasteChildOperation {

	private PasteChildOperation pasteChildOperation;

	private PasteChildOperation[] pasteOperations;

	/**
	 * Initializes me with the paste operation that I am following.  I may
	 * wish to access it later, to get its results.
	 * 
	 * @param pasteChildOperation the paste child operation that I follow
	 * @param pasteOperations paste operations to execute.  By default, I
	 *     will execute all of these operations first, then all of their
	 *     post-paste operations (after all of the pastes have completed)
	 */
	public PostPasteChildOperation(PasteChildOperation pasteChildOperation,
		List pasteOperations) {
		this(pasteChildOperation, (PasteChildOperation[]) pasteOperations
			.toArray(EMPTY_ARRAY));
	}

	/**
	 * Creates an empty operation to follow the specified paste operation.
	 * 
	 * @param pasteChildOperation a paste operation
	 * @return a post-paste operation that does nothing
	 */
	public static PostPasteChildOperation makeNullPostPasteChildOperation(
		PasteChildOperation pasteChildOperation) {
		return new PostPasteChildOperation(pasteChildOperation, EMPTY_ARRAY);
	}

	/**
	 * Initializes me with the paste operation that I am following.  I may
	 * wish to access it later, to get its results.
	 * 
	 * @param pasteChildOperation the paste child operation that I follow
	 * @param pasteOperations paste operations to execute.  By default, I
	 *     will execute all of these operations first, then all of their
	 *     post-paste operations (after all of the pastes have completed)
	 */
	public PostPasteChildOperation(PasteChildOperation pasteChildOperation,
		PasteChildOperation[] pasteOperations) {
		super(pasteChildOperation);
		this.pasteChildOperation = pasteChildOperation;
		this.pasteOperations = pasteOperations;
	}

	/**
	 * Invoked after the
	 * {@linkplain #getPasteChildOperation() past-child operation} that I am
	 * following has done its pasting, to do some more pasting.
	 * <p>
	 * By default, I just invoke the {@link PasteChildOperation#paste()} method
	 * on all of my {@linkplain #getPasteOperations() additional} paste
	 * operations.
	 * </p>
	 * 
	 * @see #getPasteOperations()
	 */
	public void paste() throws Exception {
		for (int i = 0; i < pasteOperations.length; ++i) {
			pasteOperations[i].paste();
		}
	}

	/**
	 * By default, returns another post-paste operation that executes the
	 * post-paste operations of all of my
	 * {@link #getPasteOperations() additional} paste operations.
	 * 
	 * @see #getPasteOperations()
	 */
	public PasteChildOperation getPostPasteOperation() {
		List list = getPostPasteOperations();
		if (list.isEmpty() == false) {
			return new PostPasteChildOperation(this,
				(PasteChildOperation[]) list.toArray(EMPTY_ARRAY));
		}
		return null;
	}

	/**
	 * Gathers the post-paste operations of the paste operations that I execute.
	 * These will all be executed in sequence, after I have executed all of the
	 * paste operations.
	 * 
	 * @return my paste operations' post-paste operations
	 */
	private List getPostPasteOperations() {
		if (pasteOperations.length > 0) {
			List list = new ArrayList();
			for (int i = 0; i < pasteOperations.length; ++i) {
				PasteChildOperation postPasteOperation = pasteOperations[i]
					.getPostPasteOperation();
				if (postPasteOperation != null) {
					list.add(postPasteOperation);
				}
			}
			return list;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Obtains the paste operation that I follow as a post-paste.
	 * 
	 * @return my paste operation
	 */
	protected PasteChildOperation getPasteChildOperation() {
		return pasteChildOperation;
	}

	/**
	 * Obtains the paste operations that I execute when I am executed.
	 * 
	 * @return my paste operations
	 */
	protected PasteChildOperation[] getPasteOperations() {
		return pasteOperations;
	}
}