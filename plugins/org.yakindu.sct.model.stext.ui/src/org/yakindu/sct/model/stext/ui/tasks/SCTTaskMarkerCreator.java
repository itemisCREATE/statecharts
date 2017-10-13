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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.ui.tasks.TaskMarkerCreator;
import org.yakindu.sct.model.stext.tasks.SCTTask;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTTaskMarkerCreator extends TaskMarkerCreator {

	public static final String SCT_TASK_TYPE = "org.yakindu.sct.ui.editor.task"; //$NON-NLS-1$
	public static final String SEMANTIC_ELEMENT_ID = org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID;
	
	@Override
	protected void setMarkerAttributes(Task task, IResource resource, IMarker marker) throws CoreException {
		super.setMarkerAttributes(task, resource, marker);
		if (task instanceof SCTTask) {
			marker.setAttribute(SEMANTIC_ELEMENT_ID, ((SCTTask) task).getSemanticURI());
		}
	}

}
