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
package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
/**
 * @author holger willebrandt - Initial contribution and API
 */
public abstract class IProjectWizardPage extends WizardPage {

	protected IProjectWizardPage(String pageName) {
		super(pageName);
	}

	protected abstract ProjectData getProjectData();
}
