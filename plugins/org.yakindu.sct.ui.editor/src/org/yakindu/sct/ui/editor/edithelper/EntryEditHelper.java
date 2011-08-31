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
package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editor.StatechartElementTypes;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EntryEditHelper extends VertexEditHelper {

	/**
	 * Set the right {@link EntryKind} for the given {@link ElementType}
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (StatechartElementTypes.SHALLOWHISTORY.equals(req
				.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					SGraphPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.SHALLOW_HISTORY));
		} else if (StatechartElementTypes.DEEPHISTORY.equals(req
				.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					SGraphPackage.eINSTANCE.getEntry_Kind(),
					EntryKind.DEEP_HISTORY));
		} else if (StatechartElementTypes.ENTRY
				.equals(req.getTypeToConfigure())) {
			return new SetValueCommand(new SetRequest(
					req.getElementToConfigure(),
					SGraphPackage.eINSTANCE.getEntry_Kind(), EntryKind.INITIAL));
		}
		return super.getConfigureCommand(req);
	}
}
