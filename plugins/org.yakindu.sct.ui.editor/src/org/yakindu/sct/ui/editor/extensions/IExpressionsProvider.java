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
package org.yakindu.sct.ui.editor.extensions;

import org.eclipse.swt.SWT;

import com.google.inject.Injector;

/**
 * @author andreas muelder
 * 
 */
public interface IExpressionsProvider extends ISCTProvider {

	String EXPRESSIONS_EXTENSION = "org.yakindu.sct.ui.editor.expressions";

	public Injector getInjector();

	/**
	 * @return the {@link SWT} styles for the CellEditor
	 */
	public int getStyle();
}
