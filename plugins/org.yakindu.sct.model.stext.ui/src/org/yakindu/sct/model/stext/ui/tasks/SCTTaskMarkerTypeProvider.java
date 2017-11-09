/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui.tasks;

import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTTaskMarkerTypeProvider extends TaskMarkerTypeProvider {

	public static final String SCT_TASK_TYPE = "org.yakindu.sct.ui.editor.task"; //$NON-NLS-1$
	
	public String getMarkerType(Task task) {
		return SCT_TASK_TYPE;
	}

}
