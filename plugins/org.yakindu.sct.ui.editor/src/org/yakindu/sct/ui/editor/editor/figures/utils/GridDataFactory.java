/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor.figures.utils;

import org.eclipse.draw2d.GridData;

/**
 * 
 * @author muelder
 *
 */
public class GridDataFactory {

	private final GridData data;

	private GridDataFactory() {
		data = new GridData();
	}

	/**
	 * Creates a GridDataFactory initialized with defaults. Initial values are:
	 * 
	 * align(SWT.FILL, SWT.FILL) exclude(false) grab(false, false) span(1,1)
	 */
	public static GridDataFactory fillDefaults() {
		return new GridDataFactory().fillDefaultsInternal();
	}

	private GridDataFactory fillDefaultsInternal() {
		align(GridData.FILL, GridData.FILL);
		grab(false, false);
		span(1, 1);
		data.horizontalIndent = 1;
		return this;
	}

	public GridDataFactory span(int horizontalSpan, int verticalSpan) {
		data.horizontalSpan = horizontalSpan;
		data.verticalSpan = verticalSpan;
		return this;
	}

	public GridDataFactory align(int verticalAlignment, int horizontalAlignment) {
		data.verticalAlignment = verticalAlignment;
		data.horizontalAlignment = horizontalAlignment;
		return this;
	}

	public GridDataFactory grab(boolean horizontal, boolean vertical) {
		data.grabExcessHorizontalSpace = horizontal;
		data.grabExcessVerticalSpace = vertical;
		return this;
	}

	public GridData getData() {
		return data;
	}

}
