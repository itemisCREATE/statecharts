/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.ui.wizards.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.yakindu.sct.examples.ui.ExampleActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExamplesPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		String property = System.getProperty("user.home");
		getPreferenceStore().setDefault(ExamplesPreferenceConstants.STORAGE_LOCATION, property);
	}

	protected IPreferenceStore getPreferenceStore() {
		return ExampleActivator.getDefault().getPreferenceStore();
	}

}
