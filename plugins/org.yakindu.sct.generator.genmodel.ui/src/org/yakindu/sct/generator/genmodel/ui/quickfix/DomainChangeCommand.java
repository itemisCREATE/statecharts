/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.quickfix;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author robin herrmann - Initial contribution
 * 
 */
public class DomainChangeCommand extends AbstractTransactionalCommand {

	private String validDomain;
	private Statechart referencedStatechart;

	public DomainChangeCommand(TransactionalEditingDomain domain, String label, List<?> affectedFiles,
			String validDomain, Statechart referencedStatechart) {
		super(domain, label, affectedFiles);
		this.validDomain = validDomain;
		this.referencedStatechart = referencedStatechart;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			Statechart statechart = (Statechart) DiagramPartitioningUtil.getSharedDomain().getResourceSet()
					.getEObject(EcoreUtil.getURI(referencedStatechart), true);
			(statechart).setDomainID(validDomain);
		} catch (Exception ex) {
			return CommandResult.newErrorCommandResult(ex);
		}
		return CommandResult.newOKCommandResult();
	}
}
