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
package org.yakindu.sct.ui.editor.pictogram;

import org.eclipse.core.commands.ExecutionEvent;
import org.yakindu.sct.model.sgraph.SubmachineState;
import org.yakindu.sct.ui.editor.StatechartImages;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubchartPictogram extends Pictogram {

	public SubchartPictogram() {
		super("Open Substatechart in new Editor",
				StatechartImages.SUB_STATECHART_PICTOGRAM.image(),
				new OpenSubstatechartHandler(),
				getHandlerExecutionContextValidator());
	}

	private static IHandlerContextValidator getHandlerExecutionContextValidator() {
		return new IHandlerContextValidator() {
			public boolean isValidContext(ExecutionEvent event) {
				SubmachineState selectedState = OpenSubstatechartHandler
						.getSelectedSubmachineState(event);
				if (selectedState.getSubstatechart() == null)
					return false;
				return true;
			}
		};
	}
}
