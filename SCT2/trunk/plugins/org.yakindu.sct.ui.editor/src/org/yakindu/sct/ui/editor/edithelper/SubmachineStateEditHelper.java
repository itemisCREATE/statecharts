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
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.dialogs.SelectSubmachineDialog;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubmachineStateEditHelper extends VertexEditHelper {

	/**
	 * Prompts the user to select the submachine resource
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		SelectSubmachineDialog dialog = new SelectSubmachineDialog(new Shell());
		if (Dialog.OK == dialog.open()) {
			Statechart selectedSubmachine = dialog.getSelectedSubmachine();
			if (selectedSubmachine != null) {
				return new SetValueCommand(new SetRequest(
						req.getElementToConfigure(),
						SGraphPackage.Literals.SUBMACHINE_STATE__SUBSTATECHART,
						selectedSubmachine));
			}
		}
		return null;
	}
}
