/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class RegionEditHelper extends AbstractEditHelper {
	@Override
	protected ICommand getBasicDestroyElementCommand(final DestroyElementRequest req) {
		// Deletion is only allowed if subdiagrams are not opened in another
		// editor
		return new DestroyElementCommand(req) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if (getElementToDestroy() instanceof State && getElementToDestroy().eResource() != null) {
					boolean success = DiagramPartitioningUtil.closeSubdiagramEditors((State) getElementToDestroy());
					if (success)
						return super.doExecute(monitor, info);
					else
						return Status.CANCEL_STATUS;
				}
				return super.doExecute(monitor, info);
			}
		};
	}
}
