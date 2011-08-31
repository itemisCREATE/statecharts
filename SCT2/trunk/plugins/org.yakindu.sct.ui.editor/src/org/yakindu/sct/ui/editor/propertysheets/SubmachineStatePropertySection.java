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
package org.yakindu.sct.ui.editor.propertysheets;

import java.util.List;

import org.yakindu.sct.model.sgraph.SGraphPackage;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public class SubmachineStatePropertySection extends StatePropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		super.createPropertyDescriptors(descriptors);

		// Submachine reference
		TextDialogPropertyDescriptor submachineDescriptor = new TextDialogPropertyDescriptor(
				SGraphPackage.Literals.SUBMACHINE_STATE__SUBSTATECHART,
				"Submachine:");
		descriptors.add(submachineDescriptor);
	}

}
