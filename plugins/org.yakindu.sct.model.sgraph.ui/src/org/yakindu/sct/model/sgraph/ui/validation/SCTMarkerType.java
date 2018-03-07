/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.model.sgraph.ui.validation;

/**
 * @author Johannes Dicks - initial contribution and API
 */
public interface SCTMarkerType {
	public final static String SUPERTYPE = "org.yakindu.sct.ui.editor.diagnostic"; //$NON-NLS-1$
	public final static String FAST_VALIDATION = "org.yakindu.sct.ui.editor.diagnostic.fast"; //$NON-NLS-1$
	public final static String NORMAL_VALIDATION = "org.yakindu.sct.ui.editor.diagnostic.normal"; //$NON-NLS-1$
	public final static String EXPENSIVE_VALIDATION = "org.yakindu.sct.ui.editor.diagnostic.expensive"; //$NON-NLS-1$
	public static final String SCT_TASK_TYPE = "org.yakindu.sct.ui.editor.task"; //$NON-NLS-1$

	public static final String SEMANTIC_ELEMENT_ID = org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID;
}
