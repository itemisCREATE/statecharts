/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Muehlbrandt - initial API and implementation
 * 
 */
package org.yakindu.gmf.runtime.treelayout.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public final class CommandUtil {

	private CommandUtil() {
	}

	public static List<IFile> getAffectedFiles(ResourceSet resourceSet) {
		final List<IFile> affectedFiles = new ArrayList<IFile>();
		final TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(resourceSet);
		for (final Resource next : resourceSet.getResources()) {
			if (!domain.isReadOnly(next)) {
				final IFile file = WorkspaceSynchronizer
						.getUnderlyingFile(next);
				Assert.isNotNull(file, next.getURI() + "");
				affectedFiles.add(file);
			}
		}
		return affectedFiles;
	}
	
	public static IStatus executeUndoableOperation(IUndoableOperation undoableOperation)
			throws ExecutionException {
		IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		return history.execute(undoableOperation, new NullProgressMonitor(), null);
	}
}
