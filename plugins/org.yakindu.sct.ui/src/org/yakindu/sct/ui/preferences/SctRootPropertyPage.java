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
package org.yakindu.sct.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;

/**
 * 
 * @author johannes dicks - Initial contribution and API
 * 
 */
public class SctRootPropertyPage extends PropertyPage {

	private SctRootPageContent yakinduRootPageContent;

	public SctRootPropertyPage() {
		super();
		yakinduRootPageContent = new SctRootPageContent();
	}

	@Override
	protected Control createContents(Composite parent) {
		yakinduRootPageContent.createContents(parent);
		return parent;
	}

	@Override
	public void createControl(Composite parent) {
		setControl(yakinduRootPageContent.createControl(parent));
	}

	protected void performDefaults() {
		super.performDefaults();
	}
	
	public boolean performOk() {
		return true;
	}

}