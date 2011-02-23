/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.statechart.diagram.DiagramActivator;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class PreferenceInitializer extends DiagramPreferenceInitializer implements StatechartColorConstants{

	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();
		//Custom Colors
		PreferenceConverter.setDefault(getPreferenceStore(),
				PreferenceConstants.STATE_COLOR, state_color.getRGB());
		PreferenceConverter.setDefault(getPreferenceStore(),
				PreferenceConstants.REGION_COLOR, region_color.getRGB());
		
		//Line colors
		Color lineColor = DiagramColorConstants.black;
		PreferenceConverter.setDefault(getPreferenceStore(),
				IPreferenceConstants.PREF_LINE_COLOR, lineColor.getRGB());
	}

	@Override
	protected IPreferenceStore getPreferenceStore() {
		return DiagramActivator.getDefault().getPreferenceStore();
	}

}
